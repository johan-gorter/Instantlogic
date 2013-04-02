/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer;

import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel.StaticInstance;
import org.instantlogic.designer.deduction.DataTypeDataCategoryDeduction;
import org.instantlogic.designer.deduction.DataTypeDataCategoryOptionsDeduction;
import org.instantlogic.designer.deduction.DataTypeEntityDeduction;
import org.instantlogic.designer.deduction.DataTypeJavaClassNameDeduction;
import org.instantlogic.designer.deduction.DataTypeMultivalueDeduction;

public class DataTypeDesignEntityGenerator extends EntityDesign {

    public static final DataTypeDesignEntityGenerator ENTITY = new DataTypeDesignEntityGenerator();
    
    private DataTypeDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("DataTypeDesign");
    }
    
    public static final RelationDesign dataCategory = addRelation(ENTITY, "dataCategory", RelationType.OneToZeroOrOne, DataCategoryDesignEntityGenerator.ENTITY);

    public static final RelationDesign entity = addRelation(ENTITY, "entity", RelationType.OneToZeroOrOne, EntityDesignEntityGenerator.ENTITY);
    public static final AttributeDesign multivalue = addAttribute(ENTITY, "multivalue", DataCategoryDesign._boolean);
   
    // Classname of a single item
    public static final AttributeDesign javaClassName = addAttribute(ENTITY, "javaClassName", DataCategoryDesign.text);
    
    // Only relevant when dataCategory == number
    public static final AttributeDesign percentage = addAttribute(ENTITY, "percentage", DataCategoryDesign._boolean);
    public static final AttributeDesign wholeNumber = addAttribute(ENTITY, "wholeNumber", DataCategoryDesign._boolean);
    public static final AttributeDesign exactRounding = addAttribute(ENTITY, "exactRounding", DataCategoryDesign._boolean);
    // Units?

    // Only relevant when dataCategory == text
    public static final AttributeDesign multiLine = addAttribute(ENTITY, "multiLine", DataCategoryDesign._boolean);
    public static final AttributeDesign formatted = addAttribute(ENTITY, "formatted", DataCategoryDesign._boolean);
    
    public static final StaticInstanceDesign _boolean = addStaticInstance(ENTITY, "boolean", createConstantText("Boolean"));
    public static final StaticInstanceDesign text = addStaticInstance(ENTITY, "text", createConstantText("Text"));
    
    @Override
    public void init() {
    	addStaticInstanceRelationValue(_boolean, dataCategory, DataCategoryDesignEntityGenerator._boolean);
    	addStaticInstanceRelationValue(text, dataCategory, DataCategoryDesignEntityGenerator.text);
    	
    	javaClassName.newDefault().deduceCustom(DesignerApplicationGenerator.DataTypeJavaClassNameDeduction);
    	
    	entity.setWriteable(false);
    	entity.newRule().deduceCustom(DesignerApplicationGenerator.DataTypeEntityDeduction);
    	
    	dataCategory.newRule().deduceCustom(DesignerApplicationGenerator.DataTypeDataCategoryDeduction);
    	dataCategory.setDefault(DeductionSchemeDesign.constant(DataCategoryDesign.text));
    	dataCategory.newOptions().deduceCustom(DesignerApplicationGenerator.DataTypeDataCategoryOptionsDeduction);
    	
    	multivalue.newRule().deduceCustom(DesignerApplicationGenerator.DataTypeMultivalueDeduction);
    	multivalue.setDefault(DeductionSchemeDesign.constant(false));

    	wholeNumber.newDefault().deduceConstant(Boolean.class, Boolean.FALSE);
    	
//TODO: deduceIf
//    	wholeNumber.newRule().deduceEquals(
//    			wholeNumber.getRelevance().deduceAttribute(percentage), 
//    			wholeNumber.getRelevance().deduceConstant(Boolean.class, Boolean.FALSE));
    	
    	// Relevance
    	multiLine.newRelevance().deduceEquals(
    			multiLine.getRelevance().deduceAttribute(dataCategory), 
    			multiLine.getRelevance().deduceConstant(DataCategoryDesign.class, DataCategoryDesign.text));
    	formatted.newRelevance().deduceAttribute(multiLine);

    	percentage.newRelevance().deduceEquals(
    			percentage.getRelevance().deduceAttribute(dataCategory), 
    			percentage.getRelevance().deduceConstant(DataCategoryDesign.class, DataCategoryDesign.number));
    	wholeNumber.newRelevance().deduceEquals(
    			wholeNumber.getRelevance().deduceAttribute(dataCategory), 
    			wholeNumber.getRelevance().deduceConstant(DataCategoryDesign.class, DataCategoryDesign.number));
    	exactRounding.newRelevance().deduceEquals(
    			exactRounding.getRelevance().deduceAttribute(wholeNumber), 
    			exactRounding.getRelevance().deduceConstant(Boolean.class, Boolean.FALSE));
    	
    	newValidation("DataCategoryRequired", "Select a value", dataCategory).deduceAttributeHasValue(dataCategory);
    }
}
