/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.tools.persistence.json;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.AttributeValues;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;
import org.instantlogic.fabric.value.RelationValue;
import org.instantlogic.fabric.value.RelationValues;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

@SuppressWarnings({"rawtypes","unchecked"})
public class GsonInstanceAdapter implements JsonSerializer<Instance>, JsonDeserializer<Instance> {

	public static final SimpleDateFormat UNIVERSAL_DATE = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public JsonElement serialize(Instance src, Type typeOfSrc, JsonSerializationContext context) {
		Entity<? extends Instance> entity = src.getMetadata().getEntity();
		JsonObject result = new JsonObject();
		result.add("instanceId", new JsonPrimitive(src.getMetadata().getUniqueId()));
		result.add("entityName", new JsonPrimitive(entity.getName()));
		if (src.getMetadata().getInstanceOwner() == null) {
			result.add("version", new JsonPrimitive(src.getMetadata().getCaseAdministration().getVersion()));
		}
		for (Attribute attribute : entity.getAttributes()) {
			if (!attribute.isReadOnly()) {
				ReadOnlyAttributeValue attributeValue = (ReadOnlyAttributeValue) attribute.get(src);
				if (attributeValue.hasStoredValue()) {
					if (attribute.isMultivalue()) {
						AttributeValues attributeValues = (AttributeValues) attributeValue;
						JsonArray values = new JsonArray();
						for (Object value : (Iterable) attributeValues.getValue()) {
							JsonElement valueItem = toJsonPrimitive(value);
							values.add(valueItem);
						}
						result.add(attribute.getName(), values);
					} else {
						JsonElement value = toJsonPrimitive(attributeValue.getValue());
						result.add(attribute.getName(), value);
					}
				}
			}
		}
		for (Relation relation : entity.getRelations()) {
			if (!relation.isReadOnly()) {
				ReadOnlyAttributeValue attributeValue = (ReadOnlyAttributeValue) relation.get(src);
				if (attributeValue.hasStoredValue()) {
					if (relation.isMultivalue()) {
						RelationValues target = (RelationValues) attributeValue;
						JsonArray values = new JsonArray();
						result.add(relation.getName(), values);
						for (Instance targetInstance : (Iterable<Instance>) target.getValue()) {
							if (relation.isOwner()) {
								JsonElement childElement = context.serialize(targetInstance);
								values.add(childElement);
							} else if (targetInstance.getMetadata().isStatic()) {
								values.add(serializeStaticInstance(targetInstance));
							} else {
								values.add(new JsonPrimitive(targetInstance.getMetadata().getUniqueId()));
							}
						}
					} else {
						RelationValue target = (RelationValue) attributeValue;
						Instance targetInstance = (Instance) target.getValue();
						if (relation.isOwner()) {
							JsonElement childElement = context.serialize(targetInstance);
							result.add(relation.getName(), childElement);
						} else if (targetInstance.getMetadata().isStatic()) {
							result.add(relation.getName(), serializeStaticInstance(targetInstance));
						} else {
							result.add(relation.getName(), new JsonPrimitive(targetInstance.getMetadata().getUniqueId()));
						}
					}
				}
			}
		}
		return result;
	}

	private JsonElement toJsonPrimitive(Object value) {
		if (value==null) {
			return JsonNull.INSTANCE;
		} else if (value instanceof Date) {
			return new JsonPrimitive(UNIVERSAL_DATE.format(value));
		} else if (value instanceof Boolean) {
			return new JsonPrimitive((Boolean) value);
		} else if (value instanceof Number) {
			return new JsonPrimitive((Number) value);
		} else if (value instanceof Instance) {
			return serializeStaticInstance((Instance)value); // Constant deduction which deduces a static instance for example
		} else {
			return new JsonPrimitive(value.toString());
		}
	}

	@Override
	public Instance deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		Instance result;
		try {
			result = (Instance) ((Class) typeOfT).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		JsonObject data = json.getAsJsonObject();
		result.getMetadata().getCaseAdministration().setVersion(data.get("version").getAsInt());
		// Id -> Instance
		Map<String, Instance> instances = new HashMap<String, Instance>();

		deserializeFirstPass(data, result, "0", result, instances);
		deserializeSecondPass(data, result, instances);
		return result;
	}

	private void deserializeFirstPass(JsonObject data, Instance result, String instanceId, Instance caseInstance, Map<String, Instance> instances) {
		instances.put(instanceId, result);
		Entity<? extends Instance> entity = result.getMetadata().getEntity();
		for (Attribute attribute : entity.getAttributes()) {
			if (!attribute.isReadOnly()) {
				if (data.has(attribute.getName())) {
					JsonElement value = data.get(attribute.getName());
					if (attribute.isMultivalue()) {
						setMultivalueAttribute(attribute, (AttributeValues) attribute.get(result), value, result.getMetadata().getCaseAdministration());
					} else {
						AttributeValue attributeValue = (AttributeValue) attribute.get(result);
						attributeValue.setValue(toPrimitive(attribute, value, result.getMetadata().getCaseAdministration()));
					}
				}
			}
		}
		for (Relation relation : entity.getRelations()) {
			if (!relation.isReadOnly()) {
				if (data.has(relation.getName())) {
					JsonElement value = data.get(relation.getName());
					ReadOnlyRelationValue relationValue = (ReadOnlyRelationValue) relation.get(result);
					if (relation.isOwner()) {
						if (relation.isMultivalue()) {
							setMultivalueRelation(relation, (RelationValues) relationValue, value, result, caseInstance, instances);
						} else {
							JsonObject valueObject = value.getAsJsonObject();
							String newInstanceId = valueObject.get("instanceId").getAsString();
							Instance target = createInstance(caseInstance, valueObject, newInstanceId);
							deserializeFirstPass(valueObject, target, newInstanceId, caseInstance, instances);
							((RelationValue)relationValue).setValue(target);
						}
					}
				}
			}
		}
	}

