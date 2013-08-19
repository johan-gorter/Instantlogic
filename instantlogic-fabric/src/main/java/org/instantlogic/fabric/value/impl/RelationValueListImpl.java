package org.instantlogic.fabric.value.impl;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.value.RelationValueList;
import org.instantlogic.fabric.value.ValueList;


public class RelationValueListImpl<I extends Instance, To extends Instance>
	extends AttributeValueListImpl<I, To>
	implements RelationValueList<I, To> {

	private Relation<I, ValueList<To>, To> model;
	
	public RelationValueListImpl(I forInstance, Relation<I, ValueList<To>, To> model) {
		super(forInstance, model);
		this.model = model;
	}
	
	@Override
	public Relation<I, ValueList<To>, To> getModel() {
		return (Relation<I, ValueList<To>, To>) model;
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
	
	@Override
	public void insertValue(To item, int index) {
		RelationValueUtil.checkCase(item, model, forInstance);
		super.insertValue(item, index);
	};
}
