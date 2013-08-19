package org.instantlogic.fabric.value.impl;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.value.RelationValues;
import org.instantlogic.fabric.value.Values;


public class RelationValuesImpl<I extends Instance, To extends Instance>
	extends AttributeValuesImpl<I, To>
	implements RelationValues<I, To> {

	private Relation<I, Values<To>, To> model;
	
	public RelationValuesImpl(I forInstance, Relation<I, Values<To>, To> model) {
		super(forInstance, model);
		this.model = model;
	}
	
	@Override
	public Relation<I, Values<To>, To> getModel() {
		return (Relation<I, Values<To>, To>) model;
	}
	
	@Override
	protected void beforeFiringChange(ValueChangeEvent event) {
		RelationValueUtil.adoptOrReject(event, model, forInstance);
		super.beforeFiringChange(event);
		RelationValueUtil.updateReverse(event, model, forInstance);
	};
	
	@Override
	public void addValue(To item) {
		RelationValueUtil.checkCase(item, model, forInstance);
		super.addValue(item);
	}
}
