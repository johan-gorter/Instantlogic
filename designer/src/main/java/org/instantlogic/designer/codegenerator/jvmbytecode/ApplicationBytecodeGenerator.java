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
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.jvmbytecode.template.ApplicationBytecodeTemplate;
import org.instantlogic.designer.codegenerator.jvmbytecode.template.EntityBytecodeTemplate;
import org.instantlogic.designer.codegenerator.jvmbytecode.template.InstanceBytecodeTemplate;

public class ApplicationBytecodeGenerator extends AbstractBytecodeGenerator {

	public static void generate(GeneratedClassModels classModels, Map<String, byte[]> bytecodeClasses) {
		if (classModels.updatedApplication!=null) {
			String fullApplicationClassName = classModels.rootPackageName+"." + classModels.updatedApplication.name+"Application";
			remove(bytecodeClasses, fullApplicationClassName);
			ApplicationBytecodeTemplate.generate(bytecodeClasses, classModels.updatedApplication);
		}
		for (EntityClassModel entity: classModels.deletedEntities) {
			//Instance
			String fullInstanceClassName = classModels.rootPackageName+"." + entity.name;
			remove(bytecodeClasses, fullInstanceClassName);
			//Entity
			String fullEntityClassName = classModels.rootPackageName+".entity." + entity.name+"Entity";
			remove(bytecodeClasses, fullEntityClassName);
		}
		for (EntityClassModel entity: classModels.updatedEntities) {
			//Instance
			String fullInstanceClassName = classModels.rootPackageName+"." + entity.name;
			remove(bytecodeClasses, fullInstanceClassName);
			InstanceBytecodeTemplate.generate(bytecodeClasses, entity);
			//Entity
			String fullEntityClassName = classModels.rootPackageName+".entity." + entity.name+"Entity";
			remove(bytecodeClasses, fullEntityClassName);
			EntityBytecodeTemplate.generate(bytecodeClasses, fullEntityClassName, entity);
		}
	}

	protected static void remove(Map<String, byte[]> bytecodeClasses, String fullClassName) {
		bytecodeClasses.remove(fullClassName);
		int i=1;
		while (bytecodeClasses.remove(fullClassName+"$"+i)!=null) {
			i++;
		}
	}
}
