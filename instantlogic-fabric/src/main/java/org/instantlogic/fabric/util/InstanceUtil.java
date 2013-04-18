package org.instantlogic.fabric.util;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.AttributeValues;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;

/**
 * Can be used as a static import for when an Instance is accessed using 'reflection'
 */
public class InstanceUtil {

	public static Object get(Instance instance, String attributeOrRelationName) {
		Entity<?> entity = instance.getMetadata().getEntity();
		Attribute attribute = entity.getAttributeOrRelation(attributeOrRelationName);
		ReadOnlyAttributeValue attributeValue = attribute.get(instance);
		return attributeValue.getValue();
	}

	public static void set(Instance instance, String attributeOrRelationName, Object value) {
		Entity<?> entity = instance.getMetadata().getEntity();
		Attribute attribute = entity.getAttributeOrRelation(attributeOrRelationName);
		ReadOnlyAttributeValue attributeValue = attribute.get(instance);
		((AttributeValue)attributeValue).setValue(value);
	}

	public static void add(Instance instance, String attributeOrRelationName, Object value) {
		Entity<?> entity = instance.getMetadata().getEntity();
		Attribute attribute = entity.getAttributeOrRelation(attributeOrRelationName);
		ReadOnlyAttributeValue attributeValue = attribute.get(instance);
		((AttributeValues)attributeValue).addValue(value);
	}

}
