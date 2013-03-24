/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.Design> {

	public static final DesignEntity INSTANCE = new DesignEntity();
	

	private static final org.instantlogic.fabric.model.Entity<?>[] EXTENSIONS = new org.instantlogic.fabric.model.Entity<?>[] {
		org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.EventDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.FragmentTypeDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.SharedElementDefinitionDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.StaticInstanceDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.ValidationDesignEntity.INSTANCE
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
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 
		  	  = new org.instantlogic.fabric.deduction.AttributeDeduction(org.instantlogic.designer.entity.DesignEntity.name);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 
		  	  = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		    d0.addToInputs(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction1() {
		    org.instantlogic.designer.deduction.DefaultDesignNameDeduction d0 
		      = new org.instantlogic.designer.deduction.DefaultDesignNameDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction2() {
		    org.instantlogic.designer.deduction.JavaIdentifierDeduction d0 
		      = new org.instantlogic.designer.deduction.JavaIdentifierDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction3() {
		    org.instantlogic.designer.deduction.TechnicalNameDeduction d0 
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
