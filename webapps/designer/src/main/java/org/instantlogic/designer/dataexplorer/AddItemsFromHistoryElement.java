package org.instantlogic.designer.dataexplorer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.value.WriteableAttributeValue;
import org.instantlogic.interaction.page.Element;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.HistoryExtension;
import org.instantlogic.interaction.util.LocationInfo;
import org.instantlogic.interaction.util.RenderContext;
import org.instantlogic.interaction.util.SubmitContext;

public class AddItemsFromHistoryElement extends Element {
	
	@SuppressWarnings("rawtypes")
	private final Relation relation;

	@SuppressWarnings("rawtypes")
	public AddItemsFromHistoryElement(Relation relation) {
		this.relation = relation;
	}

	@Override
	public void render(RenderContext context, List<Map<String, Object>> appendTo) {
		Instance latestRelevantInstance = findLatestRelevantInstance(context);
		if (latestRelevantInstance != null) {
			context.enterScope(getClass().getName());
			String id = context.enterScope(latestRelevantInstance);
			Map<String, Object> result = new LinkedHashMap<String, Object>();
			result.put("type", "Button");
			result.put("id", id);
			if (relation.isMultivalue()) {
				result.put("text", "Add recent: "+ DataExplorerInstanceTitleDeduction.renderTitle(latestRelevantInstance));
			} else {
				result.put("text", "Set to recent: "+ DataExplorerInstanceTitleDeduction.renderTitle(latestRelevantInstance));
			}
			appendTo.add(result);
			context.exitScope();
			context.exitScope();
		}
	}

	private Instance findLatestRelevantInstance(RenderContext context) {
		Instance latestRelevantInstance = null;
		HistoryExtension extension = (context.getTraveler().getExtension(HistoryExtension.class));
		for (LocationInfo location : extension.getHistory()) {
			if (location.getAboutInstanceId()!=null) {
				Instance candidate = location.getAboutInstance(context.getCaseInstance());
				if (Entity.extendsFrom(candidate.getMetadata().getEntity(), relation.getTo())) {
					latestRelevantInstance = candidate;
				}
			}
		}
		return latestRelevantInstance;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public FlowEventOccurrence submit(SubmitContext context) {
		String idPrefix = context.enterScope(getClass().getName());
		if (context.getPageElementId().startsWith(idPrefix)) {
			Instance latestRelevantInstance = findLatestRelevantInstance(context);
			if (latestRelevantInstance!=null) {
				String id = context.enterScope(latestRelevantInstance);
				if (id.equals(context.getPageElementId())) {
					Instance instance = context.getSelectedInstance(relation.getEntity());
					WriteableAttributeValue value = (WriteableAttributeValue) relation.get(instance);
					value.setOrAdd(latestRelevantInstance);
				}
				context.exitScope();
			}
		}
		context.exitScope();
		return null;
	}

	@Override
	public void change(ChangeContext changeContext) {
	}
	
}
