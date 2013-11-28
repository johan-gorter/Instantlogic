package org.instantlogic.designer;

public abstract class AbstractDesignerApplication extends org.instantlogic.interaction.Application {

	public static final DesignerApplication INSTANCE = new DesignerApplication();
	
	protected AbstractDesignerApplication() {
	}
	
	@Override
	public org.instantlogic.fabric.model.Entity<org.instantlogic.designer.ApplicationDesign> getCaseEntity() {
		return org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.interaction.flow.Flow getMainFlow() {
		return org.instantlogic.designer.flow.MainFlow.INSTANCE;
	}

	@Override
	public org.instantlogic.interaction.flow.FlowEvent getStartEvent() {
		return org.instantlogic.designer.event.HomeEvent.INSTANCE;
	}

	
	private static final org.instantlogic.interaction.flow.PlaceTemplate[] PLACE_TEMPLATES = new org.instantlogic.interaction.flow.PlaceTemplate[]{
	};
	
	@Override
	public org.instantlogic.interaction.flow.PlaceTemplate[] getPlaceTemplates() {
		return PLACE_TEMPLATES;
	}

    private static final String[] THEME_NAMES = new String[]{"designer", "margin"};	
	@Override
	public String[] getThemeNames() {
		return THEME_NAMES;
	}
	
	@Override
	public String getName() {
		return "Designer";
	}
}
