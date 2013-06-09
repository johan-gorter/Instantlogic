

package org.instantlogic.designer;



public class DeductionParameterDesignEntityGenerator extends EntityDesign {

    public static final DeductionParameterDesignEntityGenerator ENTITY = new DeductionParameterDesignEntityGenerator();
    
    private DeductionParameterDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("DeductionParameterDesign");
    }
    
    // Attributes
    public static final AttributeDesign value = addAttribute(ENTITY, "value", Object.class);

    // Relations
    public static final RelationDesign operationParameter = addRelation(ENTITY, "operationParameter", RelationType.ManyToZeroOrOne, DeductionOperationParameterDesignEntityGenerator.ENTITY);

    // Relations
    public static final RelationDesign entityValue = addRelation(ENTITY, "entityValue", RelationType.ManyToZeroOrOne, EntityDesignEntityGenerator.ENTITY);
    public static final RelationDesign attributeValue = addRelation(ENTITY, "attributeValue", RelationType.ManyToZeroOrOne, AttributeDesignEntityGenerator.ENTITY);
    public static final RelationDesign staticInstanceValue = addRelation(ENTITY, "staticInstanceValue", RelationType.ManyToZeroOrOne, StaticInstanceDesignEntityGenerator.ENTITY);
}