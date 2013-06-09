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
