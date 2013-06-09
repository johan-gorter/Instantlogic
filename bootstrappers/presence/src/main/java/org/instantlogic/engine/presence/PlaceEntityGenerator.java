package org.instantlogic.engine.presence;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.DataCategoryDesign;
import org.instantlogic.designer.EntityDesign;

public class PlaceEntityGenerator extends EntityDesign {

    public static final PlaceEntityGenerator ENTITY = new PlaceEntityGenerator();
    
    private PlaceEntityGenerator() {
    	PresenceApplicationGenerator.APPLICATION.addToEntities(this);
        setName("Place");
        setIsCustomized(true);
    }
    
    // Attributes
    public static final AttributeDesign url = addAttribute(ENTITY, "url", DataCategoryDesign.text);
    public static final AttributeDesign title = addAttribute(ENTITY, "title", DataCategoryDesign.text);
    
}
