package org.instantlogic.fabric.deduction;


import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

// If the input is the specified subclass, the input is returned, otherwise null is returned 
public class CastInstanceDeduction<I extends Instance, V extends Instance> extends Deduction<V> { // V extends I

	private Deduction<I> instance;
	private Entity<V> toEntity;

	public CastInstanceDeduction() {
	}

	public CastInstanceDeduction(Entity<V> toEntity) {
		this.toEntity = toEntity;
	}

	public void setToEntity(Entity<V> toEntity) {
		this.toEntity = toEntity;
	}

	public void setInstance(Deduction<I> instance) {
		this.instance = instance;
	}

	@Deprecated
	public void addToInputs(Deduction<I> instance) {
		this.instance = instance;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected ValueAndLevel<V> execute(DeductionContext context) {
		ValueAndLevel<I> candidate = instance.deduce(context);
		if (Entity.extendsFrom(candidate.getValue().getMetadata().getEntity(), toEntity)) {
			return ValueAndLevel.rule((V)candidate.getValue());
		}
		return ValueAndLevel.rule(null);
	}
}
