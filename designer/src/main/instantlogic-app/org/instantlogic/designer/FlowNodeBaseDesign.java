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
public class FlowNodeBaseDesign extends Design { 

	private static final java.util.Map<String, FlowNodeBaseDesign> _staticInstances = new java.util.LinkedHashMap<String, FlowNodeBaseDesign>();
	
	public static java.util.Map<String, FlowNodeBaseDesign> getStaticFlowNodeBaseDesignInstances() {
		return _staticInstances;
	}
	
	private static FlowNodeBaseDesign addStaticInstance(String name, FlowNodeBaseDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValues<FlowNodeBaseDesign, FlowEdgeDesign> incomingEdges
		= createReverseRelationValues(org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.incomingEdges);

	public org.instantlogic.fabric.value.RelationValues<FlowNodeBaseDesign, FlowEdgeDesign> getIncomingEdgesRelationValue() {
		return incomingEdges;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign> getIncomingEdges() {
		return incomingEdges.getValue();
	}

    public FlowNodeBaseDesign addToIncomingEdges(FlowEdgeDesign item) {
        incomingEdges.addValue(item);
        return (FlowNodeBaseDesign)this;
    }

    public FlowNodeBaseDesign removeFromIncomingEdges(FlowEdgeDesign item) {
        incomingEdges.removeValue(item);
        return (FlowNodeBaseDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValues<FlowNodeBaseDesign, FlowEdgeDesign> outgoingEdges
		= createReverseRelationValues(org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.outgoingEdges);

	public org.instantlogic.fabric.value.RelationValues<FlowNodeBaseDesign, FlowEdgeDesign> getOutgoingEdgesRelationValue() {
		return outgoingEdges;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign> getOutgoingEdges() {
		return outgoingEdges.getValue();
	}

    public FlowNodeBaseDesign addToOutgoingEdges(FlowEdgeDesign item) {
        outgoingEdges.addValue(item);
        return (FlowNodeBaseDesign)this;
    }

    public FlowNodeBaseDesign removeFromOutgoingEdges(FlowEdgeDesign item) {
        outgoingEdges.removeValue(item);
        return (FlowNodeBaseDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<FlowNodeBaseDesign, FlowDesign> owner
		= createReverseRelationValue(org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.owner);

	public org.instantlogic.fabric.value.RelationValue<FlowNodeBaseDesign, FlowDesign> getOwnerRelationValue() {
		return owner;
	}

	public org.instantlogic.designer.FlowDesign getOwner() {
		return owner.getValue();
	}

    public FlowNodeBaseDesign setOwner(org.instantlogic.designer.FlowDesign newValue) {
        owner.setValue(newValue);
        return (FlowNodeBaseDesign)this;
    }


}
