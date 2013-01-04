/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.interaction.util;

import java.util.List;
import java.util.NoSuchElementException;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.flow.PlaceTemplate;


public class FlowContext extends DeductionContext {

	public static FlowContext create(Flow mainFlow, String path, Instance caseInstance, String caseId, TravelerInfo travelerInfo) {
		FlowStack flowStack = FlowStack.create(mainFlow, path, caseInstance);
		FlowContext result = new FlowContext(caseInstance, caseId, travelerInfo);
		result.setFlowStack(flowStack);
		if (flowStack.getCurrentNode()==null && path!=null) {
			throw new NoSuchElementException();
		}
		return result;
	}
	
	
	private final Instance caseInstance;
	private final String caseId;
	private final TravelerInfo traveler;
	private FlowStack flowStack;
	
	// For debugging purposes
	private FlowNodeBase lastNode;
	private FlowEventOccurrence lastOccurrence;

	public FlowContext(Instance caseInstance, String caseId, TravelerInfo traveler) {
		this.caseInstance = caseInstance;
		this.caseId = caseId;
		this.traveler = traveler;
	}
	
	public PlaceTemplate getPage() {
		return (PlaceTemplate) flowStack.getCurrentNode();
	}
	
	public Instance getCaseInstance() {
		return this.caseInstance;
	}

	public String getCaseId() {
		return caseId;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <I extends Instance> I getSelectedInstance(Entity<I> entity) {
		if (entity == caseInstance.getMetadata().getEntity()) {
			return (I)caseInstance;
		}
		Instance result = flowStack.getSelectedInstance(entity);
		if (result!=null) {
			return (I)result;
		}
		throw new RuntimeException("No active instance of entity "+entity.getName());
	}

	public FlowEventOccurrence step(FlowEventOccurrence occurrence) {
		lastOccurrence = occurrence;
		lastNode = flowStack.getCurrentNode();
		return flowStack.getFlow().step(flowStack.getCurrentNode(), occurrence, this);
	}

	public FlowStack getFlowStack() {
		return flowStack;
	}

	public void setFlowStack(FlowStack flowStack) {
		this.flowStack = flowStack;
	}

	public void popFlowContext() {
		flowStack = flowStack.getParent();
		if (flowStack==null) {
			throw new UnhandledOccurrenceException(lastNode, lastOccurrence);
		}
	}
	
	public void pushFlowContext(Flow flow) {
		flowStack = new FlowStack(flowStack, flow);
	}
	
	@Override
	public String toString() {
		return "Flowstack for case "+caseId+" "+flowStack;
	}

	@Override
	protected void addSelectedInstances(List<Instance> result) {
		flowStack.addSelectedInstances(result);
	}

	public void logOccurrence(FlowEventOccurrence occurrence) {
		this.lastNode = flowStack.getCurrentNode();
		this.lastOccurrence = occurrence;
	}

	public TravelerInfo getTraveler() {
		return traveler;
	}

	@Override
	public String printDiagnostics() {
		return flowStack.printDiagnostics();
	}
}
