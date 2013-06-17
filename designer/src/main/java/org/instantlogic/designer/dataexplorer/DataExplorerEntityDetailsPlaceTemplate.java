package org.instantlogic.designer.dataexplorer;

import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.page.FragmentTemplate;

public class DataExplorerEntityDetailsPlaceTemplate extends PlaceTemplate {

	private final Entity<?> entity;

	public DataExplorerEntityDetailsPlaceTemplate(Entity<?> entity) {
		this.entity = entity;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public FragmentTemplate getRootContainer() {
		FragmentTemplate page = new FragmentTemplate("page", "Page")
			.addChild("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("h1", "Heading1")      
                    .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(entity.getName() + " details").getTextTemplate())        
            );
		for(Attribute attribute : entity.getAttributes()) {
			page.addChild("mainContent", new FragmentTemplate("attribute-"+attribute.getUniqueId(), "Input")
				.setField(entity, attribute)
			);
		}
		return page;
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
