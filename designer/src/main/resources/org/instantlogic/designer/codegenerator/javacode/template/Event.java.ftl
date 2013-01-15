/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package ${rootPackageName}.event;

public<#if isCustomized> abstract</#if> class <#if isCustomized>Abstract</#if>${technicalNameCapitalized}Event extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final ${technicalNameCapitalized}Event INSTANCE = new <#if customization??>${customization}<#else>${technicalNameCapitalized}Event</#if>();

	public <#if isCustomized>Abstract</#if>${technicalNameCapitalized}Event() {
		super("${name}", new org.instantlogic.fabric.model.Entity[]{
<#list parameters as parameter>
			${rootPackageName}.entity.${parameter}Entity.INSTANCE,
</#list>
		});
	}
}
