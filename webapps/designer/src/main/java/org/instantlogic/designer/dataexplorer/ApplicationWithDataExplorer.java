package org.instantlogic.designer.dataexplorer;

import java.util.Arrays;
import java.util.List;

import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.flow.PlaceTemplate;

// Wraps another application and adds the DataExplorer flows
public class ApplicationWithDataExplorer extends ApplicationWrapper {

	private final DataExplorerAdministration administration;
	private PlaceTemplate[] placeTemplates;

	public ApplicationWithDataExplorer(Application delegate) {
		super(delegate);
		administration = new DataExplorerAdministration(delegate);
	}

	@Override
	public PlaceTemplate getStartPlace() {
		PlaceTemplate startPlace = super.getStartPlace();
		if (startPlace==null) {
			return administration.getEntityDetailsPlaceTemplate(getCaseEntity());
		}
		return super.getStartPlace();
	}
	
	@Override
	public PlaceTemplate[] getPlaceTemplates() {
		if (placeTemplates == null) {
			List<PlaceTemplate> newPlaceTemplates = administration.getPlaceTemplates();
			newPlaceTemplates.addAll(Arrays.asList(super.getPlaceTemplates()));
			placeTemplates = newPlaceTemplates.toArray(new PlaceTemplate[newPlaceTemplates.size()]);
		}
		return placeTemplates;
	}
}
