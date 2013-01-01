//package org.instantlogic.fabric.util;
//
//import java.io.Serializable;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.instantlogic.fabric.Instance;
//import org.instantlogic.fabric.model.Attribute;
//import org.instantlogic.fabric.model.Entity;
//import org.instantlogic.fabric.model.Relation;
//import org.instantlogic.fabric.value.AttributeValue;
//import org.instantlogic.fabric.value.AttributeValues;
//import org.instantlogic.fabric.value.RelationValue;
//import org.instantlogic.fabric.value.RelationValues;
//
//public class SerializedInstance<I extends Instance> implements Serializable {
//
//	private long id;
//	
//	private String entityName;
//	
//	private Map<String, Serializable> values;
//	
//	// TODO distributed using guids
//	
//	protected SerializedInstance() {
//	}
//	
//	public SerializedInstance(long id, String entityName, Map<String, Serializable> values) {
//		this.id = id;
//		this.entityName = entityName;
//		this.values = (Map<String, Serializable>)values;
//	}
//	
//	public boolean isDistributed() {
//		return false;
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public String getEntityName() {
//		return entityName;
//	}
//	
//	@SuppressWarnings("unchecked")
//	public static <II extends Instance<II>> SerializedInstance<II> serialize(II src) {
//		Entity<II> entity = src.getEntity();
//		String id = src.getInstanceId();
//		Map<String, Serializable> values = new HashMap<String, Serializable>();
//		String entityName = entity.getName();
//		// TODO: case version?
//		for (Attribute<II,?,?> attribute : entity.getAttributes()) {
//			if (!attribute.isReadOnly()) {
//				AttributeValue<II, ?> attributeValue = (AttributeValue<II, ?>) attribute.get(src);
//				if (attributeValue.isStored()) {
//					if (attribute.isMultivalue()) {
//						AttributeValues<II,?> attributeValues = (AttributeValues<II,?>) attributeValue;
//						Object[] arrayValues = new Object[attributeValues.getValue().size()];
//						int index=0;
//						for (Object value : attributeValues.getValue()) {
//							Serializable valueItem = toSerializable(value);
//							arrayValues[index++] = valueItem;
//						}
//						values.put(attribute.getName(), arrayValues);
//					} else {
//						Serializable value = toSerializable(attributeValue.getValue());
//						values.put(attribute.getName(), value);
//					}
//				}
//			}
//		}
//		for (Relation<II, ?, ?> relation : entity.getRelations()) {
//			if (!relation.isReadOnly()) {
//				RelationValue<II, ?> attributeValue = (RelationValue<II, ?>) relation.get(src);
//				if (attributeValue.isStored()) {
//					if (relation.isMultivalue()) {
//						RelationValues<II, ?> target = (RelationValues<II, ?>)attributeValue;
//						Object[] arrayValues = new Object[target.getValue().size()];
//						values.put(relation.getName(), arrayValues);
//						int index = 0;
//						for (Instance targetInstance: (List<Instance>)target.getValue()) {
//							if (relation.isOwner()) {
//								Serializable childElement = serialize((II)targetInstance); // Cheating, targetInstance is not II
//								arrayValues[index++] = childElement;
//							} else {
//								arrayValues[index++]=targetInstance.getInstanceId();
//							}
//						}
//					} else {
//						RelationValue<II, ?> target = (RelationValue<II, ?>)attributeValue;
//						Instance targetInstance = (Instance) target.getValue();
//						if (relation.isOwner()) {
//							Serializable childElement = serialize((II)targetInstance); // Cheating, targetInstance is not II
//							values.put(relation.getName(), childElement);
//						} else {
//							values.put(relation.getName(), targetInstance.getInstanceId());
//						}
//					}
//				}
//			}
//		}
//		return new SerializedInstance<II>(id, entityName, values);
//	}
//	
//	// Can only be used to deserialize the case instance or deserialize into an emtpy case instance for now
//	public void deserialize(I target) {
//		if (entityName.equals(target.getEntity().getName())) {
//			throw new RuntimeException("Wrong entity name. was: "+getEntityName()+" expected: "+target.getEntity().getName());
//		}
//		if (target.getInstanceId()!=getId()) {
//			throw new RuntimeException("Wrong instance id. was: "+getId()+" expected: "+target.getInstanceId());
//		}
//		deserializeFirstPass(this, target);
//		deserializeSecondPass(this, target);
//	}
//
//	// Everything except not-owned relations
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	private static <II extends Instance<II>> void deserializeFirstPass(SerializedInstance<II> source, II target) {
//		Entity<II> entity = target.getEntity();
//		for (Attribute<II, ?, ?> attribute : entity.getAttributes()) {
//			if (!attribute.isReadOnly()) {
//				if (source.values.containsKey(attribute.getName())) {
//					Serializable value = (Serializable)source.values.get(attribute.getName());
//					AttributeValue attributeValue = (AttributeValue) attribute.get(target);
//					if (attribute.isMultivalue()) {
//						setMultivalueAttribute(attribute, (AttributeValues) attributeValue, value);
//					} else {
//						attributeValue.set(fromSerializable(attribute.getDatatype(), value));
//					}
//				}
//			}
//		}
//		for (Relation relation : entity.getRelations()) {
//			if (!relation.isReadOnly()) {
//				if (source.values.containsKey(relation.getName())) {
//					Serializable value = (Serializable)source.values.get(relation.getName());
//					AttributeValue relationValue = (RelationValue) relation.get(target);
//					if (relation.isOwner()) {
//						if (relation.isMultivalue()) {
//							setMultivalueRelation(relation, (RelationValues)relationValue, value, target);
//						} else {
//							SerializedInstance valueObject = (SerializedInstance) value;
//							Instance targetInstance = createInstance(target.getCase(), valueObject.getEntityName(), valueObject.getId());
//							deserializeFirstPass((SerializedInstance<II>)valueObject, (II)targetInstance); // Cheating
//							relationValue.set(targetInstance);
//						}
//					}
//				}
//			}
//		}
//	}
//	
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	private static <II extends Instance<II>> void deserializeSecondPass(SerializedInstance<II> source, II target) {
//		Entity<II> entity = target.getEntity();
//		InstanceAdministration registry = target.getInstanceAdministration();
//		for (Relation relation : entity.getRelations()) {
//			if (!relation.isReadOnly()) {
//				if (source.values.containsKey(relation.getName())) {
//					Object value = source.values.get(relation.getName());
//					RelationValue relationValue = (RelationValue) relation.get(target);
//					if (!relation.isOwner()) {
//						// Set non-owning relations
//						if (relation.isMultivalue()) {
//							RelationValues values = (RelationValues) relationValue;
//							for (Object item: ((Object[])value)) {
//								values.add(registry.getInstanceById((String)item));
//							}
//						} else {
//							relationValue.set(registry.getInstanceById((String)value));
//						}
//					} else {
//						// Recurse
//						if (relation.isMultivalue()) {
//							Iterable<Instance> targets = (Iterable<Instance>) relationValue.getValue();
//							Object[] items = (Object[]) value;
//							int index = 0;
//							for (Instance targetInstance: targets) {
//								SerializedInstance<II> item = (SerializedInstance<II>)items[index++]; // cheating
//								deserializeSecondPass(item, (II)targetInstance); // cheating
//							}
//						} else {
//							II targetInstance = (II) relation.get(target).getValue(); // cheating
//							deserializeSecondPass((SerializedInstance<II>)value, targetInstance); // cheating
//						}
//					}
//				}
//			}
//		}
//	}
//	
//	private static Instance createInstance(String entityName) {
//		Entity<?> entity = caseInstance.getEntity().getEntities().get(entityName);
//		return entity.createInstance();
//	}
//
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	private static void setMultivalueRelation(Relation relation, RelationValues relationValue, Serializable value, Instance owner) {
//		Object[] values = (Object[])value;
//		for (Object item: values) {
//			SerializedInstance valueObject = (SerializedInstance) item;
//			Instance target = createInstance(owner.getCase(), valueObject.getEntityName(), valueObject.getId());
//			deserializeFirstPass(valueObject, target);
//			relationValue.add(target);
//		}
//	}
//
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	private static void setMultivalueAttribute(Attribute attribute, AttributeValues attributeValue, Object value) {
//		Object[] values = (Object[])value;
//		for (Object item: values) {
//			attributeValue.add(fromSerializable(attribute.getDatatype(), (Serializable) item));
//		}
//	}	
//
//	private static Serializable toSerializable(Object value) {
//		if (value instanceof Serializable) {
//			return (Serializable) value;
//		}
//		throw new RuntimeException("Not serializable: "+value.getClass());
//	}
//
//	private static Object fromSerializable(Class<?> type, Serializable value) {
//		return value;
//	}
//}
