package org.instantlogic.interaction;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.TreeMap;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.interaction.flow.PlaceTemplate;


public abstract class Application implements AutoCloseable {
	
	private static final String[] NO_THEMES = new String[0];
	private static final PlaceTemplate[] NO_PLACE_TEMPLATES = new PlaceTemplate[0];
	

	private List<AutoCloseable> resourcesToClose = new ArrayList<AutoCloseable>();

	private TreeMap<String, Entity<?>> allEntitiesByName;
	
	public abstract Entity<? extends Instance> getCaseEntity();
	
	public abstract String getName();
	
	public SortedMap<String, Entity<?>> getAllEntities() {
		if (allEntitiesByName==null) {
			TreeMap<String, Entity<?>> tempResult = new TreeMap<String, Entity<?>>();
			addEntities(getCaseEntity(), tempResult);
			allEntitiesByName = tempResult;
		}
		return allEntitiesByName;
	}
	
	private static void addEntities(Entity<?> entity, SortedMap<String, Entity<?>> all) {
		if (all.containsKey(entity.getName())) {
			return;
		}
		all.put(entity.getName(), entity);
		if (entity.extendsEntity()!=null) {
			addEntities(entity.extendsEntity(), all);
		}
		for (Entity<?> extension : entity.extensions()) {
			addEntities(extension, all);
		}
		for (Relation<?, ?, ? extends Instance> relation : entity.getRelations()) {
			addEntities(relation.getTo(), all);
		}
	}
	
	public PlaceTemplate getStartPlace() {
		return null;
	}
	
	public PlaceTemplate getLoggedInPlace() {
		return null;
	}
	
	public PlaceTemplate[] getPlaceTemplates() {
		return NO_PLACE_TEMPLATES;
	}
	
	public String[] getThemeNames() {
		return NO_THEMES;
	}
	
	public void addCloseableResource(AutoCloseable resource) {
		resourcesToClose.add(resource);
	}
	
	public ClassLoader getApplicationClassLoader() {
		return getClass().getClassLoader();
	}
	
	@Override
	public void close() throws Exception {
		for(AutoCloseable resource : resourcesToClose) {
			resource.close();
		}
	}

	// Injected dependency
	public void setEnvironment(ApplicationEnvironment environment, String applicationName) {
	}

	public PlaceTemplate getPlaceTemplate(String technicalName) {
		for (PlaceTemplate placeTemplate : getPlaceTemplates()) {
			if (placeTemplate.getTechnicalName().equals(technicalName)) {
				return placeTemplate;
			}
		}
		throw new NoSuchElementException("Placetemplate with technicalName "+technicalName);
	}
}