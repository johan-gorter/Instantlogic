package org.instantlogic.designer.codegenerator.classmodel;

import java.util.ArrayList;
import java.util.List;

public class FlowClassModel extends AbstractClassModel {
	public static class FlowNode {
		public String name;
		public String type;
		
		public String getName() {
			return name;
		}
		public String getType() {
			return type;
		}
	}

	public static class FlowEdge {
		public String startNode;
		public String endNode;
		public String event;
		
		public String getStartNode() {
			return startNode;
		}
		public String getEndNode() {
			return endNode;
		}
		public String getEvent() {
			return event;
		}
	}
	
	public final List<FlowNode> nodes = new ArrayList<FlowNode>();
	public final List<FlowEdge> edges = new ArrayList<FlowEdge>();
	public final List<String> parameters = new ArrayList<String>();

	public List<FlowNode> getNodes() {
		return nodes;
	}

	public List<FlowEdge> getEdges() {
		return edges;
	}

	public List<String> getParameters() {
		return parameters;
	}

	public String getFullClassName() {
		return rootPackageName+".flow." + (isCustomized?"Abstract":"") + technicalNameCapitalized + "Flow";
	}
}
