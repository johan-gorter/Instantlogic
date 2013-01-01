package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class HasValueDeductionDesign extends DeductionDesign { 

	private static final java.util.Map<String, HasValueDeductionDesign> _staticInstances = new java.util.LinkedHashMap<String, HasValueDeductionDesign>();
	
	public static java.util.Map<String, HasValueDeductionDesign> getStaticHasValueDeductionDesignInstances() {
		return _staticInstances;
	}
	
	private static HasValueDeductionDesign addStaticInstance(String name, HasValueDeductionDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.HasValueDeductionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations

	// Reverse relations

}
