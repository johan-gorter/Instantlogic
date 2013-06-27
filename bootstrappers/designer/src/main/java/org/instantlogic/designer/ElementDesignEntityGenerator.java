package org.instantlogic.designer;


public class ElementDesignEntityGenerator extends EntityDesign {

    public static final ElementDesignEntityGenerator ENTITY = new ElementDesignEntityGenerator();
    
    // Attributes
    public static final AttributeDesign editorOpen = addAttribute(ENTITY, "editorOpen", DataCategoryDesign._boolean);
    public static final AttributeDesign previewMode = addAttribute(ENTITY, "previewMode", DataCategoryDesign.text); // mobile/tablet/desktop. Does not affect code generation
    
    private ElementDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("ElementDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }
    
    @Override
    public void init() {
    	editorOpen.newDefault().deduceConstant(Boolean.class, Boolean.FALSE);
    	previewMode.newDefault().deduceConstant(String.class, "mobile");
    }
}