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
