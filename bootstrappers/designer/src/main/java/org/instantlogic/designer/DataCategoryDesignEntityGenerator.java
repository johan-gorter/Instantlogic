

package org.instantlogic.designer;


public class DataCategoryDesignEntityGenerator extends EntityDesign {

    public static final DataCategoryDesignEntityGenerator ENTITY = new DataCategoryDesignEntityGenerator();
    
    public static StaticInstanceDesign text = addStaticInstance(ENTITY, "text", createConstantText("Text"));
    public static StaticInstanceDesign number = addStaticInstance(ENTITY, "number", createConstantText("Number"));
    public static StaticInstanceDesign dateTime = addStaticInstance(ENTITY, "dateTime", createConstantText("Date/Time"));
    public static StaticInstanceDesign _boolean = addStaticInstance(ENTITY, "boolean", createConstantText("Yes-No"));
    public static StaticInstanceDesign entity = addStaticInstance(ENTITY, "entity", createConstantText("Entity"));
    public static StaticInstanceDesign custom = addStaticInstance(ENTITY, "custom", createConstantText("Custom"));
    
    private DataCategoryDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("DataCategoryDesign");
    }
}
