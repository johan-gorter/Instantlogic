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



public class SelectionDesignEntityGenerator extends EntityDesign {

    public static final SelectionDesignEntityGenerator ENTITY = new SelectionDesignEntityGenerator();
    
    private SelectionDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("SelectionDesign");
        setExtendsFrom(ElementDesignEntityGenerator.ENTITY);
    }

    // Relations
    public static final RelationDesign selection = addRelation(ENTITY, "selection", RelationType.OneToOneAggregation, DeductionSchemeDesignEntityGenerator.ENTITY)
    		.setReverseName("selectionElement");
    
    public static final RelationDesign children = addRelation(ENTITY, "children", RelationType.OneToManyAggregation, ElementDesignEntityGenerator.ENTITY)
            .setReverseName("childOfSelection"); //TODO: Single value for making it easier to get animations right (and no collapsing needed in the designer)
    
}