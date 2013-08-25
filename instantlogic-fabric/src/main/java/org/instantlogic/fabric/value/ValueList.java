package org.instantlogic.fabric.value;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 
 * Contains only the read methods from List<T>
 */
public class ValueList<T> extends Values<T> {

	protected List<T> items = new ArrayList<T>();
	private List<T> readOnlyItems;

	public ValueList(List<T> items) {
		super(items);
		this.items = items;
		this.readOnlyItems = Collections.unmodifiableList(items);
	}
	
	
	public List<T> asList() {
		return readOnlyItems;
	}
	
	public boolean contains(T item) {
		return items.contains(item);
	}
	
	public int size() {
		return items.size();
	}

	@Override
	public Iterator<T> iterator() {
		return readOnlyItems.iterator();
	}
	
	public ListIterator<T> listIterator() {
		return readOnlyItems.listIterator();
	}

	public T get(int i) {
		return items.get(i);
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (T item : items) {
			if (sb.length()>1) sb.append(",");
			sb.append(item);
		}
		sb.append("]");
		return sb.toString();
	}
}
