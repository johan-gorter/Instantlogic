package org.instantlogic.designer.codegenerator.classmodel;

import java.util.ArrayList;
import java.util.List;

public class ApplicationClassModel extends AbstractClassModel {

	public String caseEntity;
	public String mainFlow;
	public String startEvent;
	public String loggedInEvent;
	public String[] themeNames;
	public final List<String> entities = new ArrayList<String>();
	
	public final List<String> placeTemplates = new ArrayList<String>();
	public String startPlace;
	public String loggedInPlace;
	
	public String getCaseEntity() {
		return caseEntity;
	}
	public List<String> getEntities() {
		return entities;
	}
	public String getMainFlow() {
		return mainFlow;
	}
	public String getStartEvent() {
		return startEvent;
	}
	public String[] getThemeNames() {
		return themeNames;
	}
	public String getLoggedInEvent() {
		return loggedInEvent;
	}
	public List<String> getPlaceTemplates() {
		return placeTemplates;
	}
	public String getStartPlace() {
		return startPlace;
	}
	public String getLoggedInPlace() {
		return loggedInPlace;
	}
}
