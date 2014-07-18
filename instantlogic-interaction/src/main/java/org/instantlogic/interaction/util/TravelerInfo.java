package org.instantlogic.interaction.util;

import java.util.HashMap;
import java.util.Map;


public final class TravelerInfo {

	private String travelerId;
	private String authenticatedUsername;
	
	private Map<Class<?>, Object> travelerExtensions = new HashMap<Class<?>, Object>();
	
	public TravelerInfo() {
	}

	public TravelerInfo(String travelerId) {
		this.travelerId = travelerId;
	}

	public TravelerInfo(String travelerId, String authenticatedUsername) {
		this.travelerId = travelerId;
		this.authenticatedUsername = authenticatedUsername;
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
	
	@SuppressWarnings("unchecked")
	public <T> T getOrCreateExtension(Class<T> extensionClass) {
		T result = (T)travelerExtensions.get(extensionClass);
		if (result == null) {
			try {
				result = extensionClass.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				throw new RuntimeException(e);
			}
			travelerExtensions.put(extensionClass, result);
		}
		return result;
	}
	
	public <T> void registerExtension(Class<? extends T> extensionInterface, T extensionInstance) {
		Object old = travelerExtensions.put(extensionInterface, extensionInstance);
		if (old!=null) {
			travelerExtensions.put(extensionInterface, old);
			throw new RuntimeException("Extension already registered: "+extensionInterface);
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getExtension(Class<T> extensionClass) {
		return (T)travelerExtensions.get(extensionClass);
	}
}
