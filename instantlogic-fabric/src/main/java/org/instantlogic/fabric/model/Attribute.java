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

import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.deduction.AttributeDeduction;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.deduction.SelectedInstanceDeduction;
import org.instantlogic.fabric.text.TextTemplate;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;

/**
 * Can be compared to a field of an Object, only more powerful.
 *  
 * @param <I>
 * @param <Value> Either the same as <Item> or List<Item>
 * @param <Item>
 */
public abstract class Attribute<I extends Instance, Value extends Object, Item extends Object> extends Concept {

	public abstract Entity<I> getEntity();
	
	public abstract Class<Item> getJavaClassName();

	public abstract TextTemplate getQuestion();

	public abstract Validation[] getValidations();
	
	public abstract boolean isMultivalue();

	/**
	 * @return a list of data type characteristics, like [category = number, exactRounding = true, decimalPlaces = 2, unitPrefix = $] or [category = text, multiline = true, formatted = true]
	 */
	public abstract Map<String, Object> getDataType();
	
	public abstract boolean isReadOnly();

	public abstract Deduction<Boolean> getRelevance();
	
	public abstract Deduction<Value> getRule();
	
	public abstract Deduction<Value> getDefault();
	
	public abstract ReadOnlyAttributeValue<I, Value> get(I instance);
	
	public AttributeDeduction<Value> toDeduction() {
		SelectedInstanceDeduction<I> selectedInstanceDeduction = new SelectedInstanceDeduction<I>();
		selectedInstanceDeduction.setOfEntity(this.getEntity());
		AttributeDeduction<Value> result = new AttributeDeduction<Value>(this);
		result.setInstance(selectedInstanceDeduction);
		return result;
	}
}
