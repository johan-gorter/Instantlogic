package org.instantlogic.designer;

import org.instantlogic.designer.codegenerator.classmodel.StaticFieldValueModel;
import org.instantlogic.designer.codegenerator.classmodel.ValueModel;

public class StaticInstanceDesign extends AbstractStaticInstanceDesign {

	public ValueModel asStaticFieldValue() {
		EntityDesign entity = getEntity();
		String instanceClassName = entity.getApplication().getRootPackageName()+"."+entity.getTechnicalNameCapitalized();
		return new StaticFieldValueModel(instanceClassName, getJavaIdentifier(), instanceClassName);
	}

}
