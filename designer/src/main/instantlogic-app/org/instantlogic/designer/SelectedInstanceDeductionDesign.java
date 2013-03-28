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
public class SelectedInstanceDeductionDesign extends DeductionDesign { 

	private static final java.util.Map<String, SelectedInstanceDeductionDesign> _staticInstances = new java.util.LinkedHashMap<String, SelectedInstanceDeductionDesign>();
	
	public static java.util.Map<String, SelectedInstanceDeductionDesign> getStaticSelectedInstanceDeductionDesignInstances() {
		return _staticInstances;
	}
	
	private static SelectedInstanceDeductionDesign addStaticInstance(String name, SelectedInstanceDeductionDesign instance) {
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
		return org.instantlogic.designer.entity.SelectedInstanceDeductionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<SelectedInstanceDeductionDesign, EntityDesign> ofEntity
		= createRelationValue(org.instantlogic.designer.entity.SelectedInstanceDeductionDesignEntity.ofEntity);
		
	public org.instantlogic.fabric.value.RelationValue<SelectedInstanceDeductionDesign, EntityDesign> getOfEntityRelationValue() {
		return ofEntity;
	}

	public org.instantlogic.designer.EntityDesign getOfEntity() {
		return ofEntity.getValue();
	}
	
	public SelectedInstanceDeductionDesign setOfEntity(org.instantlogic.designer.EntityDesign newValue) {
		ofEntity.setValue(newValue);
		return (SelectedInstanceDeductionDesign)this;
	}
	


	// Reverse relations

}
