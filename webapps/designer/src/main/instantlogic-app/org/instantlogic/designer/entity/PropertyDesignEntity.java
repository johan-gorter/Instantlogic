package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class PropertyDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.PropertyDesign> {

	public static final PropertyDesignEntity INSTANCE = new PropertyDesignEntity();
	

	private static final org.instantlogic.fabric.model.Entity<?>[] EXTENSIONS;
	 
	@Override
	public org.instantlogic.fabric.model.Entity[] extensions() {
		return EXTENSIONS;
	}
	
	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.PropertyDesignEntity.propertyName);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(true);
		return d0;
	}


	// Title
	private static final org.instantlogic.fabric.text.TextTemplate title;
	@Override
	public org.instantlogic.fabric.text.TextTemplate getTitle() {
		return title;
	}
	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.PropertyDesign, java.lang.Boolean, java.lang.Boolean> collapsed; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.PropertyDesign, java.lang.String, java.lang.String> propertyName; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PropertyDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.ElementDesign>, org.instantlogic.designer.ElementDesign> children;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> text;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> value;
	
	// Reverse relations

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.PropertyDesign, java.lang.Boolean, java.lang.Boolean> $collapsed
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.PropertyDesign, java.lang.Boolean, java.lang.Boolean>(
				"AttributeDesign_collapsed", "collapsed", INSTANCE, java.lang.Boolean.class, "collapsed", org.instantlogic.designer.PropertyDesign.class);
		collapsed = $collapsed;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.PropertyDesign, java.lang.String, java.lang.String> $propertyName
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.PropertyDesign, java.lang.String, java.lang.String>(
				"AttributeDesign_propertyName", "propertyName", INSTANCE, java.lang.String.class, "propertyName", org.instantlogic.designer.PropertyDesign.class);
		propertyName = $propertyName;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.ElementDesign>, org.instantlogic.designer.ElementDesign> $children
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.ElementDesign>, org.instantlogic.designer.ElementDesign>(
				"RelationDesign_children", "children", INSTANCE, "children", org.instantlogic.designer.PropertyDesign.class);
		children = $children;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> $text
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign>(
				"RelationDesign_text", "text", INSTANCE, "text", org.instantlogic.designer.PropertyDesign.class);
		text = $text;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $value
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"RelationDesign_value", "value", INSTANCE, "value", org.instantlogic.designer.PropertyDesign.class);
		value = $value;
		// Reverse relations
		
		// Phase 2
		EXTENSIONS = new org.instantlogic.fabric.model.Entity<?>[] {
			org.instantlogic.designer.entity.FragmentTemplateContentDesignEntity.INSTANCE,
			org.instantlogic.designer.entity.FragmentTemplateTextDesignEntity.INSTANCE,
			org.instantlogic.designer.entity.FragmentTemplateValueDesignEntity.INSTANCE
		};
		$collapsed.dataType.put("category", "boolean");
		$collapsed._default = createDeduction1();
		$propertyName.dataType.put("category", "text");

		$children.valueClass = org.instantlogic.designer.ElementDesign.class;
		$children.to = org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE;
		$children.setReverseRelation(org.instantlogic.designer.entity.ElementDesignEntity.childrenForFragment);
		$children.owner = true;
		$children.multivalue = true;
		$children.ordered = true;
		$text.valueClass = org.instantlogic.designer.TextTemplateDesign.class;
		$text.to = org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE;
		$text.setReverseRelation(org.instantlogic.designer.entity.TextTemplateDesignEntity.textOnPropertyDesign);
		$text.owner = true;
		$value.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$value.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$value.setReverseRelation(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.valueOnPropertyDesign);
		$value.owner = true;


		title = new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction0()).getTextTemplate();
	}

	@Override
	public org.instantlogic.designer.PropertyDesign createInstance() {
		return new org.instantlogic.designer.PropertyDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.PropertyDesign> getInstanceClass() {
		return org.instantlogic.designer.PropertyDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "EntityDesign_PropertyDesign";
	}
	
	@Override
	public String getName() {
		return "PropertyDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		collapsed,
		propertyName,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		children,
		text,
		value,
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
	public java.util.Map<String, org.instantlogic.designer.PropertyDesign> getStaticInstances() {
		return org.instantlogic.designer.PropertyDesign.getStaticPropertyDesignInstances();
	}
}
