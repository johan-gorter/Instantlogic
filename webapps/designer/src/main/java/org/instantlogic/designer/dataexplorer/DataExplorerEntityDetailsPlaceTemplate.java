package org.instantlogic.designer.dataexplorer;

import java.util.List;

import org.instantlogic.fabric.deduction.AttributeDeduction;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.deduction.ReverseRelationDeduction;
import org.instantlogic.fabric.deduction.SelectedInstanceDeduction;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.text.TextTemplate;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.page.FragmentTemplate;
import org.instantlogic.interaction.page.SelectionElement;

public class DataExplorerEntityDetailsPlaceTemplate extends PlaceTemplate {

	private final Entity<?> entity;
	private DataExplorerEntityFlow entityFlow;
	private List<FlowEvent> directEvents;
	private DataExplorerOwnerBreadcrumbElement breadcrumbElement;
	private DataExplorerRootFlow rootFlow;

	public DataExplorerEntityDetailsPlaceTemplate(DataExplorerEntityFlow entityFlow, List<FlowEvent> directEvents, DataExplorerOwnerBreadcrumbElement breadcrumbElement, DataExplorerRootFlow dataExplorerRootFlow) {
		this.entity = entityFlow.getEntity();
		this.entityFlow = entityFlow;
		this.directEvents = directEvents;
		this.breadcrumbElement = breadcrumbElement;
		this.rootFlow = dataExplorerRootFlow;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public FragmentTemplate getRootContainer() {
		// the resulting page can be used to view each instance of the same entity
		FragmentTemplate page = new FragmentTemplate(entity.getUniqueId()+"-details", "Page")
			.addChild("mainContent", new FragmentTemplate("h2", "Heading2")
				.putText("text", new TextTemplate().getUntranslated().add("Data Explorer").getTextTemplate()))
			.addChild("mainContent", new FragmentTemplate("staticinstances-link", "Link")
				.putText("text", new TextTemplate().getUntranslated().add("Static instances").getTextTemplate())
				.setEvent(ExploreStaticInstancesEvent.INSTANCE))
			.addChild("mainContent", new ShoppingElement(rootFlow, entity))
		    .addChild("mainContent", breadcrumbElement)
			.addChild("mainContent",
                new FragmentTemplate("h1", "Heading1")      
                    .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated()
                    	.add(createInstanceTitleDeduction())
                    	.getTextTemplate())        
            );
		
		// DirectEvent buttons
		for (FlowEvent directEvent : directEvents) {
			page.addChild("mainContent", new FragmentTemplate("direct-"+directEvent.getName(), "Button")
				.putText("text", new TextTemplate().getUntranslated().add(directEvent.getName()).getTextTemplate())
				.setEvent(directEvent)
			);
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
				String id = "reverserelation-"+relation.getUniqueId();
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
								new FragmentTemplate(id+"-linkBlock", "Block").addChild("content", 
									new FragmentTemplate(id+"-link", "Link")
										.putText("text", getEntityTitle(relation.getTo()))
										.setEvent(ExploreDataEvent.INSTANCE))
								)
						)
						.addChild("content", 
							new FragmentTemplate(id+"detailsButton", "Button").setStyleNames(new String[]{"btn"})
								.putText("text", new TextTemplate().getUntranslated().add("Relation").getTextTemplate())
								.setEvent(entityFlow.getRelationDetailsEvent(relation))
						)
					)
		);
	}

	static TextTemplate getEntityTitle(Entity<?> entity) {
		return new TextTemplate().getUntranslated().add(new DataExplorerInstanceTitleDeduction()).getTextTemplate();
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

	@SuppressWarnings({ "rawtypes" })
	private Deduction createInstanceTitleDeduction() {
		return new Deduction<String>() {
			@Override
			protected ValueAndLevel<String> execute(DeductionContext context) {
				TextTemplate entityTitle = getEntityTitle(entity);
				return ValueAndLevel.rule(entityTitle.renderText(context));
			}
		};
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
