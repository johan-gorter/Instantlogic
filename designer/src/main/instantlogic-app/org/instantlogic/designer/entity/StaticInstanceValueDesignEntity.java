package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class StaticInstanceValueDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.StaticInstanceValueDesign> {

	public static final StaticInstanceValueDesignEntity INSTANCE = new StaticInstanceValueDesignEntity();
	

	
	// Deductions

	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.StaticInstanceValueDesign, java.lang.Object, java.lang.Object> value; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.StaticInstanceValueDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> attribute;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.StaticInstanceValueDesign, org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.StaticInstanceDesign> relationValue;
	
	// Reverse relations

	static {
		// Phase 1
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.StaticInstanceValueDesign, java.lang.Object, java.lang.Object> $value
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.StaticInstanceValueDesign, java.lang.Object, java.lang.Object>(
				"value", INSTANCE, java.lang.Object.class, "value", org.instantlogic.designer.StaticInstanceValueDesign.class);
		value = $value;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StaticInstanceValueDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> $attribute
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StaticInstanceValueDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
				"attribute", INSTANCE, "attribute", org.instantlogic.designer.StaticInstanceValueDesign.class);
		attribute = $attribute;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StaticInstanceValueDesign, org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.StaticInstanceDesign> $relationValue
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StaticInstanceValueDesign, org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.StaticInstanceDesign>(
				"relationValue", INSTANCE, "relationValue", org.instantlogic.designer.StaticInstanceValueDesign.class);
		relationValue = $relationValue;
		// Phase "reverse relations"
		
		// Phase 2

		$attribute.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$attribute.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$relationValue.valueClass = org.instantlogic.designer.StaticInstanceDesign.class;
		$relationValue.to = org.instantlogic.designer.entity.StaticInstanceDesignEntity.INSTANCE;
		$relationValue.setReverseRelation(org.instantlogic.designer.entity.StaticInstanceDesignEntity.valueOfStaticInstances);

	}

	@Override
	public org.instantlogic.designer.StaticInstanceValueDesign createInstance() {
		return new org.instantlogic.designer.StaticInstanceValueDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.StaticInstanceValueDesign> getInstanceClass() {
		return org.instantlogic.designer.StaticInstanceValueDesign.class;
	}
	
	@Override
	public String getName() {
		return "StaticInstanceValueDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		value,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		attribute,
		relationValue,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
	};
	private static final org.instantlogic.fabric.model.Validation[] VALIDATIONS = new org.instantlogic.fabric.model.Validation[]{
	};

	@Override
	public org.instantlogic.fabric.model.Attribute[] getLocalAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public org.instantlogic.fabric.model.Relation[] getLocalRelations() {
		return RELATIONS;
	}

	@Override
	public org.instantlogic.fabric.model.Relation[] getLocalReverseRelations() {
		return REVERSE_RELATIONS;
	}
	@Override
	public org.instantlogic.fabric.model.Validation[] getLocalValidations() {
		return VALIDATIONS;
	}
	
	@Override
	public java.util.Map<String, org.instantlogic.designer.StaticInstanceValueDesign> getStaticInstances() {
		return org.instantlogic.designer.StaticInstanceValueDesign.getStaticStaticInstanceValueDesignInstances();
	}
}
