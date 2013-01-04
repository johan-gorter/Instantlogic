/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

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
		checkCase(value);
		super.setValue(value);
	}

	private void checkCase(To value) { // Copy in RelationValuesImpl
		if (!model.isOwner() && value!=null && !value.getMetadata().isStatic()) {
			if (value.getMetadata().getCaseAdministration()!=forInstance.getMetadata().getCaseAdministration()) {
				throw new IllegalArgumentException("The value "+value+" is not owned by the "+forInstance.getMetadata().getCase().getMetadata().getEntity().getName()+" the "+forInstance+" belongs to");
			}
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ValueAndLevel<To> getValueAndLevel() {
		ValueAndLevel<To> result = super.getValueAndLevel();
		if (!result.isConclusive() && model.isAutoCreate()) {
			// 1 on 1 aggregation, is now silently lazily created
			To resultValue = (To) model.createTo(forInstance);
			setStoredValue(resultValue);
			invalidateCachedValue();
			forInstance.getMetadata().adopt(resultValue);
			if (model.getReverseRelation()!=null) {
				ReadOnlyAttributeValue<To, ? extends Object> newReverseRelationValue = model.getReverseRelation().get(resultValue);
				if (getModel().getReverseRelation().isMultivalue()) {
					((ReverseRelationValuesImpl)newReverseRelationValue).internalAddReverse(forInstance, null);
				} else {
					((ReverseRelationValueImpl)newReverseRelationValue).internalSetReverse(forInstance, null);
				}
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
