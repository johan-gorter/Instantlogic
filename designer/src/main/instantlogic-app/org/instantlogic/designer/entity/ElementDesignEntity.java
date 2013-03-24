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
public class ElementDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.ElementDesign> {

	public static final ElementDesignEntity INSTANCE = new ElementDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	private static final org.instantlogic.fabric.model.Entity<?>[] EXTENSIONS = new org.instantlogic.fabric.model.Entity<?>[] {
		org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.IfElseDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.SelectionDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.SharedElementDesignEntity.INSTANCE
	};
	 
	@Override
	public org.instantlogic.fabric.model.Entity[] extensions() {
		return EXTENSIONS;
	}
	
	@Override
	public org.instantlogic.designer.ElementDesign createInstance() {
		return new org.instantlogic.designer.ElementDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.ElementDesign> getInstanceClass() {
		return org.instantlogic.designer.ElementDesign.class;
	}
	
	@Override
	public String getName() {
		return "ElementDesign";
	}

	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction0() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 
		  	  = new org.instantlogic.fabric.deduction.ConstantDeduction(false);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction1() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 
		  	  = new org.instantlogic.fabric.deduction.ConstantDeduction("mobile");
		return d0;
	}


	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ElementDesign, java.lang.Boolean, java.lang.Boolean> editorOpen 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ElementDesign, java.lang.Boolean, java.lang.Boolean>(
			"editorOpen", INSTANCE, java.lang.Boolean.class
		) {
			{
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.ElementDesign, java.lang.Boolean> get(org.instantlogic.designer.ElementDesign instance) {
				return instance.getEditorOpenAttributeValue();
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
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ElementDesign, java.lang.String, java.lang.String> previewMode 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ElementDesign, java.lang.String, java.lang.String>(
			"previewMode", INSTANCE, java.lang.String.class
		) {
			{
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.ElementDesign, java.lang.String> get(org.instantlogic.designer.ElementDesign instance) {
				return instance.getPreviewModeAttributeValue();
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
	
	// Relations
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.SelectionDesign> childOfSelection
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.SelectionDesign>(
			"childOfSelection", INSTANCE, org.instantlogic.designer.entity.SelectionDesignEntity.INSTANCE, org.instantlogic.designer.SelectionDesign.class, org.instantlogic.designer.entity.SelectionDesignEntity.children
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.SelectionDesign> get(
					org.instantlogic.designer.ElementDesign instance) {
				return instance.getChildOfSelectionRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.PropertyDesign> childrenForFragment
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.PropertyDesign>(
			"childrenForFragment", INSTANCE, org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE, org.instantlogic.designer.PropertyDesign.class, org.instantlogic.designer.entity.PropertyDesignEntity.children
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.PropertyDesign> get(
					org.instantlogic.designer.ElementDesign instance) {
				return instance.getChildrenForFragmentRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign> contentOfPage
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign>(
			"contentOfPage", INSTANCE, org.instantlogic.designer.entity.PlaceTemplateDesignEntity.INSTANCE, org.instantlogic.designer.PlaceTemplateDesign.class, org.instantlogic.designer.entity.PlaceTemplateDesignEntity.content
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.PlaceTemplateDesign> get(
					org.instantlogic.designer.ElementDesign instance) {
				return instance.getContentOfPageRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.SharedElementDefinitionDesign> partOfSharedElementDefinition
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.SharedElementDefinitionDesign>(
			"partOfSharedElementDefinition", INSTANCE, org.instantlogic.designer.entity.SharedElementDefinitionDesignEntity.INSTANCE, org.instantlogic.designer.SharedElementDefinitionDesign.class, org.instantlogic.designer.entity.SharedElementDefinitionDesignEntity.fragment
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.SharedElementDefinitionDesign> get(
					org.instantlogic.designer.ElementDesign instance) {
				return instance.getPartOfSharedElementDefinitionRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		editorOpen,
		previewMode,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		childOfSelection,
		childrenForFragment,
		contentOfPage,
		partOfSharedElementDefinition,
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
	public java.util.Map<String, org.instantlogic.designer.ElementDesign> getStaticInstances() {
		return org.instantlogic.designer.ElementDesign.getStaticElementDesignInstances();
	}
}
