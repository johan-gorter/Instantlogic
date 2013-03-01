# Instantlogic
Instantlogic is an experimental framework for creating real-time, collaborative web applications. See http://instantlogic.org.

## Build instructions

*Unfortunately, adopting a build tool has not been a priority so far. 
This is why the checkout contains an eclipse workspace*

1. Install JDK 7 and eclipse 4.2. Start eclipse and point the workspace location to the checkout.
2. Install the ivy plugin for eclipse
3. Go to Window -> Preferences -> General -> Workspace. Check 'Refresh using native hooks or polling'
4. File -> import -> general -> existing projects into workspace -> browse -> ok. Import all projects
5. Do an Ivy Resolve on all projects which contain an ivy.xml file
6. Now run Generator (in instantlogic-tools/org/instantlogic/tools/generator)
7. The workspace should now be free of compile errors
8. You can now run NettyServer (in instantlogic-netty/src/main/java/org/instantlogic/netty)
9. Start a browser and navigate to http://localhost:8080/index.html?application=izzy&case=project1
