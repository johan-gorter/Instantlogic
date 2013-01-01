package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class ElementDesign extends Design { 

	private static final java.util.Map<String, ElementDesign> _staticInstances = new java.util.LinkedHashMap<String, ElementDesign>();
	
	public static java.util.Map<String, ElementDesign> getStaticElementDesignInstances() {
		return _staticInstances;
	}
	
	private static ElementDesign addStaticInstance(String name, ElementDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<ElementDesign, java.lang.Boolean> editorOpen
		= createAttributeValue(org.instantlogic.designer.entity.ElementDesignEntity.editorOpen);
	
	public java.lang.Boolean getEditorOpen() {
		return editorOpen.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<ElementDesign, java.lang.Boolean> getEditorOpenAttributeValue() {
		return editorOpen;
	}

	public ElementDesign setEditorOpen(java.lang.Boolean newValue) {
		editorOpen.setValue(newValue);
		return (ElementDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<ElementDesign, java.lang.String> previewMode
		= createAttributeValue(org.instantlogic.designer.entity.ElementDesignEntity.previewMode);
	
	public java.lang.String getPreviewMode() {
		return previewMode.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<ElementDesign, java.lang.String> getPreviewModeAttributeValue() {
		return previewMode;
	}

	public ElementDesign setPreviewMode(java.lang.String newValue) {
		previewMode.setValue(newValue);
		return (ElementDesign)this;
	}
	
	
	// Relations

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<ElementDesign, SelectionDesign> childOfSelection
		= createReverseRelationValue(org.instantlogic.designer.entity.ElementDesignEntity.childOfSelection);

	public org.instantlogic.fabric.value.RelationValue<ElementDesign, SelectionDesign> getChildOfSelectionRelationValue() {
		return childOfSelection;
	}

	public org.instantlogic.designer.SelectionDesign getChildOfSelection() {
		return childOfSelection.getValue();
	}

    public ElementDesign setChildOfSelection(org.instantlogic.designer.SelectionDesign newValue) {
        childOfSelection.setValue(newValue);
        return (ElementDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<ElementDesign, PropertyDesign> childrenForFragment
		= createReverseRelationValue(org.instantlogic.designer.entity.ElementDesignEntity.childrenForFragment);

	public org.instantlogic.fabric.value.RelationValue<ElementDesign, PropertyDesign> getChildrenForFragmentRelationValue() {
		return childrenForFragment;
	}

	public org.instantlogic.designer.PropertyDesign getChildrenForFragment() {
		return childrenForFragment.getValue();
	}

    public ElementDesign setChildrenForFragment(org.instantlogic.designer.PropertyDesign newValue) {
        childrenForFragment.setValue(newValue);
        return (ElementDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<ElementDesign, PlaceTemplateDesign> contentOfPage
		= createReverseRelationValue(org.instantlogic.designer.entity.ElementDesignEntity.contentOfPage);

	public org.instantlogic.fabric.value.RelationValue<ElementDesign, PlaceTemplateDesign> getContentOfPageRelationValue() {
		return contentOfPage;
	}

	public org.instantlogic.designer.PlaceTemplateDesign getContentOfPage() {
		return contentOfPage.getValue();
	}

    public ElementDesign setContentOfPage(org.instantlogic.designer.PlaceTemplateDesign newValue) {
        contentOfPage.setValue(newValue);
        return (ElementDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<ElementDesign, SharedElementDefinitionDesign> partOfSharedElementDefinition
		= createReverseRelationValue(org.instantlogic.designer.entity.ElementDesignEntity.partOfSharedElementDefinition);

	public org.instantlogic.fabric.value.RelationValue<ElementDesign, SharedElementDefinitionDesign> getPartOfSharedElementDefinitionRelationValue() {
		return partOfSharedElementDefinition;
	}

	public org.instantlogic.designer.SharedElementDefinitionDesign getPartOfSharedElementDefinition() {
		return partOfSharedElementDefinition.getValue();
	}

    public ElementDesign setPartOfSharedElementDefinition(org.instantlogic.designer.SharedElementDefinitionDesign newValue) {
        partOfSharedElementDefinition.setValue(newValue);
        return (ElementDesign)this;
    }


}
