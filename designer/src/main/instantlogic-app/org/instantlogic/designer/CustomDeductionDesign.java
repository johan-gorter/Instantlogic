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
public class CustomDeductionDesign extends DeductionDesign { 

	private static final java.util.Map<String, CustomDeductionDesign> _staticInstances = new java.util.LinkedHashMap<String, CustomDeductionDesign>();
	
	public static java.util.Map<String, CustomDeductionDesign> getStaticCustomDeductionDesignInstances() {
		return _staticInstances;
	}
	
	private static CustomDeductionDesign addStaticInstance(String name, CustomDeductionDesign instance) {
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
		return org.instantlogic.designer.entity.CustomDeductionDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<CustomDeductionDesign, java.lang.String> implementationClassName
		= createAttributeValue(org.instantlogic.designer.entity.CustomDeductionDesignEntity.implementationClassName);
	
	public java.lang.String getImplementationClassName() {
		return implementationClassName.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<CustomDeductionDesign, java.lang.String> getImplementationClassNameAttributeValue() {
		return implementationClassName;
	}

	public CustomDeductionDesign setImplementationClassName(java.lang.String newValue) {
		implementationClassName.setValue(newValue);
		return (CustomDeductionDesign)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<CustomDeductionDesign, DataTypeDesign> customDataType
		= createRelationValue(org.instantlogic.designer.entity.CustomDeductionDesignEntity.customDataType);
		
	public org.instantlogic.fabric.value.RelationValue<CustomDeductionDesign, DataTypeDesign> getCustomDataTypeRelationValue() {
		return customDataType;
	}

	public org.instantlogic.designer.DataTypeDesign getCustomDataType() {
		return customDataType.getValue();
	}
	
	public CustomDeductionDesign setCustomDataType(org.instantlogic.designer.DataTypeDesign newValue) {
		customDataType.setValue(newValue);
		return (CustomDeductionDesign)this;
	}
	
	public org.instantlogic.designer.DataTypeDesign newCustomDataType() {
		org.instantlogic.designer.DataTypeDesign newValue = new org.instantlogic.designer.DataTypeDesign(); 
		customDataType.setValue(newValue);
		return newValue;
	}


	// Reverse relations

}
