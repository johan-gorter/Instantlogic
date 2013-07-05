package org.instantlogic.designer;


public class DeductionSchemeDesignEntityGenerator extends EntityDesign {

    public static final DeductionSchemeDesignEntityGenerator ENTITY = new DeductionSchemeDesignEntityGenerator();
    
    private DeductionSchemeDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("DeductionSchemeDesign");
        setIsCustomized(true);
    }

    // Attributes

    // Relations
    public static final RelationDesign deductions = addRelation(ENTITY, "deductions", RelationType.OneToManyAggregation, DeductionDesignEntityGenerator.ENTITY)
            .setReverseName("scheme");
    public static final RelationDesign output = addRelation(ENTITY, "output", RelationType.OneToZeroOrOne, DeductionDesignEntityGenerator.ENTITY)
    		.setReverseName("outputOfScheme");

}