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



public class DeductionParameterDesignEntityGenerator extends EntityDesign {

    public static final DeductionParameterDesignEntityGenerator ENTITY = new DeductionParameterDesignEntityGenerator();
    
    private DeductionParameterDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("DeductionParameterDesign");
    }
    
    // Attributes
    public static final AttributeDesign value = addAttribute(ENTITY, "value", Object.class);

    // Relations
    public static final RelationDesign operationParameter = addRelation(ENTITY, "operationParameter", RelationType.ManyToZeroOrOne, DeductionOperationParameterDesignEntityGenerator.ENTITY);

    // Relations
    public static final RelationDesign entityValue = addRelation(ENTITY, "entityValue", RelationType.ManyToZeroOrOne, EntityDesignEntityGenerator.ENTITY);
    public static final RelationDesign attributeValue = addRelation(ENTITY, "attributeValue", RelationType.ManyToZeroOrOne, AttributeDesignEntityGenerator.ENTITY);
    public static final RelationDesign staticInstanceValue = addRelation(ENTITY, "staticInstanceValue", RelationType.ManyToZeroOrOne, StaticInstanceDesignEntityGenerator.ENTITY);
}