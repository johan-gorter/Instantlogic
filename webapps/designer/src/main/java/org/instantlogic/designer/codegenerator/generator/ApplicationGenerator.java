package org.instantlogic.designer.codegenerator.generator;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.Design;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.EventDesign;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.SharedElementDefinitionDesign;
import org.instantlogic.designer.codegenerator.classmodel.ApplicationClassModel;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;
import org.instantlogic.designer.deduction.TechnicalNameDeduction;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

/**
 * Here the generation of the application starts. 
 * 
 * This class is able to 
 * generate a list of changes (classmodelupdates) that can be sent to another
 * thread to be generated out to java bytecode or java source files.
 */
public class ApplicationGenerator extends AbstractGenerator<ApplicationClassModel> {

	private ApplicationDesign applicationInstance;
	
	private Map<String, EntityGenerator> entityGenerators=new HashMap<String, EntityGenerator>();
	private Map<String, EventGenerator> eventGenerators = new HashMap<String, EventGenerator>(); 
	private Map<String, FlowGenerator> flowGenerators = new HashMap<String, FlowGenerator>(); 
	private Map<String, SharedElementDefinitionGenerator> sharedPageFragmentGenerators = new HashMap<String, SharedElementDefinitionGenerator>();

	public ApplicationGenerator(ApplicationDesign applicationInstance) {
		this.applicationInstance = applicationInstance;
	}
	
	public void resetClassModelUpdates() {
		if (observations==null) return;
		observations.remove();
		observations = null;
		entityGenerators.clear();
		eventGenerators.clear();
		flowGenerators.clear();
		sharedPageFragmentGenerators.clear();
		// TODO: remove the memory leak here
	}
	
	/**
	 * @return The updates to the class models since the previous call (or since resetClassModelUpdates()). On the first call, every classmodel is returned.
	 */
	public GeneratedClassModels getClassModelUpdates() {
		GeneratedClassModels result = new GeneratedClassModels();
		update(result);
		return result;
	}
	
	@Override
	public ApplicationClassModel generate(GeneratedClassModels context) {
		if (observations!=null && !observations.isOutdated()) {
			// Our observations are not changed, but maybe there are changes in one of these generators
			updateAll(entityGenerators.values(), context);
			updateAll(eventGenerators.values(), context);
			updateAll(flowGenerators.values(), context);
			updateAll(sharedPageFragmentGenerators.values(), context);
			return null;
		}
		
		applicationInstance.getMetadata().getCaseAdministration().startRecordingObservations();
		ApplicationClassModel model = new ApplicationClassModel();
		
		model.rootPackageName = applicationInstance.getRootPackageName();
		model.name = applicationInstance.getName();
		model.technicalNameCapitalized = TechnicalNameDeduction.capitalizeFirst(TechnicalNameDeduction.makeTechnicalName(applicationInstance.getName()));
		model.isCustomized = applicationInstance.getIsCustomized()==Boolean.TRUE;
		
		model.determineIsDeleted(applicationInstance.isValidForCodeGeneration());
		
		for (EntityDesign entity: applicationInstance.getEntities()) {
			model.entities.add(entity.getTechnicalNameCapitalized());
		}
		if (applicationInstance.getCaseEntity()!=null && applicationInstance.getCaseEntity().isValidForCodeGeneration()) {
			model.caseEntity = applicationInstance.getCaseEntity().getTechnicalNameCapitalized();
		}
		if (applicationInstance.getMainFlow()!=null) {
			model.mainFlow = applicationInstance.getMainFlow().getTechnicalNameCapitalized();
		}
		if (applicationInstance.getStartEvent()!=null) {
			model.startEvent = applicationInstance.getStartEvent().getTechnicalNameCapitalized();
		}
		if (applicationInstance.getLoggedInEvent()!=null) {
			model.loggedInEvent = applicationInstance.getLoggedInEvent().getTechnicalNameCapitalized();
		}
		if (applicationInstance.getThemeNames().size()>0) {
			model.themeNames = applicationInstance.getThemeNames().asCollection().toArray(new String[applicationInstance.getThemeNames().size()]);
		} else {
			model.themeNames = new String[0];
		}
		
		List<Design> newEntities = updateGenerators(entityGenerators, applicationInstance.getEntities(), context);
		for(Design newEntity : newEntities) {
			EntityGenerator entityGenerator = new EntityGenerator((EntityDesign)newEntity);
			entityGenerator.update(context);
			entityGenerators.put(newEntity.getName(), entityGenerator);
		}
		
		// Comment from here to temporary skip the interaction part
		
		List<Design> newSharedPageFragments = updateGenerators(sharedPageFragmentGenerators, applicationInstance.getSharedElements(), context);
		for(Design newSharedPageFragment : newSharedPageFragments) {
			SharedElementDefinitionGenerator sharedPageFragmentGenerator = new SharedElementDefinitionGenerator((SharedElementDefinitionDesign)newSharedPageFragment);
			sharedPageFragmentGenerator.update(context);
			sharedPageFragmentGenerators.put(newSharedPageFragment.getName(), sharedPageFragmentGenerator);
		}

		List<Design> newEvents = updateGenerators(eventGenerators, applicationInstance.getEvents(), context);
		for(Design newEvent : newEvents) {
			EventGenerator eventGenerator = new EventGenerator((EventDesign)newEvent);
			eventGenerator.update(context);
			eventGenerators.put(newEvent.getName(), eventGenerator);
		}
		
		List<Design> newFlows = updateGenerators(flowGenerators, applicationInstance.getFlows(), context);
		for(Design newFlow : newFlows) {
			FlowGenerator flowGenerator = new FlowGenerator((FlowDesign)newFlow);
			flowGenerator.update(context);
			flowGenerators.put(newFlow.getName(), flowGenerator);
		}
		
		this.observations = new ObservationsOutdatedObserver(applicationInstance.getMetadata().getCaseAdministration().stopRecordingObservations(), null);
		return model;
	}
	
	@Override
	public void queueClassModel(ApplicationClassModel classModel, GeneratedClassModels context) {
		context.updatedApplication = classModel;
	}
}
