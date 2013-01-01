package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class FragmentTemplateDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.FragmentTemplateDesign> {

	public static final FragmentTemplateDesignEntity INSTANCE = new FragmentTemplateDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE;
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

	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentTypeDesign>> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.ApplicationDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentTypeDesign>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.ApplicationDesignEntity.fragmentTypes, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.AttributeDesign>> createDeduction1() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTemplateDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.EntityDesign> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.entity, d0);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.AttributeDesign>> d2 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.EntityDesignEntity.attributes, d1);
		return d2;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EntityDesign>> createDeduction2() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.ApplicationDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EntityDesign>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.ApplicationDesignEntity.entities, d0);
		return d1;
	}


	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Multi<java.lang.String>, java.lang.String> fragmentFilters 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Multi<java.lang.String>, java.lang.String>(
			"fragmentFilters", INSTANCE, java.lang.String.class
		) {
			{
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValues<org.instantlogic.designer.FragmentTemplateDesign, java.lang.String> get(org.instantlogic.designer.FragmentTemplateDesign instance) {
				return instance.getFragmentFiltersAttributeValue();
			}
	
			public boolean isMultivalue() {
				return true;
			}
            
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FragmentTemplateDesign, java.lang.String, java.lang.String> fragmentTypeName 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTemplateDesign, java.lang.String, java.lang.String>(
			"fragmentTypeName", INSTANCE, java.lang.String.class
		) {
			{
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.FragmentTemplateDesign, java.lang.String> get(org.instantlogic.designer.FragmentTemplateDesign instance) {
				return instance.getFragmentTypeNameAttributeValue();
			}
            
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Multi<java.lang.String>, java.lang.String> styleNames 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Multi<java.lang.String>, java.lang.String>(
			"styleNames", INSTANCE, java.lang.String.class
		) {
			{
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValues<org.instantlogic.designer.FragmentTemplateDesign, java.lang.String> get(org.instantlogic.designer.FragmentTemplateDesign instance) {
				return instance.getStyleNamesAttributeValue();
			}
	
			public boolean isMultivalue() {
				return true;
			}
            
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> attribute
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
			"attribute", INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.AttributeDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.AttributeDesign> get(
					org.instantlogic.designer.FragmentTemplateDesign instance) {
				return instance.getAttributeRelationValue();
			}
			
			private org.instantlogic.fabric.deduction.Deduction<? extends java.lang.Iterable<org.instantlogic.designer.AttributeDesign>> options;
			@Override
			public org.instantlogic.fabric.deduction.Deduction<? extends java.lang.Iterable<org.instantlogic.designer.AttributeDesign>> getOptions() {
				if (options==null) {
					options = (org.instantlogic.fabric.deduction.Deduction)createDeduction1();
				}
				return options;
			};
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> entity
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
			"entity", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.FragmentTemplateDesign instance) {
				return instance.getEntityRelationValue();
			}
			
			private org.instantlogic.fabric.deduction.Deduction<? extends java.lang.Iterable<org.instantlogic.designer.EntityDesign>> options;
			@Override
			public org.instantlogic.fabric.deduction.Deduction<? extends java.lang.Iterable<org.instantlogic.designer.EntityDesign>> getOptions() {
				if (options==null) {
					options = (org.instantlogic.fabric.deduction.Deduction)createDeduction2();
				}
				return options;
			};
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> event
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign>(
			"event", INSTANCE, org.instantlogic.designer.entity.EventDesignEntity.INSTANCE, org.instantlogic.designer.EventDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.EventDesign> get(
					org.instantlogic.designer.FragmentTemplateDesign instance) {
				return instance.getEventRelationValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PropertyDesign>, org.instantlogic.designer.PropertyDesign> properties
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PropertyDesign>, org.instantlogic.designer.PropertyDesign>(
			"properties", INSTANCE, org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE, org.instantlogic.designer.PropertyDesign.class, 
			org.instantlogic.designer.entity.PropertyDesignEntity.fragment
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.PropertyDesign> get(
					org.instantlogic.designer.FragmentTemplateDesign instance) {
				return instance.getPropertiesRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.designer.FragmentTypeDesign> type
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTypeDesign, org.instantlogic.designer.FragmentTypeDesign>(
			"type", INSTANCE, org.instantlogic.designer.entity.FragmentTypeDesignEntity.INSTANCE, org.instantlogic.designer.FragmentTypeDesign.class, 
			org.instantlogic.designer.entity.FragmentTypeDesignEntity.usages
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTypeDesign> get(
					org.instantlogic.designer.FragmentTemplateDesign instance) {
				return instance.getTypeRelationValue();
			}
			
			private org.instantlogic.fabric.deduction.Deduction<? extends java.lang.Iterable<org.instantlogic.designer.FragmentTypeDesign>> options;
			@Override
			public org.instantlogic.fabric.deduction.Deduction<? extends java.lang.Iterable<org.instantlogic.designer.FragmentTypeDesign>> getOptions() {
				if (options==null) {
					options = (org.instantlogic.fabric.deduction.Deduction)createDeduction0();
				}
				return options;
			};
		};
	
	// Reverse relations

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
