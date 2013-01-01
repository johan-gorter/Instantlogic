package org.instantlogic.designer;


public class EqualsDeductionDesignEntityGenerator extends EntityDesign {

    public static final EqualsDeductionDesignEntityGenerator ENTITY = new EqualsDeductionDesignEntityGenerator();
    
    private EqualsDeductionDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("EqualsDeductionDesign");
        setExtendsFrom(DeductionDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
}