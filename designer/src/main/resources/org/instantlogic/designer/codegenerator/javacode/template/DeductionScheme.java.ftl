<#macro deductionscheme_macro scheme>

	private static org.instantlogic.fabric.deduction.Deduction<${scheme.lastResultType}> createDeduction${scheme.index}() {
		<#list scheme.deductions as deduction>
		  <#if deduction.customization??>
		    org.instantlogic.fabric.deduction.Deduction<${deduction.resultType}> d${deduction.index} 
		    	= new ${deduction.customization}(<#list deduction.parameters as parameters>${parameters}<#if parameters_has_next>, </#if></#list>);
		  <#else>
		  	org.instantlogic.fabric.deduction.Deduction<${deduction.resultType}> d${deduction.index} 
		  		= ${deduction.type}.create(<#list deduction.parameters as parameter>${parameter}<#if parameter_has_next>, </#if></#list>);
		  </#if>
		</#list>
		return d${scheme.lastDeductionIndex};
	}

</#macro>