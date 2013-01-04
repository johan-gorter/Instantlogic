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
public class SharedElementDesign extends ElementDesign { 

	private static final java.util.Map<String, SharedElementDesign> _staticInstances = new java.util.LinkedHashMap<String, SharedElementDesign>();
	
	public static java.util.Map<String, SharedElementDesign> getStaticSharedElementDesignInstances() {
		return _staticInstances;
	}
	
	private static SharedElementDesign addStaticInstance(String name, SharedElementDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.SharedElementDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<SharedElementDesign, SharedElementDefinitionDesign> definition
		= createRelationValue(org.instantlogic.designer.entity.SharedElementDesignEntity.definition);
		
	public org.instantlogic.fabric.value.RelationValue<SharedElementDesign, SharedElementDefinitionDesign> getDefinitionRelationValue() {
		return definition;
	}

	public org.instantlogic.designer.SharedElementDefinitionDesign getDefinition() {
		return definition.getValue();
	}
	
	public SharedElementDesign setDefinition(org.instantlogic.designer.SharedElementDefinitionDesign newValue) {
		definition.setValue(newValue);
		return (SharedElementDesign)this;
	}
	


	// Reverse relations

}
