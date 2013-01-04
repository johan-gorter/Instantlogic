<#--
Copyright 2013, Johan Gorter
This file is part of Instantlogic.
Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
General Public License for more details. You should have received a copy of the GNU Lesser General Public License
along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
-->
<#macro text_macro text>
new org.instantlogic.fabric.text.TextTemplate(<#t>
<#list text.untranslated as st>
	<#if st.type=="constant">
        new org.instantlogic.fabric.text.StringTemplate("${st.constant}")<#t>
	</#if>
	<#if st.type=="formattedValue">
		new org.instantlogic.fabric.text.StringTemplate(createDeduction${st.deductionIndex}())<#t>
	</#if>
	<#if st_has_next>,</#if><#t>
</#list>)<#t>
</#macro>