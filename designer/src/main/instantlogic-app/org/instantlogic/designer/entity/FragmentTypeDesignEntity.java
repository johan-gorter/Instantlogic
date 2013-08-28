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
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FragmentTypeDesign, java.lang.Boolean, java.lang.Boolean> hasEvent; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FragmentTypeDesign, java.lang.Boolean, java.lang.Boolean> hasAttribute; 
	
	// Relations
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign> usages;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> application;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.fabric.value.Values<java.lang.String>, java.lang.String> $fragmentFilters
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.fabric.value.Values<java.lang.String>, java.lang.String>(
				"AmdUyfrIoqeOIcqp_553dd1fa_1fc9", "fragmentFilters", INSTANCE, java.lang.String.class, "fragmentFilters", org.instantlogic.designer.FragmentTypeDesign.class);
		fragmentFilters = $fragmentFilters;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTypeDesign, java.lang.Boolean, java.lang.Boolean> $hasEvent
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"BhplwcorxIeImiIx_d2eafc31_599e", "hasEvent", INSTANCE, java.lang.Boolean.class, "hasEvent", org.instantlogic.designer.FragmentTypeDesign.class);
		hasEvent = $hasEvent;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTypeDesign, java.lang.Boolean, java.lang.Boolean> $hasAttribute
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"KinOsukdlucfimrv_32077760_1d35", "hasAttribute", INSTANCE, java.lang.Boolean.class, "hasAttribute", org.instantlogic.designer.FragmentTypeDesign.class);
		hasAttribute = $hasAttribute;
		// Relations
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign> $usages
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign>(
				"Nddsmn_axIddknnA_3528ba74_08c3", "usages", INSTANCE, "usages", org.instantlogic.designer.FragmentTypeDesign.class);
		usages = $usages;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> $application
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
				"_cenbAAdzaeEqf_u_fa29b722_22bb", "application", INSTANCE, "application", org.instantlogic.designer.FragmentTypeDesign.class);
		application = $application;
		
		// Phase 2
		$fragmentFilters.dataType.put("category", "text");
		$fragmentFilters.multivalue = true;
		$hasEvent.dataType.put("category", "boolean");
		$hasEvent._default = createDeduction0();
		$hasAttribute.dataType.put("category", "boolean");
		$hasAttribute._default = createDeduction1();


		$usages.reverse = true;
		$usages.valueClass = org.instantlogic.designer.FragmentTemplateDesign.class;
		$usages.to = org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE;
		$usages.setReverseRelation(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type);
		$usages.multivalue = true;
		$application.reverse = true;
		$application.valueClass = org.instantlogic.designer.ApplicationDesign.class;
		$application.to = org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
		$application.setReverseRelation(org.instantlogic.designer.entity.ApplicationDesignEntity.fragmentTypes);
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
		return "oEszvzeUjydfcowi_4566422b_10b1";
	}
	
	@Override
	public String getName() {
		return "FragmentTypeDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		fragmentFilters,
		hasEvent,
		hasAttribute,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		usages,
		application,
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
