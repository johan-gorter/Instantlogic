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
public abstract class AbstractEventDesign extends Design { 

	private static final java.util.Map<String, EventDesign> _staticInstances = new java.util.LinkedHashMap<String, EventDesign>();
	
	public static java.util.Map<String, EventDesign> getStaticEventDesignInstances() {
		return _staticInstances;
	}
	
	private static EventDesign addStaticInstance(String name, EventDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	  // Phase 1
	  // Phase 2
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.EventDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<EventDesign, EntityDesign> parameters
		= createRelationValues(org.instantlogic.designer.entity.EventDesignEntity.parameters);
		
	public org.instantlogic.fabric.value.RelationValues<EventDesign, EntityDesign> getParametersRelationValue() {
		return parameters;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EntityDesign> getParameters() {
		return parameters.getValue();
	}
	
	public EventDesign addToParameters(EntityDesign item) {
		parameters.addValue(item);
		return (EventDesign)this;
	}
	
	public EventDesign addToParameters(EntityDesign item, int index) {
		parameters.insertValue(item, index);
		return (EventDesign)this;
	}
	
	public EventDesign removeFromParameters(EntityDesign item) {
		parameters.removeValue(item);
		return (EventDesign)this;
	}
	
	public EventDesign removeFromParameters(int index) {
		parameters.removeValue(index);
		return (EventDesign)this;
	}
	

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<EventDesign, ApplicationDesign> application
		= createReverseRelationValue(org.instantlogic.designer.entity.EventDesignEntity.application);

	public org.instantlogic.fabric.value.RelationValue<EventDesign, ApplicationDesign> getApplicationRelationValue() {
		return application;
	}

	public org.instantlogic.designer.ApplicationDesign getApplication() {
		return application.getValue();
	}

    public EventDesign setApplication(org.instantlogic.designer.ApplicationDesign newValue) {
        application.setValue(newValue);
        return (EventDesign)this;
    }


}
