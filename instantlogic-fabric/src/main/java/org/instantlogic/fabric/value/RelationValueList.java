package org.instantlogic.fabric.value;

import org.instantlogic.fabric.Instance;


public interface RelationValueList<I extends Instance, Item extends Instance> 
	extends AttributeValueList<I, Item>, ReadOnlyRelationValueList<I, Item>
{

}
