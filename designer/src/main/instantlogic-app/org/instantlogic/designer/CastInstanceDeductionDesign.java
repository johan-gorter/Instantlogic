package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class CastInstanceDeductionDesign extends DeductionDesign { 

	private static final java.util.Map<String, CastInstanceDeductionDesign> _staticInstances = new java.util.LinkedHashMap<String, CastInstanceDeductionDesign>();
	
	public static java.util.Map<String, CastInstanceDeductionDesign> getStaticCastInstanceDeductionDesignInstances() {
		return _staticInstances;
	}
	
	private static CastInstanceDeductionDesign addStaticInstance(String name, CastInstanceDeductionDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.CastInstanceDeductionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<CastInstanceDeductionDesign, EntityDesign> toEntity
		= createRelationValue(org.instantlogic.designer.entity.CastInstanceDeductionDesignEntity.toEntity);
		
	public org.instantlogic.fabric.value.RelationValue<CastInstanceDeductionDesign, EntityDesign> getToEntityRelationValue() {
		return toEntity;
	}

	public org.instantlogic.designer.EntityDesign getToEntity() {
		return toEntity.getValue();
	}
	
	public CastInstanceDeductionDesign setToEntity(org.instantlogic.designer.EntityDesign newValue) {
		toEntity.setValue(newValue);
		return (CastInstanceDeductionDesign)this;
	}
	


	// Reverse relations

}
