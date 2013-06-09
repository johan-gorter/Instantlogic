package org.instantlogic.designer;


public class FlowNodeBaseDesignEntityGenerator extends EntityDesign {

    public static final FlowNodeBaseDesignEntityGenerator ENTITY = new FlowNodeBaseDesignEntityGenerator();
    
    private FlowNodeBaseDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("FlowNodeBaseDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations

}