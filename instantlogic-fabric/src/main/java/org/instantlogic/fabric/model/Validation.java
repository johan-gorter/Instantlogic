

package org.instantlogic.fabric.model;

import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.text.TextTemplate;

public abstract class Validation {
	
	public abstract TextTemplate getMessage();
	
	public abstract Deduction<Boolean> getRule();
}
