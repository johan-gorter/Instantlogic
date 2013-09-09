package org.instantlogic.designer.dataexplorer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.interaction.flow.FlowEdge;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.flow.impl.SimpleFlow;
import org.instantlogic.interaction.flow.impl.SimpleFlowEvent;
import org.instantlogic.interaction.flow.impl.SimpleSubFlow;

public class DataExplorerEntityFlow extends SimpleFlow {

	private final Entity<?> entity;
	private final DataExplorerEntityDetailsPlaceTemplate detailsPlaceTemplate;
	
	private final FlowNodeBase[] nodes;
	private final FlowEdge[] edges;
	private final Entity<?>[] parameters;
	@SuppressWarnings("rawtypes")
	private final Map<Relation, FlowEvent> relationDetailsEvents = new HashMap<Relation, FlowEvent>();
	
	public DataExplorerEntityFlow(Entity<?> entity, SimpleFlowEvent entityDetailsEvent, DataExplorerOwnerBreadcrumbElement breadcrumbElement, List<FlowEvent> directEvents) {
		this.entity = entity;
		this.detailsPlaceTemplate = new DataExplorerEntityDetailsPlaceTemplate(this, directEvents, breadcrumbElement);
		this.parameters = new Entity<?>[]{entity};
		
		ArrayList<FlowNodeBase> nodeList = new ArrayList<FlowNodeBase>();
		nodeList.add(detailsPlaceTemplate);
		
		ArrayList<FlowEdge> edgeList = new ArrayList<FlowEdge>();
		edgeList.add(new FlowEdge(null, entityDetailsEvent, detailsPlaceTemplate));
		
		for (Relation<?, ? extends Object, ? extends Instance> relation : entity.getRelations()) {
			addRelationDetails(relation, nodeList, edgeList);
		}
		for (Relation<?, ? extends Object, ? extends Instance> relation : entity.getReverseRelations()) {
			addRelationDetails(relation, nodeList, edgeList);
		}
		
		this.nodes = nodeList.toArray(new FlowNodeBase[nodeList.size()]);
		this.edges = edgeList.toArray(new FlowEdge[edgeList.size()]);
	}

	private void addRelationDetails(Relation<?, ?, ?> relation, List<FlowNodeBase> nodeList, List<FlowEdge> edgeList) {
		SimpleFlowEvent relationDetailsEvent = new SimpleFlowEvent(entity.getName()+"-"+relation.getName()+"-details");
		DataExplorerRelationFlow relationFlow = new DataExplorerRelationFlow(this, relation, relationDetailsEvent);
		relationDetailsEvents.put(relation, relationDetailsEvent);
		SimpleSubFlow relationSubFlow = new SimpleSubFlow(relationFlow);
		nodeList.add(relationSubFlow);
		edgeList.add(new FlowEdge(detailsPlaceTemplate, relationDetailsEvent, relationSubFlow));
	}
	
	@SuppressWarnings("rawtypes")
	public FlowEvent getRelationDetailsEvent(Relation relation) {
		return relationDetailsEvents.get(relation);
	}

	@Override
	public String getName() {
		return "DataExplorer"+entity.getUniqueId();
	}

	@Override
	public FlowNodeBase[] getNodes() {
		return nodes;
	}

	@Override
	public FlowEdge[] getEdges() {
		return edges;
	}

	@Override
	public Entity<? extends Instance>[] getParameters() {
		return parameters;
	}

	public Entity<?> getEntity() {
		return entity;
	}
}
