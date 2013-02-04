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




public class EntityDesignEntityGenerator extends EntityDesign {

    public static final EntityDesignEntityGenerator ENTITY = new EntityDesignEntityGenerator();
    
    private EntityDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("EntityDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
        setIsCustomized(true);
    }

    // Attributes

    // Relations
    public static final RelationDesign title = addRelation(ENTITY, "title", RelationType.OneToZeroOrOneAggregation, TextTemplateDesignEntityGenerator.ENTITY)
            .setReverseName("titleOfEntity");
    public static final RelationDesign extendsFrom = addRelation(ENTITY, "extendsFrom", RelationType.ManyToZeroOrOne, EntityDesignEntityGenerator.ENTITY)
            .setReverseName("extensions");
    public static final RelationDesign attributes = addRelation(ENTITY, "attributes", RelationType.OneToManyAggregation, AttributeDesignEntityGenerator.ENTITY)
            .setReverseName("attributeOf");
    public static final RelationDesign relations = addRelation(ENTITY, "relations", RelationType.OneToManyAggregation, RelationDesignEntityGenerator.ENTITY)
            .setReverseName("from");

    public static final RelationDesign validations = addRelation(ENTITY, "validations", RelationType.OneToManyAggregation, ValidationDesignEntityGenerator.ENTITY)
            .setReverseName("forEntity");
    
    public static final RelationDesign staticInstances = addRelation(ENTITY, "staticInstances", RelationType.OneToManyAggregation, StaticInstanceDesignEntityGenerator.ENTITY)
            .setReverseName("entity");

    public static final RelationDesign dataType = addRelation(ENTITY, "dataType", RelationType.OneToOneAggregation, DataTypeDesignEntityGenerator.ENTITY)
    		.setReverseName("forEntity");
}