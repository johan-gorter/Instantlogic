package org.instantlogic.designer.test.application;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.DataCategoryDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.EntityDesign.RelationType;
import org.instantlogic.designer.StaticInstanceDesign;

public class MiniApplicationGenerator {

	public static final ApplicationDesign APPLICATION_DESIGN;
	
	static {
		APPLICATION_DESIGN = new ApplicationDesign();
		APPLICATION_DESIGN.setName("Mini");
		APPLICATION_DESIGN.setRootPackageName("org.instantlogic.designer.test.application.mini");
		
		EntityDesign person = new EntityDesign("Person");
		APPLICATION_DESIGN.addToEntities(person);
		APPLICATION_DESIGN.setCaseEntity(person);
		person.addAttribute("name", DataCategoryDesign.text);
		
		EntityDesign thing = new EntityDesign("Thing");
		thing.addAttribute("name", DataCategoryDesign.text);
		APPLICATION_DESIGN.addToEntities(thing);
		thing.setIsCustomized(true);
		StaticInstanceDesign holyGrail = new StaticInstanceDesign();
		holyGrail.setName("holyGrail");
		thing.addToStaticInstances(holyGrail);
		
		person.addRelation("owns", RelationType.OneToManyAggregation, thing).setReverseName("owner");
	}
}
