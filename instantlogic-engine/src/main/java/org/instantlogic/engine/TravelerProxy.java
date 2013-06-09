

package org.instantlogic.engine;

import java.util.List;

import org.instantlogic.engine.manager.Update;
import org.instantlogic.interaction.util.TravelerInfo;

public interface TravelerProxy {

	TravelerInfo getTravelerInfo();
	
	void sendUpdates(List<Update> messages);

}
