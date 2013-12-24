package org.instantlogic.designer.placetemplate;

import org.instantlogic.designer.dataexplorer.DataExplorerExplorePlaceTemplate;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class ToDataExplorerPlaceTemplate extends AbstractToDataExplorerPlaceTemplate {
	
	@SuppressWarnings("rawtypes")
	private static final Entity[] ANY_ENTITY = new Entity[]{null};
	
	@SuppressWarnings("rawtypes")
	@Override
	public Entity[] getParameters() {
		return ANY_ENTITY;
	}
	
	@Override
	public FlowEventOccurrence enter(FlowContext context) {
		Instance parameter = context.getSelectedInstance(null);

		for (PlaceTemplate placeTemplate : context.getApplication().getPlaceTemplates()) {
			if (DataExplorerExplorePlaceTemplate.NAME.equals(placeTemplate.getName())) {
				return new FlowEventOccurrence(placeTemplate, parameter);
			}
		}
		throw new RuntimeException("Data explorer explore flow not found");
	}
}