	private Instance createInstance(Instance caseInstance, JsonObject valueObject, String uniqueId) {
		String entityName = valueObject.get("entityName").getAsString();
		Entity<?> entity = caseInstance.getMetadata().getCaseAdministration().getAllEntities().get(entityName);
		if (entity==null) return null;
		Instance target = entity.createInstance();
		target.getMetadata().initUniqueId(uniqueId);
		return target;
	}

	private void deserializeSecondPass(JsonObject data, Instance result, Map<String, Instance> instances) {
		Entity<? extends Instance> entity = result.getMetadata().getEntity();
		for (Relation relation : entity.getRelations()) {
			if (!relation.isReadOnly()) {
				if (data.has(relation.getName())) {
					JsonElement value = data.get(relation.getName());
					ReadOnlyRelationValue relationValue = (ReadOnlyRelationValue) relation.get(result);
					if (!relation.isOwner()) {
						// Set non-owning relations
						if (relation.isMultivalue()) {
							RelationValues values = (RelationValues) relationValue;
							for (JsonElement item : ((JsonArray) value)) {
								if (item instanceof JsonObject) {
									// probably a static instance
									values.addValue(deserializeStaticInstance((JsonObject)item, result.getMetadata().getCaseAdministration()));
								} else {
									String itemId = item.getAsString(); // Id of another instance
									values.addValue(instances.get(itemId));
								}
							}
						} else {
							if (value instanceof JsonObject) {
								((RelationValue)relationValue).setValue(deserializeStaticInstance((JsonObject)value, result.getMetadata().getCaseAdministration()));
							} else {
								String itemId = value.getAsString();
								((RelationValue)relationValue).setValue(instances.get(itemId));
							}
						}
					} else {
						// Recurse
						if (relation.isMultivalue()) {
							Iterable<Instance> targets = (Iterable<Instance>) relationValue.getValue();
							JsonArray items = (JsonArray) value;
							int index = 0;
							for (Instance target : targets) {
								JsonObject item = (JsonObject) items.get(index++);
								deserializeSecondPass(item, target, instances);
							}
						} else {
							Instance target = (Instance) relation.get(result).getValue();
							deserializeSecondPass((JsonObject) value, target, instances);
						}
					}
				}
			}
		}
	}

	private Instance deserializeStaticInstance(JsonObject value, CaseAdministration caseAdministration) {
		String entityName = value.get("entityName").getAsString();
		Entity<?> entity = caseAdministration.getAllEntities().get(entityName);
		String instanceName = value.get("instanceName").getAsString();
		return entity.getStaticInstances().get(instanceName);
	}
	
	private JsonElement serializeStaticInstance(Instance instance) {
		JsonObject result = new JsonObject();
		String instanceName = instance.getMetadata().getStaticName();
		if (instanceName==null) 
			throw new IllegalArgumentException();
		result.addProperty("instanceName", instanceName);
		result.addProperty("entityName", instance.getMetadata().getEntity().getName());
		return result;
	}

	private void setMultivalueRelation(Relation relation, RelationValues relationValue, JsonElement value, Instance owner, Instance caseInstance, Map<String, Instance> instances) {
		JsonArray values = (JsonArray) value;
		for (JsonElement item : values) {
			JsonObject valueObject = item.getAsJsonObject();
			String newInstanceId = valueObject.get("instanceId").getAsString();
			Instance target = createInstance(caseInstance, valueObject, newInstanceId);
			if (target!=null) {
				deserializeFirstPass(item.getAsJsonObject(), target, newInstanceId, caseInstance, instances);
				relationValue.addValue(target);
			} else {
				// Warning: could not deserialize instance
			}
		}
	}

	private void setMultivalueAttribute(Attribute attribute, AttributeValues attributeValue, JsonElement value, CaseAdministration caseAdministration) {
		JsonArray values = (JsonArray) value;
		for (JsonElement item : values) {
			attributeValue.addValue(toPrimitive(attribute, item, caseAdministration));
		}
	}

	private Object toPrimitive(Attribute attribute, JsonElement value, CaseAdministration caseAdministration) {
		Class javaClassName = attribute.getJavaClassName();
		if (javaClassName == Object.class && value.isJsonPrimitive()) {
			JsonPrimitive primitiveValue = value.getAsJsonPrimitive();
			if (primitiveValue.isBoolean()) return primitiveValue.getAsBoolean();
			if (primitiveValue.isNumber()) {
				if (primitiveValue.getAsString().contains(".")) {
					return primitiveValue.getAsBigDecimal(); // To be on the safe side
				} else {
					return primitiveValue.getAsNumber().intValue();
				}
			}
			return primitiveValue.getAsString();
		} else if (javaClassName == Date.class) {
			try {
				return UNIVERSAL_DATE.parse(value.getAsString());
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		} else if (javaClassName == Boolean.class) {
			return value.getAsBoolean();
		} else if (javaClassName == Long.class) {
			return value.getAsLong();
		} else if (javaClassName == Integer.class) {
			return value.getAsInt();
		} else if (javaClassName == Double.class) {
			return value.getAsDouble();
		} else if (javaClassName == BigDecimal.class) {
			return value.getAsBigDecimal();
		} else if (Number.class.isAssignableFrom(javaClassName)) {
			return value.getAsNumber();
		} else if (value.isJsonObject()) {
			return deserializeStaticInstance((JsonObject)value, caseAdministration);
		} else {
			return value.getAsString();
		}
	}
}
