/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.example.izzy;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.DataCategoryDesign;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.Design;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.EntityDesign.RelationType;
import org.instantlogic.designer.EventDesign;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.FragmentTypeDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.SelectionDesign;
import org.instantlogic.designer.SharedElementDefinitionDesign;
import org.instantlogic.designer.SharedElementDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.designer.TextTemplateDesign;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;
import org.instantlogic.engine.persistence.json.CasePersister;
import org.instantlogic.example.izzy.deduction.IssuePreviewDeduction;

public class IzzyGenerator extends Design {
	private static ApplicationDesign izzy;

	private static EntityDesign project;
	private static EntityDesign user;
	private static EntityDesign issue;
	private static EntityDesign comment;
	
	private static RelationDesign projectIssues;
	private static RelationDesign issueReporter;
	private static RelationDesign issueAssignee;
	
	private static AttributeDesign issueHeadline;
	private static AttributeDesign issueNumber;
	private static AttributeDesign userUsername;
	
	private static EventDesign createIssueEvent;
	private static EventDesign issueDetailsEvent;
	private static EventDesign dashboardEvent;
	private static EventDesign homeEvent;
	private static EventDesign notLoggedInEvent;
	
	private static PlaceTemplateDesign notLoggedInPlaceTemplate;
	private static PlaceTemplateDesign dashboardPlaceTemplate;
	private static PlaceTemplateDesign issueDetailsPlaceTemplate;

	private static FlowDesign mainFlow;
	private static FlowDesign issueFlow;
	private static FlowDesign createIssueFlow;
	private static FlowDesign dashboardFlow;
	private static FlowDesign selectDashboardFlow;
	private static AttributeDesign issueDescription;

	private static SharedElementDefinitionDesign issueRow;

	public static void main(String[] args) throws IOException {
		// Entities and attributes
		izzy = new ApplicationDesign();
		project = new EntityDesign("project").setApplication(izzy);
		project.addAttribute("last issue number", Integer.class).setDefault(new DeductionSchemeDesign().deduceConstant(Integer.class, 0).getScheme());
		user = new EntityDesign("user").setApplication(izzy);
		userUsername = user.addAttribute("username", DataCategoryDesign.text);
		DeductionSchemeDesign usernameTitle;
		user.setTitle(new TextTemplateDesign().addToUntranslated(new StringTemplateDesign().setDeduction(usernameTitle = new DeductionSchemeDesign())));
		usernameTitle.deduceAttribute(userUsername);
		issue = new EntityDesign("issue").setApplication(izzy);
		issueNumber = issue.addAttribute("number", Integer.class);
		issueHeadline = issue.addAttribute("headline", DataCategoryDesign.text);
		issueDescription = issue.addAttribute("description", DataCategoryDesign.text);
		issueDescription.getDataType().setMultiLine(true).setFormatted(true);
		comment = new EntityDesign("comment").setApplication(izzy);
		comment.addAttribute("text", DataCategoryDesign.text);
		comment.getDataType().setMultiLine(true).setFormatted(true);
		
		// Relations
		RelationDesign projectUsers = project.addRelation("users", RelationType.OneToManyAggregation, user).setReverseName("project");
		projectIssues = project.addRelation("issues", RelationType.OneToManyAggregation, issue).setReverseName("project");
		issueReporter = issue.addRelation("reporter", RelationType.ManyToZeroOrOne, user).setReverseName("reported issues");
		issueAssignee = issue.addRelation("assignee", RelationType.ManyToZeroOrOne, user).setReverseName("assigned issues");
		issue.addRelation("comments", RelationType.OneToManyAggregation, comment).setReverseName("issue");
		comment.addRelation("by", RelationType.OneToZeroOrOne, user).setReverseName("comments");
		issueReporter.newOptions().deduceRelation(projectUsers);
		issueAssignee.newOptions().deduceRelation(projectUsers);
		
		// Validations
    	issue.newValidation("HeadlineRequired","Enter a value", issueHeadline).deduceAttributeHasValue(issueHeadline);
    	issue.newValidation("DescriptionRequired", "Enter a value", issueDescription).deduceAttributeHasValue(issueDescription);

		izzy.setCaseEntity(project);
		izzy.setName("izzy");
		izzy.setRootPackageName("org.instantlogic.example.izzy");
		izzy.getCaseEntity().registerApplication(izzy);
		izzy.addToThemeNames("margin").addToThemeNames("izzy");
		
		homeEvent = new EventDesign("home").setApplication(izzy);
		createIssueEvent = new EventDesign("create issue").setApplication(izzy);
		issueDetailsEvent = new EventDesign("issue details").setApplication(izzy).addToParameters(issue);
		dashboardEvent = new EventDesign("dashboard").setApplication(izzy).addToParameters(user);
		notLoggedInEvent = new EventDesign("not logged in").setApplication(izzy);
		
		mainFlow = new FlowDesign("main").setApplication(izzy);
		issueFlow = new FlowDesign("issue").setApplication(izzy).addToParameters(issue);
		createIssueFlow = new FlowDesign("create issue").setApplication(izzy);
		createIssueFlow.setIsCustomized(true);
		dashboardFlow = new FlowDesign("dashboard").setApplication(izzy).addToParameters(user);
		selectDashboardFlow = new FlowDesign("select dashboard").setApplication(izzy);
		selectDashboardFlow.setIsCustomized(true);

		createFragmentTypes();
		
		createIssueRowSharedElement();
		
		createNotLoggedInPlaceTemplate();
		createDashboardPlaceTemplate();
		createIssueDetailsPlaceTemplate();
		
		initMainFlow();
		initIssueFlow();
		initDashboardFlow();

		notLoggedInPlaceTemplate.lookUpTypes();
		dashboardPlaceTemplate.lookUpTypes();
		issueDetailsPlaceTemplate.lookUpTypes();
		
		// Application
		izzy.setSourcePath("target/generated-sources/instantlogic-app");
		izzy.setMainFlow(mainFlow);
		izzy.setStartEvent(homeEvent);

		// Finished with the design, what to do next
		
		// Generate java code
		GeneratedClassModels classModelUpdates = izzy.getApplicationGenerator().getClassModelUpdates();
		ApplicationJavacodeGenerator.generate(classModelUpdates, new File(izzy.getSourcePath()));
		
		// Display the design in json format
		OutputStreamWriter writer = new OutputStreamWriter(System.out);
		new CasePersister().save(izzy, writer);
		writer.flush();
	}
	
