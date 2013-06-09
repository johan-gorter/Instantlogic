

package org.instantlogic.interaction.util;


public final class TravelerInfo {

	private String travelerId;
	private String authenticatedUsername;
	
	public TravelerInfo() {
	}

	public TravelerInfo(String travelerId) {
		this.travelerId = travelerId;
	}

	public String getTravelerId() {
		return travelerId;
	}
	
	public void setTravelerId(String travelerId) {
		this.travelerId = travelerId;
	}

	public String getAuthenticatedUsername() {
		return authenticatedUsername;
	}

	public void setAuthenticatedUsername(String authenticatedUsername) {
		this.authenticatedUsername = authenticatedUsername;
	}
	
	@Override
	public String toString() {
		return authenticatedUsername+"-"+travelerId;
	}
}
