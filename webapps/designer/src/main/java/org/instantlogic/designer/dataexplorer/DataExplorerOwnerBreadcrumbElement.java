package org.instantlogic.designer.dataexplorer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.flow.impl.SimpleFlowEvent;
import org.instantlogic.interaction.page.Element;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;
import org.instantlogic.interaction.util.SubmitContext;

public class DataExplorerOwnerBreadcrumbElement extends Element {

	private static final String[] STYLENAMES_BREADCRUMB_NODE = new String[]{"breadcrumb-node"};
	private final Entity<?> entity;
	private final DataExplorerAdministration administration;
	private boolean includeSelf;
	
	public DataExplorerOwnerBreadcrumbElement(Entity<?> forEntity, DataExplorerAdministration administration, boolean includeSelf) {
		this.entity = forEntity;
		this.administration = administration;
		this.includeSelf = includeSelf;
	}
	
	@Override
	public void render(RenderContext context, List<Map<String, Object>> appendTo) {
		Map<String, Object> self = null;
		if (includeSelf) {
			Instance instance = context.getSelectedInstance(entity);
			String id = context.makeId("breadcrumb");
			
			// Node
			self = new LinkedHashMap<String, Object>();
			self.put("type", "Block");
			self.put("styleNames", STYLENAMES_BREADCRUMB_NODE);
			self.put("id", id+"-0");
			List<Map<String, Object>> selfChildren = new ArrayList<Map<String, Object>>();
			self.put("content", selfChildren);
			
			// Link
			Map<String, Object> link = new LinkedHashMap<String, Object>();
			link.put("type", "Link");
			link.put("id", id+"-instance-"+instance.getMetadata().getUniqueId());
			link.put("text", entity.getName()+" "+instance.renderTitle());
			selfChildren.add(link);
		}
		renderAndWrap(context, appendTo, self, 1);
	}

	public void renderAndWrap(RenderContext context, List<Map<String, Object>> appendTo, Map<String, Object> child, int depth) {
		Instance instance = context.getSelectedInstance(entity);
		String id = context.makeId("breadcrumb"); // We assume there is only one breadcrumb at our parent
		for (Relation reverseRelation : entity.getReverseRelations()) {
			if (reverseRelation.getReverseRelation().isOwner()) {
				ReadOnlyAttributeValue attributeValue = reverseRelation.get(instance);
				Instance owner = (Instance) attributeValue.getValue();
				if (owner!=null) { // This only happens once (or never) in the loop
					// Node
					Map<String, Object> node1 = new LinkedHashMap<String, Object>();
					node1.put("type", "Block");
					node1.put("styleNames", STYLENAMES_BREADCRUMB_NODE);
					node1.put("id", id+"-"+depth);
					List<Map<String, Object>> node1Children = new ArrayList<Map<String, Object>>();
					node1.put("content", node1Children);
					// Owner instance link
					Map<String, Object> ownerInstance = new LinkedHashMap<String, Object>();
					ownerInstance.put("type", "Link");
					ownerInstance.put("id", id+"-instance-"+owner.getMetadata().getUniqueId());
					ownerInstance.put("text", reverseRelation.getTo().getName()+" "+owner.renderTitle());
					node1Children.add(ownerInstance);
					// Node
					Map<String, Object> node2 = new LinkedHashMap<String, Object>();
					node2.put("type", "Block");
					node2.put("styleNames", STYLENAMES_BREADCRUMB_NODE);
					node2.put("id", id+"-"+(depth+1));
					List<Map<String, Object>> node2Children = new ArrayList<Map<String, Object>>();
					node2.put("content", node2Children);
					node1Children.add(node2);
					// Relation link
					Map<String, Object> ownerRelation = new LinkedHashMap<String, Object>();
					ownerRelation.put("type", "Link");
					ownerRelation.put("id", id+"-relation-"+reverseRelation.getReverseRelation().getName()+"-"+owner.getMetadata().getUniqueId());
					ownerRelation.put("text", reverseRelation.getReverseRelation().getName());
					node2Children.add(ownerRelation);
					// Content
					if (child!=null) {
						node2Children.add(child);
					}
					// The owners hierarchy first
					context.pushSelectedInstance(owner);
					DataExplorerOwnerBreadcrumbElement ownerElement = administration.getBreadcrumbElement(reverseRelation.getTo());
					ownerElement.renderAndWrap(context, appendTo, node1, depth+2);
					context.popSelectedInstance();
					return;
				}
			}
		}
		// We did not have an owner, so
		if (child!=null) {
			appendTo.add(child);
		}
	}

	@Override
	public FlowEventOccurrence submit(SubmitContext context) {
		String id = context.makeId("breadcrumb");
		if (context.getPageElementId().startsWith(id)) {
			String suffix = context.getPageElementId().substring(id.length());
			CaseAdministration caseAdministration = context.getCaseInstance().getMetadata().getCaseAdministration();
			if (suffix.startsWith("-relation-")) {
				suffix = suffix.substring("-relation-".length());
				String relationName = suffix.substring(0, suffix.indexOf('-'));
				String uniqueId = suffix.substring(suffix.indexOf('-')+1);
				Instance instance = caseAdministration.getInstanceByUniqueId(uniqueId);
				PlaceTemplate relationDetailsPlaceTemplate = administration.getRelationPlaceTemplate(instance.getMetadata().getEntity(), relationName);
				return new FlowEventOccurrence(relationDetailsPlaceTemplate, instance);
			} else if (suffix.startsWith("-instance-")) {
				String uniqueId = suffix.substring("-instance-".length());
				Instance instance = caseAdministration.getInstanceByUniqueId(uniqueId);
				PlaceTemplate entityDetailsPlaceTemplate = administration.getEntityDetailsPlaceTemplate(instance.getMetadata().getEntity());
				return new FlowEventOccurrence(entityDetailsPlaceTemplate, instance);
			}
		}
		return null;
	}

	@Override
	public void change(ChangeContext changeContext) {
	}

}
