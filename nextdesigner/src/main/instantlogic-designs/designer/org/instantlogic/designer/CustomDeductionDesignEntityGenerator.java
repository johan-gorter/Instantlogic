package org.instantlogic.designer;


public class CustomDeductionDesignEntityGenerator extends EntityDesign {

    public static final CustomDeductionDesignEntityGenerator ENTITY = new CustomDeductionDesignEntityGenerator();
    
    private CustomDeductionDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setExtendsFrom(DeductionDesignEntityGenerator.ENTITY);
        setName("CustomDeductionDesign");
    }

    // Attributes
    public static final AttributeDesign implementationClassName = addAttribute(ENTITY, "implementationClassName", java.lang.String.class);

    // Relations
    public static final RelationDesign customDataType = addRelation(ENTITY, "customDataType", RelationType.OneToOneAggregation, DataTypeDesignEntityGenerator.ENTITY)
    		.setReverseName("customDeductionDesign");
}