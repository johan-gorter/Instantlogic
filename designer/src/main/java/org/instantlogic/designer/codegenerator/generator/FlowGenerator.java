package org.instantlogic.designer.codegenerator.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.Design;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FlowEdgeDesign;
import org.instantlogic.designer.FlowNodeBaseDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.designer.codegenerator.classmodel.FlowClassModel;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;
import org.instantlogic.fabric.value.Values;

public class FlowGenerator extends AbstractGenerator<FlowClassModel> {

	private FlowDesign flowDesign;

	public FlowGenerator(FlowDesign flowDesign) {
		this.flowDesign = flowDesign;
	}

	private Map<String, PlaceTemplateGenerator> placeTemplateGenerators = new HashMap<String, PlaceTemplateGenerator>();
	private Map<String, SubFlowGenerator> subFlowGenerators = new HashMap<String, SubFlowGenerator>();

	@Override
	public FlowClassModel generate(GeneratedClassModels context) {
		if (observations != null && !observations.isOutdated()) {
			updateAll(placeTemplateGenerators.values(), context);
			updateAll(subFlowGenerators.values(), context);
			return null;
		}

		CaseAdministration caseAdministration = flowDesign.getMetadata()
				.getCaseAdministration();
		caseAdministration.startRecordingObservations();

		FlowClassModel model = new FlowClassModel();
		model.name = flowDesign.getName();
		model.rootPackageName = ((ApplicationDesign)flowDesign.getMetadata().getCase()).getRootPackageName();
		model.technicalNameCapitalized = flowDesign.getTechnicalNameCapitalized();
		model.isCustomized = flowDesign.getIsCustomized() == Boolean.TRUE;

		model.determineIsDeleted(flowDesign.isValidForCodeGeneration());

		for (FlowNodeBaseDesign nodeDesign : flowDesign.getNodes()) {
			FlowClassModel.FlowNode node = new FlowClassModel.FlowNode();
			node.name = nodeDesign.getTechnicalNameCapitalized();
			node.type = nodeDesign.getMetadata().getEntity().getName();
			node.type = node.type.substring(0, node.type.length() - 6); // remove Design
			model.nodes.add(node);
		}
		for (FlowEdgeDesign edgeDesign : flowDesign.getEdges()) {
			FlowClassModel.FlowEdge edge = new FlowClassModel.FlowEdge();
			if (edgeDesign.getStartNode() != null) {
				edge.startNode = edgePoint(edgeDesign.getStartNode());
			}
			if (edgeDesign.getEvent() != null) {
				edge.event = edgeDesign.getEvent().getTechnicalNameCapitalized();
			}
			edge.endNode = edgePoint(edgeDesign.getEndNode());
			model.edges.add(edge);
		}
		for (EntityDesign selectDesign : flowDesign.getParameters()) {
			model.parameters.add(selectDesign.getTechnicalNameCapitalized());
		}

		List<Design> newPages = updateGenerators(placeTemplateGenerators, getPages(flowDesign.getNodes()), context);
		for (Design newPage : newPages) {
			PlaceTemplateGenerator placeTemplateGenerator = new PlaceTemplateGenerator((PlaceTemplateDesign) newPage);
			placeTemplateGenerator.update(context);
			placeTemplateGenerators.put(newPage.getName(),
					placeTemplateGenerator);
		}
		List<Design> newSubFlows = updateGenerators(subFlowGenerators, getSubFlows(flowDesign.getNodes()), context);
		for (Design newSubFlow : newSubFlows) {
			SubFlowGenerator subFlowGenerator = new SubFlowGenerator((SubFlowDesign) newSubFlow);
			subFlowGenerator.update(context);
			subFlowGenerators.put(newSubFlow.getName(), subFlowGenerator);
		}
		this.observations = new ObservationsOutdatedObserver(
				caseAdministration.stopRecordingObservations(), null);
		return model;
	}
	
	@Override
	public void queueClassModel(FlowClassModel classModel, GeneratedClassModels context) {
		context.updatedFlows.add(classModel);
	}

	private List<SubFlowDesign> getSubFlows(Values<FlowNodeBaseDesign> list) {
		ArrayList<SubFlowDesign> result = new ArrayList<SubFlowDesign>();
		for (FlowNodeBaseDesign node : list) {
			if (node instanceof SubFlowDesign) {
				result.add((SubFlowDesign) node);
			}
		}
		return result;
	}

	private List<PlaceTemplateDesign> getPages(Values<FlowNodeBaseDesign> list) {
		ArrayList<PlaceTemplateDesign> result = new ArrayList<PlaceTemplateDesign>();
		for (FlowNodeBaseDesign node : list) {
			if (node instanceof PlaceTemplateDesign) {
				result.add((PlaceTemplateDesign) node);
			}
		}
		return result;
	}

	private static String edgePoint(FlowNodeBaseDesign flowNodeBaseDesign) {
		String name = flowNodeBaseDesign.getTechnicalNameCapitalized();
		String typeName;
		if (flowNodeBaseDesign instanceof PlaceTemplateDesign) {
			typeName = "PlaceTemplate";
		} else if (flowNodeBaseDesign instanceof SubFlowDesign) {
			typeName = "SubFlow";
		} else {
			throw new RuntimeException("Unknown flow node type");
		}
		return name + typeName;
	}
}
