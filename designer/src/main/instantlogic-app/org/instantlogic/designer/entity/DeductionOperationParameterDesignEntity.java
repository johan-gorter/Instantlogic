package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DeductionOperationParameterDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DeductionOperationParameterDesign> {

	public static final DeductionOperationParameterDesignEntity INSTANCE = new DeductionOperationParameterDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	
	// Deductions

	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionOperationParameterDesign, java.lang.String, java.lang.String> valueClass; 
	
	// Relations
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionOperationParameterDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign> operation;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionOperationParameterDesign, java.lang.String, java.lang.String> $valueClass
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionOperationParameterDesign, java.lang.String, java.lang.String>(
				"Attributedesign__0014", "valueClass", INSTANCE, java.lang.String.class, "valueClass", org.instantlogic.designer.DeductionOperationParameterDesign.class);
		valueClass = $valueClass;
		// Relations
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationParameterDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign> $operation
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationParameterDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign>(
				"Relationdesign__001b", "operation", INSTANCE, "operation", org.instantlogic.designer.DeductionOperationParameterDesign.class);
		operation = $operation;
		
		// Phase 2
		$valueClass.dataType.put("category", "text");


		$operation.reverse = true;
		$operation.valueClass = org.instantlogic.designer.DeductionOperationDesign.class;
		$operation.to = org.instantlogic.designer.entity.DeductionOperationDesignEntity.INSTANCE;
		$operation.setReverseRelation(org.instantlogic.designer.entity.DeductionOperationDesignEntity.parameters);
	}

	@Override
	public org.instantlogic.designer.DeductionOperationParameterDesign createInstance() {
		return new org.instantlogic.designer.DeductionOperationParameterDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.DeductionOperationParameterDesign> getInstanceClass() {
		return org.instantlogic.designer.DeductionOperationParameterDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "Entitydesign__0015";
	}
	
	@Override
	public String getName() {
		return "DeductionOperationParameterDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		valueClass,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		operation,
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
	public java.util.Map<String, org.instantlogic.designer.DeductionOperationParameterDesign> getStaticInstances() {
		return org.instantlogic.designer.DeductionOperationParameterDesign.getStaticDeductionOperationParameterDesignInstances();
	}
}
