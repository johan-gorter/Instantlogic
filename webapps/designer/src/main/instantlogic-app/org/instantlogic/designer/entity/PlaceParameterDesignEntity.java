package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class PlaceParameterDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.PlaceParameterDesign> {

	public static final PlaceParameterDesignEntity INSTANCE = new PlaceParameterDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	
	// Deductions

	
	// Attributes
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PlaceParameterDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> entity;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PlaceParameterDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign> placeTemplateDesign;

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PlaceParameterDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $entity
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PlaceParameterDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"RelationDesign_entity_2", "entity", INSTANCE, "entity", org.instantlogic.designer.PlaceParameterDesign.class);
		entity = $entity;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PlaceParameterDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign> $placeTemplateDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PlaceParameterDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign>(
				"reverse-RelationDesign_parameters_4", "placeTemplateDesign", INSTANCE, "placeTemplateDesign", org.instantlogic.designer.PlaceParameterDesign.class);
		placeTemplateDesign = $placeTemplateDesign;
		
		// Phase 2

		$entity.valueClass = org.instantlogic.designer.EntityDesign.class;
		$entity.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$entity.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.placeParameter);

		$placeTemplateDesign.reverse = true;
		$placeTemplateDesign.valueClass = org.instantlogic.designer.PlaceTemplateDesign.class;
		$placeTemplateDesign.to = org.instantlogic.designer.entity.PlaceTemplateDesignEntity.INSTANCE;
		$placeTemplateDesign.setReverseRelation(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.parameters);
	}

	@Override
	public org.instantlogic.designer.PlaceParameterDesign createInstance() {
		return new org.instantlogic.designer.PlaceParameterDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.PlaceParameterDesign> getInstanceClass() {
		return org.instantlogic.designer.PlaceParameterDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "EntityDesign_PlaceParameterDesign";
	}
	
	@Override
	public String getName() {
		return "PlaceParameterDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		entity,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		placeTemplateDesign,
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
	public java.util.Map<String, org.instantlogic.designer.PlaceParameterDesign> getStaticInstances() {
		return org.instantlogic.designer.PlaceParameterDesign.getStaticPlaceParameterDesignInstances();
	}
}
