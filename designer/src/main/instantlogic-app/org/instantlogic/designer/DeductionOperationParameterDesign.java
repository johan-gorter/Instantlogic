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
	  attribute.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Attribute")));
      castToEntity.setName("toEntity");
	  castToEntity.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("To entity")));
      constantValue.setName("value");
	  constantValue.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Value")));
      selectedInstanceEntity.setName("ofEntity");
	  selectedInstanceEntity.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Of entity")));
      reverseRelationRelation.setName("relation");
	  reverseRelationRelation.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Relation")));
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.DeductionOperationParameterDesignEntity.INSTANCE;
	}

	// Attributes
	
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
