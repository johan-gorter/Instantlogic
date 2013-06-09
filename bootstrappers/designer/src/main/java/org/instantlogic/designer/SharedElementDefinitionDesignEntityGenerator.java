

package org.instantlogic.designer;


public class SharedElementDefinitionDesignEntityGenerator extends EntityDesign {

    public static final SharedElementDefinitionDesignEntityGenerator ENTITY = new SharedElementDefinitionDesignEntityGenerator();
    
    private SharedElementDefinitionDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("SharedElementDefinitionDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
        setIsCustomized(true);
    }

    // Attributes

    // Relations
    public static final RelationDesign fragment = addRelation(ENTITY, "fragment", RelationType.OneToZeroOrOneAggregation, ElementDesignEntityGenerator.ENTITY)
            .setReverseName("partOfSharedElementDefinition");

}