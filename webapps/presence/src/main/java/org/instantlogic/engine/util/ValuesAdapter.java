package org.instantlogic.engine.util;

import java.lang.reflect.Type;

import org.instantlogic.fabric.value.Values;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

@SuppressWarnings("rawtypes")
public class ValuesAdapter implements JsonSerializer<Values>{

	@Override
	public JsonElement serialize(Values src, Type typeOfSrc, JsonSerializationContext context) {
		return context.serialize(src.asCollection());
	}
}
