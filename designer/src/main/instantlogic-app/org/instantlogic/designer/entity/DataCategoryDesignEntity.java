package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DataCategoryDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DataCategoryDesign> {

	public static final DataCategoryDesignEntity INSTANCE = new DataCategoryDesignEntity();
	

	
	// Deductions

	
	// Attributes
	
	// Relations
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataCategoryDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> dataCategoryOnDataTypeDesign;

	static {
		// Phase 1
		// Attributes
		// Relations
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataCategoryDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> $dataCategoryOnDataTypeDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataCategoryDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
				"HlxAieAgiybdIgyr_afb6f13f_b418", "dataCategoryOnDataTypeDesign", INSTANCE, "dataCategoryOnDataTypeDesign", org.instantlogic.designer.DataCategoryDesign.class);
		dataCategoryOnDataTypeDesign = $dataCategoryOnDataTypeDesign;
		
		// Phase 2


		$dataCategoryOnDataTypeDesign.reverse = true;
		$dataCategoryOnDataTypeDesign.valueClass = org.instantlogic.designer.DataTypeDesign.class;
		$dataCategoryOnDataTypeDesign.to = org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE;
		$dataCategoryOnDataTypeDesign.setReverseRelation(org.instantlogic.designer.entity.DataTypeDesignEntity.dataCategory);
	}

	@Override
	public org.instantlogic.designer.DataCategoryDesign createInstance() {
		return new org.instantlogic.designer.DataCategoryDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.DataCategoryDesign> getInstanceClass() {
		return org.instantlogic.designer.DataCategoryDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "LudtEqcewefnccdu_e01c62e8_2c13";
	}
	
	@Override
	public String getName() {
		return "DataCategoryDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		dataCategoryOnDataTypeDesign,
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
	public java.util.Map<String, org.instantlogic.designer.DataCategoryDesign> getStaticInstances() {
		return org.instantlogic.designer.DataCategoryDesign.getStaticDataCategoryDesignInstances();
	}
}
