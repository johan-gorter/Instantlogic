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


public class FragmentTemplateDesignEntityGenerator extends EntityDesign {

    public static final FragmentTemplateDesignEntityGenerator ENTITY = new FragmentTemplateDesignEntityGenerator();
    
    private FragmentTemplateDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("FragmentTemplateDesign");
        setExtendsFrom(ElementDesignEntityGenerator.ENTITY);
        setIsCustomized(true);
    }

    // Attributes
    public static final AttributeDesign fragmentTypeName = addAttribute(ENTITY, "fragmentTypeName", java.lang.String.class); // To be replaced by 'type'
    public static final AttributeDesign styleNames = addAttribute(ENTITY, "styleNames", java.lang.String.class);
    public static final AttributeDesign fragmentFilters = addAttribute(ENTITY, "fragmentFilters", java.lang.String.class);

    // Relations
    public static final RelationDesign type = addRelation(ENTITY, "type", RelationType.ManyToZeroOrOne, FragmentTypeDesignEntityGenerator.ENTITY)
    		.setReverseName("usages");
    public static final RelationDesign attribute = addRelation(ENTITY, "attribute", RelationType.ManyToZeroOrOne, AttributeDesignEntityGenerator.ENTITY);
    public static final RelationDesign entity = addRelation(ENTITY, "entity", RelationType.ManyToZeroOrOne, EntityDesignEntityGenerator.ENTITY);
    public static final RelationDesign event = addRelation(ENTITY, "event", RelationType.ManyToZeroOrOne, EventDesignEntityGenerator.ENTITY);
    public static final RelationDesign properties = addRelation(ENTITY, "properties", RelationType.OneToManyAggregation, PropertyDesignEntityGenerator.ENTITY)
            .setReverseName("fragment");
    
    @Override
    public void init() {
    	styleNames.getDataType().setMultivalue(true);
    	fragmentFilters.getDataType().setMultivalue(true);
    	type.newOptions().deduceRelation(ApplicationDesignEntityGenerator.fragmentTypes);
    	entity.newOptions().deduceRelation(ApplicationDesignEntityGenerator.entities);
    	attribute.newOptions().deduceRelation(EntityDesignEntityGenerator.attributes, attribute.getOptions().deduceRelation(entity)); //TODO: Union relations
    }
}