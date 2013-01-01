package org.instantlogic.fabric.deduction;


import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class SelectedInstanceDeduction<V extends Instance> extends Deduction<V> {

	public static <V extends Instance> SelectedInstanceDeduction<V> create(Entity<V> entity) {
		return new SelectedInstanceDeduction<V>(entity);
	}
	
	private Entity<V> ofEntity;

	public SelectedInstanceDeduction(Entity<V> entity) {
		this.ofEntity = entity;
	}
	
	@Override
	public ValueAndLevel<V> deduct(DeductionContext context) {
		return ValueAndLevel.rule((V)context.getSelectedInstance(ofEntity)); // Will throw an exception if no such entity is selected. (This should have been validated at design time)
	}

}
