package org.instantlogic.engine.manager;

public interface EnginePlugin {
	
	void pluggedIn(EngineManager engineManager);
	
	void caseCreated(CaseProcessor caseProcessor);
	
}
