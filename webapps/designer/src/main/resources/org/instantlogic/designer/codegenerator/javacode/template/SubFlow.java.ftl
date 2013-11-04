package ${rootPackageName}.flow.${flowname?lower_case};

public class ${technicalNameCapitalized}SubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final ${technicalNameCapitalized}SubFlow INSTANCE = new ${technicalNameCapitalized}SubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.Flow getFlow() {
		return ${rootPackageName}.flow.${subFlowName}Flow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "${name}";
	}
}
