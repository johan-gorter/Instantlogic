/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer.flow;

@SuppressWarnings({"unchecked","rawtypes"})
public class MainFlow extends org.instantlogic.interaction.flow.Flow {

	public static final MainFlow INSTANCE = new MainFlow();
	
	private static final org.instantlogic.interaction.flow.FlowNodeBase[] NODES = new org.instantlogic.interaction.flow.FlowNodeBase[]{
		org.instantlogic.designer.flow.main.EntitySubFlow.INSTANCE,
		org.instantlogic.designer.flow.main.FlowSubFlow.INSTANCE,
		org.instantlogic.designer.flow.main.AddEntitySubFlow.INSTANCE,
		org.instantlogic.designer.flow.main.FlowNodeSubFlow.INSTANCE,
		org.instantlogic.designer.flow.main.PlaceTemplateSubFlow.INSTANCE,
		org.instantlogic.designer.flow.main.AttributeSubFlow.INSTANCE,
		org.instantlogic.designer.flow.main.WelcomePlaceTemplate.INSTANCE,
	};
	
	private static final org.instantlogic.interaction.flow.FlowEdge[] EDGES = new org.instantlogic.interaction.flow.FlowEdge[]{
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.designer.event.HomeEvent.INSTANCE,
			org.instantlogic.designer.flow.main.WelcomePlaceTemplate.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.designer.event.EntityDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.main.EntitySubFlow.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.designer.event.AttributeDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.main.AttributeSubFlow.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.main.FlowSubFlow.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.designer.event.AddEntityEvent.INSTANCE,
			org.instantlogic.designer.flow.main.AddEntitySubFlow.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.designer.event.FlowNodeDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.main.FlowNodeSubFlow.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.designer.event.PlaceTemplateDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.main.PlaceTemplateSubFlow.INSTANCE
		),
	};
	
	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
	};
	
	@Override
	public String getName() {
		return "Main";
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
