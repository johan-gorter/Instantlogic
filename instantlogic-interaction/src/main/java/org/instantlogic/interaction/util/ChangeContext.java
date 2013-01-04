/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.interaction.util;

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
		((AttributeValue)getAttributeValue(entity, attribute)).setValue(parse(value, attribute));
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
		if (attribute instanceof Relation) {
			String id = (String)value;
			if (id==null || id.length()==0) return null;
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
		return value;
	}

	public String getPageElementId() {
		return pageElementId;
	}

	public Object getValue() {
		return value;
	}
}
