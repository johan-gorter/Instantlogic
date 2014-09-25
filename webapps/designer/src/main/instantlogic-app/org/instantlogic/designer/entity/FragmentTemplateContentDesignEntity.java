package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class FragmentTemplateContentDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.FragmentTemplateContentDesign> {

	public static final FragmentTemplateContentDesignEntity INSTANCE = new FragmentTemplateContentDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE;
	}

	
	// Deductions

	
	// Attributes
	
	// Relations
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateContentDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign> fragmentTemplateDesign;

	static {
		// Phase 1
		// Attributes
		// Relations
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateContentDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign> $fragmentTemplateDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateContentDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign>(
				"reverse-RelationDesign_contents", "fragmentTemplateDesign", INSTANCE, "fragmentTemplateDesign", org.instantlogic.designer.FragmentTemplateContentDesign.class);
		fragmentTemplateDesign = $fragmentTemplateDesign;
		
		// Phase 2


		$fragmentTemplateDesign.reverse = true;
		$fragmentTemplateDesign.valueClass = org.instantlogic.designer.FragmentTemplateDesign.class;
		$fragmentTemplateDesign.to = org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE;
		$fragmentTemplateDesign.setReverseRelation(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.contents);
	}

	@Override
	public org.instantlogic.designer.FragmentTemplateContentDesign createInstance() {
		return new org.instantlogic.designer.FragmentTemplateContentDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.FragmentTemplateContentDesign> getInstanceClass() {
		return org.instantlogic.designer.FragmentTemplateContentDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "EntityDesign_FragmentTemplateContentDesign";
	}
	
	@Override
	public String getName() {
		return "FragmentTemplateContentDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		fragmentTemplateDesign,
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
	public java.util.Map<String, org.instantlogic.designer.FragmentTemplateContentDesign> getStaticInstances() {
		return org.instantlogic.designer.FragmentTemplateContentDesign.getStaticFragmentTemplateContentDesignInstances();
	}
}
