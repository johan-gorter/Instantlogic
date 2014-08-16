package org.instantlogic.designer.dataexplorer;

import java.util.SortedMap;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.deduction.ConstantDeduction;
import org.instantlogic.fabric.deduction.SelectedInstanceDeduction;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.text.TextTemplate;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.page.FragmentTemplate;
import org.instantlogic.interaction.page.SelectionElement;

/**
 * Renders a static place which shows all static instances
 */
public class DataExplorerStaticInstancesPlaceTemplate extends PlaceTemplate {

	private DataExplorerAdministration administration;

	public DataExplorerStaticInstancesPlaceTemplate(DataExplorerAdministration administration) {
		this.administration = administration;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public FragmentTemplate getRootContainer() {
		FragmentTemplate page = new FragmentTemplate("staticinstances", "Page")
			.addChild("mainContent", new FragmentTemplate("h2", "Heading2")
				.putText("text", new TextTemplate().getUntranslated().add("Data Explorer").getTextTemplate()))
			.addChild("mainContent", new SelectionElement(new SelectedInstanceDeduction(administration.getCaseEntity()), 
				new FragmentTemplate("root-link", "Link")
					.putText("text", new TextTemplate().getUntranslated().add("Back to "+administration.getCaseEntity().getName()).getTextTemplate())
					.setDestination(administration.getEntityDetailsPlaceTemplate(administration.getCaseEntity()))
				))
			.addChild("mainContent", new ShoppingElement(administration))
			.addChild("mainContent",
	            new FragmentTemplate("h1", "Heading1")      
	                .putText("text", new TextTemplate().getUntranslated()
	                	.add("Static instances").getTextTemplate())        
	        );
		
		int id = 0;
		SortedMap<String, Entity<?>> entities = administration.getApplication().getAllEntities();
		for (Entity<?> entity : entities.values()) {
			if (entity.getStaticInstances().size()>0) {
				page.addChild("mainContent", new FragmentTemplate("h2", "Heading2")
					.putText("text", new TextTemplate().getUntranslated().add("Entity '"+entity.getName()+"'").getTextTemplate()));
				for (Instance instance : entity.getStaticInstances().values()) {
					page.addChild("mainContent", 
						new SelectionElement(new ConstantDeduction<Instance>(instance),
							new FragmentTemplate("block-"+(id++),"Block").addChild("content",
								new FragmentTemplate("link-"+(id++), "Link")
									.putText("text", new TextTemplate().getUntranslated().add(instance.getMetadata().getStaticName()).getTextTemplate())
									.setDestination(administration.getEntityDetailsPlaceTemplate(entity))
							)
						)
					);
				}
			}
		}
		
		return page;
	}

	@Override
	public String getId() {
		return getName();
	}

	@Override
	public String getName() {
		return "_DataExplorer-staticinstances";
	}

}
