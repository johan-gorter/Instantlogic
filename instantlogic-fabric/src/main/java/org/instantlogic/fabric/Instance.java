package org.instantlogic.fabric;

import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.text.TextTemplate;
import org.instantlogic.fabric.util.AbstractDeductionContext;
import org.instantlogic.fabric.util.InstanceMetadata;
import org.instantlogic.fabric.util.SingleInstanceDeductionContext;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.AttributeValueList;
import org.instantlogic.fabric.value.AttributeValues;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;
import org.instantlogic.fabric.value.RelationValue;
import org.instantlogic.fabric.value.RelationValueList;
import org.instantlogic.fabric.value.RelationValues;
import org.instantlogic.fabric.value.ValueList;
import org.instantlogic.fabric.value.Values;
import org.instantlogic.fabric.value.impl.AttributeValueImpl;
import org.instantlogic.fabric.value.impl.AttributeValueListImpl;
import org.instantlogic.fabric.value.impl.AttributeValuesImpl;
import org.instantlogic.fabric.value.impl.ReadOnlyAttributeValueImpl;
import org.instantlogic.fabric.value.impl.ReadOnlyRelationValueImpl;
import org.instantlogic.fabric.value.impl.RelationValueImpl;
import org.instantlogic.fabric.value.impl.RelationValueListImpl;
import org.instantlogic.fabric.value.impl.RelationValuesImpl;
import org.instantlogic.fabric.value.impl.ReverseRelationValueImpl;
import org.instantlogic.fabric.value.impl.ReverseRelationValuesImpl;

/**
 * Can be compared to a class, only more powerful.
 * 
 * Note that an instance should always have an owner. the root of this owner hierarchy is called the case.
 */
public abstract class Instance implements Comparable<Instance> {

	private final InstanceMetadata metadata;
	
	protected abstract Entity<?> getInstanceEntity();
	
	protected Instance() {
		metadata = new InstanceMetadata(this, getInstanceEntity());
	}

	@SuppressWarnings("unchecked")
	protected<Value extends Object, I extends Instance> ReadOnlyAttributeValue<I, Value> createReadOnlyAttributeValue(Attribute<I, Value, Value> attribute) {
		return new ReadOnlyAttributeValueImpl<I, Value>((I)this, attribute);
	}
	
	@SuppressWarnings("unchecked")
	protected<Value extends Object, I extends Instance> AttributeValue<I, Value> createAttributeValue(Attribute<I, Value, Value> attribute) {
		return new AttributeValueImpl<I, Value>((I)this, attribute);
	}
	
	@SuppressWarnings("unchecked")
	protected<Value extends Object, I extends Instance> AttributeValueList<I, Value> createAttributeValueList(Attribute<I, ValueList<Value>, Value> attribute) {
		return new AttributeValueListImpl<I, Value>((I)this, attribute);
	}

	@SuppressWarnings("unchecked")
	protected<Value extends Object, I extends Instance> AttributeValues<I, Value> createAttributeValues(Attribute<I, Values<Value>, Value> attribute) {
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
	protected<To extends Instance, I extends Instance> RelationValueList<I, To> createRelationValueList(Relation<I, ValueList<To>, To> relation) {
		return new RelationValueListImpl<I, To>((I)this, relation);
	}

	@SuppressWarnings("unchecked")
	protected<To extends Instance, I extends Instance> RelationValues<I, To> createRelationValues(Relation<I, Values<To>, To> relation) {
		return new RelationValuesImpl<I, To>((I)this, relation);
	}

	
	@SuppressWarnings("unchecked")
	protected<To extends Instance, I extends Instance> RelationValue<I, To> createReverseRelationValue(Relation<I, To, To> relation) {
		return new ReverseRelationValueImpl<I, To>((I)this, relation);
	}
	
	@SuppressWarnings("unchecked")
	protected<To extends Instance, I extends Instance> RelationValues<I, To> createReverseRelationValues(Relation<I, Values<To>, To> relation) {
		return new ReverseRelationValuesImpl<I, To>((I)this, relation);
	}
	
	@Override
	public String toString() {
		String suffix = "";
		Entity<?> entity = getMetadata().getEntity();
		while (entity.getTitle()==null && entity.extendsEntity()!=null) {
			entity = entity.extendsEntity();
		}
		TextTemplate title = entity.getTitle();
		if (title!=null) {
			SingleInstanceDeductionContext context = new SingleInstanceDeductionContext(this);
			suffix = " ("+title.renderText(context)+")";
		}
		String uniqueId = getMetadata().getUniqueIdIfInitialized();
		if (uniqueId==null) uniqueId="Anonymous";
		return getInstanceEntity().toString()+"#"+uniqueId+suffix;
	}
	
	public String renderTitle(AbstractDeductionContext context) {
		Entity<?> entity = getMetadata().getEntity();
		while (entity.getTitle()==null && entity.extendsEntity()!=null) {
			entity = entity.extendsEntity();
		}
		TextTemplate title = entity.getTitle();
		if (title==null) return null;
		try {
			context.pushSelectedInstance(this, "instance");
			return title.renderText(context);
		} finally {
			context.popSelectedInstance(this);
		}
	}

	public String renderTitle() {
		Entity<?> entity = getMetadata().getEntity();
		while (entity.getTitle()==null && entity.extendsEntity()!=null) {
			entity = entity.extendsEntity();
		}
		TextTemplate title = entity.getTitle();
		if (title==null) return getMetadata().getUniqueId();
		SingleInstanceDeductionContext context = new SingleInstanceDeductionContext(this);
		return title.renderText(context);
	}


	/**
	 * Suggestions for a better name: getInstanceOptions, getInstanceOperations, getInstanceData, instance(), asInstance() ...
	 */
	public InstanceMetadata getMetadata() {
		return metadata;
	}
	
	public void detach() {
		metadata.detach();
	}
	
	// compareTo, equals and hashcode are based on the uniqueId
	
	public int compareTo(Instance other) {
		return metadata.getUniqueId().compareTo(other.metadata.getUniqueId());
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj == this;
	}
	
	@Override
	public int hashCode() {
		return metadata.getUniqueId().hashCode();
	}
}
