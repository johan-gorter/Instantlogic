package org.instantlogic.example.izzy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.DataCategoryDesign;
import org.instantlogic.designer.DeductionOperationDesign;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.Design;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.EntityDesign.RelationType;
import org.instantlogic.designer.EventDesign;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.FragmentTypeDesign;
import org.instantlogic.designer.IfElseDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.SelectionDesign;
import org.instantlogic.designer.SharedElementDefinitionDesign;
import org.instantlogic.designer.SharedElementDesign;
import org.instantlogic.designer.StaticInstanceDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.designer.TextTemplateDesign;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;
import org.instantlogic.designer.tools.Generator;
import org.instantlogic.fabric.util.id.SequencePerLabelIdGenerator;
import org.instantlogic.tools.persistence.json.CasePersister;

public class IzzyGenerator extends Design {
	private static ApplicationDesign izzy;

	private static DeductionOperationDesign issuePreviewDeduction;
	
	private static EntityDesign project;
	private static EntityDesign user;
	private static EntityDesign issue;
	private static EntityDesign comment;
	private static EntityDesign issueStatus;
	
	private static RelationDesign projectIssues;
	private static RelationDesign issueReporter;
	private static RelationDesign issueAssignee;
	private static RelationDesign issueIssueStatus;
	
	private static AttributeDesign issueHeadline;
	private static AttributeDesign issueNumber;
	private static AttributeDesign userUsername;
	private static AttributeDesign userName;
	
	private static EventDesign createIssueEvent;
	private static EventDesign issueDetailsEvent;
	private static EventDesign dashboardEvent;
	private static EventDesign homeEvent;
	private static EventDesign deleteIssueEvent;
	private static EventDesign notLoggedInEvent;
	private static EventDesign openIssueEvent;
	private static EventDesign resolveIssueEvent;
	private static EventDesign closeIssueEvent;
	
	private static PlaceTemplateDesign notLoggedInPlaceTemplate;
	private static PlaceTemplateDesign dashboardPlaceTemplate;
	private static PlaceTemplateDesign issueDetailsPlaceTemplate;

	private static FlowDesign mainFlow;
	private static FlowDesign issueFlow;
	private static FlowDesign createIssueFlow;
	private static FlowDesign deleteIssueFlow;
	private static FlowDesign dashboardFlow;
	private static FlowDesign selectDashboardFlow;
	private static FlowDesign openIssueFlow;
	private static FlowDesign resolveIssueFlow;
	private static FlowDesign closeIssueFlow;
	private static AttributeDesign issueDescription;
	
	private static StaticInstanceDesign draft;
	private static StaticInstanceDesign open;
	private static StaticInstanceDesign resolved;
	private static StaticInstanceDesign closed;

	private static SharedElementDefinitionDesign issueRow;

