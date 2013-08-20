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
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.PropertyDesign, java.lang.String, java.lang.String> propertyName; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.PropertyDesign, java.lang.Boolean, java.lang.Boolean> collapsed; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> value;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PropertyDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.ElementDesign>, org.instantlogic.designer.ElementDesign> children;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> text;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign> fragment;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.PropertyDesign, java.lang.String, java.lang.String> $propertyName
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.PropertyDesign, java.lang.String, java.lang.String>(
				"Qkukzznaeifmujvt_0721ecec_467d", "propertyName", INSTANCE, java.lang.String.class, "propertyName", org.instantlogic.designer.PropertyDesign.class);
		propertyName = $propertyName;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.PropertyDesign, java.lang.Boolean, java.lang.Boolean> $collapsed
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.PropertyDesign, java.lang.Boolean, java.lang.Boolean>(
				"otljthrOfIegajte_09ca36d3_8fa8", "collapsed", INSTANCE, java.lang.Boolean.class, "collapsed", org.instantlogic.designer.PropertyDesign.class);
		collapsed = $collapsed;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $value
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"HEfmlnOwwabvwmqn_0281c0ac_a45f", "value", INSTANCE, "value", org.instantlogic.designer.PropertyDesign.class);
		value = $value;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.ElementDesign>, org.instantlogic.designer.ElementDesign> $children
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.ElementDesign>, org.instantlogic.designer.ElementDesign>(
				"HldUIxEaxmbtg_ko_80ee6d73_8db0", "children", INSTANCE, "children", org.instantlogic.designer.PropertyDesign.class);
		children = $children;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> $text
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign>(
				"WaymxfIjmmewqmve_785b51bf_2234", "text", INSTANCE, "text", org.instantlogic.designer.PropertyDesign.class);
		text = $text;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign> $fragment
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign>(
				"RIwOUdf_uigyinrl_85c41327_55d7", "fragment", INSTANCE, "fragment", org.instantlogic.designer.PropertyDesign.class);
		fragment = $fragment;
		
		// Phase 2
		$propertyName.dataType.put("category", "text");
		$collapsed.dataType.put("category", "boolean");
		$collapsed._default = createDeduction0();

		$value.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$value.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$value.owner = true;
		$children.valueClass = org.instantlogic.designer.ElementDesign.class;
		$children.to = org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE;
		$children.setReverseRelation(org.instantlogic.designer.entity.ElementDesignEntity.childrenForFragment);
		$children.owner = true;
		$children.multivalue = true;
		$children.ordered = true;
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
		return "N_zE_csiamc_obOA_a2eab945_757b";
	}
	
	@Override
	public String getName() {
		return "PropertyDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		propertyName,
		collapsed,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		value,
		children,
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
