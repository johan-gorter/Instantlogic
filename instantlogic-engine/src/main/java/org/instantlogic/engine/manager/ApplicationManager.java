/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.engine.manager;

import java.util.HashMap;
import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.Application;

public class ApplicationManager {

	protected static Map<String, ApplicationManager> applicationManagers = new HashMap<String, ApplicationManager>();
	
	public static void registerApplication(Application application) {
		applicationManagers.put(application.getName(), new ApplicationManager(application));
	}
	
	public static ApplicationManager getManager(String name) {
		ApplicationManager result = applicationManagers.get(name);
		if (result==null) {
			throw new RuntimeException("No such application: "+name);
		}
		return result;
	}

	private final Application application;
	private final HashMap<String, CaseManager> activeCases=new HashMap<String, CaseManager>();
	
	public ApplicationManager(Application application) {
		this.application = application;
	}
	
	public synchronized CaseManager getOrCreateCase(String caseId) {
		CaseManager result = caseId==null?null:activeCases.get(caseId);
		if (result == null) {
			result = new CaseManager(this, caseId);
			activeCases.put(result.getCaseId(), result);
			caseCreated(result.getCase());
		}
		return result;
	}

	protected void caseCreated(Instance case1) {
	}

	public Application getApplication() {
		return application;
	}
}