	public static void main(String[] args) throws IOException {
		// Entities and attributes
		izzy = new ApplicationDesign();
		izzy.getMetadata().getCaseAdministration().setIdGenerator(new SequencePerLabelIdGenerator()); // predictable Id's for better source control
		issuePreviewDeduction = new DeductionOperationDesign();
		izzy.addToCustomDeductionOperations(issuePreviewDeduction);
		issuePreviewDeduction.setName("issue preview");
		issuePreviewDeduction.setJavaClassName("org.instantlogic.example.izzy.deduction.IssuePreviewDeduction");
		project = new EntityDesign("project").setApplication(izzy);
		project.addAttribute("last issue number", Integer.class).setDefault(new DeductionSchemeDesign().deduceConstant(Integer.class, 0).getScheme());
		user = new EntityDesign("user").setApplication(izzy);
		userUsername = user.addAttribute("username", DataCategoryDesign.text);
		userName = user.addAttribute("name", DataCategoryDesign.text);
		DeductionSchemeDesign usernameTitle;
		user.setTitle(new TextTemplateDesign().addToUntranslated(new StringTemplateDesign().setDeduction(usernameTitle = new DeductionSchemeDesign())));
		usernameTitle.deduceAttribute(userName);
		issueStatus = new EntityDesign("issueStatus").setApplication(izzy);
		issueStatus.addToStaticInstances(draft = (StaticInstanceDesign)new StaticInstanceDesign().setDescription(createConstantText("Draft")).setName("draft"));
		issueStatus.addToStaticInstances(open = (StaticInstanceDesign)new StaticInstanceDesign().setDescription(createConstantText("Open")).setName("open"));
		issueStatus.addToStaticInstances(resolved = (StaticInstanceDesign)new StaticInstanceDesign().setDescription(createConstantText("Resolved")).setName("resolved"));
		issueStatus.addToStaticInstances(closed = (StaticInstanceDesign)new StaticInstanceDesign().setDescription(createConstantText("Closed")).setName("closed"));
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
		issueIssueStatus = issue.addRelation("status", RelationType.ManyToZeroOrOne, issueStatus);
		
		// Validations
    	issue.newValidation("HeadlineRequired","Enter a value", issueHeadline).deduceAttributeHasValue(issueHeadline);
    	issue.newValidation("DescriptionRequired", "Enter a value", issueDescription).deduceAttributeHasValue(issueDescription);

		izzy.setCaseEntity(project);
		izzy.setName("izzy");
		izzy.setRootPackageName("org.instantlogic.example.izzy");
		izzy.getCaseEntity().registerApplication(izzy);
		izzy.addToThemeNames("margin").addToThemeNames("izzy");
		
		homeEvent = new EventDesign("home").setApplication(izzy);
		deleteIssueEvent = new EventDesign("delete issue").setApplication(izzy).addToParameters(issue);
		createIssueEvent = new EventDesign("create issue").setApplication(izzy);
		issueDetailsEvent = new EventDesign("issue details").setApplication(izzy).addToParameters(issue);
		dashboardEvent = new EventDesign("dashboard").setApplication(izzy).addToParameters(user);
		notLoggedInEvent = new EventDesign("not logged in").setApplication(izzy);
		openIssueEvent = new EventDesign("open issue").setApplication(izzy).addToParameters(issue);
		resolveIssueEvent = new EventDesign("resolve issue").setApplication(izzy).addToParameters(issue);
		closeIssueEvent = new EventDesign("close issue").setApplication(izzy).addToParameters(issue);
		
		mainFlow = new FlowDesign("main").setApplication(izzy);
		issueFlow = new FlowDesign("issue").setApplication(izzy).addToParameters(issue);
		createIssueFlow = new FlowDesign("create issue").setApplication(izzy);
		createIssueFlow.setIsCustomized(true);
		deleteIssueFlow = new FlowDesign("delete issue").setApplication(izzy);
		deleteIssueFlow.addToParameters(issue);
		deleteIssueFlow.setIsCustomized(true);
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
		izzy.setSourcePath("../izzy/target/generated-sources/instantlogic-app");
		izzy.setMainFlow(mainFlow);
		izzy.setStartEvent(homeEvent);

		// Finished with the design, what to do next
		
		// Generate java code
		GeneratedClassModels classModelUpdates = izzy.getApplicationGenerator().getClassModelUpdates();
		ApplicationJavacodeGenerator.generate(classModelUpdates, new File(izzy.getSourcePath()));
		
		// Display the design in json format
		try (FileWriter fileWriter = new FileWriter(new File("../../webapps/izzy/src/main/instantlogic-designs/izzy.json"))) {
			new CasePersister().save(izzy, fileWriter);
		}
		System.out.println("izzy.json written");
		Generator.scanForInstantlogicDesigns(new File("../../webapps/izzy"));
	}
	
	// Flows

	private static void createFragmentTypes() {
		izzy.addToFragmentTypes((FragmentTypeDesign) new FragmentTypeDesign().setName("Page"));
		izzy.addToFragmentTypes((FragmentTypeDesign) new FragmentTypeDesign().setName("Block"));
		izzy.addToFragmentTypes((FragmentTypeDesign) new FragmentTypeDesign().setName("Group"));
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
		openIssueFlow = new FlowDesign("open issue").setApplication(izzy);
		openIssueFlow.setIsCustomized(true);
		resolveIssueFlow = new FlowDesign("resolve issue").setApplication(izzy);
		resolveIssueFlow.setIsCustomized(true);
		closeIssueFlow = new FlowDesign("close issue").setApplication(izzy);
		closeIssueFlow.setIsCustomized(true);
		SubFlowDesign openIssueSubFlow = issueFlow.addSubFlow(openIssueFlow);
		SubFlowDesign resolveIssueSubFlow = issueFlow.addSubFlow(resolveIssueFlow);
		SubFlowDesign closeIssueSubFlow = issueFlow.addSubFlow(closeIssueFlow);
		issueFlow.newEdge().setEvent(issueDetailsEvent).setEndNode(issueDetailsPlaceTemplate);
		issueFlow.newEdge().setEvent(openIssueEvent).setEndNode(openIssueSubFlow);
		issueFlow.newEdge().setEvent(resolveIssueEvent).setEndNode(resolveIssueSubFlow);
		issueFlow.newEdge().setEvent(closeIssueEvent).setEndNode(closeIssueSubFlow);
	}

