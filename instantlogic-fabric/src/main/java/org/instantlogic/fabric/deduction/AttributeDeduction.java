package org.instantlogic.fabric.deduction;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class AttributeDeduction<V> extends Deduction<V> {

	private Attribute<? extends Instance, V, ? extends Object> attribute;
	
	public void setAttribute(Attribute<? extends Instance, V, ? extends Object> attribute) {
		if (attribute==null) 
			throw new IllegalArgumentException();
		this.attribute = attribute;
	}

	private Deduction<? extends Instance> instance;
	
	public void setInstance(Deduction<? extends Instance> instance) {
		if (instance==null) throw new IllegalArgumentException();
		this.instance = instance;
	}
	
	public AttributeDeduction() {
	}
	
	public AttributeDeduction(Attribute<? extends Instance, V, ? extends Object> attribute) {
		if (attribute==null) throw new IllegalArgumentException();
		this.attribute = attribute;
	}

	public AttributeDeduction(Deduction<? extends Instance> instance, Attribute<? extends Instance, V, ? extends Object> attribute) {
		if (attribute==null) throw new IllegalArgumentException();
		this.attribute = attribute;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected ValueAndLevel<V> execute(DeductionContext context) {
		ValueAndLevel<? extends Instance> instanceValue = instance.deduce(context);
		if (instanceValue.getValue()==null) {
			//TODO: think carefully before throwing this out: throw new RuntimeException("No instance while getting value for attribute "+attribute+" on entity "+attribute.getEntity()+", context: "+context.printDiagnostics());
			return ValueAndLevel.inconclusive();
		}
		return ((Attribute)attribute).get(instanceValue.getValue()).getValueAndLevel();
	}

	@Deprecated
	public static <V, I extends Instance> Deduction<V> create(Attribute<I, V, ?> attribute, Deduction<I> instance) {
		AttributeDeduction<V> result = new AttributeDeduction<V>(instance, attribute);
		return result;
	}

	@Deprecated
	public void addToInputs(Deduction<? extends Instance> input) {
		setInstance(input);
	}
}
