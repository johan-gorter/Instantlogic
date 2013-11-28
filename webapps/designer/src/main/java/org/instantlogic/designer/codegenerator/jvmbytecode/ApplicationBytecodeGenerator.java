package org.instantlogic.designer.codegenerator.jvmbytecode;

import java.net.URL;

import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel;
import org.instantlogic.designer.codegenerator.classmodel.EventClassModel;
import org.instantlogic.designer.codegenerator.classmodel.FlowClassModel;
import org.instantlogic.designer.codegenerator.classmodel.PlaceTemplateClassModel;
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
import org.instantlogic.designer.util.NoSuchApplicationApplication;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.DesignerApplicationEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationBytecodeGenerator implements GeneratedClassModelsProcessor {

	private static final Logger logger = LoggerFactory.getLogger(DesignerPersistenceStrategy.class);

	public static void update(GeneratedClassModels classModels, JvmBytecodeApplication updateableApplication) {
		if (classModels.updatedApplication!=null) {
			String fullApplicationClassName = classModels.updatedApplication.rootPackageName+"." + (classModels.updatedApplication.isCustomized?"Abstract":"") +classModels.updatedApplication.name+"Application";
			if (classModels.updatedApplication.isDeleted) {
				updateableApplication.removeClassBytes(fullApplicationClassName);
			} else {
				updateableApplication.setClassBytes(fullApplicationClassName,
					ApplicationBytecodeTemplate.generate(classModels.updatedApplication, fullApplicationClassName));
			}
		}
		for (EntityClassModel entity: classModels.updatedEntities) {
			String fullInstanceClassName = entity.rootPackageName+"." + (entity.isCustomized?"Abstract":"") + entity.technicalNameCapitalized;
			String fullEntityClassName = entity.rootPackageName+".entity." + entity.technicalNameCapitalized+"Entity";
			if (entity.isDeleted) {
				//Instance
				updateableApplication.removeClassBytes(fullInstanceClassName);
				//Entity
				updateableApplication.removeClassBytes(fullEntityClassName);
			} else {
				//Instance
				updateableApplication.setClassBytes(fullInstanceClassName,
					InstanceBytecodeTemplate.generate(entity, fullInstanceClassName));
				//Entity
				updateableApplication.setClassBytes(fullEntityClassName,
					EntityBytecodeTemplate.generate(entity, fullEntityClassName));
			}
		}

		for (EventClassModel event: classModels.updatedEvents) {
			if (event.isDeleted) {
				updateableApplication.removeClassBytes(event.getFullClassName());
			} else {
				updateableApplication.setClassBytes(event.getFullClassName(),
					EventBytecodeTemplate.generate(event));
			}
		}
		
		for (FlowClassModel flow: classModels.updatedFlows) {
			if (flow.isDeleted) {
				updateableApplication.removeClassBytes(flow.getFullClassName());
			} else {
				updateableApplication.setClassBytes(flow.getFullClassName(), FlowBytecodeTemplate.generate(flow));
			}
		}
		
		for (PlaceTemplateClassModel placeTemplate: classModels.updatedPlaces) {
			if (placeTemplate.isDeleted) {
				updateableApplication.removeClassBytes(placeTemplate.getFullClassName());
			} else {
				updateableApplication.setClassBytes(placeTemplate.getFullClassName(),
						PlaceTemplateBytecodeTemplate.generate(placeTemplate));
			}
		}

		for (SubFlowClassModel subFlowTemplate: classModels.updatedSubFlows) {
			if (subFlowTemplate.isDeleted) {
				updateableApplication.removeClassBytes(subFlowTemplate.getFullClassName());
			} else {
				updateableApplication.setClassBytes(subFlowTemplate.getFullClassName(),
					SubFlowBytecodeTemplate.generate(subFlowTemplate));
			}
		}
		
		for (SharedPageFragmentClassModel sharedPageFragment: classModels.updatedSharedPageFragments) {
			if (sharedPageFragment.isDeleted) {
				updateableApplication.removeClassBytes(sharedPageFragment.getFullClassName());
			} else {
				updateableApplication.setClassBytes(sharedPageFragment.getFullClassName(),
					SharedPageFragmentBytecodeTemplate.generate(sharedPageFragment));
			}
		}
	}
	
	private final DesignerApplicationEnvironment applicationEnvironment;
	private final GeneratedClassModelsProcessor next;
	private JvmBytecodeApplication lastApplication;
	private String applicationName;
	private String applicationRootPackage;
	private boolean applicationIsDeleted = false;
	
	public ApplicationBytecodeGenerator(DesignerApplicationEnvironment applicationEnvironment, GeneratedClassModelsProcessor next) {
		this.applicationEnvironment = applicationEnvironment;
		this.next = next;
	}

	@Override
	public void process(GeneratedClassModels models, String applicationName) {
		try {
			if (models.updatedApplication!=null) {
				this.applicationName = models.updatedApplication.name;
				this.applicationRootPackage = models.updatedApplication.rootPackageName;
				this.applicationIsDeleted = models.updatedApplication.isDeleted;
			}
			if (lastApplication!=null) {
				lastApplication = new JvmBytecodeApplication(lastApplication);
			} else {
				lastApplication = new JvmBytecodeApplication();
			}
			update(models, lastApplication);
			URL[] customizationUrls;
			if (this.applicationName==null) {
				customizationUrls = new URL[0];
			} else if ("nextdesigner".equals(applicationName)) {
				customizationUrls = new URL[]{applicationEnvironment.getCustomizationClassesUrl("designer")};
			} else {
				customizationUrls = new URL[]{applicationEnvironment.getCustomizationClassesUrl(applicationName)};
			}
			if (!this.applicationIsDeleted) {
				JvmBytecodeApplicationClassloader jvmBytecodeApplicationClassloader = 
					new JvmBytecodeApplicationClassloader(Application.class.getClassLoader(), lastApplication, customizationUrls);
				Application application = jvmBytecodeApplicationClassloader.getApplication(applicationRootPackage, this.applicationName);
				logger.debug("Generated bytecode for application {} consisting of {} classes and classfiles from {}", 
					new Object[]{this.applicationName, lastApplication.getClassCount(), customizationUrls});
				application.addCloseableResource(jvmBytecodeApplicationClassloader);
				// Add the data explorer
				application = new ApplicationWithDataExplorer(application);
				applicationEnvironment.updateApplication(application, applicationName);
			} else {
				applicationEnvironment.updateApplication(new NoSuchApplicationApplication(applicationName), applicationName);
			}
		} finally {
			if (next!=null) {
				next.process(models, applicationName);
			}
		}
	}

	@Override
	public String getName() {
		return "ApplicationBytecodeGenerator";
	}
}