	private static void initDashboardFlow() {
		dashboardFlow.newEdge().setEvent(dashboardEvent).setEndNode(dashboardPlaceTemplate);
	}
	
	private static void initMainFlow() {
		SubFlowDesign mainFlowIssueSubFlow = mainFlow.addSubFlow(issueFlow);
		SubFlowDesign mainFlowCreateIssueSubFlow = mainFlow.addSubFlow(createIssueFlow);
		SubFlowDesign mainFlowDeleteIssueSubFlow = mainFlow.addSubFlow(deleteIssueFlow);
		SubFlowDesign selectDashboard = mainFlow.addSubFlow(selectDashboardFlow);
		SubFlowDesign dashboard = mainFlow.addSubFlow(dashboardFlow);
		
		mainFlow.newEdge().setEvent(issueDetailsEvent).setEndNode(mainFlowIssueSubFlow);
		mainFlow.newEdge().setEvent(createIssueEvent).setEndNode(mainFlowCreateIssueSubFlow);
		mainFlow.newEdge().setEvent(deleteIssueEvent).setEndNode(mainFlowDeleteIssueSubFlow);
		
		mainFlow.newEdge().setEvent(homeEvent).setEndNode(selectDashboard);
		mainFlow.newEdge().setEvent(dashboardEvent).setEndNode(dashboard);
		
		mainFlow.newEdge().setEvent(notLoggedInEvent).setEndNode(notLoggedInPlaceTemplate);
	}

