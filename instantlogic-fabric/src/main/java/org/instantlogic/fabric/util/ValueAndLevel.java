

package org.instantlogic.fabric.util;

public class ValueAndLevel<V extends Object> {
	
	private V value;
	private ValueLevel valueLevel;
	
	public static <V> ValueAndLevel<V> irrelevant() {
		return new ValueAndLevel<V>(null, ValueLevel.IRRELEVANT);
	}

	public static <V> ValueAndLevel<V> rule(V value) {
		return new ValueAndLevel<V>(value, ValueLevel.RULE);
	}
	
	public static <V> ValueAndLevel<V> stored(V value) {
		if (value==null) throw new IllegalArgumentException("value");
		return new ValueAndLevel<V>(value, ValueLevel.STORED);
	}
	
	/**
	 * def is short for default (default is a reserved word in Java)
	 */
	public static <V> ValueAndLevel<V> def(V value) {
		return new ValueAndLevel<V>(value, ValueLevel.DEFAULT);
	}
	
	public static <V> ValueAndLevel<V> inconclusive() {
		return new ValueAndLevel<V>(null, ValueLevel.INCONCLUSIVE);
	}
	
	private ValueAndLevel(V value, ValueLevel valueLevel) {
		this.value = value;
		this.valueLevel = valueLevel;
	}

	public V getValue() {
		return value;
	}

	public ValueLevel getValueLevel() {
		return valueLevel;
	}
	
	public boolean isConclusive() {
		return valueLevel!=ValueLevel.INCONCLUSIVE;
	}

	public boolean hasValue() {
		return value!=null;
	}
	
	@Override
	public String toString() {
		return ""+value+" ("+valueLevel.toString().toLowerCase()+")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		result = prime * result
				+ ((valueLevel == null) ? 0 : valueLevel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		ValueAndLevel<V> other = (ValueAndLevel<V>) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		if (valueLevel != other.valueLevel)
			return false;
		return true;
	}
}
