package org.instantlogic.engine.presence;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.DataCategoryDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.interaction.util.LocationInfo;

public class UserEntityGenerator extends EntityDesign {

    public static final UserEntityGenerator ENTITY = new UserEntityGenerator();
    
    private UserEntityGenerator() {
    	PresenceApplicationGenerator.APPLICATION.addToEntities(this);
        setName("User");
        setIsCustomized(true);
    }

    // Attributes
    public static final AttributeDesign username = addAttribute(ENTITY, "username", DataCategoryDesign.text);
    public static final AttributeDesign email = addAttribute(ENTITY, "email", DataCategoryDesign.text);
    public static final AttributeDesign name = addAttribute(ENTITY, "name", DataCategoryDesign.text);
    public static final AttributeDesign avatarUrl = addAttribute(ENTITY, "avatarUrl", DataCategoryDesign.text);
    public static final AttributeDesign bookmarks = addAttribute(ENTITY, "bookmarks", LocationInfo.class).multivalue().ordered();
    
    // Relations
    
    // init
    @Override
    public void init() {
    	email.newDefault().deduceAttribute(username);
    	name.newDefault().deduceCustom(PresenceApplicationGenerator.UserNameDefaultDeduction);
    	avatarUrl.newDefault().deduceCustom(PresenceApplicationGenerator.UserAvatarUrlDefaultDeduction);
    }
}
