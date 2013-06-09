

package org.instantlogic.designer;



public class DeductionDesignEntityGenerator extends EntityDesign {

    public static final DeductionDesignEntityGenerator ENTITY = new DeductionDesignEntityGenerator();
    
    private DeductionDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("DeductionDesign");
        setIsCustomized(true);
    }

    // Relations
    public static final RelationDesign operation = addRelation(ENTITY, "operation", RelationType.ManyToZeroOrOne, DeductionOperationDesignEntityGenerator.ENTITY);

    public static final RelationDesign dataType = addRelation(ENTITY, "dataType", RelationType.ManyToZeroOrOne, DataTypeDesignEntityGenerator.ENTITY);
    
    public static final RelationDesign inputs = addRelation(ENTITY, "inputs", RelationType.OneToManyAggregation, DeductionInputDesignEntityGenerator.ENTITY)
    	.setReverseName("deduction");

    public static final RelationDesign parameters = addRelation(ENTITY, "parameters", RelationType.OneToManyAggregation, DeductionParameterDesignEntityGenerator.ENTITY)
        	.setReverseName("deduction");

    @Override
    public void init() {
    }
}