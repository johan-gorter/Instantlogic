package org.instantlogic.engine.presence;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.DataCategoryDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.RelationDesign;

public class TravelerEntityGenerator extends EntityDesign {

    public static final TravelerEntityGenerator ENTITY = new TravelerEntityGenerator();
    
    private TravelerEntityGenerator() {
    	PresenceApplicationGenerator.APPLICATION.addToEntities(this);
        setName("Traveler");
        setIsCustomized(true);
    }
    
    // Attributes
    public static final AttributeDesign id = addAttribute(ENTITY, "id", DataCategoryDesign.text);
    public static final AttributeDesign debugVisible = addAttribute(ENTITY, "debugVisible", DataCategoryDesign._boolean);
    public static final AttributeDesign focus = addAttribute(ENTITY, "focus", DataCategoryDesign.text);

    // Relations
    public static final RelationDesign currentPlace = addRelation(ENTITY, "currentPlace", RelationType.ManyToZeroOrOne, PlaceEntityGenerator.ENTITY)
    	.setReverseName("visitingTravelers");
    
    public static final RelationDesign user = addRelation(ENTITY, "user", RelationType.ManyToZeroOrOne, UserEntityGenerator.ENTITY)
            .setReverseName("travelers");
    
    @Override
    public void init() {
    	debugVisible.setQuestion(createConstantText("debug"));
    }
}
