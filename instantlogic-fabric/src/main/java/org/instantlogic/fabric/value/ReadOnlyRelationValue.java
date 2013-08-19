package org.instantlogic.fabric.value;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Relation;


// Value: Values<Instance>, ValueList<Instance> or Instance
public interface ReadOnlyRelationValue<I extends Instance, Value extends Object> 
	extends ReadOnlyAttributeValue<I, Value> {

	Relation<I, Value, ? extends Object> getModel();
	
}
