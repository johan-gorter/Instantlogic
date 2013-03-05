package org.instantlogic.designer.test.application;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.DataCategoryDesign;
import org.instantlogic.designer.EntityDesign;

public class MiniApplicationGenerator {

	public static final ApplicationDesign DESIGN;
	
	static {
		DESIGN = new ApplicationDesign();
		DESIGN.setName("Mini");
		DESIGN.setRootPackageName("org.instantlogic.example.mini");
		
		EntityDesign thing = new EntityDesign("Thing");
		DESIGN.addToEntities(thing);
		DESIGN.setCaseEntity(thing);
		thing.addAttribute("name", DataCategoryDesign.text);
	}
}
