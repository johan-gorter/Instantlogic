package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class SubFlowDesign extends FlowNodeBaseDesign { 

	private static final java.util.Map<String, SubFlowDesign> _staticInstances = new java.util.LinkedHashMap<String, SubFlowDesign>();
	
	public static java.util.Map<String, SubFlowDesign> getStaticSubFlowDesignInstances() {
		return _staticInstances;
	}
	
	private static SubFlowDesign addStaticInstance(String name, SubFlowDesign instance) {
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
		return org.instantlogic.designer.entity.SubFlowDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<SubFlowDesign, FlowDesign> flow
		= createRelationValue(org.instantlogic.designer.entity.SubFlowDesignEntity.flow);
		
	public org.instantlogic.fabric.value.RelationValue<SubFlowDesign, FlowDesign> getFlowRelationValue() {
		return flow;
	}

	public org.instantlogic.designer.FlowDesign getFlow() {
		return flow.getValue();
	}
	
	public SubFlowDesign setFlow(org.instantlogic.designer.FlowDesign newValue) {
		flow.setValue(newValue);
		return (SubFlowDesign)this;
	}
	


	// Reverse relations

}
