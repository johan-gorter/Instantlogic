/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

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
		String result = issue.getDescription();
		if (result==null) return ValueAndLevel.inconclusive();
		result = result.replaceAll("[\r\n]", " ");
		if (result.length()>150) result = result.substring(0, 150);
		return ValueAndLevel.rule(result);
	}
}
