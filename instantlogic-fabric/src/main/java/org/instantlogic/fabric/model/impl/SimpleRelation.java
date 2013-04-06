/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.fabric.model.impl;

import java.lang.reflect.Field;
import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.model.Validation;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;


public class SimpleRelation<I extends Instance, Value extends Object, To extends Instance> extends Relation<I, Value, To> {

	private final String name;
	private final Entity<I> entity;
	private final Entity<To> to;
	private final Class<To> valueClass;
	private Relation<To, ? extends Object,I> reverseRelation;

	public boolean owner;
	public boolean autoCreate;
	public boolean multivalue;
	public boolean reverse;
	public Validation[] validations;
	public Map<String, Object> dataType;
	public boolean readOnly;
	public Deduction<Boolean> relevance;
	public Deduction<Value> rule;
	public Deduction<Value> _default;

	private Field instanceField; 

	public SimpleRelation(String name, Entity<I> entity, Entity<To> to, Class<To> valueClass, Relation<To, ? extends Object,I> reverseRelation) {
		this(name, entity, to, valueClass, reverseRelation, null);
	}

	
	public SimpleRelation(String name, Entity<I> entity, Entity<To> to, Class<To> valueClass, Relation<To, ? extends Object,I> reverseRelation, String instanceFieldName) {
		this.name = name;
		this.entity = entity;
		this.to = to;
		this.valueClass = valueClass;
		this.reverseRelation = reverseRelation;
		if (reverseRelation!=null) {
			reverseRelation.setReverseRelation(this);
		}
		if (instanceFieldName!=null) {
			try {
				instanceField = entity.getInstanceClass().getField(instanceFieldName);
				instanceField.setAccessible(true);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public String getName() {
		return name;
	}

	@Override
	public Entity<To> getTo() {
		return to;
	}

	@Override
	public boolean isOwner() {
		return owner;
	}
	
	@Override
	public boolean isAutoCreate() {
		return autoCreate;
	}

	@Override
	public boolean isMultivalue() {
		return multivalue;
	}
	
	@Override
	public boolean isReverse() {
		return reverse;
	}
	
	/* Needed for bootstrapping */
	@Override
	public void setReverseRelation(Relation<To, ? extends Object, I> reverse) {
		this.reverseRelation = reverse;
	}

	@Override
	public Relation<To, ? extends Object,I> getReverseRelation() {
		return reverseRelation;
	}


	@Override
	public Entity<I> getEntity() {
		return entity;
	}
	
	public To createTo(I from) {
		To result = (To)getTo().createInstance();
		return result;
	};
	
	@Override
	public Class<To> getJavaClassName() {
		return valueClass;
	}

	@Override
	public Validation[] getValidations() {
		return validations;
	}

	@Override
	public Map<String, Object> getDataType() {
		return dataType;
	}

	@Override
	public boolean isReadOnly() {
		return readOnly;
	}

	@Override
	public Deduction<Boolean> getRelevance() {
		return relevance;
	}

	@Override
	public Deduction<Value> getRule() {
		return rule;
	}

	@Override
	public Deduction<Value> getDefault() {
		return _default;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ReadOnlyAttributeValue<I, Value> get(I instance) {
		try {
			return (ReadOnlyAttributeValue<I, Value>) instanceField.get(instance);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
