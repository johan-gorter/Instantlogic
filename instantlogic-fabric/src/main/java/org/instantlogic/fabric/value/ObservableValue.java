package org.instantlogic.fabric.value;

import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.util.ValueChangeObserver;

public interface ObservableValue<Value extends Object> {
	
	Value getValue();
	
	ValueAndLevel<Value> getValueAndLevel();
	
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
