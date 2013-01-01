package ${rootPackageName}.flow;

@SuppressWarnings({"unchecked","rawtypes"})
public<#if isCustomized> abstract</#if> class <#if isCustomized>Abstract</#if>${technicalNameCapitalized}Flow extends org.instantlogic.interaction.flow.Flow {

	public static final ${technicalNameCapitalized}Flow INSTANCE = new <#if customization??>${customization}<#else>${technicalNameCapitalized}Flow</#if>();
	
	private static final org.instantlogic.interaction.flow.FlowNodeBase[] NODES = new org.instantlogic.interaction.flow.FlowNodeBase[]{
	<#list nodes as node>
		${rootPackageName}.flow.${name?lower_case}.${node.name}${node.type}.INSTANCE,
	</#list>
	};
	
	private static final org.instantlogic.interaction.flow.FlowEdge[] EDGES = new org.instantlogic.interaction.flow.FlowEdge[]{
	<#list edges as edge>
		new org.instantlogic.interaction.flow.FlowEdge(
			<#if edge.startNode??>${rootPackageName}.flow.${name?lower_case}.${edge.startNode}<#else>null</#if>, 
			<#if edge.event??>${rootPackageName}.event.${edge.event}Event.INSTANCE<#else>null</#if>,
			${rootPackageName}.flow.${name?lower_case}.${edge.endNode}
		),
	</#list>
	};
	
	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
	<#list parameters as parameter>
		${rootPackageName}.entity.${parameter}Entity.INSTANCE,
	</#list>
	};
	
	@Override
	public String getName() {
		return "${name}";
	}

	@Override
	public org.instantlogic.interaction.flow.FlowNodeBase[] getNodes() {
		return NODES;
	}

	@Override
	public org.instantlogic.interaction.flow.FlowEdge[] getEdges() {
		return EDGES;
	}

	@Override
	public org.instantlogic.fabric.model.Entity[] getParameters() {
		return PARAMETERS;
	}
}
