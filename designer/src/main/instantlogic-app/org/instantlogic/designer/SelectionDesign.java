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
