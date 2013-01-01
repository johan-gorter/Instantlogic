package org.instantlogic.designer.util;

public class LazyReference<T> {

	private T reference;

	public T get() {
		return reference;
	}

	public void init(T reference) {
		this.reference = reference;
	}
}
