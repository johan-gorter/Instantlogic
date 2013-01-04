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


public class ValidationDesignEntityGenerator extends EntityDesign {

    public static final ValidationDesignEntityGenerator ENTITY = new ValidationDesignEntityGenerator();
    
    private ValidationDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("ValidationDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
        setIsCustomized(true);
    }

    // Attributes

    // Relations
    public static final RelationDesign message = addRelation(ENTITY, "message", RelationType.OneToZeroOrOneAggregation, TextTemplateDesignEntityGenerator.ENTITY)
            .setReverseName("messageOfValidation");
    // Should return boolean: true/null/inconclusive = valid, false is invalid
    public static final RelationDesign rule = addRelation(ENTITY, "rule", RelationType.OneToOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY)
    		.setReverseName("ruleForValidation");
    public static final RelationDesign displayWith = addRelation(ENTITY, "displayWith", RelationType.ManyToMany, AttributeDesignEntityGenerator.ENTITY)
            .setReverseName("validations");
}