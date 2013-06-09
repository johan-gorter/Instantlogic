

package org.instantlogic.engine.util;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.engine.TravelerProxy;
import org.instantlogic.engine.manager.Update;
import org.instantlogic.interaction.util.TravelerInfo;

public class TravelerProxyStub implements TravelerProxy {
	
	private final List<Update> lastUpdates = new ArrayList<Update>();
	
	private final TravelerInfo travelerInfo;

	public TravelerProxyStub(String travelerId, String username) {
		this.travelerInfo =  new TravelerInfo(travelerId);
		this.travelerInfo.setAuthenticatedUsername(username);
	}
	
	public TravelerProxyStub(TravelerInfo travelerInfo) {
		this.travelerInfo = travelerInfo;
	}

	@Override
	public void sendUpdates(List<Update> updates) {
		lastUpdates.addAll(updates);
	}
	
	@Override
	public TravelerInfo getTravelerInfo() {
		return travelerInfo;
	}

	public List<Update> getLastUpdates() {
		return lastUpdates;
	}
	
	public void clearLastUpdates() {
		lastUpdates.clear();
	}
	
	public Update getLastPlaceUpdate() {
		Update result = null;
		if (lastUpdates==null) throw new RuntimeException("No updates");
		for (Update update : lastUpdates) {
			if (update.getName().equals("place")) {
				result = update;
			}
		}
		if (result!=null) {
			return result;
		}
		throw new RuntimeException("No place update");
	}
}
