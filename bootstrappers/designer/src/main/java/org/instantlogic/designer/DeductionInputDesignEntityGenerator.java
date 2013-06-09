

package org.instantlogic.designer;



public class DeductionInputDesignEntityGenerator extends EntityDesign {

    public static final DeductionInputDesignEntityGenerator ENTITY = new DeductionInputDesignEntityGenerator();
    
    private DeductionInputDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("DeductionInputDesign");
    }

    // Relations
    public static final RelationDesign operationInput = addRelation(ENTITY, "operationInput", RelationType.ManyToZeroOrOne, DeductionOperationInputDesignEntityGenerator.ENTITY);

    public static final RelationDesign inputs = addRelation(ENTITY, "inputs", RelationType.ManyToMany, DeductionDesignEntityGenerator.ENTITY)
    	.setReverseName("outputs");
}