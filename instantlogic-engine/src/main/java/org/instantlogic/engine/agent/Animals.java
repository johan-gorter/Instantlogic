package org.instantlogic.engine.agent;

import java.util.Map;

import org.instantlogic.engine.manager.CaseProcessor;
import org.instantlogic.engine.manager.EngineManager;
import org.instantlogic.engine.manager.EnginePlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Animals implements EnginePlugin {

	private static final Logger logger = LoggerFactory.getLogger(Animals.class);

	private RandomAgent agent1;
	private Thread runnerThread;
	private Runnable runner  = new Runnable() {
		
		@Override
		public void run() {
			try {
				while (true) {
					agent1.step();
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				agent1.exit();
				agent1 = null;
			} catch (Exception e) {
				logger.error("Fatal exception", e);
			}
		}
	};

	private EngineManager engineManager;

	@Override
	public void caseCreated(CaseProcessor caseProcessor) {
		addAgents(caseProcessor);
		runnerThread = new Thread(runner);
		runnerThread.start();
	}

	public void stop() {
		if (runnerThread!=null) {
			runnerThread.interrupt();
			runnerThread = null;
		}
	}
	
	public void restart() {
		if (runnerThread!=null) {
			stop();
		}
		for(CaseProcessor caseProcessor : this.engineManager.getCaseProcessors().values()) {
			addAgents(caseProcessor);
		}
		runnerThread = new Thread(runner);
		runnerThread.start();
	}

	private void addAgents(CaseProcessor caseProcessor) {
		if (!"Designer".equals(caseProcessor.getApplication().getName())) {
			this.agent1 = new RandomAgent("monkey@instantlogic.org");
			agent1.start(caseProcessor);
		}
	}

	@Override
	public void pluggedIn(EngineManager engineManager) {
		this.engineManager = engineManager;
	}
}
