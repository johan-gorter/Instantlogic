package org.instantlogic.designer.dataexplorer;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.value.WriteableAttributeValue;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.page.FragmentTemplate;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class DataExplorerRemoveInstancePlaceTemplate extends PlaceTemplate {

	private final Entity<?> entity;
	private final String entityId;
	private final String relationId;
	private final DataExplorerAdministration administration;
	@SuppressWarnings("rawtypes")
	private Relation relation;
	private Entity<?>[] parameters;
	
	public DataExplorerRemoveInstancePlaceTemplate(Entity<?> entity,
			Relation<?,?,?> relation, 
			DataExplorerAdministration administration) {
		this.entity = entity;
		this.entityId = entity.getUniqueId();
		this.relation = relation;
		this.relationId = relation.getUniqueId();
		this.administration = administration;
		this.parameters = new Entity<?>[]{entity, relation.getTo()};
	}

	@Override
	public FragmentTemplate getRootContainer() {
		return null;
	}

	@Override
	public String getId() {
		return getName();
	}
	
	@Override
	public Entity<?>[] getParameters() {
		return parameters;
	}

	@Override
	public String getName() {
		return "_DataExplorer-"+entityId+"-remove-from-"+relationId;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public FlowEventOccurrence enter(FlowContext context) {
		Instance instance = context.getSelectedInstance(entity);
		Instance instanceToRemove = context.getSelectedInstance(null);
		((WriteableAttributeValue)relation.get(instance)).clearOrRemove(instanceToRemove);
		return new FlowEventOccurrence(administration.getRelationPlaceTemplate(entity, relationId), instance);
	}
}
