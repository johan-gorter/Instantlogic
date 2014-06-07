package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class FragmentTemplateDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.FragmentTemplateDesign> {

	public static final FragmentTemplateDesignEntity INSTANCE = new FragmentTemplateDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE;
	}

	
	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DesignEntity.name);
		  	org.instantlogic.fabric.deduction.AttributeDeduction d1 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d1.setAttribute(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d2 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d2.setOfEntity(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		    d1.setInstance(d2);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.EntityDesignEntity.attributes);
		  	org.instantlogic.fabric.deduction.AttributeDeduction d1 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d1.setAttribute(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.entity);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d2 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d2.setOfEntity(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		    d1.setInstance(d2);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction2() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.ApplicationDesignEntity.entities);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction3() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.ApplicationDesignEntity.fragmentTypes);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	// Title
	private static final org.instantlogic.fabric.text.TextTemplate title;
	@Override
	public org.instantlogic.fabric.text.TextTemplate getTitle() {
		return title;
	}
	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.ValueList<java.lang.String>, java.lang.String> fragmentFilters; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FragmentTemplateDesign, java.lang.String, java.lang.String> fragmentTypeName; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Values<java.lang.String>, java.lang.String> styleNames; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> attribute;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.FragmentTemplateContentDesign>, org.instantlogic.designer.FragmentTemplateContentDesign> contents;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.DestinationDesign, org.instantlogic.designer.DestinationDesign> destination;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> entity;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> event;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign> linkToPlaceTemplate;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.FragmentTemplateTextDesign>, org.instantlogic.designer.FragmentTemplateTextDesign> texts;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.designer.FragmentTypeDesign> type;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.FragmentTemplateValueDesign>, org.instantlogic.designer.FragmentTemplateValueDesign> values;
	
	// Reverse relations

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.ValueList<java.lang.String>, java.lang.String> $fragmentFilters
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.ValueList<java.lang.String>, java.lang.String>(
				"AttributeDesign_fragmentFilters", "fragmentFilters", INSTANCE, java.lang.String.class, "fragmentFilters", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		fragmentFilters = $fragmentFilters;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTemplateDesign, java.lang.String, java.lang.String> $fragmentTypeName
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTemplateDesign, java.lang.String, java.lang.String>(
				"AttributeDesign_fragmentTypeName", "fragmentTypeName", INSTANCE, java.lang.String.class, "fragmentTypeName", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		fragmentTypeName = $fragmentTypeName;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Values<java.lang.String>, java.lang.String> $styleNames
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Values<java.lang.String>, java.lang.String>(
				"AttributeDesign_styleNames", "styleNames", INSTANCE, java.lang.String.class, "styleNames", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		styleNames = $styleNames;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> $attribute
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
				"RelationDesign_attribute", "attribute", INSTANCE, "attribute", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		attribute = $attribute;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.FragmentTemplateContentDesign>, org.instantlogic.designer.FragmentTemplateContentDesign> $contents
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.FragmentTemplateContentDesign>, org.instantlogic.designer.FragmentTemplateContentDesign>(
				"RelationDesign_contents", "contents", INSTANCE, "contents", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		contents = $contents;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.DestinationDesign, org.instantlogic.designer.DestinationDesign> $destination
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.DestinationDesign, org.instantlogic.designer.DestinationDesign>(
				"RelationDesign_destination", "destination", INSTANCE, "destination", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		destination = $destination;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $entity
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"RelationDesign_entity_1", "entity", INSTANCE, "entity", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		entity = $entity;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> $event
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign>(
				"RelationDesign_event_1", "event", INSTANCE, "event", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		event = $event;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign> $linkToPlaceTemplate
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign>(
				"RelationDesign_linkToPlaceTemplate", "linkToPlaceTemplate", INSTANCE, "linkToPlaceTemplate", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		linkToPlaceTemplate = $linkToPlaceTemplate;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.FragmentTemplateTextDesign>, org.instantlogic.designer.FragmentTemplateTextDesign> $texts
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.FragmentTemplateTextDesign>, org.instantlogic.designer.FragmentTemplateTextDesign>(
				"RelationDesign_texts", "texts", INSTANCE, "texts", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		texts = $texts;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.designer.FragmentTypeDesign> $type
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.designer.FragmentTypeDesign>(
				"RelationDesign_type", "type", INSTANCE, "type", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		type = $type;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.FragmentTemplateValueDesign>, org.instantlogic.designer.FragmentTemplateValueDesign> $values
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.FragmentTemplateValueDesign>, org.instantlogic.designer.FragmentTemplateValueDesign>(
				"RelationDesign_values", "values", INSTANCE, "values", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		values = $values;
		// Reverse relations
		
		// Phase 2
		$fragmentFilters.dataType.put("category", "text");
		$fragmentFilters.multivalue = true;
		$fragmentFilters.ordered = true;
		$fragmentTypeName.dataType.put("category", "text");
		$styleNames.dataType.put("category", "text");
		$styleNames.multivalue = true;

		$attribute.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$attribute.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$attribute.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity.attributeOnFragmentTemplateDesign);
		$attribute.options = (org.instantlogic.fabric.deduction.Deduction)createDeduction1();
		$contents.valueClass = org.instantlogic.designer.FragmentTemplateContentDesign.class;
		$contents.to = org.instantlogic.designer.entity.FragmentTemplateContentDesignEntity.INSTANCE;
		$contents.setReverseRelation(org.instantlogic.designer.entity.FragmentTemplateContentDesignEntity.fragmentTemplateDesign);
		$contents.owner = true;
		$contents.multivalue = true;
		$contents.ordered = true;
		$destination.valueClass = org.instantlogic.designer.DestinationDesign.class;
		$destination.to = org.instantlogic.designer.entity.DestinationDesignEntity.INSTANCE;
		$destination.setReverseRelation(org.instantlogic.designer.entity.DestinationDesignEntity.destinationOnFragmentTemplateDesign);
		$destination.owner = true;
		$entity.valueClass = org.instantlogic.designer.EntityDesign.class;
		$entity.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$entity.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.entityOnFragmentTemplateDesign);
		$entity.options = (org.instantlogic.fabric.deduction.Deduction)createDeduction2();
		$event.valueClass = org.instantlogic.designer.EventDesign.class;
		$event.to = org.instantlogic.designer.entity.EventDesignEntity.INSTANCE;
		$event.setReverseRelation(org.instantlogic.designer.entity.EventDesignEntity.eventOnFragmentTemplateDesign);
		$linkToPlaceTemplate.valueClass = org.instantlogic.designer.PlaceTemplateDesign.class;
		$linkToPlaceTemplate.to = org.instantlogic.designer.entity.PlaceTemplateDesignEntity.INSTANCE;
		$linkToPlaceTemplate.setReverseRelation(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.incomingLinksFromFragmentTemplates);
		$texts.valueClass = org.instantlogic.designer.FragmentTemplateTextDesign.class;
		$texts.to = org.instantlogic.designer.entity.FragmentTemplateTextDesignEntity.INSTANCE;
		$texts.setReverseRelation(org.instantlogic.designer.entity.FragmentTemplateTextDesignEntity.fragmentTemplateDesign);
		$texts.owner = true;
		$texts.multivalue = true;
		$texts.ordered = true;
		$type.valueClass = org.instantlogic.designer.FragmentTypeDesign.class;
		$type.to = org.instantlogic.designer.entity.FragmentTypeDesignEntity.INSTANCE;
		$type.setReverseRelation(org.instantlogic.designer.entity.FragmentTypeDesignEntity.usages);
		$type.options = (org.instantlogic.fabric.deduction.Deduction)createDeduction3();
		$values.valueClass = org.instantlogic.designer.FragmentTemplateValueDesign.class;
		$values.to = org.instantlogic.designer.entity.FragmentTemplateValueDesignEntity.INSTANCE;
		$values.setReverseRelation(org.instantlogic.designer.entity.FragmentTemplateValueDesignEntity.valuesOnFragmentTemplateDesign);
		$values.owner = true;
		$values.multivalue = true;
		$values.ordered = true;


		title = new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction0()).getTextTemplate();
	}

	@Override
	public org.instantlogic.designer.FragmentTemplateDesign createInstance() {
		return new org.instantlogic.designer.FragmentTemplateDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.FragmentTemplateDesign> getInstanceClass() {
		return org.instantlogic.designer.FragmentTemplateDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "EntityDesign_FragmentTemplateDesign";
	}
	
	@Override
	public String getName() {
		return "FragmentTemplateDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		fragmentFilters,
		fragmentTypeName,
		styleNames,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		attribute,
		contents,
		destination,
		entity,
		event,
		linkToPlaceTemplate,
		texts,
		type,
		values,
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
	public java.util.Map<String, org.instantlogic.designer.FragmentTemplateDesign> getStaticInstances() {
		return org.instantlogic.designer.FragmentTemplateDesign.getStaticFragmentTemplateDesignInstances();
	}
}
