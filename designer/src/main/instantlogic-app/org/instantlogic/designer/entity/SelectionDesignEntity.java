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
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> selection;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.ElementDesign, org.instantlogic.designer.ElementDesign> child;
	
	// Reverse relations

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $selection
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"Fx_pogkzUmgbwmyO_216754c3_9d6d", "selection", INSTANCE, "selection", org.instantlogic.designer.SelectionDesign.class);
		selection = $selection;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.ElementDesign, org.instantlogic.designer.ElementDesign> $child
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.ElementDesign, org.instantlogic.designer.ElementDesign>(
				"PUtuEvnryabxgnyI_e65abfc6_f599", "child", INSTANCE, "child", org.instantlogic.designer.SelectionDesign.class);
		child = $child;
		// Reverse relations
		
		// Phase 2

		$selection.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$selection.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$selection.setReverseRelation(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.selectionElement);
		$selection.owner = true;
		$selection.autoCreate = true;
		$child.valueClass = org.instantlogic.designer.ElementDesign.class;
		$child.to = org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE;
		$child.setReverseRelation(org.instantlogic.designer.entity.ElementDesignEntity.childOfSelection);
		$child.owner = true;

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
		return "Kccsopwdwe_semIA_d9decfa4_e253";
	}
	
	@Override
	public String getName() {
		return "SelectionDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		selection,
		child,
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