	// Flows

	private static void createIssueRowSharedElement() {
		FragmentTemplateDesign detailsLink;
		DeductionSchemeDesign number;
		DeductionSchemeDesign headline;
		DeductionSchemeDesign preview;
		issueRow = new SharedElementDefinitionDesign()
			.setApplication(izzy)
			.setFragment(new FragmentTemplateDesign("Row")
				.setChildren("cells",
					detailsLink = new FragmentTemplateDesign("Link")
						.setChildren("content", 
							new FragmentTemplateDesign("Cell")
								.setText("text", new TextTemplateDesign().addToUntranslated(
									new StringTemplateDesign().setDeduction(number = new DeductionSchemeDesign()))),
							new FragmentTemplateDesign("Cell")
								.setText("text", new TextTemplateDesign().addToUntranslated(
									new StringTemplateDesign().setDeduction(headline = new DeductionSchemeDesign()))),
							new FragmentTemplateDesign("Cell")
								.setText("text", new TextTemplateDesign().addToUntranslated(
									new StringTemplateDesign().setDeduction(preview = new DeductionSchemeDesign()))),
							new FragmentTemplateDesign("Cell")
								.setChildren("content", 
									new FragmentTemplateDesign("PresenceIndicator")
							)
						)
					)
				);
		issueRow.setName("IssueRow");
		number.deduceAttribute(issueNumber);
		headline.deduceAttribute(issueHeadline);
		preview.deduceCustom(IssuePreviewDeduction.class, String.class);
		detailsLink.setEvent(issueDetailsEvent);
	}

