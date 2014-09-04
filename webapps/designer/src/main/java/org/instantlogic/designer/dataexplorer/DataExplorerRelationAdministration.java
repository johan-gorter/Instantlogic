package org.instantlogic.designer.dataexplorer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.interaction.flow.PlaceTemplate;

public class DataExplorerRelationAdministration {

	public final DataExplorerRelationDetailsPlaceTemplate relationDetailsPlaceTemplate;
	public final DataExplorerShopForInstancePlaceTemplate shopPlaceTemplate;
	public final Map<Entity, DataExplorerCreateInstancePlaceTemplate> createPlaceTemplates = new HashMap<>();
	public final DataExplorerRemoveInstancePlaceTemplate removePlaceTemplate;
  public final DataExplorerAddInstancePlaceTemplate addPlaceTemplate;
	
	public DataExplorerRelationAdministration(
			Relation<?, ? extends Object, ? extends Instance> relation,
			DataExplorerAdministration administration, DataExplorerOwnerBreadcrumbElement breadcrumbElement) {
		
		Entity entity = relation.getEntity();
		relationDetailsPlaceTemplate = new DataExplorerRelationDetailsPlaceTemplate(administration, this, breadcrumbElement, relation.getEntity(), relation);
		removePlaceTemplate = new DataExplorerRemoveInstancePlaceTemplate(entity, relation, administration);
		addPlaceTemplate = new DataExplorerAddInstancePlaceTemplate(entity, relation, administration);
		
		if (relation.isOwner()) {
			shopPlaceTemplate = null;
			List<Entity> entitiesToBeAdded = new ArrayList<Entity>();
			addExtensions(relation.getTo(), entitiesToBeAdded);
			for (final Entity entityToBeAdded : entitiesToBeAdded) {
				DataExplorerCreateInstancePlaceTemplate create = new DataExplorerCreateInstancePlaceTemplate(entity, relation, entityToBeAdded, administration);
				createPlaceTemplates.put(entityToBeAdded, create);
			}
		} else {
			shopPlaceTemplate = new DataExplorerShopForInstancePlaceTemplate(entity, relation, administration);
		}
	}
	
	private void addExtensions(Entity from, List<Entity> result) {
		result.add(from);
		for (Entity entity:from.extensions()) {
			addExtensions(entity, result);
		}
	}

	public void addPlaceTemplates(List<PlaceTemplate> to) {
		to.add(relationDetailsPlaceTemplate);
    to.add(removePlaceTemplate);
		to.add(addPlaceTemplate);
		if (shopPlaceTemplate!=null) {
			to.add(shopPlaceTemplate);
		}
		for (PlaceTemplate createPlaceTemplate : createPlaceTemplates.values()) {
			to.add(createPlaceTemplate);
		}
	}	
}
