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
    public static final AttributeDesign diagramWidth = addAttribute(ENTITY, "diagramWidth", DataCategoryDesign.number);
    public static final AttributeDesign diagramHeight = addAttribute(ENTITY, "diagramHeight", DataCategoryDesign.number);
    public static final AttributeDesign parameterValuesDescription = addAttribute(ENTITY, "parameterValuesDescription", DataCategoryDesign.text);
    
    // Relations
    public static final RelationDesign operation = addRelation(ENTITY, "operation", RelationType.ManyToZeroOrOne, DeductionOperationDesignEntityGenerator.ENTITY);

    public static final RelationDesign dataType = addRelation(ENTITY, "dataType", RelationType.ManyToZeroOrOne, DataTypeDesignEntityGenerator.ENTITY);
    
    public static final RelationDesign inputs = addRelation(ENTITY, "inputs", RelationType.OneToManyAggregation, DeductionInputDesignEntityGenerator.ENTITY)
    	.setReverseName("deduction");

    public static final RelationDesign parameters = addRelation(ENTITY, "parameters", RelationType.OneToManyAggregation, DeductionParameterDesignEntityGenerator.ENTITY)
        	.setReverseName("deduction");
    

    @Override
    public void init() {
    	DeductionSchemeDesign title;
		setTitle(new TextTemplateDesign().addToUntranslated(new StringTemplateDesign().setDeduction(title = new DeductionSchemeDesign())));
		DeductionDesign operationName = title.deduceAttribute(DesignEntityGenerator.name, title.deduceRelation(operation));
		DeductionDesign space = title.deduceConstant(String.class, " ");
		DeductionDesign parameters = title.deduceAttribute(parameterValuesDescription);
		DeductionDesign concatenate = title.deduceCustom(DeductionOperationDesign.concatenate);
		concatenate.addInput(DeductionOperationInputDesign.concatenateStrings, operationName, space, parameters);
    	
    	diagramHeight.newDefault().deduceConstant(java.lang.Double.class, 40.0);
    	diagramWidth.newDefault().deduceConstant(java.lang.Double.class, 80.0);
    	diagramPosition.newDefault().deduceCustom(DesignerApplicationGenerator.DeductionDiagramPositionDefaultDeduction);

    	parameterValuesDescription.setWriteable(false);
    	parameterValuesDescription.newRule().deduceCustom(DesignerApplicationGenerator.DeductionParameterValuesDescriptionRuleDeduction);
    }
    
}