package org.instantlogic.designer;



public class TextTemplateDesignEntityGenerator extends EntityDesign {

    public static final TextTemplateDesignEntityGenerator ENTITY = new TextTemplateDesignEntityGenerator();
    
    private TextTemplateDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("TextTemplateDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public static final RelationDesign untranslated = addRelation(ENTITY, "untranslated", RelationType.OneToManyAggregation, StringTemplateDesignEntityGenerator.ENTITY)
            .setReverseName("untranslatedInTemplate");
    

}