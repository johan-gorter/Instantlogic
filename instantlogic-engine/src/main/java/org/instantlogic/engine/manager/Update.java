

package org.instantlogic.engine.manager;

import java.util.Map;

public class Update {
	
	private String name;
	private String location;
	private Map<String, Object> rootFragment;
	private String exceptionMessage;
	private Boolean exceptionRendering;
	
	public Update() {
	}
	
	public Update(String name) {
		this.name = name;
	}

	public Update(Exception exception, boolean exceptionRendering) {
		this.name = "exception";
		this.exceptionMessage = exception.getMessage();
		this.exceptionRendering = exceptionRendering;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Map<String, Object> getRootFragment() {
		return rootFragment;
	}
	public void setRootFragment(Map<String, Object> rootFragment) {
		this.rootFragment = rootFragment;
	}

	public Boolean getExceptionRendering() {
		return exceptionRendering;
	}

	public void setExceptionRendering(Boolean exceptionRendering) {
		this.exceptionRendering = exceptionRendering;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
}