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
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.PlaceParameterDesign>, org.instantlogic.designer.PlaceParameterDesign> parameters;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> application;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> loggedInPlaceOnApplicationDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign> incomingLinksFromFragmentTemplates;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> startPlaceOnApplication;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DestinationDesign>, org.instantlogic.designer.DestinationDesign> incomingLinks;

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
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.PlaceParameterDesign>, org.instantlogic.designer.PlaceParameterDesign> $parameters
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.PlaceParameterDesign>, org.instantlogic.designer.PlaceParameterDesign>(
				"iutfOibjcIcoafjm_2852f3ef_662a", "parameters", INSTANCE, "parameters", org.instantlogic.designer.AbstractPlaceTemplateDesign.class);
		parameters = $parameters;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> $application
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
				"IeIasvhvnm_lqlww_e8627169_003f", "application", INSTANCE, "application", org.instantlogic.designer.AbstractPlaceTemplateDesign.class);
		application = $application;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> $loggedInPlaceOnApplicationDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
				"MjgOujqxzidxulUp_c10e22ff_3f1b", "loggedInPlaceOnApplicationDesign", INSTANCE, "loggedInPlaceOnApplicationDesign", org.instantlogic.designer.AbstractPlaceTemplateDesign.class);
		loggedInPlaceOnApplicationDesign = $loggedInPlaceOnApplicationDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign> $incomingLinksFromFragmentTemplates
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign>(
				"NzOgiyu_Uaftialv_2536eadf_ad0f", "incomingLinksFromFragmentTemplates", INSTANCE, "incomingLinksFromFragmentTemplates", org.instantlogic.designer.AbstractPlaceTemplateDesign.class);
		incomingLinksFromFragmentTemplates = $incomingLinksFromFragmentTemplates;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> $startPlaceOnApplication
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
				"Rlreusummyeemjut_838db6d5_b94d", "startPlaceOnApplication", INSTANCE, "startPlaceOnApplication", org.instantlogic.designer.AbstractPlaceTemplateDesign.class);
		startPlaceOnApplication = $startPlaceOnApplication;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DestinationDesign>, org.instantlogic.designer.DestinationDesign> $incomingLinks
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DestinationDesign>, org.instantlogic.designer.DestinationDesign>(
				"avqpegEnte_osmph_73500193_ff7a", "incomingLinks", INSTANCE, "incomingLinks", org.instantlogic.designer.AbstractPlaceTemplateDesign.class);
		incomingLinks = $incomingLinks;
		
		// Phase 2

		$content.valueClass = org.instantlogic.designer.ElementDesign.class;
		$content.to = org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE;
		$content.setReverseRelation(org.instantlogic.designer.entity.ElementDesignEntity.contentOfPage);
		$content.owner = true;
		$title.valueClass = org.instantlogic.designer.TextTemplateDesign.class;
		$title.to = org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE;
		$title.setReverseRelation(org.instantlogic.designer.entity.TextTemplateDesignEntity.titleOfPlaceTemplate);
		$title.owner = true;
		$parameters.valueClass = org.instantlogic.designer.PlaceParameterDesign.class;
		$parameters.to = org.instantlogic.designer.entity.PlaceParameterDesignEntity.INSTANCE;
		$parameters.setReverseRelation(org.instantlogic.designer.entity.PlaceParameterDesignEntity.placeTemplateDesign);
		$parameters.owner = true;
		$parameters.multivalue = true;
		$parameters.ordered = true;

		$application.reverse = true;
		$application.valueClass = org.instantlogic.designer.ApplicationDesign.class;
		$application.to = org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
		$application.setReverseRelation(org.instantlogic.designer.entity.ApplicationDesignEntity.placeTemplates);
		$loggedInPlaceOnApplicationDesign.reverse = true;
		$loggedInPlaceOnApplicationDesign.valueClass = org.instantlogic.designer.ApplicationDesign.class;
		$loggedInPlaceOnApplicationDesign.to = org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
		$loggedInPlaceOnApplicationDesign.setReverseRelation(org.instantlogic.designer.entity.ApplicationDesignEntity.loggedInPlace);
		$incomingLinksFromFragmentTemplates.reverse = true;
		$incomingLinksFromFragmentTemplates.valueClass = org.instantlogic.designer.FragmentTemplateDesign.class;
		$incomingLinksFromFragmentTemplates.to = org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE;
		$incomingLinksFromFragmentTemplates.setReverseRelation(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.linkToPlaceTemplate);
		$incomingLinksFromFragmentTemplates.multivalue = true;
		$startPlaceOnApplication.reverse = true;
		$startPlaceOnApplication.valueClass = org.instantlogic.designer.ApplicationDesign.class;
		$startPlaceOnApplication.to = org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
		$startPlaceOnApplication.setReverseRelation(org.instantlogic.designer.entity.ApplicationDesignEntity.startPlace);
		$incomingLinks.reverse = true;
		$incomingLinks.valueClass = org.instantlogic.designer.DestinationDesign.class;
		$incomingLinks.to = org.instantlogic.designer.entity.DestinationDesignEntity.INSTANCE;
		$incomingLinks.setReverseRelation(org.instantlogic.designer.entity.DestinationDesignEntity.PlaceTemplate);
		$incomingLinks.multivalue = true;
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
		parameters,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		application,
		loggedInPlaceOnApplicationDesign,
		incomingLinksFromFragmentTemplates,
		startPlaceOnApplication,
		incomingLinks,
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
