package org.instantlogic.fabric.value;

import org.instantlogic.fabric.Instance;

public interface ReadOnlyRelationValues<I extends Instance, To extends Instance> 
	extends ReadOnlyAttributeValues<I, To>,  ReadOnlyRelationValue<I, Multi<To>>{
}
