package org.instantlogic.designer.deduction;

import org.instantlogic.designer.DeductionDesign;
import org.instantlogic.designer.DeductionInputDesign;
import org.instantlogic.designer.entity.DeductionDesignEntity;
import org.instantlogic.designer.util.diagram.Point2d;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.value.Multi;

public class DeductionDiagramPositionDefaultDeduction extends Deduction<Point2d> {

	private static final double RELATIVE_SPREAD = 1.5;
	private static final double ABSOLUTE_SPREAD = 40;
	
	@Override
	public ValueAndLevel<Point2d> execute(DeductionContext context) {
		DeductionDesign deductionDesign = context.getSelectedInstance(DeductionDesignEntity.INSTANCE);
		if (deductionDesign.getOutputOfScheme()!=null) {
			return ValueAndLevel.rule(new Point2d(0, 10));
		}
		Multi<DeductionInputDesign> outputs = deductionDesign.getOutputs();
		if (outputs.size()==0) {
			return ValueAndLevel.rule(new Point2d(10, 10));
		}
		DeductionDesign parent = outputs.get(0).getDeduction();
		int parentInputCount = 0;
		int childIndex = -1;
		for(DeductionInputDesign input : parent.getInputs()) {
			for (DeductionDesign child:input.getInputs()) {
				if (child == deductionDesign) {
					childIndex = parentInputCount;
				}
				parentInputCount++;
			}
		}
		double absoluteOffset = ABSOLUTE_SPREAD * (childIndex+1) / (parentInputCount+1) - 0.5 * ABSOLUTE_SPREAD;
		Point2d parentPosition = parent.getDiagramPosition();
		return ValueAndLevel.rule(new Point2d(parentPosition.getLeft()*RELATIVE_SPREAD+absoluteOffset,parentPosition.getTop()+10));
	}
}