<#include "Text.java.ftl">
<#macro content_macro content depth>
  <#list 1..depth-1 as i>    </#list><#t>
  <#if content.category=="Shared">
    new org.instantlogic.interaction.page.SharedElementHolder("${content.id}", ${rootPackageName}.sharedpagefragment.${content.name}PageFragment.INSTANCE)
  <#elseif content.category=="Selection">
    new org.instantlogic.interaction.page.SelectionElement(createDeduction${content.deductionIndex}(),<#lt>
      <#if content.child??>
        <@content_macro content=content.child depth=depth+2 />
      <#else>
        null
      </#if>
    )<#lt>
  <#elseif content.category=="IfElse">
    new org.instantlogic.interaction.page.IfElseElement(createDeduction${content.deductionIndex}(),<#lt>
        <#if content.child??>
          <@content_macro content=content.child depth=depth+2 />
        <#else>
          null<#lt>
        </#if>
        ,<#lt>
        <#if content.elseChild??>
          <@content_macro content=content.elseChild depth=depth+2 />
        <#else>
          null<#lt>
        </#if>
    )<#lt>
  <#elseif content.category=="Fragment">
    new org.instantlogic.interaction.page.FragmentTemplate("${content.id}", "${content.fragmentTypeName}")<#t>
    <#if content.styleNames??>
      <#nt>
      <#list 1..depth as i>    </#list><#t>
      .setStyleNames(new String[]{<#list content.styleNames as name>"${name}"<#if name_has_next>, </#if></#list>})<#t>
    </#if>
    <#if content.fragmentFilters??>
  	<#list content.fragmentFilters as filter>
      <#nt>
      <#list 1..depth as i>    </#list><#t>
        .addCustomFilter(new ${filter}())<#t>
      </#list>
    </#if>
    <#if content.event??>
      <#nt>
      <#list 1..depth as i>    </#list><#t>
      .setEvent(${rootPackageName}.event.${content.event}Event.INSTANCE)<#t>
    </#if>
    <#if content.destination??>
      <#nt>
      <#list 1..depth as i>    </#list><#t>
      .setDestination(${rootPackageName}.placetemplate.${content.destination}PlaceTemplate.INSTANCE)<#t>
    </#if>
    <#if content.attribute??>
      <#nt>
      <#list 1..depth as i>    </#list><#t>
      .setField(${rootPackageName}.entity.${content.entity}Entity.INSTANCE, ${rootPackageName}.entity.${content.entity}Entity.${content.attribute})<#t>
    </#if>
    <#list content.values?keys as key>
      <#nt>
      <#list 1..depth as i>    </#list><#t>
      .putValue("${key}", createDeduction${content.values[key]}())<#t>
    </#list>
    <#list content.texts?keys as key>
      <#nt>
      <#list 1..depth as i>    </#list><#t>
      .putText("${key}", <@text_macro text=content.texts[key] />)<#t>
    </#list>
    <#list content.childLists?keys as key>
      <#list content.childLists[key] as childListChild>
        <#nt>
        <#list 1..depth as i>    </#list><#t>
        .addChild("${key}",<#lt>
          <@content_macro content=childListChild depth=depth+2 /><#t>
        <#nt>
        <#list 1..depth as i>    </#list><#t>
        )<#t>
      </#list>
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