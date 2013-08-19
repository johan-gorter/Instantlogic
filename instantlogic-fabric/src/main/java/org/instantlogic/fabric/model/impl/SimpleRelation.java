package org.instantlogic.fabric.model.impl;

import java.lang.reflect.Field;
import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.model.Validation;
import org.instantlogic.fabric.text.TextTemplate;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;


public class SimpleRelation<I extends Instance, Value extends Object, To extends Instance> extends Relation<I, Value, To> {

	private final String id;
	private final String name;
	private final Entity<I> entity;
	private Field instanceField;

	public Class<To> valueClass;
	public Entity<To> to;
	public Relation<To, ? extends Object,I> reverseRelation;
	public boolean owner;
	public boolean autoCreate;
	public boolean multivalue;
	public boolean ordered;
	public boolean reverse;
	public Validation[] validations;
	public Map<String, Object> dataType;
	public boolean readOnly;
	public Deduction<Boolean> relevance;
	public Deduction<Value> rule;
	public Deduction<Value> _default;
	public TextTemplate question;
	public Deduction<? extends Iterable<To>> options; 

	@Deprecated
	public SimpleRelation(String name, Entity<I> entity, String instanceFieldName, Class<? extends Instance> instanceFieldClass) {
		this(null, name, entity, instanceFieldName, instanceFieldClass);
	}
	
	public SimpleRelation(String id, String name, Entity<I> entity, String instanceFieldName, Class<? extends Instance> instanceFieldClass) {
		this.id = id;
		this.name = name;
		this.entity = entity;
		try {
			instanceField = instanceFieldClass.getDeclaredField(instanceFieldName);
			instanceField.setAccessible(true);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String getUniqueId() {
		return id;
	};

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
		if (reverse==null)
			throw new IllegalArgumentException();
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
			ReadOnlyAttributeValue<I, Value> result = (ReadOnlyAttributeValue<I, Value>) instanceField.get(instance);
			if (result==null) throw new IllegalStateException();
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	@Override
	public TextTemplate getQuestion() {
		return question;
	}


	@Override
	public Deduction<? extends Iterable<To>> getOptions() {
		return options;
	}

	@Override
	public boolean isOrderedMultivalue() {
		return ordered && multivalue;
	}
}