	// Shared elements
	private static void createIssueRowSharedElement() {
		FragmentTemplateDesign detailsLink;
		DeductionSchemeDesign number;
		DeductionSchemeDesign headline;
		DeductionSchemeDesign preview;
		DeductionSchemeDesign assignee;
		DeductionSchemeDesign isDraft;
		issueRow = new SharedElementDefinitionDesign()
			.setApplication(izzy)
			.setFragment(new FragmentTemplateDesign("Row")
				.setChildren("cells",
					detailsLink = new FragmentTemplateDesign("Link")
						.setChildren("content", 
							new FragmentTemplateDesign("Cell").addToStyleNames("issueNr")
								.setText("text", new TextTemplateDesign().addToUntranslated(
									new StringTemplateDesign().setDeduction(number = new DeductionSchemeDesign()))),
							new FragmentTemplateDesign("Cell").addToStyleNames("issueDetails")
								.setChildren("content",
									new IfElseDesign()
										.setCondition(isDraft = new DeductionSchemeDesign())
										.setIfChild(new FragmentTemplateDesign("Text")
											.setText("text", createConstantText("[Draft] "))
											.addToStyleNames("draft-label")),
									new FragmentTemplateDesign("Text").addToStyleNames("headline")
										.setText("text", new TextTemplateDesign().addToUntranslated(
											new StringTemplateDesign().setDeduction(headline = new DeductionSchemeDesign()))),									
									new FragmentTemplateDesign("Text").addToStyleNames("preview")
										.setText("text", new TextTemplateDesign().addToUntranslated(
											new StringTemplateDesign().setDeduction(preview = new DeductionSchemeDesign()))),
									new FragmentTemplateDesign("Text").addToStyleNames("assignee")
										.setText("text", new TextTemplateDesign().addToUntranslated(
											new StringTemplateDesign().setDeduction(assignee = new DeductionSchemeDesign())))
								),
							new FragmentTemplateDesign("Cell").addToStyleNames("presence-indicator")
								.setChildren("content", 
									new FragmentTemplateDesign("PresenceIndicator")
							)
						)
					)
				);
		isDraft.deduceEquals(isDraft.deduceAttribute(issueIssueStatus), isDraft.deduceStaticInstance(draft));
		issueRow.setName("IssueRow");
		number.deduceAttribute(issueNumber);
		headline.deduceAttribute(issueHeadline);
		preview.deduceCustom(issuePreviewDeduction);
		assignee.deduceAttribute(userName, assignee.deduceRelation(issueAssignee));
		detailsLink.setEvent(issueDetailsEvent);
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

	private static void createDashboardPlaceTemplate() {
		DeductionSchemeDesign issues, assignedToMe, username;
		FragmentTemplateDesign createButton;
		SharedElementDesign issueRow1, issueRow2;
		dashboardPlaceTemplate = new PlaceTemplateDesign("dashboard")
			.setOwner(dashboardFlow)
			.setContent(
				new FragmentTemplateDesign("Page")
					.setChildren("mainContent",
						new FragmentTemplateDesign("Block").addToStyleNames("no-margin")
							.setChildren("content", 
								createButton = new FragmentTemplateDesign("Button")
									.setChildren("content", new FragmentTemplateDesign("Icon").addToStyleNames("icon-plus"))
									.setText("text", createConstantText("Create issue")),
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
										new FragmentTemplateDesign("Column").addToStyleNames("issue")
											.setText("header", createConstantText("Issue")),
										new FragmentTemplateDesign("Column").addToStyleNames("assignee")
											.setText("header", createConstantText("Assignee"))
									)
									.setChildren("rows",
										new SelectionDesign()
											.setSelection(assignedToMe = new DeductionSchemeDesign())
											.setChild(
												issueRow1 = new SharedElementDesign()
											)
									),
								new FragmentTemplateDesign("Heading4").setText("text", createConstantText("All issues")),
								new FragmentTemplateDesign("Table")
									.setChildren("columns", 
										new FragmentTemplateDesign("Column").addToStyleNames("issueNr")
											.setText("header", createConstantText("#")),
										new FragmentTemplateDesign("Column").addToStyleNames("issue")
											.setText("header", createConstantText("Issue")),
										new FragmentTemplateDesign("Column").addToStyleNames("assignee")
											.setText("header", createConstantText("Assignee"))
									)
									.setChildren("rows",
										new SelectionDesign()
											.setSelection(issues = new DeductionSchemeDesign())
											.setChild(
												issueRow2 = new SharedElementDesign()
											)
									)
							)
					)
			);
		username.deduceAttribute(userName);
		issues.deduceAttribute(projectIssues);
		assignedToMe.deduceReverseRelation(issueAssignee, assignedToMe.deduceSelectedInstance(user));
		issueRow1.setDefinition(issueRow);
		issueRow2.setDefinition(issueRow);
		createButton.setEvent(createIssueEvent);
		
		//Title
		dashboardPlaceTemplate.newTitle()
			.addToUntranslated(new StringTemplateDesign().setDeduction(username = new DeductionSchemeDesign()))
			.addToUntranslated(new StringTemplateDesign().setConstantText("'s dashboard"));
		username.deduceAttribute(userName);	
	}
	
