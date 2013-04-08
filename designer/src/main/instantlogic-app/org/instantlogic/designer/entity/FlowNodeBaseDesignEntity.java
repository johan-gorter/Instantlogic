package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class FlowNodeBaseDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.FlowNodeBaseDesign> {

	public static final FlowNodeBaseDesignEntity INSTANCE = new FlowNodeBaseDesignEntity();
	
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

	
	// Attributes
	
	// Relations
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign>, org.instantlogic.designer.FlowEdgeDesign> incomingEdges;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign>, org.instantlogic.designer.FlowEdgeDesign> outgoingEdges;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign> owner;

	static {
		// Phase 1
		// Phase "reverse relations"
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign>, org.instantlogic.designer.FlowEdgeDesign> $incomingEdges
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign>, org.instantlogic.designer.FlowEdgeDesign>(
				"incomingEdges", INSTANCE, "incomingEdges", org.instantlogic.designer.FlowNodeBaseDesign.class);
		incomingEdges = $incomingEdges;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign>, org.instantlogic.designer.FlowEdgeDesign> $outgoingEdges
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign>, org.instantlogic.designer.FlowEdgeDesign>(
				"outgoingEdges", INSTANCE, "outgoingEdges", org.instantlogic.designer.FlowNodeBaseDesign.class);
		outgoingEdges = $outgoingEdges;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign> $owner
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign>(
				"owner", INSTANCE, "owner", org.instantlogic.designer.FlowNodeBaseDesign.class);
		owner = $owner;
		
		// Phase 2
		EXTENSIONS = new org.instantlogic.fabric.model.Entity<?>[] {
			org.instantlogic.designer.entity.PlaceTemplateDesignEntity.INSTANCE,
			org.instantlogic.designer.entity.SubFlowDesignEntity.INSTANCE
		};


		$incomingEdges.valueClass = org.instantlogic.designer.FlowEdgeDesign.class;
		$incomingEdges.to = org.instantlogic.designer.entity.FlowEdgeDesignEntity.INSTANCE;
		$incomingEdges.setReverseRelation(org.instantlogic.designer.entity.FlowEdgeDesignEntity.endNode);
		$incomingEdges.reverse = true;
		$incomingEdges.multivalue = true;
		$outgoingEdges.valueClass = org.instantlogic.designer.FlowEdgeDesign.class;
		$outgoingEdges.to = org.instantlogic.designer.entity.FlowEdgeDesignEntity.INSTANCE;
		$outgoingEdges.setReverseRelation(org.instantlogic.designer.entity.FlowEdgeDesignEntity.startNode);
		$outgoingEdges.reverse = true;
		$outgoingEdges.multivalue = true;
		$owner.valueClass = org.instantlogic.designer.FlowDesign.class;
		$owner.to = org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE;
		$owner.setReverseRelation(org.instantlogic.designer.entity.FlowDesignEntity.nodes);
		$owner.reverse = true;
	}

	@Override
	public org.instantlogic.designer.FlowNodeBaseDesign createInstance() {
		return new org.instantlogic.designer.FlowNodeBaseDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.FlowNodeBaseDesign> getInstanceClass() {
		return org.instantlogic.designer.FlowNodeBaseDesign.class;
	}
	
	@Override
	public String getName() {
		return "FlowNodeBaseDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		incomingEdges,
		outgoingEdges,
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
	public java.util.Map<String, org.instantlogic.designer.FlowNodeBaseDesign> getStaticInstances() {
		return org.instantlogic.designer.FlowNodeBaseDesign.getStaticFlowNodeBaseDesignInstances();
	}
}
