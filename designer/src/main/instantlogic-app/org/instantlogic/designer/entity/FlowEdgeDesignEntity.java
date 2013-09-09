package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class FlowEdgeDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.FlowEdgeDesign> {

	public static final FlowEdgeDesignEntity INSTANCE = new FlowEdgeDesignEntity();
	

	
	// Deductions

	
	// Attributes
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowEdgeDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> event;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowEdgeDesign, org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.designer.FlowNodeBaseDesign> startNode;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowEdgeDesign, org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.designer.FlowNodeBaseDesign> endNode;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowEdgeDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign> owner;

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowEdgeDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> $event
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowEdgeDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign>(
				"CbrfpEuO_Id_Aasm_23ee0000_56dd", "event", INSTANCE, "event", org.instantlogic.designer.FlowEdgeDesign.class);
		event = $event;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowEdgeDesign, org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.designer.FlowNodeBaseDesign> $startNode
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowEdgeDesign, org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.designer.FlowNodeBaseDesign>(
				"PylzpIqIsm_nijij_e2e52c82_4fe1", "startNode", INSTANCE, "startNode", org.instantlogic.designer.FlowEdgeDesign.class);
		startNode = $startNode;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowEdgeDesign, org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.designer.FlowNodeBaseDesign> $endNode
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowEdgeDesign, org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.designer.FlowNodeBaseDesign>(
				"eAnimlhdgqbcqjUt_9c486307_4756", "endNode", INSTANCE, "endNode", org.instantlogic.designer.FlowEdgeDesign.class);
		endNode = $endNode;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowEdgeDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign> $owner
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowEdgeDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign>(
				"itatvbqumy_pImww_a3416540_1a75", "owner", INSTANCE, "owner", org.instantlogic.designer.FlowEdgeDesign.class);
		owner = $owner;
		
		// Phase 2

		$event.valueClass = org.instantlogic.designer.EventDesign.class;
		$event.to = org.instantlogic.designer.entity.EventDesignEntity.INSTANCE;
		$startNode.valueClass = org.instantlogic.designer.FlowNodeBaseDesign.class;
		$startNode.to = org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE;
		$startNode.setReverseRelation(org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.outgoingEdges);
		$endNode.valueClass = org.instantlogic.designer.FlowNodeBaseDesign.class;
		$endNode.to = org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE;
		$endNode.setReverseRelation(org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.incomingEdges);

		$owner.reverse = true;
		$owner.valueClass = org.instantlogic.designer.FlowDesign.class;
		$owner.to = org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE;
		$owner.setReverseRelation(org.instantlogic.designer.entity.FlowDesignEntity.edges);
	}

	@Override
	public org.instantlogic.designer.FlowEdgeDesign createInstance() {
		return new org.instantlogic.designer.FlowEdgeDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.FlowEdgeDesign> getInstanceClass() {
		return org.instantlogic.designer.FlowEdgeDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "SfUqv_Eioifbwked_ff1553fe_01ab";
	}
	
	@Override
	public String getName() {
		return "FlowEdgeDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		event,
		startNode,
		endNode,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		owner,
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
	public java.util.Map<String, org.instantlogic.designer.FlowEdgeDesign> getStaticInstances() {
		return org.instantlogic.designer.FlowEdgeDesign.getStaticFlowEdgeDesignInstances();
	}
}
