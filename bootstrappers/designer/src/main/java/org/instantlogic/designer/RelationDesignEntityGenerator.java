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

import org.instantlogic.designer.deduction.ReverseJavaIdentifierDeduction;
import org.instantlogic.designer.deduction.ReverseTechnicalNameDeduction;



public class RelationDesignEntityGenerator extends EntityDesign {

    public static final RelationDesignEntityGenerator ENTITY = new RelationDesignEntityGenerator();
    
    private RelationDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("RelationDesign");
        setExtendsFrom(AttributeDesignEntityGenerator.ENTITY);
    }

    // Attributes
    public static final AttributeDesign owner = addAttribute(ENTITY, "owner", java.lang.Boolean.class);
    public static final AttributeDesign autoCreate = addAttribute(ENTITY, "autoCreate", java.lang.Boolean.class);
    public static final AttributeDesign reverseMultivalue = addAttribute(ENTITY, "reverseMultivalue", java.lang.Boolean.class);
    public static final AttributeDesign reverseName = addAttribute(ENTITY, "reverseName", java.lang.String.class);
    public static final AttributeDesign reverseTechnicalName = addAttribute(ENTITY, "reverseTechnicalName", java.lang.String.class);
    public static final AttributeDesign reverseJavaIdentifier = addAttribute(ENTITY, "reverseJavaIdentifier", java.lang.String.class);
    public static final AttributeDesign hasOptions = addAttribute(ENTITY, "hasOptions", java.lang.Boolean.class);

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
    	
    	reverseTechnicalName.setWriteable(false);
    	reverseTechnicalName.setRule(new DeductionSchemeDesign().deduceCustom(ReverseTechnicalNameDeduction.class, String.class).getScheme());

    	reverseJavaIdentifier.setWriteable(false);
    	reverseJavaIdentifier.setRule(new DeductionSchemeDesign().deduceCustom(ReverseJavaIdentifierDeduction.class, String.class).getScheme());
    	
    	new DeductionSchemeDesign().setRelevanceOfAttribute(options).deduceAttribute(hasOptions);
    }
}