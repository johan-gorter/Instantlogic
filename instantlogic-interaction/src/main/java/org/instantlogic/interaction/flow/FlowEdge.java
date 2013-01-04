/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.interaction.flow;


public class FlowEdge {
	
	private FlowNodeBase startNode;
	private FlowEvent event;
	private FlowNodeBase endNode;
	
	
	/**
	 * Creates a new FlowEdge
	 * @param startNode optional: node the edge starts from, if null the edge matches any nodes in the flow
	 * @param event required: event the edge triggers on
	 * @param endNode required: node the edge ends in
	 */
	public FlowEdge(FlowNodeBase startNode, FlowEvent event, FlowNodeBase endNode) {
		if (event==null) throw new IllegalArgumentException("event");
		if (endNode==null) throw new IllegalArgumentException("endNode");
		this.startNode = startNode;
		this.event = event;
		this.endNode = endNode;
	}
	
	public FlowNodeBase getStartNode() {
		return startNode;
	}

	public FlowEvent getEvent() {
		return event;
	}

	public FlowNodeBase getEndNode() {
		return endNode;
	}
}
