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
					delegate.process(accumulated);
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
		thread.start();
	}

	@Override
	public void process(GeneratedClassModels models) {
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
