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

import org.instantlogic.designer.DataCategoryDesign;
import org.instantlogic.fabric.deduction.Deduction;

@SuppressWarnings({"unchecked","rawtypes"})
public class DataTypeDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DataTypeDesign> {

	public static final DataTypeDesignEntity INSTANCE = new DataTypeDesignEntity();
	

	
	@Override
	public org.instantlogic.designer.DataTypeDesign createInstance() {
		return new org.instantlogic.designer.DataTypeDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.DataTypeDesign> getInstanceClass() {
		return org.instantlogic.designer.DataTypeDesign.class;
	}
	
	@Override
	public String getName() {
		return "DataTypeDesign";
	}

	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction0() {
		    org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> d0 
		    	= new org.instantlogic.designer.deduction.DataTypeMultivalueDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction1() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction<java.lang.Boolean> d0 
		  		= new org.instantlogic.fabric.deduction.ConstantDeduction(false);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction2() {
		    org.instantlogic.fabric.deduction.Deduction<java.lang.String> d0 
		    	= new org.instantlogic.designer.deduction.DataTypeJavaClassNameDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction3() {
	  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction<org.instantlogic.designer.DataTypeDesign> d0 
	  		= new org.instantlogic.fabric.deduction.SelectedInstanceDeduction(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE);
	  	org.instantlogic.fabric.deduction.AttributeDeduction<org.instantlogic.designer.DataCategoryDesign>  d1 
	  		= new org.instantlogic.fabric.deduction.AttributeDeduction<org.instantlogic.designer.DataCategoryDesign>(org.instantlogic.designer.entity.DataTypeDesignEntity.dataCategory);
	  	org.instantlogic.fabric.deduction.ConstantDeduction<org.instantlogic.designer.DataCategoryDesign> d2 
	  		= new org.instantlogic.fabric.deduction.ConstantDeduction(org.instantlogic.designer.DataCategoryDesign.number);
	  	org.instantlogic.fabric.deduction.EqualsDeduction d3 = new org.instantlogic.fabric.deduction.EqualsDeduction();
	  	d1.setInstance(d0);
	  	d3.addToInputs(d1);
	  	d3.addToInputs(d2);
		return d3;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction4() {
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction<org.instantlogic.designer.DataTypeDesign> d0 
		  		= new org.instantlogic.fabric.deduction.SelectedInstanceDeduction(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.AttributeDeduction<org.instantlogic.designer.DataCategoryDesign> d1 
		  		= new org.instantlogic.fabric.deduction.AttributeDeduction(org.instantlogic.designer.entity.DataTypeDesignEntity.dataCategory);
		  	org.instantlogic.fabric.deduction.ConstantDeduction<org.instantlogic.designer.DataCategoryDesign> d2 
		  		= new org.instantlogic.fabric.deduction.ConstantDeduction(org.instantlogic.designer.DataCategoryDesign.number);
		  	org.instantlogic.fabric.deduction.EqualsDeduction d3 
		  		= new org.instantlogic.fabric.deduction.EqualsDeduction();
		  	d1.setInstance(d0);
		  	d3.addToInputs(d1);
		  	d3.addToInputs(d2);
		return d3;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction5() {
	  	org.instantlogic.fabric.deduction.ConstantDeduction<java.lang.Boolean> d0 
	  		= new org.instantlogic.fabric.deduction.ConstantDeduction(false);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction6() {
	  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction<org.instantlogic.designer.DataTypeDesign> d0 
	  		= new org.instantlogic.fabric.deduction.SelectedInstanceDeduction(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE);
	  	org.instantlogic.fabric.deduction.AttributeDeduction<java.lang.Boolean> d1 
	  		= new org.instantlogic.fabric.deduction.AttributeDeduction(org.instantlogic.designer.entity.DataTypeDesignEntity.wholeNumber);
	  	org.instantlogic.fabric.deduction.ConstantDeduction<java.lang.Boolean> d2 
	  		= new org.instantlogic.fabric.deduction.ConstantDeduction(false);
	  	org.instantlogic.fabric.deduction.EqualsDeduction d3 
	  		= new org.instantlogic.fabric.deduction.EqualsDeduction();
	  	d1.setInstance(d0);
	  	d3.addToInputs(d1);
	  	d3.addToInputs(d2);
		return d3;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction7() {
	  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction<org.instantlogic.designer.DataTypeDesign> d0 
	  		= new org.instantlogic.fabric.deduction.SelectedInstanceDeduction(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE);
	  	org.instantlogic.fabric.deduction.AttributeDeduction<org.instantlogic.designer.DataCategoryDesign> d1 
	  		= new org.instantlogic.fabric.deduction.AttributeDeduction(org.instantlogic.designer.entity.DataTypeDesignEntity.dataCategory);
	  	org.instantlogic.fabric.deduction.ConstantDeduction<org.instantlogic.designer.DataCategoryDesign> d2 
	  		= new org.instantlogic.fabric.deduction.ConstantDeduction(org.instantlogic.designer.DataCategoryDesign.text);
	  	org.instantlogic.fabric.deduction.EqualsDeduction d3 
	  		= new org.instantlogic.fabric.deduction.EqualsDeduction();
	  	
	  	d1.setInstance(d0);
	  	d3.addToInputs(d1);
	  	d3.addToInputs(d2);
		return d3;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction8() {
	  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction<org.instantlogic.designer.DataTypeDesign> d0 
	  		= new org.instantlogic.fabric.deduction.SelectedInstanceDeduction(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE);
	  	org.instantlogic.fabric.deduction.AttributeDeduction<java.lang.Boolean> d1 
	  		= new org.instantlogic.fabric.deduction.AttributeDeduction(org.instantlogic.designer.entity.DataTypeDesignEntity.multiLine);
	  	d1.setInstance(d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.DataCategoryDesign> createDeduction9() {
		org.instantlogic.designer.deduction.DataTypeDataCategoryDeduction d0 
	    	= new org.instantlogic.designer.deduction.DataTypeDataCategoryDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<? extends Iterable> createDeduction10() {
		org.instantlogic.designer.deduction.DataTypeDataCategoryOptionsDeduction d0 
	    	= new org.instantlogic.designer.deduction.DataTypeDataCategoryOptionsDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.EntityDesign> createDeduction11() {
		org.instantlogic.designer.deduction.DataTypeEntityDeduction d0 
	    	= new org.instantlogic.designer.deduction.DataTypeEntityDeduction();
		return d0;
	}


	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> exactRounding 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
			"exactRounding", INSTANCE, java.lang.Boolean.class
		) {
			{
				dataType.put("category", "boolean");
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean> get(org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getExactRoundingAttributeValue();
			}

            private org.instantlogic.fabric.deduction.Deduction<Boolean> relevance;
            @Override
            public org.instantlogic.fabric.deduction.Deduction<Boolean> getRelevance() {
                if (relevance==null) {
                    relevance = createDeduction6();
                }
                return relevance;
            }
            
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> formatted 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
			"formatted", INSTANCE, java.lang.Boolean.class
		) {
			{
				dataType.put("category", "boolean");
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean> get(org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getFormattedAttributeValue();
			}

            private org.instantlogic.fabric.deduction.Deduction<Boolean> relevance;
            @Override
            public org.instantlogic.fabric.deduction.Deduction<Boolean> getRelevance() {
                if (relevance==null) {
                    relevance = createDeduction8();
                }
                return relevance;
            }
            
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.String, java.lang.String> javaClassName 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.String, java.lang.String>(
			"javaClassName", INSTANCE, java.lang.String.class
		) {
			{
				dataType.put("category", "text");
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.DataTypeDesign, java.lang.String> get(org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getJavaClassNameAttributeValue();
			}

            private org.instantlogic.fabric.deduction.Deduction<java.lang.String> defaultDeduction;
            @Override
            public org.instantlogic.fabric.deduction.Deduction<java.lang.String> getDefault() {
                if (defaultDeduction==null) {
                    defaultDeduction = createDeduction2();
                }
                return defaultDeduction;
            }
            
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> multiLine 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
			"multiLine", INSTANCE, java.lang.Boolean.class
		) {
			{
				dataType.put("category", "boolean");
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean> get(org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getMultiLineAttributeValue();
			}

            private org.instantlogic.fabric.deduction.Deduction<Boolean> relevance;
            @Override
            public org.instantlogic.fabric.deduction.Deduction<Boolean> getRelevance() {
                if (relevance==null) {
                    relevance = createDeduction7();
                }
                return relevance;
            }
            
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> multivalue 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
			"multivalue", INSTANCE, java.lang.Boolean.class
		) {
			{
				dataType.put("category", "boolean");
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean> get(org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getMultivalueAttributeValue();
			}

            private org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> rule;
            @Override
            public org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> getRule() {
                if (rule==null) {
                    rule = createDeduction0();
                }
                return rule;
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
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> percentage 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
			"percentage", INSTANCE, java.lang.Boolean.class
		) {
			{
				dataType.put("category", "boolean");
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean> get(org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getPercentageAttributeValue();
			}

            private org.instantlogic.fabric.deduction.Deduction<Boolean> relevance;
            @Override
            public org.instantlogic.fabric.deduction.Deduction<Boolean> getRelevance() {
                if (relevance==null) {
                    relevance = createDeduction3();
                }
                return relevance;
            }
            
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> wholeNumber 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
			"wholeNumber", INSTANCE, java.lang.Boolean.class
		) {
			{
				dataType.put("category", "boolean");
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean> get(org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getWholeNumberAttributeValue();
			}

            private org.instantlogic.fabric.deduction.Deduction<Boolean> relevance;
            @Override
            public org.instantlogic.fabric.deduction.Deduction<Boolean> getRelevance() {
                if (relevance==null) {
                    relevance = createDeduction4();
                }
                return relevance;
            }

            private org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> defaultDeduction;
            @Override
            public org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> getDefault() {
                if (defaultDeduction==null) {
                    defaultDeduction = createDeduction5();
                }
                return defaultDeduction;
            }
            
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataCategoryDesign, org.instantlogic.designer.DataCategoryDesign> dataCategory
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataCategoryDesign, org.instantlogic.designer.DataCategoryDesign>(
			"dataCategory", INSTANCE, org.instantlogic.designer.entity.DataCategoryDesignEntity.INSTANCE, org.instantlogic.designer.DataCategoryDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataCategoryDesign> get(
					org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getDataCategoryRelationValue();
			}

			private org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.DataCategoryDesign> rule;
			@Override
			public org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.DataCategoryDesign> getRule() {
				if (rule==null) {
					rule  = createDeduction9();
				}
				return rule;
			}
			
			private org.instantlogic.fabric.deduction.Deduction<? extends java.lang.Iterable<org.instantlogic.designer.DataCategoryDesign>> options;
			@Override
			public org.instantlogic.fabric.deduction.Deduction<? extends java.lang.Iterable<org.instantlogic.designer.DataCategoryDesign>> getOptions() {
				if (options==null) {
					options = (Deduction<? extends Iterable<DataCategoryDesign>>) createDeduction10();
				}
				return options;
			};
            
            public org.instantlogic.fabric.model.Validation[] validations;
			@Override
			public org.instantlogic.fabric.model.Validation[] getValidations() {
				if (validations==null) {
					validations = new org.instantlogic.fabric.model.Validation[] {
						org.instantlogic.designer.validation.DataTypeDesignDataCategoryRequiredValidation.INSTANCE,
					};
				}
				return validations;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> entity
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
			"entity", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getEntityRelationValue();
			}
	
			public boolean isReadOnly() {
				return true;
			}

			private org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.EntityDesign> rule;
			@Override
			public org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.EntityDesign> getRule() {
				if (rule==null) {
					rule  = createDeduction11();
				}
				return rule;
			}
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> attribute
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
			"attribute", INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.AttributeDesign.class, org.instantlogic.designer.entity.AttributeDesignEntity.dataType
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.AttributeDesign> get(
					org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getAttributeRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.ConstantDeductionDesign, org.instantlogic.designer.ConstantDeductionDesign> constantDeductionDesign
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.ConstantDeductionDesign, org.instantlogic.designer.ConstantDeductionDesign>(
			"constantDeductionDesign", INSTANCE, org.instantlogic.designer.entity.ConstantDeductionDesignEntity.INSTANCE, org.instantlogic.designer.ConstantDeductionDesign.class, org.instantlogic.designer.entity.ConstantDeductionDesignEntity.constantDataType
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.ConstantDeductionDesign> get(
					org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getConstantDeductionDesignRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.CustomDeductionDesign, org.instantlogic.designer.CustomDeductionDesign> customDeductionDesign
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.CustomDeductionDesign, org.instantlogic.designer.CustomDeductionDesign>(
			"customDeductionDesign", INSTANCE, org.instantlogic.designer.entity.CustomDeductionDesignEntity.INSTANCE, org.instantlogic.designer.CustomDeductionDesign.class, org.instantlogic.designer.entity.CustomDeductionDesignEntity.customDataType
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.CustomDeductionDesign> get(
					org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getCustomDeductionDesignRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> forEntity
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
			"forEntity", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, org.instantlogic.designer.entity.EntityDesignEntity.dataType
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getForEntityRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign> reverseRelation
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign>(
			"reverseRelation", INSTANCE, org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE, org.instantlogic.designer.RelationDesign.class, org.instantlogic.designer.entity.RelationDesignEntity.reverseDataType
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.RelationDesign> get(
					org.instantlogic.designer.DataTypeDesign instance) {
				return instance.getReverseRelationRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		exactRounding,
		formatted,
		javaClassName,
		multiLine,
		multivalue,
		percentage,
		wholeNumber,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		dataCategory,
		entity,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		attribute,
		constantDeductionDesign,
		customDeductionDesign,
		forEntity,
		reverseRelation,
	};
	private static final org.instantlogic.fabric.model.Validation[] VALIDATIONS = new org.instantlogic.fabric.model.Validation[]{
		org.instantlogic.designer.validation.DataTypeDesignDataCategoryRequiredValidation.INSTANCE,
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
	public java.util.Map<String, org.instantlogic.designer.DataTypeDesign> getStaticInstances() {
		return org.instantlogic.designer.DataTypeDesign.getStaticDataTypeDesignInstances();
	}
}
