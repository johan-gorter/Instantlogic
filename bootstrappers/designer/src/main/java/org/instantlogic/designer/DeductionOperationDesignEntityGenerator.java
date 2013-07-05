package org.instantlogic.designer;


public class DeductionOperationDesignEntityGenerator extends EntityDesign {

    public static final DeductionOperationDesignEntityGenerator ENTITY = new DeductionOperationDesignEntityGenerator();
    
    private DeductionOperationDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("DeductionOperationDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }
    
    // Attributes
    public static final AttributeDesign javaClassName = addAttribute(ENTITY, "javaClassName", DataCategoryDesign.text);

    // Relations
    public static final RelationDesign outputDataType = addRelation(ENTITY, "outputDataType", RelationType.ManyToZeroOrOne, DataTypeDesignEntityGenerator.ENTITY);
    
    public static final RelationDesign inputs = addRelation(ENTITY, "inputs", RelationType.OneToManyAggregation, DeductionOperationInputDesignEntityGenerator.ENTITY)
        	.setReverseName("operation");
    public static final RelationDesign parameters = addRelation(ENTITY, "parameters", RelationType.OneToManyAggregation, DeductionOperationParameterDesignEntityGenerator.ENTITY)
        	.setReverseName("operation");
    
    // Static instances
    public static final StaticInstanceDesign attribute = addStaticInstance(ENTITY, "attribute", createConstantText("Attribute"));
    public static final StaticInstanceDesign cast = addStaticInstance(ENTITY, "cast", createConstantText("Cast"));
    public static final StaticInstanceDesign constant = addStaticInstance(ENTITY, "constant", createConstantText("Constant"));
    public static final StaticInstanceDesign custom = addStaticInstance(ENTITY, "custom", createConstantText("Custom"));
    public static final StaticInstanceDesign equals = addStaticInstance(ENTITY, "equals", createConstantText("Equals"));
    public static final StaticInstanceDesign first = addStaticInstance(ENTITY, "first", createConstantText("First"));
    public static final StaticInstanceDesign hasValue = addStaticInstance(ENTITY, "hasValue", createConstantText("Has value"));
    public static final StaticInstanceDesign id = addStaticInstance(ENTITY, "id", createConstantText("Id"));
    public static final StaticInstanceDesign negation = addStaticInstance(ENTITY, "negation", createConstantText("Negation"));
    public static final StaticInstanceDesign reverseRelation = addStaticInstance(ENTITY, "reverseRelation", createConstantText("Reverse relation"));
    public static final StaticInstanceDesign selectedInstance = addStaticInstance(ENTITY, "selectedInstance", createConstantText("Selected instance"));
    public static final StaticInstanceDesign sum = addStaticInstance(ENTITY, "sum", createConstantText("Sum"));
    		
    @Override
    public void init() {
        // static instance relation values
    	addStaticInstanceValue(attribute, javaClassName, "org.instantlogic.fabric.deduction.AttributeDeduction");
    	addStaticInstanceValue(attribute, DesignEntityGenerator.name, "attribute");
    	addStaticInstanceRelationValue(attribute, inputs, DeductionOperationInputDesignEntityGenerator.attributeInstance);
    	addStaticInstanceRelationValue(attribute, parameters, DeductionOperationParameterDesignEntityGenerator.attribute);

    	addStaticInstanceValue(cast, javaClassName, "org.instantlogic.fabric.deduction.CastInstanceDeduction");
    	addStaticInstanceValue(cast, DesignEntityGenerator.name, "cast");
    	addStaticInstanceRelationValue(cast, inputs, DeductionOperationInputDesignEntityGenerator.castInstance);
    	addStaticInstanceRelationValue(cast, parameters, DeductionOperationParameterDesignEntityGenerator.castToEntity);
    	
    	addStaticInstanceValue(constant, javaClassName, "org.instantlogic.fabric.deduction.ConstantDeduction");
    	addStaticInstanceValue(constant, DesignEntityGenerator.name, "constant");
    	addStaticInstanceRelationValue(constant, parameters, DeductionOperationParameterDesignEntityGenerator.constantValue);
    	
    	addStaticInstanceValue(custom, javaClassName, "org.instantlogic.fabric.deduction.CustomDeduction");
    	addStaticInstanceValue(custom, DesignEntityGenerator.name, "custom");
    	
    	addStaticInstanceValue(equals, javaClassName, "org.instantlogic.fabric.deduction.EqualsDeduction");
    	addStaticInstanceValue(equals, DesignEntityGenerator.name, "equals");
    	addStaticInstanceRelationValue(equals, inputs, DeductionOperationInputDesignEntityGenerator.equalsOperands);
    	
    	addStaticInstanceValue(hasValue, javaClassName, "org.instantlogic.fabric.deduction.HasValueDeduction");
    	addStaticInstanceValue(hasValue, DesignEntityGenerator.name, "hasValue");
    	addStaticInstanceRelationValue(hasValue, inputs, DeductionOperationInputDesignEntityGenerator.hasValueInput);
    	
    	addStaticInstanceValue(id, javaClassName, "org.instantlogic.fabric.deduction.IdDeduction");
    	addStaticInstanceValue(id, DesignEntityGenerator.name, "id");
    	addStaticInstanceRelationValue(id, inputs, DeductionOperationInputDesignEntityGenerator.idOfInstance);
    	
    	addStaticInstanceValue(negation, javaClassName, "org.instantlogic.fabric.deduction.NegationDeduction");
    	addStaticInstanceValue(negation, DesignEntityGenerator.name, "negation");
    	addStaticInstanceRelationValue(negation, inputs, DeductionOperationInputDesignEntityGenerator.negationInput);
    	
    	addStaticInstanceValue(reverseRelation, javaClassName, "org.instantlogic.fabric.deduction.ReverseRelationDeduction");
    	addStaticInstanceValue(reverseRelation, DesignEntityGenerator.name, "reverseRelation");
    	addStaticInstanceRelationValue(reverseRelation, inputs, DeductionOperationInputDesignEntityGenerator.reverseRelationToInstance);
    	
    	addStaticInstanceValue(selectedInstance, javaClassName, "org.instantlogic.fabric.deduction.SelectedInstanceDeduction");
    	addStaticInstanceValue(selectedInstance, DesignEntityGenerator.name, "selectedInstance");
    	addStaticInstanceRelationValue(selectedInstance, parameters, DeductionOperationParameterDesignEntityGenerator.selectedInstanceEntity);

    	addStaticInstanceValue(sum, javaClassName, "org.instantlogic.fabric.deduction.SumDeduction");
    	addStaticInstanceValue(sum, DesignEntityGenerator.name, "sum");
    	addStaticInstanceRelationValue(sum, inputs, DeductionOperationInputDesignEntityGenerator.sumOperands);
    }
}