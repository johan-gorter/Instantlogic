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