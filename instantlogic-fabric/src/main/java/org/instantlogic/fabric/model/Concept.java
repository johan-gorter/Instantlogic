/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

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