	private static void createFragmentTypes() {
		izzy.addToFragmentTypes((FragmentTypeDesign) new FragmentTypeDesign().setName("Page"));
		izzy.addToFragmentTypes((FragmentTypeDesign) new FragmentTypeDesign().setName("Paragraph"));
		izzy.addToFragmentTypes((FragmentTypeDesign) new FragmentTypeDesign().setName("Heading1"));
		izzy.addToFragmentTypes((FragmentTypeDesign) new FragmentTypeDesign().setName("Heading2"));
		izzy.addToFragmentTypes((FragmentTypeDesign) new FragmentTypeDesign().setName("Heading3"));
		izzy.addToFragmentTypes((FragmentTypeDesign) new FragmentTypeDesign().setName("Heading4"));
		izzy.addToFragmentTypes((FragmentTypeDesign) new FragmentTypeDesign().setName("Icon"));
		izzy.addToFragmentTypes((FragmentTypeDesign) new FragmentTypeDesign().setHasAttribute(true).setName("Input"));
		izzy.addToFragmentTypes((FragmentTypeDesign) new FragmentTypeDesign().setName("Table"));
		izzy.addToFragmentTypes((FragmentTypeDesign) new FragmentTypeDesign().setName("Row"));
		izzy.addToFragmentTypes((FragmentTypeDesign) new FragmentTypeDesign().setName("Column"));
		izzy.addToFragmentTypes((FragmentTypeDesign) new FragmentTypeDesign().setName("Cell"));
		izzy.addToFragmentTypes((FragmentTypeDesign) new FragmentTypeDesign().setHasEvent(true).setName("Link"));
		izzy.addToFragmentTypes((FragmentTypeDesign) new FragmentTypeDesign().setHasEvent(true).setName("Button"));
	}

	private static void initIssueFlow() {
		issueFlow.newEdge().setEvent(issueDetailsEvent).setEndNode(issueDetailsPlaceTemplate);
	}

	private static void initDashboardFlow() {
		dashboardFlow.newEdge().setEvent(dashboardEvent).setEndNode(dashboardPlaceTemplate);
	}
	
	private static void initMainFlow() {
		SubFlowDesign mainFlowIssueSubFlow = mainFlow.addSubFlow(issueFlow);
		SubFlowDesign mainFlowCreateIssueSubFlow = mainFlow.addSubFlow(createIssueFlow);
		SubFlowDesign selectDashboard = mainFlow.addSubFlow(selectDashboardFlow);
		SubFlowDesign dashboard = mainFlow.addSubFlow(dashboardFlow);
		
		mainFlow.newEdge().setEvent(issueDetailsEvent).setEndNode(mainFlowIssueSubFlow);
		mainFlow.newEdge().setEvent(createIssueEvent).setEndNode(mainFlowCreateIssueSubFlow);
		
		mainFlow.newEdge().setEvent(homeEvent).setEndNode(selectDashboard);
		mainFlow.newEdge().setEvent(dashboardEvent).setEndNode(dashboard);
		
		mainFlow.newEdge().setEvent(notLoggedInEvent).setEndNode(notLoggedInPlaceTemplate);
	}
	
	// Place templates
	private static void createNotLoggedInPlaceTemplate() {
		notLoggedInPlaceTemplate = new PlaceTemplateDesign("not logged in")
			.setOwner(mainFlow)
			.setContent(
				new FragmentTemplateDesign("Page")
					.setChildren("mainContent",
						new FragmentTemplateDesign("Paragraph")
							.setText("text", new TextTemplateDesign().addToUntranslated(new StringTemplateDesign().setConstantText("Please log in.")))
					)
			);
	}

	private static void createIssueDetailsPlaceTemplate() {
		DeductionSchemeDesign number, headline;
		FragmentTemplateDesign headlineInput, descriptionInput, homeLink, reporterInput, assigneeInput;
		issueDetailsPlaceTemplate = new PlaceTemplateDesign("issueDetails")
			.setOwner(issueFlow)
			.setContent(new FragmentTemplateDesign("Page")
				.setChildren("mainContent", 
					homeLink = new FragmentTemplateDesign("Button").addToStyleNames("btn-link")
						.setChildren("content", new FragmentTemplateDesign("Icon").addToStyleNames("icon-home"))
						.setText("text", new TextTemplateDesign().addToUntranslated(new StringTemplateDesign().setConstantText("Home"))),
					new FragmentTemplateDesign("Heading2")
						.setText("text", new TextTemplateDesign()
							.addToUntranslated(new StringTemplateDesign().setConstantText("Issue "))
							.addToUntranslated(new StringTemplateDesign().setDeduction(number = new DeductionSchemeDesign()))
							.addToUntranslated(new StringTemplateDesign().setConstantText(": "))
							.addToUntranslated(new StringTemplateDesign().setDeduction(headline = new DeductionSchemeDesign()))
						),
					headlineInput = new FragmentTemplateDesign("Input").addToStyleNames("answer-span8"),
					reporterInput = new FragmentTemplateDesign("Input").addToStyleNames("answer-span4"),
					assigneeInput = new FragmentTemplateDesign("Input").addToStyleNames("answer-span4"),
					descriptionInput = new FragmentTemplateDesign("Input").addToStyleNames("answer-span8").addToStyleNames("answer-height300")
				)
			);
		issueDetailsPlaceTemplate.getMetadata().initUniqueId("issueDetails");// Keep this one fixed
		homeLink.setEvent(homeEvent);
		number.deduceAttribute(issueNumber);
		headline.deduceAttribute(issueHeadline);
		headlineInput.setEntity(issue).setAttribute(issueHeadline);
		reporterInput.setEntity(issue).setAttribute(issueReporter);
		assigneeInput.setEntity(issue).setAttribute(issueAssignee);
		descriptionInput.setEntity(issue).setAttribute(issueDescription);
		// Title
		issueDetailsPlaceTemplate.newTitle()
			.addToUntranslated(new StringTemplateDesign().setConstantText("Issue "))
			.addToUntranslated(new StringTemplateDesign().setDeduction(number = new DeductionSchemeDesign()))
			.addToUntranslated(new StringTemplateDesign().setConstantText(": "))
			.addToUntranslated(new StringTemplateDesign().setDeduction(headline = new DeductionSchemeDesign()));
		number.deduceAttribute(issueNumber);
		headline.deduceAttribute(issueHeadline);
	}

