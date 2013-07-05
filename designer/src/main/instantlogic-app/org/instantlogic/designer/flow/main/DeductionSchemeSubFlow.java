package org.instantlogic.designer.flow.main;

public class DeductionSchemeSubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final DeductionSchemeSubFlow INSTANCE = new DeductionSchemeSubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.Flow getFlow() {
		return org.instantlogic.designer.flow.DeductionSchemeFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "DeductionScheme";
	}
}
