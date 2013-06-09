

package org.instantlogic.designer;


public class ValidationDesignEntityGenerator extends EntityDesign {

    public static final ValidationDesignEntityGenerator ENTITY = new ValidationDesignEntityGenerator();
    
    private ValidationDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("ValidationDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
        setIsCustomized(true);
    }

    // Attributes

    // Relations
    public static final RelationDesign message = addRelation(ENTITY, "message", RelationType.OneToZeroOrOneAggregation, TextTemplateDesignEntityGenerator.ENTITY)
            .setReverseName("messageOfValidation");
    // Should return boolean: true/null/inconclusive = valid, false is invalid
    public static final RelationDesign rule = addRelation(ENTITY, "rule", RelationType.OneToOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY)
    		.setReverseName("ruleForValidation");
    public static final RelationDesign displayWith = addRelation(ENTITY, "displayWith", RelationType.ManyToMany, AttributeDesignEntityGenerator.ENTITY)
            .setReverseName("validations");
}