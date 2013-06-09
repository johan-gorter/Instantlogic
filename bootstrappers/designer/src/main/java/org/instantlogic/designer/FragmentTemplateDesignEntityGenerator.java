

package org.instantlogic.designer;


public class FragmentTemplateDesignEntityGenerator extends EntityDesign {

    public static final FragmentTemplateDesignEntityGenerator ENTITY = new FragmentTemplateDesignEntityGenerator();
    
    private FragmentTemplateDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("FragmentTemplateDesign");
        setExtendsFrom(ElementDesignEntityGenerator.ENTITY);
        setIsCustomized(true);
    }

    // Attributes
    public static final AttributeDesign fragmentTypeName = addAttribute(ENTITY, "fragmentTypeName", java.lang.String.class); // To be replaced by 'type'
    public static final AttributeDesign styleNames = addAttribute(ENTITY, "styleNames", java.lang.String.class);
    public static final AttributeDesign fragmentFilters = addAttribute(ENTITY, "fragmentFilters", java.lang.String.class);

    // Relations
    public static final RelationDesign type = addRelation(ENTITY, "type", RelationType.ManyToZeroOrOne, FragmentTypeDesignEntityGenerator.ENTITY)
    		.setReverseName("usages");
    public static final RelationDesign attribute = addRelation(ENTITY, "attribute", RelationType.ManyToZeroOrOne, AttributeDesignEntityGenerator.ENTITY);
    public static final RelationDesign entity = addRelation(ENTITY, "entity", RelationType.ManyToZeroOrOne, EntityDesignEntityGenerator.ENTITY);
    public static final RelationDesign event = addRelation(ENTITY, "event", RelationType.ManyToZeroOrOne, EventDesignEntityGenerator.ENTITY);
    public static final RelationDesign properties = addRelation(ENTITY, "properties", RelationType.OneToManyAggregation, PropertyDesignEntityGenerator.ENTITY)
            .setReverseName("fragment");
    
    @Override
    public void init() {
    	styleNames.getDataType().setMultivalue(true);
    	fragmentFilters.getDataType().setMultivalue(true);
    	type.newOptions().deduceRelation(ApplicationDesignEntityGenerator.fragmentTypes);
    	entity.newOptions().deduceRelation(ApplicationDesignEntityGenerator.entities);
    	attribute.newOptions().deduceRelation(EntityDesignEntityGenerator.attributes, attribute.getOptions().deduceRelation(entity)); //TODO: Union relations
    }
}