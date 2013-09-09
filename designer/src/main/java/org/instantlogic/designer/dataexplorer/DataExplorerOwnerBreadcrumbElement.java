package org.instantlogic.designer.dataexplorer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;
import org.instantlogic.interaction.page.Element;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;
import org.instantlogic.interaction.util.SubmitContext;

public class DataExplorerOwnerBreadcrumbElement extends Element {

	private final Entity<?> entity;
	private final DataExplorerRootFlow root;
	
	public DataExplorerOwnerBreadcrumbElement(Entity<?> forEntity, DataExplorerRootFlow root) {
		this.entity = forEntity;
		this.root = root;
	}

	@Override
	public void render(RenderContext context, List<Map<String, Object>> appendTo) {
		Instance instance = context.getSelectedInstance(entity);
		for (Relation reverseRelation : entity.getReverseRelations()) {
			if (reverseRelation.getReverseRelation().isOwner()) {
				ReadOnlyAttributeValue attributeValue = reverseRelation.get(instance);
				Instance owner = (Instance) attributeValue.getValue();
				if (owner!=null) { // This only happens once (or never) in the loop
					// The owners hierarchy first
					context.pushSelectedInstance(owner);
					DataExplorerOwnerBreadcrumbElement ownerElement = root.getBreadcrumbElement(reverseRelation.getTo());
					ownerElement.render(context, appendTo);
					context.popSelectedInstance();
					// Owner instance link
					Map<String, Object> ownerInstance = new LinkedHashMap<String, Object>();
					ownerInstance.put("type", "Link");
					ownerInstance.put("id", "breadcrumb-"+((Instance)attributeValue.getValue()).getMetadata().getUniqueId());
					ownerInstance.put("text", reverseRelation.getTo().getName()+" TODO");
					appendTo.add(ownerInstance);
					// Relation link
					Map<String, Object> ownerRelation = new LinkedHashMap<String, Object>();
					ownerRelation.put("type", "Link");
					ownerRelation.put("id", "breadcrumb-TODO");
					ownerRelation.put("text", reverseRelation.getReverseRelation().getName());
					appendTo.add(ownerRelation);
				}
			}
		}
	}

	@Override
	public FlowEventOccurrence submit(SubmitContext submitContext) {
		return null;
	}

	@Override
	public void change(ChangeContext changeContext) {
	}

}
