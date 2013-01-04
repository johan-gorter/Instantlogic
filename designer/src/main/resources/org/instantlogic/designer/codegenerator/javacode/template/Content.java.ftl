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
<#include "Text.java.ftl">
<#macro content_macro content depth>
  <#list 1..depth as i>    </#list><#t>
  <#if content.category=="Shared">
    new org.instantlogic.interaction.page.SharedElementHolder("${content.id}", ${rootPackageName}.sharedpagefragment.${content.name}PageFragment.INSTANCE)
  <#elseif content.category=="Selection">
    new org.instantlogic.interaction.page.SelectionElement(createDeduction${content.deductionIndex}()<#lt>
        <#list content.children as child>
          ,<#t>
          <@content_macro content=child depth=depth+2 />
        </#list>
    )<#lt>
  <#elseif content.category=="IfElse">
    new org.instantlogic.interaction.page.IfElseElement(createDeduction${content.deductionIndex}(),<#lt>
        new org.instantlogic.interaction.page.Element[] {
        <#list content.children as child>
          <@content_macro content=child depth=depth+2 />
          <#if child_has_next>,</#if><#t>
        </#list>
        },
        new org.instantlogic.interaction.page.Element[] {
        <#list content.elseChildren as child>
          <@content_macro content=child depth=depth+2 />
          <#if child_has_next>,</#if><#t>
        </#list>
        }
    )<#lt>
  <#elseif content.category=="Fragment">
    new org.instantlogic.interaction.page.FragmentTemplate("${content.id}", "${content.fragmentTypeName}")<#t>
    <#if content.styleNames??>
      .setStyleNames(new String[]{<#list content.styleNames as name>"${name}"<#if name_has_next>, </#if></#list>})
    </#if>
    <#if content.fragmentFilters??>
    	<#list content.fragmentFilters as filter>
          .addCustomFilter(new ${filter}())
        </#list>
    </#if>
    <#if content.event??>
      .setEvent(${rootPackageName}.event.${content.event}Event.INSTANCE)
    </#if>
    <#if content.attribute??>
      .setField(${rootPackageName}.entity.${content.entity}Entity.INSTANCE, ${rootPackageName}.entity.${content.entity}Entity.${content.attribute})
    </#if>
    <#list content.values?keys as key>
      <#nt>
      <#list 1..depth as i>    </#list><#t>
      .putValue("${key}", createDeduction${content.values[key]}())<#t>
    </#list>
    <#list content.texts?keys as key>
      <#nt>
      <#list 1..depth as i>    </#list><#t>
      .putText("${key}", <@text_macro text=content.texts[key] />)<#lt>
    </#list>
    <#list content.childLists?keys as key>
      <#nt>
      <#list 1..depth as i>    </#list><#t>
      .putChildren("${key}"<#t>
        <#list content.childLists[key] as childListChild>
          ,<#lt>
          <@content_macro content=childListChild depth=depth+2 />
        </#list>
      <#list 1..depth as i>    </#list><#t>
      )<#lt>
    </#list>
  </#if>
</#macro>
<#--

	private static CompositePageFragment CONTENT = new SimpleCompositePageFragment(new PageFragment[]{
		new SimpleCompositePageFragment(CarinsuranceCaseEntity.driver, new PageFragment[]{
			new SimpleCompositePageFragment(new ConstantText("Driver"), new PageFragment[]{
				new SimpleField(DriverEntity.carUse)
			})
		})
	}); 

-->