package org.instantlogic.designer.element;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.entity.ApplicationDesignEntity;
import org.instantlogic.interaction.page.Element;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;
import org.instantlogic.interaction.util.SubmitContext;

public class EntitiesGraphElement extends Element {

	@Override
	public void render(RenderContext context, List<Map<String, Object>> appendTo) {
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		String id = context.enterScope("entities-graph-element");
		result.put("type", "Graph");
		List<Map<String, Object>> nodes = new ArrayList<>();
		result.put("nodes", nodes);
		Map<String, Object> edges = new LinkedHashMap<String, Object>();
		result.put("edges", edges);
		List<Map<String, Object>> inherits = new ArrayList<>();
		edges.put("inherits", inherits);
		ApplicationDesign application = context.getSelectedInstance(ApplicationDesignEntity.INSTANCE);
		for (EntityDesign entity : application.getEntities()) {
			Map<String, Object> node = new LinkedHashMap<String, Object>();
			nodes.add(node);
			node.put("id", entity.getMetadata().getUniqueId());
			if (entity.getExtendsFrom()!=null) {
				Map<String, Object> edge = new LinkedHashMap<String, Object>();
				edge.put("id", entity.getMetadata().getUniqueId()+"-extends");
				edge.put("from", entity.getMetadata().getUniqueId());
				edge.put("to", entity.getExtendsFrom().getMetadata().getUniqueId());
			}
		}
		context.exitScope();
		appendTo.add(result);
	}

	@Override
	public FlowEventOccurrence submit(SubmitContext submitContext) {
		return null;
	}

	@Override
	public void change(ChangeContext changeContext) {
	}

}
