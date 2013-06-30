package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.Design> {

	public static final DesignEntity INSTANCE = new DesignEntity();
	

	private static final org.instantlogic.fabric.model.Entity<?>[] EXTENSIONS;
	 
	@Override
	public org.instantlogic.fabric.model.Entity[] extensions() {
		return EXTENSIONS;
	}
	
	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DesignEntity.name);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.designer.deduction.DefaultDesignNameDeduction d0 = new org.instantlogic.designer.deduction.DefaultDesignNameDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction2() {
		  	org.instantlogic.designer.deduction.JavaIdentifierDeduction d0 = new org.instantlogic.designer.deduction.JavaIdentifierDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction3() {
		  	org.instantlogic.designer.deduction.TechnicalNameDeduction d0 = new org.instantlogic.designer.deduction.TechnicalNameDeduction();
		return d0;
	}


	// Title
	private static final org.instantlogic.fabric.text.TextTemplate title;
	@Override
	public org.instantlogic.fabric.text.TextTemplate getTitle() {
		return title;
	}
	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.Design, java.lang.String, java.lang.String> name; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.Design, java.lang.String, java.lang.String> javaIdentifier; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.Design, java.lang.String, java.lang.String> technicalName; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.Design, java.lang.Boolean, java.lang.Boolean> isCustomized; 
	
	// Relations
	
	// Reverse relations

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.Design, java.lang.String, java.lang.String> $name
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.Design, java.lang.String, java.lang.String>(
				"Attributedesign__0006", "name", INSTANCE, java.lang.String.class, "name", org.instantlogic.designer.AbstractDesign.class);
		name = $name;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.Design, java.lang.String, java.lang.String> $javaIdentifier
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.Design, java.lang.String, java.lang.String>(
				"Attributedesign__0007", "javaIdentifier", INSTANCE, java.lang.String.class, "javaIdentifier", org.instantlogic.designer.AbstractDesign.class);
		javaIdentifier = $javaIdentifier;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.Design, java.lang.String, java.lang.String> $technicalName
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.Design, java.lang.String, java.lang.String>(
				"Attributedesign__0008", "technicalName", INSTANCE, java.lang.String.class, "technicalName", org.instantlogic.designer.AbstractDesign.class);
		technicalName = $technicalName;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.Design, java.lang.Boolean, java.lang.Boolean> $isCustomized
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.Design, java.lang.Boolean, java.lang.Boolean>(
				"Attributedesign__0009", "isCustomized", INSTANCE, java.lang.Boolean.class, "isCustomized", org.instantlogic.designer.AbstractDesign.class);
		isCustomized = $isCustomized;
		// Relations
		// Reverse relations
		
		// Phase 2
		EXTENSIONS = new org.instantlogic.fabric.model.Entity<?>[] {
			org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE,
			org.instantlogic.designer.entity.DeductionOperationDesignEntity.INSTANCE,
			org.instantlogic.designer.entity.DeductionOperationInputDesignEntity.INSTANCE,
			org.instantlogic.designer.entity.DeductionOperationParameterDesignEntity.INSTANCE,
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
		$name.dataType.put("category", "text");
		$name._default = createDeduction1();
		$javaIdentifier.dataType.put("category", "text");
		$javaIdentifier.readOnly = true;
		$javaIdentifier.rule = createDeduction2();
		$technicalName.dataType.put("category", "text");
		$technicalName.readOnly = true;
		$technicalName.rule = createDeduction3();
		$isCustomized.dataType.put("category", "boolean");



		title = new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction0()).getTextTemplate();
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
	public String getUniqueId() {
		return "Entitydesign__0008";
	}
	
	@Override
	public String getName() {
		return "Design";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		name,
		javaIdentifier,
		technicalName,
		isCustomized,
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
