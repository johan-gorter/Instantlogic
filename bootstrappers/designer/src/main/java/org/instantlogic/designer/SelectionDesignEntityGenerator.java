

package org.instantlogic.designer;



public class SelectionDesignEntityGenerator extends EntityDesign {

    public static final SelectionDesignEntityGenerator ENTITY = new SelectionDesignEntityGenerator();
    
    private SelectionDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("SelectionDesign");
        setExtendsFrom(ElementDesignEntityGenerator.ENTITY);
    }

    // Relations
    public static final RelationDesign selection = addRelation(ENTITY, "selection", RelationType.OneToOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY)
    		.setReverseName("selectionElement");
    
    public static final RelationDesign child = addRelation(ENTITY, "child", RelationType.OneToZeroOrOneAggregation, ElementDesignEntityGenerator.ENTITY)
            .setReverseName("childOfSelection");
    
}