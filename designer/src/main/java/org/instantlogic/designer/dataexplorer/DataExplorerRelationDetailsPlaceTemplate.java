package org.instantlogic.designer.dataexplorer;

import java.util.Map.Entry;

import org.instantlogic.designer.deduction.EntityNameDeduction;
import org.instantlogic.fabric.deduction.AttributeDeduction;
import org.instantlogic.fabric.deduction.IdDeduction;
import org.instantlogic.fabric.deduction.SelectedInstanceDeduction;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.text.TextTemplate;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.page.FragmentTemplate;
import org.instantlogic.interaction.page.SelectionElement;

@SuppressWarnings("rawtypes")
public class DataExplorerRelationDetailsPlaceTemplate extends PlaceTemplate {

	private final Entity<?> entity;
	private Relation<?, ?, ?> relation;
	private DataExplorerRelationFlow flow;

	public DataExplorerRelationDetailsPlaceTemplate(DataExplorerRelationFlow flow) {
		this.entity = flow.getEntity();
		this.relation = flow.getRelation();
		this.flow = flow;
	}
	
	@Override
	public FragmentTemplate getRootContainer() {
		FragmentTemplate page = new FragmentTemplate(relation.getUniqueId()+"-details", "Page")
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
					.setEvent(ExploreDataEvent.INSTANCE)
			)
		);
		page.addChild("mainContent", new ShoppingElement());
		
		for (Entry<Entity, FlowEvent> entry : flow.getAddNewEvents().entrySet()) {
			Entity entity = entry.getKey();
			page.addChild("mainContent",
				new FragmentTemplate("add-"+entity.getUniqueId(), "Button")
					.putText("text", new TextTemplate().getUntranslated().add("Add new "+entity.getName()).getTextTemplate())
					.setEvent(entry.getValue())
			);
		}
		
		if (flow.getShopForInstancesEvent()!=null) {
			page.addChild("mainContent",
				new FragmentTemplate("shopForInstancesOuter", "Block")
					.addChild("content", 
						new FragmentTemplate("shopForInstances", "Button")
							.addChild("content", new FragmentTemplate("shopping-icon","Icon").setStyleNames(new String[]{"icon-shopping-cart"}))
							.putText("text", new TextTemplate().getUntranslated().add("Start shopping for instances").getTextTemplate())
							.setEvent(flow.getShopForInstancesEvent())
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
											.setEvent(ExploreDataEvent.INSTANCE)
									),
								new FragmentTemplate("cell-operations", "Cell")
									.addChild("content", new FragmentTemplate("delete", "Button").setStyleNames(new String[]{"btn-small", "btn-danger"})
										.addChild("content", new FragmentTemplate("delete-icon","Icon").setStyleNames(new String[]{"icon-remove"}))
										.setEvent(flow.removeInstanceEvent)
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
	public String getId() {
		return relation.getUniqueId();
	}

	@Override
	public String getName() {
		return "details";
	}
}
