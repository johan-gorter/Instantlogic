package org.instantlogic.fabric.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains all of the information as it was loaded into the instance. (including information that was not recognized)
 */
// TODO: allow 'git' diff markers to be parsed and stored within this information
public class InstanceStorageInfo {

	public static class InstanceNode {
		public String uniqueId;
		public String entityName;
		public final List<AttributeValueNode> attributes = new ArrayList<>();
	}
	
	public static class AttributeValueNode {
		public String attributeName;
		public final List<String> values = new ArrayList<>();
		public final List<InstanceNode> subInstances = new ArrayList<>();
		public boolean multivalue;
	}
	
	public String fileName;
	
	public InstanceNode rootNode;

	public String subDirectory;

}
