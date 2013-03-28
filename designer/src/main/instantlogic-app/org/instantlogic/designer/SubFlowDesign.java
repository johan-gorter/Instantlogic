/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class SubFlowDesign extends FlowNodeBaseDesign { 

	private static final java.util.Map<String, SubFlowDesign> _staticInstances = new java.util.LinkedHashMap<String, SubFlowDesign>();
	
	public static java.util.Map<String, SubFlowDesign> getStaticSubFlowDesignInstances() {
		return _staticInstances;
	}
	
	private static SubFlowDesign addStaticInstance(String name, SubFlowDesign instance) {
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
		return org.instantlogic.designer.entity.SubFlowDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<SubFlowDesign, FlowDesign> flow
		= createRelationValue(org.instantlogic.designer.entity.SubFlowDesignEntity.flow);
		
	public org.instantlogic.fabric.value.RelationValue<SubFlowDesign, FlowDesign> getFlowRelationValue() {
		return flow;
	}

	public org.instantlogic.designer.FlowDesign getFlow() {
		return flow.getValue();
	}
	
	public SubFlowDesign setFlow(org.instantlogic.designer.FlowDesign newValue) {
		flow.setValue(newValue);
		return (SubFlowDesign)this;
	}
	


	// Reverse relations

}
