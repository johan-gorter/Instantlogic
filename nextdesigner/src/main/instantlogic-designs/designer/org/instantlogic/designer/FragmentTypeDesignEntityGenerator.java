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


public class FragmentTypeDesignEntityGenerator extends EntityDesign {

    public static final FragmentTypeDesignEntityGenerator ENTITY = new FragmentTypeDesignEntityGenerator();
    
    private FragmentTypeDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("FragmentTypeDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes
    public static final AttributeDesign fragmentFilters = addAttribute(ENTITY, "fragmentFilters", DataCategoryDesign.text);
    public static final AttributeDesign hasAttribute = addAttribute(ENTITY, "hasAttribute", DataCategoryDesign._boolean);
    public static final AttributeDesign hasEvent = addAttribute(ENTITY, "hasEvent", DataCategoryDesign._boolean);

    // Relations
    //TODO: Property definitions
    
    @Override
    public void init() {
    	fragmentFilters.getDataType().setMultivalue(true);
    	hasAttribute.newDefault().deduceConstant(Boolean.class, false);
    	hasEvent.newDefault().deduceConstant(Boolean.class, false);
    }
}