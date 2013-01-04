/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

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
	
	public ReadOnlyAttributeValue<Period, java.lang.Integer> getDaysBetweenAttribute() {
		return daysBetween;
	}
}
