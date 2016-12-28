## Build instructions

1. Do a maven build using 'mvn install' (use 'install' because a maven plugin is built that will be used later in the build)
2. If using eclipse: Go to Window -> Preferences -> General -> Workspace. Check 'Refresh using native hooks or polling'
3. Run NettyServer (in instantlogic-netty/src/main/java/org/instantlogic/netty)
4. Start a browser and navigate to http://localhost:8080/index.html?application=izzy&case=project1
