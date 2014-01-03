package org.instantlogic.designer.dataexplorer;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class DataExplorerInstanceTitleDeduction extends Deduction<String> {

	@Override
	protected ValueAndLevel<String> execute(DeductionContext context) {
		Instance instance = context.getSelectedInstance(null);
		String title = renderTitle(instance);
		return ValueAndLevel.rule(title);
	}
	
	public static String renderTitle(Instance instance) {
		String title = instance.renderTitle();
		if (title.length()>30) {
			title = title.substring(0,30)+"...";
		}
		return title;
	}
}
