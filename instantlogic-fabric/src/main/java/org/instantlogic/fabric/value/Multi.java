

package org.instantlogic.fabric.value;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Multi<T> implements Iterable<T> {

	protected List<T> items = new ArrayList<T>();
	private List<T> readOnlyItems;

	public Multi(List<T> items) {
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
		return asList().iterator();
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
