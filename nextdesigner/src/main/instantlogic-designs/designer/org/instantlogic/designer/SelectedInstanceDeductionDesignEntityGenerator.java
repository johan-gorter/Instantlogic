package org.instantlogic.designer;


public class SelectedInstanceDeductionDesignEntityGenerator extends EntityDesign {

    public static final SelectedInstanceDeductionDesignEntityGenerator ENTITY = new SelectedInstanceDeductionDesignEntityGenerator();
    
    private SelectedInstanceDeductionDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("SelectedInstanceDeductionDesign");
        setExtendsFrom(DeductionDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public static final RelationDesign ofEntity = addRelation(ENTITY, "ofEntity", RelationType.ManyToZeroOrOne, EntityDesignEntityGenerator.ENTITY);

}