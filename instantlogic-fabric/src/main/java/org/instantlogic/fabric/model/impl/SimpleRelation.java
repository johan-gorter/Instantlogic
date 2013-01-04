/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.fabric.model.impl;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;


public abstract class SimpleRelation<I extends Instance, Value extends Object, To extends Instance> extends Relation<I, Value, To> {

	private final String name;
	private final Entity<I> entity;
	private final Entity<To> to;
	private final Class<To> valueClass;
	private Relation<To, ? extends Object,I> reverseRelation;
	
	
	public SimpleRelation(String name, Entity<I> entity, Entity<To> to, 
			Class<To> valueClass, Relation<To, ? extends Object,I> reverseRelation) {
		this.name = name;
		this.entity = entity;
		this.to = to;
		this.valueClass = valueClass;
		this.reverseRelation = reverseRelation;
		if (reverseRelation!=null) {
			reverseRelation.setReverseRelation(this);
		}
	}
	
	public String getName() {
		return name;
	}

	@Override
	public Entity<To> getTo() {
		return to;
	}

	@Override
	public boolean isOwner() {
		return false;
	}
	
	@Override
	public boolean isAutoCreate() {
		return false;
	}

	@Override
	public boolean isMultivalue() {
		return false;
	}
	
	@Override
	public boolean isReverse() {
		return false;
	}
	
	/* Needed for bootstrapping */
	@Override
	public void setReverseRelation(Relation<To, ? extends Object, I> reverse) {
		this.reverseRelation = reverse;
	}

	@Override
	public Relation<To, ? extends Object,I> getReverseRelation() {
		return reverseRelation;
	}


	@Override
	public Entity<I> getEntity() {
		return entity;
	}
	
	public To createTo(I from) {
		To result = (To)getTo().createInstance();
		return result;
	};
	
	@Override
	public Class<To> getJavaClassName() {
		return valueClass;
	}
}
