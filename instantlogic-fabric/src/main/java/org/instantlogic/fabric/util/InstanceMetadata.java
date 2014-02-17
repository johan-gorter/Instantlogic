package org.instantlogic.fabric.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.text.TextTemplate;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;
import org.instantlogic.fabric.value.RelationValue;
import org.instantlogic.fabric.value.RelationValueList;
import org.instantlogic.fabric.value.RelationValues;
import org.instantlogic.fabric.value.ValueList;
import org.instantlogic.fabric.value.Values;
import org.instantlogic.fabric.value.WriteableAttributeValue;

public class InstanceMetadata {

	private final Instance instance;
	private final Entity<? extends Instance> entity;
	private String uniqueId;
	private Instance owner = null;
	@SuppressWarnings("rawtypes")
	private WriteableAttributeValue ownerRelationValue;
	private List<GlobalValueChangeListener> globalValueChangeListeners = new ArrayList<GlobalValueChangeListener>();
	// When this value is the same as globalValueChangeListeners, copy globalValueChangeListeners on write and clear this field.
	private List<GlobalValueChangeListener> iteratingGlobalValueChangeListeners = null; 
	// Only available on the top instance, instances with an owner get the registry from the top instance (TODO: cache and invalidate for performance)
	private CaseAdministration caseAdministration; 
	
	private Set<Instance> children;
	private Set<Instance> unmodifiableChildren = Collections.emptySet();
	
	private TextTemplate staticDescription;
	private String staticName;
	private InstanceStorageInfo storageInfo;

	public InstanceStorageInfo getStorageInfo() {
		return storageInfo;
	}

	public void setStorageInfo(InstanceStorageInfo storageInfo) {
		this.storageInfo = storageInfo;
	}

	public InstanceMetadata(Instance instance, Entity<? extends Instance> entity) {
		this.instance = instance;
		this.entity = entity;
	}

	private static class GlobalValueChangeListener {
		ValueChangeObserver listener;
		boolean alsoForOwnedInstances;
	}
	
	public CaseAdministration getCaseAdministration() {
		if (caseAdministration==null) {
			if (owner!=null) {
				return owner.getMetadata().getCaseAdministration();
			} else {
				caseAdministration = new CaseAdministration(instance);
			}
		}
		return caseAdministration;
	}
	
	public void addGlobalValueChangeListener(ValueChangeObserver listener, boolean alsoForOwnedInstances) {
		GlobalValueChangeListener gvcl = new GlobalValueChangeListener();
		gvcl.listener = listener;
		gvcl.alsoForOwnedInstances = alsoForOwnedInstances;
		copyGlobalValueChangeListenersIfNeeded();
		globalValueChangeListeners.add(gvcl);
	}
	
	private void copyGlobalValueChangeListenersIfNeeded() {
		if (iteratingGlobalValueChangeListeners==globalValueChangeListeners) {
			globalValueChangeListeners = new ArrayList<GlobalValueChangeListener>(globalValueChangeListeners);
		}
	}

	public void removeGlobalValueChangeListener(ValueChangeObserver listener) {
		copyGlobalValueChangeListenersIfNeeded();
		Iterator<GlobalValueChangeListener> iterator = globalValueChangeListeners.iterator();
		while (iterator.hasNext()) {
			GlobalValueChangeListener next = iterator.next();
			if (next.listener==listener) {
				iterator.remove();
				return;
			}
		}
		throw new NoSuchElementException("GlobalValueChangeListener "+listener);
	}
	
	public void fireValueChanged(ValueChangeEvent event, boolean fromSelf) {
		boolean clearIteratingOnExit = false;
		if (iteratingGlobalValueChangeListeners != globalValueChangeListeners) {
			iteratingGlobalValueChangeListeners = globalValueChangeListeners;
			clearIteratingOnExit = true;
		}
		List<GlobalValueChangeListener> iterating = iteratingGlobalValueChangeListeners;
		ListIterator<GlobalValueChangeListener> iterator = iterating.listIterator(iterating.size());
		try {
			while (iterator.hasPrevious()) {
				GlobalValueChangeListener listener = iterator.previous();
				if (listener.alsoForOwnedInstances || fromSelf) {
					listener.listener.valueChanged(event);
				}
			}
			if (owner!=null) {
				owner.getMetadata().fireValueChanged(event, false);
			}
		} finally {
			if (clearIteratingOnExit && iteratingGlobalValueChangeListeners == iterating) {
				iteratingGlobalValueChangeListeners = null;
			}
		}
	}
	

