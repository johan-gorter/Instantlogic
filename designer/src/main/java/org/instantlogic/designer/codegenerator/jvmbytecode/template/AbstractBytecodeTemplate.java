/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer.codegenerator.jvmbytecode.template;

import org.instantlogic.designer.codegenerator.classmodel.DeductionModel;
import org.instantlogic.designer.codegenerator.classmodel.DeductionModel.Parameter;
import org.instantlogic.designer.codegenerator.classmodel.DeductionSchemeModel;
import org.objectweb.asm.*;

public class AbstractBytecodeTemplate implements Opcodes {

	protected static String upperFirst(String name) {
		return name.substring(0,1).toUpperCase()+name.substring(1);
	}
	
	protected static void throwUnsupported(MethodVisitor mv) {
		mv.visitTypeInsn(NEW, "java/lang/UnsupportedOperationException");
		mv.visitInsn(DUP);
		mv.visitMethodInsn(INVOKESPECIAL, "java/lang/UnsupportedOperationException", "<init>", "()V");
		mv.visitInsn(ATHROW);
	}
	
	protected static void emitReturnTrue(ClassWriter cw, String methodName) {
		{
			MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, methodName, "()Z", null, null);
			mv.visitCode();
			mv.visitInsn(ICONST_1);
			mv.visitInsn(IRETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}			
	}
	
	protected static void dumpDeductionScheme(ClassVisitor cw, DeductionSchemeModel scheme) {
		MethodVisitor mv = cw.visitMethod(ACC_PRIVATE + ACC_STATIC, "createDeduction"+scheme.index, "()Lorg/instantlogic/fabric/deduction/Deduction;", null, null);
		mv.visitCode();
		int localVariableIndex = 0;
		for (DeductionModel deduction: scheme.deductions) {
			// org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
			mv.visitTypeInsn(NEW, deduction.getInternalClassName());
			mv.visitInsn(DUP);
			mv.visitMethodInsn(INVOKESPECIAL, deduction.getInternalClassName(), "<init>", "()V");
			mv.visitVarInsn(ASTORE, localVariableIndex);
			for (Parameter parameter: deduction.getParameters()) {
				// d0.setAttribute(org.instantlogic.example.izzy.entity.ProjectEntity.users);
				mv.visitVarInsn(ALOAD, localVariableIndex);
				parameter.getValue().writeJvmBytecode(mv);
				mv.visitMethodInsn(INVOKEVIRTUAL, deduction.getInternalClassName() , "set"+parameter.name, "(Lorg/instantlogic/fabric/model/Attribute;)V");
			}
			localVariableIndex++;
		}
		localVariableIndex = 0;
		for (DeductionModel deduction: scheme.deductions) {
			localVariableIndex++;
			for (DeductionModel.Input input: deduction.inputs) {
				// d0.setInstance(d1);
				mv.visitVarInsn(ALOAD, localVariableIndex);
				mv.visitVarInsn(ALOAD, input.deductionIndex);
				if (input.multivalue) {
					mv.visitMethodInsn(INVOKEVIRTUAL, deduction.getInternalClassName(), "addTo"+input.getInputName(), "(Lorg/instantlogic/fabric/deduction/Deduction;)V");
				} else {
					mv.visitMethodInsn(INVOKEVIRTUAL, deduction.getInternalClassName(), "set"+input.getInputName(), "(Lorg/instantlogic/fabric/deduction/Deduction;)V");
				}
			}
		}
		mv.visitVarInsn(ALOAD, 0);
		mv.visitInsn(ARETURN);
		mv.visitMaxs(2, 2);
		mv.visitEnd();
	}	
}
