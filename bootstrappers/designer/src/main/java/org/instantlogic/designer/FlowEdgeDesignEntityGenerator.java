

package org.instantlogic.designer;


public class FlowEdgeDesignEntityGenerator extends EntityDesign {

    public static final FlowEdgeDesignEntityGenerator ENTITY = new FlowEdgeDesignEntityGenerator();
    
    private FlowEdgeDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("FlowEdgeDesign");
    }

    // Attributes

    // Relations
    public static final RelationDesign startNode = addRelation(ENTITY, "startNode", RelationType.ManyToZeroOrOne, FlowNodeBaseDesignEntityGenerator.ENTITY)
            .setReverseName("outgoingEdges");
    public static final RelationDesign event = addRelation(ENTITY, "event", RelationType.ManyToZeroOrOne, EventDesignEntityGenerator.ENTITY);
    public static final RelationDesign endNode = addRelation(ENTITY, "endNode", RelationType.ManyToZeroOrOne, FlowNodeBaseDesignEntityGenerator.ENTITY)
            .setReverseName("incomingEdges");
}