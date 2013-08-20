package org.instantlogic.designer.dataexplorer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.value.RelationValue;
import org.instantlogic.fabric.value.RelationValueList;
import org.instantlogic.fabric.value.WriteableAttributeValue;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEdge;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.flow.impl.ProcessingFlow;
import org.instantlogic.interaction.flow.impl.SimpleFlow;
import org.instantlogic.interaction.flow.impl.SimpleFlowEvent;
import org.instantlogic.interaction.flow.impl.SimpleSubFlow;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

@SuppressWarnings("rawtypes")
public class DataExplorerRelationFlow extends SimpleFlow {
	
	public final FlowEvent removeInstanceEvent;

	private final Entity<?> entity;
	private final Relation relation;
	
	private final DataExplorerRelationDetailsPlaceTemplate relationPlaceTemplate;
	
	// Place, addsubflow for each extensions of relation.to, removesubflow, moveup/down subflows
	private final FlowNodeBase[] nodes;
	private final FlowEdge[] edges;
	private final Entity<?>[] parameters;
	
	// For all add buttons
	private final Map<Entity, FlowEvent> addNewEvents = new HashMap<Entity, FlowEvent>();
	private final FlowEvent shopForInstancesEvent;
	
	public DataExplorerRelationFlow(final DataExplorerEntityFlow parentFlow, final Relation relation, final SimpleFlowEvent relationDetailsEvent) {
		this.entity = parentFlow.getEntity();
		removeInstanceEvent = new SimpleFlowEvent("remove-instance", relation.getTo());
		this.relation = relation;
		this.relationPlaceTemplate = new DataExplorerRelationDetailsPlaceTemplate(this);
		this.parameters = new Entity<?>[]{};
		
		ArrayList<FlowNodeBase> nodeList = new ArrayList<FlowNodeBase>();
		nodeList.add(relationPlaceTemplate);
		
		ArrayList<FlowEdge> edgeList = new ArrayList<FlowEdge>();
		edgeList.add(new FlowEdge(null, relationDetailsEvent, relationPlaceTemplate));
		
		if (relation.isOwner()) {
			shopForInstancesEvent = null;
			List<Entity> entitiesToBeAdded = new ArrayList<Entity>();
			addExtensions(relation.getTo(), entitiesToBeAdded);
			for (final Entity entityToBeAdded : entitiesToBeAdded) {
				SimpleFlowEvent addEvent = new SimpleFlowEvent(entity.getName()+"-"+relation.getName()+"-add-"+entityToBeAdded.getName());
				addNewEvents.put(entityToBeAdded, addEvent);
				Flow addFlow = new ProcessingFlow() {
					@SuppressWarnings("unchecked")
					@Override
					public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
						Instance instance = context.getSelectedInstance(entity);
						Instance newInstance = entityToBeAdded.createInstance();
						((WriteableAttributeValue)relation.get(instance)).setOrAdd(newInstance);
						return new FlowEventOccurrence(relationDetailsEvent);
					}
				};
				SimpleSubFlow subFlow = new SimpleSubFlow(addFlow);
				nodeList.add(subFlow);
				edgeList.add(new FlowEdge(null, addEvent, subFlow));
			}
		} else {
			shopForInstancesEvent = new SimpleFlowEvent(entity.getName()+"-"+relation.getName()+"-shopping");
			Flow shoppingFlow = new ProcessingFlow() {

				@Override
				public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
					List<RelationInstanceShopping> shoppingFor = context.getTraveler().getOrCreateExtension(RelationInstanceShopping.TravelerExtension.class).getCurrentlyShoppingFor();
					shoppingFor.add(new RelationInstanceShopping(relation, context.getSelectedInstance(entity)));
					return new FlowEventOccurrence(relationDetailsEvent);
				}
				
			};
			SimpleSubFlow subFlow = new SimpleSubFlow(shoppingFlow);
			nodeList.add(subFlow);
			edgeList.add(new FlowEdge(null, shopForInstancesEvent, subFlow));
		}
		
		Flow removeFlow = new ProcessingFlow() {
			@SuppressWarnings("unchecked")
			@Override
			public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
				Instance instance = context.getSelectedInstance(entity);
				Instance instanceToRemove = occurrence.getParameters()[0];
				((WriteableAttributeValue)relation.get(instance)).clearOrRemove(instanceToRemove);
				return new FlowEventOccurrence(relationDetailsEvent);
			}
		};
		
		SimpleSubFlow removeSubFlow = new SimpleSubFlow(removeFlow);
		nodeList.add(removeSubFlow);
		edgeList.add(new FlowEdge(null, removeInstanceEvent, removeSubFlow));
		
		this.nodes = nodeList.toArray(new FlowNodeBase[nodeList.size()]);
		this.edges = edgeList.toArray(new FlowEdge[edgeList.size()]);
	}

	private void addExtensions(Entity from, List<Entity> result) {
		result.add(from);
		for (Entity entity:from.extensions()) {
			addExtensions(entity, result);
		}
	}

	
	@Override
	public String getName() {
		return relation.getName();
	}

	@Override
	public FlowNodeBase[] getNodes() {
		return nodes;
	}

	@Override
	public FlowEdge[] getEdges() {
		return edges;
	}

	@Override
	public Entity<? extends Instance>[] getParameters() {
		return parameters;
	}

	public Entity<?> getEntity() {
		return entity;
	}

	public Relation getRelation() {
		return relation;
	}

	public Map<Entity, FlowEvent> getAddNewEvents() {
		return addNewEvents;
	}

	public FlowEvent getShopForInstancesEvent() {
		return shopForInstancesEvent;
	}
}
