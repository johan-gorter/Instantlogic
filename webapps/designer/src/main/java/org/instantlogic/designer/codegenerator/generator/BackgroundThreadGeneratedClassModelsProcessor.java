package org.instantlogic.designer.codegenerator.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BackgroundThreadGeneratedClassModelsProcessor implements GeneratedClassModelsProcessor, AutoCloseable {

	private static final Logger logger = LoggerFactory.getLogger(BackgroundThreadGeneratedClassModelsProcessor.class);
	
	private final GeneratedClassModelsProcessor delegate;
	private final String name;
	private LinkedBlockingQueue<GeneratedClassModels> queue;
	private String applicationName;
	private Thread thread;
	private Runnable processor = new Runnable() {
		
		@Override
		public void run() {
			List<GeneratedClassModels> read = new ArrayList<GeneratedClassModels>();
			GeneratedClassModels accumulated;
			while (!Thread.interrupted()) {
				try {
					read.clear();
					queue.drainTo(read);
					if (read.size()==0) {
						accumulated = queue.take(); // Blocks
					} else {
						accumulated = GeneratedClassModels.merge(read);
					}
					logger.debug("Backgound thread [{}] started processing", name);
					delegate.process(accumulated, applicationName);
					logger.debug("Backgound thread [{}] finished processing", name);
				} catch (Exception e) {
					if (e instanceof InterruptedException) {
						return;
					}
					logger.error("Exception in background "+name, e);
				}
			}
		}
	};

	public BackgroundThreadGeneratedClassModelsProcessor(GeneratedClassModelsProcessor delegate) {
		this.delegate = delegate;
		queue = new LinkedBlockingQueue<GeneratedClassModels>();
		name = delegate.getName();
		thread = new Thread(processor);
		thread.setName(delegate.getName());
		thread.start();
	}

	@Override
	public void process(GeneratedClassModels models, String applicationName) {
		this.applicationName = applicationName;
		queue.add(models);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void close() throws Exception {
		thread.interrupt();
	}
}
