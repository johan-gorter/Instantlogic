package org.instantlogic.designer;



public class IfElseDesignEntityGenerator extends EntityDesign {

    public static final IfElseDesignEntityGenerator ENTITY = new IfElseDesignEntityGenerator();
    
    private IfElseDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("IfElseDesign");
        setExtendsFrom(ElementDesignEntityGenerator.ENTITY);
    }

    // Relations
    public static final RelationDesign condition = addRelation(ENTITY, "condition", RelationType.OneToOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY);
    
    public static final RelationDesign ifChild = addRelation(ENTITY, "ifChild", RelationType.OneToZeroOrOneAggregation, ElementDesignEntityGenerator.ENTITY);    

    public static final RelationDesign elseChild = addRelation(ENTITY, "elseChild", RelationType.OneToZeroOrOneAggregation, ElementDesignEntityGenerator.ENTITY);    
}