package org.instantlogic.designer.codegenerator.jvmbytecode;

import java.util.Map;

import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.jvmbytecode.template.EntityBytecodeTemplate;
import org.instantlogic.designer.codegenerator.jvmbytecode.template.InstanceBytecodeTemplate;

public class ApplicationBytecodeGenerator extends AbstractBytecodeGenerator {

	public static void generate(GeneratedClassModels classModels, Map<String, byte[]> bytecodeClasses) {
		if (classModels.updatedApplication!=null) {
			//todo
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
