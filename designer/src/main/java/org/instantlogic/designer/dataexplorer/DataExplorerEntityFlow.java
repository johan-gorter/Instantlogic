package org.instantlogic.designer.dataexplorer;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.flow.FlowEdge;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.flow.impl.SimpleFlow;

public class DataExplorerEntityFlow extends SimpleFlow {

	private final Entity<?> entity;
	private final DataExplorerEntityDetailsPlaceTemplate detailsPlaceTemplate;
	
	private final FlowNodeBase[] nodes;
	private final FlowEdge[] edges;
	private final Entity<?>[] parameters;
	
	public DataExplorerEntityFlow(Entity<?> entity) {
		this.entity = entity;
		this.detailsPlaceTemplate = new DataExplorerEntityDetailsPlaceTemplate(entity);
		this.parameters = new Entity<?>[]{entity};
		this.nodes = new FlowNodeBase[]{detailsPlaceTemplate};
		this.edges = new FlowEdge[]{
			new FlowEdge(null, ExploreDataEvent.INSTANCE, detailsPlaceTemplate)
		};
	}

	@Override
	public PlaceTemplate getPage(String[] path, int pathIndex) {
		if ("details".equals(path[pathIndex])) {
			return new DataExplorerEntityDetailsPlaceTemplate(entity);
		}
		return null;
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
}
