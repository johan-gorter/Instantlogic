

package org.instantlogic.designer;


public class FlowDesignEntityGenerator extends EntityDesign {

    public static final FlowDesignEntityGenerator ENTITY = new FlowDesignEntityGenerator();
    
    private FlowDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("FlowDesign");
        setIsCustomized(true);
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public static final RelationDesign nodes = addRelation(ENTITY, "nodes", RelationType.OneToManyAggregation, FlowNodeBaseDesignEntityGenerator.ENTITY)
            .setReverseName("owner");
    public static final RelationDesign edges = addRelation(ENTITY, "edges", RelationType.OneToManyAggregation, FlowEdgeDesignEntityGenerator.ENTITY)
            .setReverseName("owner");
    public static final RelationDesign parameters = addRelation(ENTITY, "parameters", RelationType.ManyToMany, EntityDesignEntityGenerator.ENTITY);

}