/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class DataCategoryDesign extends org.instantlogic.fabric.Instance { 

	private static final java.util.Map<String, DataCategoryDesign> _staticInstances = new java.util.LinkedHashMap<String, DataCategoryDesign>();
	
	public static java.util.Map<String, DataCategoryDesign> getStaticDataCategoryDesignInstances() {
		return _staticInstances;
	}
	
	private static DataCategoryDesign addStaticInstance(String name, DataCategoryDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	public static final DataCategoryDesign text;
	public static final DataCategoryDesign number;
	public static final DataCategoryDesign dateTime;
	public static final DataCategoryDesign _boolean;
	public static final DataCategoryDesign entity;
	public static final DataCategoryDesign custom;
	
	static {
	  // Phase 1
	  text = addStaticInstance("text", new DataCategoryDesign());
	  number = addStaticInstance("number", new DataCategoryDesign());
	  dateTime = addStaticInstance("dateTime", new DataCategoryDesign());
	  _boolean = addStaticInstance("boolean", new DataCategoryDesign());
	  entity = addStaticInstance("entity", new DataCategoryDesign());
	  custom = addStaticInstance("custom", new DataCategoryDesign());
	  // Phase 2
	  text.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Text")));
	  number.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Number")));
	  dateTime.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Date/Time")));
	  _boolean.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Yes-No")));
	  entity.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Entity")));
	  custom.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Custom")));
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.DataCategoryDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations

	// Reverse relations

}
