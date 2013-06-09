

package org.instantlogic.engine.message;

import org.instantlogic.engine.presence.Presence;
import org.instantlogic.engine.presence.Traveler;
import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.util.ChangeContext;

public class ChangeMessage extends Message {

	private final String placeElementId;
	private final Object value;

	public ChangeMessage(String placeElementId, Object value) {
		this.placeElementId = placeElementId;
		this.value = value;
	}

	@Override
	public void execute(Application application, Traveler traveler, Presence presence, Instance theCase) {
		ChangeContext changeContext = ChangeContext.create(application.getMainFlow(), traveler.getCurrentPlace().getUrl(), theCase, presence.getCaseName(), placeElementId, value, traveler.getTravelerInfo());
		PlaceTemplate placeTemplate = (PlaceTemplate)changeContext.getFlowContext().getFlowStack().getCurrentNode();
		placeTemplate.change(changeContext);
	}

	@Override
	public String toString() {
		return "ChangeMessage [placeElementId=" + placeElementId + ", value=" + value + "]";
	}
}
