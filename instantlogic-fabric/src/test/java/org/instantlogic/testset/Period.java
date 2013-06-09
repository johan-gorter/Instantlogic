package org.instantlogic.testset;

import java.util.Date;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;

public class Period extends Instance {

	@Override
	public Entity<Period> getInstanceEntity() {
		return PeriodEntity.INSTANCE;
	}

	public final AttributeValue<Period, java.util.Date> from = createAttributeValue(PeriodEntity.from);

	public final AttributeValue<Period, java.util.Date> to = createAttributeValue(PeriodEntity.to);

	public final ReadOnlyAttributeValue<Period, java.lang.Integer> daysBetween = createReadOnlyAttributeValue(PeriodEntity.daysBetween);
	
	public Date getFrom() {
		return from.getValue();
	}
	
	public void setFrom(Date from) {
		this.from.setValue(from);
	}

	public Date getTo() {
		return to.getValue();
	}

	public void setTo(Date from) {
		this.to.setValue(from);
	}

	public Integer getDaysBetween() {
		return daysBetween.getValue();
	}
	
	public ReadOnlyAttributeValue<Period, java.lang.Integer> getDaysBetweenAttributeValue() {
		return daysBetween;
	}
}
