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

import java.util.Map;

import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

public class InstanceBytecodeTemplate extends AbstractTemplate {

	public static void generate(Map<String, byte[]> bytecodeClasses, EntityClassModel model) {
		bytecodeClasses.put(model.rootPackageName+"."+model.name, dump(model));	
	}

	public static byte[] dump(EntityClassModel model) {

		ClassWriter cw = new ClassWriter(0);
		FieldVisitor fv;
		MethodVisitor mv;

		cw.visit(V1_6, ACC_PUBLIC + ACC_SUPER, model.getRootPackageInternalPrefix()+model.name, null, "org/instantlogic/fabric/Instance", null);

		cw.visitSource(model.name+".java", null);

		{
			for (EntityClassModel.Attribute a : model.attributes) {
				fv = cw.visitField(
						ACC_PRIVATE + ACC_FINAL, 
						a.name, 
						"Lorg/instantlogic/fabric/value/AttributeValue;",
						null,//"Lorg/instantlogic/fabric/value/AttributeValue<Lcom/instantlogic/mini/MiniThing;Ljava/lang/Float;>;", 
						null);
				fv.visitEnd();
			}
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/fabric/Instance", "<init>", "()V");
			for (EntityClassModel.Attribute a : model.attributes) {
				mv.visitVarInsn(ALOAD, 0);
				mv.visitVarInsn(ALOAD, 0);
				mv.visitFieldInsn(GETSTATIC, model.getInternalEntityName(), a.name, "Lorg/instantlogic/fabric/model/Attribute;");
				mv.visitMethodInsn(INVOKEVIRTUAL, model.getInternalName(), "createAttributeValue", "(Lorg/instantlogic/fabric/model/Attribute;)Lorg/instantlogic/fabric/value/AttributeValue;");
				mv.visitFieldInsn(PUTFIELD, model.getInternalName(), a.name, "Lorg/instantlogic/fabric/value/AttributeValue;");
			}
			mv.visitInsn(RETURN);
			mv.visitMaxs(3, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getInstanceEntity", "()Lorg/instantlogic/fabric/model/Entity;", null, null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitFieldInsn(GETSTATIC, "com/instantlogic/mini/entity/MiniThingEntity", "INSTANCE", "Lcom/instantlogic/mini/entity/MiniThingEntity;");
			mv.visitInsn(ARETURN);
			Label l1 = new Label();
			mv.visitLabel(l1);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getMiniProperty", "()Ljava/lang/Float;", null, null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitFieldInsn(GETFIELD, "com/instantlogic/mini/MiniThing", "miniProperty", "Lorg/instantlogic/fabric/value/AttributeValue;");
			mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/AttributeValue", "getValue", "()Ljava/lang/Object;");
			mv.visitTypeInsn(CHECKCAST, "java/lang/Float");
			mv.visitInsn(ARETURN);
			Label l1 = new Label();
			mv.visitLabel(l1);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getMiniPropertyAttributeValue", "()Lorg/instantlogic/fabric/value/AttributeValue;",
					"()Lorg/instantlogic/fabric/value/AttributeValue<Lcom/instantlogic/mini/MiniThing;Ljava/lang/Float;>;", null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitFieldInsn(GETFIELD, "com/instantlogic/mini/MiniThing", "miniProperty", "Lorg/instantlogic/fabric/value/AttributeValue;");
			mv.visitInsn(ARETURN);
			Label l1 = new Label();
			mv.visitLabel(l1);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "setMiniProperty", "(Ljava/lang/Float;)Lcom/instantlogic/mini/MiniThing;", null, null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitFieldInsn(GETFIELD, "com/instantlogic/mini/MiniThing", "miniProperty", "Lorg/instantlogic/fabric/value/AttributeValue;");
			mv.visitVarInsn(ALOAD, 1);
			mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/AttributeValue", "setValue", "(Ljava/lang/Object;)V");
			Label l1 = new Label();
			mv.visitLabel(l1);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitInsn(ARETURN);
			Label l2 = new Label();
			mv.visitLabel(l2);
			mv.visitMaxs(2, 2);
			mv.visitEnd();
		}
		cw.visitEnd();

		return cw.toByteArray();
	}
}
