/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

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
