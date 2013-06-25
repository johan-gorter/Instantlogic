package org.instantlogic.fabric.model;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.text.TextTemplate;


/**
 * Can be compared to a Class, only more powerful
 */
public abstract class Entity<I extends Instance> extends Concept {

	private static final Entity<?>[] NO_ENTITIES = new Entity[0];

	public static boolean extendsFrom(Entity<?> entity, Entity<?> from) {
		if (entity==from) return true;
		if (entity==null) return false;
		return extendsFrom(entity.extendsEntity(), from);
	}
	
	private static class BaseEntityFirstIterable<E> implements Iterable<E> {

		private Iterable<E> baseEntityIterator;
		private E[] items;
		
		public BaseEntityFirstIterable(Iterable<E> baseEntityIterator, E[] items) {
			this.baseEntityIterator = baseEntityIterator;
			this.items = items;
		}

		@Override
		public Iterator<E> iterator() {
			return new BaseEntityFirstIterator<E>(baseEntityIterator, items);
		}
	}
	
	private static class  BaseEntityFirstIterator<E> implements Iterator<E> {

		private Iterator<E> baseEntityIterator;
		private E[] items;
		private int index = 0;
		
		public BaseEntityFirstIterator(Iterable<E> baseEntityIterator, E[] items) {
			if (baseEntityIterator!=null) {
				this.baseEntityIterator = baseEntityIterator.iterator();
			}
			this.items = items;
		}

		@Override
		public boolean hasNext() {
			if (baseEntityIterator!=null) {
				boolean hasNext = baseEntityIterator.hasNext();
				if (hasNext) {
					return true;
				} else {
					baseEntityIterator = null;
				}
			}
			return index<items.length;
		}

		@Override
		public E next() {
			if (baseEntityIterator!=null) {
				return baseEntityIterator.next();
			}
			return items[index++];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Not implemented");
		}
	}
	private final TextTemplate defaultTitle = new TextTemplate().getUntranslated().add(getName()).getTextTemplate();
	
	public TextTemplate getTitle() {
		return defaultTitle;
	}
	
	// TODO: Allow multiple inheritance (Java code generation: generate Instance classes + interfaces and implement all baseclass-interfaces instead of extending baseclass)
	public Entity<?> extendsEntity() {
		return null;
	}

	public Entity<?>[] extensions() {
		return NO_ENTITIES;
	}
	
	public abstract Attribute<I, ? extends Object, ? extends Object>[] getLocalAttributes();
	
	public abstract Relation<I, ? extends Object, ? extends Instance>[] getLocalRelations();

	public abstract Relation<? extends Instance, ? extends Object, I>[] getLocalReverseRelations();
	
	public Validation[] getLocalValidations() { // TODO: make abstract
		return new Validation[0];
	}

	public abstract I createInstance();
	
	public abstract Class<I> getInstanceClass();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final Iterable<Attribute<I, ? extends Object, ? extends Object>> getAttributes() {
		Entity<?> extendsEntity = extendsEntity();
		Iterable<?> baseEntityIterator=null;
		if (extendsEntity!=null) {
			baseEntityIterator = (Iterable<?>)extendsEntity.getAttributes();
		}
		return new BaseEntityFirstIterable(baseEntityIterator, getLocalAttributes());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public final Iterable<Relation<I, ? extends Object, ? extends Instance>> getRelations() {
		Entity<?> extendsEntity = extendsEntity();
		Iterable<?> baseEntityIterator=null;
		if (extendsEntity!=null) {
			baseEntityIterator = (Iterable<?>)extendsEntity.getRelations();
		}
		return new BaseEntityFirstIterable(baseEntityIterator, getLocalRelations());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public final Iterable<Relation<? extends Instance, ? extends Object, I>> getReverseRelations() {
		Entity<?> extendsEntity = extendsEntity();
		Iterable<?> baseEntityIterator=null;
		if (extendsEntity!=null) {
			baseEntityIterator = extendsEntity.getReverseRelations();
		}
		return new BaseEntityFirstIterable(baseEntityIterator, getLocalReverseRelations());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final Iterable<Validation> getValidations() {
		Entity<?> extendsEntity = extendsEntity();
		Iterable<?> baseEntityIterator=null;
		if (extendsEntity!=null) {
			baseEntityIterator = (Iterable<?>)extendsEntity.getValidations();
		}
		return new BaseEntityFirstIterable(baseEntityIterator, getLocalValidations());
	}
	
	protected I addStaticInstance(String name, I instance) {
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, I> getStaticInstances() {
		return Collections.EMPTY_MAP;
	}

	// Convenience method for obtaining an attribute
	@SuppressWarnings("rawtypes")
	public Attribute getAttribute(String attributeName) {
		for (Attribute attribute: getAttributes()) {
			if (attributeName.equals(attribute.getName())) {
				return attribute;
			}
		}
		throw new NoSuchElementException(attributeName);
	}

	// Convenience method for obtaining an attribute
	@SuppressWarnings("rawtypes")
	public Relation getRelation(String relationName) {
		for (Relation relation: getRelations()) {
			if (relationName.equals(relation.getName())) {
				return relation;
			}
		}
		throw new NoSuchElementException(relationName);
	}
	
	@SuppressWarnings("rawtypes")
	public Attribute getAttributeOrRelation(String name) {
		for (Attribute attribute: getLocalAttributes()) {
			if (name.equals(attribute.getName())) {
				return attribute;
			}
		}
		for (Attribute attribute: getLocalRelations()) {
			if (name.equals(attribute.getName())) {
				return attribute;
			}
		}
		for (Attribute attribute: getLocalReverseRelations()) {
			if (name.equals(attribute.getName())) {
				return attribute;
			}
		}
		if (extendsEntity()!=null) {
			return extendsEntity().getAttributeOrRelation(name);
		}
		throw new NoSuchElementException(name);
	}	
	
	@SuppressWarnings("rawtypes")
	public Attribute getAttributeOrRelationById(String id) {
		for (Attribute attribute: getLocalAttributes()) {
			if (id.equals(attribute.getUniqueId())) {
				return attribute;
			}
		}
		for (Attribute attribute: getLocalRelations()) {
			if (id.equals(attribute.getUniqueId())) {
				return attribute;
			}
		}
		for (Attribute attribute: getLocalReverseRelations()) {
			if (id.equals(attribute.getUniqueId())) {
				return attribute;
			}
		}
		if (extendsEntity()!=null) {
			return extendsEntity().getAttributeOrRelationById(id);
		}
		throw new NoSuchElementException(id);
	}

	@SuppressWarnings("rawtypes")
	public Relation getRelationById(String relationId) {
		for (Relation relation: getRelations()) {
			if (relationId.equals(relation.getUniqueId())) {
				return relation;
			}
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	public Attribute getAttributeById(String attributeId) {
		for (Attribute attribute: getAttributes()) {
			if (attributeId.equals(attribute.getUniqueId())) {
				return attribute;
			}
		}
		return null;
	}
}
