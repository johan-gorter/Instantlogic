package org.instantlogic.designer;

import org.instantlogic.designer.util.diagram.Point2d;



public class DeductionDesignEntityGenerator extends EntityDesign {

    public static final DeductionDesignEntityGenerator ENTITY = new DeductionDesignEntityGenerator();
    
    private DeductionDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("DeductionDesign");
        setIsCustomized(true);
    }
    
    public static final AttributeDesign diagramPosition = addAttribute(ENTITY, "diagramPosition", Point2d.class);
    public static final AttributeDesign diagramWidth = addAttribute(ENTITY, "diagramWidth", java.lang.Double.class);
    public static final AttributeDesign diagramHeight = addAttribute(ENTITY, "diagramHeight", java.lang.Double.class);
    
    // Relations
    public static final RelationDesign operation = addRelation(ENTITY, "operation", RelationType.ManyToZeroOrOne, DeductionOperationDesignEntityGenerator.ENTITY);

    public static final RelationDesign dataType = addRelation(ENTITY, "dataType", RelationType.ManyToZeroOrOne, DataTypeDesignEntityGenerator.ENTITY);
    
    public static final RelationDesign inputs = addRelation(ENTITY, "inputs", RelationType.OneToManyAggregation, DeductionInputDesignEntityGenerator.ENTITY)
    	.setReverseName("deduction");

    public static final RelationDesign parameters = addRelation(ENTITY, "parameters", RelationType.OneToManyAggregation, DeductionParameterDesignEntityGenerator.ENTITY)
        	.setReverseName("deduction");
    

    @Override
    public void init() {
    	diagramHeight.newDefault().deduceConstant(java.lang.Double.class, 4.0);
    	diagramWidth.newDefault().deduceConstant(java.lang.Double.class, 8.0);
    	diagramPosition.newDefault().deduceCustom(DesignerApplicationGenerator.DeductionDiagramPositionDefaultDeduction);
    }
}