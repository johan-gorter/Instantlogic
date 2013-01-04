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
public class AttributeDeductionDesign extends DeductionDesign { 

	private static final java.util.Map<String, AttributeDeductionDesign> _staticInstances = new java.util.LinkedHashMap<String, AttributeDeductionDesign>();
	
	public static java.util.Map<String, AttributeDeductionDesign> getStaticAttributeDeductionDesignInstances() {
		return _staticInstances;
	}
	
	private static AttributeDeductionDesign addStaticInstance(String name, AttributeDeductionDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.AttributeDeductionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<AttributeDeductionDesign, AttributeDesign> attribute
		= createRelationValue(org.instantlogic.designer.entity.AttributeDeductionDesignEntity.attribute);
		
	public org.instantlogic.fabric.value.RelationValue<AttributeDeductionDesign, AttributeDesign> getAttributeRelationValue() {
		return attribute;
	}

	public org.instantlogic.designer.AttributeDesign getAttribute() {
		return attribute.getValue();
	}
	
	public AttributeDeductionDesign setAttribute(org.instantlogic.designer.AttributeDesign newValue) {
		attribute.setValue(newValue);
		return (AttributeDeductionDesign)this;
	}
	


	// Reverse relations

}
