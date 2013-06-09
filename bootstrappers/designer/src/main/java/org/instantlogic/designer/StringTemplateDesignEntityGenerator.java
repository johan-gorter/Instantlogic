package org.instantlogic.designer;


public class StringTemplateDesignEntityGenerator extends EntityDesign {

    public static final StringTemplateDesignEntityGenerator ENTITY = new StringTemplateDesignEntityGenerator();
    
    private StringTemplateDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("StringTemplateDesign");
    }

    // Attributes
    public static final AttributeDesign constantText = addAttribute(ENTITY, "constantText", java.lang.String.class);

    // Relations
    public static final RelationDesign deduction = addRelation(ENTITY, "deduction", RelationType.OneToOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY);

}