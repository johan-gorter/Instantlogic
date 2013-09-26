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
		if (constantValue instanceof Instance) { // Must be a static instance
			String className = ((Instance)constantValue).getMetadata().getEntity().getInstanceClass().getName();
			String fieldName = TechnicalNameDeduction.makeTechnicalName(((Instance)constantValue).getMetadata().getStaticName());
			mv.visitFieldInsn(Opcodes.GETSTATIC, className.replace('.', '/'), fieldName, "L"+className.replace('.', '/')+";");
		} else if (constantValue instanceof Boolean) {
			if (constantValue==Boolean.TRUE) {
				mv.visitInsn(Opcodes.ICONST_1);
			} else {
				mv.visitInsn(Opcodes.ICONST_0);
			}
			mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
		} else if (constantValue instanceof Integer) {
			int intValue = (Integer)constantValue;
			if (intValue <= 5) {
				mv.visitInsn(Opcodes.ICONST_0+intValue);
			} else {
				mv.visitIntInsn(Opcodes.BIPUSH, (Integer)constantValue);
			}
			mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
		} else if (constantValue instanceof Number) {
			mv.visitLdcInsn(((Number) constantValue).doubleValue());
		} else if (constantValue instanceof String) {
			mv.visitLdcInsn(constantValue);
		} else {
			throw new RuntimeException("Unsupported value "+constantValue);
		}
	}
}
