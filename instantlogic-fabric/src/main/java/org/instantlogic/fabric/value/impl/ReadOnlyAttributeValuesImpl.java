package org.instantlogic.fabric.value.impl;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.value.ReadOnlyAttributeValues;
import org.instantlogic.fabric.value.Values;

public class ReadOnlyAttributeValuesImpl<I extends Instance, Item extends Object> 
	extends ReadOnlyAttributeValueImpl<I, Values<Item>>
	implements ReadOnlyAttributeValues<I, Item>{

	public ReadOnlyAttributeValuesImpl(I forInstance, Attribute<I, Values<Item>, ? extends Object> model) {
		super(forInstance, model);
	} 

}
