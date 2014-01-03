package org.instantlogic.engine.presence;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.DataCategoryDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.interaction.util.LocationInfo;

public class PlaceEntityGenerator extends EntityDesign {

    public static final PlaceEntityGenerator ENTITY = new PlaceEntityGenerator();
    
    private PlaceEntityGenerator() {
    	PresenceApplicationGenerator.APPLICATION.addToEntities(this);
        setName("Place");
        setIsCustomized(true);
    }
    
    // Attributes
    public static final AttributeDesign location = addAttribute(ENTITY, "location", LocationInfo.class);
    public static final AttributeDesign currentTitle = addAttribute(ENTITY, "currentTitle", DataCategoryDesign.text);

}
