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
	protected final List<String> parameterNames = new ArrayList<String>();
	
	private final DeductionContext parent;
	
	public AbstractDeductionContext(DeductionContext parent) {
		this.parent = parent;
	}
	
	public Instance[] getSelectedInstances(Entity<?>[] entities) {
		Instance[] result = new Instance[entities.length];
		for (int i=0;i<entities.length;i++) {
			result[i] = getSelectedInstance(entities[i]);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <I extends Instance> I getSelectedInstance(Entity<I> entity) {
		for (int i=selectedInstances.size()-1;i>=0;i--) {
			Instance candidate = selectedInstances.get(i);
			if (entity == null || Entity.extendsFrom(candidate.getMetadata().getEntity(), entity)) {
				return (I)candidate;
			}
		}
		if (parent!=null) {
			return parent.getSelectedInstance(entity);
		}
		return null;
	}
	
  @SuppressWarnings("unchecked")
  @Override
  public <I extends Instance> I getSelectedInstance(Entity<I> entity, String parameterName) {
    for (int i=parameterNames.size()-1;i>=0;i--) {
      if (parameterNames.get(i).equals(parameterName)) {
        Instance candidate = selectedInstances.get(i);
        if (entity == null || Entity.extendsFrom(candidate.getMetadata().getEntity(), entity)) {
          return (I)candidate;
        } else {
          throw new RuntimeException("Parameter ["+parameterName+"] value was not of type ["+entity+"]");
        }
      }
    }
    if (parent!=null) {
      return parent.getSelectedInstance(entity, parameterName);
    }
    return null;
  }

	public void pushSelectedInstance(Instance instance) {
		selectedInstances.add(instance);
	}
	
  public void pushSelectedInstance(Instance instance, String parameterName) {
    if (parameterNames.size()!=selectedInstances.size()) {
      throw new RuntimeException("Do not mix anonymous parameters with named ones");
    }
    selectedInstances.add(instance);
    parameterNames.add(parameterName);
  }
  
	public Instance popSelectedInstance() {
		if (this.selectedInstances.size()==0) {
			throw new RuntimeException("Asymmetric push/pop");
		}
    if (parameterNames.size()==selectedInstances.size()) {
      parameterNames.remove(parameterNames.size()-1);
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
