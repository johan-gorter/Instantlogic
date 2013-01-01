package org.instantlogic.engine.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FragmentQuery {
	
	public static interface Selector {
		
		public boolean matches(Map<String, Object> fragment);
		
	}
	
	public static class ExactValue implements Selector {

		private final String key;
		private final Object value;
		
		
		public ExactValue(String key, Object value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public boolean matches(Map<String, Object> fragment) {
			Object fragmentValue = fragment.get(key);
			if (fragmentValue!=null && fragmentValue.equals(value)) {
				return true;
			}
			return false;
		}
	}

	public static Map<String, Object> findOnly(Map<String, Object> fragment, Selector selector) {
		List<Map<String,Object>> all = findAll(fragment, selector);
		if (all.size()==1) {
			return all.get(0);
		}
		if (all.size()==0) {
			throw new RuntimeException("Fragment was not found");
		} else {
			throw new RuntimeException(all.size()+" fragments were found");
		}
	}
	
	public static List<Map<String, Object>> findAll(Map<String, Object> fragment, Selector selector) {
		List<Map<String,Object>> results = new ArrayList<Map<String, Object>>();
		findAll(fragment, selector, results);
		return results;
	}
	
	@SuppressWarnings("unchecked")
	private static void findAll(Map<String, Object> fragment, Selector selector, List<Map<String, Object>> results) {
		if (selector.matches(fragment)) {
			results.add(fragment);
		}
		for(Entry<String, Object> entry : fragment.entrySet()) {
			if (entry.getValue() instanceof List<?>) {
				for(Object item : ((List<?>)entry.getValue())) {
					if (item instanceof Map<?,?>) {
						findAll((Map<String, Object>) item, selector, results);
					}
				}
			}
		}
	}
}
