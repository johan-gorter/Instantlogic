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

	private DataExplorerRootFlow rootFlow;

	public DataExplorerStaticInstancesPlaceTemplate(DataExplorerRootFlow dataExplorerRootFlow) {
		this.rootFlow = dataExplorerRootFlow;
	}

	@Override
	public FragmentTemplate getRootContainer() {
		FragmentTemplate page = new FragmentTemplate("staticinstances", "Page")
			.addChild("mainContent", new FragmentTemplate("h2", "Heading2")
				.putText("text", new TextTemplate().getUntranslated().add("Data Explorer").getTextTemplate()))
			.addChild("mainContent", new SelectionElement(new SelectedInstanceDeduction(rootFlow.getCaseEntity()), 
				new FragmentTemplate("root-link", "Link")
					.putText("text", new TextTemplate().getUntranslated().add("Back to "+rootFlow.getCaseEntity().getName()).getTextTemplate())
					.setEvent(rootFlow.getEntityDetailsEvent(rootFlow.getCaseEntity()))
				))
			.addChild("mainContent", new ShoppingElement(rootFlow))
			.addChild("mainContent",
	            new FragmentTemplate("h1", "Heading1")      
	                .putText("text", new TextTemplate().getUntranslated()
	                	.add("Static instances").getTextTemplate())        
	        );
		
		int id = 0;
		SortedMap<String, Entity<?>> entities = rootFlow.getApplication().getAllEntities();
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
									.setEvent(rootFlow.getEntityDetailsEvent(entity))
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
		return "staticinstances";
	}

	@Override
	public String getName() {
		return "Static instances";
	}

}
