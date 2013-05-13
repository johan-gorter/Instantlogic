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

import org.instantlogic.fabric.util.TransactionListener;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.ApplicationEnvironment;
import org.instantlogic.interaction.PersistenceStrategy;
import org.instantlogic.tools.persistence.json.FileCasePersister;

public class ApplicationManager implements ApplicationEnvironment {


	private final Application application;
	private final HashMap<String, CaseManager> activeCases=new HashMap<String, CaseManager>();
	private PersistenceStrategy persistenceStrategy = new FileCasePersister();
	
	public ApplicationManager(Application application) {
		this.application = application;
	}
	
	public synchronized CaseManager getOrCreateCase(String caseId) {
		CaseManager result = caseId==null?null:activeCases.get(caseId);
		if (result == null) {
			result = new CaseManager(this, caseId, persistenceStrategy);
			activeCases.put(result.getCaseId(), result);
		}
		return result;
	}

	public Application getApplication() {
		return application;
	}

	@Override
	public void addTransactionListener(TransactionListener listener) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateApplication(Application updatedApplication) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setPersistenceStrategy(PersistenceStrategy newPersistenceStrategy) {
		persistenceStrategy = newPersistenceStrategy;
	}
}
