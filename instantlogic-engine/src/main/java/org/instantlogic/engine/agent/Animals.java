package org.instantlogic.engine.agent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.instantlogic.engine.manager.CaseProcessor;
import org.instantlogic.engine.manager.EngineManager;
import org.instantlogic.engine.manager.EnginePlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Animals implements EnginePlugin {
	
	public class Animal extends RandomAgent {

		public List<String> words = new ArrayList<String>();
		public List<String> sentences = new ArrayList<String>();
		public List<String> stories = new ArrayList<String>();
		
		public Animal(String name) {
			super(name+"@instantlogic.org");
			InputStream stream = Animals.class.getResourceAsStream("texts-"+name+".txt");
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
				String line;
				List<String> addTo = words;
				while ((line = reader.readLine()) != null) {
					if (line.length()==0) {
						if (addTo==words) {
							addTo = sentences;
						} else {
							addTo = stories;
						}
					} else {
						addTo.add(line);
					}
				}
				if (stories.size()==0) {
					throw new RuntimeException("Could not read all 3 sections from texts-"+name+".txt");
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		
		@Override
		protected String provideText(boolean multiLine, String currentValue) {
			List<String> pickFrom;
			if (multiLine) {
				if (Math.random()<0.5) {
					pickFrom = sentences;
				} else {
					pickFrom = stories;
				}
			} else {
				if (Math.random()<0.5) {
					pickFrom = sentences;
				} else {
					pickFrom = words;
				}
			}
			String item = pickFrom.get((int)(Math.random()*pickFrom.size()));
			boolean append = currentValue!=null && Math.random()<0.5;
			if (append && multiLine) {
				return currentValue+"\r\n\r\n"+item;
			}
			if (append && !multiLine) {
				return currentValue+" "+item;
			}
			return item;
		}
	}

	private static final Logger logger = LoggerFactory.getLogger(Animals.class);

	private Animal monkey;
	private Thread runnerThread;
	private Runnable runner  = new Runnable() {
		
		@Override
		public void run() {
			try {
				while (true) {
					monkey.step();
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				monkey.exit();
				monkey = null;
			} catch (Exception e) {
				logger.error("Fatal exception", e);
			}
		}
	};

	private EngineManager engineManager;

	@Override
	public void caseCreated(CaseProcessor caseProcessor) {
		if (!"Designer".equals(caseProcessor.getApplication().getName())) {
			addAgents(caseProcessor);
			runnerThread = new Thread(runner);
			runnerThread.start();
		}
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
		this.monkey = new Animal("monkey");
		monkey.start(caseProcessor);
	}

	@Override
	public void pluggedIn(EngineManager engineManager) {
		this.engineManager = engineManager;
	}
}
