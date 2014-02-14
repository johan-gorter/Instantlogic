package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class FragmentTemplateTextDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.FragmentTemplateTextDesign> {

	public static final FragmentTemplateTextDesignEntity INSTANCE = new FragmentTemplateTextDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE;
	}

	
	// Deductions

	
	// Attributes
	
	// Relations
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateTextDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign> fragmentTemplateDesign;

	static {
		// Phase 1
		// Attributes
		// Relations
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateTextDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign> $fragmentTemplateDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateTextDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign>(
				"DrvmanhvIqdmkhEe_cb506554_d6d4", "fragmentTemplateDesign", INSTANCE, "fragmentTemplateDesign", org.instantlogic.designer.FragmentTemplateTextDesign.class);
		fragmentTemplateDesign = $fragmentTemplateDesign;
		
		// Phase 2


		$fragmentTemplateDesign.reverse = true;
		$fragmentTemplateDesign.valueClass = org.instantlogic.designer.FragmentTemplateDesign.class;
		$fragmentTemplateDesign.to = org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE;
		$fragmentTemplateDesign.setReverseRelation(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.texts);
	}

	@Override
	public org.instantlogic.designer.FragmentTemplateTextDesign createInstance() {
		return new org.instantlogic.designer.FragmentTemplateTextDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.FragmentTemplateTextDesign> getInstanceClass() {
		return org.instantlogic.designer.FragmentTemplateTextDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "ScIfIb_fbadEkoIh_e27989e8_5734";
	}
	
	@Override
	public String getName() {
		return "FragmentTemplateTextDesign";
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
	public java.util.Map<String, org.instantlogic.designer.FragmentTemplateTextDesign> getStaticInstances() {
		return org.instantlogic.designer.FragmentTemplateTextDesign.getStaticFragmentTemplateTextDesignInstances();
	}
}
