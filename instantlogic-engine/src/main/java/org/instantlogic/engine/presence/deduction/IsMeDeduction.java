package org.instantlogic.engine.presence.deduction;

import org.instantlogic.engine.presence.Traveler;
import org.instantlogic.engine.presence.entity.TravelerEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.interaction.util.RenderContext;
import org.instantlogic.interaction.util.TravelerInfo;

public class IsMeDeduction extends Deduction<Boolean> {

	@Override
	public ValueAndLevel<Boolean> execute(DeductionContext context) {
		Traveler traveler = context.getSelectedInstance(TravelerEntity.INSTANCE);
		TravelerInfo me = ((RenderContext)context).getFlowContext().getTraveler();
		return ValueAndLevel.rule(me.getTravelerId().equals(traveler.getTravelerInfo().getTravelerId()));
	}

}
