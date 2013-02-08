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

import java.io.File;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.DesignerApplication;
import org.instantlogic.designer.codegenerator.generator.BackgroundThreadGeneratedClassModelsProcessor;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;
import org.instantlogic.engine.manager.ApplicationManager;
import org.instantlogic.fabric.Instance;

public class DesignerApplicationManager extends ApplicationManager {

	public static void registerDesignerApplication() {
		applicationManagers.put("Designer", new DesignerApplicationManager());
	}
	
	public DesignerApplicationManager() {
		super(DesignerApplication.INSTANCE);
	}

	@Override
	protected void caseCreated(Instance theCase) {
		ApplicationDesign applicationDesign = (ApplicationDesign)theCase;
		applicationDesign.setGeneratedClassModelsProcessor(
			new BackgroundThreadGeneratedClassModelsProcessor(
				new ApplicationJavacodeGenerator(new File(new File("../webapps", theCase.getName()), "target/generated-sources/instantlogic-app").getAbsoluteFile())
			)
		);
	}

}
