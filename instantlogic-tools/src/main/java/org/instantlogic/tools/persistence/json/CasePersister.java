/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.tools.persistence.json;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.instantlogic.fabric.Instance;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CasePersister {

	public static final Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd")
				.setPrettyPrinting()
				.registerTypeHierarchyAdapter(Instance.class, new GsonInstanceAdapter()).create();

	public void save(Instance caseInstance, OutputStreamWriter writer) {
		gson.toJson(caseInstance, writer);
	}
	
	public <T> T load(Class<T> ofType, InputStreamReader reader) {
		return gson.fromJson(reader, ofType);
	}
}
