package org.instantlogic.designer.test.application;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.DesignerApplication;
import org.instantlogic.designer.util.DesignerCasePersister;

public class IzzyApplicationGenerator {

	public static final ApplicationDesign DESIGN;
	
	static {
		DESIGN = (ApplicationDesign) new DesignerCasePersister().loadOrCreate("izzy", ApplicationDesign.class, DesignerApplication.INSTANCE);
	}
}