	private static void createIssueDetailsPlaceTemplate() {
		DeductionSchemeDesign number, headline, issueStatusDeduction;
		FragmentTemplateDesign headlineInput, descriptionInput, homeLink, deleteButton, reporterInput, assigneeInput,
			submitButton, resolveButton, reopenButton, closeButton, reopenClosedButton;
		DeductionSchemeDesign statusDraft, statusOpen, statusResolved, statusClosed;
		
		issueDetailsPlaceTemplate = new PlaceTemplateDesign("issueDetails")
			.setOwner(issueFlow)
			.setContent(new FragmentTemplateDesign("Page")
				.setChildren("mainContent", 
					homeLink = new FragmentTemplateDesign("Button").addToStyleNames("btn-link")
						.setChildren("content", new FragmentTemplateDesign("Icon").addToStyleNames("icon-home"))
						.setText("text", createConstantText("Home")),
					deleteButton = new FragmentTemplateDesign("Button").addToStyleNames("btn")
						.setChildren("content", new FragmentTemplateDesign("Icon").addToStyleNames("icon-remove"))
						.setText("text", createConstantText("Delete")),
					new IfElseDesign().setCondition(statusOpen = new DeductionSchemeDesign())
						.setIfChild(resolveButton = new FragmentTemplateDesign("Button").setText("text", createConstantText("Resolve")).addToStyleNames("btn-primary")
						),
					new IfElseDesign().setCondition(statusResolved = new DeductionSchemeDesign())
						.setIfChild(new FragmentTemplateDesign("Group")
							.setChildren("content", 
								reopenButton = new FragmentTemplateDesign("Button").setText("text", createConstantText("Re-open")),
								closeButton = new FragmentTemplateDesign("Button").setText("text", createConstantText("Close")).addToStyleNames("btn-primary")
							)
						),
					new IfElseDesign().setCondition(statusClosed = new DeductionSchemeDesign())
						.setIfChild(reopenClosedButton = new FragmentTemplateDesign("Button").setText("text", createConstantText("Re-open"))),
					new IfElseDesign().setCondition(statusDraft = new DeductionSchemeDesign())
					.setIfChild(
							submitButton = new FragmentTemplateDesign("Button").setText("text", createConstantText("Ready")).addToStyleNames("btn-primary")
					),
					new FragmentTemplateDesign("Heading2")
						.setText("text", new TextTemplateDesign()
							.addToUntranslated(new StringTemplateDesign().setConstantText("Issue "))
							.addToUntranslated(new StringTemplateDesign().setDeduction(number = new DeductionSchemeDesign()))
							.addToUntranslated(new StringTemplateDesign().setConstantText(": "))
							.addToUntranslated(new StringTemplateDesign().setDeduction(headline = new DeductionSchemeDesign()))
							.addToUntranslated(new StringTemplateDesign().setConstantText(" ("))
							.addToUntranslated(new StringTemplateDesign().setDeduction(issueStatusDeduction = new DeductionSchemeDesign()))
							.addToUntranslated(new StringTemplateDesign().setConstantText(")"))
						),
					headlineInput = new FragmentTemplateDesign("Input").addToStyleNames("answer-span8"),
					reporterInput = new FragmentTemplateDesign("Input").addToStyleNames("answer-span4"),
					assigneeInput = new FragmentTemplateDesign("Input").addToStyleNames("answer-span4"),
					descriptionInput = new FragmentTemplateDesign("Input").addToStyleNames("answer-span8").addToStyleNames("answer-height300")
				)
			);
		
		issueDetailsPlaceTemplate.getMetadata().initUniqueId("issueDetails");// Keep this one fixed
		homeLink.setEvent(homeEvent);
		deleteButton.setEvent(deleteIssueEvent);
		number.deduceAttribute(issueNumber);
		headline.deduceAttribute(issueHeadline);
		headlineInput.setEntity(issue).setAttribute(issueHeadline);
		reporterInput.setEntity(issue).setAttribute(issueReporter);
		assigneeInput.setEntity(issue).setAttribute(issueAssignee);
		descriptionInput.setEntity(issue).setAttribute(issueDescription);
		submitButton.setEvent(openIssueEvent);
		reopenButton.setEvent(openIssueEvent);
		reopenClosedButton.setEvent(openIssueEvent);
		resolveButton.setEvent(resolveIssueEvent);
		closeButton.setEvent(closeIssueEvent);
		
		issueStatusDeduction.deduceAttribute(issueIssueStatus);
		statusDraft.deduceEquals(statusDraft.deduceAttribute(issueIssueStatus), statusDraft.deduceStaticInstance(draft));
		statusOpen.deduceEquals(statusOpen.deduceAttribute(issueIssueStatus), statusOpen.deduceStaticInstance(open));
		statusResolved.deduceEquals(statusResolved.deduceAttribute(issueIssueStatus), statusResolved.deduceStaticInstance(resolved));
		statusClosed.deduceEquals(statusClosed.deduceAttribute(issueIssueStatus), statusClosed.deduceStaticInstance(closed));
		
		// Title
		issueDetailsPlaceTemplate.newTitle()
			.addToUntranslated(new StringTemplateDesign().setConstantText("Issue "))
			.addToUntranslated(new StringTemplateDesign().setDeduction(number = new DeductionSchemeDesign()))
			.addToUntranslated(new StringTemplateDesign().setConstantText(": "))
			.addToUntranslated(new StringTemplateDesign().setDeduction(headline = new DeductionSchemeDesign()));
		number.deduceAttribute(issueNumber);
		headline.deduceAttribute(issueHeadline);
	}
}
