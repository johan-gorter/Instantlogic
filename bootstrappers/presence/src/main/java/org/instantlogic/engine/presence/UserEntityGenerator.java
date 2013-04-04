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
    
    // Relations
    
    // init
    @Override
    public void init() {
    	email.newDefault().deduceAttribute(username);
    	name.newDefault().deduceCustom(PresenceApplicationGenerator.UserNameDefaultDeduction);
    	avatarUrl.newDefault().deduceCustom(PresenceApplicationGenerator.UserAvatarUrlDefaultDeduction);
    }
}
