<#macro deductionscheme_macro scheme>

	private static org.instantlogic.fabric.deduction.Deduction createDeduction${scheme.index}() {
		<#list scheme.deductions as deduction>
		  	${deduction.type} d${deduction.index} = new ${deduction.type}();
		  <#list deduction.parameters as parameter>
		    d${deduction.index}.set${parameter.name}(${parameter.value.asJavaTemplate});
		  </#list>
		</#list>
		<#list scheme.deductions as deduction>
			<#list deduction.inputs as input>
			  <#if input.multivalue>
		    d${deduction.index}.addTo${input.inputName}(d${input.deductionIndex});
			  <#else>
		    d${deduction.index}.set${input.inputName}(d${input.deductionIndex});
			  </#if>
			</#list>
		</#list>
		return d0;
	}

</#macro>