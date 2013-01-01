package org.instantlogic.designer;

import org.instantlogic.designer.deduction.DeductionDataTypeDeduction;


public class DeductionDesignEntityGenerator extends EntityDesign {

    public static final DeductionDesignEntityGenerator ENTITY = new DeductionDesignEntityGenerator();
    
    private DeductionDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("DeductionDesign");
        setIsCustomized(true);
    }

    // Relations
    public static final RelationDesign dataType = addRelation(ENTITY, "dataType", RelationType.ManyToZeroOrOne, DataTypeDesignEntityGenerator.ENTITY);
    
    public static final RelationDesign inputs = addRelation(ENTITY, "inputs", RelationType.ManyToMany, DeductionDesignEntityGenerator.ENTITY)
    	.setReverseName("outputs");
    
    @Override
    public void init() {
    	dataType.setWriteable(false);
    	dataType.setRule(new DeductionSchemeDesign().deduceCustom(DeductionDataTypeDeduction.class, DataTypeDesign.class).getScheme());
    }
}