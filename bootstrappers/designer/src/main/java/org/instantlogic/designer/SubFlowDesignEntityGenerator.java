

package org.instantlogic.designer;


public class SubFlowDesignEntityGenerator extends EntityDesign {

    public static final SubFlowDesignEntityGenerator ENTITY = new SubFlowDesignEntityGenerator();
    
    private SubFlowDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("SubFlowDesign");
        setExtendsFrom(FlowNodeBaseDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public static final RelationDesign flow = addRelation(ENTITY, "flow", RelationType.OneToZeroOrOne, FlowDesignEntityGenerator.ENTITY)
            .setReverseName("subFlowIn");

}