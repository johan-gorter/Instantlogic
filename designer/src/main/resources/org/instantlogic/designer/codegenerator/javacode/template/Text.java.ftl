<#macro text_macro text>
new org.instantlogic.fabric.text.TextTemplate().getUntranslated()<#t>
<#list text.untranslated as st>
	<#if st.type=="constant">
        .add("${st.constant}")<#t>
	</#if>
	<#if st.type=="formattedValue">
		.add(createDeduction${st.deductionIndex}())<#t>
	</#if>
</#list>.getTextTemplate()<#t>
</#macro>