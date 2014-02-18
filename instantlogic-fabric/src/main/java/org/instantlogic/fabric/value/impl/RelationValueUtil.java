package org.instantlogic.fabric.value.impl;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeEvent.MultiValueUpdateType;
import org.instantlogic.fabric.value.WriteableAttributeValue;

class RelationValueUtil {

	@SuppressWarnings("rawtypes")
	static void checkCase(Instance value, Relation model, Instance forInstance) { // Copy in RelationValueImpl
		if (!model.isOwner() && value!=null && !value.getMetadata().isStatic()) { 
			if (value.getMetadata().getCaseAdministration()!=forInstance.getMetadata().getCaseAdministration()) {
				throw new IllegalArgumentException("The item "+value+" is not owned by the "+forInstance.getMetadata().getCase().getMetadata().getEntity().getName()+" the "+forInstance+" belongs to");
			}
		}
	};
	
	@SuppressWarnings("rawtypes")
	static void adoptOrReject(ValueChangeEvent event, Relation model, Instance forInstance, WriteableAttributeValue<?, ?, ?> relationValue) {
		MultiValueUpdateType type = event.getMultiValueUpdateType();
		Instance item = (Instance) event.getItemValue();
		if (model.isOwner()) {
			if (type == MultiValueUpdateType.INSERT) {
				forInstance.getMetadata().adopt(item, relationValue);
			} else { // Remove
				forInstance.getMetadata().reject(item);
			}
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static void updateReverse(ValueChangeEvent event, Relation model, Instance forInstance) {
		MultiValueUpdateType type = event.getMultiValueUpdateType();
		Instance item = (Instance) event.getItemValue();
		Operation operation = event.getOperation();
		if (model.getReverseRelation()!=null) {
			if (type == MultiValueUpdateType.INSERT) {
				if (model.getReverseRelation().isMultivalue()) {
					((ReverseRelationValuesImpl)model.getReverseRelation().get(item)).internalAddReverse(forInstance, operation);
				} else {
					((ReverseRelationValueImpl)model.getReverseRelation().get(item)).internalSetReverse(forInstance, operation);
				}
			} else { // Remove
				if (model.getReverseRelation().isMultivalue()) {
					((ReverseRelationValuesImpl)model.getReverseRelation().get(item)).internalRemoveReverse(forInstance, operation);
				} else {
					((ReverseRelationValueImpl)model.getReverseRelation().get(item)).internalSetReverse(null, operation);
				}
			}
		}
	}
}
