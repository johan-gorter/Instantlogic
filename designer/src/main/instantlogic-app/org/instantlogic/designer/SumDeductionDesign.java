package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class SumDeductionDesign extends DeductionDesign { 

	private static final java.util.Map<String, SumDeductionDesign> _staticInstances = new java.util.LinkedHashMap<String, SumDeductionDesign>();
	
	public static java.util.Map<String, SumDeductionDesign> getStaticSumDeductionDesignInstances() {
		return _staticInstances;
	}
	
	private static SumDeductionDesign addStaticInstance(String name, SumDeductionDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.SumDeductionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations

	// Reverse relations

}
