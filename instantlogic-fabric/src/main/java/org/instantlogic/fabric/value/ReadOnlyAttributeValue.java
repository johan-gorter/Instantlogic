

package org.instantlogic.fabric.value;


import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.util.ValueChangeObserver;

// TODO: Rename AttributeValue to InstanceValue everywhere
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
