

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
