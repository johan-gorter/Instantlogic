/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.fabric.value;


import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.util.ValueChangeObserver;


public interface ReadOnlyAttributeValue<I extends Instance, Value extends Object> extends ObservableValue<Value> {

	Attribute<I, Value, ? extends Object> getModel();
	
	I getInstance();
	
	Value getValue();
	
	ValueAndLevel<Value> getValueAndLevel();
	
	boolean hasStoredValue();
	
	public void addValueChangeObserver(ValueChangeObserver observer);

	public void removeValueChangeObserver(ValueChangeObserver observer);

	/**
	 * The observer will only be called once, when the value changes again.
	 * 
	 * @param observer The observer which will receive the callback.
	 */
	public void addNextValueChangeObserver(ValueChangeObserver observer);

	public void removeNextValueChangeObserver(ValueChangeObserver observer);
}
