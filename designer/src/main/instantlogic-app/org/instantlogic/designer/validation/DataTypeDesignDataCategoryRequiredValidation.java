package org.instantlogic.designer.validation;

public class DataTypeDesignDataCategoryRequiredValidation extends org.instantlogic.fabric.model.Validation {
	
	public static DataTypeDesignDataCategoryRequiredValidation INSTANCE = new DataTypeDesignDataCategoryRequiredValidation();
	

	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.DataTypeDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.DataCategoryDesign> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DataTypeDesignEntity.dataCategory, d0);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> d2 
		  		= org.instantlogic.fabric.deduction.HasValueDeduction.create(d1);
		return d2;
	}

	
	private org.instantlogic.fabric.text.TextTemplate message;
	@Override
	public org.instantlogic.fabric.text.TextTemplate getMessage() {
		if (message==null) {
			message = new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Select a value"));
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
