package org.instantlogic.designer.dataexplorer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.instantlogic.designer.dataexplorer.RelationInstanceShopping.TravelerExtension;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.util.SingleInstanceDeductionContext;
import org.instantlogic.fabric.value.Values;
import org.instantlogic.fabric.value.WriteableAttributeValue;
import org.instantlogic.interaction.page.Element;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;
import org.instantlogic.interaction.util.SubmitContext;

public class ShoppingElement extends Element {

	
	private Entity<?> potentialCandidateEntity;
	private DataExplorerRootFlow root;

	public ShoppingElement(DataExplorerRootFlow root) {
		this.root = root;
	}

	public ShoppingElement(DataExplorerRootFlow root, Entity<?> potentialCandidateEntity) {
		this(root);
		this.potentialCandidateEntity = potentialCandidateEntity;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void render(RenderContext context, List<Map<String, Object>> appendTo) {
		TravelerExtension extension = ((RenderContext)context).getTraveler().getOrCreateExtension(RelationInstanceShopping.TravelerExtension.class);
		for (RelationInstanceShopping cart : extension.getCurrentlyShoppingFor()) {
			String id = context.enterScope(Integer.toHexString(cart.hashCode()));
			Map<String, Object> result = new LinkedHashMap<String, Object>();
			Entity<?> entity = cart.getInstance().getMetadata().getEntity();
			Instance currentInstance = potentialCandidateEntity==null?null:context.getSelectedInstance(potentialCandidateEntity);
			boolean found = false;
			result.put("type", "Shopping");
			result.put("id", id);
			result.put("relationName", cart.getRelation().getName());
			result.put("instanceName", entity.getName()+ " '" + DataExplorerEntityDetailsPlaceTemplate.getEntityTitle(entity).renderText(
				new SingleInstanceDeductionContext(cart.getInstance()))+"'");
			if (cart.getRelation().isMultivalue()) {
				Values items = (Values) cart.getRelation().get(cart.getInstance()).getValue();
				result.put("itemCount", items.size());
				if (currentInstance != null && items.contains(currentInstance)) {
					result.put("thisCanBeRemoved", true);
					found = true;
				}
			} else {
				result.put("single", true);
				if(currentInstance != null && cart.getRelation().get(cart.getInstance()).getValue()==currentInstance) {
					result.put("thisCanBeRemoved", true);
					found = true;
				}
			}
			if (Entity.extendsFrom(potentialCandidateEntity, cart.getRelation().getTo())) {
				if (!found || cart.getRelation().isOrderedMultivalue()) {
					result.put("thisCanBeAdded", true);
				}
			}
			appendTo.add(result);
			context.exitScope();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public FlowEventOccurrence submit(SubmitContext context) {
		TravelerExtension extension = ((RenderContext)context).getTraveler().getOrCreateExtension(RelationInstanceShopping.TravelerExtension.class);
		RelationInstanceShopping cartToRemove = null;
		for (RelationInstanceShopping cart : extension.getCurrentlyShoppingFor()) {
			String id = context.enterScope(Integer.toHexString(cart.hashCode()));
			if ((id+"-addItem").equals(context.getPageElementId())) {
				WriteableAttributeValue value = (WriteableAttributeValue) cart.getRelation().get(cart.getInstance());
				value.setOrAdd(context.getSelectedInstance(potentialCandidateEntity));
			}
			if ((id+"-removeItem").equals(context.getPageElementId())) {
				WriteableAttributeValue value = (WriteableAttributeValue) cart.getRelation().get(cart.getInstance());
				value.clearOrRemove(context.getSelectedInstance(potentialCandidateEntity));
			}
			if ((id+"-finished").equals(context.getPageElementId())) {
				cartToRemove = cart;
			}
			if ((id+"-gotoInstance").equals(context.getPageElementId())) {
				return new FlowEventOccurrence(root.getEntityDetailsEvent(cart.getInstance().getMetadata().getEntity()), cart.getInstance());
			}
			if ((id+"-gotoRelation").equals(context.getPageElementId())) {
				return new FlowEventOccurrence(root.getEntityFlow(cart.getInstance().getMetadata().getEntity()).getRelationDetailsEvent(cart.getRelation()), cart.getInstance());
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
