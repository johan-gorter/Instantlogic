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

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.instantlogic.engine.agent.Animals;
import org.instantlogic.engine.manager.DesignerEngineManager;
import org.instantlogic.engine.manager.EngineManager;
import org.instantlogic.engine.manager.Update;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyServer {

	private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);

	private static final boolean WATCH_FILES = true;
	
	private static final Update FILES_UPDATED = new Update("filesUpdated");
	private static final Update CSS_FILES_UPDATED = new Update("cssFilesUpdated");

	private static TravelersManagement travelersManagement;
	private static EngineManager engineManager;
	private static File webroot;
	private static File webapps;
	private static int port = 7080;
	
	
	private static Runnable fileWatcher = new Runnable() {
		@Override
		public void run() {
			watch(webroot);
		}
	};
	
	private static Runnable fileWatcherStyle = new Runnable() {
		@Override
		public void run() {
			watch(new File(webroot, "style"));
		}
	};

	private static Runnable fileWatcherInstanceGraph = new Runnable() {
    @Override
    public void run() {
      watch(new File(webroot, "instance-graph"));
    }
  };

	private static Animals animals;

	public static void main(String[] args) throws IOException, ParseException {
		Options options = new Options();
		options.addOption(new Option("help", "Print this message"));
		options.addOption("webapps", true, "Folder which contains the web applications to run");
		options.addOption("port", true, "The port to run the webserver on");
		options.addOption("animals", false, "Have a bunch of animals run around in the applications while creating testdata");
		CommandLineParser parser = new BasicParser();
		CommandLine cmd = parser.parse( options, args);
		if (cmd.hasOption("help")) {
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp( "instantlogic-server", options );
			return;
		}
		webapps = new File(cmd.hasOption("webapps")?cmd.getOptionValue("webapps"):"../webapps");
		if (!webapps.isDirectory()) {
			throw new RuntimeException("Webapps folder not found: "+webapps.getAbsolutePath());
		}
		if (cmd.hasOption("port")) {
			port = Integer.parseInt(cmd.getOptionValue("port"));
		}
		
		engineManager = new DesignerEngineManager();
		engineManager.registerWebappsDirectory(webapps);
		
		if (cmd.hasOption("animals")) {
			startAnimals();
		}
		
		webroot = new File("../web");
		if (!webroot.isDirectory()) {
			webroot = new File("src/main/webroot");
			if (!webroot.isDirectory()) {
				throw new RuntimeException("Web root folder not found");
			}
		}
		
		travelersManagement = new TravelersManagement(engineManager);
		
		EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();		
		ServerBootstrap bootstrap = new ServerBootstrap()
		  .group(bossGroup, workerGroup)
		  .channel(NioServerSocketChannel.class)
		  .childHandler(new InstantlogicPipelineFactory(travelersManagement, webroot));

		ExecutorService executor = Executors.newCachedThreadPool(factory);
		
		if (WATCH_FILES) {
			executor.execute(fileWatcher);
			executor.execute(fileWatcherStyle);
      executor.execute(fileWatcherInstanceGraph);
		}
		
		bootstrap.bind(new InetSocketAddress(port)).addListener(new GenericFutureListener<Future<? super Void>>() {
      @Override
      public void operationComplete(Future<? super Void> future) throws Exception {
        if (future.isSuccess()) {
          logger.info("Server started at port "+port);
        } else {
          logger.error("Could not bind to port "+port);
          System.exit(1);
        }
      }
    });
		
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
			} else if ("stopanimals".equalsIgnoreCase(command)){
				stopAnimals();
			} else if ("startanimals".equalsIgnoreCase(command)){
				startAnimals();
			} else {
				executor.execute(filesUpdatedBroadcaster);
			}
		}
		scheduler.shutdown();
		executor.shutdown();
		System.exit(0);
	}	
	
	private static void startAnimals() {
		if (animals==null) {
			animals = new Animals();
			engineManager.addPlugin(animals);
		} else  {
			stopAnimals();
			animals.restart();
		}
	}

	private static void stopAnimals() {
		animals.stop();
	}

	private static void watch(File dirFile) {
		try {
			WatchService watcher = FileSystems.getDefault().newWatchService();
			Path dir = dirFile.toPath();
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
