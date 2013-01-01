package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class FlowEdgeDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.FlowEdgeDesign> {

	public static final FlowEdgeDesignEntity INSTANCE = new FlowEdgeDesignEntity();
	

	
	@Override
	public org.instantlogic.designer.FlowEdgeDesign createInstance() {
		return new org.instantlogic.designer.FlowEdgeDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.FlowEdgeDesign> getInstanceClass() {
		return org.instantlogic.designer.FlowEdgeDesign.class;
	}
	
	@Override
	public String getName() {
		return "FlowEdgeDesign";
	}

	// Deductions

	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowEdgeDesign, org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.designer.FlowNodeBaseDesign> endNode
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowEdgeDesign, org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.designer.FlowNodeBaseDesign>(
			"endNode", INSTANCE, org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE, org.instantlogic.designer.FlowNodeBaseDesign.class, 
			org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.incomingEdges
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.FlowEdgeDesign, org.instantlogic.designer.FlowNodeBaseDesign> get(
					org.instantlogic.designer.FlowEdgeDesign instance) {
				return instance.getEndNodeRelationValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowEdgeDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> event
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowEdgeDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign>(
			"event", INSTANCE, org.instantlogic.designer.entity.EventDesignEntity.INSTANCE, org.instantlogic.designer.EventDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.FlowEdgeDesign, org.instantlogic.designer.EventDesign> get(
					org.instantlogic.designer.FlowEdgeDesign instance) {
				return instance.getEventRelationValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowEdgeDesign, org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.designer.FlowNodeBaseDesign> startNode
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowEdgeDesign, org.instantlogic.designer.FlowNodeBaseDesign, org.instantlogic.designer.FlowNodeBaseDesign>(
			"startNode", INSTANCE, org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE, org.instantlogic.designer.FlowNodeBaseDesign.class, 
			org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.outgoingEdges
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.FlowEdgeDesign, org.instantlogic.designer.FlowNodeBaseDesign> get(
					org.instantlogic.designer.FlowEdgeDesign instance) {
				return instance.getStartNodeRelationValue();
			}
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowEdgeDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign> owner
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowEdgeDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign>(
			"owner", INSTANCE, org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE, org.instantlogic.designer.FlowDesign.class, org.instantlogic.designer.entity.FlowDesignEntity.edges
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.FlowEdgeDesign, org.instantlogic.designer.FlowDesign> get(
					org.instantlogic.designer.FlowEdgeDesign instance) {
				return instance.getOwnerRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		endNode,
		event,
		startNode,
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
