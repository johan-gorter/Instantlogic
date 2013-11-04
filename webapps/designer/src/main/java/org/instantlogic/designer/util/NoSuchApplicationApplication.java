package org.instantlogic.designer.util;

import java.util.Iterator;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.text.TextTemplate;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.page.FragmentTemplate;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.FlowStack;
import org.instantlogic.interaction.util.SubmitContext;

public class NoSuchApplicationApplication extends Application {

	private final String applicationName;
	private final FragmentTemplate mainPageContent;

	public NoSuchApplicationApplication(String applicationName) {
		this.applicationName = applicationName;
		mainPageContent = new FragmentTemplate("page1", "Page")
			.addChild("mainContent",new FragmentTemplate("text1","Heading1").putText("text", new TextTemplate().getUntranslated().add("The application ["+applicationName+"] does not exist at this moment.").getTextTemplate()));
	}

	private FlowEvent startEvent = new FlowEvent() {
		
		@Override
		public String getName() {
			return "startEvent";
		}
		
		@Override
		public FlowEventOccurrence createOccurrence(SubmitContext context) {
			return new FlowEventOccurrence(startEvent);
		}
	};
	
	public static class CaseInstance extends Instance {

		@Override
		protected Entity<?> getInstanceEntity() {
			return caseEntity;
		}
	}
	
	private static final Entity caseEntity = new Entity<CaseInstance>() {

		@Override
		public Attribute<CaseInstance, ? extends Object, ? extends Object>[] getLocalAttributes() {
			return new Attribute[0];
		}

		@Override
		public Relation<CaseInstance, ? extends Object, ? extends Instance>[] getLocalRelations() {
			return new Relation[0];
		}

		@Override
		public Relation<? extends Instance, ? extends Object, CaseInstance>[] getLocalReverseRelations() {
			return new Relation[0];
		}

		@Override
		public CaseInstance createInstance() {
			return new CaseInstance();
		}

		@Override
		public Class<CaseInstance> getInstanceClass() {
			return CaseInstance.class;
		}

		@Override
		public String getName() {
			return "DummyCase";
		}
	};
	
	private PlaceTemplate mainPage = new PlaceTemplate() {
		
		@Override
		public String getName() {
			return "main";
		}
		
		@Override
		public FragmentTemplate getRootContainer() {
			return mainPageContent;
		}
		
		@Override
		public String getId() {
			return "main";
		}
	};

	private Flow mainFlow = new Flow() {

		private FlowStack createFixedFlowStack() {
			FlowStack result = new FlowStack(null, this);
			result.setCurrentNode(mainPage);
			return result;
		}
		
		@Override
		public PlaceTemplate getPage(String[] path, int pathIndex) {
			return mainPage;
		}

		@Override
		public FlowEvent findEvent(String eventName) {
			return startEvent;
		}

		@Override
		public FlowStack createFlowStack(FlowStack parentStack, Flow thisOrWrapper, String current, Iterator<String> moreCoordinates, Instance caseInstance) {
			return createFixedFlowStack();
		}

		@Override
		public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
			context.setFlowStack(createFixedFlowStack());
			return null;
		}

		@Override
		public FlowEventOccurrence step(FlowNodeBase currentNode, FlowEventOccurrence occurrence, FlowContext flowContext) {
			flowContext.setFlowStack(createFixedFlowStack());
			return null;
		}

		@Override
		public String getName() {
			return "mainFlow";
		}
	};
	
	@Override
	public Entity<? extends Instance> getCaseEntity() {
		return caseEntity;
	}

	@Override
	public String getName() {
		return applicationName;
	}
	
	@Override
	public FlowEvent getStartEvent() {
		return startEvent;
	}
	
	@Override
	public Flow getMainFlow() {
		return mainFlow;
	}
}
