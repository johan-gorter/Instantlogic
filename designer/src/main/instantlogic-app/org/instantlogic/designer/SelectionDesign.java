

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
	  // Phase 1
	  // Phase 2
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.SelectionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<SelectionDesign, ElementDesign> child
		= createRelationValue(org.instantlogic.designer.entity.SelectionDesignEntity.child);
		
	public org.instantlogic.fabric.value.RelationValue<SelectionDesign, ElementDesign> getChildRelationValue() {
		return child;
	}

	public org.instantlogic.designer.ElementDesign getChild() {
		return child.getValue();
	}
	
	public SelectionDesign setChild(org.instantlogic.designer.ElementDesign newValue) {
		child.setValue(newValue);
		return (SelectionDesign)this;
	}
	
	public org.instantlogic.designer.ElementDesign newChild() {
		org.instantlogic.designer.ElementDesign newValue = new org.instantlogic.designer.ElementDesign(); 
		child.setValue(newValue);
		return newValue;
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
