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
public class SelectionDesign extends ElementDesign { 

	private static final java.util.Map<String, SelectionDesign> _staticInstances = new java.util.LinkedHashMap<String, SelectionDesign>();
	
	public static java.util.Map<String, SelectionDesign> getStaticSelectionDesignInstances() {
		return _staticInstances;
	}
	
	private static SelectionDesign addStaticInstance(String name, SelectionDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.SelectionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<SelectionDesign, ElementDesign> children
		= createRelationValues(org.instantlogic.designer.entity.SelectionDesignEntity.children);
		
	public org.instantlogic.fabric.value.RelationValues<SelectionDesign, ElementDesign> getChildrenRelationValue() {
		return children;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign> getChildren() {
		return children.getValue();
	}
	
	public SelectionDesign addToChildren(ElementDesign item) {
		children.addValue(item);
		return (SelectionDesign)this;
	}
	
	public SelectionDesign addToChildren(ElementDesign item, int index) {
		children.insertValue(item, index);
		return (SelectionDesign)this;
	}
	
	public SelectionDesign removeFromChildren(ElementDesign item) {
		children.removeValue(item);
		return (SelectionDesign)this;
	}
	
	public SelectionDesign removeFromChildren(int index) {
		children.removeValue(index);
		return (SelectionDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValue<SelectionDesign, DeductionSchemeDesign> selection
		= createRelationValue(org.instantlogic.designer.entity.SelectionDesignEntity.selection);
		
	public org.instantlogic.fabric.value.RelationValue<SelectionDesign, DeductionSchemeDesign> getSelectionRelationValue() {
		return selection;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getSelection() {
		return selection.getValue();
	}
	
	public SelectionDesign setSelection(org.instantlogic.designer.DeductionSchemeDesign newValue) {
		selection.setValue(newValue);
		return (SelectionDesign)this;
	}
	
	public org.instantlogic.designer.DeductionSchemeDesign newSelection() {
		org.instantlogic.designer.DeductionSchemeDesign newValue = new org.instantlogic.designer.DeductionSchemeDesign(); 
		selection.setValue(newValue);
		return newValue;
	}


	// Reverse relations

}
