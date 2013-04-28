/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

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
			<#if edge.startNode??>${rootPackageName}.flow.${name?lower_case}.${edge.startNode}.INSTANCE<#else>null</#if>, 
			<#if edge.event??>${rootPackageName}.event.${edge.event}Event.INSTANCE<#else>null</#if>,
			${rootPackageName}.flow.${name?lower_case}.${edge.endNode}.INSTANCE
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
