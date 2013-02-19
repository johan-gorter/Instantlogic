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



public class StaticInstanceValueDesignEntityGenerator extends EntityDesign {

    public static final StaticInstanceValueDesignEntityGenerator ENTITY = new StaticInstanceValueDesignEntityGenerator();
    
    private StaticInstanceValueDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("StaticInstanceValueDesign");
    }

    // Attributes
    public static final AttributeDesign value = addAttribute(ENTITY, "value", java.lang.Object.class);

    // Relations
    public static final RelationDesign attribute = addRelation(ENTITY, "attribute", RelationType.OneToZeroOrOne, AttributeDesignEntityGenerator.ENTITY);
    
    //TODO: pairs of attribute and value
}