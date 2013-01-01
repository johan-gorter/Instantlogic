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
