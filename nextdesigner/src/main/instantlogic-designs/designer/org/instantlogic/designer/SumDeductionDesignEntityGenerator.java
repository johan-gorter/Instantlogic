package org.instantlogic.designer;


public class SumDeductionDesignEntityGenerator extends EntityDesign {

    public static final SumDeductionDesignEntityGenerator ENTITY = new SumDeductionDesignEntityGenerator();
    
    private SumDeductionDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("SumDeductionDesign");
        setExtendsFrom(DeductionDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations

}