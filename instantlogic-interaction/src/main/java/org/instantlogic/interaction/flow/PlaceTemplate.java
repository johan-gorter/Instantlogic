package org.instantlogic.interaction.flow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Concept;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.text.TextTemplate;
import org.instantlogic.interaction.page.FragmentTemplate;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.LocationInfo;
import org.instantlogic.interaction.util.SubmitContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

public abstract class PlaceTemplate extends Concept {
	
	public static final Entity<?>[] NO_PARAMETERS = new Entity<?>[0];
	
	public abstract FragmentTemplate getRootContainer();
	
	public abstract String getId();

	public String getTechnicalName()
	{
		return getName();
	}

	public FlowEventOccurrence submit(SubmitContext submitContext) {
		return getRootContainer().submit(submitContext);
	}

	public void change(ChangeContext changeContext) {
		getRootContainer().change(changeContext);
	}
	
	protected TextTemplate getTitle() {
		return null;
	}
	
	// Apply routing, return null if this is the place to be rendered
	public FlowEventOccurrence enter(FlowContext context) {
		return null; // Null means no more events, continue to render the place
	}

	public Map<String, Object> render(final RenderContext renderContext) {
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		TextTemplate title = getTitle();
		// TODO: handle absence of rootContainer gracefully
		getRootContainer().render(renderContext, result);
		if (result.size()!=1) throw new RuntimeException("Rendering resulted in more than one page root");
		Map<String, Object> fragment = result.get(0);
		if (title!=null) {
			fragment.put("title", title.renderText(renderContext));
		}
		fragment.put("placeTemplateId", this.getId());
		return fragment;
	}

	public Entity<?>[] getParameters() {
		return NO_PARAMETERS;
	}

	public LocationInfo provideInfo(RenderContext renderContext) {
		TextTemplate title = getTitle();
		String renderedTitle = "?";
		if (title!=null) {
			renderedTitle = title.renderText(renderContext);
		}
		Instance aboutInstance = renderContext.getSelectedInstance(null);
		return new LocationInfo(renderContext.getLocation(), renderedTitle, getInstanceId(aboutInstance), null);
	}
	
	protected String getInstanceId(Instance instance) {
		if (instance==null) {
			return null;
		}
		if (instance.getMetadata().isStatic()) {
			return instance.getMetadata().getEntity().getName()+"!" + instance.getMetadata().getStaticName();
		}
		return instance.getMetadata().getUniqueId();
	}
}