	public Instance getInstanceOwner() {
		return owner;
	}
	
	/**
	 * Travels down the owners until an owner of the specified entity (or subclass) is found
	 * @param ofEntity The desired entity
	 * @return an instance of the desired entity or null
	 */
	@SuppressWarnings("unchecked")
	public <T extends Instance> T getInstanceOwner(Entity<T> ofEntity) {
		if (ofEntity==null) throw new IllegalArgumentException();
		Instance candidate = owner;
		while (candidate!=null) {
			if (Entity.extendsFrom(candidate.getMetadata().getEntity(), ofEntity)) return (T)candidate;
			candidate = candidate.getMetadata().getInstanceOwner();
		}
		return null;
	}
	
	/**
	 * Registers this as the owner of instance.
	 * Internal method, do not call directly!
	 * @param instance the owned instance.
	 */
	public void adopt(Instance instance, WriteableAttributeValue<? ,?, ?> relation) {
		if (children==null) {
			children = new HashSet<Instance>();
			this.unmodifiableChildren = Collections.unmodifiableSet(children);
		}
		children.add(instance);
		instance.getMetadata().registerOwner(this.instance, relation);
	}
	
	/**
	 * Opposite of adopt, clears the owner of instance
	 * Internal method, do not call directly!
	 * @param instance
	 */
	public void reject(Instance instance) {
		// TODO: readonly while transaction is not committed
		boolean found = children.remove(instance);
		if (!found) throw new RuntimeException("This instance was not adopted: "+instance);
		instance.getMetadata().clearOwner(this.instance);
	}

