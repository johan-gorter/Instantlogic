package org.instantlogic.fabric.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.instantlogic.fabric.model.Attribute;

/**
 * Contains all of the information as it was loaded into the instance. (including information that was not recognized)
 */
// TODO: allow 'git' diff markers to be parsed and stored within this information
public class InstanceStorageInfo {
	
	public static class InstanceNode {
		public String uniqueId;
		public String entityName;
		public final List<AttributeValueNode> values = new ArrayList<>();
		
		@SuppressWarnings("rawtypes")
		public void setValue(Attribute attribute, String newStoredValue) {
			AttributeValueNode value = getOrAdd(attribute);
			value.reset(false);
			if (newStoredValue!=null) {
				value.values.add(newStoredValue);
			}
		}
		
		@SuppressWarnings("rawtypes")
		public void setValues(Attribute attribute, List<String> newValues) {
			AttributeValueNode value = getOrAdd(attribute);
			value.reset(true);
			value.values.addAll(newValues);
		}
		
		@SuppressWarnings("rawtypes")
		public void setInstance(Attribute attribute, InstanceNode newNode) {
			AttributeValueNode value = getOrAdd(attribute);
			value.reset(false);
			value.subInstances.add(newNode);
		}
		
		@SuppressWarnings("rawtypes")
		public void setInstances(Attribute attribute, List<InstanceNode> newNodes) {
			AttributeValueNode value = getOrAdd(attribute);
			value.reset(true);
			value.subInstances.addAll(newNodes);
		}
		
		@SuppressWarnings("rawtypes")
		private AttributeValueNode getOrAdd(Attribute attribute) {
			for (AttributeValueNode value : values) {
				if (value.attributeName.equals(attribute.getName())) {
					return value;
				}
			}
			return addValue(attribute);
		}
		
		@SuppressWarnings("rawtypes")
		private AttributeValueNode addValue(Attribute attribute) {
			AttributeValueNode result = new AttributeValueNode();
			result.attributeName = attribute.getName();
			Iterator iterator = combine(attribute.getEntity().getAttributes().iterator(), attribute.getEntity().getRelations().iterator());
			while (iterator.hasNext()) {
				Attribute search = (Attribute) iterator.next();
				if (search==attribute) {
					while (iterator.hasNext()) {
						Attribute insertBefore = (Attribute) iterator.next();
						ListIterator<AttributeValueNode> valuesIterator = values.listIterator();
						while (valuesIterator.hasNext()) {
							AttributeValueNode insertBeforeValue = valuesIterator.next();
							if (insertBeforeValue.attributeName.equals(insertBefore.getName())) {
								values.add(valuesIterator.previousIndex()+1, result);
								return result;
							}
						}
					}
					values.add(result);
					return result;
				}
			}
			throw new RuntimeException("Attribute not found on its entity");
		}

		@SuppressWarnings("rawtypes")
		private Iterator combine(final Iterator iterator1, final Iterator iterator2) {
			return new Iterator() {
				private Iterator current = iterator1;
				@Override
				public boolean hasNext() {
					if (!current.hasNext() && current==iterator1) {
						current = iterator2;
					}
					return current.hasNext();
				}

				@Override
				public Object next() {
					if (!current.hasNext() && current==iterator1) {
						current = iterator2;
					}
					return current.next();
				}

				@Override
				public void remove() {
					throw new UnsupportedOperationException();
				}
			};
		}

		public AttributeValueNode getOrAddValue(String attributeName) {
			for(AttributeValueNode candidate : values) {
				if (candidate.attributeName.equals(attributeName))
				  return candidate;
			}
			AttributeValueNode result = new AttributeValueNode();
			result.attributeName = attributeName;
			values.add(result);
			return result;
		}

	}
	
	public static class AttributeValueNode {
		public String attributeName;
		public final List<String> values = new ArrayList<>();
		public final List<InstanceNode> subInstances = new ArrayList<>();
		public boolean multivalue;
		
		public void reset(boolean multivalue) {
			values.clear();
			subInstances.clear();
			this.multivalue = multivalue;
		}
	}

	public InstanceNode node;
	// fileName != null means this is the root of a file
	public String fileName;
	public String subDirectory;
	// in other cases this points to the root of its file
	public InstanceStorageInfo root;

	public Map<String, List<InstanceStorageInfo>> subStorages = new HashMap<>();
	
	public void addSubStorage(String relationName, InstanceStorageInfo storageInfo) {
		List<InstanceStorageInfo> list = subStorages.get(relationName);
		if (list==null) {
			list = new ArrayList<>();
			subStorages.put(relationName, list);
		}
		list.add(storageInfo);
	}

	public void removeSubStorage(String relationName, InstanceStorageInfo storageInfo) {
		List<InstanceStorageInfo> list = subStorages.get(relationName);
		Iterator<InstanceStorageInfo> iterator = list.iterator();
		while (iterator.hasNext()) {
			InstanceStorageInfo subStorage = iterator.next();
			if (storageInfo == subStorage) {
				iterator.remove();
				return;
			}
		}
		throw new RuntimeException("StorageInfo out of sync");
	}
}
