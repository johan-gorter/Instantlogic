package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class SelectionDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.SelectionDesign> {

	public static final SelectionDesignEntity INSTANCE = new SelectionDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE;
	}

	
	// Deductions

	
	// Attributes
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.ElementDesign, org.instantlogic.designer.ElementDesign> child;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> selection;
	
	// Reverse relations

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.ElementDesign, org.instantlogic.designer.ElementDesign> $child
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.ElementDesign, org.instantlogic.designer.ElementDesign>(
				"UAcuIsixhi_jecAw_62209cd2_0804", "child", INSTANCE, "child", org.instantlogic.designer.SelectionDesign.class);
		child = $child;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $selection
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"upksAfiynactkksn_c38a64d4_997e", "selection", INSTANCE, "selection", org.instantlogic.designer.SelectionDesign.class);
		selection = $selection;
		// Reverse relations
		
		// Phase 2

		$child.valueClass = org.instantlogic.designer.ElementDesign.class;
		$child.to = org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE;
		$child.setReverseRelation(org.instantlogic.designer.entity.ElementDesignEntity.childOfSelection);
		$child.owner = true;
		$selection.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$selection.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$selection.setReverseRelation(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.selectionElement);
		$selection.owner = true;
		$selection.autoCreate = true;

	}

	@Override
	public org.instantlogic.designer.SelectionDesign createInstance() {
		return new org.instantlogic.designer.SelectionDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.SelectionDesign> getInstanceClass() {
		return org.instantlogic.designer.SelectionDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "QaezhmvueugUcgtl_d8430bb2_628d";
	}
	
	@Override
	public String getName() {
		return "SelectionDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		child,
		selection,
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
	public java.util.Map<String, org.instantlogic.designer.SelectionDesign> getStaticInstances() {
		return org.instantlogic.designer.SelectionDesign.getStaticSelectionDesignInstances();
	}
}
