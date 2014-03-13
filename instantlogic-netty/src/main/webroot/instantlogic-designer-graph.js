YUI.add('instantlogic-designer-graph', function(Y) {

  var designerTest = {
		  "type": "Graph",
		  "id": "graph1",
		  "nodes": [
		   {
		    "id": "EntityDesign_ApplicationDesign",
		    "text": "ApplicationDesign"
		   },
		   {
		    "id": "EntityDesign_AttributeDesign",
		    "text": "AttributeDesign"
		   },
		   {
		    "id": "EntityDesign_DataCategoryDesign",
		    "text": "DataCategoryDesign"
		   },
		   {
		    "id": "EntityDesign_DataTypeDesign",
		    "text": "DataTypeDesign"
		   },
		   {
		    "id": "EntityDesign_DeductionDesign",
		    "text": "DeductionDesign"
		   },
		   {
		    "id": "EntityDesign_DeductionInputDesign",
		    "text": "DeductionInputDesign"
		   },
		   {
		    "id": "EntityDesign_DeductionOperationDesign",
		    "text": "DeductionOperationDesign"
		   },
		   {
		    "id": "EntityDesign_DeductionOperationInputDesign",
		    "text": "DeductionOperationInputDesign"
		   },
		   {
		    "id": "EntityDesign_DeductionOperationParameterDesign",
		    "text": "DeductionOperationParameterDesign"
		   },
		   {
		    "id": "EntityDesign_DeductionParameterDesign",
		    "text": "DeductionParameterDesign"
		   },
		   {
		    "id": "EntityDesign_DeductionSchemeDesign",
		    "text": "DeductionSchemeDesign"
		   },
		   {
		    "id": "EntityDesign_Design",
		    "text": "Design"
		   },
		   {
		    "id": "EntityDesign_DestinationDesign",
		    "text": "DestinationDesign"
		   },
		   {
		    "id": "EntityDesign_ElementDesign",
		    "text": "ElementDesign"
		   },
		   {
		    "id": "EntityDesign_EntityDesign",
		    "text": "EntityDesign"
		   },
		   {
		    "id": "EntityDesign_EventDesign",
		    "text": "EventDesign"
		   },
		   {
		    "id": "EntityDesign_FlowDesign",
		    "text": "FlowDesign"
		   },
		   {
		    "id": "EntityDesign_FlowEdgeDesign",
		    "text": "FlowEdgeDesign"
		   },
		   {
		    "id": "EntityDesign_FlowNodeBaseDesign",
		    "text": "FlowNodeBaseDesign"
		   },
		   {
		    "id": "EntityDesign_FragmentTemplateContentDesign",
		    "text": "FragmentTemplateContentDesign"
		   },
		   {
		    "id": "EntityDesign_FragmentTemplateDesign",
		    "text": "FragmentTemplateDesign"
		   },
		   {
		    "id": "EntityDesign_FragmentTemplateTextDesign",
		    "text": "FragmentTemplateTextDesign"
		   },
		   {
		    "id": "EntityDesign_FragmentTemplateValueDesign",
		    "text": "FragmentTemplateValueDesign"
		   },
		   {
		    "id": "EntityDesign_FragmentTypeDesign",
		    "text": "FragmentTypeDesign"
		   },
		   {
		    "id": "EntityDesign_IfElseDesign",
		    "text": "IfElseDesign"
		   },
		   {
		    "id": "EntityDesign_PlaceParameterDesign",
		    "text": "PlaceParameterDesign"
		   },
		   {
		    "id": "EntityDesign_PlaceTemplateDesign",
		    "text": "PlaceTemplateDesign"
		   },
		   {
		    "id": "EntityDesign_PropertyDesign",
		    "text": "PropertyDesign"
		   },
		   {
		    "id": "EntityDesign_RelationDesign",
		    "text": "RelationDesign"
		   },
		   {
		    "id": "EntityDesign_SelectionDesign",
		    "text": "SelectionDesign"
		   },
		   {
		    "id": "EntityDesign_SharedElementDefinitionDesign",
		    "text": "SharedElementDefinitionDesign"
		   },
		   {
		    "id": "EntityDesign_SharedElementDesign",
		    "text": "SharedElementDesign"
		   },
		   {
		    "id": "EntityDesign_StaticInstanceDesign",
		    "text": "StaticInstanceDesign"
		   },
		   {
		    "id": "EntityDesign_StaticInstanceValueDesign",
		    "text": "StaticInstanceValueDesign"
		   },
		   {
		    "id": "EntityDesign_StringTemplateDesign",
		    "text": "StringTemplateDesign"
		   },
		   {
		    "id": "EntityDesign_SubFlowDesign",
		    "text": "SubFlowDesign"
		   },
		   {
		    "id": "EntityDesign_TextTemplateDesign",
		    "text": "TextTemplateDesign"
		   },
		   {
		    "id": "EntityDesign_ValidationDesign",
		    "text": "ValidationDesign"
		   }
		  ],
		  "edges": {
		   "inherits": [],
		   "ownsMany": [
		    {
		     "id": "RelationDesign_customDeductionOperations",
		     "from": "EntityDesign_ApplicationDesign",
		     "to": "EntityDesign_DeductionOperationDesign"
		    },
		    {
		     "id": "RelationDesign_entities",
		     "from": "EntityDesign_ApplicationDesign",
		     "to": "EntityDesign_EntityDesign"
		    },
		    {
		     "id": "RelationDesign_events",
		     "from": "EntityDesign_ApplicationDesign",
		     "to": "EntityDesign_EventDesign"
		    },
		    {
		     "id": "RelationDesign_flows",
		     "from": "EntityDesign_ApplicationDesign",
		     "to": "EntityDesign_FlowDesign"
		    },
		    {
		     "id": "RelationDesign_fragmentTypes",
		     "from": "EntityDesign_ApplicationDesign",
		     "to": "EntityDesign_FragmentTypeDesign"
		    },
		    {
		     "id": "RelationDesign_placeTemplates",
		     "from": "EntityDesign_ApplicationDesign",
		     "to": "EntityDesign_PlaceTemplateDesign"
		    },
		    {
		     "id": "RelationDesign_sharedElements",
		     "from": "EntityDesign_ApplicationDesign",
		     "to": "EntityDesign_SharedElementDefinitionDesign"
		    },
		    {
		     "id": "RelationDesign_inputs",
		     "from": "EntityDesign_DeductionDesign",
		     "to": "EntityDesign_DeductionInputDesign"
		    },
		    {
		     "id": "RelationDesign_parameters",
		     "from": "EntityDesign_DeductionDesign",
		     "to": "EntityDesign_DeductionParameterDesign"
		    },
		    {
		     "id": "RelationDesign_inputs_2",
		     "from": "EntityDesign_DeductionOperationDesign",
		     "to": "EntityDesign_DeductionOperationInputDesign"
		    },
		    {
		     "id": "RelationDesign_parameters_1",
		     "from": "EntityDesign_DeductionOperationDesign",
		     "to": "EntityDesign_DeductionOperationParameterDesign"
		    },
		    {
		     "id": "RelationDesign_deductions",
		     "from": "EntityDesign_DeductionSchemeDesign",
		     "to": "EntityDesign_DeductionDesign"
		    },
		    {
		     "id": "RelationDesign_attributes",
		     "from": "EntityDesign_EntityDesign",
		     "to": "EntityDesign_AttributeDesign"
		    },
		    {
		     "id": "RelationDesign_relations",
		     "from": "EntityDesign_EntityDesign",
		     "to": "EntityDesign_RelationDesign"
		    },
		    {
		     "id": "RelationDesign_staticInstances",
		     "from": "EntityDesign_EntityDesign",
		     "to": "EntityDesign_StaticInstanceDesign"
		    },
		    {
		     "id": "RelationDesign_validations",
		     "from": "EntityDesign_EntityDesign",
		     "to": "EntityDesign_ValidationDesign"
		    },
		    {
		     "id": "RelationDesign_edges",
		     "from": "EntityDesign_FlowDesign",
		     "to": "EntityDesign_FlowEdgeDesign"
		    },
		    {
		     "id": "RelationDesign_nodes",
		     "from": "EntityDesign_FlowDesign",
		     "to": "EntityDesign_FlowNodeBaseDesign"
		    },
		    {
		     "id": "RelationDesign_contents",
		     "from": "EntityDesign_FragmentTemplateDesign",
		     "to": "EntityDesign_FragmentTemplateContentDesign"
		    },
		    {
		     "id": "RelationDesign_properties",
		     "from": "EntityDesign_FragmentTemplateDesign",
		     "to": "EntityDesign_PropertyDesign"
		    },
		    {
		     "id": "RelationDesign_texts",
		     "from": "EntityDesign_FragmentTemplateDesign",
		     "to": "EntityDesign_FragmentTemplateTextDesign"
		    },
		    {
		     "id": "RelationDesign_values",
		     "from": "EntityDesign_FragmentTemplateDesign",
		     "to": "EntityDesign_FragmentTemplateValueDesign"
		    },
		    {
		     "id": "RelationDesign_parameters_4",
		     "from": "EntityDesign_PlaceTemplateDesign",
		     "to": "EntityDesign_PlaceParameterDesign"
		    },
		    {
		     "id": "RelationDesign_children",
		     "from": "EntityDesign_PropertyDesign",
		     "to": "EntityDesign_ElementDesign"
		    },
		    {
		     "id": "RelationDesign_values_2",
		     "from": "EntityDesign_StaticInstanceDesign",
		     "to": "EntityDesign_StaticInstanceValueDesign"
		    },
		    {
		     "id": "RelationDesign_untranslated",
		     "from": "EntityDesign_TextTemplateDesign",
		     "to": "EntityDesign_StringTemplateDesign"
		    }
		   ],
		   "ownsOne": [
		    {
		     "id": "RelationDesign_dataType",
		     "from": "EntityDesign_AttributeDesign",
		     "to": "EntityDesign_DataTypeDesign"
		    },
		    {
		     "id": "RelationDesign_default",
		     "from": "EntityDesign_AttributeDesign",
		     "to": "EntityDesign_DeductionSchemeDesign"
		    },
		    {
		     "id": "RelationDesign_explanation",
		     "from": "EntityDesign_AttributeDesign",
		     "to": "EntityDesign_TextTemplateDesign"
		    },
		    {
		     "id": "RelationDesign_question",
		     "from": "EntityDesign_AttributeDesign",
		     "to": "EntityDesign_TextTemplateDesign"
		    },
		    {
		     "id": "RelationDesign_relevance",
		     "from": "EntityDesign_AttributeDesign",
		     "to": "EntityDesign_DeductionSchemeDesign"
		    },
		    {
		     "id": "RelationDesign_rule",
		     "from": "EntityDesign_AttributeDesign",
		     "to": "EntityDesign_DeductionSchemeDesign"
		    },
		    {
		     "id": "RelationDesign_dataType_3",
		     "from": "EntityDesign_EntityDesign",
		     "to": "EntityDesign_DataTypeDesign"
		    },
		    {
		     "id": "RelationDesign_title",
		     "from": "EntityDesign_EntityDesign",
		     "to": "EntityDesign_TextTemplateDesign"
		    },
		    {
		     "id": "RelationDesign_destination",
		     "from": "EntityDesign_FragmentTemplateDesign",
		     "to": "EntityDesign_DestinationDesign"
		    },
		    {
		     "id": "RelationDesign_condition",
		     "from": "EntityDesign_IfElseDesign",
		     "to": "EntityDesign_DeductionSchemeDesign"
		    },
		    {
		     "id": "RelationDesign_elseChild",
		     "from": "EntityDesign_IfElseDesign",
		     "to": "EntityDesign_ElementDesign"
		    },
		    {
		     "id": "RelationDesign_ifChild",
		     "from": "EntityDesign_IfElseDesign",
		     "to": "EntityDesign_ElementDesign"
		    },
		    {
		     "id": "RelationDesign_content",
		     "from": "EntityDesign_PlaceTemplateDesign",
		     "to": "EntityDesign_ElementDesign"
		    },
		    {
		     "id": "RelationDesign_title_1",
		     "from": "EntityDesign_PlaceTemplateDesign",
		     "to": "EntityDesign_TextTemplateDesign"
		    },
		    {
		     "id": "RelationDesign_text",
		     "from": "EntityDesign_PropertyDesign",
		     "to": "EntityDesign_TextTemplateDesign"
		    },
		    {
		     "id": "RelationDesign_value",
		     "from": "EntityDesign_PropertyDesign",
		     "to": "EntityDesign_DeductionSchemeDesign"
		    },
		    {
		     "id": "RelationDesign_options",
		     "from": "EntityDesign_RelationDesign",
		     "to": "EntityDesign_DeductionSchemeDesign"
		    },
		    {
		     "id": "RelationDesign_reverseDataType",
		     "from": "EntityDesign_RelationDesign",
		     "to": "EntityDesign_DataTypeDesign"
		    },
		    {
		     "id": "RelationDesign_child",
		     "from": "EntityDesign_SelectionDesign",
		     "to": "EntityDesign_ElementDesign"
		    },
		    {
		     "id": "RelationDesign_selection",
		     "from": "EntityDesign_SelectionDesign",
		     "to": "EntityDesign_DeductionSchemeDesign"
		    },
		    {
		     "id": "RelationDesign_fragment",
		     "from": "EntityDesign_SharedElementDefinitionDesign",
		     "to": "EntityDesign_ElementDesign"
		    },
		    {
		     "id": "RelationDesign_description",
		     "from": "EntityDesign_StaticInstanceDesign",
		     "to": "EntityDesign_TextTemplateDesign"
		    },
		    {
		     "id": "RelationDesign_deduction",
		     "from": "EntityDesign_StringTemplateDesign",
		     "to": "EntityDesign_DeductionSchemeDesign"
		    },
		    {
		     "id": "RelationDesign_message",
		     "from": "EntityDesign_ValidationDesign",
		     "to": "EntityDesign_TextTemplateDesign"
		    },
		    {
		     "id": "RelationDesign_rule_1",
		     "from": "EntityDesign_ValidationDesign",
		     "to": "EntityDesign_DeductionSchemeDesign"
		    }
		   ],
		   "one": [
		    {
		     "id": "RelationDesign_caseEntity",
		     "from": "EntityDesign_ApplicationDesign",
		     "to": "EntityDesign_EntityDesign"
		    },
		    {
		     "id": "RelationDesign_loggedInEvent",
		     "from": "EntityDesign_ApplicationDesign",
		     "to": "EntityDesign_EventDesign"
		    },
		    {
		     "id": "RelationDesign_loggedInPlace",
		     "from": "EntityDesign_ApplicationDesign",
		     "to": "EntityDesign_PlaceTemplateDesign"
		    },
		    {
		     "id": "RelationDesign_mainFlow",
		     "from": "EntityDesign_ApplicationDesign",
		     "to": "EntityDesign_FlowDesign"
		    },
		    {
		     "id": "RelationDesign_startEvent",
		     "from": "EntityDesign_ApplicationDesign",
		     "to": "EntityDesign_EventDesign"
		    },
		    {
		     "id": "RelationDesign_startPlace",
		     "from": "EntityDesign_ApplicationDesign",
		     "to": "EntityDesign_PlaceTemplateDesign"
		    },
		    {
		     "id": "RelationDesign_belongsToEntity",
		     "from": "EntityDesign_AttributeDesign",
		     "to": "EntityDesign_EntityDesign"
		    },
		    {
		     "id": "RelationDesign_dataCategory",
		     "from": "EntityDesign_DataTypeDesign",
		     "to": "EntityDesign_DataCategoryDesign"
		    },
		    {
		     "id": "RelationDesign_entity",
		     "from": "EntityDesign_DataTypeDesign",
		     "to": "EntityDesign_EntityDesign"
		    },
		    {
		     "id": "RelationDesign_dataType_1",
		     "from": "EntityDesign_DeductionDesign",
		     "to": "EntityDesign_DataTypeDesign"
		    },
		    {
		     "id": "RelationDesign_operation",
		     "from": "EntityDesign_DeductionDesign",
		     "to": "EntityDesign_DeductionOperationDesign"
		    },
		    {
		     "id": "RelationDesign_operationInput",
		     "from": "EntityDesign_DeductionInputDesign",
		     "to": "EntityDesign_DeductionOperationInputDesign"
		    },
		    {
		     "id": "RelationDesign_outputDataType",
		     "from": "EntityDesign_DeductionOperationDesign",
		     "to": "EntityDesign_DataTypeDesign"
		    },
		    {
		     "id": "RelationDesign_dataType_2",
		     "from": "EntityDesign_DeductionOperationInputDesign",
		     "to": "EntityDesign_DataTypeDesign"
		    },
		    {
		     "id": "RelationDesign_attributeValue",
		     "from": "EntityDesign_DeductionParameterDesign",
		     "to": "EntityDesign_AttributeDesign"
		    },
		    {
		     "id": "RelationDesign_entityValue",
		     "from": "EntityDesign_DeductionParameterDesign",
		     "to": "EntityDesign_EntityDesign"
		    },
		    {
		     "id": "RelationDesign_operationParameter",
		     "from": "EntityDesign_DeductionParameterDesign",
		     "to": "EntityDesign_DeductionOperationParameterDesign"
		    },
		    {
		     "id": "RelationDesign_staticInstanceValue",
		     "from": "EntityDesign_DeductionParameterDesign",
		     "to": "EntityDesign_StaticInstanceDesign"
		    },
		    {
		     "id": "RelationDesign_output",
		     "from": "EntityDesign_DeductionSchemeDesign",
		     "to": "EntityDesign_DeductionDesign"
		    },
		    {
		     "id": "RelationDesign_selectedDeduction",
		     "from": "EntityDesign_DeductionSchemeDesign",
		     "to": "EntityDesign_DeductionDesign"
		    },
		    {
		     "id": "RelationDesign_PlaceTemplate",
		     "from": "EntityDesign_DestinationDesign",
		     "to": "EntityDesign_PlaceTemplateDesign"
		    },
		    {
		     "id": "RelationDesign_extendsFrom",
		     "from": "EntityDesign_EntityDesign",
		     "to": "EntityDesign_EntityDesign"
		    },
		    {
		     "id": "RelationDesign_endNode",
		     "from": "EntityDesign_FlowEdgeDesign",
		     "to": "EntityDesign_FlowNodeBaseDesign"
		    },
		    {
		     "id": "RelationDesign_event",
		     "from": "EntityDesign_FlowEdgeDesign",
		     "to": "EntityDesign_EventDesign"
		    },
		    {
		     "id": "RelationDesign_startNode",
		     "from": "EntityDesign_FlowEdgeDesign",
		     "to": "EntityDesign_FlowNodeBaseDesign"
		    },
		    {
		     "id": "RelationDesign_attribute",
		     "from": "EntityDesign_FragmentTemplateDesign",
		     "to": "EntityDesign_AttributeDesign"
		    },
		    {
		     "id": "RelationDesign_entity_1",
		     "from": "EntityDesign_FragmentTemplateDesign",
		     "to": "EntityDesign_EntityDesign"
		    },
		    {
		     "id": "RelationDesign_event_1",
		     "from": "EntityDesign_FragmentTemplateDesign",
		     "to": "EntityDesign_EventDesign"
		    },
		    {
		     "id": "RelationDesign_linkToPlaceTemplate",
		     "from": "EntityDesign_FragmentTemplateDesign",
		     "to": "EntityDesign_PlaceTemplateDesign"
		    },
		    {
		     "id": "RelationDesign_type",
		     "from": "EntityDesign_FragmentTemplateDesign",
		     "to": "EntityDesign_FragmentTypeDesign"
		    },
		    {
		     "id": "RelationDesign_entity_2",
		     "from": "EntityDesign_PlaceParameterDesign",
		     "to": "EntityDesign_EntityDesign"
		    },
		    {
		     "id": "RelationDesign_to",
		     "from": "EntityDesign_RelationDesign",
		     "to": "EntityDesign_EntityDesign"
		    },
		    {
		     "id": "RelationDesign_definition",
		     "from": "EntityDesign_SharedElementDesign",
		     "to": "EntityDesign_SharedElementDefinitionDesign"
		    },
		    {
		     "id": "RelationDesign_attribute_1",
		     "from": "EntityDesign_StaticInstanceValueDesign",
		     "to": "EntityDesign_AttributeDesign"
		    },
		    {
		     "id": "RelationDesign_relationValue",
		     "from": "EntityDesign_StaticInstanceValueDesign",
		     "to": "EntityDesign_StaticInstanceDesign"
		    },
		    {
		     "id": "RelationDesign_flow",
		     "from": "EntityDesign_SubFlowDesign",
		     "to": "EntityDesign_FlowDesign"
		    }
		   ],
		   "many": [
		    {
		     "id": "RelationDesign_inputs_1",
		     "from": "EntityDesign_DeductionInputDesign",
		     "to": "EntityDesign_DeductionDesign"
		    },
		    {
		     "id": "RelationDesign_parameters_2",
		     "from": "EntityDesign_EventDesign",
		     "to": "EntityDesign_EntityDesign"
		    },
		    {
		     "id": "RelationDesign_parameters_3",
		     "from": "EntityDesign_FlowDesign",
		     "to": "EntityDesign_EntityDesign"
		    },
		    {
		     "id": "RelationDesign_displayWith",
		     "from": "EntityDesign_ValidationDesign",
		     "to": "EntityDesign_AttributeDesign"
		    }
		   ]
		  },
		  "startNodeId": "EntityDesign_ApplicationDesign"
		 }; 
	
  var test = {
		  "type": "Graph",
		  "id": "graph1",
		  "nodes": [
		   {
		    "id": "EntityDesign_comment",
		    "text": "comment"
		   },
		   {
		    "id": "EntityDesign_issue",
		    "text": "issue"
		   },
		   {
		    "id": "EntityDesign_issueStatus",
		    "text": "issueStatus"
		   },
		   {
		    "id": "EntityDesign_project",
		    "text": "project"
		   },
		   {
		    "id": "EntityDesign_user",
		    "text": "user"
		   }
		  ],
		  "edges": {
		   "inherits": [],
		   "ownsMany": [
		    {
		     "id": "RelationDesign_comments",
		     "from": "EntityDesign_issue",
		     "to": "EntityDesign_comment"
		    },
		    {
		     "id": "RelationDesign_issues",
		     "from": "EntityDesign_project",
		     "to": "EntityDesign_issue"
		    },
		    {
		     "id": "RelationDesign_users",
		     "from": "EntityDesign_project",
		     "to": "EntityDesign_user"
		    }
		   ],
		   "ownsOne": [],
		   "one": [
		    {
		     "id": "RelationDesign_by",
		     "from": "EntityDesign_comment",
		     "to": "EntityDesign_user"
		    },
		    {
		     "id": "RelationDesign_assignee",
		     "from": "EntityDesign_issue",
		     "to": "EntityDesign_user"
		    },
		    {
		     "id": "RelationDesign_reporter",
		     "from": "EntityDesign_issue",
		     "to": "EntityDesign_user"
		    },
		    {
		     "id": "RelationDesign_status",
		     "from": "EntityDesign_issue",
		     "to": "EntityDesign_issueStatus"
		    }
		   ],
		   "many": []
		  },
		  "startNodeId": "EntityDesign_project"
		 };	
	
  var ns = Y.namespace('instantlogic.designer.graph');
  var html = Y.html;
  var createFragment = Y.instantlogic.createFragment;

  var svg = Y.svg;
  
  var sqr = function (a) {
    return a * a;
  };

  var speed = 5;
  var dragFactor = 0.08;
  var repelFactor = 4;
  var accFactor = speed / 1000000;

  edgeTypes = {
    inherits: { // subclass -> superclass
      preferredDx: 0,
      preferredDy: -100, // from below
      dxGrow: 10,
      dxShrink: 10,
      dyGrow: 100, // repel hard
      dyShrink: 30 // attract
    },
    one: { 
      preferredDx: 100,
      preferredDy: -100,
      dxGrow: 10,
      dxShrink: 10,
      dyGrow: 10,
      dyShrink: 10
    },
    many: { 
      preferredDx: 100,
      preferredDy: 50,
      dxGrow: 10,
      dxShrink: 10,
      dyGrow: 10,
      dyShrink: 10
    },
    ownsOne: { 
      preferredDx: 50,
      preferredDy: 50,
      dxGrow: 10,
      dxShrink: 10,
      dyGrow: 10,
      dyShrink: 10
    },
    ownsMany: { 
      preferredDx: 0,
      preferredDy: 75,
      dxGrow: 10,
      dxShrink: 10,
      dyGrow: 10,
      dyShrink: 10
    }
  };

  window.Physics.behavior('edge', function (parent) {
    return {

      init: function (options) {
        parent.init.call(this, options);
        this.graph = options.graph;
      },
      behave: function (data) {
        var scratch = window.Physics.scratchpad();
        var edges = this.graph.edges;
        var vector = scratch.vector();
        for(var i = 0; i < edges.length; i++) {
          var edge = edges[i];
          if(edge.isVisible()) {
            var from = edge.fromNode.point;
            var to = edge.toNode.point;
            var type = edge.type;
            var dx = to.state.pos.get(0) - from.state.pos.get(0);
            var dy = to.state.pos.get(1) - from.state.pos.get(1);
            var xDeviation = dx - type.preferredDx;
            var yDeviation = dy - type.preferredDy;
            var addX, addY;
            if(xDeviation < 0) {
              addX = -xDeviation * type.dxShrink * accFactor;
            } else {
              addX = -xDeviation * type.dxGrow * accFactor;
            }
            if(yDeviation < 0) {
              addY = -yDeviation * type.dyShrink * accFactor;
            } else {
              addY = -yDeviation * type.dyGrow * accFactor;
            }
            vector.set(addX, addY);
            to.accelerate(vector);
            from.accelerate(vector.negate());
          }
        }
        scratch.done();
      }
    };
  });

  // Node

  var Node = function (id, text, graph) {
    this.id = id;
    this.text = text;
    this.graph = graph;
    this.width = 100;
    this.height = 20;
    this.frozenBeforeDrag = false;
  };

  Node.prototype = {
    appear: function (x, y) {
      this.node = svg.svg({ width: this.width, height: this.height, x: -this.width/2, y: -this.height/2},
        this.bottomRect = svg.rect({ stroke: 'black', 'stroke-width': 1, fill: '#666666', width: 100, height: 20, rx: 10, ry: 10 }),
        svg.text({ 'font-family': '"Helvetica Neue", Helvetica, Arial, sans-serif', 'font-size': '15px', fill: 'white', y:15, x:2.5}, this.text)
      );
      this.moveTo(x, y);
      this.graph.nodesContainer.appendChild(this.node);
      this.node.on('mousedown', this.onMousedown, this);
      this.point = window.Physics.body("point", { x: x, y: y });
      this.graph.world.add(this.point);
    },
    disappear: function () {
      this.graph.world.remove(this.point);
      this.node.remove();
      this.node = this.point = null;
    },
    isVisible: function () {
      return !!this.node;
    },
    isExpanded: function () {
      return this.point && this.point.fixed;
    },
    freeze: function () {
      this.point.fixed = true;
      this.bottomRect.setAttribute('fill', 'blue');
    },
    unfreeze: function () {
      this.point.fixed = false;
      this.bottomRect.setAttribute('fill', '#666666');
    },
    onMousedown: function (evt) {
      evt.preventDefault();
      this.frozenBeforeDrag = this.point.fixed;
      this.graph.startDrag(this, evt);
      this.freeze();
    },
    endDrag: function (moved) {
      if (this.point.fixed) {
        if(moved) {
          this.freeze();
          this.graph.addRelatedNodes(this);
        } else {
          if(this.frozenBeforeDrag) {
            this.unfreeze();
            this.graph.removeUnrelatedNodes(this);
          } else {
            this.graph.addRelatedNodes(this);
          }
        }
      }
    },
    moveTo: function (x, y) {
      this.x = x;
      this.y = y;
      this.renderXY();
      if (this.point) {
        this.point.state.pos.clone(window.Physics.vector(x, y));
      }
    },
    render: function () {
      if(this.point && !this.point.fixed) {
        this.x = this.point.state.pos.get(0);
        this.y = this.point.state.pos.get(1);
        this.renderXY();
      }
    },
    renderXY: function () {
      this.node.setAttribute("x", this.x - this.width / 2);
      this.node.setAttribute("y", this.y - this.height / 2);
    }
  };

  var Edge = function (graph, fromNode, toNode, type) {
    this.graph = graph;
    this.fromNode = fromNode;
    this.toNode = toNode;
    this.type = edgeTypes[type];
    if(!this.type) {
      throw new Error("unknown edge type: " + type);
    }
  };

  Edge.prototype = {
    appear: function () {
      if(this.node) throw new Error("already visible");
      this.node = svg.line({ stroke: 'black', 'stroke-width': 1 });
      this.render();
      this.graph.edgesContainer.appendChild(this.node);
    },
    disappear: function () {
      this.node.remove();
      this.node = null;
    },
    adjustVisibility: function () {
      var desiredVisibility = this.fromNode.isVisible() && this.toNode.isVisible();
      if(this.isVisible()) {
        if(!desiredVisibility) {
          this.disappear();
        }
      } else {
        if (desiredVisibility) {
          this.appear();
        }
      }
    },
    isVisible: function () {
      return !!this.node;
    },
    render: function () {
      if(this.node) {
        this.node.setAttribute("x1", this.fromNode.x);
        this.node.setAttribute("y1", this.fromNode.y);
        this.node.setAttribute("x2", this.toNode.x);
        this.node.setAttribute("y2", this.toNode.y);
      }
    }
  };

  ns.Graph = createFragment({
    createMarkup: function() {
      this.width = 800;
      this.height = 500;
      var result = html.div({ className: 'graph'},
        this.node = svg.svg({ viewBox: [-this.width / 2, -this.height/2, this.width, this.height].toString() },
          this.background = svg.rect({x:-this.width/2+0.5,y:-this.height/2+0.5, width:this.width-1, height: this.height-1, fill: 'white', stroke:'black', 'stroke-width':1}),
          this.edgesContainer = svg.g(),
          this.nodesContainer = svg.g()
        )
      );
      this.node.on("click", this.onClick, this);
      this.node.on("mouseup", this.onMouseup, this);
      this.node.on("mousemove", this.onMousemove, this);
      return result;
    },
    postInit: function (model) {
      this.nodes = {};
      this.edges = [];
      this.startPhysics();
      for (var i = 0; i < model.nodes.length; i++) {
        var modelNode = model.nodes[i];
        this.nodes[modelNode.id] = new Node(modelNode.id, modelNode.text, this);
      }
      for (var edgeType in model.edges) {
        var edgeArray = model.edges[edgeType];
        for(var j = 0; j < edgeArray.length; j++) {
          var modelEdge = edgeArray[j];
          var edge = new Edge(this, this.nodes[modelEdge.from], this.nodes[modelEdge.to], edgeType);
          this.edges.push(edge);
        }
      }
      var startNode = this.nodes[model.startNodeId];
      startNode.appear(0, 0);
      startNode.freeze();
      this.addRelatedNodes(startNode);
    },
    postUpdate: function (newModel, diff) {
	  },    
    overrides: {
      addRelatedNodes: function (node) {
        var offset = 0;
        for (var i = 0; i < this.edges.length; i++) {
          var otherNode = null;
          var edge = this.edges[i];
          if (edge.fromNode === node) {
            otherNode = edge.toNode;
          } else if (edge.toNode === node) {
            otherNode = edge.fromNode;
          }
          if (otherNode) {
            if(!otherNode.isVisible()) {
              otherNode.appear(this.width / 2, offset++ * this.height / 10);
            }
            if(!edge.isVisible()) {
              edge.appear();
            }
          }
        }
        this.adjustEdgeVisibilities();
      },
      adjustNodeVisibility: function (node) {
        for (var j = 0; j < this.edges.length; j++) {
          var otherNode = null;
          var edge = this.edges[j];
          if (edge.fromNode === node) {
            otherNode = edge.toNode;
          } else if (edge.toNode === node) {
            otherNode = edge.fromNode;
          }
          if(otherNode && otherNode.isExpanded()) return;
        }
        node.disappear();
      },
      removeUnrelatedNodes: function (node) {
        // node is no longer expanded, remove all surrounding nodes that are not visible for any other reason
        this.adjustNodeVisibility(node);
        for(var i = 0; i < this.edges.length; i++) {
          var otherNode = null;
          var edge = this.edges[i];
          if (edge.fromNode === node) {
            otherNode = edge.toNode;
          } else if (edge.toNode === node) {
            otherNode = edge.fromNode;
          }
          if(otherNode && otherNode.isVisible() && !otherNode.isExpanded()) {
            this.adjustNodeVisibility(otherNode);
          }
        }
        this.adjustEdgeVisibilities();
      },
      adjustEdgeVisibilities: function () {
        for(var i = 0; i < this.edges.length; i++) {
          this.edges[i].adjustVisibility();
        }
      },
      startPhysics: function () {
        this.world = new window.Physics({
          timestep: 1000.0 / 160,
          maxIPF: 16
        });
        this.world.add(window.Physics.integrator('verlet', { drag: dragFactor }));
        this.world.add(window.Physics.behavior('newtonian', { strength: -repelFactor }));
        this.world.add(window.Physics.behavior('edge', { graph: this }));
        var me = this;
        window.Physics.util.ticker.subscribe(function (time, dt) {
          try {
            me.world.step(time);
            me.render();
          } catch(exception) {
            debugger;
            window.Physics.util.ticker.stop();
          }
        });
        window.Physics.util.ticker.start();
      },
      render: function () {
        for(var id in this.nodes) {
          this.nodes[id].render();
        }
        for(var i = 0; i < this.edges.length; i++) {
          this.edges[i].render();
        }
      },
    	toSVGXY: function(pageX, pageY) {
    		var deltaX = pageX - this.drag.originalPageX;
    		var deltaY = pageY - this.drag.originalPageY;
    		deltaX = deltaX * this.width / this.drag.nodeWidth;
    		deltaY = deltaY * this.height / this.drag.nodeHeight;
    		return [this.drag.originalX + deltaX, this.drag.originalY + deltaY];
    	},
    	startDrag: function(node, evt) {
    		this.drag = {
    			node: node,
    			originalX: node.x,
    			originalY: node.y,
    			originalPageX: evt.pageX,
    			originalPageY: evt.pageY,
          moved: false,
    			nodeWidth: this.node.get('clientWidth'),
    			nodeHeight: this.node.get('clientHeight')
    		};
    	},
    	onClick: function(evt) {
    		if (evt.target.compareTo(this.background)) {
    			this.engine.sendChange(this.model.id, null);
    		}
    	},
    	// onMousedown part of Node
    	onMouseup: function(evt) {
    	  if (this.drag) {
	        this.drag.node.endDrag(this.drag.moved);
    			this.drag = null;
    		}
    	},
    	onMousemove: function(evt) {
    		if (this.drag) {
    		  var xy = this.toSVGXY(evt.pageX, evt.pageY);
    		  if (!this.drag.moved && (evt.pageX !== this.drag.originalPageX || evt.pageY !== this.drag.originalPageY)) {
    		    this.drag.moved = true;
		      }
		      this.drag.node.moveTo(xy[0], xy[1]);
    		}
    	}
    }
  });

}, '0.7.0', { requires: ['dd-drag', 'dd-constrain', 'instantlogic', 'html', 'instantlogic-fragments', 'dd'] });