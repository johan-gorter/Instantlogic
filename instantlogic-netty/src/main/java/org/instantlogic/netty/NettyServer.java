/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.netty;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Thread.UncaughtExceptionHandler;
import java.net.InetSocketAddress;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.instantlogic.designer.DesignerApplication;
import org.instantlogic.engine.manager.EngineManager;
import org.instantlogic.engine.manager.Update;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyServer {

	private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);

	private static final boolean WATCH_FILES = true;
	
	private static final Update FILES_UPDATED = new Update("filesUpdated");
	private static final Update CSS_FILES_UPDATED = new Update("cssFilesUpdated");

	private static TravelersManagement travelersManagement;
	private static EngineManager engineManager;
	
	private static Runnable fileWatcher = new Runnable() {
		@Override
		public void run() {
			watch("src/main/webroot");
		}
	};
	
	private static Runnable fileWatcherStyle = new Runnable() {
		@Override
		public void run() {
			watch("src/main/webroot/style");
		}
	};
	
	public static void main(String[] args) throws IOException {
		DesignerApplicationManager.registerDesignerApplication();
		engineManager = new EngineManager();
		engineManager.registerApplication(DesignerApplication.INSTANCE);
		engineManager.registerWebappsDirectory(new File("../webapps"));
		
		travelersManagement = new TravelersManagement(engineManager);
		
		ExecutorService executor = Executors.newCachedThreadPool(factory);
		ServerBootstrap bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(Executors.newSingleThreadExecutor(factory), executor));

		// Set up the event pipeline factory.
		bootstrap.setPipelineFactory(new InstantlogicPipelineFactory(travelersManagement));

		if (WATCH_FILES) {
			executor.execute(fileWatcher);
			executor.execute(fileWatcherStyle);
		}
		
		bootstrap.bind(new InetSocketAddress(8080));
		logger.info("Server started");
		
		ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(1,factory);
		scheduler.scheduleWithFixedDelay(sweeper, 10, 10, TimeUnit.SECONDS); // This may be a bit short for mobile devices on the road

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Enter a command");
			final String command = in.readLine();
			if ("quit".equalsIgnoreCase(command)) {
				break;
			} else if ("case".equalsIgnoreCase(command)) {
				System.out.println(engineManager.printCaseDiagnostics());
			} else if ("presence".equalsIgnoreCase(command)) {
				System.out.println(engineManager.printPresenceDiagnostics());
			} else if ("sweep".equalsIgnoreCase(command)){
				travelersManagement.sweep();
			} else {
				executor.execute(filesUpdatedBroadcaster);
			}
		}
		scheduler.shutdown();
		executor.shutdown();
	}	
	
	private static void watch(String dirPath) {
		try {
			WatchService watcher = FileSystems.getDefault().newWatchService();
			Path dir = new File(dirPath).toPath();
			WatchKey key = dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);				
			while (true) {
				try {
					key = watcher.take();
					logger.warn("Filesystem update detected");
				} catch (InterruptedException x) {
					return;
				}
				boolean cssOnly = true;
				for (WatchEvent<?> event : key.pollEvents()) {
					Path path = (Path) event.context();
					if (path!=null && !path.toString().endsWith(".css")) {
						cssOnly = false;
						break;
					}
				}
				travelersManagement.broadcast(cssOnly?CSS_FILES_UPDATED:FILES_UPDATED);
				if (!key.reset()) break;
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static Runnable sweeper = new Runnable() {
		@Override
		public void run() {
			travelersManagement.sweep();
		}
	};

	private static Runnable filesUpdatedBroadcaster = new Runnable() {
		@Override
		public void run() {
			travelersManagement.broadcast(FILES_UPDATED);
		}
	};

	private static final ThreadFactory factory = new ThreadFactory() {
		
		@Override
		public Thread newThread(Runnable target) {
			final Thread thread = new Thread(target);
	        logger.debug("Creating new worker thread");
	        thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
	 
	            @Override
	            public void uncaughtException(Thread t, Throwable e) {
	                logger.error("Uncaught Exception in executor", e);
	            }
	 
	        });
	        return thread;
		}
	};
}
