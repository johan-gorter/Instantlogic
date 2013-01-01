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
    
    public static final RelationDesign ifChildren = addRelation(ENTITY, "ifChildren", RelationType.OneToManyAggregation, ElementDesignEntityGenerator.ENTITY); //TODO: Single value for making it easier to get animations right    

    public static final RelationDesign elseChildren = addRelation(ENTITY, "elseChildren", RelationType.OneToManyAggregation, ElementDesignEntityGenerator.ENTITY); //TODO: Single value for making it easier to get animations right    
}