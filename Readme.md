# Instantlogic

Instantlogic is an experimental web development framework, focussing on interaction and cooperation.

## Build instructions

*Unfortunately, adopting a build tool has not been a priority so far. 
This is why the checkout contains an eclipse workspace*

1. Install JDK 7 and eclipse 4.2
2. Install the ivy plugin for eclipse
3. Go to Window -> Preferences -> General -> Workspace. Check 'Refresh using native hooks or polling'
4. File -> import -> general -> existing projects into workspace -> browse -> ok. Import all projects
5. Run the following java applications:
  1. PresenceApplicationGenerator (in instantlogic-engine/src/main/instantlogic-designs/presence/org/instantlogic/engine/presence)
  2. IzzyGenerator (in izzy/src/main/instantlogic-designs/izzy/org/instantlogic/examples/izzy)
  3. DesignerApplicationGenerator (in nextdesigner/src/main/instantlogic-designs/designer/org/instantlogic/designer)
6. You can now run NettyServer (in instantlogic-netty/src/main/java/org/instantlogic/netty)
7. Start a browser and navigate to http://localhost:8080/index.html?application=izzy&case=project1