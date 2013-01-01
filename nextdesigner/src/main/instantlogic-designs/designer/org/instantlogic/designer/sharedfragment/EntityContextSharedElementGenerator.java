package org.instantlogic.designer.sharedfragment;

import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.DesignEntityGenerator;
import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.EntityDesignEntityGenerator;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.SharedElementDefinitionDesign;
import org.instantlogic.designer.SharedElementDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.TextTemplateDesign;
import org.instantlogic.designer.event.EntityDetailsEventGenerator;

public class EntityContextSharedElementGenerator extends SharedElementDefinitionDesign {

	public static final EntityContextSharedElementGenerator DEFINITION = new EntityContextSharedElementGenerator();
	
	private EntityContextSharedElementGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToSharedElements(this);
		setName("EntityContext");
	}
	
	@Override
	public void init() {
		DeductionSchemeDesign entityName;
		FragmentTemplateDesign entityLink;
		SharedElementDesign applicationContext;
		
		setFragment(
			new FragmentTemplateDesign("Group")
				.setChildren("content",
					applicationContext = new SharedElementDesign(),
					entityLink = new FragmentTemplateDesign("Link")
						.setChildren("content",
							new  FragmentTemplateDesign("Block")
								.addToStyleNames("inactive-card")
								.setChildren("content",
									createText("Heading3", new TextTemplateDesign()
										.addToUntranslated(new StringTemplateDesign().setDeduction(entityName = new DeductionSchemeDesign()))
										.addToUntranslated(new StringTemplateDesign().setConstantText(" (Entity)")))
								)
						)
				)
		);
	
		applicationContext.setDefinition(ApplicationContextSharedElementGenerator.DEFINITION);
		entityName.deduceAttribute(DesignEntityGenerator.name, entityName.deduceSelectedInstance(EntityDesignEntityGenerator.ENTITY));
		entityLink.setEvent(EntityDetailsEventGenerator.EVENT);
	}
}
