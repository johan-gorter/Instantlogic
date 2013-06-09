package org.instantlogic.designer;



public class ApplicationDesignEntityGenerator extends EntityDesign {

    public static final ApplicationDesignEntityGenerator ENTITY = new ApplicationDesignEntityGenerator();
    
    private ApplicationDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("ApplicationDesign");
        setIsCustomized(true);
    }

    // Attributes
    public static final AttributeDesign name = addAttribute(ENTITY, "name", java.lang.String.class);
    public static final AttributeDesign rootPackageName = addAttribute(ENTITY, "rootPackageName", java.lang.String.class);
    public static final AttributeDesign sourcePath = addAttribute(ENTITY, "sourcePath", java.lang.String.class);
    public static final AttributeDesign isCustomized = addAttribute(ENTITY, "isCustomized", java.lang.Boolean.class);
    public static final AttributeDesign themeNames = addAttribute(ENTITY, "themeNames", java.lang.String.class);

    // Relations
    public static final RelationDesign entities = addRelation(ENTITY, "entities", RelationType.OneToManyAggregation, EntityDesignEntityGenerator.ENTITY)
            .setReverseName("application");
    public static final RelationDesign caseEntity = addRelation(ENTITY, "caseEntity", RelationType.OneToZeroOrOne, EntityDesignEntityGenerator.ENTITY);

    public static final RelationDesign customDeductionOperations = addRelation(ENTITY, "customDeductionOperations", RelationType.OneToManyAggregation, DeductionOperationDesignEntityGenerator.ENTITY);
    
    public static final RelationDesign flows = addRelation(ENTITY, "flows", RelationType.OneToManyAggregation, FlowDesignEntityGenerator.ENTITY)
            .setReverseName("application");
    public static final RelationDesign events = addRelation(ENTITY, "events", RelationType.OneToManyAggregation, EventDesignEntityGenerator.ENTITY)
            .setReverseName("application");
    public static final RelationDesign fragmentTypes = addRelation(ENTITY, "fragmentTypes", RelationType.OneToManyAggregation, FragmentTypeDesignEntityGenerator.ENTITY)
            .setReverseName("application");
    public static final RelationDesign mainFlow = addRelation(ENTITY, "mainFlow", RelationType.OneToZeroOrOne, FlowDesignEntityGenerator.ENTITY);
    public static final RelationDesign startEvent = addRelation(ENTITY, "startEvent", RelationType.OneToZeroOrOne, EventDesignEntityGenerator.ENTITY);
    public static final RelationDesign sharedElements = addRelation(ENTITY, "sharedElements", RelationType.OneToManyAggregation, SharedElementDefinitionDesignEntityGenerator.ENTITY)
            .setReverseName("application");
    
    @Override
    public void init() {
    	themeNames.getDataType().setMultivalue(true);
    }
}