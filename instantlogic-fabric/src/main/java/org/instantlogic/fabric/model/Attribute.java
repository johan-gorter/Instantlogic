package org.instantlogic.fabric.model;

import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.deduction.AttributeDeduction;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.deduction.SelectedInstanceDeduction;
import org.instantlogic.fabric.text.TextTemplate;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;

/**
 * Can be compared to a field of an Object, only more powerful.
 *  
 * @param <I>
 * @param <Value> Either the same as <Item> or List<Item>
 * @param <Item>
 */
public abstract class Attribute<I extends Instance, Value extends Object, Item extends Object> extends Concept {

	private static final Validation[] NO_VALIDATIONS = new Validation[0];
	public abstract Entity<I> getEntity();
	
	public abstract Class<Item> getJavaClassName();

	public abstract TextTemplate getQuestion();

	public Validation[] getValidations() {
		return NO_VALIDATIONS;
	}
	
	public TextTemplate getExplain() {
		return null;
	}

	public boolean isMultivalue() {
		return false;
	}

	/**
	 * @return a list of data type characteristics, like [category = number, exactRounding = true, decimalPlaces = 2, unitPrefix = $] or [category = text, multiline = true, formatted = true]
	 */
	public Map<String, Object> getDataType() {
		return null;
	}
	
	public boolean isReadOnly() {
		return false;
	}

	public Deduction<Boolean> getRelevance() {
		return null;
	}
	
	public Deduction<Value> getRule() {
		return null;
	}
	
	public Deduction<Value> getDefault() {
		return null;
	}
	
	public abstract ReadOnlyAttributeValue<I, Value> get(I instance);
	
	public AttributeDeduction<Value, I> toDeduction() {
		SelectedInstanceDeduction<I> selectedInstanceDeduction = new SelectedInstanceDeduction<I>(this.getEntity());
		return new AttributeDeduction<Value, I>((Attribute<I, Value, ? extends Object>) this, selectedInstanceDeduction);
	}
}
