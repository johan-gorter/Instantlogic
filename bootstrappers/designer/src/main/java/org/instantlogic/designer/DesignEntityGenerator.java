package org.instantlogic.designer;



public class DesignEntityGenerator extends EntityDesign {

    public static final DesignEntityGenerator ENTITY = new DesignEntityGenerator();
    
    private DesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
    	setIsCustomized(true);
        setName("Design");
    }

    // Attributes
    public static final AttributeDesign name = addAttribute(ENTITY, "name", java.lang.String.class);
    public static final AttributeDesign javaIdentifier = addAttribute(ENTITY, "javaIdentifier", java.lang.String.class);
    public static final AttributeDesign technicalName = addAttribute(ENTITY, "technicalName", java.lang.String.class);
    public static final AttributeDesign isCustomized = addAttribute(ENTITY, "isCustomized", java.lang.Boolean.class);

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