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
6. Temporary remove all source folders that point to a folder that has not been generated yet
7. Run the following java applications:
  1. PresenceApplicationGenerator (in instantlogic-engine/src/main/instantlogic-designs/presence/org/instantlogic/engine/presence)
  2. IzzyGenerator (in izzy/src/main/instantlogic-designs/izzy/org/instantlogic/examples/izzy)
  3. DesignerApplicationGenerator (in nextdesigner/src/main/instantlogic-designs/designer/org/instantlogic/designer)
8. You can now run NettyServer (in instantlogic-netty/src/main/java/org/instantlogic/netty)
9. Start a browser and navigate to http://localhost:8080/index.html?application=izzy&case=project1