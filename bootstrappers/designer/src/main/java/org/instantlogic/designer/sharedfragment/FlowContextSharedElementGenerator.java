

package org.instantlogic.designer.sharedfragment;

import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.DesignEntityGenerator;
import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.FlowDesignEntityGenerator;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.SharedElementDefinitionDesign;
import org.instantlogic.designer.SharedElementDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.TextTemplateDesign;
import org.instantlogic.designer.event.FlowDetailsEventGenerator;

public class FlowContextSharedElementGenerator extends SharedElementDefinitionDesign {

	public static final FlowContextSharedElementGenerator DEFINITION = new FlowContextSharedElementGenerator();
	
	private FlowContextSharedElementGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToSharedElements(this);
		setName("FlowContext");
	}
	
	@Override
	public void init() {
		DeductionSchemeDesign flowName;
		FragmentTemplateDesign flowLink;
		SharedElementDesign applicationContext;
		
		setFragment(
			new FragmentTemplateDesign("Group")
				.setChildren("content",
					applicationContext = new SharedElementDesign(),
					flowLink = new FragmentTemplateDesign("Link")
						.setChildren("content",
							new  FragmentTemplateDesign("Block")
								.addToStyleNames("inactive-card")
								.setChildren("content",
									createText("Heading3", new TextTemplateDesign()
										.addToUntranslated(new StringTemplateDesign().setDeduction(flowName = new DeductionSchemeDesign()))
										.addToUntranslated(new StringTemplateDesign().setConstantText(" (Flow)")))
								)
						)
				)
		);
	
		applicationContext.setDefinition(ApplicationContextSharedElementGenerator.DEFINITION);
		flowName.deduceAttribute(DesignEntityGenerator.name, flowName.deduceSelectedInstance(FlowDesignEntityGenerator.ENTITY));
		flowLink.setEvent(FlowDetailsEventGenerator.EVENT);
	}
}
