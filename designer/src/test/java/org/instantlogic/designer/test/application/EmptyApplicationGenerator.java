package org.instantlogic.designer.test.application;

import org.instantlogic.designer.ApplicationDesign;

public class EmptyApplicationGenerator {

	public static final ApplicationDesign DESIGN;
	
	static {
		DESIGN = new ApplicationDesign();
		DESIGN.setName("Empty");
		DESIGN.setRootPackageName("org.instantlogic.example.empty");
	}
}
