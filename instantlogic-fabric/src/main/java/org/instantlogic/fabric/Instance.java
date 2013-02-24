/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.fabric;

import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.text.TextTemplate;
import org.instantlogic.fabric.util.AbstractDeductionContext;
import org.instantlogic.fabric.util.InstanceMetadata;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.AttributeValues;
import org.instantlogic.fabric.value.Multi;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;
import org.instantlogic.fabric.value.RelationValue;
import org.instantlogic.fabric.value.RelationValues;
import org.instantlogic.fabric.value.impl.AttributeValueImpl;
import org.instantlogic.fabric.value.impl.AttributeValuesImpl;
import org.instantlogic.fabric.value.impl.ReadOnlyAttributeValueImpl;
import org.instantlogic.fabric.value.impl.ReadOnlyRelationValueImpl;
import org.instantlogic.fabric.value.impl.RelationValueImpl;
import org.instantlogic.fabric.value.impl.RelationValuesImpl;
import org.instantlogic.fabric.value.impl.ReverseRelationValueImpl;
import org.instantlogic.fabric.value.impl.ReverseRelationValuesImpl;

/**
 * Can be compared to a class, only more powerful.
 * 
 * Note that an instance should always have an owner. the root of this owner hierarchy is called the case.
 */
public abstract class Instance {

	private final InstanceMetadata metadata;
	
	protected abstract Entity<?> getInstanceEntity();
	
	protected Instance() {
		metadata = new InstanceMetadata(this, getInstanceEntity());
	}

	@SuppressWarnings("unchecked")
	protected<Value extends Object, I extends Instance> ReadOnlyAttributeValueImpl<I, Value> createReadOnlyAttributeValue(Attribute<I, Value, Value> attribute) {
		return new ReadOnlyAttributeValueImpl<I, Value>((I)this, attribute);
	}
	
	@SuppressWarnings("unchecked")
	protected<Value extends Object, I extends Instance> AttributeValue<I, Value> createAttributeValue(Attribute<I, Value, Value> attribute) {
		return new AttributeValueImpl<I, Value>((I)this, attribute);
	}
	
	@SuppressWarnings("unchecked")
	protected<Value extends Object, I extends Instance> AttributeValues<I, Value> createAttributeValues(Attribute<I, Multi<Value>, Value> attribute) {
		return new AttributeValuesImpl<I, Value>((I)this, attribute);
	}

	@SuppressWarnings("unchecked")
	protected<To extends Instance, I extends Instance> ReadOnlyRelationValue<I, To> createReadOnlyRelationValue(Relation<I, To, To> relation) {
		return new ReadOnlyRelationValueImpl<I, To>((I)this, relation);
	}
	
	@SuppressWarnings("unchecked")
	protected<To extends Instance, I extends Instance> RelationValue<I, To> createRelationValue(Relation<I, To, To> relation) {
		return new RelationValueImpl<I, To>((I)this, relation);
	}
	
	@SuppressWarnings("unchecked")
	protected<To extends Instance, I extends Instance> RelationValues<I, To> createRelationValues(Relation<I, Multi<To>, To> relation) {
		return new RelationValuesImpl<I, To>((I)this, relation);
	}

	@SuppressWarnings("unchecked")
	protected<To extends Instance, I extends Instance> RelationValue<I, To> createReverseRelationValue(Relation<I, To, To> relation) {
		return new ReverseRelationValueImpl<I, To>((I)this, relation);
	}
	
	@SuppressWarnings("unchecked")
	protected<To extends Instance, I extends Instance> RelationValues<I, To> createReverseRelationValues(Relation<I, Multi<To>, To> relation) {
		return new ReverseRelationValuesImpl<I, To>((I)this, relation);
	}
	
	public String getName() {
		return null;
	}
	
	@Override
	public String toString() {
		String name = getName();
		if (name==null) {
			name="";
		} else {
			name="("+name+")";
		}
		String uniqueId = getMetadata().getUniqueIdIfInitialized();
		if (uniqueId==null) uniqueId="Anonymous";
		return getInstanceEntity().toString()+"#"+uniqueId+name;
	}
	
	public String renderTitle(AbstractDeductionContext context) {
		Entity<?> entity = getMetadata().getEntity();
		while (entity.getTitle()==null && entity.extendsEntity()!=null) {
			entity = entity.extendsEntity();
		}
		TextTemplate title = entity.getTitle();
		if (title==null) return null;
		try {
			context.pushSelectedInstance(this);
			return title.renderText(context);
		} finally {
			context.popSelectedInstance(this);
		}
	}

	/**
	 * Suggestions for a better name: getInstanceOptions, getInstanceOperations, getInstanceData, instance() ...
	 */
	public InstanceMetadata getMetadata() {
		return metadata;
	}
}
