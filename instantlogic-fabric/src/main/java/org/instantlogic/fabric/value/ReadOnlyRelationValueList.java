package org.instantlogic.fabric.value;

import org.instantlogic.fabric.Instance;

public interface ReadOnlyRelationValueList<I extends Instance, To extends Instance> 
	extends ReadOnlyAttributeValueList<I, To>,  ReadOnlyRelationValue<I, ValueList<To>>{
}
