package org.instantlogic.designer.dataexplorer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.instantlogic.designer.dataexplorer.RelationInstanceShopping.TravelerExtension;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.util.SingleInstanceDeductionContext;
import org.instantlogic.fabric.value.Multi;
import org.instantlogic.fabric.value.RelationValues;
import org.instantlogic.interaction.page.Element;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;
import org.instantlogic.interaction.util.SubmitContext;

public class ShoppingElement extends Element {

	
	private Entity<?> potentialCandidateEntity;

	public ShoppingElement() {
		super();
	}

	public ShoppingElement(Entity<?> potentialCandidateEntity) {
		this.potentialCandidateEntity = potentialCandidateEntity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void render(RenderContext context, List<Map<String, Object>> appendTo) {
		TravelerExtension extension = ((RenderContext)context).getTraveler().getOrCreateExtension(RelationInstanceShopping.TravelerExtension.class);
		for (RelationInstanceShopping cart : extension.getCurrentlyShoppingFor()) {
			String id = context.enterScope(Integer.toHexString(cart.hashCode()));
			Map<String, Object> result = new LinkedHashMap<String, Object>();
			Entity<?> entity = cart.getInstance().getMetadata().getEntity();
			
			result.put("type", "Shopping");
			result.put("id", id);
			result.put("relationName", cart.getRelation().getName());
			result.put("instanceName", DataExplorerEntityDetailsPlaceTemplate.getEntityTitle(entity).renderText(
				new SingleInstanceDeductionContext(cart.getInstance())));
			Multi<?> items = (Multi<?>) cart.getRelation().get(cart.getInstance()).getValue();
			result.put("itemCount", items.size());
			if (Entity.extendsFrom(potentialCandidateEntity, cart.getRelation().getTo())) {
				result.put("addCurrent", true);
			}
			context.exitScope();
		}
	}

	@Override
	public FlowEventOccurrence submit(SubmitContext context) {
		TravelerExtension extension = ((RenderContext)context).getTraveler().getOrCreateExtension(RelationInstanceShopping.TravelerExtension.class);
		RelationInstanceShopping cartToRemove = null;
		for (RelationInstanceShopping cart : extension.getCurrentlyShoppingFor()) {
			String id = context.enterScope(Integer.toHexString(cart.hashCode()));
			if ((id+"-addItem").equals(context.getPageElementId())) {
				RelationValues values = (RelationValues) cart.getRelation().get(cart.getInstance());
				values.addValue(context.getSelectedInstance(null));
			}
			if ((id+"-finished").equals(context.getPageElementId())) {
				cartToRemove = cart;
			}
			context.exitScope();
		}
		if (cartToRemove!=null) {
			extension.getCurrentlyShoppingFor().remove(cartToRemove);
		}
		return null;
	}

	@Override
	public void change(ChangeContext changeContext) {
	}
}
