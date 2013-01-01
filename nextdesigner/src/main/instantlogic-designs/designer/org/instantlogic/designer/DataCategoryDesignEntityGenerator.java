package org.instantlogic.designer;


public class DataCategoryDesignEntityGenerator extends EntityDesign {

    public static final DataCategoryDesignEntityGenerator ENTITY = new DataCategoryDesignEntityGenerator();
    
    private DataCategoryDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("DataCategoryDesign");
        addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Text")).setName("text"));
        addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Number")).setName("number"));
        addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Date/Time")).setName("dateTime"));
        addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Yes-No")).setName("boolean"));
        addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Entity")).setName("entity"));
        addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Custom")).setName("custom"));
    }
}
