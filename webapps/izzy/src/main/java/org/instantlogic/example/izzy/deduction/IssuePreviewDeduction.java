

package org.instantlogic.example.izzy.deduction;

import org.instantlogic.example.izzy.Issue;
import org.instantlogic.example.izzy.entity.IssueEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class IssuePreviewDeduction extends Deduction<String> {

	@Override
	public ValueAndLevel<String> execute(DeductionContext context) {
		Issue issue = context.getSelectedInstance(IssueEntity.INSTANCE);
		String result = issue.getDescription();
		if (result==null) return ValueAndLevel.inconclusive();
		result = result.replaceAll("[\r\n]", " ");
		if (result.length()>150) result = result.substring(0, 150);
		return ValueAndLevel.rule(result);
	}
}
