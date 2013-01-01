package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class EqualsDeductionDesign extends DeductionDesign { 

	private static final java.util.Map<String, EqualsDeductionDesign> _staticInstances = new java.util.LinkedHashMap<String, EqualsDeductionDesign>();
	
	public static java.util.Map<String, EqualsDeductionDesign> getStaticEqualsDeductionDesignInstances() {
		return _staticInstances;
	}
	
	private static EqualsDeductionDesign addStaticInstance(String name, EqualsDeductionDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.EqualsDeductionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations

	// Reverse relations

}
