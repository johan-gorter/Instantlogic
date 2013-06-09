package org.instantlogic.designer;



public class StaticInstanceDesignEntityGenerator extends EntityDesign {

    public static final StaticInstanceDesignEntityGenerator ENTITY = new StaticInstanceDesignEntityGenerator();
    
    private StaticInstanceDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("StaticInstanceDesign");
        setIsCustomized(true);
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public static final RelationDesign description = addRelation(ENTITY, "description", RelationType.OneToZeroOrOneAggregation, TextTemplateDesignEntityGenerator.ENTITY);
    
    public static final RelationDesign values = addRelation(ENTITY, "values", RelationType.OneToManyAggregation, StaticInstanceValueDesignEntityGenerator.ENTITY);
}