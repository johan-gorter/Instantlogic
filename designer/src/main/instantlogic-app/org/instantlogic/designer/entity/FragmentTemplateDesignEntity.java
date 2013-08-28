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
		    d0.setAttribute(org.instantlogic.designer.entity.EntityDesignEntity.attributes);
		  	org.instantlogic.fabric.deduction.AttributeDeduction d1 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d1.setAttribute(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.entity);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d2 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d2.setOfEntity(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		    d1.setInstance(d2);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.ApplicationDesignEntity.fragmentTypes);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE);
		    d0.setInstance(d1);
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
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FragmentTemplateDesign, java.lang.String, java.lang.String> fragmentTypeName; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Values<java.lang.String>, java.lang.String> styleNames; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.ValueList<java.lang.String>, java.lang.String> fragmentFilters; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> attribute;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.designer.FragmentTypeDesign> type;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.PropertyDesign>, org.instantlogic.designer.PropertyDesign> properties;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> entity;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> event;
	
	// Reverse relations

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTemplateDesign, java.lang.String, java.lang.String> $fragmentTypeName
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTemplateDesign, java.lang.String, java.lang.String>(
				"ShzhotrytudnmbEb_cfe1eef8_07f2", "fragmentTypeName", INSTANCE, java.lang.String.class, "fragmentTypeName", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		fragmentTypeName = $fragmentTypeName;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Values<java.lang.String>, java.lang.String> $styleNames
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Values<java.lang.String>, java.lang.String>(
				"eUwIuaAziiauk_uz_828ffb24_297c", "styleNames", INSTANCE, java.lang.String.class, "styleNames", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		styleNames = $styleNames;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.ValueList<java.lang.String>, java.lang.String> $fragmentFilters
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.ValueList<java.lang.String>, java.lang.String>(
				"iiomzwgqAmamcnmq_2665e66b_df0a", "fragmentFilters", INSTANCE, java.lang.String.class, "fragmentFilters", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		fragmentFilters = $fragmentFilters;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> $attribute
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
				"Dimbrbxzfy_AUesq_1c2e7a46_4b17", "attribute", INSTANCE, "attribute", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		attribute = $attribute;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.designer.FragmentTypeDesign> $type
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.designer.FragmentTypeDesign>(
				"Nddsmn_axIddknnA_3528ba74_08c3", "type", INSTANCE, "type", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		type = $type;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.PropertyDesign>, org.instantlogic.designer.PropertyDesign> $properties
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.PropertyDesign>, org.instantlogic.designer.PropertyDesign>(
				"Tpa_wwxytuausgjp_b4eab58f_35c3", "properties", INSTANCE, "properties", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		properties = $properties;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $entity
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"X_opkks_UmbgcnOp_ff0ee2a2_4a06", "entity", INSTANCE, "entity", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		entity = $entity;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> $event
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign>(
				"eprEfieyueaIkoe_6cdc8bc2_c729", "event", INSTANCE, "event", org.instantlogic.designer.AbstractFragmentTemplateDesign.class);
		event = $event;
		// Reverse relations
		
		// Phase 2
		$fragmentTypeName.dataType.put("category", "text");
		$styleNames.dataType.put("category", "text");
		$styleNames.multivalue = true;
		$fragmentFilters.dataType.put("category", "text");
		$fragmentFilters.multivalue = true;
		$fragmentFilters.ordered = true;

		$attribute.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$attribute.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$attribute.options = (org.instantlogic.fabric.deduction.Deduction)createDeduction0();
		$type.valueClass = org.instantlogic.designer.FragmentTypeDesign.class;
		$type.to = org.instantlogic.designer.entity.FragmentTypeDesignEntity.INSTANCE;
		$type.setReverseRelation(org.instantlogic.designer.entity.FragmentTypeDesignEntity.usages);
		$type.options = (org.instantlogic.fabric.deduction.Deduction)createDeduction1();
		$properties.valueClass = org.instantlogic.designer.PropertyDesign.class;
		$properties.to = org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE;
		$properties.setReverseRelation(org.instantlogic.designer.entity.PropertyDesignEntity.fragment);
		$properties.owner = true;
		$properties.multivalue = true;
		$entity.valueClass = org.instantlogic.designer.EntityDesign.class;
		$entity.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$entity.options = (org.instantlogic.fabric.deduction.Deduction)createDeduction2();
		$event.valueClass = org.instantlogic.designer.EventDesign.class;
		$event.to = org.instantlogic.designer.entity.EventDesignEntity.INSTANCE;

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
		return "PpihlEegduadyoum_0d351774_74c9";
	}
	
	@Override
	public String getName() {
		return "FragmentTemplateDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		fragmentTypeName,
		styleNames,
		fragmentFilters,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		attribute,
		type,
		properties,
		entity,
		event,
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
