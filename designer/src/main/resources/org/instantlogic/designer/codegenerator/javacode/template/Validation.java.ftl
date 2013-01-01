package ${rootPackageName}.validation;
<#include "Text.java.ftl">
<#include "DeductionScheme.java.ftl">

public<#if isCustomized> abstract</#if> class <#if isCustomized>Abstract</#if>${technicalNameCapitalized}Validation extends org.instantlogic.fabric.model.Validation {
	
	public static ${technicalNameCapitalized}Validation INSTANCE = new ${technicalNameCapitalized}Validation();
	
<#list deductionSchemes as scheme>
	<@deductionscheme_macro scheme=scheme />
</#list>
	
	private org.instantlogic.fabric.text.TextTemplate message;
	@Override
	public org.instantlogic.fabric.text.TextTemplate getMessage() {
		if (message==null) {
			message = <@text_macro text=message />;
		}
		return message;
	}

	private org.instantlogic.fabric.deduction.Deduction<Boolean> rule;
	@Override
	public org.instantlogic.fabric.deduction.Deduction<Boolean> getRule() {
		if (rule==null) {
			rule = createDeduction${ruleDeductionIndex}();
		}
		return rule;
	}
}
