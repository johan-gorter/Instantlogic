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
