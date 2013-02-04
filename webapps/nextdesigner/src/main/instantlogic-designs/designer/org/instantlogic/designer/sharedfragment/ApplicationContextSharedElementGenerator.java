/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer.sharedfragment;

import org.instantlogic.designer.ApplicationDesignEntityGenerator;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.SharedElementDefinitionDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.TextTemplateDesign;
import org.instantlogic.designer.event.HomeEventGenerator;

public class ApplicationContextSharedElementGenerator extends SharedElementDefinitionDesign {

	public static final ApplicationContextSharedElementGenerator DEFINITION = new ApplicationContextSharedElementGenerator();
	
	private ApplicationContextSharedElementGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToSharedElements(this);
		setName("ApplicationContext");
	}
	
	@Override
	public void init() {
		DeductionSchemeDesign applicationName;
		FragmentTemplateDesign applicationLink;
		
		setFragment(
			applicationLink = new FragmentTemplateDesign("Link")
				.setChildren("content",
					new  FragmentTemplateDesign("Block")
						.addToStyleNames("inactive-card")
						.setChildren("content",
							createText("Heading3", new TextTemplateDesign()
								.addToUntranslated(new StringTemplateDesign().setDeduction(applicationName = new DeductionSchemeDesign()))
								.addToUntranslated(new StringTemplateDesign().setConstantText(" (Application)")))
						)
				)
		);
	
		applicationName.deduceAttribute(ApplicationDesignEntityGenerator.name);
		applicationLink.setEvent(HomeEventGenerator.EVENT);
	}
}
