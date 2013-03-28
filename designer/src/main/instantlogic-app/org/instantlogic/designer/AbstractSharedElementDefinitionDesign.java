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
public abstract class AbstractSharedElementDefinitionDesign extends Design { 

	private static final java.util.Map<String, SharedElementDefinitionDesign> _staticInstances = new java.util.LinkedHashMap<String, SharedElementDefinitionDesign>();
	
	public static java.util.Map<String, SharedElementDefinitionDesign> getStaticSharedElementDefinitionDesignInstances() {
		return _staticInstances;
	}
	
	private static SharedElementDefinitionDesign addStaticInstance(String name, SharedElementDefinitionDesign instance) {
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
		return org.instantlogic.designer.entity.SharedElementDefinitionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<SharedElementDefinitionDesign, ElementDesign> fragment
		= createRelationValue(org.instantlogic.designer.entity.SharedElementDefinitionDesignEntity.fragment);
		
	public org.instantlogic.fabric.value.RelationValue<SharedElementDefinitionDesign, ElementDesign> getFragmentRelationValue() {
		return fragment;
	}

	public org.instantlogic.designer.ElementDesign getFragment() {
		return fragment.getValue();
	}
	
	public SharedElementDefinitionDesign setFragment(org.instantlogic.designer.ElementDesign newValue) {
		fragment.setValue(newValue);
		return (SharedElementDefinitionDesign)this;
	}
	
	public org.instantlogic.designer.ElementDesign newFragment() {
		org.instantlogic.designer.ElementDesign newValue = new org.instantlogic.designer.ElementDesign(); 
		fragment.setValue(newValue);
		return newValue;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<SharedElementDefinitionDesign, ApplicationDesign> application
		= createReverseRelationValue(org.instantlogic.designer.entity.SharedElementDefinitionDesignEntity.application);

	public org.instantlogic.fabric.value.RelationValue<SharedElementDefinitionDesign, ApplicationDesign> getApplicationRelationValue() {
		return application;
	}

	public org.instantlogic.designer.ApplicationDesign getApplication() {
		return application.getValue();
	}

    public SharedElementDefinitionDesign setApplication(org.instantlogic.designer.ApplicationDesign newValue) {
        application.setValue(newValue);
        return (SharedElementDefinitionDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValues<SharedElementDefinitionDesign, SharedElementDesign> usages
		= createReverseRelationValues(org.instantlogic.designer.entity.SharedElementDefinitionDesignEntity.usages);

	public org.instantlogic.fabric.value.RelationValues<SharedElementDefinitionDesign, SharedElementDesign> getUsagesRelationValue() {
		return usages;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.SharedElementDesign> getUsages() {
		return usages.getValue();
	}

    public SharedElementDefinitionDesign addToUsages(SharedElementDesign item) {
        usages.addValue(item);
        return (SharedElementDefinitionDesign)this;
    }

    public SharedElementDefinitionDesign removeFromUsages(SharedElementDesign item) {
        usages.removeValue(item);
        return (SharedElementDefinitionDesign)this;
    }


}
