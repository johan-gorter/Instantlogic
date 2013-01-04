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


public class FlowDesignEntityGenerator extends EntityDesign {

    public static final FlowDesignEntityGenerator ENTITY = new FlowDesignEntityGenerator();
    
    private FlowDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("FlowDesign");
        setIsCustomized(true);
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations
    public static final RelationDesign nodes = addRelation(ENTITY, "nodes", RelationType.OneToManyAggregation, FlowNodeBaseDesignEntityGenerator.ENTITY)
            .setReverseName("owner");
    public static final RelationDesign edges = addRelation(ENTITY, "edges", RelationType.OneToManyAggregation, FlowEdgeDesignEntityGenerator.ENTITY)
            .setReverseName("owner");
    public static final RelationDesign parameters = addRelation(ENTITY, "parameters", RelationType.ManyToMany, EntityDesignEntityGenerator.ENTITY);

}