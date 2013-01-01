package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class ConstantDeductionDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.ConstantDeductionDesign> {

	public static final ConstantDeductionDesignEntity INSTANCE = new ConstantDeductionDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
	}

	
	@Override
	public org.instantlogic.designer.ConstantDeductionDesign createInstance() {
		return new org.instantlogic.designer.ConstantDeductionDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.ConstantDeductionDesign> getInstanceClass() {
		return org.instantlogic.designer.ConstantDeductionDesign.class;
	}
	
	@Override
	public String getName() {
		return "ConstantDeductionDesign";
	}

	// Deductions

	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ConstantDeductionDesign, java.lang.Object, java.lang.Object> value 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ConstantDeductionDesign, java.lang.Object, java.lang.Object>(
			"value", INSTANCE, java.lang.Object.class
		) {
			{
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.ConstantDeductionDesign, java.lang.Object> get(org.instantlogic.designer.ConstantDeductionDesign instance) {
				return instance.getValueAttributeValue();
			}
            
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ConstantDeductionDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> constantDataType
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ConstantDeductionDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
			"constantDataType", INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.DataTypeDesign.class, 
			org.instantlogic.designer.entity.DataTypeDesignEntity.constantDeductionDesign
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.ConstantDeductionDesign, org.instantlogic.designer.DataTypeDesign> get(
					org.instantlogic.designer.ConstantDeductionDesign instance) {
				return instance.getConstantDataTypeRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
		};
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		value,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		constantDataType,
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
	public java.util.Map<String, org.instantlogic.designer.ConstantDeductionDesign> getStaticInstances() {
		return org.instantlogic.designer.ConstantDeductionDesign.getStaticConstantDeductionDesignInstances();
	}
}
