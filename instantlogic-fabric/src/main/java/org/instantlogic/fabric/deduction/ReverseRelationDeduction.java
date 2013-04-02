/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.fabric.deduction;


import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

/*
 * Return value can either be a 
 *   ReverseRelationDeduction<From, To>
 * or a 
 *   ReverseRelationDeduction<Multi<From>, To>
 */
public class ReverseRelationDeduction<From extends Instance, Item extends Object, To extends Instance, ReverseItem extends Object> extends Deduction<ReverseItem> {

	private Relation<From, Item, To> relation;
	private Deduction<To> toInstance;
	

	public ReverseRelationDeduction() {
	}
	
	public ReverseRelationDeduction(Relation<From, Item, To> relation) {
		this.relation = relation;
	}

	public void setRelation(Relation<From, Item, To> relation) {
		this.relation = relation;
	}

	public void setToInstance(Deduction<To> toInstance) {
		this.toInstance = toInstance;
	}
	
	@Deprecated
	public void addToInputs(Deduction<To> toInstance) {
		this.toInstance = toInstance;
	}

	@Override
	protected ValueAndLevel<ReverseItem> execute(DeductionContext context) {
		ValueAndLevel<To> instanceValue = toInstance.deduce(context);
		if (instanceValue.getValue()==null) {
			//TODO: think carefully before throwing this out: throw new RuntimeException("No instance while getting value for attribute "+attribute+" on entity "+attribute.getEntity()+", context: "+context.printDiagnostics());
			return ValueAndLevel.inconclusive();
		}
		return (ValueAndLevel<ReverseItem>) relation.getReverseRelation().get(instanceValue.getValue()).getValueAndLevel();
	}
}
