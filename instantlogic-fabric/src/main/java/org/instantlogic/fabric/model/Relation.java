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

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.text.TextTemplate;


public abstract class Relation<I extends Instance, Value extends Object, To extends Instance> extends Attribute<I, Value, To> {
	
	public abstract Entity<To> getTo();
	
	public abstract boolean isOwner(); // Delete cascades

	public abstract boolean isAutoCreate(); // Create cascades also (only valid if isOwner and !isMultivalue)
	
	public abstract boolean isMultivalue();
	
	public abstract boolean isReverse();
	
	public abstract void setReverseRelation(Relation<To, ? extends Object, I> reverse);
	
	public abstract Relation<To, ? extends Object, I> getReverseRelation();
	
	public abstract To createTo(I from);
	
	@Override
	public abstract TextTemplate getQuestion();
	
	// This is meant to be used to fill the options of a dropdown.
	public abstract Deduction<? extends Iterable<To>> getOptions();
}
