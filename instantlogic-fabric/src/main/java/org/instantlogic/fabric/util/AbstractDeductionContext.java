/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.fabric.util;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;


/**
 *	Used to calculate deductions by keeping a list of selected instances. 
 */
public abstract class AbstractDeductionContext extends DeductionContext {

	protected final List<Instance> selectedInstances = new ArrayList<Instance>();
	
	private final DeductionContext parent;
	
	public AbstractDeductionContext(DeductionContext parent) {
		this.parent = parent;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <I extends Instance> I getSelectedInstance(Entity<I> entity) {
		for (int i=selectedInstances.size()-1;i>=0;i--) {
			Instance candidate = selectedInstances.get(i);
			if (Entity.extendsFrom(candidate.getMetadata().getEntity(), entity)) {
				return (I)candidate;
			}
		}
		if (parent!=null) {
			return parent.getSelectedInstance(entity);
		}
		return null;
	}

	public void pushSelectedInstance(Instance instance) {
		selectedInstances.add(instance);
	}
	
	public Instance popSelectedInstance() {
		if (this.selectedInstances.size()==0) {
			throw new RuntimeException("Asymmetric push/pop");
		}
		return selectedInstances.remove(selectedInstances.size()-1);
	}

	public void popSelectedInstance(Instance instance) {
		Instance check = popSelectedInstance();
		if (check!=instance) {
			throw new RuntimeException("Asymmetric push/pop");
		}
	}
	
	public void addSelectedInstances(List<Instance> result) {
		ListIterator<Instance> iterator = selectedInstances.listIterator(selectedInstances.size());
		while (iterator.hasPrevious()) {
			result.add(iterator.previous());
		}
		if (parent!=null) {
			parent.addSelectedInstances(result);
		}
	}
	
	@Override
	public String printDiagnostics() {
		StringBuffer sb = new StringBuffer(getClass().getName());
		sb.append("(");
		for (Instance i : selectedInstances) {
			sb.append(i.toString());
			sb.append(",");
		}
		if (parent==null) {
			sb.setLength(sb.length()-1);
		} else {
			sb.append("parent: ");
			sb.append(parent.printDiagnostics());
		}
		sb.append(")");
		return sb.toString();
	}
}
