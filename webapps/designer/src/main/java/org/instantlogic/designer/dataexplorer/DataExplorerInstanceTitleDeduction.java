package org.instantlogic.designer.dataexplorer;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.SingleInstanceDeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class DataExplorerInstanceTitleDeduction extends Deduction<String> {

	@Override
	protected ValueAndLevel<String> execute(DeductionContext context) {
		Instance instance = context.getSelectedInstance(null);
		String title = renderTitle(instance);
		return ValueAndLevel.rule(title);
	}
	
	public static String renderTitle(Instance instance) {
	  if (instance.getMetadata().isStatic()) {
	    if (instance.getMetadata().getStaticDescription()!=null) {
	      return instance.getMetadata().getStaticDescription().renderText(new SingleInstanceDeductionContext(instance));
	    }
	    return instance.getMetadata().getStaticName();
	  }
		String title = instance.renderTitle();
		if (title.length()>30) {
			title = title.substring(0,30)+"...";
		}
		if (title.trim().length()==0) {
		  title = "[empty title]";
		}
		return title;
	}
}
