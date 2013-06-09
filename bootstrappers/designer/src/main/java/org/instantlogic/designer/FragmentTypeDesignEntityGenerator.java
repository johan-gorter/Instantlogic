

package org.instantlogic.designer;


public class FragmentTypeDesignEntityGenerator extends EntityDesign {

    public static final FragmentTypeDesignEntityGenerator ENTITY = new FragmentTypeDesignEntityGenerator();
    
    private FragmentTypeDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("FragmentTypeDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes
    public static final AttributeDesign fragmentFilters = addAttribute(ENTITY, "fragmentFilters", DataCategoryDesign.text);
    public static final AttributeDesign hasAttribute = addAttribute(ENTITY, "hasAttribute", DataCategoryDesign._boolean);
    public static final AttributeDesign hasEvent = addAttribute(ENTITY, "hasEvent", DataCategoryDesign._boolean);

    // Relations
    //TODO: Property definitions
    
    @Override
    public void init() {
    	fragmentFilters.getDataType().setMultivalue(true);
    	hasAttribute.newDefault().deduceConstant(Boolean.class, false);
    	hasEvent.newDefault().deduceConstant(Boolean.class, false);
    }
}