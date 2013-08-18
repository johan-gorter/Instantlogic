package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class ElementDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.ElementDesign> {

	public static final ElementDesignEntity INSTANCE = new ElementDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	private static final org.instantlogic.fabric.model.Entity<?>[] EXTENSIONS;
	 
	@Override
	public org.instantlogic.fabric.model.Entity[] extensions() {
		return EXTENSIONS;
	}
	
	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(false);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue("mobile");
		return d0;
	}


	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ElementDesign, java.lang.Boolean, java.lang.Boolean> editorOpen; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ElementDesign, java.lang.String, java.lang.String> previewMode; 
	
	// Relations
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.SharedElementDefinitionDesign> partOfSharedElementDefinition;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign> contentOfPage;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.PropertyDesign> childrenForFragment;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.SelectionDesign> childOfSelection;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ElementDesign, java.lang.Boolean, java.lang.Boolean> $editorOpen
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ElementDesign, java.lang.Boolean, java.lang.Boolean>(
				"Attributedesign__0028", "editorOpen", INSTANCE, java.lang.Boolean.class, "editorOpen", org.instantlogic.designer.ElementDesign.class);
		editorOpen = $editorOpen;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ElementDesign, java.lang.String, java.lang.String> $previewMode
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ElementDesign, java.lang.String, java.lang.String>(
				"Attributedesign__0029", "previewMode", INSTANCE, java.lang.String.class, "previewMode", org.instantlogic.designer.ElementDesign.class);
		previewMode = $previewMode;
		// Relations
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.SharedElementDefinitionDesign> $partOfSharedElementDefinition
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.SharedElementDefinitionDesign>(
				"Relationdesign__003e", "partOfSharedElementDefinition", INSTANCE, "partOfSharedElementDefinition", org.instantlogic.designer.ElementDesign.class);
		partOfSharedElementDefinition = $partOfSharedElementDefinition;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign> $contentOfPage
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign>(
				"Relationdesign__003f", "contentOfPage", INSTANCE, "contentOfPage", org.instantlogic.designer.ElementDesign.class);
		contentOfPage = $contentOfPage;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.PropertyDesign> $childrenForFragment
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.PropertyDesign>(
				"Relationdesign__0049", "childrenForFragment", INSTANCE, "childrenForFragment", org.instantlogic.designer.ElementDesign.class);
		childrenForFragment = $childrenForFragment;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.SelectionDesign> $childOfSelection
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.SelectionDesign>(
				"Relationdesign__004f", "childOfSelection", INSTANCE, "childOfSelection", org.instantlogic.designer.ElementDesign.class);
		childOfSelection = $childOfSelection;
		
		// Phase 2
		EXTENSIONS = new org.instantlogic.fabric.model.Entity<?>[] {
			org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE,
			org.instantlogic.designer.entity.IfElseDesignEntity.INSTANCE,
			org.instantlogic.designer.entity.SelectionDesignEntity.INSTANCE,
			org.instantlogic.designer.entity.SharedElementDesignEntity.INSTANCE
		};
		$editorOpen.dataType.put("category", "boolean");
		$editorOpen._default = createDeduction0();
		$previewMode.dataType.put("category", "text");
		$previewMode._default = createDeduction1();


		$partOfSharedElementDefinition.reverse = true;
		$partOfSharedElementDefinition.valueClass = org.instantlogic.designer.SharedElementDefinitionDesign.class;
		$partOfSharedElementDefinition.to = org.instantlogic.designer.entity.SharedElementDefinitionDesignEntity.INSTANCE;
		$partOfSharedElementDefinition.setReverseRelation(org.instantlogic.designer.entity.SharedElementDefinitionDesignEntity.fragment);
		$contentOfPage.reverse = true;
		$contentOfPage.valueClass = org.instantlogic.designer.PlaceTemplateDesign.class;
		$contentOfPage.to = org.instantlogic.designer.entity.PlaceTemplateDesignEntity.INSTANCE;
		$contentOfPage.setReverseRelation(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.content);
		$childrenForFragment.reverse = true;
		$childrenForFragment.valueClass = org.instantlogic.designer.PropertyDesign.class;
		$childrenForFragment.to = org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE;
		$childrenForFragment.setReverseRelation(org.instantlogic.designer.entity.PropertyDesignEntity.children);
		$childOfSelection.reverse = true;
		$childOfSelection.valueClass = org.instantlogic.designer.SelectionDesign.class;
		$childOfSelection.to = org.instantlogic.designer.entity.SelectionDesignEntity.INSTANCE;
		$childOfSelection.setReverseRelation(org.instantlogic.designer.entity.SelectionDesignEntity.child);
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
	public String getUniqueId() {
		return "Entitydesign__001a";
	}
	
	@Override
	public String getName() {
		return "ElementDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		editorOpen,
		previewMode,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		partOfSharedElementDefinition,
		contentOfPage,
		childrenForFragment,
		childOfSelection,
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
