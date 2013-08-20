package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class FlowEdgeDesign extends org.instantlogic.fabric.Instance { 

	private static final java.util.Map<String, FlowEdgeDesign> _staticInstances = new java.util.LinkedHashMap<String, FlowEdgeDesign>();
	
	public static java.util.Map<String, FlowEdgeDesign> getStaticFlowEdgeDesignInstances() {
		return _staticInstances;
	}
	
	private static FlowEdgeDesign addStaticInstance(String name, FlowEdgeDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	  // Phase 1
	  // Phase 2
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.FlowEdgeDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<FlowEdgeDesign, EventDesign> event
		= createRelationValue(org.instantlogic.designer.entity.FlowEdgeDesignEntity.event);
		
	public org.instantlogic.fabric.value.RelationValue<FlowEdgeDesign, EventDesign> getEventRelationValue() {
		return event;
	}

	public org.instantlogic.designer.EventDesign getEvent() {
		return event.getValue();
	}
	
	public FlowEdgeDesign setEvent(org.instantlogic.designer.EventDesign newValue) {
		event.setValue(newValue);
		return (FlowEdgeDesign)this;
	}
	

	
	private final org.instantlogic.fabric.value.RelationValue<FlowEdgeDesign, FlowNodeBaseDesign> endNode
		= createRelationValue(org.instantlogic.designer.entity.FlowEdgeDesignEntity.endNode);
		
	public org.instantlogic.fabric.value.RelationValue<FlowEdgeDesign, FlowNodeBaseDesign> getEndNodeRelationValue() {
		return endNode;
	}

	public org.instantlogic.designer.FlowNodeBaseDesign getEndNode() {
		return endNode.getValue();
	}
	
	public FlowEdgeDesign setEndNode(org.instantlogic.designer.FlowNodeBaseDesign newValue) {
		endNode.setValue(newValue);
		return (FlowEdgeDesign)this;
	}
	

	
	private final org.instantlogic.fabric.value.RelationValue<FlowEdgeDesign, FlowNodeBaseDesign> startNode
		= createRelationValue(org.instantlogic.designer.entity.FlowEdgeDesignEntity.startNode);
		
	public org.instantlogic.fabric.value.RelationValue<FlowEdgeDesign, FlowNodeBaseDesign> getStartNodeRelationValue() {
		return startNode;
	}

	public org.instantlogic.designer.FlowNodeBaseDesign getStartNode() {
		return startNode.getValue();
	}
	
	public FlowEdgeDesign setStartNode(org.instantlogic.designer.FlowNodeBaseDesign newValue) {
		startNode.setValue(newValue);
		return (FlowEdgeDesign)this;
	}
	


	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<FlowEdgeDesign, FlowDesign> owner
		= createReverseRelationValue(org.instantlogic.designer.entity.FlowEdgeDesignEntity.owner);

	public org.instantlogic.fabric.value.RelationValue<FlowEdgeDesign, FlowDesign> getOwnerRelationValue() {
		return owner;
	}

	public org.instantlogic.designer.FlowDesign getOwner() {
		return owner.getValue();
	}

    public FlowEdgeDesign setOwner(org.instantlogic.designer.FlowDesign newValue) {
        owner.setValue(newValue);
        return (FlowEdgeDesign)this;
    }


}
