package ${rootPackageName}.event;

public<#if isCustomized> abstract</#if> class <#if isCustomized>Abstract</#if>${technicalNameCapitalized}Event extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final ${technicalNameCapitalized}Event INSTANCE = new <#if customization??>${customization}<#else>${technicalNameCapitalized}Event</#if>();

    // Note: the phase1/phase2 distinction is not implemented here. Thusfar this did not seem neccessary.
	public <#if isCustomized>Abstract</#if>${technicalNameCapitalized}Event() {
		super("${name}", new org.instantlogic.fabric.model.Entity[]{
<#list parameters as parameter>
			${rootPackageName}.entity.${parameter}Entity.INSTANCE,
</#list>
		});
	}
}
