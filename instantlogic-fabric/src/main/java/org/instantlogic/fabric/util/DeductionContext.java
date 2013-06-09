

package org.instantlogic.fabric.util;

import java.util.List;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;


public abstract class DeductionContext {

	public abstract <I extends Instance> I getSelectedInstance(Entity<I> entity);
	
	// Convenience methods
	
	public <I extends Instance, Value extends Object> Value getValue(Entity<I> entity, Attribute<I, Value, ? extends Object> attribute) {
		return getAttributeValue(entity, attribute).getValue();
	}
	
	public <I extends Instance, Value extends Object> ReadOnlyAttributeValue<I, Value> getAttributeValue(Entity<I> entity, Attribute<I, Value, ? extends Object> attribute) {
		I instance = (I) getSelectedInstance(entity);
		if (instance==null) {
			throw new RuntimeException("No selected instance of type "+entity+" in scope while evaluating attribute "+attribute.getName());
		}
		return attribute.get(instance);
	}

	/**
	 * Add the selected instances in reverse order to result.
	 * @param result the list to append to
	 */
	protected abstract void addSelectedInstances(List<Instance> result);

	public abstract String printDiagnostics();

}
