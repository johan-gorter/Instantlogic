package org.instantlogic.fabric.value.impl;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.value.ValueList;
import org.instantlogic.fabric.value.ReadOnlyAttributeValueList;

public class ReadOnlyAttributeValueListImpl<I extends Instance, Item extends Object> 
	extends ReadOnlyAttributeValueImpl<I, ValueList<Item>>
	implements ReadOnlyAttributeValueList<I, Item>{

	public ReadOnlyAttributeValueListImpl(I forInstance,
			Attribute<I, ValueList<Item>, ? extends Object> model) {
		super(forInstance, model);
	} 

}
