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

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.instantlogic.engine.TravelerProxy;
import org.instantlogic.engine.message.Message;

public class EngineProcessor {

	private static Map<String, CaseProcessor> caseProcessors = new ConcurrentHashMap<String, CaseProcessor>();
	
	public static synchronized CaseProcessor getCaseProcessor(String application, String caseId) {
		String key = application+":"+caseId;
		CaseProcessor result = caseProcessors.get(key);
		if (result==null) {
			ApplicationManager applicationManager = ApplicationManager.getManager(application);
			result = new CaseProcessor(applicationManager, caseId);
			caseProcessors.put(key, result);
		}
		return result;
	}
	
	public static void process(String application, String caseId, TravelerProxy travelerProxy, List<Message> messages) {
		CaseProcessor caseProcessor = getCaseProcessor(application, caseId);
		caseProcessor.processMessagesAndSendUpdates(travelerProxy, messages);
	}

	public static String printCaseDiagnostics() {
		StringBuffer sb = new StringBuffer();
		for (CaseProcessor caseProcessor : caseProcessors.values()) {
			caseProcessor.printCaseDiagnostics(sb);
		}
		return sb.toString();
	}

	public static String printPresenceDiagnostics() {
		StringBuffer sb = new StringBuffer();
		for (CaseProcessor caseProcessor : caseProcessors.values()) {
			caseProcessor.printPresenceDiagnostics(sb);
		}
		return sb.toString();
	}
}
