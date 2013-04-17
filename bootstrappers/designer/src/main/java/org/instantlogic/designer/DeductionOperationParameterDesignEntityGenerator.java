package org.instantlogic.designer;


public class DeductionOperationParameterDesignEntityGenerator extends EntityDesign {

    public static final DeductionOperationParameterDesignEntityGenerator ENTITY = new DeductionOperationParameterDesignEntityGenerator();
    
    private DeductionOperationParameterDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("DeductionOperationParameterDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    public static final AttributeDesign valueClass = addAttribute(ENTITY, "valueClass", String.class);

    // Static instances
    public static final StaticInstanceDesign attribute = addStaticInstance(ENTITY, "attribute", createConstantText("Attribute"));
    public static final StaticInstanceDesign castToEntity = addStaticInstance(ENTITY, "castToEntity", createConstantText("To entity"));
    public static final StaticInstanceDesign constantValue = addStaticInstance(ENTITY, "constantValue", createConstantText("Value"));
    public static final StaticInstanceDesign selectedInstanceEntity = addStaticInstance(ENTITY, "selectedInstanceEntity", createConstantText("Of entity"));
    public static final StaticInstanceDesign reverseRelationRelation = addStaticInstance(ENTITY, "reverseRelationRelation", createConstantText("Relation"));
    
    @Override
    public void init() {
    	addStaticInstanceValue(attribute, DesignEntityGenerator.name, "attribute");
    	addStaticInstanceValue(attribute, valueClass, "org.instantlogic.fabric.model.Attribute");
    	addStaticInstanceValue(castToEntity, DesignEntityGenerator.name, "toEntity");
    	addStaticInstanceValue(castToEntity, valueClass, "org.instantlogic.fabric.model.Entity");
    	addStaticInstanceValue(constantValue, DesignEntityGenerator.name, "value");
    	addStaticInstanceValue(constantValue, valueClass, "java.lang.Object");
    	addStaticInstanceValue(selectedInstanceEntity, DesignEntityGenerator.name, "ofEntity");
    	addStaticInstanceValue(selectedInstanceEntity, valueClass, "org.instantlogic.fabric.model.Entity");
    	addStaticInstanceValue(reverseRelationRelation, DesignEntityGenerator.name, "relation");
    	addStaticInstanceValue(reverseRelationRelation, valueClass, "org.instantlogic.fabric.model.Relation");
    }
}