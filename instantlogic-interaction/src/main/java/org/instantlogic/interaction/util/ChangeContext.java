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
import org.instantlogic.interaction.flow.Flow;


public class ChangeContext extends RenderContext {

	public static ChangeContext create(Flow mainFlow, String path, Instance caseInstance, String caseId, String pageElementId, Object value, TravelerInfo travelerInfo) {
		FlowContext flowContext = FlowContext.create(mainFlow, path, caseInstance, caseId, travelerInfo);
		return new ChangeContext(flowContext, path, pageElementId, value);
	}
	
	private String pageElementId;
	private Object value;

	public ChangeContext(FlowContext flowContext, String pageCoordinates, String pageElementId, Object value) {
		super(flowContext, pageCoordinates);
		this.pageElementId = pageElementId;
		this.value = value;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setValue(Entity entity, Attribute attribute, Object value) {
		AttributeValue attributeValue = (AttributeValue)getAttributeValue(entity, attribute);
		attributeValue.setValue(parse(value, attribute));
	}
	
	private static final DateFormat DATE_INTERNATIONAL = new SimpleDateFormat("yyyy/MM/dd");
	
	public Object parse(Object value, Attribute<?,?,?> attribute) {
		if (attribute.getJavaClassName()==Date.class && value instanceof String) {
			try {
				return DATE_INTERNATIONAL.parseObject((String)value);
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		}
		if (value == null) return null;
		if (attribute instanceof Relation) {
			String id = (String)value;
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
			return ((Number)value).doubleValue();
		}
		if (attribute.getJavaClassName() == Integer.class) {
			return ((Number)value).intValue();
		}
		if (attribute.getJavaClassName() == BigDecimal.class) {
			return new BigDecimal(value.toString());
		}
		return value;
	}

	public String getPageElementId() {
		return pageElementId;
	}

	public Object getValue() {
		return value;
	}
}
