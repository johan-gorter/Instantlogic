package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class StaticInstanceValueDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.StaticInstanceValueDesign> {

	public static final StaticInstanceValueDesignEntity INSTANCE = new StaticInstanceValueDesignEntity();
	

	
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

	// Deductions

	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.StaticInstanceValueDesign, java.lang.Object, java.lang.Object> value 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.StaticInstanceValueDesign, java.lang.Object, java.lang.Object>(
			"value", INSTANCE, java.lang.Object.class
		) {
			{
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.StaticInstanceValueDesign, java.lang.Object> get(org.instantlogic.designer.StaticInstanceValueDesign instance) {
				return instance.getValueAttributeValue();
			}
            
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.StaticInstanceValueDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> attribute
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StaticInstanceValueDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
			"attribute", INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.AttributeDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.StaticInstanceValueDesign, org.instantlogic.designer.AttributeDesign> get(
					org.instantlogic.designer.StaticInstanceValueDesign instance) {
				return instance.getAttributeRelationValue();
			}
		};
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		value,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		attribute,
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
