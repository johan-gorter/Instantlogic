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
public class IfElseDesign extends ElementDesign { 

	private static final java.util.Map<String, IfElseDesign> _staticInstances = new java.util.LinkedHashMap<String, IfElseDesign>();
	
	public static java.util.Map<String, IfElseDesign> getStaticIfElseDesignInstances() {
		return _staticInstances;
	}
	
	private static IfElseDesign addStaticInstance(String name, IfElseDesign instance) {
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
		return org.instantlogic.designer.entity.IfElseDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<IfElseDesign, DeductionSchemeDesign> condition
		= createRelationValue(org.instantlogic.designer.entity.IfElseDesignEntity.condition);
		
	public org.instantlogic.fabric.value.RelationValue<IfElseDesign, DeductionSchemeDesign> getConditionRelationValue() {
		return condition;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getCondition() {
		return condition.getValue();
	}
	
	public IfElseDesign setCondition(org.instantlogic.designer.DeductionSchemeDesign newValue) {
		condition.setValue(newValue);
		return (IfElseDesign)this;
	}
	
	public org.instantlogic.designer.DeductionSchemeDesign newCondition() {
		org.instantlogic.designer.DeductionSchemeDesign newValue = new org.instantlogic.designer.DeductionSchemeDesign(); 
		condition.setValue(newValue);
		return newValue;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<IfElseDesign, ElementDesign> elseChild
		= createRelationValue(org.instantlogic.designer.entity.IfElseDesignEntity.elseChild);
		
	public org.instantlogic.fabric.value.RelationValue<IfElseDesign, ElementDesign> getElseChildRelationValue() {
		return elseChild;
	}

	public org.instantlogic.designer.ElementDesign getElseChild() {
		return elseChild.getValue();
	}
	
	public IfElseDesign setElseChild(org.instantlogic.designer.ElementDesign newValue) {
		elseChild.setValue(newValue);
		return (IfElseDesign)this;
	}
	
	public org.instantlogic.designer.ElementDesign newElseChild() {
		org.instantlogic.designer.ElementDesign newValue = new org.instantlogic.designer.ElementDesign(); 
		elseChild.setValue(newValue);
		return newValue;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<IfElseDesign, ElementDesign> ifChild
		= createRelationValue(org.instantlogic.designer.entity.IfElseDesignEntity.ifChild);
		
	public org.instantlogic.fabric.value.RelationValue<IfElseDesign, ElementDesign> getIfChildRelationValue() {
		return ifChild;
	}

	public org.instantlogic.designer.ElementDesign getIfChild() {
		return ifChild.getValue();
	}
	
	public IfElseDesign setIfChild(org.instantlogic.designer.ElementDesign newValue) {
		ifChild.setValue(newValue);
		return (IfElseDesign)this;
	}
	
	public org.instantlogic.designer.ElementDesign newIfChild() {
		org.instantlogic.designer.ElementDesign newValue = new org.instantlogic.designer.ElementDesign(); 
		ifChild.setValue(newValue);
		return newValue;
	}


	// Reverse relations

}
