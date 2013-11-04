package org.instantlogic.designer.dataexplorer;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class DataExplorerInstanceTitleDeduction extends Deduction<String> {

	@Override
	protected ValueAndLevel<String> execute(DeductionContext context) {
		Instance instance = context.getSelectedInstance(null);
		String title = instance.renderTitle();
		String name = instance.getMetadata().getEntity().getName();
		if (title.length()>30) {
			title = title.substring(0,30)+"...";
		}
		return ValueAndLevel.rule(name+" '"+title+"'");
	}
}
