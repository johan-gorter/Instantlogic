package org.instantlogic.designer.dataexplorer;

import org.instantlogic.designer.IfElseDesign;
import org.instantlogic.fabric.deduction.AttributeDeduction;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.deduction.HasValueDeduction;
import org.instantlogic.fabric.deduction.ReverseRelationDeduction;
import org.instantlogic.fabric.deduction.SelectedInstanceDeduction;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.text.TextTemplate;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.page.FragmentTemplate;
import org.instantlogic.interaction.page.IfElseElement;
import org.instantlogic.interaction.page.SelectionElement;

public class DataExplorerEntityDetailsPlaceTemplate extends PlaceTemplate {

	private final Entity<?> entity;

	public DataExplorerEntityDetailsPlaceTemplate(Entity<?> entity) {
		this.entity = entity;
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
					new FragmentTemplate(id, "Group")
						.addChild("content", new FragmentTemplate(id+"-text", "Text").putText("text", new TextTemplate().getUntranslated().add(reverseRelation.getName()).add(" ").getTextTemplate()))
						.addChild("content", new FragmentTemplate(id+"-link", "Link").putText("text", reverseRelation.getTo().getTitle()).setEvent(ExploreDataEvent.INSTANCE))
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

			page.addChild("mainContent", new FragmentTemplate(id, "Block")
				.addChild("content", new FragmentTemplate(id+"-text", "Text").putText("text", new TextTemplate().getUntranslated().add(relation.getName()).add(":").getTextTemplate()))
				.addChild("content", new SelectionElement(selectValue, 
					new FragmentTemplate(id, "Block")
						.addChild("content", new FragmentTemplate(id+"-link", "Link").putText("text", relation.getTo().getTitle()).setEvent(ExploreDataEvent.INSTANCE))
					)
				)
			);
		}
		
		// TODO: Once finished developing, cache this page in order to increase performance.
		return page;
	}

	private AttributeDeduction createSelectRelationDeduction(Relation relation) {
		SelectedInstanceDeduction selectedInstance = new SelectedInstanceDeduction(this.entity);
		AttributeDeduction result = new AttributeDeduction(relation);
		result.setInstance(selectedInstance);
		return result;
	}

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
