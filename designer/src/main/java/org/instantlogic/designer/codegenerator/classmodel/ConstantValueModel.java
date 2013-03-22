package org.instantlogic.designer.codegenerator.classmodel;

import org.instantlogic.designer.deduction.TechnicalNameDeduction;
import org.instantlogic.fabric.Instance;
import org.objectweb.asm.ClassWriter;

public class ConstantValueModel extends ValueModel {

	private final Object constantValue;
	
	public ConstantValueModel(Object constantValue) {
		this.constantValue = constantValue;
	}

	@Override
	public String getAsJavaTemplate() {
		if (constantValue==null) {
			return "null";
		} else if (constantValue instanceof Instance) { // Must be a static instance
			return ((Instance)constantValue).getMetadata().getEntity().getInstanceClass().getName() + "."+TechnicalNameDeduction.makeTechnicalName(((Instance)constantValue).getMetadata().getStaticName());
		} else if (constantValue instanceof String) {
			return "\""+constantValue.toString()+"\"";
		} else {
			return constantValue.toString();
		}
	}

	@Override
	public void writeJvmBytecode(ClassWriter cw) {
	}
}
