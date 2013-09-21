package org.instantlogic.designer;

import org.instantlogic.fabric.deduction.ConcatenateDeduction;




public class RelationDesignEntityGenerator extends EntityDesign {

    public static final RelationDesignEntityGenerator ENTITY = new RelationDesignEntityGenerator();
    
    private RelationDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("RelationDesign");
        setExtendsFrom(AttributeDesignEntityGenerator.ENTITY);
    }

    // Attributes
    public static final AttributeDesign owner = addAttribute(ENTITY, "owner", DataCategoryDesign._boolean);
    public static final AttributeDesign autoCreate = addAttribute(ENTITY, "autoCreate", DataCategoryDesign._boolean);
    public static final AttributeDesign reverseMultivalue = addAttribute(ENTITY, "reverseMultivalue", DataCategoryDesign._boolean);
    public static final AttributeDesign reverseName = addAttribute(ENTITY, "reverseName", DataCategoryDesign.text);
    public static final AttributeDesign reverseTechnicalName = addAttribute(ENTITY, "reverseTechnicalName", DataCategoryDesign.text);
    public static final AttributeDesign reverseJavaIdentifier = addAttribute(ENTITY, "reverseJavaIdentifier", DataCategoryDesign.text);
    public static final AttributeDesign hasOptions = addAttribute(ENTITY, "hasOptions", DataCategoryDesign._boolean);

    // Relations
    public static final RelationDesign to = addRelation(ENTITY, "to", RelationType.ManyToZeroOrOne, EntityDesignEntityGenerator.ENTITY)
            .setReverseName("reverseRelations");
    
    public static final RelationDesign reverseDataType = addRelation(ENTITY, "reverseDataType", RelationType.OneToOneAggregation, DataTypeDesignEntityGenerator.ENTITY)
    		.setReverseName("reverseRelation");
    
    public static final RelationDesign options = addRelation(ENTITY, "options", RelationType.OneToZeroOrOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY)
        	.setReverseName("optionsOfRelation");

    @Override
    public void init() {
    	super.init();
    	
    	DeductionDesign deduceRelationName = reverseName.newDefault().deduceAttribute(DesignEntityGenerator.name);
    	DeductionDesign constantOn = reverseName.getDefault().deduceConstant(String.class, "On");
    	DeductionDesign entityName = reverseName.getDefault().deduceAttribute(DesignEntityGenerator.name, reverseName.getDefault().deduceReverseRelation(EntityDesignEntityGenerator.relations, reverseName.getDefault().deduceSelectedInstance(ENTITY)));
    	DeductionDesign reverseDefault = reverseName.getDefault().deduceCustom(DeductionOperationDesign.concatenate);
		DeductionInputDesign stringsInput = new DeductionInputDesign();
		reverseDefault.addToInputs(stringsInput);
		stringsInput.setOperationInput(DeductionOperationInputDesign.concatenateStrings);
		stringsInput.addToInputs(deduceRelationName);
		stringsInput.addToInputs(constantOn);
		stringsInput.addToInputs(entityName);
    	
    	reverseTechnicalName.setWriteable(false);
    	reverseTechnicalName.newRule().deduceCustom(DesignerApplicationGenerator.ReverseTechnicalNameDeduction);

    	reverseJavaIdentifier.setWriteable(false);
    	reverseJavaIdentifier.newRule().deduceCustom(DesignerApplicationGenerator.ReverseJavaIdentifierDeduction);
    	
    	new DeductionSchemeDesign().setRelevanceOfAttribute(options).deduceAttribute(hasOptions);
    }
}