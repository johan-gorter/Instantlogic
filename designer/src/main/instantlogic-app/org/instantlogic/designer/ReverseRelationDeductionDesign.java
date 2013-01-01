package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class ReverseRelationDeductionDesign extends DeductionDesign { 

	private static final java.util.Map<String, ReverseRelationDeductionDesign> _staticInstances = new java.util.LinkedHashMap<String, ReverseRelationDeductionDesign>();
	
	public static java.util.Map<String, ReverseRelationDeductionDesign> getStaticReverseRelationDeductionDesignInstances() {
		return _staticInstances;
	}
	
	private static ReverseRelationDeductionDesign addStaticInstance(String name, ReverseRelationDeductionDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.ReverseRelationDeductionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<ReverseRelationDeductionDesign, RelationDesign> relation
		= createRelationValue(org.instantlogic.designer.entity.ReverseRelationDeductionDesignEntity.relation);
		
	public org.instantlogic.fabric.value.RelationValue<ReverseRelationDeductionDesign, RelationDesign> getRelationRelationValue() {
		return relation;
	}

	public org.instantlogic.designer.RelationDesign getRelation() {
		return relation.getValue();
	}
	
	public ReverseRelationDeductionDesign setRelation(org.instantlogic.designer.RelationDesign newValue) {
		relation.setValue(newValue);
		return (ReverseRelationDeductionDesign)this;
	}
	


	// Reverse relations

}
