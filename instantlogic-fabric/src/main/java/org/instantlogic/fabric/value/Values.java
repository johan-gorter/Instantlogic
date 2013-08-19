package org.instantlogic.fabric.value;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * Contains only the readonly methods from Collection<T>
 */
public class Values<T> implements Iterable<T>{

	private Collection<T> readOnlySource;
	private Collection<T> source;

	public Values(Collection<T> source) {
		this.source = source;
		this.readOnlySource = Collections.unmodifiableCollection(source);
	}
	
	@Override
	public Iterator<T> iterator() {
		return readOnlySource.iterator();
	}
	
	public boolean contains(T item) {
		return source.contains(item);
	}
	
	public int size() {
		return source.size();
	}
}
