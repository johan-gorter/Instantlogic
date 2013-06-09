

package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class SharedElementDesign extends ElementDesign { 

	private static final java.util.Map<String, SharedElementDesign> _staticInstances = new java.util.LinkedHashMap<String, SharedElementDesign>();
	
	public static java.util.Map<String, SharedElementDesign> getStaticSharedElementDesignInstances() {
		return _staticInstances;
	}
	
	private static SharedElementDesign addStaticInstance(String name, SharedElementDesign instance) {
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
		return org.instantlogic.designer.entity.SharedElementDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<SharedElementDesign, SharedElementDefinitionDesign> definition
		= createRelationValue(org.instantlogic.designer.entity.SharedElementDesignEntity.definition);
		
	public org.instantlogic.fabric.value.RelationValue<SharedElementDesign, SharedElementDefinitionDesign> getDefinitionRelationValue() {
		return definition;
	}

	public org.instantlogic.designer.SharedElementDefinitionDesign getDefinition() {
		return definition.getValue();
	}
	
	public SharedElementDesign setDefinition(org.instantlogic.designer.SharedElementDefinitionDesign newValue) {
		definition.setValue(newValue);
		return (SharedElementDesign)this;
	}
	


	// Reverse relations

}
