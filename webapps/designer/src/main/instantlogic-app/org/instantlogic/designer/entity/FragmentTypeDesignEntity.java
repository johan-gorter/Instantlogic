package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class FragmentTypeDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.FragmentTypeDesign> {

	public static final FragmentTypeDesignEntity INSTANCE = new FragmentTypeDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	
	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(false);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(false);
		return d0;
	}


	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.fabric.value.Values<java.lang.String>, java.lang.String> fragmentFilters; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FragmentTypeDesign, java.lang.Boolean, java.lang.Boolean> hasAttribute; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FragmentTypeDesign, java.lang.Boolean, java.lang.Boolean> hasEvent; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.fabric.value.ValueList<java.lang.String>, java.lang.String> valuePropertyNames; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.fabric.value.ValueList<java.lang.String>, java.lang.String> textPropertyNames; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.fabric.value.ValueList<java.lang.String>, java.lang.String> contentPropertyNames; 
	
	// Relations
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> application;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign> usages;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.fabric.value.Values<java.lang.String>, java.lang.String> $fragmentFilters
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.fabric.value.Values<java.lang.String>, java.lang.String>(
				"AttributeDesign_fragmentFilters_1", "fragmentFilters", INSTANCE, java.lang.String.class, "fragmentFilters", org.instantlogic.designer.FragmentTypeDesign.class);
		fragmentFilters = $fragmentFilters;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTypeDesign, java.lang.Boolean, java.lang.Boolean> $hasAttribute
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"AttributeDesign_hasAttribute", "hasAttribute", INSTANCE, java.lang.Boolean.class, "hasAttribute", org.instantlogic.designer.FragmentTypeDesign.class);
		hasAttribute = $hasAttribute;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTypeDesign, java.lang.Boolean, java.lang.Boolean> $hasEvent
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"AttributeDesign_hasEvent", "hasEvent", INSTANCE, java.lang.Boolean.class, "hasEvent", org.instantlogic.designer.FragmentTypeDesign.class);
		hasEvent = $hasEvent;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.fabric.value.ValueList<java.lang.String>, java.lang.String> $valuePropertyNames
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.fabric.value.ValueList<java.lang.String>, java.lang.String>(
				"HvklhctmrmdAyjim_df1c6d01_5489", "valuePropertyNames", INSTANCE, java.lang.String.class, "valuePropertyNames", org.instantlogic.designer.FragmentTypeDesign.class);
		valuePropertyNames = $valuePropertyNames;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.fabric.value.ValueList<java.lang.String>, java.lang.String> $textPropertyNames
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.fabric.value.ValueList<java.lang.String>, java.lang.String>(
				"IUzzwiUonufOcilc_0d85f7dd_1a30", "textPropertyNames", INSTANCE, java.lang.String.class, "textPropertyNames", org.instantlogic.designer.FragmentTypeDesign.class);
		textPropertyNames = $textPropertyNames;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.fabric.value.ValueList<java.lang.String>, java.lang.String> $contentPropertyNames
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.fabric.value.ValueList<java.lang.String>, java.lang.String>(
				"WresyzOEumbOAjbb_d0074160_a120", "contentPropertyNames", INSTANCE, java.lang.String.class, "contentPropertyNames", org.instantlogic.designer.FragmentTypeDesign.class);
		contentPropertyNames = $contentPropertyNames;
		// Relations
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> $application
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
				"RelationDesign_fragmentTypes", "application", INSTANCE, "application", org.instantlogic.designer.FragmentTypeDesign.class);
		application = $application;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign> $usages
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign>(
				"RelationDesign_type", "usages", INSTANCE, "usages", org.instantlogic.designer.FragmentTypeDesign.class);
		usages = $usages;
		
		// Phase 2
		$fragmentFilters.dataType.put("category", "text");
		$fragmentFilters.multivalue = true;
		$hasAttribute.dataType.put("category", "boolean");
		$hasAttribute._default = createDeduction0();
		$hasEvent.dataType.put("category", "boolean");
		$hasEvent._default = createDeduction1();
		$valuePropertyNames.dataType.put("category", "text");
		$valuePropertyNames.multivalue = true;
		$valuePropertyNames.ordered = true;
		$textPropertyNames.dataType.put("category", "text");
		$textPropertyNames.multivalue = true;
		$textPropertyNames.ordered = true;
		$contentPropertyNames.dataType.put("category", "text");
		$contentPropertyNames.multivalue = true;
		$contentPropertyNames.ordered = true;


		$application.reverse = true;
		$application.valueClass = org.instantlogic.designer.ApplicationDesign.class;
		$application.to = org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
		$application.setReverseRelation(org.instantlogic.designer.entity.ApplicationDesignEntity.fragmentTypes);
		$usages.reverse = true;
		$usages.valueClass = org.instantlogic.designer.FragmentTemplateDesign.class;
		$usages.to = org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE;
		$usages.setReverseRelation(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type);
		$usages.multivalue = true;
	}

	@Override
	public org.instantlogic.designer.FragmentTypeDesign createInstance() {
		return new org.instantlogic.designer.FragmentTypeDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.FragmentTypeDesign> getInstanceClass() {
		return org.instantlogic.designer.FragmentTypeDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "EntityDesign_FragmentTypeDesign";
	}
	
	@Override
	public String getName() {
		return "FragmentTypeDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		fragmentFilters,
		hasAttribute,
		hasEvent,
		valuePropertyNames,
		textPropertyNames,
		contentPropertyNames,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		application,
		usages,
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
	public java.util.Map<String, org.instantlogic.designer.FragmentTypeDesign> getStaticInstances() {
		return org.instantlogic.designer.FragmentTypeDesign.getStaticFragmentTypeDesignInstances();
	}
}
