package org.instantlogic.designer;


public class EventDesignEntityGenerator extends EntityDesign {

    public static final EventDesignEntityGenerator ENTITY = new EventDesignEntityGenerator();
    
    private EventDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("EventDesign");
        setIsCustomized(true);
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public static final RelationDesign parameters = addRelation(ENTITY, "parameters", RelationType.ManyToMany, EntityDesignEntityGenerator.ENTITY);

}