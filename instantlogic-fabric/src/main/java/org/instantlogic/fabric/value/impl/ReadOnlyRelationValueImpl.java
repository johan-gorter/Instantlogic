

package org.instantlogic.fabric.value.impl;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;


public class ReadOnlyRelationValueImpl<I extends Instance, Value extends Object> 
	extends ReadOnlyAttributeValueImpl<I, Value>
	implements ReadOnlyRelationValue<I, Value>{

	public ReadOnlyRelationValueImpl(I forInstance,
			Attribute<I, Value, ? extends Object> model) {
		super(forInstance, model);
	}
	
	@Override
	public Relation<I, Value, ? extends Object> getModel() {
		return (Relation<I, Value, ? extends Object>) super.getModel();
	}
	
}
