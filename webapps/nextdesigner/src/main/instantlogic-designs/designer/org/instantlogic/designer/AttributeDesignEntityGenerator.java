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

import org.instantlogic.designer.deduction.AttributeBelongsToDeduction;

public class AttributeDesignEntityGenerator extends EntityDesign {

    public static final AttributeDesignEntityGenerator ENTITY = new AttributeDesignEntityGenerator();
    
    private AttributeDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("AttributeDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
        setIsCustomized(true);
    }

    // Attributes
    public static final AttributeDesign writeable = addAttribute(ENTITY, "writeable", DataCategoryDesign._boolean); // writeable == Not readonly
    public static final AttributeDesign hasRelevance = addAttribute(ENTITY, "hasRelevance", DataCategoryDesign._boolean);
    public static final AttributeDesign hasRule = addAttribute(ENTITY, "hasRule", DataCategoryDesign._boolean);
    public static final AttributeDesign hasDefault = addAttribute(ENTITY, "hasDefault", DataCategoryDesign._boolean);
    
    // Relations
    public static final RelationDesign dataType = addRelation(ENTITY, "dataType", RelationType.OneToOneAggregation, DataTypeDesignEntityGenerator.ENTITY)
		.setReverseName("attribute");
    
    public static final RelationDesign question = addRelation(ENTITY, "question", RelationType.OneToZeroOrOneAggregation, TextTemplateDesignEntityGenerator.ENTITY);
    public static final RelationDesign explanation = addRelation(ENTITY, "explanation", RelationType.OneToZeroOrOneAggregation, TextTemplateDesignEntityGenerator.ENTITY);
    public static final RelationDesign relevance = addRelation(ENTITY, "relevance", RelationType.OneToZeroOrOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY)
    	.setReverseName("relevanceOfAttribute");
    public static final RelationDesign rule = addRelation(ENTITY, "rule", RelationType.OneToZeroOrOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY)
    	.setReverseName("ruleOfAttribute");
    public static final RelationDesign _default = addRelation(ENTITY, "default", RelationType.OneToZeroOrOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY)
    		.setReverseName("defaultOfAttribute");

    public static final RelationDesign belongsToEntity = addRelation(ENTITY, "belongsToEntity", RelationType.ManyToZeroOrOne, EntityDesignEntityGenerator.ENTITY);
    
    @Override
    public void init() {
    	belongsToEntity.setWriteable(false);
    	belongsToEntity.setRule(new DeductionSchemeDesign().deduceCustom(AttributeBelongsToDeduction.class, EntityDesign.class).getScheme());
    	
    	hasRelevance.setDefault(DeductionSchemeDesign.constant(false));
    	hasRule.setDefault(DeductionSchemeDesign.constant(false));
    	writeable.setDefault(DeductionSchemeDesign.constant(true));

    	new DeductionSchemeDesign().setRelevanceOfAttribute(relevance).deduceAttribute(hasRelevance);
    	new DeductionSchemeDesign().setRelevanceOfAttribute(rule).deduceAttribute(hasRule);
    	new DeductionSchemeDesign().setRelevanceOfAttribute(_default).deduceAttribute(hasDefault);
    }
}