/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer.codegenerator.generator;


import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.EventDesign;
import org.instantlogic.designer.codegenerator.classmodel.EventClassModel;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

public class EventGenerator extends AbstractGenerator {

	private EventDesign eventDesign;

	public EventGenerator(EventDesign eventDesign) {
		this.eventDesign = eventDesign;
	}
	
	@Override
	public void update(GeneratedClassModels context) {
		if (observations!=null && !observations.isOutdated()) {
			return;
		}

		CaseAdministration caseAdministration = eventDesign.getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();
		
		EventClassModel model = initModel();
		model.rootPackageName = context.rootPackageName;

		for (EntityDesign parameter: eventDesign.getParameters()) {
			model.parameters.add(parameter.getTechnicalNameCapitalized());
		}
		
		this.observations = new ObservationsOutdatedObserver(caseAdministration.stopRecordingObservations(), null);
		context.updatedEvents.add(model);
	}

	@Override
	public void delete(GeneratedClassModels context) {
		EventClassModel model = initModel();
		context.deletedEvents.add(model);
	}

	private EventClassModel initModel() {
		EventClassModel model = new EventClassModel();
		model.name = eventDesign.getName();
		model.technicalNameCapitalized = eventDesign.getTechnicalNameCapitalized();
		model.isCustomized = eventDesign.getIsCustomized()==Boolean.TRUE;
		return model;
	}
}
