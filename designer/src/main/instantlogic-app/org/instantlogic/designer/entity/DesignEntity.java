package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.Design> {

	public static final DesignEntity INSTANCE = new DesignEntity();
	

	private static final org.instantlogic.fabric.model.Entity<?>[] EXTENSIONS = new org.instantlogic.fabric.model.Entity<?>[] {
		org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.ValidationDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.StaticInstanceDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.EventDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.FragmentTypeDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.SharedElementDefinitionDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE
	};
	 
	@Override
	public org.instantlogic.fabric.model.Entity[] extensions() {
		return EXTENSIONS;
	}
	
	@Override
	public org.instantlogic.designer.Design createInstance() {
		return new org.instantlogic.designer.Design();
	}
	
	@Override
	public Class<org.instantlogic.designer.Design> getInstanceClass() {
		return org.instantlogic.designer.Design.class;
	}
	
	@Override
	public String getName() {
		return "Design";
	}

	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.Design> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction1() {
		    org.instantlogic.fabric.deduction.Deduction<java.lang.String> d0 
		    	= new org.instantlogic.designer.deduction.DefaultDesignNameDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction2() {
		    org.instantlogic.fabric.deduction.Deduction<java.lang.String> d0 
		    	= new org.instantlogic.designer.deduction.JavaIdentifierDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction3() {
		    org.instantlogic.fabric.deduction.Deduction<java.lang.String> d0 
		    	= new org.instantlogic.designer.deduction.TechnicalNameDeduction();
		return d0;
	}


	// Title
	private org.instantlogic.fabric.text.TextTemplate title;
	@Override
	public org.instantlogic.fabric.text.TextTemplate getTitle() {
		if (title==null) {
			title = new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0()));
		}
		return title;
	}
	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.Design, java.lang.Boolean, java.lang.Boolean> isCustomized 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.Design, java.lang.Boolean, java.lang.Boolean>(
			"isCustomized", INSTANCE, java.lang.Boolean.class
		) {
			{
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.Design, java.lang.Boolean> get(org.instantlogic.designer.Design instance) {
				return instance.getIsCustomizedAttributeValue();
			}
            
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.Design, java.lang.String, java.lang.String> javaIdentifier 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.Design, java.lang.String, java.lang.String>(
			"javaIdentifier", INSTANCE, java.lang.String.class
		) {
			{
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.Design, java.lang.String> get(org.instantlogic.designer.Design instance) {
				return instance.getJavaIdentifierAttributeValue();
			}
			
			public boolean isReadOnly() {
				return true;
			};

            private org.instantlogic.fabric.deduction.Deduction<java.lang.String> rule;
            @Override
            public org.instantlogic.fabric.deduction.Deduction<java.lang.String> getRule() {
                if (rule==null) {
                    rule = createDeduction2();
                }
                return rule;
            }
            
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.Design, java.lang.String, java.lang.String> name 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.Design, java.lang.String, java.lang.String>(
			"name", INSTANCE, java.lang.String.class
		) {
			{
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.Design, java.lang.String> get(org.instantlogic.designer.Design instance) {
				return instance.getNameAttributeValue();
			}

            private org.instantlogic.fabric.deduction.Deduction<java.lang.String> defaultDeduction;
            @Override
            public org.instantlogic.fabric.deduction.Deduction<java.lang.String> getDefault() {
                if (defaultDeduction==null) {
                    defaultDeduction = createDeduction1();
                }
                return defaultDeduction;
            }
            
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.Design, java.lang.String, java.lang.String> technicalName 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.Design, java.lang.String, java.lang.String>(
			"technicalName", INSTANCE, java.lang.String.class
		) {
			{
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.Design, java.lang.String> get(org.instantlogic.designer.Design instance) {
				return instance.getTechnicalNameAttributeValue();
			}
			
			public boolean isReadOnly() {
				return true;
			};

            private org.instantlogic.fabric.deduction.Deduction<java.lang.String> rule;
            @Override
            public org.instantlogic.fabric.deduction.Deduction<java.lang.String> getRule() {
                if (rule==null) {
                    rule = createDeduction3();
                }
                return rule;
            }
            
		};
	
	// Relations
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		isCustomized,
		javaIdentifier,
		name,
		technicalName,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
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
	public java.util.Map<String, org.instantlogic.designer.Design> getStaticInstances() {
		return org.instantlogic.designer.Design.getStaticDesignInstances();
	}
}
