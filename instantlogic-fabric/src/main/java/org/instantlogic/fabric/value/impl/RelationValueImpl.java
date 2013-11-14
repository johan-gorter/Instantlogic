package org.instantlogic.fabric.value.impl;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;
import org.instantlogic.fabric.value.RelationValue;


public class RelationValueImpl<I extends Instance, To extends Instance> 
	extends AttributeValueImpl<I, To> 
	implements RelationValue<I, To>{

	private final Relation<I, To, To> model;
	private final I forInstance;

	public RelationValueImpl(I forInstance, Relation<I, To, To> model) {
		super(forInstance, model);
		this.forInstance = forInstance;
		this.model = model;
	}
	
	@Override
	public void setValue(To value) {
		RelationValueUtil.checkCase(value, model, forInstance);
		super.setValue(value);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ValueAndLevel<To> getValueAndLevel() {
		ValueAndLevel<To> result = super.getValueAndLevel();
		if (!result.isConclusive() && model.isAutoCreate()) {
			// 1 on 1 aggregation, is now silently lazily created
			Operation operation = forInstance.getMetadata().getCaseAdministration().startOperation();
			To resultValue = (To) model.createTo(forInstance);
			try {
				setStoredValue(resultValue);
				invalidateCachedValue();
				// happens during valueChanged: forInstance.getMetadata().adopt(resultValue);
				fireValueChanged((ValueAndLevel)ValueAndLevel.inconclusive(), null, resultValue, operation);
				if (model.getReverseRelation()!=null) {
					ReadOnlyAttributeValue<To, ? extends Object> newReverseRelationValue = model.getReverseRelation().get(resultValue);
					if (getModel().getReverseRelation().isMultivalue()) {
						((ReverseRelationValuesImpl)newReverseRelationValue).internalAddReverse(forInstance, null);
					} else {
						((ReverseRelationValueImpl)newReverseRelationValue).internalSetReverse(forInstance, null);
					}
				}
				operation.complete();
			} finally {
				operation.close();
			}
			return ValueAndLevel.stored(resultValue);
		}
		return result;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void beforeFiringChange(ValueChangeEvent event) {
		To oldStoredValue = (To) event.getOldStoredValue();
		To newStoredValue = (To) event.getNewStoredValue();
		Operation operation = event.getOperation();
		super.beforeFiringChange(event);
		if (model.isOwner()) {
			if (oldStoredValue!=null) {
				forInstance.getMetadata().reject(oldStoredValue);
			}
			if (newStoredValue!=null) {
				forInstance.getMetadata().adopt(newStoredValue);
			}
		}
		if (model.getReverseRelation()!=null) {
			if (oldStoredValue!=null) {
				ReadOnlyAttributeValue<To, ? extends Object> oldReverseRelationValue = model.getReverseRelation().get(oldStoredValue);
				if (getModel().getReverseRelation().isMultivalue()) {
					((ReverseRelationValuesImpl)oldReverseRelationValue).internalRemoveReverse(forInstance, operation);
				} else {
					((ReverseRelationValueImpl)oldReverseRelationValue).internalSetReverse(null, operation);
				}
			}
			if (newStoredValue!=null) {
				ReadOnlyAttributeValue<To, ? extends Object> newReverseRelationValue = model.getReverseRelation().get(newStoredValue);
				if (getModel().getReverseRelation().isMultivalue()) {
					((ReverseRelationValuesImpl)newReverseRelationValue).internalAddReverse(forInstance, operation);
				} else {
					((ReverseRelationValueImpl)newReverseRelationValue).internalSetReverse(forInstance, operation);
				}
			}
		}
	}
	
	public Relation<I, To, To> getModel() {
		return model;
	}
}
