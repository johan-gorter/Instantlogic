package org.instantlogic.interaction.util;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;

public class LocationInfo {

	private final String url;
	private final String title;
	private final String aboutInstanceId;
	private final String aboutRelationId;
	
	public LocationInfo(String url, String title, String aboutInstanceId, String aboutRelationId) {
		this.url = url;
		this.title = title;
		this.aboutInstanceId = aboutInstanceId;
		this.aboutRelationId = aboutRelationId;
	}

	public String getUrl() {
		return url;
	}

	public String getTitle() {
		return title;
	}

	public String getAboutInstanceId() {
		return aboutInstanceId;
	}

	public String getAboutRelationId() {
		return aboutRelationId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aboutInstanceId == null) ? 0 : aboutInstanceId.hashCode());
		result = prime * result
				+ ((aboutRelationId == null) ? 0 : aboutRelationId.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocationInfo other = (LocationInfo) obj;
		if (aboutInstanceId == null) {
			if (other.aboutInstanceId != null)
				return false;
		} else if (!aboutInstanceId.equals(other.aboutInstanceId))
			return false;
		if (aboutRelationId == null) {
			if (other.aboutRelationId != null)
				return false;
		} else if (!aboutRelationId.equals(other.aboutRelationId))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	public Instance getAboutInstance(Instance caseInstance) {
		if (aboutInstanceId.indexOf("!")>=0) {
			String[] split = aboutInstanceId.split("!");
			Entity<?> entity = caseInstance.getMetadata().getCaseAdministration().getAllEntities().get(split[0]);
			return entity.getStaticInstances().get(split[1]);
		}
		return caseInstance.getMetadata().getCaseAdministration().getInstanceByUniqueId(aboutInstanceId);
	}
	
	
}
