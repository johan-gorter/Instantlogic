package org.instantlogic.designer;


public class DeductionOperationDesignEntityGenerator extends EntityDesign {

    public static final DeductionOperationDesignEntityGenerator ENTITY = new DeductionOperationDesignEntityGenerator();
    
    private DeductionOperationDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("DeductionOperationDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Relations
    public static final RelationDesign outputDataType = addRelation(ENTITY, "outputDataType", RelationType.ManyToZeroOrOne, DataTypeDesignEntityGenerator.ENTITY);
    
    public static final RelationDesign inputs = addRelation(ENTITY, "inputs", RelationType.OneToManyAggregation, DeductionOperationInputDesignEntityGenerator.ENTITY)
    	.setReverseName("operation");
    
    // Static instances
    public static final StaticInstanceDesign attribute = addStaticInstance(ENTITY, "attribute", createConstantText("Attribute"));
    		
    @Override
    public void init() {
// TODO:    	outputDataType.setDefault(new DeductionSchemeDesign().deduceCustom(DeductionDataTypeDeduction.class, DataTypeDesign.class).getScheme());
        // static instances

    	StaticInstanceValueDesign value = new StaticInstanceValueDesign();
    	attribute.addToValues(value);
    	value.setAttribute(inputs);
    	value.setRelationValue(DeductionOperationInputDesignEntityGenerator.attributeInstance);

 //    	addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Attribute")).setName("attribute"));
    	addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Cast")).setName("cast"));
    	addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Constant")).setName("constant"));
    	addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Custom")).setName("custom"));
    	addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Equals")).setName("equals"));
    	addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Has value")).setName("hasValue"));
    	addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Negation")).setName("negation"));
    	addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Reverse relation")).setName("reverseRelation"));
    	addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Selected instance")).setName("selectedInstance"));
    	addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Sum")).setName("sum"));
    }
}