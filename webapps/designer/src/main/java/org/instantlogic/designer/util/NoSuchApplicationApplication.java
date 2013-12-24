package org.instantlogic.designer.util;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.text.TextTemplate;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.page.FragmentTemplate;

public class NoSuchApplicationApplication extends Application {

	private final String applicationName;
	private final FragmentTemplate mainPageContent;

	public NoSuchApplicationApplication(String applicationName) {
		this.applicationName = applicationName;
		mainPageContent = new FragmentTemplate("page1", "Page")
			.addChild("mainContent",new FragmentTemplate("text1","Heading1").putText("text", new TextTemplate().getUntranslated().add("The application ["+applicationName+"] does not exist at this moment.").getTextTemplate()));
	}

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
	
	@Override
	public Entity<? extends Instance> getCaseEntity() {
		return caseEntity;
	}

	@Override
	public String getName() {
		return applicationName;
	}
	
	@Override
	public PlaceTemplate getStartPlace() {
		return mainPage;
	}
}
