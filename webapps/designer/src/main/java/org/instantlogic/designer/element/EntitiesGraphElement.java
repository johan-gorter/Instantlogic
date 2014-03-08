package org.instantlogic.designer.element;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.entity.ApplicationDesignEntity;
import org.instantlogic.interaction.page.Element;
import org.instantlogic.interaction.page.FragmentFilter;
import org.instantlogic.interaction.page.FragmentFilterChain;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;
import org.instantlogic.interaction.util.SubmitContext;

public class EntitiesGraphElement implements FragmentFilter {

	@Override
	public Map<String, Object> render(RenderContext renderContext, String id, FragmentFilterChain chain) {
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		result.put("type", "Graph");
		List<Map<String, Object>> nodes = new ArrayList<>();
		result.put("nodes", nodes);
		Map<String, Object> edges = new LinkedHashMap<String, Object>();
		result.put("edges", edges);
		List<Map<String, Object>> inherits = new ArrayList<>();
		edges.put("inherits", inherits);
		List<Map<String, Object>> ownsMany = new ArrayList<>();
		edges.put("ownsMany", ownsMany);
		List<Map<String, Object>> ownsOne = new ArrayList<>();
		edges.put("ownsOne", ownsOne);
		List<Map<String, Object>> one = new ArrayList<>();
		edges.put("one", one);
		List<Map<String, Object>> many = new ArrayList<>();
		edges.put("many", many);
		ApplicationDesign application = renderContext.getSelectedInstance(ApplicationDesignEntity.INSTANCE);
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
			for (RelationDesign relation : entity.getRelations()) {
				List<Map<String, Object>> category;
				if (relation.getOwner()==Boolean.TRUE) {
					if (relation.getDataType().getMultivalue() == Boolean.TRUE) {
						category = ownsMany;
					} else {
						category = ownsOne;
					}
				} else {
					if (relation.getDataType().getMultivalue() == Boolean.TRUE) {
						category = many;
					} else {
						category = one;
					}
				}
				Map<String, Object> edge = new LinkedHashMap<String, Object>();
				edge.put("id", relation.getMetadata().getUniqueId());
				edge.put("from", entity.getMetadata().getUniqueId());
				edge.put("to", relation.getTo().getMetadata().getUniqueId());
				category.add(edge);
			}
		}
		return result;
	}

	@Override
	public FlowEventOccurrence submit(SubmitContext submitContext, String id, FragmentFilterChain chain) {
		return null;
	}

	@Override
	public void change(ChangeContext changeContext, String id, FragmentFilterChain chain) {
	}

}
