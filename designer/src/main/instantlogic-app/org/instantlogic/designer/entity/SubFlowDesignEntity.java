package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class SubFlowDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.SubFlowDesign> {

	public static final SubFlowDesignEntity INSTANCE = new SubFlowDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE;
	}

	
	// Deductions

	
	// Attributes
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.SubFlowDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign> flow;
	
	// Reverse relations

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SubFlowDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign> $flow
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SubFlowDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign>(
				"WfvnwfcnuIgzqcAn_b9d4a637_9c1f", "flow", INSTANCE, "flow", org.instantlogic.designer.SubFlowDesign.class);
		flow = $flow;
		// Reverse relations
		
		// Phase 2

		$flow.valueClass = org.instantlogic.designer.FlowDesign.class;
		$flow.to = org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE;
		$flow.setReverseRelation(org.instantlogic.designer.entity.FlowDesignEntity.subFlowIn);

	}

	@Override
	public org.instantlogic.designer.SubFlowDesign createInstance() {
		return new org.instantlogic.designer.SubFlowDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.SubFlowDesign> getInstanceClass() {
		return org.instantlogic.designer.SubFlowDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "OiwwnuEgmidiucEA_c5d9b61d_e085";
	}
	
	@Override
	public String getName() {
		return "SubFlowDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		flow,
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
	public java.util.Map<String, org.instantlogic.designer.SubFlowDesign> getStaticInstances() {
		return org.instantlogic.designer.SubFlowDesign.getStaticSubFlowDesignInstances();
	}
}
