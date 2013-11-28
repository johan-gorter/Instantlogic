package org.instantlogic.designer.codegenerator.javacode;


import java.io.File;

import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel;
import org.instantlogic.designer.codegenerator.classmodel.EventClassModel;
import org.instantlogic.designer.codegenerator.classmodel.FlowClassModel;
import org.instantlogic.designer.codegenerator.classmodel.PlaceTemplateClassModel;
import org.instantlogic.designer.codegenerator.classmodel.SharedPageFragmentClassModel;
import org.instantlogic.designer.codegenerator.classmodel.SubFlowClassModel;
import org.instantlogic.designer.codegenerator.classmodel.ValidationClassModel;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModelsProcessor;

public class ApplicationJavacodeGenerator extends AbstractJavacodeGenerator implements GeneratedClassModelsProcessor {

	private File applicationRoot = null;
	
	public void generate(GeneratedClassModels context) {
		if (context.updatedApplication!=null) { 
			if (!context.updatedApplication.isDeleted) {
				File newApplicationRoot = sourcePath;
				String[] packageNames = context.updatedApplication.rootPackageName.split("\\.");
				for (String packageName : packageNames) {
					newApplicationRoot = new File(newApplicationRoot, packageName);
				}
				if (!newApplicationRoot.equals(applicationRoot)) {
					//TODO: clean previous applicationRoot
					applicationRoot = newApplicationRoot;
				}
				applicationRoot.mkdirs();
				new File(applicationRoot, "entity").mkdirs();
				new File(applicationRoot, "event").mkdirs();
				new File(applicationRoot, "placetemplate").mkdirs();
				new File(applicationRoot, "flow").mkdirs();
				new File(applicationRoot, "validation").mkdirs();
				new File(applicationRoot, "sharedpagefragment").mkdirs();
				
				generateFile(AbstractJavacodeGenerator.applicationTemplate, context.updatedApplication, null, "Application", applicationRoot);
			} else {
				// TODO: clean previous applicationRoot
				return;
			}
		}
		if (applicationRoot==null) {
			return;
		}
		for (EntityClassModel entity: context.updatedEntities) {
			if (entity.isDeleted) {
				deleteFile("entity", entity, "Entity", applicationRoot);
				deleteFile(null, entity, "", applicationRoot);
				deleteFile(null, entity, "", applicationRoot);
			} else {
				generateFile(AbstractJavacodeGenerator.entityTemplate, entity, "entity", "Entity", applicationRoot);
				generateFile(AbstractJavacodeGenerator.instanceTemplate, entity, null, "", applicationRoot);
			}
		}
		for (SharedPageFragmentClassModel sharedPageFragment:context.updatedSharedPageFragments) {
			if (sharedPageFragment.isDeleted) {
				deleteFile("sharedpagefragment", sharedPageFragment, "Pagefragment", applicationRoot);
			} else {
				generateFile(AbstractJavacodeGenerator.pageFragmentTemplate, sharedPageFragment, "sharedpagefragment", "PageFragment", applicationRoot);
			}
		}
		for (EventClassModel event:context.updatedEvents) {
			if (event.isDeleted) {
				deleteFile("event", event, "Event", applicationRoot);				
			} else {
				generateFile(AbstractJavacodeGenerator.eventTemplate, event, "event", "Event", applicationRoot);
			}
		}
		for (PlaceTemplateClassModel placeTemplate:context.updatedPlaces) {
			if (placeTemplate.flowname==null) {
				if (placeTemplate.isDeleted) {
					deleteFile("placetemplate", placeTemplate, "PlaceTemplate", applicationRoot);	
				} else {
					generateFile(AbstractJavacodeGenerator.placeTemplateTemplate, placeTemplate, "placetemplate", "PlaceTemplate", applicationRoot);
				}
			} else {
				// Old
				if (placeTemplate.isDeleted) {
					deleteFile("flow/"+placeTemplate.flowname.toLowerCase(), placeTemplate, "PlaceTemplate", applicationRoot);	
				} else {
					generateFile(AbstractJavacodeGenerator.placeTemplateTemplate, placeTemplate, "flow/"+placeTemplate.flowname.toLowerCase(), "PlaceTemplate", applicationRoot);
				}
			}
		}
		for (FlowClassModel flow:context.updatedFlows) {
			if (flow.isDeleted) {
				deleteFile("flow", flow, "Flow", applicationRoot);
				File dir = new File(applicationRoot,"flow/"+flow.name.toLowerCase()); 
				purge(dir);
				dir.delete();
			} else {
				generateFile(AbstractJavacodeGenerator.flowTemplate, flow, "flow", "Flow", applicationRoot);
				if (applicationRoot!=null) {
					new File(new File(applicationRoot,"flow"), flow.technicalNameCapitalized.toLowerCase()).mkdirs();
				}
			}
		}
		for (SubFlowClassModel subFlow:context.updatedSubFlows) {
			if (subFlow.isDeleted) {
				deleteFile("flow/"+subFlow.flowname.toLowerCase(), subFlow, "SubFlow", applicationRoot);
			} else {
				generateFile(AbstractJavacodeGenerator.subFlowTemplate, subFlow, "flow/"+subFlow.flowname.toLowerCase(), "SubFlow", applicationRoot);
			}
		}
		for (ValidationClassModel validation:context.updatedValidations) {
			if (validation.isDeleted) {
				deleteFile("validation", validation, "Validation", applicationRoot);
			} else {
				generateFile(AbstractJavacodeGenerator.validationTemplate, validation, "validation", "Validation", applicationRoot);
			}
		}
	}

	private File sourcePath;
	
	public ApplicationJavacodeGenerator(File sourcePath) {
		this.sourcePath = sourcePath;
	}

	@Override
	public void process(GeneratedClassModels models, String applicationName) {
		generate(models);
	}

	@Override
	public String getName() {
		return "Java code generator";
	}
}
