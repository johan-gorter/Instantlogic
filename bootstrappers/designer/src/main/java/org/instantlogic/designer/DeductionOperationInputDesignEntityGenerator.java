package org.instantlogic.designer;


public class DeductionOperationInputDesignEntityGenerator extends EntityDesign {

    public static final DeductionOperationInputDesignEntityGenerator ENTITY = new DeductionOperationInputDesignEntityGenerator();
    
    private DeductionOperationInputDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("DeductionOperationInputDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes
    public static final AttributeDesign multivalue = addAttribute(ENTITY, "multivalue", DataCategoryDesign._boolean);
    
    // Relations
    public static final RelationDesign dataType = addRelation(ENTITY, "dataType", RelationType.ManyToZeroOrOne, DataTypeDesignEntityGenerator.ENTITY);
    
    // Static instances
    public static final StaticInstanceDesign attributeInstance = addStaticInstance(ENTITY, "attributeInstance", createConstantText("Instance"));
    public static final StaticInstanceDesign castInstance = addStaticInstance(ENTITY, "castInstance", createConstantText("Instance"));
    public static final StaticInstanceDesign equalsOperands = addStaticInstance(ENTITY, "equalsOperands", createConstantText("Operands"));
    public static final StaticInstanceDesign hasValueInput = addStaticInstance(ENTITY, "hasValueInput", createConstantText("Input"));
    public static final StaticInstanceDesign idOfInstance = addStaticInstance(ENTITY, "idOfInstance", createConstantText("Id of instance"));
    public static final StaticInstanceDesign titleOfInstance = addStaticInstance(ENTITY, "titleOfInstance", createConstantText("Title of instance"));
    public static final StaticInstanceDesign negationInput = addStaticInstance(ENTITY, "negationInput", createConstantText("Input"));
    public static final StaticInstanceDesign reverseRelationToInstance = addStaticInstance(ENTITY, "reverseRelationToInstance", createConstantText("To instance"));
    public static final StaticInstanceDesign sumOperands = addStaticInstance(ENTITY, "sumOperands", createConstantText("Operands"));

    @Override
    public void init() {
    	multivalue.newDefault().deduceConstant(Boolean.class, false);
    	
    	addStaticInstanceValue(attributeInstance, DesignEntityGenerator.name, "instance");
    	addStaticInstanceValue(castInstance, DesignEntityGenerator.name, "instance");
    	addStaticInstanceValue(equalsOperands, DesignEntityGenerator.name, "operands");
    	addStaticInstanceValue(hasValueInput, DesignEntityGenerator.name, "input");
    	addStaticInstanceValue(idOfInstance, DesignEntityGenerator.name, "idOfInstance");
    	addStaticInstanceValue(titleOfInstance, DesignEntityGenerator.name, "titleOfInstance");
    	addStaticInstanceValue(negationInput, DesignEntityGenerator.name, "input");
    	addStaticInstanceValue(reverseRelationToInstance, DesignEntityGenerator.name, "toInstance");
    	addStaticInstanceValue(sumOperands, DesignEntityGenerator.name, "operands");
    	
    	addStaticInstanceValue(equalsOperands, multivalue, true);
    	addStaticInstanceValue(sumOperands, multivalue, true);
    }
    
}