package org.instantlogic.designer;


public class DeductionOperationParameterDesignEntityGenerator extends EntityDesign {

    public static final DeductionOperationParameterDesignEntityGenerator ENTITY = new DeductionOperationParameterDesignEntityGenerator();
    
    private DeductionOperationParameterDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("DeductionOperationParameterDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Static instances
    public static final StaticInstanceDesign attribute = addStaticInstance(ENTITY, "attribute", createConstantText("Attribute"));
    public static final StaticInstanceDesign castToEntity = addStaticInstance(ENTITY, "castToEntity", createConstantText("To entity"));
    public static final StaticInstanceDesign constantValue = addStaticInstance(ENTITY, "constantValue", createConstantText("Value"));
    public static final StaticInstanceDesign selectedInstanceEntity = addStaticInstance(ENTITY, "selectedInstanceEntity", createConstantText("Of entity"));
    public static final StaticInstanceDesign reverseRelationRelation = addStaticInstance(ENTITY, "reverseRelationRelation", createConstantText("Relation"));
    
    @Override
    public void init() {
    	addStaticInstanceValue(attribute, DesignEntityGenerator.name, "attribute");
    	addStaticInstanceValue(castToEntity, DesignEntityGenerator.name, "toEntity");
    	addStaticInstanceValue(constantValue, DesignEntityGenerator.name, "value");
    	addStaticInstanceValue(selectedInstanceEntity, DesignEntityGenerator.name, "ofEntity");
    	addStaticInstanceValue(reverseRelationRelation, DesignEntityGenerator.name, "relation");
    }
}