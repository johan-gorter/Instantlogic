package org.instantlogic.designer.deduction;

import org.instantlogic.designer.DataTypeDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.entity.DataTypeDesignEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class DataTypeEntityDeduction extends Deduction<EntityDesign> {

	@Override
	public ValueAndLevel<EntityDesign> execute(DeductionContext context) {
		DataTypeDesign dataType = context.getSelectedInstance(DataTypeDesignEntity.INSTANCE);
		if (dataType.getAttribute()!=null && dataType.getAttribute() instanceof RelationDesign) {
			return ValueAndLevel.rule(((RelationDesign)dataType.getAttribute()).getTo());
		}
		if (dataType.getReverseRelation()!=null) {
			return ValueAndLevel.rule(dataType.getReverseRelation().getFrom());
		}
		if (dataType.getForEntity()!=null) {
			return ValueAndLevel.rule(dataType.getForEntity());
		}
		return ValueAndLevel.rule(null);
	}
}
