package org.instantlogic.interaction.util;

import java.util.List;

import org.instantlogic.fabric.value.ValueList;


public interface UserExtension {
	
	ValueList<LocationInfo> getBookmarks();
	
	List<LocationInfo> getTravelerLocations();

}
