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
import java.util.LinkedHashMap;
import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Validation;
import org.instantlogic.fabric.text.TextTemplate;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;


public class SimpleAttribute<I extends Instance, Value extends Object, Item extends Object> extends Attribute<I, Value, Item> {

	private static final Validation[] NO_VALIDATIONS = new Validation[0];
	
	private final String name;
	private final String id;
	private final Entity<I> entity;
	private final Class<Item> javaClassName;

	public final Map<String, Object> dataType = new LinkedHashMap<String, Object>();
	public TextTemplate question = null;
	public Deduction<Value> rule;
	public Deduction<Value> _default;
	public Deduction<Boolean> relevance;
	public Validation[] validations = NO_VALIDATIONS;
	public boolean multivalue;
	public boolean readOnly;
	private Field instanceField; 
	
	@Deprecated
	public SimpleAttribute(String name, Entity<I> entity, Class<Item> javaClassName, String instanceFieldName, Class<? extends Instance> instanceFieldClass) {
		this(null, name, entity, javaClassName, instanceFieldName, instanceFieldClass);
	}
	
	public SimpleAttribute(String id, String name, Entity<I> entity, Class<Item> javaClassName, String instanceFieldName, Class<? extends Instance> instanceFieldClass) {
		this.id = id;
		this.name = name;
		this.entity = entity;
		this.javaClassName = javaClassName;
		try {
			instanceField = instanceFieldClass.getDeclaredField(instanceFieldName);
			instanceField.setAccessible(true);
		} catch (Exception e) {
			throw new RuntimeException("Problem with field "+instanceFieldName+" from "+entity.getInstanceClass(), e);
		}
	}

	@Override
	public String getUniqueId() {
		return id;
	}

	@Override
	public Entity<I> getEntity() {
		return entity;
	}

	@Override
	public Class<Item> getJavaClassName() {
		return javaClassName;
	}

	@Override
	public TextTemplate getQuestion() {
		return question;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setQuestion(TextTemplate question) {
		this.question = question;
	}
	
	@Override
	public Map<String, Object> getDataType() {
		return dataType;
	}

	@Override
	public Validation[] getValidations() {
		return validations;
	}

	@Override
	public boolean isMultivalue() {
		return multivalue;
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
			ReadOnlyAttributeValue<I, Value> result = (ReadOnlyAttributeValue<I, Value>) instanceField.get(instance);
			if (result==null) throw new IllegalStateException();
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
