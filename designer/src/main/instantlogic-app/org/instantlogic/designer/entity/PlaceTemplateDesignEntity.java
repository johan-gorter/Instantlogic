package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class PlaceTemplateDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.PlaceTemplateDesign> {

	public static final PlaceTemplateDesignEntity INSTANCE = new PlaceTemplateDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE;
	}

	
	// Deductions

	
	// Attributes
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.ElementDesign, org.instantlogic.designer.ElementDesign> content;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> title;
	
	// Reverse relations

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.ElementDesign, org.instantlogic.designer.ElementDesign> $content
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.ElementDesign, org.instantlogic.designer.ElementDesign>(
				"KltgvgzezebwkmdE_acaa2c56_3f2a", "content", INSTANCE, "content", org.instantlogic.designer.AbstractPlaceTemplateDesign.class);
		content = $content;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> $title
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign>(
				"_zbnxtdcpiaxqnUu_71e029b7_b81c", "title", INSTANCE, "title", org.instantlogic.designer.AbstractPlaceTemplateDesign.class);
		title = $title;
		// Reverse relations
		
		// Phase 2

		$content.valueClass = org.instantlogic.designer.ElementDesign.class;
		$content.to = org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE;
		$content.setReverseRelation(org.instantlogic.designer.entity.ElementDesignEntity.contentOfPage);
		$content.owner = true;
		$title.valueClass = org.instantlogic.designer.TextTemplateDesign.class;
		$title.to = org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE;
		$title.setReverseRelation(org.instantlogic.designer.entity.TextTemplateDesignEntity.titleOfPlaceTemplate);
		$title.owner = true;

	}

	@Override
	public org.instantlogic.designer.PlaceTemplateDesign createInstance() {
		return new org.instantlogic.designer.PlaceTemplateDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.PlaceTemplateDesign> getInstanceClass() {
		return org.instantlogic.designer.PlaceTemplateDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "DpnuOOxfOabAidbo_a745d7f7_a686";
	}
	
	@Override
	public String getName() {
		return "PlaceTemplateDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		content,
		title,
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
	public java.util.Map<String, org.instantlogic.designer.PlaceTemplateDesign> getStaticInstances() {
		return org.instantlogic.designer.PlaceTemplateDesign.getStaticPlaceTemplateDesignInstances();
	}
}
