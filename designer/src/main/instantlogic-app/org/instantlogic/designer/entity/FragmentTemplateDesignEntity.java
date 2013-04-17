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
		    d0.setAttribute(org.instantlogic.designer.entity.ApplicationDesignEntity.fragmentTypes);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE);
		    d0.setInstance(d1);
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


	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Multi<java.lang.String>, java.lang.String> fragmentFilters; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FragmentTemplateDesign, java.lang.String, java.lang.String> fragmentTypeName; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Multi<java.lang.String>, java.lang.String> styleNames; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> attribute;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> entity;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> event;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PropertyDesign>, org.instantlogic.designer.PropertyDesign> properties;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.designer.FragmentTypeDesign> type;
	
	// Reverse relations

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Multi<java.lang.String>, java.lang.String> $fragmentFilters
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Multi<java.lang.String>, java.lang.String>(
				"fragmentFilters", INSTANCE, java.lang.String.class, "fragmentFilters", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		fragmentFilters = $fragmentFilters;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTemplateDesign, java.lang.String, java.lang.String> $fragmentTypeName
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTemplateDesign, java.lang.String, java.lang.String>(
				"fragmentTypeName", INSTANCE, java.lang.String.class, "fragmentTypeName", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		fragmentTypeName = $fragmentTypeName;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Multi<java.lang.String>, java.lang.String> $styleNames
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Multi<java.lang.String>, java.lang.String>(
				"styleNames", INSTANCE, java.lang.String.class, "styleNames", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		styleNames = $styleNames;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> $attribute
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
				"attribute", INSTANCE, "attribute", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		attribute = $attribute;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $entity
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"entity", INSTANCE, "entity", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		entity = $entity;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> $event
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign>(
				"event", INSTANCE, "event", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		event = $event;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PropertyDesign>, org.instantlogic.designer.PropertyDesign> $properties
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PropertyDesign>, org.instantlogic.designer.PropertyDesign>(
				"properties", INSTANCE, "properties", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		properties = $properties;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.designer.FragmentTypeDesign> $type
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.designer.FragmentTypeDesign>(
				"type", INSTANCE, "type", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		type = $type;
		// Reverse relations
		
		// Phase 2
		$fragmentFilters.multivalue = true;
		$styleNames.multivalue = true;

		$attribute.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$attribute.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$attribute.options = (org.instantlogic.fabric.deduction.Deduction)createDeduction1();
		$entity.valueClass = org.instantlogic.designer.EntityDesign.class;
		$entity.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$entity.options = (org.instantlogic.fabric.deduction.Deduction)createDeduction2();
		$event.valueClass = org.instantlogic.designer.EventDesign.class;
		$event.to = org.instantlogic.designer.entity.EventDesignEntity.INSTANCE;
		$properties.valueClass = org.instantlogic.designer.PropertyDesign.class;
		$properties.to = org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE;
		$properties.setReverseRelation(org.instantlogic.designer.entity.PropertyDesignEntity.fragment);
		$properties.owner = true;
		$properties.multivalue = true;
		$type.valueClass = org.instantlogic.designer.FragmentTypeDesign.class;
		$type.to = org.instantlogic.designer.entity.FragmentTypeDesignEntity.INSTANCE;
		$type.setReverseRelation(org.instantlogic.designer.entity.FragmentTypeDesignEntity.usages);
		$type.options = (org.instantlogic.fabric.deduction.Deduction)createDeduction0();

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
		entity,
		event,
		properties,
		type,
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
