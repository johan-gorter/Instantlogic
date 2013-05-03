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
public class DeductionOperationParameterDesign extends Design { 

	private static final java.util.Map<String, DeductionOperationParameterDesign> _staticInstances = new java.util.LinkedHashMap<String, DeductionOperationParameterDesign>();
	
	public static java.util.Map<String, DeductionOperationParameterDesign> getStaticDeductionOperationParameterDesignInstances() {
		return _staticInstances;
	}
	
	private static DeductionOperationParameterDesign addStaticInstance(String name, DeductionOperationParameterDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	public static final DeductionOperationParameterDesign attribute;
	public static final DeductionOperationParameterDesign castToEntity;
	public static final DeductionOperationParameterDesign constantValue;
	public static final DeductionOperationParameterDesign selectedInstanceEntity;
	public static final DeductionOperationParameterDesign reverseRelationRelation;
	
	static {
	  // Phase 1
	  attribute = addStaticInstance("attribute", new DeductionOperationParameterDesign());
	  castToEntity = addStaticInstance("castToEntity", new DeductionOperationParameterDesign());
	  constantValue = addStaticInstance("constantValue", new DeductionOperationParameterDesign());
	  selectedInstanceEntity = addStaticInstance("selectedInstanceEntity", new DeductionOperationParameterDesign());
	  reverseRelationRelation = addStaticInstance("reverseRelationRelation", new DeductionOperationParameterDesign());
	  // Phase 2
      attribute.setName("attribute");
      attribute.setValueClass("org.instantlogic.fabric.model.Attribute");
	  attribute.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Attribute").getTextTemplate());
      castToEntity.setName("toEntity");
      castToEntity.setValueClass("org.instantlogic.fabric.model.Entity");
	  castToEntity.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("To entity").getTextTemplate());
      constantValue.setName("value");
      constantValue.setValueClass("java.lang.Object");
	  constantValue.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Value").getTextTemplate());
      selectedInstanceEntity.setName("ofEntity");
      selectedInstanceEntity.setValueClass("org.instantlogic.fabric.model.Entity");
	  selectedInstanceEntity.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Of entity").getTextTemplate());
      reverseRelationRelation.setName("relation");
      reverseRelationRelation.setValueClass("org.instantlogic.fabric.model.Relation");
	  reverseRelationRelation.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Relation").getTextTemplate());
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.DeductionOperationParameterDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<DeductionOperationParameterDesign, java.lang.String> valueClass
		= createAttributeValue(org.instantlogic.designer.entity.DeductionOperationParameterDesignEntity.valueClass);
	
	public java.lang.String getValueClass() {
		return valueClass.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DeductionOperationParameterDesign, java.lang.String> getValueClassAttributeValue() {
		return valueClass;
	}

	public DeductionOperationParameterDesign setValueClass(java.lang.String newValue) {
		valueClass.setValue(newValue);
		return (DeductionOperationParameterDesign)this;
	}
	
	
	// Relations

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<DeductionOperationParameterDesign, DeductionOperationDesign> operation
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionOperationParameterDesignEntity.operation);

	public org.instantlogic.fabric.value.RelationValue<DeductionOperationParameterDesign, DeductionOperationDesign> getOperationRelationValue() {
		return operation;
	}

	public org.instantlogic.designer.DeductionOperationDesign getOperation() {
		return operation.getValue();
	}

    public DeductionOperationParameterDesign setOperation(org.instantlogic.designer.DeductionOperationDesign newValue) {
        operation.setValue(newValue);
        return (DeductionOperationParameterDesign)this;
    }


}
