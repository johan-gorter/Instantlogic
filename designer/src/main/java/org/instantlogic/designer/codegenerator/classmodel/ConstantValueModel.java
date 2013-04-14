package org.instantlogic.designer.codegenerator.classmodel;

import org.instantlogic.designer.deduction.TechnicalNameDeduction;
import org.instantlogic.fabric.Instance;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

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
	public void writeJvmBytecode(MethodVisitor mv) {
		if (constantValue instanceof Boolean) {
			if (constantValue==Boolean.TRUE) {
				mv.visitInsn(Opcodes.ICONST_1);
			} else {
				mv.visitInsn(Opcodes.ICONST_0);
			}
		} else if (constantValue instanceof Number) {
			mv.visitIntInsn(Opcodes.BIPUSH, (Integer)constantValue);
		} else {
			throw new RuntimeException("Unsupported value "+constantValue);
		}
	}
}
