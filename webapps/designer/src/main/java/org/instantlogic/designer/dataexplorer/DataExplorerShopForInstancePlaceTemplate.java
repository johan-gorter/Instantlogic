package org.instantlogic.designer.dataexplorer;

import java.util.List;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.page.FragmentTemplate;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class DataExplorerShopForInstancePlaceTemplate extends PlaceTemplate {

	private final Entity<?> entity;
	private final String entityId;
	private final String relationId;
	private final DataExplorerAdministration administration;
	@SuppressWarnings("rawtypes")
	private Relation relation;
	private Entity<?>[] parameters;
	
	public DataExplorerShopForInstancePlaceTemplate(Entity<?> entity,
			Relation<?,?,?> relation, DataExplorerAdministration administration) {
		this.entity = entity;
		this.entityId = entity.getUniqueId();
		this.relation = relation;
		this.relationId = relation.getUniqueId();
		this.administration = administration;
		this.parameters = new Entity<?>[]{entity};
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
		return "_DataExplorer-"+entityId+"-shop-for-"+relationId;
	}

	@Override
	public FlowEventOccurrence enter(FlowContext context) {
		Instance instance = context.getSelectedInstance(entity);
		List<RelationInstanceShopping> shoppingFor = context.getTraveler().getOrCreateExtension(RelationInstanceShopping.TravelerExtension.class).getCurrentlyShoppingFor();
		shoppingFor.add(new RelationInstanceShopping(relation, instance));
		return new FlowEventOccurrence(administration.getRelationPlaceTemplate(entity, relationId), instance);
	}
}
