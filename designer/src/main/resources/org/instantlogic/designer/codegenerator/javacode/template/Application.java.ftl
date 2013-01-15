/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package ${rootPackageName};

public<#if isCustomized> abstract</#if> class <#if isCustomized>Abstract</#if>${technicalNameCapitalized}Application extends org.instantlogic.interaction.Application {

	public static final ${technicalNameCapitalized}Application INSTANCE = new ${technicalNameCapitalized}Application();
	
	protected ${technicalNameCapitalized}Application() {
	}
	
	@Override
	public org.instantlogic.fabric.model.Entity<${rootPackageName}.${caseEntity}> getCaseEntity() {
		return ${rootPackageName}.entity.${caseEntity}Entity.INSTANCE;
	}

    <#if mainFlow??>	
	@Override
	public org.instantlogic.interaction.flow.Flow getMainFlow() {
		return ${rootPackageName}.flow.${mainFlow}Flow.INSTANCE;
	}
	</#if>

    <#if startEvent??>	
	@Override
	public org.instantlogic.interaction.flow.FlowEvent getStartEvent() {
		return ${rootPackageName}.event.${startEvent}Event.INSTANCE;
	}
	</#if>

    <#if themeNames??>
    private static final String[] THEME_NAMES = new String[]{<#list themeNames as name>"${name}"<#if name_has_next>, </#if></#list>};	
	@Override
	public String[] getThemeNames() {
		return THEME_NAMES;
	}
	</#if>
	
	@Override
	public String getName() {
		return "${name}";
	}
}
