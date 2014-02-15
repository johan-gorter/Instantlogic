package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class FragmentTemplateValueDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.FragmentTemplateValueDesign> {

	public static final FragmentTemplateValueDesignEntity INSTANCE = new FragmentTemplateValueDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE;
	}

	
	// Deductions

	
	// Attributes
	
	// Relations
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateValueDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign> valuesOnFragmentTemplateDesign;

	static {
		// Phase 1
		// Attributes
		// Relations
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateValueDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign> $valuesOnFragmentTemplateDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateValueDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign>(
				"RelationDesign_values", "valuesOnFragmentTemplateDesign", INSTANCE, "valuesOnFragmentTemplateDesign", org.instantlogic.designer.FragmentTemplateValueDesign.class);
		valuesOnFragmentTemplateDesign = $valuesOnFragmentTemplateDesign;
		
		// Phase 2


		$valuesOnFragmentTemplateDesign.reverse = true;
		$valuesOnFragmentTemplateDesign.valueClass = org.instantlogic.designer.FragmentTemplateDesign.class;
		$valuesOnFragmentTemplateDesign.to = org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE;
		$valuesOnFragmentTemplateDesign.setReverseRelation(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.values);
	}

	@Override
	public org.instantlogic.designer.FragmentTemplateValueDesign createInstance() {
		return new org.instantlogic.designer.FragmentTemplateValueDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.FragmentTemplateValueDesign> getInstanceClass() {
		return org.instantlogic.designer.FragmentTemplateValueDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "EntityDesign_FragmentTemplateValueDesign";
	}
	
	@Override
	public String getName() {
		return "FragmentTemplateValueDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		valuesOnFragmentTemplateDesign,
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
	public java.util.Map<String, org.instantlogic.designer.FragmentTemplateValueDesign> getStaticInstances() {
		return org.instantlogic.designer.FragmentTemplateValueDesign.getStaticFragmentTemplateValueDesignInstances();
	}
}
