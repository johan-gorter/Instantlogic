package org.instantlogic.designer;

public class PropertyDesignEntityGenerator extends EntityDesign {

    public static final PropertyDesignEntityGenerator ENTITY = new PropertyDesignEntityGenerator();
    
    private PropertyDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("PropertyDesign");
    }

    // Attributes
    public static final AttributeDesign propertyName = addAttribute(ENTITY, "propertyName", DataCategoryDesign.text);
    public static final AttributeDesign collapsed = addAttribute(ENTITY, "collapsed", DataCategoryDesign._boolean); // Used in the editor, does not affect code generation

    // Relations
    public static final RelationDesign children = addRelation(ENTITY, "children", RelationType.OneToManyAggregation, ElementDesignEntityGenerator.ENTITY).setReverseName("childrenForFragment");
    public static final RelationDesign text = addRelation(ENTITY, "text", RelationType.OneToZeroOrOneAggregation, TextTemplateDesignEntityGenerator.ENTITY);
    public static final RelationDesign value = addRelation(ENTITY, "value", RelationType.OneToZeroOrOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY);

    @Override
    public void init() {
    	super.init();
    	children.getDataType().setOrdered(true);
    	collapsed.newDefault().deduceConstant(Boolean.class, Boolean.TRUE);
    }
}