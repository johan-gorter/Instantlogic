package org.instantlogic.designer.flow;

@SuppressWarnings({"unchecked","rawtypes"})
public class PlaceTemplateFlow extends org.instantlogic.interaction.flow.impl.SimpleFlow {

	public static final PlaceTemplateFlow INSTANCE = new PlaceTemplateFlow();
	
	private static final org.instantlogic.interaction.flow.FlowNodeBase[] NODES = new org.instantlogic.interaction.flow.FlowNodeBase[]{
		org.instantlogic.designer.flow.placetemplate.CloseEditorSubFlow.INSTANCE,
		org.instantlogic.designer.flow.placetemplate.PlaceTemplateDetailsPlaceTemplate.INSTANCE,
		org.instantlogic.designer.flow.placetemplate.InsertFragmentTemplateBelowSubFlow.INSTANCE,
		org.instantlogic.designer.flow.placetemplate.NewAttributeForFragmentTemplateSubFlow.INSTANCE,
		org.instantlogic.designer.flow.placetemplate.OpenEditorSubFlow.INSTANCE,
		org.instantlogic.designer.flow.placetemplate.RemoveFragmentTemplateSubFlow.INSTANCE,
	};
	
	private static final org.instantlogic.interaction.flow.FlowEdge[] EDGES = new org.instantlogic.interaction.flow.FlowEdge[]{
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.placetemplate.PlaceTemplateDetailsPlaceTemplate.INSTANCE, 
			org.instantlogic.designer.event.OpenEditorEvent.INSTANCE,
			org.instantlogic.designer.flow.placetemplate.OpenEditorSubFlow.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.placetemplate.PlaceTemplateDetailsPlaceTemplate.INSTANCE, 
			org.instantlogic.designer.event.RemoveFragmentTemplateEvent.INSTANCE,
			org.instantlogic.designer.flow.placetemplate.RemoveFragmentTemplateSubFlow.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.placetemplate.PlaceTemplateDetailsPlaceTemplate.INSTANCE, 
			org.instantlogic.designer.event.CloseEditorEvent.INSTANCE,
			org.instantlogic.designer.flow.placetemplate.CloseEditorSubFlow.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.placetemplate.PlaceTemplateDetailsPlaceTemplate.INSTANCE, 
			org.instantlogic.designer.event.InsertFragmentTemplateBelowEvent.INSTANCE,
			org.instantlogic.designer.flow.placetemplate.InsertFragmentTemplateBelowSubFlow.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.placetemplate.PlaceTemplateDetailsPlaceTemplate.INSTANCE, 
			org.instantlogic.designer.event.NewAttributeForFragmentTemplateEvent.INSTANCE,
			org.instantlogic.designer.flow.placetemplate.NewAttributeForFragmentTemplateSubFlow.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.placetemplate.CloseEditorSubFlow.INSTANCE, 
			org.instantlogic.designer.event.CloseEditorEvent.INSTANCE,
			org.instantlogic.designer.flow.placetemplate.PlaceTemplateDetailsPlaceTemplate.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.designer.event.PlaceTemplateDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.placetemplate.PlaceTemplateDetailsPlaceTemplate.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.placetemplate.RemoveFragmentTemplateSubFlow.INSTANCE, 
			org.instantlogic.designer.event.RemoveFragmentTemplateEvent.INSTANCE,
			org.instantlogic.designer.flow.placetemplate.PlaceTemplateDetailsPlaceTemplate.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.placetemplate.InsertFragmentTemplateBelowSubFlow.INSTANCE, 
			org.instantlogic.designer.event.InsertFragmentTemplateBelowEvent.INSTANCE,
			org.instantlogic.designer.flow.placetemplate.PlaceTemplateDetailsPlaceTemplate.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			org.instantlogic.designer.flow.placetemplate.OpenEditorSubFlow.INSTANCE, 
			org.instantlogic.designer.event.OpenEditorEvent.INSTANCE,
			org.instantlogic.designer.flow.placetemplate.PlaceTemplateDetailsPlaceTemplate.INSTANCE
		),
	};
	
	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
		org.instantlogic.designer.entity.PlaceTemplateDesignEntity.INSTANCE,
	};
	
	@Override
	public String getName() {
		return "PlaceTemplate";
	}

	@Override
	public org.instantlogic.interaction.flow.FlowNodeBase[] getNodes() {
		return NODES;
	}

	@Override
	public org.instantlogic.interaction.flow.FlowEdge[] getEdges() {
		return EDGES;
	}

	@Override
	public org.instantlogic.fabric.model.Entity[] getParameters() {
		return PARAMETERS;
	}
}
