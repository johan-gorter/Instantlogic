package org.instantlogic.designer.codegenerator.jvmbytecode;

import java.net.URL;

import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel;
import org.instantlogic.designer.codegenerator.classmodel.EventClassModel;
import org.instantlogic.designer.codegenerator.classmodel.FlowClassModel;
import org.instantlogic.designer.codegenerator.classmodel.PlaceClassModel;
import org.instantlogic.designer.codegenerator.classmodel.SharedPageFragmentClassModel;
import org.instantlogic.designer.codegenerator.classmodel.SubFlowClassModel;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModelsProcessor;
import org.instantlogic.designer.codegenerator.jvmbytecode.template.ApplicationBytecodeTemplate;
import org.instantlogic.designer.codegenerator.jvmbytecode.template.EntityBytecodeTemplate;
import org.instantlogic.designer.codegenerator.jvmbytecode.template.EventBytecodeTemplate;
import org.instantlogic.designer.codegenerator.jvmbytecode.template.FlowBytecodeTemplate;
import org.instantlogic.designer.codegenerator.jvmbytecode.template.InstanceBytecodeTemplate;
import org.instantlogic.designer.codegenerator.jvmbytecode.template.PlaceTemplateBytecodeTemplate;
import org.instantlogic.designer.codegenerator.jvmbytecode.template.SharedPageFragmentBytecodeTemplate;
import org.instantlogic.designer.codegenerator.jvmbytecode.template.SubFlowBytecodeTemplate;
import org.instantlogic.designer.dataexplorer.ApplicationWithDataExplorer;
import org.instantlogic.designer.util.DesignerPersistenceStrategy;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.ApplicationEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationBytecodeGenerator implements GeneratedClassModelsProcessor {

	private static final Logger logger = LoggerFactory.getLogger(DesignerPersistenceStrategy.class);

	public static void update(GeneratedClassModels classModels, JvmBytecodeApplication updateableApplication) {
		if (classModels.updatedApplication!=null) {
			String fullApplicationClassName = classModels.rootPackageName+"." + classModels.updatedApplication.name+"Application";
			updateableApplication.setClassBytes(fullApplicationClassName,
				ApplicationBytecodeTemplate.generate(classModels.updatedApplication, fullApplicationClassName));
		}
		for (EntityClassModel entity: classModels.deletedEntities) {
			//Instance
			String fullInstanceClassName = classModels.rootPackageName+"." + (entity.isCustomized?"Abstract":"") + entity.technicalNameCapitalized;
			updateableApplication.removeClassBytes(fullInstanceClassName);
			//Entity
			String fullEntityClassName = classModels.rootPackageName+".entity." + entity.technicalNameCapitalized+"Entity";
			updateableApplication.removeClassBytes(fullEntityClassName);
		}
		for (EntityClassModel entity: classModels.updatedEntities) {
			//Instance
			String fullInstanceClassName = classModels.rootPackageName+"." + (entity.isCustomized?"Abstract":"") + entity.technicalNameCapitalized;
			updateableApplication.setClassBytes(fullInstanceClassName,
				InstanceBytecodeTemplate.generate(entity, fullInstanceClassName));
			//Entity
			String fullEntityClassName = classModels.rootPackageName+".entity." + entity.technicalNameCapitalized+"Entity";
			updateableApplication.setClassBytes(fullEntityClassName,
				EntityBytecodeTemplate.generate(entity, fullEntityClassName));
		}

		for (EventClassModel event: classModels.deletedEvents) {
			updateableApplication.removeClassBytes(event.getFullClassName());
		}
		for (EventClassModel event: classModels.updatedEvents) {
			updateableApplication.setClassBytes(event.getFullClassName(),
				EventBytecodeTemplate.generate(event));
		}
		
		for (FlowClassModel flow: classModels.deletedFlows) {
			updateableApplication.removeClassBytes(flow.getFullClassName());
		}
		for (FlowClassModel flow: classModels.updatedFlows) {
			updateableApplication.setClassBytes(flow.getFullClassName(),
				FlowBytecodeTemplate.generate(flow));
		}
		
		for (PlaceClassModel placeTemplate: classModels.deletedPlaces) {
			updateableApplication.removeClassBytes(placeTemplate.getFullClassName());
		}
		for (PlaceClassModel placeTemplate: classModels.updatedPlaces) {
			updateableApplication.setClassBytes(placeTemplate.getFullClassName(),
				PlaceTemplateBytecodeTemplate.generate(placeTemplate));
		}

		for (SubFlowClassModel subFlowTemplate: classModels.deletedSubFlows) {
			updateableApplication.removeClassBytes(subFlowTemplate.getFullClassName());
		}
		for (SubFlowClassModel subFlowTemplate: classModels.updatedSubFlows) {
			updateableApplication.setClassBytes(subFlowTemplate.getFullClassName(),
				SubFlowBytecodeTemplate.generate(subFlowTemplate));
		}
		
		for (SharedPageFragmentClassModel sharedPageFragment: classModels.deletedSharedPageFragments) {
			updateableApplication.removeClassBytes(sharedPageFragment.getFullClassName());
		}
		for (SharedPageFragmentClassModel sharedPageFragment: classModels.updatedSharedPageFragments) {
			updateableApplication.setClassBytes(sharedPageFragment.getFullClassName(),
				SharedPageFragmentBytecodeTemplate.generate(sharedPageFragment));
		}
		
		
	}
	
	private final ApplicationEnvironment applicationEnvironment;
	private final GeneratedClassModelsProcessor next;
	private JvmBytecodeApplication lastApplication;
	private String applicationName;
	private String applicationRootPackage;
	
	public ApplicationBytecodeGenerator(ApplicationEnvironment applicationEnvironment, GeneratedClassModelsProcessor next) {
		this.applicationEnvironment = applicationEnvironment;
		this.next = next;
	}

	@Override
	public void process(GeneratedClassModels models) {
		try {
			if (models.updatedApplication!=null) {
				this.applicationName = models.updatedApplication.name;
				this.applicationRootPackage = models.updatedApplication.rootPackageName;
			}
			if (lastApplication!=null) {
				lastApplication = new JvmBytecodeApplication(lastApplication);
			} else {
				lastApplication = new JvmBytecodeApplication();
			}
			update(models, lastApplication);
			URL[] customizationUrls;
			if (applicationName==null) {
				customizationUrls = new URL[0];
			} else {
				customizationUrls = new URL[]{applicationEnvironment.getCustomizationClassesUrl(applicationName)};
			}
			JvmBytecodeApplicationClassloader jvmBytecodeApplicationClassloader = 
				new JvmBytecodeApplicationClassloader(Application.class.getClassLoader(), lastApplication, customizationUrls);
			Application application = jvmBytecodeApplicationClassloader.getApplication(applicationRootPackage, applicationName);
			logger.debug("Generated bytecode for application {} consisting of {} classes and classfiles from {}", 
				new Object[]{this.applicationName, lastApplication.getClassCount(), customizationUrls});
			application.addCloseableResource(jvmBytecodeApplicationClassloader);
			// Add the data explorer
			application = new ApplicationWithDataExplorer(application);
			applicationEnvironment.updateApplication(application);
		} finally {
			if (next!=null) {
				next.process(models);
			}
		}
	}

	@Override
	public String getName() {
		return "ApplicationBytecodeGenerator";
	}
}
