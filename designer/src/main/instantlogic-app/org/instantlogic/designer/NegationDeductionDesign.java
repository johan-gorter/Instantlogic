package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class NegationDeductionDesign extends DeductionDesign { 

	private static final java.util.Map<String, NegationDeductionDesign> _staticInstances = new java.util.LinkedHashMap<String, NegationDeductionDesign>();
	
	public static java.util.Map<String, NegationDeductionDesign> getStaticNegationDeductionDesignInstances() {
		return _staticInstances;
	}
	
	private static NegationDeductionDesign addStaticInstance(String name, NegationDeductionDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.NegationDeductionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations

	// Reverse relations

}
