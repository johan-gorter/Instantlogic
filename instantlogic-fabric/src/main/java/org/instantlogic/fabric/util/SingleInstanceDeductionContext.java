

package org.instantlogic.fabric.util;

import java.util.List;


import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;


public class SingleInstanceDeductionContext extends DeductionContext {

	private final Instance instance;
	
	public SingleInstanceDeductionContext(Instance instance) {
		this.instance = instance;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <I extends Instance> I getSelectedInstance(Entity<I> entity) {
		if (Entity.extendsFrom(instance.getMetadata().getEntity(), entity)) {
			return (I)instance;
		}
		Instance instanceCase = instance.getMetadata().getCase(); // The case to which the instance belongs is also checked.
		if (Entity.extendsFrom(instanceCase.getMetadata().getEntity(), entity)) {
			return (I)instanceCase;
		}
		throw new RuntimeException("No active instance of entity "+entity.getName());
	}

	@Override
	protected void addSelectedInstances(List<Instance> result) {
		result.add(instance);
	}

	@Override
	public String printDiagnostics() {
		return "SingleInstanceDeductionContext("+instance+")";
	}

}
