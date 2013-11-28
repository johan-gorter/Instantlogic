package ${rootPackageName};

public<#if isCustomized> abstract</#if> class <#if isCustomized>Abstract</#if>${technicalNameCapitalized}Application extends org.instantlogic.interaction.Application {

	public static final ${technicalNameCapitalized}Application INSTANCE = new ${technicalNameCapitalized}Application();
	
	protected <#if isCustomized>Abstract</#if>${technicalNameCapitalized}Application() {
	}
	
    <#if caseEntity??>	
	@Override
	public org.instantlogic.fabric.model.Entity<${rootPackageName}.${caseEntity}> getCaseEntity() {
		return ${rootPackageName}.entity.${caseEntity}Entity.INSTANCE;
	}
	</#if>

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

    <#if loggedInEvent??>	
	@Override
	public org.instantlogic.interaction.flow.FlowEvent getLoggedInEvent() {
		return ${rootPackageName}.event.${loggedInEvent}Event.INSTANCE;
	}
	</#if>
	
	private static final org.instantlogic.interaction.flow.PlaceTemplate[] PLACE_TEMPLATES = new org.instantlogic.interaction.flow.PlaceTemplate[]{
	<#list placeTemplates as placeTemplate>
		${rootPackageName}.placetemplate.${placeTemplate}PlaceTemplate.INSTANCE,
	</#list>
	};
	
	@Override
	public org.instantlogic.interaction.flow.PlaceTemplate[] getPlaceTemplates() {
		return PLACE_TEMPLATES;
	}

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
