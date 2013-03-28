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



public class ApplicationDesignEntityGenerator extends EntityDesign {

    public static final ApplicationDesignEntityGenerator ENTITY = new ApplicationDesignEntityGenerator();
    
    private ApplicationDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("ApplicationDesign");
        setIsCustomized(true);
    }

    // Attributes
    public static final AttributeDesign name = addAttribute(ENTITY, "name", java.lang.String.class);
    public static final AttributeDesign rootPackageName = addAttribute(ENTITY, "rootPackageName", java.lang.String.class);
    public static final AttributeDesign sourcePath = addAttribute(ENTITY, "sourcePath", java.lang.String.class);
    public static final AttributeDesign isCustomized = addAttribute(ENTITY, "isCustomized", java.lang.Boolean.class);
    public static final AttributeDesign themeNames = addAttribute(ENTITY, "themeNames", java.lang.String.class);

    // Relations
    public static final RelationDesign entities = addRelation(ENTITY, "entities", RelationType.OneToManyAggregation, EntityDesignEntityGenerator.ENTITY)
            .setReverseName("application");
    public static final RelationDesign caseEntity = addRelation(ENTITY, "caseEntity", RelationType.OneToZeroOrOne, EntityDesignEntityGenerator.ENTITY);

    public static final RelationDesign deductionOperations = addRelation(ENTITY, "deductionOperations", RelationType.OneToManyAggregation, DeductionOperationDesignEntityGenerator.ENTITY);
    
    public static final RelationDesign flows = addRelation(ENTITY, "flows", RelationType.OneToManyAggregation, FlowDesignEntityGenerator.ENTITY)
            .setReverseName("application");
    public static final RelationDesign events = addRelation(ENTITY, "events", RelationType.OneToManyAggregation, EventDesignEntityGenerator.ENTITY)
            .setReverseName("application");
    public static final RelationDesign fragmentTypes = addRelation(ENTITY, "fragmentTypes", RelationType.OneToManyAggregation, FragmentTypeDesignEntityGenerator.ENTITY)
            .setReverseName("application");
    public static final RelationDesign mainFlow = addRelation(ENTITY, "mainFlow", RelationType.OneToZeroOrOne, FlowDesignEntityGenerator.ENTITY);
    public static final RelationDesign startEvent = addRelation(ENTITY, "startEvent", RelationType.OneToZeroOrOne, EventDesignEntityGenerator.ENTITY);
    public static final RelationDesign sharedElements = addRelation(ENTITY, "sharedElements", RelationType.OneToManyAggregation, SharedElementDefinitionDesignEntityGenerator.ENTITY)
            .setReverseName("application");
    
    @Override
    public void init() {
    	themeNames.getDataType().setMultivalue(true);
    }
}