/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.engine.presence;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.DataCategoryDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.RelationDesign;

public class PresenceEntityGenerator extends EntityDesign {

    public static final PresenceEntityGenerator ENTITY = new PresenceEntityGenerator();
    
    private PresenceEntityGenerator() {
    	PresenceApplicationGenerator.APPLICATION.addToEntities(this);
        setName("Presence");
        setIsCustomized(true);
    }

    // Attributes
    public static final AttributeDesign applicationName = addAttribute(ENTITY, "applicationName", DataCategoryDesign.text);
    public static final AttributeDesign caseName = addAttribute(ENTITY, "caseName", DataCategoryDesign.text);

    // Relations
    public static final RelationDesign activeUsers = addRelation(ENTITY, "activeUsers", RelationType.OneToManyAggregation, UserEntityGenerator.ENTITY)
            .setReverseName("presence");
    public static final RelationDesign activeTravelers = addRelation(ENTITY, "activeTravelers", RelationType.OneToManyAggregation, TravelerEntityGenerator.ENTITY)
            .setReverseName("presence");
    public static final RelationDesign activePlaces = addRelation(ENTITY, "activePlaces", RelationType.OneToManyAggregation, PlaceEntityGenerator.ENTITY)
            .setReverseName("presence");
    
}
