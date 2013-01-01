package org.instantlogic.engine;

import java.util.List;

import org.instantlogic.engine.manager.Update;
import org.instantlogic.interaction.util.TravelerInfo;

public class TestTravelerProxy implements TravelerProxy {
	
	private TravelerInfo travelerInfo;
	private List<Update> lastUpdates;
	
	public TestTravelerProxy(TravelerInfo travelerInfo) {
		this.travelerInfo = travelerInfo;
	}

	@Override
	public TravelerInfo getTravelerInfo() {
		return travelerInfo;
	}

	@Override
	public void sendUpdates(List<Update> updates) {
		this.lastUpdates = updates;
	}

	public List<Update> getLastUpdates() {
		return lastUpdates;
	}

}
