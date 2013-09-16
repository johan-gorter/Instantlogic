package org.instantlogic.designer.dataexplorer;

import java.util.ArrayList;
import java.util.Collection;
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
	private final Map<String, SimpleFlowEvent> relationDetailsEvents = new HashMap<String, SimpleFlowEvent>();
	private SimpleFlowEvent detailsEvent;
	
	public DataExplorerEntityFlow(Entity<?> entity, SimpleFlowEvent entityDetailsEvent, DataExplorerOwnerBreadcrumbElement breadcrumbElement, DataExplorerOwnerBreadcrumbElement relationBreadcrumbElement, List<FlowEvent> directEvents) {
		this.detailsEvent = entityDetailsEvent;
		this.entity = entity;
		this.detailsPlaceTemplate = new DataExplorerEntityDetailsPlaceTemplate(this, directEvents, breadcrumbElement);
		this.parameters = new Entity<?>[]{entity};
		
		ArrayList<FlowNodeBase> nodeList = new ArrayList<FlowNodeBase>();
		nodeList.add(detailsPlaceTemplate);
		
		ArrayList<FlowEdge> edgeList = new ArrayList<FlowEdge>();
		edgeList.add(new FlowEdge(null, entityDetailsEvent, detailsPlaceTemplate));
		
		for (Relation<?, ? extends Object, ? extends Instance> relation : entity.getRelations()) {
			addRelationDetails(relation, nodeList, edgeList, relationBreadcrumbElement);
		}
		for (Relation<?, ? extends Object, ? extends Instance> relation : entity.getReverseRelations()) {
			addRelationDetails(relation, nodeList, edgeList, relationBreadcrumbElement);
		}
		
		this.nodes = nodeList.toArray(new FlowNodeBase[nodeList.size()]);
		this.edges = edgeList.toArray(new FlowEdge[edgeList.size()]);
	}
	
	public SimpleFlowEvent getEntityDetailsEvent() {
		return detailsEvent;
	}

	private void addRelationDetails(Relation<?, ?, ?> relation, List<FlowNodeBase> nodeList, List<FlowEdge> edgeList, DataExplorerOwnerBreadcrumbElement breadcrumbElement) {
		SimpleFlowEvent relationDetailsEvent = new SimpleFlowEvent(entity.getName()+"-"+relation.getName()+"-details");
		DataExplorerRelationFlow relationFlow = new DataExplorerRelationFlow(this, relation, relationDetailsEvent, breadcrumbElement);
		relationDetailsEvents.put(relation.getName(), relationDetailsEvent);
		SimpleSubFlow relationSubFlow = new SimpleSubFlow(relationFlow);
		nodeList.add(relationSubFlow);
		edgeList.add(new FlowEdge(null, relationDetailsEvent, relationSubFlow));
	}
	
	@SuppressWarnings("rawtypes")
	public FlowEvent getRelationDetailsEvent(Relation relation) {
		return relationDetailsEvents.get(relation.getName());
	}

	public FlowEvent getRelationDetailsEvent(String relationName) {
		return relationDetailsEvents.get(relationName);
	}

	@Override
	public String getName() {
		return "DataExplorer"+entity.getName();
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

	public Collection<SimpleFlowEvent> getRelationDetailsEvents() {
		return relationDetailsEvents.values();
	}
}
