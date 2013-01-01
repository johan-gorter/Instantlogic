package org.instantlogic.fabric.value.impl;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.value.Multi;
import org.instantlogic.fabric.value.ReadOnlyAttributeValues;

public class ReadOnlyAttributeValuesImpl<I extends Instance, Item extends Object> 
	extends ReadOnlyAttributeValueImpl<I, Multi<Item>>
	implements ReadOnlyAttributeValues<I, Item>{

	public ReadOnlyAttributeValuesImpl(I forInstance,
			Attribute<I, Multi<Item>, ? extends Object> model) {
		super(forInstance, model);
	} 

}
