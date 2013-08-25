package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class PropertyDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.PropertyDesign> {

	public static final PropertyDesignEntity INSTANCE = new PropertyDesignEntity();
	

	
	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(true);
		return d0;
	}


	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.PropertyDesign, java.lang.Boolean, java.lang.Boolean> collapsed; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.PropertyDesign, java.lang.String, java.lang.String> propertyName; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PropertyDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.ElementDesign>, org.instantlogic.designer.ElementDesign> children;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> value;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> text;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign> fragment;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.PropertyDesign, java.lang.Boolean, java.lang.Boolean> $collapsed
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.PropertyDesign, java.lang.Boolean, java.lang.Boolean>(
				"Eayldornye_ywfwn_5f3957a5_1cc1", "collapsed", INSTANCE, java.lang.Boolean.class, "collapsed", org.instantlogic.designer.PropertyDesign.class);
		collapsed = $collapsed;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.PropertyDesign, java.lang.String, java.lang.String> $propertyName
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.PropertyDesign, java.lang.String, java.lang.String>(
				"QtknnqrEli_egmkw_a9205c04_d299", "propertyName", INSTANCE, java.lang.String.class, "propertyName", org.instantlogic.designer.PropertyDesign.class);
		propertyName = $propertyName;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.ElementDesign>, org.instantlogic.designer.ElementDesign> $children
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.ElementDesign>, org.instantlogic.designer.ElementDesign>(
				"Ladu_rzliedEufuE_ccd088e7_8051", "children", INSTANCE, "children", org.instantlogic.designer.PropertyDesign.class);
		children = $children;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $value
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"Zc_oErzycygsicxA_417ccb27_9253", "value", INSTANCE, "value", org.instantlogic.designer.PropertyDesign.class);
		value = $value;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> $text
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign>(
				"oaOAexOybeebwaei_fa042114_889b", "text", INSTANCE, "text", org.instantlogic.designer.PropertyDesign.class);
		text = $text;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign> $fragment
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign>(
				"BUjdEnzxEu_hoceg_b65391b1_29a8", "fragment", INSTANCE, "fragment", org.instantlogic.designer.PropertyDesign.class);
		fragment = $fragment;
		
		// Phase 2
		$collapsed.dataType.put("category", "boolean");
		$collapsed._default = createDeduction0();
		$propertyName.dataType.put("category", "text");

		$children.valueClass = org.instantlogic.designer.ElementDesign.class;
		$children.to = org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE;
		$children.setReverseRelation(org.instantlogic.designer.entity.ElementDesignEntity.childrenForFragment);
		$children.owner = true;
		$children.multivalue = true;
		$children.ordered = true;
		$value.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$value.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$value.owner = true;
		$text.valueClass = org.instantlogic.designer.TextTemplateDesign.class;
		$text.to = org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE;
		$text.owner = true;

		$fragment.reverse = true;
		$fragment.valueClass = org.instantlogic.designer.FragmentTemplateDesign.class;
		$fragment.to = org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE;
		$fragment.setReverseRelation(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.properties);
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
		return "ihequktqwId_mclE_0948dc40_47d6";
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
		value,
		text,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		fragment,
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