	protected void clearOwner(Instance oldOwner) {
		if (this.owner==oldOwner) {
			// We are not in the middle of a migration
			registerOwner(null, null);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void registerOwner(Instance owner, WriteableAttributeValue<?, ?, ?> ownerRelationValue) {
		if (this.isStatic() && !owner.getMetadata().isStatic()) throw new RuntimeException("Static instances cannot be owned by a case, they are global");
		if (this.owner!=null && owner!=null) {
			if (this.owner.getMetadata().getCaseAdministration()!=owner.getMetadata().getCaseAdministration()) {
				// 'Migration' to another case is not allowed
				throw new RuntimeException("This instance ["+instance+"] is already owned by ["+this.owner+"]. call detach() first.");
			}
		}
		if (this.owner!=null) {
			this.caseAdministration = this.owner.getMetadata().getCaseAdministration(); // temporary
		}
		if (ownerRelationValue != null) {
			if (ownerRelationValue.getInstance() != owner) {
				throw new IllegalArgumentException();
			}
		} else if (owner!=null) {
			throw new IllegalArgumentException();
		}

		WriteableAttributeValue oldOwnerRelationValue = this.ownerRelationValue;
		this.owner = owner;
		this.ownerRelationValue = ownerRelationValue;
		
		if (oldOwnerRelationValue!=null && ownerRelationValue!=null) {
			oldOwnerRelationValue.clearOrRemove(instance);
		}
		
		if (owner==null) {
			clearRelationsAfterSplit(this.instance);
			this.caseAdministration = null;
		} else {
			this.caseAdministration = null; // Fallthrough to the owner
			if (oldOwnerRelationValue==null) {
				// We did move to a new case
				registerUniqueIdsWithCaseAdministration(getCaseAdministration());
			}
		}
	}
	
	private void registerUniqueIdsWithCaseAdministration(CaseAdministration newCaseAdministration) {
		if (uniqueId!=null) {
			newCaseAdministration.rememberInstanceWithUniqueId(uniqueId, instance);
		}
		if (children!=null) {
			for(Instance instance: children) { // depth-first
				instance.getMetadata().registerUniqueIdsWithCaseAdministration(newCaseAdministration);
			}
		}
	}

	public Entity<?> getEntity() {
		return entity;
	}
	
	@Override
	public String toString() {
		return "InstanceMetadata("+instance.toString()+")";
	}

	public Set<Instance> getChildren() {
		return unmodifiableChildren;
	}
	
	/**
	 * Clears all relations to instances in other cases. Applies recursively to children. (getCaseAdministration() still refers the old case now)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void clearRelationsAfterSplit(Instance newCase) {
		if (uniqueId!=null) {
			getCaseAdministration().forgetInstanceWithUniqueId(uniqueId);
		}
		if (children!=null) {
			for(Instance instance: children) { // depth-first
				instance.getMetadata().clearRelationsAfterSplit(newCase);
			}
		}
		for (Relation relation : getEntity().getRelations()) {
			if (!relation.isReadOnly() && !relation.isOwner()) { 
				if (relation.isMultivalue()) {
					if (relation.isOrderedMultivalue()) {
						RelationValueList values = ((RelationValueList)relation.get(instance));
						if (values.hasStoredValue()) { // No default
							ValueList<? extends Instance> multi = (ValueList<? extends Instance>)values.getValue();
							for (int i=multi.size()-1;i>=0;i--) {
								if (multi.get(i).getMetadata().getCase()!=newCase) {
									values.removeValue(i);
								}
							}
						}
					} else {
						RelationValues values = ((RelationValues)relation.get(instance));
						if (values.hasStoredValue()) { // No default
							Values<? extends Instance> multi = (Values<? extends Instance>)values.getValue();
							List<Instance>  valuesToRemove = new ArrayList<Instance>();
							for (Instance candidate: multi) {
								if (candidate.getMetadata().getCase()!=newCase) {
									valuesToRemove.add(candidate);
								}
							}
							for (Instance instanceToRemove:valuesToRemove) {
								values.removeValue(instanceToRemove);
							}
						}
					}
				} else { // single value
					ReadOnlyAttributeValue value = relation.get(instance);
					if (value.hasStoredValue()) { // No default
						if (((Instance)value.getValue()).getMetadata().getCase()!=newCase) {
							((RelationValue)value).setValue(null);
						}
					}
				}
			}
		}
		for (Relation relation : getEntity().getReverseRelations()) {
			if (!relation.getReverseRelation().isOwner()) {
				if (relation.isMultivalue()) {
					RelationValues values = ((RelationValues)relation.get(instance));
					Values<? extends Instance> multi = (Values<? extends Instance>)values.getValue();
					List<Instance>  valuesToRemove = new ArrayList<Instance>();
					for (Instance candidate: multi) {
						if (candidate.getMetadata().getCase()!=newCase) {
							valuesToRemove.add(candidate);
						}
					}
					for (Instance instanceToRemove:valuesToRemove) {
						values.removeValue(instanceToRemove);
					}
					
				} else { // single value
					ReadOnlyAttributeValue value = relation.get(instance);
					if (value.getValue()!=null) {
						if (((Instance)value.getValue()).getMetadata().getCase()!=newCase) {
							((RelationValue)value).setValue(null);
						}
					}
				}
			}
		}
	}

	public Instance getCase() {
		Instance result = instance;
		while (result.getMetadata().getInstanceOwner()!=null) {
			result = result.getMetadata().getInstanceOwner();
		}
		return result;
	}

	/**
	 * Only used in static instances
	 */
	public TextTemplate getStaticDescription() {
		return staticDescription;
	}

	public void setStaticDescription(TextTemplate staticDescription) {
		this.staticDescription = staticDescription;
	}

	public void makeStatic(String name) {
		if (this.uniqueId!=null) {
			throw new IllegalStateException();
		}
		this.uniqueId = name; //TODO: Replace spaces and other non-name characters
		this.staticName = name;
	}
	
	public boolean isStatic() {
		return this.staticName!=null;
	}

	public String getStaticName() {
		return staticName;
	}
	
	public void initUniqueId(String uniqueId) {
		if (this.uniqueId!=null) {
			throw new RuntimeException("UniqueId was already initialized and cannot be changed");
		}
		this.uniqueId = uniqueId;
		getCaseAdministration().rememberInstanceWithUniqueId(this.uniqueId, this.instance);
	}

	public String getUniqueId() {
		if (this.uniqueId==null) {
			this.uniqueId = getCaseAdministration().newId(instance).toString();
			getCaseAdministration().rememberInstanceWithUniqueId(this.uniqueId, this.instance);
		}
		return uniqueId;
	}

	public String getUniqueIdIfInitialized() {
		return uniqueId;
	}

	@SuppressWarnings("unchecked")
	public void detach() {
		this.ownerRelationValue.clearOrRemove(instance);
	}
}
