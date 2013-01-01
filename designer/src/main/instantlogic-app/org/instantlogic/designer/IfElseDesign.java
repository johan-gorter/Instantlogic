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

	
	private final org.instantlogic.fabric.value.RelationValues<IfElseDesign, ElementDesign> elseChildren
		= createRelationValues(org.instantlogic.designer.entity.IfElseDesignEntity.elseChildren);
		
	public org.instantlogic.fabric.value.RelationValues<IfElseDesign, ElementDesign> getElseChildrenRelationValue() {
		return elseChildren;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign> getElseChildren() {
		return elseChildren.getValue();
	}
	
	public IfElseDesign addToElseChildren(ElementDesign item) {
		elseChildren.addValue(item);
		return (IfElseDesign)this;
	}
	
	public IfElseDesign addToElseChildren(ElementDesign item, int index) {
		elseChildren.insertValue(item, index);
		return (IfElseDesign)this;
	}
	
	public IfElseDesign removeFromElseChildren(ElementDesign item) {
		elseChildren.removeValue(item);
		return (IfElseDesign)this;
	}
	
	public IfElseDesign removeFromElseChildren(int index) {
		elseChildren.removeValue(index);
		return (IfElseDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<IfElseDesign, ElementDesign> ifChildren
		= createRelationValues(org.instantlogic.designer.entity.IfElseDesignEntity.ifChildren);
		
	public org.instantlogic.fabric.value.RelationValues<IfElseDesign, ElementDesign> getIfChildrenRelationValue() {
		return ifChildren;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign> getIfChildren() {
		return ifChildren.getValue();
	}
	
	public IfElseDesign addToIfChildren(ElementDesign item) {
		ifChildren.addValue(item);
		return (IfElseDesign)this;
	}
	
	public IfElseDesign addToIfChildren(ElementDesign item, int index) {
		ifChildren.insertValue(item, index);
		return (IfElseDesign)this;
	}
	
	public IfElseDesign removeFromIfChildren(ElementDesign item) {
		ifChildren.removeValue(item);
		return (IfElseDesign)this;
	}
	
	public IfElseDesign removeFromIfChildren(int index) {
		ifChildren.removeValue(index);
		return (IfElseDesign)this;
	}
	

	// Reverse relations

}
