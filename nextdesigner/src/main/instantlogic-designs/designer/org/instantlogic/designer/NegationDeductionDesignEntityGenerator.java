package org.instantlogic.designer;


public class NegationDeductionDesignEntityGenerator extends EntityDesign {

    public static final NegationDeductionDesignEntityGenerator ENTITY = new NegationDeductionDesignEntityGenerator();
    
    private NegationDeductionDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("NegationDeductionDesign");
        setExtendsFrom(DeductionDesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations

}