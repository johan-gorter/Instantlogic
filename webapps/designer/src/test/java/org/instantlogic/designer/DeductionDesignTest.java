package org.instantlogic.designer;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.designer.entity.DeductionDesignEntity;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeObserver;
import org.junit.Test;

public class DeductionDesignTest {

	protected final List<ValueChangeEvent> loggedEvents = new ArrayList<>();
	
	@SuppressWarnings("serial")
	public class ObserverCrashedException extends RuntimeException {
	}
	
	private ValueChangeObserver loggingObserver = new ValueChangeObserver() {
		
		@Override
		public void valueChanged(ValueChangeEvent event) {
			loggedEvents.add(event);
		}
	};

	private ValueChangeObserver crashingObserver = new ValueChangeObserver() {
		
		@Override
		public void valueChanged(ValueChangeEvent event) {
			throw new ObserverCrashedException();
		}
	};

	@Test
	public void testNormalBehaviorFromScratch() {
		DeductionDesign deduction = new DeductionDesign();
		assertEquals(0, deduction.getInputs().size());
		assertEquals(0, deduction.getParameters().size());
		deduction.setOperation(DeductionOperationDesign.attribute);
		
		assertEquals(1, deduction.getInputs().size());
		DeductionInputDesign input = deduction.getInputs().iterator().next();
		assertEquals(DeductionOperationInputDesign.attributeInstance, input.getOperationInput());
		
		assertEquals(1, deduction.getParameters().size());
		DeductionParameterDesign parameter = deduction.getParameters().iterator().next();
		assertEquals(DeductionOperationParameterDesign.attribute, parameter.getOperationParameter());
	}
	
	@Test
	public void testConsistencyWithCrashingObservers() {
		DeductionDesign deduction = new DeductionDesign();
		deduction.getOperationRelationValue().addValueChangeObserver(loggingObserver);
		deduction.getInputsRelationValue().addValueChangeObserver(crashingObserver);
		deduction.getInputsRelationValue().addValueChangeObserver(loggingObserver); // listeners added later are informed sooner
		
		try {
			deduction.setOperation(DeductionOperationDesign.attribute);
			fail();
		} catch (ObserverCrashedException e) {
		}
		assertEquals(4, loggedEvents.size());
		// 0
		assertEquals(DeductionDesignEntity.operation, loggedEvents.get(0).getAttribute());
		assertEquals(false, loggedEvents.get(0).isUndoEvent());
		// 1
		assertEquals(DeductionDesignEntity.inputs, loggedEvents.get(1).getAttribute());
		assertEquals(false, loggedEvents.get(1).isUndoEvent());
		// 2
		assertEquals(DeductionDesignEntity.inputs, loggedEvents.get(2).getAttribute());
		assertEquals(true, loggedEvents.get(2).isUndoEvent());
		// 3
		assertEquals(DeductionDesignEntity.operation, loggedEvents.get(3).getAttribute());
		assertEquals(true, loggedEvents.get(3).isUndoEvent());
	}

}
