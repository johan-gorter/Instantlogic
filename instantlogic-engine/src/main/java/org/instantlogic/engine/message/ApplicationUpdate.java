package org.instantlogic.engine.message;

import java.util.concurrent.atomic.AtomicInteger;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.AttributeValueList;
import org.instantlogic.fabric.value.ValueList;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;
import org.instantlogic.fabric.value.RelationValue;
import org.instantlogic.fabric.value.RelationValueList;
import org.instantlogic.interaction.Application;

public class ApplicationUpdate {

	public final Application application;
	public final Application oldApplication;
	private final AtomicInteger tasksToComplete = new AtomicInteger();
	
	public ApplicationUpdate(Application oldApplication, Application application) {
		this.oldApplication = oldApplication;
		this.application = application;
	}

	public Instance loadFrom(Instance oldCase) {
		Instance newCase = application.getCaseEntity().createInstance();
		recreateStructure(newCase, oldCase, newCase.getMetadata().getCaseAdministration()); // aggregate relations only
		copyData(newCase, oldCase, newCase.getMetadata().getCaseAdministration());
		return newCase;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void copyData(Instance newInstance, Instance oldInstance, CaseAdministration newCaseAdministration) {
		// TODO: Instead of recursion, use a list result from recreateStructure
		Entity<?> newEntity = newInstance.getMetadata().getEntity();
		Entity<?> oldEntity = oldInstance.getMetadata().getEntity();
		for (Attribute oldAttribute : oldEntity.getAttributes()) {
			copyValue(oldInstance, oldAttribute, newInstance, newEntity);
		}
		for (Relation oldRelation : oldEntity.getRelations()) {
			Relation newRelation = newEntity.getRelationById(oldRelation.getUniqueId());
			if (newRelation!=null) {
				if (!oldRelation.isOwner()) {
					if (!newRelation.isOwner()) {
						copyRelationValue(oldInstance, oldRelation, newInstance, newEntity, newCaseAdministration);
					}
				} else {
					if (newRelation.isMultivalue()) {
						RelationValueList relationValues = (RelationValueList)newRelation.get(newInstance);
						for (Instance newChildInstance : (ValueList<? extends Instance>)relationValues.getValue()) {
							Instance oldChildInstance = oldInstance.getMetadata().getCaseAdministration().getInstanceByUniqueId(newChildInstance.getMetadata().getUniqueId());
							copyData(newChildInstance, oldChildInstance, newCaseAdministration);
						}
					} else {
						Instance newChildInstance = (Instance)newRelation.get(newInstance).getValue();
						Instance oldChildInstance = oldInstance.getMetadata().getCaseAdministration().getInstanceByUniqueId(newChildInstance.getMetadata().getUniqueId());
						copyData(newChildInstance, oldChildInstance, newCaseAdministration);
					}
				}
			}
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void copyRelationValue(Instance oldInstance, Relation oldRelation, Instance newInstance, Entity<?> newEntity, CaseAdministration newCaseAdministration) {
		ReadOnlyAttributeValue relationValue = oldRelation.get(oldInstance);
		if (relationValue.hasStoredValue()) {
			Relation newRelation = newEntity.getRelationById(oldRelation.getUniqueId());
			if (newRelation!=null && !newRelation.isReadOnly()) {
				if (oldRelation.isMultivalue()) {
					if (newRelation.isMultivalue()) {
						RelationValueList oldRelationValues = (RelationValueList)oldRelation.get(oldInstance);
						RelationValueList newRelationValues = (RelationValueList)newRelation.get(newInstance);
						for (Instance oldValue : (ValueList<Instance>)oldRelationValues.getStoredValue()) {
							Instance newValue = findInstance(oldValue, newCaseAdministration);
							newRelationValues.addValue(newValue);
						}
					} else {
						// TODO multivalue to single value (use only first instance)
					}
				} else {
					if (!newRelation.isMultivalue()) {
						Instance oldValue = (Instance)((RelationValue)oldRelation.get(oldInstance)).getStoredValue();
						Instance newValue = findInstance(oldValue, newCaseAdministration);
						((AttributeValue)newRelation.get(newInstance)).setValue(newValue);
					} else {
						// TODO single value becomes multivalue
					}
				}
			} else {
				// TODO: Remember value
			}
		}
	}

	private Instance findInstance(Instance oldValue, CaseAdministration newCaseAdministration) {
		if (oldValue.getMetadata().isStatic()) {
			Entity<?> newEntity = newCaseAdministration.getAllEntitiesById().get(oldValue.getMetadata().getEntity().getUniqueId());
			if (newEntity!=null) {
				return (Instance)newEntity.getStaticInstances().get(oldValue.getMetadata().getStaticName());
			}
		}
		return newCaseAdministration.getInstanceByUniqueId(oldValue.getMetadata().getUniqueId());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void copyValue(Instance oldInstance, Attribute oldAttribute, Instance newInstance, Entity<?> newEntity) {
		ReadOnlyAttributeValue attributeValue = oldAttribute.get(oldInstance);
		if (attributeValue.hasStoredValue()) {
			Attribute newAttribute = newEntity.getAttributeById(oldAttribute.getUniqueId());
			if (newAttribute!=null && !newAttribute.isReadOnly()) {
				if (oldAttribute.isMultivalue()) {
					if (newAttribute.isMultivalue()) {
						AttributeValueList oldAttributeValues = (AttributeValueList)oldAttribute.get(oldInstance);
						AttributeValueList newAttributeValues = (AttributeValueList)newAttribute.get(newInstance);
						for (Object oldValue : (ValueList)oldAttributeValues.getStoredValue()) {
							newAttributeValues.addValue(oldValue);
						}
					} else {
						// TODO multivalue to single value (use only first instance)
					}
				} else {
					if (!newAttribute.isMultivalue()) {
						Object oldValue = ((AttributeValue)oldAttribute.get(oldInstance)).getStoredValue();
						((AttributeValue)newAttribute.get(newInstance)).setValue(oldValue);
					} else {
						// TODO single value becomes multivalue
					}
				}
			} else {
				// TODO: Remember value
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void recreateStructure(Instance newInstance, Instance oldInstance, CaseAdministration newCaseAdministration) {
		String id = oldInstance.getMetadata().getUniqueIdIfInitialized();
		if (id!=null) {
			newInstance.getMetadata().initUniqueId(id);
		}
		Entity<?> newEntity = newInstance.getMetadata().getEntity();
		Entity<?> oldEntity = oldInstance.getMetadata().getEntity();
		for (Relation oldRelation : oldEntity.getRelations()) {
			if (oldRelation.isOwner()) {
				Relation newRelation = newEntity.getRelationById(oldRelation.getUniqueId());
				if (newRelation!=null && newRelation.isOwner()) {
					ReadOnlyAttributeValue attributeValue = oldRelation.get(oldInstance);
					if (attributeValue.hasStoredValue()) {
						if (oldRelation.isMultivalue()) {
							if (newRelation.isMultivalue()) {
								RelationValueList oldRelationValues = (RelationValueList)oldRelation.get(oldInstance);
								RelationValueList newRelationValues = (RelationValueList)newRelation.get(newInstance);
								for (Instance oldChildInstance : (ValueList<? extends Instance>)oldRelationValues.getValue()) {
									Instance newChildInstance = createInstance(oldChildInstance, newCaseAdministration);
									if (newChildInstance!=null) {
										newRelationValues.addValue(newChildInstance);
										recreateStructure(newChildInstance, oldChildInstance, newCaseAdministration);
									}
								}
							} else {
								// TODO multivalue to single value (use only first instance)
							}
						} else {
							if (!newRelation.isMultivalue()) {
								Instance oldChildInstance = (Instance)oldRelation.get(oldInstance).getValue();
								Instance newChildInstance = createInstance(oldChildInstance, newCaseAdministration);
								if (newChildInstance!=null) {
									((RelationValue)newRelation.get(newInstance)).setValue(oldChildInstance);
									recreateStructure(newChildInstance, oldChildInstance, newCaseAdministration);
								}
							} else {
								// TODO single value becomes multivalue
							}
						}
					}
				} else {
					//TODO: Remember instance
				}
			}
		}
	}

	private Instance createInstance(Instance oldChildInstance, CaseAdministration newCaseAdministration) {
		Entity<?> newEntity = newCaseAdministration.getAllEntitiesById().get(oldChildInstance.getMetadata().getEntity().getUniqueId());
		if (newEntity!=null) {
			Instance newInstance = newEntity.createInstance();
			return newInstance;
		}
		return null;
	}

	public void addTaskToComplete() {
		tasksToComplete.incrementAndGet();
	}
	
	public void taskCompleted() {
		if (tasksToComplete.decrementAndGet()==0) {
			try {
				oldApplication.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}
