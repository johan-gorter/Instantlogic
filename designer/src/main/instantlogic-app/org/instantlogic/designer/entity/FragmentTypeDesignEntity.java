package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class FragmentTypeDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.FragmentTypeDesign> {

	public static final FragmentTypeDesignEntity INSTANCE = new FragmentTypeDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
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
	public String getName() {
		return "FragmentTypeDesign";
	}

	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> d0 
		  		= org.instantlogic.fabric.deduction.ConstantDeduction.create(false);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction1() {
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> d0 
		  		= org.instantlogic.fabric.deduction.ConstantDeduction.create(false);
		return d0;
	}


	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.fabric.value.Multi<java.lang.String>, java.lang.String> fragmentFilters 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.fabric.value.Multi<java.lang.String>, java.lang.String>(
			"fragmentFilters", INSTANCE, java.lang.String.class
		) {
			{
				dataType.put("category", "text");
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValues<org.instantlogic.designer.FragmentTypeDesign, java.lang.String> get(org.instantlogic.designer.FragmentTypeDesign instance) {
				return instance.getFragmentFiltersAttributeValue();
			}
	
			public boolean isMultivalue() {
				return true;
			}
            
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FragmentTypeDesign, java.lang.Boolean, java.lang.Boolean> hasAttribute 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTypeDesign, java.lang.Boolean, java.lang.Boolean>(
			"hasAttribute", INSTANCE, java.lang.Boolean.class
		) {
			{
				dataType.put("category", "boolean");
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.FragmentTypeDesign, java.lang.Boolean> get(org.instantlogic.designer.FragmentTypeDesign instance) {
				return instance.getHasAttributeAttributeValue();
			}

            private org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> defaultDeduction;
            @Override
            public org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> getDefault() {
                if (defaultDeduction==null) {
                    defaultDeduction = createDeduction0();
                }
                return defaultDeduction;
            }
            
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FragmentTypeDesign, java.lang.Boolean, java.lang.Boolean> hasEvent 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTypeDesign, java.lang.Boolean, java.lang.Boolean>(
			"hasEvent", INSTANCE, java.lang.Boolean.class
		) {
			{
				dataType.put("category", "boolean");
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.FragmentTypeDesign, java.lang.Boolean> get(org.instantlogic.designer.FragmentTypeDesign instance) {
				return instance.getHasEventAttributeValue();
			}

            private org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> defaultDeduction;
            @Override
            public org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> getDefault() {
                if (defaultDeduction==null) {
                    defaultDeduction = createDeduction1();
                }
                return defaultDeduction;
            }
            
		};
	
	// Relations
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> application
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
			"application", INSTANCE, org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE, org.instantlogic.designer.ApplicationDesign.class, org.instantlogic.designer.entity.ApplicationDesignEntity.fragmentTypes
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.designer.ApplicationDesign> get(
					org.instantlogic.designer.FragmentTypeDesign instance) {
				return instance.getApplicationRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign> usages
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign>(
			"usages", INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.FragmentTemplateDesign.class, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.designer.FragmentTemplateDesign> get(
					org.instantlogic.designer.FragmentTypeDesign instance) {
				return instance.getUsagesRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		fragmentFilters,
		hasAttribute,
		hasEvent,
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
