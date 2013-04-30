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
<@content_macro content=content depth=3 />; 
	
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