package org.instantlogic.designer.dataexplorer;

import java.util.List;

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
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.page.FragmentTemplate;
import org.instantlogic.interaction.page.IfElseElement;
import org.instantlogic.interaction.page.SelectionElement;

public class DataExplorerEntityDetailsPlaceTemplate extends PlaceTemplate {

	private final Entity<?> entity;
	private DataExplorerAdministration administration;
	private Entity<?>[] parameters;
	@SuppressWarnings("unchecked")
  private TextTemplate title = new TextTemplate().getUntranslated().add(createInstanceTitleDeduction()).getTextTemplate();

	public DataExplorerEntityDetailsPlaceTemplate(Entity<?> entity, DataExplorerOwnerBreadcrumbElement breadcrumbElement, DataExplorerAdministration administration) {
		this.entity = entity;
		this.administration = administration;
		this.parameters = new Entity<?>[]{entity};
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public FragmentTemplate getRootContainer() {
		// the resulting page can be used to view each instance of the same entity
		FragmentTemplate page = new FragmentTemplate(entity.getUniqueId()+"-details", "Page")
			.addChild("mainContent", new FragmentTemplate("h1", "Heading1")
				.putText("text", new TextTemplate().getUntranslated().add(entity.getName()).getTextTemplate()))
			.addChild("mainContent", new ShoppingElement(administration, entity))
			.addChild("mainContent",
        new FragmentTemplate("h2", "Heading2")
          .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated()
          	.add(createInstanceTitleDeduction())
          	.getTextTemplate())        
			);
		
    // Owner reverse relations
    for (Relation relation : entity.getReverseRelations()) {
      if (relation.getReverseRelation().isOwner()) {
        String id = "reverserelation-"+relation.getUniqueId();
        Deduction selectValue = createSelectReverseRelationDeduction(relation); 
  
        FragmentTemplate relationAsField = relationAsField(id, relation, selectValue);
        if (!relation.getName().toLowerCase().equals("owner")) {
          relationAsField.addChild("keyContent", new FragmentTemplate(relation.getUniqueId()+"-owner-text", "Text")
            .putText("text", new TextTemplate().getUntranslated().add(" (owner)").getTextTemplate()));
        }
        HasValueDeduction hasValueDeduction = new HasValueDeduction();
        AttributeDeduction attributeDeduction = new AttributeDeduction(relation);
        attributeDeduction.setInstance(new SelectedInstanceDeduction(entity));
        hasValueDeduction.setInput(attributeDeduction);
        page.addChild("mainContent", new IfElseElement(hasValueDeduction, relationAsField, null));
      }
    }
    // Reverse relations
    for (Relation relation : entity.getReverseRelations()) {
      if (!relation.getReverseRelation().isOwner()) {
        String id = "reverserelation-"+relation.getUniqueId();
        Deduction selectValue = createSelectReverseRelationDeduction(relation); 
  
        page.addChild("mainContent", relationAsField(id, relation, selectValue));
      }
    }
		// Normal relations
    page.addChild("mainContent", new FragmentTemplate("relationsBlockBlock", "Div").setStyleNames(new String[]{"separator"}));
		for (Relation relation : entity.getRelations()) {
			String id = "relation-"+relation.getUniqueId();
			Deduction selectValue = createSelectRelationDeduction(relation); 

			page.addChild("mainContent", relationAsField(id, relation, selectValue));
		}
    // Attributes
    page.addChild("mainContent", new FragmentTemplate("attributesBlock", "Div").setStyleNames(new String[]{"separator"}));

    for(Attribute attribute : entity.getAttributes()) {
      page.addChild("mainContent", new FragmentTemplate("attribute-"+attribute.getUniqueId(), "inputField")
        .setField(entity, attribute)
      );
    }

		page.addChild("mainContent", new FragmentTemplate("GoToBlock", "Div").setStyleNames(new String[]{"separator"}));
		page.addChild("mainContent", new FragmentTemplate("GoToText", "Text")
		  .putText("text", new TextTemplate().getUntranslated().add("Go to: ").getTextTemplate()));
		page.addChild("mainContent", new FragmentTemplate("staticinstances-link", "Link")
      .putText("text", new TextTemplate().getUntranslated().add("Static instances").getTextTemplate())
      .setDestination(administration.getStaticInstancesPlaceTemplate()));
    // DirectEvent buttons
    List<PlaceTemplate> placeTemplates = administration.getPlacesWithSingleParameter(entity);
    if (administration.getApplication().getStartPlace()!=null) {
      placeTemplates.add(administration.getApplication().getStartPlace());
    }
    // TODO: for every reverse owner-relation do a select recursively and add direct- buttons
    for (PlaceTemplate placeTemplate : placeTemplates) {
      page.addChild("mainContent", new FragmentTemplate("direct-"+placeTemplate.getTechnicalName(), "Button")
        .putText("text", new TextTemplate().getUntranslated().add(placeTemplate.getName()).getTextTemplate())
        .setDestination(placeTemplate)
      );
    }
    
		// TODO: Once finished developing, cache this page in order to increase performance.
		return page;
	}

	@SuppressWarnings("rawtypes")
	private FragmentTemplate relationAsField(String id, Relation relation, Deduction selectValue) {
		return new FragmentTemplate(id, "keyValue")
			.addChild("keyContent",
				new FragmentTemplate(id+"-link", "Link")
					.putText("text", new TextTemplate().getUntranslated().add(relation.getName()).getTextTemplate())
					.setDestination(administration.getRelationPlaceTemplate(entity, relation.getUniqueId()))
			)
			.addChild("valueContent", new SelectionElement(selectValue,
  			new FragmentTemplate(id+"-linkBlock", "Block")
			    .addChild("content", 
  				  new FragmentTemplate(id+"-link", "Link")
  					  .putText("text", getEntityTitle(relation.getTo()))
  					  .setDestination(administration.getExplorePlaceTemplate()))
  		));
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
	public String getName() {
		return "_DataExplorer-"+entity.getUniqueId();
	}

	@Override
	public String getId() {
		return getName();
	}
	
	@Override
	protected TextTemplate getTitle() {
		return title;
	}

	public Entity<?>[] getParameters() {
		return parameters;
	}
}
