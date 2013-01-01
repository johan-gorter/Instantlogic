package org.instantlogic.fabric.deduction;


import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

// If the input is the specified subclass, the input is returned, otherwise null is returned 
public class CastInstanceDeduction<I extends Instance, V extends Instance> extends Deduction<V> { // V extends I

	public static <I extends Instance, V extends Instance> CastInstanceDeduction<I, V> create(Entity<V> entity, Deduction<I> instanceDeduction) {
		return new CastInstanceDeduction<I, V>(entity, instanceDeduction);
	}
	
	private Deduction<I> instanceDeduction;
	private Entity<V> toEntity;

	public CastInstanceDeduction(Entity<V> toEntity, Deduction<I> instanceDeduction) {
		this.instanceDeduction = instanceDeduction;
		this.toEntity = toEntity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ValueAndLevel<V> deduct(DeductionContext context) {
		ValueAndLevel<I> candidate = instanceDeduction.deduct(context);
		if (Entity.extendsFrom(candidate.getValue().getMetadata().getEntity(), toEntity)) {
			return ValueAndLevel.rule((V)candidate.getValue());
		}
		return ValueAndLevel.rule(null);
	}
}
