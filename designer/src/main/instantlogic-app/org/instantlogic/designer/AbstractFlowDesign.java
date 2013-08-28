package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public abstract class AbstractFlowDesign extends Design { 

	private static final java.util.Map<String, FlowDesign> _staticInstances = new java.util.LinkedHashMap<String, FlowDesign>();
	
	public static java.util.Map<String, FlowDesign> getStaticFlowDesignInstances() {
		return _staticInstances;
	}
	
	private static FlowDesign addStaticInstance(String name, FlowDesign instance) {
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
		return org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<FlowDesign, FlowEdgeDesign> edges
		= createRelationValues(org.instantlogic.designer.entity.FlowDesignEntity.edges);
		
	public org.instantlogic.fabric.value.RelationValues<FlowDesign, FlowEdgeDesign> getEdgesRelationValue() {
		return edges;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowEdgeDesign> getEdges() {
		return edges.getValue();
	}
	
	public FlowDesign addToEdges(FlowEdgeDesign item) {
		edges.addValue(item);
		return (FlowDesign)this;
	}
	
	public FlowDesign removeFromEdges(FlowEdgeDesign item) {
		edges.removeValue(item);
		return (FlowDesign)this;
	}
	
	
	
	private final org.instantlogic.fabric.value.RelationValues<FlowDesign, FlowNodeBaseDesign> nodes
		= createRelationValues(org.instantlogic.designer.entity.FlowDesignEntity.nodes);
		
	public org.instantlogic.fabric.value.RelationValues<FlowDesign, FlowNodeBaseDesign> getNodesRelationValue() {
		return nodes;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowNodeBaseDesign> getNodes() {
		return nodes.getValue();
	}
	
	public FlowDesign addToNodes(FlowNodeBaseDesign item) {
		nodes.addValue(item);
		return (FlowDesign)this;
	}
	
	public FlowDesign removeFromNodes(FlowNodeBaseDesign item) {
		nodes.removeValue(item);
		return (FlowDesign)this;
	}
	
	
	
	private final org.instantlogic.fabric.value.RelationValues<FlowDesign, EntityDesign> parameters
		= createRelationValues(org.instantlogic.designer.entity.FlowDesignEntity.parameters);
		
	public org.instantlogic.fabric.value.RelationValues<FlowDesign, EntityDesign> getParametersRelationValue() {
		return parameters;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign> getParameters() {
		return parameters.getValue();
	}
	
	public FlowDesign addToParameters(EntityDesign item) {
		parameters.addValue(item);
		return (FlowDesign)this;
	}
	
	public FlowDesign removeFromParameters(EntityDesign item) {
		parameters.removeValue(item);
		return (FlowDesign)this;
	}
	
	

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<FlowDesign, ApplicationDesign> application
		= createReverseRelationValue(org.instantlogic.designer.entity.FlowDesignEntity.application);

	public org.instantlogic.fabric.value.RelationValue<FlowDesign, ApplicationDesign> getApplicationRelationValue() {
		return application;
	}

	public org.instantlogic.designer.ApplicationDesign getApplication() {
		return application.getValue();
	}

    public FlowDesign setApplication(org.instantlogic.designer.ApplicationDesign newValue) {
        application.setValue(newValue);
        return (FlowDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<FlowDesign, SubFlowDesign> subFlowIn
		= createReverseRelationValue(org.instantlogic.designer.entity.FlowDesignEntity.subFlowIn);

	public org.instantlogic.fabric.value.RelationValue<FlowDesign, SubFlowDesign> getSubFlowInRelationValue() {
		return subFlowIn;
	}

	public org.instantlogic.designer.SubFlowDesign getSubFlowIn() {
		return subFlowIn.getValue();
	}

    public FlowDesign setSubFlowIn(org.instantlogic.designer.SubFlowDesign newValue) {
        subFlowIn.setValue(newValue);
        return (FlowDesign)this;
    }


}
