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



public class IfElseDesignEntityGenerator extends EntityDesign {

    public static final IfElseDesignEntityGenerator ENTITY = new IfElseDesignEntityGenerator();
    
    private IfElseDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("IfElseDesign");
        setExtendsFrom(ElementDesignEntityGenerator.ENTITY);
    }

    // Relations
    public static final RelationDesign condition = addRelation(ENTITY, "condition", RelationType.OneToOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY);
    
    public static final RelationDesign ifChildren = addRelation(ENTITY, "ifChildren", RelationType.OneToManyAggregation, ElementDesignEntityGenerator.ENTITY); //TODO: Single value for making it easier to get animations right    

    public static final RelationDesign elseChildren = addRelation(ENTITY, "elseChildren", RelationType.OneToManyAggregation, ElementDesignEntityGenerator.ENTITY); //TODO: Single value for making it easier to get animations right    
}