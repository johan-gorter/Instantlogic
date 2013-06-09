

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
