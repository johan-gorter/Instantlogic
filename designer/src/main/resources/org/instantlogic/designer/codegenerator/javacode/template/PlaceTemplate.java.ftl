/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package ${rootPackageName}.flow.${flowname?lower_case};
<#include "Content.java.ftl">
<#include "Text.java.ftl">
<#include "DeductionScheme.java.ftl">

public<#if isCustomized> abstract</#if> class <#if isCustomized>Abstract</#if>${technicalNameCapitalized}PlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final ${technicalNameCapitalized}PlaceTemplate INSTANCE = new ${technicalNameCapitalized}PlaceTemplate();

	@Override
	public String getId() {
		return "${id}";
	}
	
<#list deductionSchemes as scheme>
	<@deductionscheme_macro scheme=scheme />
</#list>
	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
<@content_macro content=content depth=2 />; 
	
	<#if title??>
	private static final org.instantlogic.fabric.text.TextTemplate TITLE = <@text_macro text=title />;
	@Override
	protected org.instantlogic.fabric.text.TextTemplate getTitle() {
		return TITLE;
	}
	</#if>
	
	@Override
	public org.instantlogic.interaction.page.FragmentTemplate getRootContainer() {
		return CONTENT;
	}; 
	
    @Override
    public String getName() {
        return "${name}";
    }
}