package org.instantlogic.designer.dataexplorer;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.value.WriteableAttributeValue;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.page.FragmentTemplate;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class DataExplorerExplorePlaceTemplate extends PlaceTemplate {

	private DataExplorerAdministration administration;
	private Entity<?>[] parameters;
	
	public DataExplorerExplorePlaceTemplate(DataExplorerAdministration administration) {
		this.parameters = new Entity<?>[]{null};
		this.administration = administration;
	}

	@Override
	public FragmentTemplate getRootContainer() {
		return null;
	}

	@Override
	public Entity<?>[] getParameters() {
		return parameters;
	}

	@Override
	public String getName() {
		return "_DataExplorer-explore";
	}

	@Override
	public String getId() {
		return getName();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public FlowEventOccurrence enter(FlowContext context) {
		Instance instance = context.getSelectedInstance(null);
		return new FlowEventOccurrence(administration.getEntityDetailsPlaceTemplate(instance.getMetadata().getEntity()), instance);
	}
}
