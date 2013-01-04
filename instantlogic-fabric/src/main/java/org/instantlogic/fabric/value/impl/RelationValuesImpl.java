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
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeEvent.MultiValueUpdateType;
import org.instantlogic.fabric.value.Multi;
import org.instantlogic.fabric.value.RelationValues;


public class RelationValuesImpl<I extends Instance, To extends Instance>
	extends AttributeValuesImpl<I, To>
	implements RelationValues<I, To> {

	private Relation<I, Multi<To>, To> model;
	
	public RelationValuesImpl(I forInstance, Relation<I, Multi<To>, To> model) {
		super(forInstance, model);
		this.model = model;
	}
	
	@Override
	public Relation<I, Multi<To>, To> getModel() {
		return (Relation<I, Multi<To>, To>) model;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void beforeFiringChange(ValueChangeEvent event) {
		MultiValueUpdateType type = event.getMultiValueUpdateType();
		To item = (To) event.getItemValue();
		Operation operation = event.getOperation();
		if (model.isOwner()) {
			if (type == MultiValueUpdateType.INSERT) {
				forInstance.getMetadata().adopt(item);
			} else { // Remove
				forInstance.getMetadata().reject(item);
			}
		}
		super.beforeFiringChange(event);
		if (model.getReverseRelation()!=null) {
			if (type == MultiValueUpdateType.INSERT) {
				if (getModel().getReverseRelation().isMultivalue()) {
					((ReverseRelationValuesImpl)model.getReverseRelation().get(item)).internalAddReverse(forInstance, operation);
				} else {
					((ReverseRelationValueImpl)model.getReverseRelation().get(item)).internalSetReverse(forInstance, operation);
				}
			} else { // Remove
				if (getModel().getReverseRelation().isMultivalue()) {
					((ReverseRelationValuesImpl)model.getReverseRelation().get(item)).internalRemoveReverse(forInstance, operation);
				} else {
					((ReverseRelationValueImpl)model.getReverseRelation().get(item)).internalSetReverse(null, operation);
				}
			}
		}
	};
	
	@Override
	public void addValue(To item) {
		checkCase(item);
		super.addValue(item);
	}
	
	@Override
	public void insertValue(To item, int index) {
		checkCase(item);
		super.insertValue(item, index);
	};

	private void checkCase(To value) { // Copy in RelationValueImpl
		if (!model.isOwner() && value!=null && !value.getMetadata().isStatic()) { 
			if (value.getMetadata().getCaseAdministration()!=forInstance.getMetadata().getCaseAdministration()) {
				throw new IllegalArgumentException("The item "+value+" is not owned by the "+forInstance.getMetadata().getCase().getMetadata().getEntity().getName()+" the "+forInstance+" belongs to");
			}
		}
	};
}
