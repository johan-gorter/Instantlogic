package org.instantlogic.designer.dataexplorer;

import org.instantlogic.fabric.deduction.AttributeDeduction;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.deduction.ReverseRelationDeduction;
import org.instantlogic.fabric.deduction.SelectedInstanceDeduction;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.text.TextTemplate;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.page.FragmentTemplate;
import org.instantlogic.interaction.page.SelectionElement;

public class DataExplorerEntityDetailsPlaceTemplate extends PlaceTemplate {

	private final Entity<?> entity;
	private DataExplorerEntityFlow entityFlow;

	public DataExplorerEntityDetailsPlaceTemplate(DataExplorerEntityFlow entityFlow) {
		this.entity = entityFlow.getEntity();
		this.entityFlow = entityFlow;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public FragmentTemplate getRootContainer() {
		// the resulting page can be used to view each instance of the same entity
		FragmentTemplate page = new FragmentTemplate(entity.getUniqueId()+"-details", "Page")
			.addChild("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("h1", "Heading1")      
                    .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(entity.getName() + " details").getTextTemplate())        
            );
		// Owner (relationname + link)
		for (Relation reverseRelation : entity.getReverseRelations()) {
			if (reverseRelation.getReverseRelation().isOwner()) {
				String id = "owner-"+reverseRelation.getUniqueId();
				Deduction selectValue = createSelectReverseRelationDeduction(reverseRelation); 

				page.addChild("mainContent", new SelectionElement(selectValue, 
					new FragmentTemplate(id, "Block").setStyleNames(new String[]{"control-group", "form-horizontal"})
						.addChild("content",
							new FragmentTemplate(id+"label", "Div").setStyleNames(new String[]{"input"})
								.addChild("content", 
									new FragmentTemplate(id+"label", "Div").setStyleNames(new String[]{"control-label"}).addChild("content", 
										new FragmentTemplate(id+"-text", "Text")
											.putText("text", new TextTemplate().getUntranslated().add(reverseRelation.getName()).add(" ").getTextTemplate()))
								)
								.addChild("content", 
									new FragmentTemplate(id+"controls", "Div").setStyleNames(new String[]{"controls"}).addChild("content", 
										new FragmentTemplate(id+"-link", "Link")
											.putText("text", getEntityTitle(reverseRelation.getTo()))
											.setEvent(ExploreDataEvent.INSTANCE))
								)
						)
					)
				);
			}
		}
		// Attributes
		for(Attribute attribute : entity.getAttributes()) {
			page.addChild("mainContent", new FragmentTemplate("attribute-"+attribute.getUniqueId(), "Input")
				.setField(entity, attribute)
			);
		}
		// Normal relations
		for (Relation relation : entity.getRelations()) {
			String id = "relation-"+relation.getUniqueId();
			Deduction selectValue = createSelectRelationDeduction(relation); 

			page.addChild("mainContent", relationAsField(id, relation, selectValue));
		}
		// Reverse relations
		for (Relation relation : entity.getReverseRelations()) {
			if (!relation.getReverseRelation().isOwner()) {
				String id = "relation-"+relation.getUniqueId();
				Deduction selectValue = createSelectReverseRelationDeduction(relation); 
	
				page.addChild("mainContent", relationAsField(id, relation, selectValue));
			}
		}
		
		// TODO: Once finished developing, cache this page in order to increase performance.
		return page;
	}

	@SuppressWarnings("rawtypes")
	private FragmentTemplate relationAsField(String id, Relation relation, Deduction selectValue) {
		return new FragmentTemplate(id, "Block").setStyleNames(new String[]{"control-group", "form-horizontal"})
			.addChild("content",
				new FragmentTemplate(id+"label", "Div").setStyleNames(new String[]{"input"})
					.addChild("content", 
						new FragmentTemplate(id+"label", "Div").setStyleNames(new String[]{"control-label"}).addChild("content", 
							new FragmentTemplate(id+"-text", "Text").putText("text", new TextTemplate().getUntranslated().add(relation.getName()).getTextTemplate()))
					)
					.addChild("content", new FragmentTemplate(id+"controls relations", "Div").setStyleNames(new String[]{"controls"})
						.addChild("content", 
							new SelectionElement(selectValue, 
								new FragmentTemplate(id+"-link", "Link")
									.putText("text", getEntityTitle(relation.getTo()))
									.setEvent(ExploreDataEvent.INSTANCE))
						)
						.addChild("content", 
							new FragmentTemplate(id+"detailsButton", "Button").setStyleNames(new String[]{"btn"})
								.putText("text", new TextTemplate().getUntranslated().add("Details").getTextTemplate())
								.setEvent(entityFlow.getRelationDetailsEvent(relation))
						)
					)
		);
	}

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
	private ReverseRelationDeduction createSelectReverseRelationDeduction(Relation reverseRelation) {
		SelectedInstanceDeduction selectedInstance = new SelectedInstanceDeduction(this.entity);
		ReverseRelationDeduction result = new ReverseRelationDeduction(reverseRelation.getReverseRelation());
		result.setToInstance(selectedInstance);
		return result;
	}

	@Override
	public String getId() {
		return entity.getUniqueId();
	}

	@Override
	public String getName() {
		return "details";
	}

}
