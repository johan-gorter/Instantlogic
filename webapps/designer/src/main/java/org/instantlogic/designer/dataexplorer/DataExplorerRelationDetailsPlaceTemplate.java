package org.instantlogic.designer.dataexplorer;

import java.util.Map.Entry;

import org.instantlogic.designer.deduction.EntityNameDeduction;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.deduction.AttributeDeduction;
import org.instantlogic.fabric.deduction.IdDeduction;
import org.instantlogic.fabric.deduction.SelectedInstanceDeduction;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.text.TextTemplate;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.page.FragmentTemplate;
import org.instantlogic.interaction.page.SelectionElement;

@SuppressWarnings("rawtypes")
public class DataExplorerRelationDetailsPlaceTemplate extends PlaceTemplate {

	private final Entity<?> entity;
	private Relation<?, ?, ?> relation;
	private DataExplorerOwnerBreadcrumbElement breadcrumbElement;
	private DataExplorerAdministration administration;
	private DataExplorerRelationAdministration relationAdministration;
	private Entity<?>[] parameters;

	public DataExplorerRelationDetailsPlaceTemplate(DataExplorerAdministration administration, DataExplorerRelationAdministration relationAdministration, DataExplorerOwnerBreadcrumbElement breadcrumbElement, Entity<?> entity, Relation<?, ? extends Object, ? extends Instance> relation) {
		this.entity = entity;
		this.relation = relation;
		this.relationAdministration = relationAdministration;
		this.breadcrumbElement = breadcrumbElement;
		this.administration = administration;
		this.parameters = new Entity<?>[]{entity};
	}

	@Override
	public FragmentTemplate getRootContainer() {
		FragmentTemplate page = new FragmentTemplate(relation.getUniqueId()+"-details", "Page")
		.addChild("mainContent", new FragmentTemplate("h2", "Heading2")
			.putText("text", new TextTemplate().getUntranslated().add("Data Explorer").getTextTemplate()))
		.addChild("mainContent", new FragmentTemplate("staticinstances-link", "Link")
			.putText("text", new TextTemplate().getUntranslated().add("Static instances").getTextTemplate())
			.setDestination(administration.getStaticInstancesPlaceTemplate()))
		.addChild("mainContent", new ShoppingElement(administration))
		.addChild("mainContent", breadcrumbElement)
		.addChild("mainContent",
                new FragmentTemplate("h1", "Heading1")      
                    .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated()
                    	.add("Relation '"+ relation.getName()+"'").getTextTemplate())        
            );
		page.addChild("mainContent", new FragmentTemplate("h2", "Heading2")
			.addChild("content", new FragmentTemplate("h2-1","Text").putConstantText("text", "On "))
			.addChild("content", 
				new FragmentTemplate(entity.getUniqueId()+"-link", "Link")
					.addChild("content", new FragmentTemplate(entity.getUniqueId()+"link1", "Text").putText("text", new TextTemplate().getUntranslated().add(entity.getName() + " '").getTextTemplate()))
					.addChild("content", new FragmentTemplate(entity.getUniqueId()+"link2", "Text").putText("text", DataExplorerEntityDetailsPlaceTemplate.getEntityTitle(entity)))
					.addChild("content", new FragmentTemplate(entity.getUniqueId()+"link3", "Text").putText("text", new TextTemplate().getUntranslated().add("'").getTextTemplate()))
					.setDestination(administration.getEntityDetailsPlaceTemplate(entity))
			)
		);
		
		for (Entry<Entity, DataExplorerCreateInstancePlaceTemplate> entry : relationAdministration.createPlaceTemplates.entrySet()) {
			Entity entity = entry.getKey();
			page.addChild("mainContent",
				new FragmentTemplate("add-"+entity.getUniqueId(), "Button")
					.putText("text", new TextTemplate().getUntranslated().add("Add new "+entity.getName()).getTextTemplate())
					.setDestination(entry.getValue())
			);
		}
		
		if (relationAdministration.shopPlaceTemplate!=null) {
			page.addChild("mainContent",
				new FragmentTemplate("shopForInstancesOuter", "Block")
					.addChild("content", 
						new FragmentTemplate("shopForInstances", "Button")
							.addChild("content", new FragmentTemplate("shopping-icon","Icon").setStyleNames(new String[]{"icon-shopping-cart"}))
							.putText("text", new TextTemplate().getUntranslated().add("Start shopping for instances").getTextTemplate())
							.setDestination(relationAdministration.shopPlaceTemplate)
					)
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
									.addChild("content", 
										new FragmentTemplate("toInstance", "Link")
											.putText("text", DataExplorerEntityDetailsPlaceTemplate.getEntityTitle(relation.getTo()))
											.setDestination(administration.getExplorePlaceTemplate())
									),
								new FragmentTemplate("cell-operations", "Cell")
									.addChild("content", new FragmentTemplate("delete", "Button").setStyleNames(new String[]{"btn-small", "btn-danger"})
										.addChild("content", new FragmentTemplate("delete-icon","Icon").setStyleNames(new String[]{"icon-remove"}))
										.setDestination(relationAdministration.removePlaceTemplate)
									)
							)
					)
				)
		);
		
		// TODO: Once finished developing, cache this page in order to increase performance.
		return page;
	}

	@SuppressWarnings({ "unchecked" })
	private AttributeDeduction createSelectRelationDeduction(Relation relation) {
		SelectedInstanceDeduction selectedInstance = new SelectedInstanceDeduction(this.entity);
		AttributeDeduction result = new AttributeDeduction(relation);
		result.setInstance(selectedInstance);
		return result;
	}

	@SuppressWarnings({ "unchecked" })
	private IdDeduction createSelectInstanceIdDeduction() {
		SelectedInstanceDeduction selectedInstance = new SelectedInstanceDeduction(this.relation.getTo());
		IdDeduction result = new IdDeduction();
		result.setIdOfInstance(selectedInstance);
		return result;
	}

	@SuppressWarnings({ "unchecked" })
	private EntityNameDeduction createSelectEntityNameDeduction() {
		SelectedInstanceDeduction selectedInstance = new SelectedInstanceDeduction(this.relation.getTo());
		EntityNameDeduction result = new EntityNameDeduction();
		result.setEntityOfInstance(selectedInstance);
		return result;
	}
	
	@Override
	public Entity<?>[] getParameters() {
		return parameters;
	}

	@Override
	public String getName() {
		return "_DataExplorer-"+entity.getUniqueId()+"-"+relation.getName();
	}

	@Override
	public String getId() {
		return getName();
	}
}
