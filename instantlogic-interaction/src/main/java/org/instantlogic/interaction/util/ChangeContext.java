package org.instantlogic.interaction.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.AttributeValues;
import org.instantlogic.interaction.Application;

import com.google.gson.Gson;
import com.google.gson.JsonElement;


public class ChangeContext extends RenderContext {

	public static ChangeContext create(Application application, String path, Instance caseInstance, String caseId, String pageElementId, JsonElement value, TravelerInfo travelerInfo) {
		FlowContext flowContext = FlowContext.create(application, path, caseInstance, caseId, travelerInfo);
		return new ChangeContext(flowContext, path, pageElementId, value);
	}
	
	private String pageElementId;
	private JsonElement value;

	public ChangeContext(FlowContext flowContext, String pageCoordinates, String pageElementId, JsonElement value) {
		super(flowContext, pageCoordinates);
		this.pageElementId = pageElementId;
		this.value = value;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setValue(Entity entity, Attribute attribute, JsonElement value) {
		if (attribute.isMultivalue()) {
			AttributeValues attributeValues = (AttributeValues)getAttributeValue(entity, attribute);
			// TODO:
			//attributeValues.removeValue(item)
			//value.getAsJsonArray().iterator();
		} else {
			AttributeValue attributeValue = (AttributeValue)getAttributeValue(entity, attribute);
			attributeValue.setValue(parse(value, attribute));
		}
	}
	
	private static final DateFormat DATE_INTERNATIONAL = new SimpleDateFormat("yyyy/MM/dd");
	
	public Object parse(JsonElement element, Attribute<?,?,?> attribute) {
		if (element == null || element.isJsonNull()) return null;
		if (attribute.getJavaClassName()==Date.class) {
			try {
				return DATE_INTERNATIONAL.parseObject(value.getAsString());
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		}
		if (attribute instanceof Relation) {
			String id = element.getAsString();
			if (id.length()==0) return null;
			CaseAdministration administration = this.getCaseInstance().getMetadata().getCaseAdministration();
			int split = id.indexOf('!');
			if (split>=0) { // Static instance
				Entity<?> entity = administration.getAllEntities().get(id.substring(0,split));
				return entity.getStaticInstances().get(id.substring(split+1));
			} else {
				Instance instance = administration.getInstanceByUniqueId(id);
				return instance;
			}
		}
		if (attribute.getJavaClassName() == Double.class) {
			return element.getAsDouble();
		}
		if (attribute.getJavaClassName() == Integer.class) {
			return element.getAsInt();
		}
		if (attribute.getJavaClassName() == BigDecimal.class) {
			return element.getAsBigDecimal();
		}
		return new Gson().fromJson(element, attribute.getJavaClassName());
	}

	public String getPageElementId() {
		return pageElementId;
	}

	public JsonElement getValue() {
		return value;
	}
}
