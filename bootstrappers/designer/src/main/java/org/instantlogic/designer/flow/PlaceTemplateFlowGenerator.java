/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer.flow;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.PlaceTemplateDesignEntityGenerator;
import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.designer.event.CloseEditorEventGenerator;
import org.instantlogic.designer.event.InsertFragmentTemplateBelowEventGenerator;
import org.instantlogic.designer.event.NewAttributeForFragmentTemplateEventGenerator;
import org.instantlogic.designer.event.OpenEditorEventGenerator;
import org.instantlogic.designer.event.PlaceTemplateDetailsEventGenerator;
import org.instantlogic.designer.event.RemoveFragmentTemplateEventGenerator;
import org.instantlogic.designer.flow.placetemplate.PlaceTemplateDetailsPlaceGenerator;

public class PlaceTemplateFlowGenerator extends FlowDesign {
	
	public static final PlaceTemplateFlowGenerator FLOW = new PlaceTemplateFlowGenerator();

	private PlaceTemplateFlowGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToFlows(this);
		setName("PlaceTemplate");
	}
	
	@Override
	public void init() {
		addToParameters(PlaceTemplateDesignEntityGenerator.ENTITY);

		addToNodes(PlaceTemplateDetailsPlaceGenerator.PLACE);
		SubFlowDesign openEditorSubFlow = addSubFlow(OpenEditorFlowGenerator.FLOW);
		SubFlowDesign closeEditorSubFlow = addSubFlow(CloseEditorFlowGenerator.FLOW);
		SubFlowDesign newAttributeSubFlow = addSubFlow(NewAttributeForFragmentTemplateFlowGenerator.FLOW);
		SubFlowDesign insertFragmentTemplateBelowSubFlow = addSubFlow(InsertFragmentTemplateBelowFlowGenerator.FLOW);
		SubFlowDesign removeFragmentTemplateSubFlow = addSubFlow(RemoveFragmentTemplateFlowGenerator.FLOW);
		
		newEdge()
			.setEvent(PlaceTemplateDetailsEventGenerator.EVENT)
			.setEndNode(PlaceTemplateDetailsPlaceGenerator.PLACE);
		
		newEdge()
			.setStartNode(PlaceTemplateDetailsPlaceGenerator.PLACE)
			.setEvent(OpenEditorEventGenerator.EVENT)
			.setEndNode(openEditorSubFlow);
		newEdge()
			.setStartNode(openEditorSubFlow)
			.setEvent(OpenEditorEventGenerator.EVENT)
			.setEndNode(PlaceTemplateDetailsPlaceGenerator.PLACE);
		
		newEdge()
			.setStartNode(PlaceTemplateDetailsPlaceGenerator.PLACE)
			.setEvent(CloseEditorEventGenerator.EVENT)
			.setEndNode(closeEditorSubFlow);
		newEdge()
			.setStartNode(closeEditorSubFlow)
			.setEvent(CloseEditorEventGenerator.EVENT)
			.setEndNode(PlaceTemplateDetailsPlaceGenerator.PLACE);

		newEdge()
			.setStartNode(PlaceTemplateDetailsPlaceGenerator.PLACE)
			.setEvent(NewAttributeForFragmentTemplateEventGenerator.EVENT)
			.setEndNode(newAttributeSubFlow);
		
		newEdge()
			.setStartNode(PlaceTemplateDetailsPlaceGenerator.PLACE)
			.setEvent(InsertFragmentTemplateBelowEventGenerator.EVENT)
			.setEndNode(insertFragmentTemplateBelowSubFlow);
		newEdge()
			.setStartNode(insertFragmentTemplateBelowSubFlow)
			.setEvent(InsertFragmentTemplateBelowEventGenerator.EVENT)
			.setEndNode(PlaceTemplateDetailsPlaceGenerator.PLACE);
		
		newEdge()
			.setStartNode(PlaceTemplateDetailsPlaceGenerator.PLACE)
			.setEvent(RemoveFragmentTemplateEventGenerator.EVENT)
			.setEndNode(removeFragmentTemplateSubFlow);
		newEdge()
			.setStartNode(removeFragmentTemplateSubFlow)
			.setEvent(RemoveFragmentTemplateEventGenerator.EVENT)
			.setEndNode(PlaceTemplateDetailsPlaceGenerator.PLACE);
	
		super.init();
	}
}
