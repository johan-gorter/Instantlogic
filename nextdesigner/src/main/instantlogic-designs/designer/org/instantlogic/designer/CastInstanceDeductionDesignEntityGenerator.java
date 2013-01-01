package org.instantlogic.designer;


public class CastInstanceDeductionDesignEntityGenerator extends EntityDesign {

    public static final CastInstanceDeductionDesignEntityGenerator ENTITY = new CastInstanceDeductionDesignEntityGenerator();
    
    private CastInstanceDeductionDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("CastInstanceDeductionDesign");
        setExtendsFrom(DeductionDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public static final RelationDesign toEntity = addRelation(ENTITY, "toEntity", RelationType.ManyToZeroOrOne, EntityDesignEntityGenerator.ENTITY);

}