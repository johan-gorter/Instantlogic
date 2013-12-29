package org.instantlogic.designer.placetemplate;

import org.instantlogic.designer.ElementDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.PropertyDesign;
import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public abstract class PlaceTemplateUtil {

	public static Instance getContentOwner(ElementDesign element) {
		Instance candidate = element;
		while (true) {
			candidate = candidate.getMetadata().getInstanceOwner();
			if (candidate==null || (!(candidate instanceof ElementDesign) && !(candidate instanceof PropertyDesign))) {
				return candidate;
			}
		}
	}

	public static FlowEventOccurrence toContentOwner(ElementDesign element) {
		Instance owner = getContentOwner(element);
		if (owner instanceof PlaceTemplateDesign) {
			return new FlowEventOccurrence(PlaceTemplateDetailsPlaceTemplate.INSTANCE, owner);
		}
		throw new RuntimeException("Did not expect owner "+owner);
	}
}
