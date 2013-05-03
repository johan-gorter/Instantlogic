/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer.validation;

public class DataTypeDesignDataCategoryRequiredValidation extends org.instantlogic.fabric.model.Validation {
	
	public static DataTypeDesignDataCategoryRequiredValidation INSTANCE = new DataTypeDesignDataCategoryRequiredValidation();
	

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.HasValueDeduction d0 = new org.instantlogic.fabric.deduction.HasValueDeduction();
		  	org.instantlogic.fabric.deduction.AttributeDeduction d1 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d1.setAttribute(org.instantlogic.designer.entity.DataTypeDesignEntity.dataCategory);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d2 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d2.setOfEntity(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE);
		    d0.setInput(d1);
		    d1.setInstance(d2);
		return d0;
	}

	
	private org.instantlogic.fabric.text.TextTemplate message;
	@Override
	public org.instantlogic.fabric.text.TextTemplate getMessage() {
		if (message==null) {
			message = new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Select a value").getTextTemplate();
		}
		return message;
	}

	private org.instantlogic.fabric.deduction.Deduction<Boolean> rule;
	@Override
	public org.instantlogic.fabric.deduction.Deduction<Boolean> getRule() {
		if (rule==null) {
			rule = createDeduction0();
		}
		return rule;
	}
}
