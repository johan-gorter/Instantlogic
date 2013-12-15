package org.instantlogic.designer.dataexplorer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.flow.PlaceTemplate;

public class DataExplorerAdministration {
	
	private final Map<String, DataExplorerEntityDetailsPlaceTemplate> entityDetailsPlaceTemplates = new HashMap<>();
	private final Map<String, Map<String, DataExplorerRelationAdministration>> relationPlaceTemplates = new HashMap<>();
	private final Map<String, DataExplorerOwnerBreadcrumbElement> breadcrumbElements = new HashMap<String, DataExplorerOwnerBreadcrumbElement>();
	private final Entity<? extends Instance> caseEntity;
	private final Application application;
	private final DataExplorerStaticInstancesPlaceTemplate staticInstancesPlaceTemplate;
	
	public DataExplorerAdministration(Application application) {
		this.caseEntity = application.getCaseEntity();
		this.application = application;
		Collection<Entity<?>> entities = application.getAllEntities().values();
		
		SortedMap<String,Entity<?>> allEntitiesById = CaseAdministration.getAllEntitiesById(application.getCaseEntity());
		for (Entity<?> entity : allEntitiesById.values()) {
			DataExplorerOwnerBreadcrumbElement breadcrumbElement = new DataExplorerOwnerBreadcrumbElement(entity, this, false);
			breadcrumbElements.put(entity.getUniqueId(), breadcrumbElement);
			DataExplorerEntityDetailsPlaceTemplate entityPlaceTemplate 
				= new DataExplorerEntityDetailsPlaceTemplate(entity, new DataExplorerOwnerBreadcrumbElement(entity, this, true), this);
			entityDetailsPlaceTemplates.put(entity.getUniqueId(), entityPlaceTemplate);
			
			relationPlaceTemplates.put(entity.getUniqueId(), new HashMap<String, DataExplorerRelationAdministration>());
			for (Relation<?, ? extends Object, ? extends Instance> relation : entity.getRelations()) {
				addRelationDetails(entity, relation, breadcrumbElement);
			}
			for (Relation<?, ? extends Object, ? extends Instance> relation : entity.getReverseRelations()) {
				addRelationDetails(entity, relation, breadcrumbElement);
			}
		}
		this.staticInstancesPlaceTemplate = new DataExplorerStaticInstancesPlaceTemplate(this);
	}

	private void addRelationDetails(Entity<?> entity, Relation<?, ? extends Object, ? extends Instance> relation, DataExplorerOwnerBreadcrumbElement breadcrumbElement) {
		DataExplorerRelationAdministration relationAdministration = new DataExplorerRelationAdministration(relation, this, breadcrumbElement);
		Map<String, DataExplorerRelationAdministration> relationsForEntity = relationPlaceTemplates.get(entity.getUniqueId());
		relationsForEntity.put(relation.getName(), relationAdministration);
	}

	@SuppressWarnings("rawtypes")
	public PlaceTemplate getEntityDetailsPlaceTemplate(Entity entity) {
		return entityDetailsPlaceTemplates.get(entity);
	}

	@SuppressWarnings("rawtypes")
	public PlaceTemplate getRelationPlaceTemplate(Entity entity, String relationName) {
		return relationPlaceTemplates.get(entity.getUniqueId()).get(relationName).relationDetailsPlaceTemplate;
	}
	
	@SuppressWarnings("rawtypes")
	public DataExplorerOwnerBreadcrumbElement getBreadcrumbElement(Entity entity) {
		return breadcrumbElements.get(entity.getUniqueId());
	}

	public Entity<? extends Instance> getCaseEntity() {
		return caseEntity;
	}

	public Application getApplication() {
		return application;
	}

	public List<PlaceTemplate> getPlacesWithSingleParameter(Entity<?> entity) {
		List<PlaceTemplate> result = new ArrayList<>();
		for (PlaceTemplate placeTemplate: application.getPlaceTemplates()) {
			Entity<?>[] parameters = placeTemplate.getParameters();
			if (parameters.length==1 && parameters[0] == entity) {
				result.add(placeTemplate);
			}
		}
		return result;
	}

	public List<PlaceTemplate> getPlaceTemplates() {
		List<PlaceTemplate> placeTemplates = new ArrayList<PlaceTemplate>();
		for (DataExplorerEntityDetailsPlaceTemplate entityPlaceTemplate: entityDetailsPlaceTemplates.values()) {
			placeTemplates.add(entityPlaceTemplate);
		}
		for (Map<String, DataExplorerRelationAdministration> relations: relationPlaceTemplates.values()) {
			for (DataExplorerRelationAdministration relationAdministration : relations.values()) {
				relationAdministration.addPlaceTemplates(placeTemplates);
			}
		}
		return placeTemplates;
	}
}
