/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer.codegenerator.jvmbytecode;

import java.util.Map;

import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel;
import org.instantlogic.designer.codegenerator.classmodel.EventClassModel;
import org.instantlogic.designer.codegenerator.classmodel.FlowClassModel;
import org.instantlogic.designer.codegenerator.classmodel.PlaceClassModel;
import org.instantlogic.designer.codegenerator.classmodel.SubFlowClassModel;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.jvmbytecode.template.ApplicationBytecodeTemplate;
import org.instantlogic.designer.codegenerator.jvmbytecode.template.EntityBytecodeTemplate;
import org.instantlogic.designer.codegenerator.jvmbytecode.template.EventBytecodeTemplate;
import org.instantlogic.designer.codegenerator.jvmbytecode.template.FlowBytecodeTemplate;
import org.instantlogic.designer.codegenerator.jvmbytecode.template.InstanceBytecodeTemplate;
import org.instantlogic.designer.codegenerator.jvmbytecode.template.PlaceTemplateBytecodeTemplate;
import org.instantlogic.designer.codegenerator.jvmbytecode.template.SubFlowBytecodeTemplate;

public class ApplicationBytecodeGenerator extends AbstractBytecodeGenerator {

	public static void generate(GeneratedClassModels classModels, Map<String, byte[]> bytecodeClasses) {
		if (classModels.updatedApplication!=null) {
			String fullApplicationClassName = classModels.rootPackageName+"." + classModels.updatedApplication.name+"Application";
			remove(bytecodeClasses, fullApplicationClassName);
			ApplicationBytecodeTemplate.generate(bytecodeClasses, classModels.updatedApplication, fullApplicationClassName);
		}
		for (EntityClassModel entity: classModels.deletedEntities) {
			//Instance
			String fullInstanceClassName = classModels.rootPackageName+"." + (entity.isCustomized?"Abstract":"") + entity.technicalNameCapitalized;
			remove(bytecodeClasses, fullInstanceClassName);
			//Entity
			String fullEntityClassName = classModels.rootPackageName+".entity." + entity.technicalNameCapitalized+"Entity";
			remove(bytecodeClasses, fullEntityClassName);
		}
		for (EntityClassModel entity: classModels.updatedEntities) {
			//Instance
			String fullInstanceClassName = classModels.rootPackageName+"." + (entity.isCustomized?"Abstract":"") + entity.technicalNameCapitalized;
			remove(bytecodeClasses, fullInstanceClassName);
			InstanceBytecodeTemplate.generate(bytecodeClasses, entity, fullInstanceClassName);
			//Entity
			String fullEntityClassName = classModels.rootPackageName+".entity." + entity.technicalNameCapitalized+"Entity";
			remove(bytecodeClasses, fullEntityClassName);
			EntityBytecodeTemplate.generate(bytecodeClasses, entity, fullEntityClassName);
		}

		for (EventClassModel event: classModels.deletedEvents) {
			remove(bytecodeClasses, event.getFullClassName());
		}
		for (EventClassModel event: classModels.updatedEvents) {
			remove(bytecodeClasses, event.getFullClassName());
			bytecodeClasses.put(event.getFullClassName(), EventBytecodeTemplate.generate(event));
		}
		
		for (FlowClassModel flow: classModels.deletedFlows) {
			remove(bytecodeClasses, flow.getFullClassName());
		}
		for (FlowClassModel flow: classModels.updatedFlows) {
			remove(bytecodeClasses, flow.getFullClassName());
			bytecodeClasses.put(flow.getFullClassName(), FlowBytecodeTemplate.generate(flow));
		}
		
		for (PlaceClassModel placeTemplate: classModels.deletedPlaces) {
			remove(bytecodeClasses, placeTemplate.getFullClassName());
		}
		for (PlaceClassModel placeTemplate: classModels.updatedPlaces) {
			remove(bytecodeClasses, placeTemplate.getFullClassName());
			bytecodeClasses.put(placeTemplate.getFullClassName(), PlaceTemplateBytecodeTemplate.generate(placeTemplate));
		}

		for (SubFlowClassModel subFlowTemplate: classModels.deletedSubFlows) {
			remove(bytecodeClasses, subFlowTemplate.getFullClassName());
		}
		for (SubFlowClassModel subFlowTemplate: classModels.updatedSubFlows) {
			remove(bytecodeClasses, subFlowTemplate.getFullClassName());
			bytecodeClasses.put(subFlowTemplate.getFullClassName(), SubFlowBytecodeTemplate.generate(subFlowTemplate));
		}
	}

	protected static void remove(Map<String, byte[]> bytecodeClasses, String fullClassName) {
		bytecodeClasses.remove(fullClassName);
//		int i=1;
//		while (bytecodeClasses.remove(fullClassName+"$"+i)!=null) {
//			i++;
//		}
	}
}
