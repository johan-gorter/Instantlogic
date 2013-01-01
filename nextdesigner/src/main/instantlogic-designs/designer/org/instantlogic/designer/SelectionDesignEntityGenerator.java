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
    
    public static final RelationDesign children = addRelation(ENTITY, "children", RelationType.OneToManyAggregation, ElementDesignEntityGenerator.ENTITY)
            .setReverseName("childOfSelection"); //TODO: Single value for making it easier to get animations right (and no collapsing needed in the designer)
    
}