package org.instantlogic.fabric.deduction;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class SelectedInstanceDeduction<I extends Instance> extends Deduction<I>{
	
	private Entity<I> entity;
	
	public void setEntity(Entity<I> entity) {
		this.entity = entity;
	}

	public SelectedInstanceDeduction()
	{
	}

	@Deprecated
	public SelectedInstanceDeduction(Entity<I> entity) {
		this.entity = entity;
	}

	@Override
	protected ValueAndLevel<I> execute(DeductionContext context) {
		return ValueAndLevel.rule((I)context.getSelectedInstance(entity));
	}

	@Deprecated
	public static <X extends Instance> Deduction<X> create(Entity<X> entity) {
		SelectedInstanceDeduction<X> result = new SelectedInstanceDeduction<X>(entity);
		return result ;
	}
}
