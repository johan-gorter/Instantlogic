package org.instantlogic.fabric.value;

import org.instantlogic.fabric.Instance;


public interface RelationValues<I extends Instance, Item extends Instance> 
	extends AttributeValues<I, Item>, ReadOnlyRelationValues<I, Item>
{

}
