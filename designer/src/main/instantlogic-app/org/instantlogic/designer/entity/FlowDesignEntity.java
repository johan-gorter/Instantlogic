package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class FlowDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.FlowDesign> {

	public static final FlowDesignEntity INSTANCE = new FlowDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	
	// Deductions

	
	// Attributes
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> parameters;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowEdgeDesign>, org.instantlogic.designer.FlowEdgeDesign> edges;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowNodeBaseDesign>, org.instantlogic.designer.FlowNodeBaseDesign> nodes;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> application;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FlowDesign, org.instantlogic.designer.SubFlowDesign, org.instantlogic.designer.SubFlowDesign> subFlowIn;

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> $parameters
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign>(
				"QuEaiogvje_lUcqd_e2a8a92b_263c", "parameters", INSTANCE, "parameters", org.instantlogic.designer.AbstractFlowDesign.class);
		parameters = $parameters;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowEdgeDesign>, org.instantlogic.designer.FlowEdgeDesign> $edges
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowEdgeDesign>, org.instantlogic.designer.FlowEdgeDesign>(
				"XgnAUgsfhabqinky_1971e432_4ea4", "edges", INSTANCE, "edges", org.instantlogic.designer.AbstractFlowDesign.class);
		edges = $edges;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowNodeBaseDesign>, org.instantlogic.designer.FlowNodeBaseDesign> $nodes
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowNodeBaseDesign>, org.instantlogic.designer.FlowNodeBaseDesign>(
				"amzjlifmsebyIbpy_a4106e9f_0205", "nodes", INSTANCE, "nodes", org.instantlogic.designer.AbstractFlowDesign.class);
		nodes = $nodes;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> $application
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
				"KolswtrlEuacIgOU_4eefa492_7205", "application", INSTANCE, "application", org.instantlogic.designer.AbstractFlowDesign.class);
		application = $application;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowDesign, org.instantlogic.designer.SubFlowDesign, org.instantlogic.designer.SubFlowDesign> $subFlowIn
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FlowDesign, org.instantlogic.designer.SubFlowDesign, org.instantlogic.designer.SubFlowDesign>(
				"VpeIhtfeyadxmgsy_8a140945_99b1", "subFlowIn", INSTANCE, "subFlowIn", org.instantlogic.designer.AbstractFlowDesign.class);
		subFlowIn = $subFlowIn;
		
		// Phase 2

		$parameters.valueClass = org.instantlogic.designer.EntityDesign.class;
		$parameters.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$parameters.multivalue = true;
		$edges.valueClass = org.instantlogic.designer.FlowEdgeDesign.class;
		$edges.to = org.instantlogic.designer.entity.FlowEdgeDesignEntity.INSTANCE;
		$edges.setReverseRelation(org.instantlogic.designer.entity.FlowEdgeDesignEntity.owner);
		$edges.owner = true;
		$edges.multivalue = true;
		$nodes.valueClass = org.instantlogic.designer.FlowNodeBaseDesign.class;
		$nodes.to = org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE;
		$nodes.setReverseRelation(org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.owner);
		$nodes.owner = true;
		$nodes.multivalue = true;

		$application.reverse = true;
		$application.valueClass = org.instantlogic.designer.ApplicationDesign.class;
		$application.to = org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
		$application.setReverseRelation(org.instantlogic.designer.entity.ApplicationDesignEntity.flows);
		$subFlowIn.reverse = true;
		$subFlowIn.valueClass = org.instantlogic.designer.SubFlowDesign.class;
		$subFlowIn.to = org.instantlogic.designer.entity.SubFlowDesignEntity.INSTANCE;
		$subFlowIn.setReverseRelation(org.instantlogic.designer.entity.SubFlowDesignEntity.flow);
	}

	@Override
	public org.instantlogic.designer.FlowDesign createInstance() {
		return new org.instantlogic.designer.FlowDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.FlowDesign> getInstanceClass() {
		return org.instantlogic.designer.FlowDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "OEEnonewmackajAp_05a41e8e_1f6a";
	}
	
	@Override
	public String getName() {
		return "FlowDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		parameters,
		edges,
		nodes,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		application,
		subFlowIn,
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
	public java.util.Map<String, org.instantlogic.designer.FlowDesign> getStaticInstances() {
		return org.instantlogic.designer.FlowDesign.getStaticFlowDesignInstances();
	}
}
