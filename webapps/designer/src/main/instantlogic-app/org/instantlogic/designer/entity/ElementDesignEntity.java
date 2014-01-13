package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class ElementDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.ElementDesign> {

	public static final ElementDesignEntity INSTANCE = new ElementDesignEntity();
	

	private static final org.instantlogic.fabric.model.Entity<?>[] EXTENSIONS;
	 
	@Override
	public org.instantlogic.fabric.model.Entity[] extensions() {
		return EXTENSIONS;
	}
	
	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue("mobile");
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(false);
		return d0;
	}


	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ElementDesign, java.lang.String, java.lang.String> previewMode; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ElementDesign, java.lang.Boolean, java.lang.Boolean> editorOpen; 
	
	// Relations
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.PropertyDesign> childrenForFragment;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign> contentOfPage;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.IfElseDesign> ifChildOnIfElseDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.SelectionDesign> childOfSelection;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.IfElseDesign> elseChildOnIfElseDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.SharedElementDefinitionDesign> partOfSharedElementDefinition;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ElementDesign, java.lang.String, java.lang.String> $previewMode
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ElementDesign, java.lang.String, java.lang.String>(
				"NvnbsdpniIfUcguU_99e8f545_9dcc", "previewMode", INSTANCE, java.lang.String.class, "previewMode", org.instantlogic.designer.ElementDesign.class);
		previewMode = $previewMode;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ElementDesign, java.lang.Boolean, java.lang.Boolean> $editorOpen
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ElementDesign, java.lang.Boolean, java.lang.Boolean>(
				"Tolibtsciuelonmj_3cb44069_cfef", "editorOpen", INSTANCE, java.lang.Boolean.class, "editorOpen", org.instantlogic.designer.ElementDesign.class);
		editorOpen = $editorOpen;
		// Relations
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.PropertyDesign> $childrenForFragment
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.PropertyDesign>(
				"EodOspApymcuy_sz_65607c6e_ccd1", "childrenForFragment", INSTANCE, "childrenForFragment", org.instantlogic.designer.ElementDesign.class);
		childrenForFragment = $childrenForFragment;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign> $contentOfPage
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign>(
				"KltgvgzezebwkmdE_acaa2c56_3f2a", "contentOfPage", INSTANCE, "contentOfPage", org.instantlogic.designer.ElementDesign.class);
		contentOfPage = $contentOfPage;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.IfElseDesign> $ifChildOnIfElseDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.IfElseDesign>(
				"OEybAE_nomfkkjOw_033f4de0_86e1", "ifChildOnIfElseDesign", INSTANCE, "ifChildOnIfElseDesign", org.instantlogic.designer.ElementDesign.class);
		ifChildOnIfElseDesign = $ifChildOnIfElseDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.SelectionDesign> $childOfSelection
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.SelectionDesign>(
				"UAcuIsixhi_jecAw_62209cd2_0804", "childOfSelection", INSTANCE, "childOfSelection", org.instantlogic.designer.ElementDesign.class);
		childOfSelection = $childOfSelection;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.IfElseDesign> $elseChildOnIfElseDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.IfElseDesign>(
				"esnfqzyexageoain_f9f3d6b8_5087", "elseChildOnIfElseDesign", INSTANCE, "elseChildOnIfElseDesign", org.instantlogic.designer.ElementDesign.class);
		elseChildOnIfElseDesign = $elseChildOnIfElseDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.SharedElementDefinitionDesign> $partOfSharedElementDefinition
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ElementDesign, org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.SharedElementDefinitionDesign>(
				"odtmutjyIy_kabms_052ed2e3_496b", "partOfSharedElementDefinition", INSTANCE, "partOfSharedElementDefinition", org.instantlogic.designer.ElementDesign.class);
		partOfSharedElementDefinition = $partOfSharedElementDefinition;
		
		// Phase 2
		EXTENSIONS = new org.instantlogic.fabric.model.Entity<?>[] {
			org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE,
			org.instantlogic.designer.entity.IfElseDesignEntity.INSTANCE,
			org.instantlogic.designer.entity.SelectionDesignEntity.INSTANCE,
			org.instantlogic.designer.entity.SharedElementDesignEntity.INSTANCE
		};
		$previewMode.dataType.put("category", "text");
		$previewMode._default = createDeduction0();
		$editorOpen.dataType.put("category", "boolean");
		$editorOpen._default = createDeduction1();


		$childrenForFragment.reverse = true;
		$childrenForFragment.valueClass = org.instantlogic.designer.PropertyDesign.class;
		$childrenForFragment.to = org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE;
		$childrenForFragment.setReverseRelation(org.instantlogic.designer.entity.PropertyDesignEntity.children);
		$contentOfPage.reverse = true;
		$contentOfPage.valueClass = org.instantlogic.designer.PlaceTemplateDesign.class;
		$contentOfPage.to = org.instantlogic.designer.entity.PlaceTemplateDesignEntity.INSTANCE;
		$contentOfPage.setReverseRelation(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.content);
		$ifChildOnIfElseDesign.reverse = true;
		$ifChildOnIfElseDesign.valueClass = org.instantlogic.designer.IfElseDesign.class;
		$ifChildOnIfElseDesign.to = org.instantlogic.designer.entity.IfElseDesignEntity.INSTANCE;
		$ifChildOnIfElseDesign.setReverseRelation(org.instantlogic.designer.entity.IfElseDesignEntity.ifChild);
		$childOfSelection.reverse = true;
		$childOfSelection.valueClass = org.instantlogic.designer.SelectionDesign.class;
		$childOfSelection.to = org.instantlogic.designer.entity.SelectionDesignEntity.INSTANCE;
		$childOfSelection.setReverseRelation(org.instantlogic.designer.entity.SelectionDesignEntity.child);
		$elseChildOnIfElseDesign.reverse = true;
		$elseChildOnIfElseDesign.valueClass = org.instantlogic.designer.IfElseDesign.class;
		$elseChildOnIfElseDesign.to = org.instantlogic.designer.entity.IfElseDesignEntity.INSTANCE;
		$elseChildOnIfElseDesign.setReverseRelation(org.instantlogic.designer.entity.IfElseDesignEntity.elseChild);
		$partOfSharedElementDefinition.reverse = true;
		$partOfSharedElementDefinition.valueClass = org.instantlogic.designer.SharedElementDefinitionDesign.class;
		$partOfSharedElementDefinition.to = org.instantlogic.designer.entity.SharedElementDefinitionDesignEntity.INSTANCE;
		$partOfSharedElementDefinition.setReverseRelation(org.instantlogic.designer.entity.SharedElementDefinitionDesignEntity.fragment);
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
		return "QgArvl_sqIbnsgjw_55852685_31f4";
	}
	
	@Override
	public String getName() {
		return "ElementDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		previewMode,
		editorOpen,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		childrenForFragment,
		contentOfPage,
		ifChildOnIfElseDesign,
		childOfSelection,
		elseChildOnIfElseDesign,
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
