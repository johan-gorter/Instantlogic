package org.instantlogic.designer;


public class DeductionOperationInputDesignEntityGenerator extends EntityDesign {

    public static final DeductionOperationInputDesignEntityGenerator ENTITY = new DeductionOperationInputDesignEntityGenerator();
    
    private DeductionOperationInputDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("DeductionOperationInputDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes
    public static final AttributeDesign multivalue = addAttribute(ENTITY, "multivalue", java.lang.Boolean.class);
    
    // Relations
    public static final RelationDesign dataType = addRelation(ENTITY, "dataType", RelationType.ManyToZeroOrOne, DataTypeDesignEntityGenerator.ENTITY);
    
    // Static instances
    public static final StaticInstanceDesign attributeInstance = addStaticInstance(ENTITY, "attributeInstance", createConstantText("Instance"));

    @Override
    public void init() {
    	// TODO: Rule for multivalue, only for static instances
    	// TODO: Rule for dataType, only for static instances
    	// static instances

    	// Attribute
    	
    	// Cast
    	addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Instance")).setName("castInstance"));
    	// Equals
    	addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Operands")).setName("equalsOperands"));
    	// HasValue
    	addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Input")).setName("hasValueInput"));
    	// Negation
    	addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Input")).setName("negationInput"));
    	// Reverse relation
    	addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("To instance")).setName("reverseRelationToInstance"));
    	// Sum
    	addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Operands")).setName("sumOperands"));
    }
    
}