package org.instantlogic.designer;


public class HasValueDeductionDesignEntityGenerator extends EntityDesign {

    public static final HasValueDeductionDesignEntityGenerator ENTITY = new HasValueDeductionDesignEntityGenerator();
    
    private HasValueDeductionDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("HasValueDeductionDesign");
        setExtendsFrom(DeductionDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
}