package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DestinationDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DestinationDesign> {

	public static final DestinationDesignEntity INSTANCE = new DestinationDesignEntity();
	

	
	// Deductions

	
	// Attributes
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DestinationDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign> PlaceTemplate;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DestinationDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign> destinationOnFragmentTemplateDesign;

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DestinationDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign> $PlaceTemplate
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DestinationDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign>(
				"avqpegEnte_osmph_73500193_ff7a", "PlaceTemplate", INSTANCE, "PlaceTemplate", org.instantlogic.designer.DestinationDesign.class);
		PlaceTemplate = $PlaceTemplate;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DestinationDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign> $destinationOnFragmentTemplateDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DestinationDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign>(
				"imrshdqayIg_a_rf_ae2137d1_f648", "destinationOnFragmentTemplateDesign", INSTANCE, "destinationOnFragmentTemplateDesign", org.instantlogic.designer.DestinationDesign.class);
		destinationOnFragmentTemplateDesign = $destinationOnFragmentTemplateDesign;
		
		// Phase 2

		$PlaceTemplate.valueClass = org.instantlogic.designer.PlaceTemplateDesign.class;
		$PlaceTemplate.to = org.instantlogic.designer.entity.PlaceTemplateDesignEntity.INSTANCE;
		$PlaceTemplate.setReverseRelation(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.incomingLinks);

		$destinationOnFragmentTemplateDesign.reverse = true;
		$destinationOnFragmentTemplateDesign.valueClass = org.instantlogic.designer.FragmentTemplateDesign.class;
		$destinationOnFragmentTemplateDesign.to = org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE;
		$destinationOnFragmentTemplateDesign.setReverseRelation(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.destination);
	}

	@Override
	public org.instantlogic.designer.DestinationDesign createInstance() {
		return new org.instantlogic.designer.DestinationDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.DestinationDesign> getInstanceClass() {
		return org.instantlogic.designer.DestinationDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "ZErmAjEahigfIcAq_bd9ee49e_d638";
	}
	
	@Override
	public String getName() {
		return "DestinationDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		PlaceTemplate,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		destinationOnFragmentTemplateDesign,
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
	public java.util.Map<String, org.instantlogic.designer.DestinationDesign> getStaticInstances() {
		return org.instantlogic.designer.DestinationDesign.getStaticDestinationDesignInstances();
	}
}
