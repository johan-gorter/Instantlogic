package org.instantlogic.designer;



public class DesignEntityGenerator extends EntityDesign {

    public static final DesignEntityGenerator ENTITY = new DesignEntityGenerator();
    
    private DesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
    	setIsCustomized(true);
        setName("Design");
    }

    // Attributes
    public static final AttributeDesign name = addAttribute(ENTITY, "name", DataCategoryDesign.text);
    public static final AttributeDesign javaIdentifier = addAttribute(ENTITY, "javaIdentifier", DataCategoryDesign.text);
    public static final AttributeDesign technicalName = addAttribute(ENTITY, "technicalName", DataCategoryDesign.text);
    public static final AttributeDesign isCustomized = addAttribute(ENTITY, "isCustomized", DataCategoryDesign._boolean);

    // Relations

    @Override
    public void init() {
    	super.init();
    	
    	name.newDefault().deduceCustom(DesignerApplicationGenerator.DefaultDesignNameDeduction);
    	
    	DeductionSchemeDesign nameDeduction;
		newTitle().addToUntranslated(new StringTemplateDesign().setDeduction(nameDeduction = new DeductionSchemeDesign()));
		nameDeduction.deduceAttribute(name);
    	
		javaIdentifier.setWriteable(false);
		javaIdentifier.newRule().deduceCustom(DesignerApplicationGenerator.JavaIdentifierDeduction);

		technicalName.setWriteable(false);
		technicalName.newRule().deduceCustom(DesignerApplicationGenerator.TechnicalNameDeduction);
    }
}