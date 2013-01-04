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
package ${rootPackageName}.sharedpagefragment;
<#include "Content.java.ftl">
<#include "DeductionScheme.java.ftl">

public<#if isCustomized> abstract</#if> class <#if isCustomized>Abstract</#if>${name}PageFragment extends org.instantlogic.interaction.page.SharedElement {
	
	public static ${name}PageFragment INSTANCE = new ${name}PageFragment();
	
<#list deductionSchemes as scheme>
	<@deductionscheme_macro scheme=scheme />
</#list>
	
	public static final org.instantlogic.interaction.page.Element SHARED_INSTANCE = 
<@content_macro content=content depth=2 />; 

	protected <#if isCustomized>Abstract</#if>${name}PageFragment() {
	    INSTANCE=this;
	}
	
	static {
	    INSTANCE.setElement(SHARED_INSTANCE);
	}
	
}
