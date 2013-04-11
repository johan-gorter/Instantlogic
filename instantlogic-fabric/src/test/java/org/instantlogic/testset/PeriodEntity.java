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
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.model.impl.SimpleAttribute;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

@SuppressWarnings({"rawtypes", "unchecked"})
public class PeriodEntity extends Entity<Period> {

	public static class DaysBetweenRule extends Deduction<Integer> {

		private static final int MILLISECONDS_PER_DAY = 1000*60*60*24;

		@Override
		public ValueAndLevel<Integer> execute(DeductionContext context) {
			Period period = context.getSelectedInstance(PeriodEntity.INSTANCE);
			Date from = period.getFrom();
			Date to = period.getTo();
			if (from==null || to==null) {
				return ValueAndLevel.inconclusive();
			}
			return ValueAndLevel.rule((int)((to.getTime() - from.getTime())/MILLISECONDS_PER_DAY));
		}
	}
	
	public static final PeriodEntity INSTANCE = new PeriodEntity();

	// Attributes

	public static final Attribute<Period, java.util.Date, java.util.Date> from = new SimpleAttribute<Period, java.util.Date, java.util.Date>(
			"from", INSTANCE, java.util.Date.class, "from", Period.class);
	
	public static final Attribute<Period, java.util.Date, java.util.Date> to = new SimpleAttribute<Period, java.util.Date, java.util.Date>(
			"to", INSTANCE, java.util.Date.class, "to", Period.class);

	public static final SimpleAttribute<Period, java.lang.Integer, java.lang.Integer> daysBetween = new SimpleAttribute<Period, java.lang.Integer, java.lang.Integer>(
			"daysBetween", INSTANCE, java.lang.Integer.class, "daysBetween", Period.class);
	
	static {
		daysBetween.rule = new DaysBetweenRule();
	}

	private static final Attribute[] ATTRIBUTES = new Attribute[] { from, to, daysBetween };
	private static final Relation[] RELATIONS = new Relation[] {};
	private static final Relation[] REVERSE_RELATIONS = new Relation[] {};

	@Override
	public Attribute<Period, ? extends Object, ? extends Object>[] getLocalAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public Relation<Period, ? extends Object, ? extends Instance>[] getLocalRelations() {
		return RELATIONS;
	}

	@Override
	public Relation<? extends Instance, ? extends Object, Period>[] getLocalReverseRelations() {
		return REVERSE_RELATIONS;
	}

	@Override
	public Period createInstance() {
		return new Period();
	}

	@Override
	public String getName() {
		return "Period";
	}

	@Override
	public Class<Period> getInstanceClass() {
		return Period.class;
	}
}