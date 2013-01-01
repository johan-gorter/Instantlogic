package org.instantlogic.fabric.model.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.text.TextTemplate;


public abstract class SimpleAttribute<I extends Instance, Value extends Object, Item extends Object> extends Attribute<I, Value, Item> {

	private final String name;
	private final Entity<I> entity;
	private final Class<Item> javaClassName;
	protected final Map<String, Object> dataType = new LinkedHashMap<String, Object>();
	private TextTemplate question = null;
	
	public SimpleAttribute(String name, Entity<I> entity, Class<Item> javaClassName) {
		this.name = name;
		this.entity = entity;
		this.javaClassName = javaClassName;
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
}
