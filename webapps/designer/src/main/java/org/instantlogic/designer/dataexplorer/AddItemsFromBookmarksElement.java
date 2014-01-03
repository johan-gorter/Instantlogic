package org.instantlogic.designer.dataexplorer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.value.WriteableAttributeValue;
import org.instantlogic.interaction.page.Element;
import org.instantlogic.interaction.util.BookmarkExtension;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.LocationInfo;
import org.instantlogic.interaction.util.RenderContext;
import org.instantlogic.interaction.util.SubmitContext;

public class AddItemsFromBookmarksElement extends Element {
	
	@SuppressWarnings("rawtypes")
	private final Relation relation;

	@SuppressWarnings("rawtypes")
	public AddItemsFromBookmarksElement(Relation relation) {
		this.relation = relation;
	}

	@Override
	public void render(RenderContext context, List<Map<String, Object>> appendTo) {
		List<Instance> relevantInstances = findRelevantInstances(context);
		context.enterScope(getClass().getName());
		for (Instance relevantInstance : relevantInstances) {
			String id = context.enterScope(relevantInstance);
			Map<String, Object> result = new LinkedHashMap<String, Object>();
			result.put("type", "Button");
			result.put("id", id);
			if (relation.isMultivalue()) {
				result.put("text", "Add bookmarked: "+ DataExplorerInstanceTitleDeduction.renderTitle(relevantInstance));
			} else {
				result.put("text", "Set to bookmarked: "+ DataExplorerInstanceTitleDeduction.renderTitle(relevantInstance));
			}
			appendTo.add(result);
			context.exitScope();
		}
		context.exitScope();
	}

	private List<Instance> findRelevantInstances(RenderContext context) {
		List<Instance> result = new ArrayList<Instance>();
		BookmarkExtension extension = (context.getTraveler().getExtension(BookmarkExtension.class));
		for (LocationInfo location : extension.getBookmarks()) {
			if (location.getAboutInstanceId()!=null) {
				Instance candidate = context.getCaseInstance().getMetadata().getCaseAdministration().getInstanceByUniqueId(location.getAboutInstanceId());
				if (Entity.extendsFrom(candidate.getMetadata().getEntity(), relation.getTo())) {
					if (!result.contains(candidate)) {
						result.add(candidate);
					}
				}
			}
		}
		return result;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public FlowEventOccurrence submit(SubmitContext context) {
		String idPrefix = context.enterScope(getClass().getName());
		if (context.getPageElementId().startsWith(idPrefix)) {
			List<Instance> relevantInstances = findRelevantInstances(context);
			for (Instance relevantInstance : relevantInstances) {
				String id = context.enterScope(relevantInstance);
				if (id.equals(context.getPageElementId())) {
					Instance instance = context.getSelectedInstance(relation.getEntity());
					WriteableAttributeValue value = (WriteableAttributeValue) relation.get(instance);
					value.setOrAdd(relevantInstance);
				}
			}
		}
		context.exitScope();
		return null;
	}

	@Override
	public void change(ChangeContext changeContext) {
	}
	
}
