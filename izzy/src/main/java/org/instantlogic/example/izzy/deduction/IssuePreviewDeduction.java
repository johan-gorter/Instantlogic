package org.instantlogic.example.izzy.deduction;

import org.instantlogic.example.izzy.Issue;
import org.instantlogic.example.izzy.entity.IssueEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class IssuePreviewDeduction extends Deduction<String> {

	@Override
	public ValueAndLevel<String> deduct(DeductionContext context) {
		Issue issue = context.getSelectedInstance(IssueEntity.INSTANCE);
		return ValueAndLevel.rule(issue.getDescription());
	}
}
