

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
