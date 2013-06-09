

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
