

package org.instantlogic.fabric.model;


/**
 * Baseclass for Entity, Attribute etc.
 */
public abstract class Concept implements Comparable<Concept> {
	
	public abstract String getName();
	
	public String getUniqueId() {
		throw new RuntimeException("TODO");
	}
	
	@Override
	public int compareTo(Concept o) {
		String n1 = getName();
		String n2 = o.getName();
		if (n1==null || n2==null) {
			if (n1==n2) return 0;
			return n1==null?-1:1;
		}
		return n1.compareTo(n2);
	}
	
	@Override
	public String toString() {
		return getName();
	}

}
