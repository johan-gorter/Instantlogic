package org.instantlogic.designer.dataexplorer;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.designer.deduction.EntityNameDeduction;
import org.instantlogic.fabric.deduction.AttributeDeduction;
import org.instantlogic.fabric.deduction.IdDeduction;
import org.instantlogic.fabric.deduction.SelectedInstanceDeduction;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.text.TextTemplate;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.page.FragmentTemplate;
import org.instantlogic.interaction.page.SelectionElement;

public class DataExplorerRelationDetailsPlaceTemplate extends PlaceTemplate {

	private final Entity<?> entity;
	private Relation<?, ?, ?> relation;

	public DataExplorerRelationDetailsPlaceTemplate(Entity<?> entity, Relation<?, ?, ?> relation) {
		this.entity = entity;
		this.relation = relation;
	}
	
	private void addExtensions(Entity from, List<Entity> result) {
		result.add(from);
		for (Entity entity:from.extensions()) {
			addExtensions(entity, result);
		}
	}

	@Override
	public FragmentTemplate getRootContainer() {
		FragmentTemplate page = new FragmentTemplate(relation.getUniqueId()+"-details", "Page")
			.addChild("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("h1", "Heading1")      
                    .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(relation.getName()+" ("+entity.getName()+")").getTextTemplate())        
            );

		page.addChild("mainContent", 
			new FragmentTemplate(entity.getUniqueId()+"-link", "Link")
				.putText("text", getEntityTitle(entity))
				.setEvent(ExploreDataEvent.INSTANCE)
		);
		
		// Add buttons
		List<Entity> entities = new ArrayList<Entity>();
		addExtensions(relation.getTo(), entities);
		for (Entity entity : entities) {
			page.addChild("mainContent",
				new FragmentTemplate("add-"+entity.getUniqueId(), "Button")
					.putText("text", new TextTemplate().getUntranslated().add("Add new "+entity.getName()).getTextTemplate())
					// TODO: .setEvent(event)
			);
		}
		
		page.addChild("mainContent",
			new FragmentTemplate("Table", "Table")
				.addChild("columns", 
					new FragmentTemplate("c1","Column").setStyleNames(new String[]{"instance-entity"})
						.putText("header", new TextTemplate().getUntranslated().add("Entity").getTextTemplate()))
				.addChild("columns", 
					new FragmentTemplate("c1","Column").setStyleNames(new String[]{"instance-id"})
						.putText("header", new TextTemplate().getUntranslated().add("Id").getTextTemplate()))
				.addChild("columns", 
					new FragmentTemplate("c1","Column").setStyleNames(new String[]{"instance-title"})
						.putText("header", new TextTemplate().getUntranslated().add("Title").getTextTemplate()))
				.addChild("columns", 
					new FragmentTemplate("c2","Column")
						.putText("header", new TextTemplate().getUntranslated().add("").getTextTemplate()))
				.addChild("rows",
					new SelectionElement(createSelectRelationDeduction(relation),
						new FragmentTemplate("instance-row", "Row")
							.putChildren("cells", 
								new FragmentTemplate("cell-entity", "Cell")
									.putText("text", new TextTemplate().getUntranslated().add(createSelectEntityNameDeduction()).getTextTemplate()),
								new FragmentTemplate("cell-id", "Cell")
									.putText("text", new TextTemplate().getUntranslated().add(createSelectInstanceIdDeduction()).getTextTemplate()),
								new FragmentTemplate("cell-title", "Cell")
									.putText("text", getEntityTitle(relation.getTo()))
							)
					)
				)
		);
		
		// TODO: Once finished developing, cache this page in order to increase performance.
		return page;
	}

	// Warning: copy-pasted from EntityDetailsPlaceTemplate
	// Traverses to super-entities and provides a fallback
	private TextTemplate getEntityTitle(Entity<?> entity) {
		Entity<?> currentEntity = entity;
		while (currentEntity!=null) {
			if (currentEntity.getTitle()!=null) {
				return currentEntity.getTitle();
			}
			currentEntity = currentEntity.extendsEntity();
		}
		return new TextTemplate().getUntranslated().add(entity.getName()).getTextTemplate();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private AttributeDeduction createSelectRelationDeduction(Relation relation) {
		SelectedInstanceDeduction selectedInstance = new SelectedInstanceDeduction(this.entity);
		AttributeDeduction result = new AttributeDeduction(relation);
		result.setInstance(selectedInstance);
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private IdDeduction createSelectInstanceIdDeduction() {
		SelectedInstanceDeduction selectedInstance = new SelectedInstanceDeduction(this.relation.getTo());
		IdDeduction result = new IdDeduction();
		result.setIdOfInstance(selectedInstance);
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private EntityNameDeduction createSelectEntityNameDeduction() {
		SelectedInstanceDeduction selectedInstance = new SelectedInstanceDeduction(this.relation.getTo());
		EntityNameDeduction result = new EntityNameDeduction();
		result.setEntityOfInstance(selectedInstance);
		return result;
	}


	@Override
	public String getId() {
		return relation.getUniqueId();
	}

	@Override
	public String getName() {
		return "relation-"+relation.getUniqueId();
	}

}
