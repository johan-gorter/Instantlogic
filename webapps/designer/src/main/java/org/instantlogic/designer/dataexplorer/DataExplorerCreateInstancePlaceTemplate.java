package org.instantlogic.designer.dataexplorer;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.value.WriteableAttributeValue;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.page.FragmentTemplate;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class DataExplorerCreateInstancePlaceTemplate extends PlaceTemplate {

	private final Entity<?> entity;
	private final String entityId;
	private final String relationId;
	private final Entity<?> entityToBeAdded;
	private final String entityToBeAddedId;
	private final DataExplorerAdministration administration;
	@SuppressWarnings("rawtypes")
	private Relation relation;
	private Entity<?>[] parameters;
	
	public DataExplorerCreateInstancePlaceTemplate(Entity<?> entity,
			Relation<?,?,?> relation, Entity<?> entityToBeAdded,
			DataExplorerAdministration administration) {
		this.entity = entity;
		this.entityId = entity.getUniqueId();
		this.relation = relation;
		this.relationId = relation.getUniqueId();
		this.entityToBeAdded = entityToBeAdded;
		this.entityToBeAddedId = entityToBeAdded.getUniqueId();
		this.administration = administration;
		this.parameters = new Entity<?>[]{entity};
	}

	@Override
	public FragmentTemplate getRootContainer() {
		return null;
	}

	@Override
	public Entity<?>[] getParameters() {
		return parameters;
	}

	@Override
	public String getName() {
		return "_DataExplorer-"+entityId+"-add-"+entityToBeAddedId+"-to-"+relationId;
	}

	@Override
	public String getId() {
		return getName();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public FlowEventOccurrence enter(FlowContext context) {
		Instance instance = context.getSelectedInstance(entity);
		Instance newInstance = entityToBeAdded.createInstance();
		((WriteableAttributeValue)relation.get(instance)).setOrAdd(newInstance);
		//return new FlowEventOccurrence(administration.getRelationPlaceTemplate(entity, relationName), instance);
		return new FlowEventOccurrence(administration.getEntityDetailsPlaceTemplate(entityToBeAdded), newInstance);
	}
}
