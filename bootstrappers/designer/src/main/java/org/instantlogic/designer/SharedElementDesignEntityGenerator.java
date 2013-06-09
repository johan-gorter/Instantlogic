package org.instantlogic.designer;


public class SharedElementDesignEntityGenerator extends EntityDesign {

    public static final SharedElementDesignEntityGenerator ENTITY = new SharedElementDesignEntityGenerator();
    
    private SharedElementDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("SharedElementDesign");
        setExtendsFrom(ElementDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public static final RelationDesign definition = addRelation(ENTITY, "definition", RelationType.ManyToZeroOrOne, SharedElementDefinitionDesignEntityGenerator.ENTITY)
            .setReverseName("usages");

}