	private static void createDashboardPlaceTemplate() {
		DeductionSchemeDesign issues, assignedToMe, username;
		FragmentTemplateDesign createButton;
		SharedElementDesign issueRow1, issueRow2;
		dashboardPlaceTemplate = new PlaceTemplateDesign("dashboard")
			.setOwner(dashboardFlow)
			.setContent(
				new FragmentTemplateDesign("Page")
					.setChildren("mainContent",
						new FragmentTemplateDesign("Heading2")
							.setText("text", new TextTemplateDesign()
								.addToUntranslated(new StringTemplateDesign().setDeduction(username = new DeductionSchemeDesign()))
								.addToUntranslated(new StringTemplateDesign().setConstantText("'s dashboard"))
							),
						new FragmentTemplateDesign("Heading4").setText("text", createConstantText("Assigned to me")),
						new FragmentTemplateDesign("Table")
							.setChildren("columns", 
								new FragmentTemplateDesign("Column").addToStyleNames("issueNr")
									.setText("header", createConstantText("#")),
								new FragmentTemplateDesign("Column").addToStyleNames("issueHeadline")
									.setText("header", createConstantText("Issue")),
								new FragmentTemplateDesign("Column").addToStyleNames("issuePreview"),
								new FragmentTemplateDesign("Column").addToStyleNames("presence-indicator")
							)
							.setChildren("rows",
								new SelectionDesign()
									.setSelection(assignedToMe = new DeductionSchemeDesign())
									.addToChildren(
										issueRow1 = new SharedElementDesign()
									)
							),
						new FragmentTemplateDesign("Heading4").setText("text", createConstantText("All issues")),
						new FragmentTemplateDesign("Table")
							.setChildren("columns", 
								new FragmentTemplateDesign("Column").addToStyleNames("issueNr")
									.setText("header", createConstantText("#")),
								new FragmentTemplateDesign("Column").addToStyleNames("issueHeadline")
									.setText("header", createConstantText("Issue")),
								new FragmentTemplateDesign("Column").addToStyleNames("issuePreview"),
								new FragmentTemplateDesign("Column").addToStyleNames("presence-indicator")
							)
							.setChildren("rows",
								new SelectionDesign()
									.setSelection(issues = new DeductionSchemeDesign())
									.addToChildren(
										issueRow2 = new SharedElementDesign()
									)
							),
						createButton = new FragmentTemplateDesign("Button")
							.setText("text", new TextTemplateDesign().addToUntranslated(new StringTemplateDesign().setConstantText("Create issue")))
					)
			);
		username.deduceAttribute(userUsername);
		issues.deduceAttribute(projectIssues);
		assignedToMe.deduceReverseRelation(issueAssignee, assignedToMe.deduceSelectedInstance(user));
		issueRow1.setDefinition(issueRow);
		issueRow2.setDefinition(issueRow);
		createButton.setEvent(createIssueEvent);
		//Title
		dashboardPlaceTemplate.newTitle()
			.addToUntranslated(new StringTemplateDesign().setDeduction(username = new DeductionSchemeDesign()))
			.addToUntranslated(new StringTemplateDesign().setConstantText("'s dashboard"));
		username.deduceAttribute(userUsername);	
	}
}
