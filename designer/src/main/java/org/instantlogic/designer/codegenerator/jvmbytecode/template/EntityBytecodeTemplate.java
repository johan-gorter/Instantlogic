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
import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel.Attribute;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public class EntityBytecodeTemplate extends AbstractTemplate {

	public static void generate(Map<String, byte[]> bytecodeClasses, String fullName, EntityClassModel model) {
		bytecodeClasses.put(fullName, dump(model));
		for (int i = 0; i < model.attributes.size(); i++) {
			bytecodeClasses.put(fullName + "$" + (i + 1), dumpAttributeInnerClass(model, i+1, model.attributes.get(i)));
		}
	}

	private static byte[] dumpAttributeInnerClass(EntityClassModel model, int innerClassIndex, Attribute attribute) {
		ClassWriter cw = new ClassWriter(0);
		MethodVisitor mv;

		cw.visit(V1_6, ACC_SUPER, "com/instantlogic/mini/entity/MiniThingEntity$"+innerClassIndex,
				"Lorg/instantlogic/fabric/model/impl/SimpleAttribute<Lcom/instantlogic/mini/MiniThing;Ljava/lang/Float;Ljava/lang/Float;>;",
				"org/instantlogic/fabric/model/impl/SimpleAttribute", null);

		cw.visitSource("MiniThingEntity.java", null);

		cw.visitOuterClass("com/instantlogic/mini/entity/MiniThingEntity", null, null);

		cw.visitInnerClass("com/instantlogic/mini/entity/MiniThingEntity$"+innerClassIndex, null, null, 0);

		{
			mv = cw.visitMethod(0, "<init>", "(Ljava/lang/String;Lorg/instantlogic/fabric/model/Entity;Ljava/lang/Class;)V", null, null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitVarInsn(ALOAD, 1);
			mv.visitVarInsn(ALOAD, 2);
			mv.visitVarInsn(ALOAD, 3);
			mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/fabric/model/impl/SimpleAttribute", "<init>",
					"(Ljava/lang/String;Lorg/instantlogic/fabric/model/Entity;Ljava/lang/Class;)V");
			Label l1 = new Label();
			mv.visitLabel(l1);
			mv.visitInsn(RETURN);
			Label l2 = new Label();
			mv.visitLabel(l2);
			mv.visitMaxs(4, 4);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(
					ACC_PUBLIC,
					"get",
					"(Lcom/instantlogic/mini/MiniThing;)Lorg/instantlogic/fabric/value/ReadOnlyAttributeValue;",
					"(Lcom/instantlogic/mini/MiniThing;)Lorg/instantlogic/fabric/value/ReadOnlyAttributeValue<Lcom/instantlogic/mini/MiniThing;Ljava/lang/Float;>;",
					null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitVarInsn(ALOAD, 1);
			mv.visitMethodInsn(INVOKEVIRTUAL, "com/instantlogic/mini/MiniThing", "get"+upperFirst(attribute.name)+"AttributeValue",
					"()Lorg/instantlogic/fabric/value/AttributeValue;");
			mv.visitInsn(ARETURN);
			Label l1 = new Label();
			mv.visitLabel(l1);
			mv.visitMaxs(1, 2);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC, "get",
					"(Lorg/instantlogic/fabric/Instance;)Lorg/instantlogic/fabric/value/ReadOnlyAttributeValue;", null, null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitVarInsn(ALOAD, 1);
			mv.visitTypeInsn(CHECKCAST, "com/instantlogic/mini/MiniThing");
			mv.visitMethodInsn(INVOKEVIRTUAL, "com/instantlogic/mini/entity/MiniThingEntity$"+innerClassIndex, "get",
					"(Lcom/instantlogic/mini/MiniThing;)Lorg/instantlogic/fabric/value/ReadOnlyAttributeValue;");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(2, 2);
			mv.visitEnd();
		}
		cw.visitEnd();

		return cw.toByteArray();
	}

	public static byte[] dump(EntityClassModel model) {
		ClassWriter cw = new ClassWriter(0);
		FieldVisitor fv;
		MethodVisitor mv;

		cw.visit(V1_6, ACC_PUBLIC + ACC_SUPER, "com/instantlogic/mini/entity/MiniThingEntity",
				"Lorg/instantlogic/fabric/model/Entity<Lcom/instantlogic/mini/MiniThing;>;", "org/instantlogic/fabric/model/Entity", null);

		cw.visitSource("MiniThingEntity.java", null);

		cw.visitInnerClass("com/instantlogic/mini/entity/MiniThingEntity$1", null, null, 0);

		cw.visitInnerClass("com/instantlogic/mini/entity/MiniThingEntity$2", null, null, 0);

		{
			fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "INSTANCE", "Lcom/instantlogic/mini/entity/MiniThingEntity;", null, null);
			fv.visitEnd();
		}
		{
			fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "miniProperty", "Lorg/instantlogic/fabric/model/Attribute;",
					"Lorg/instantlogic/fabric/model/Attribute<Lcom/instantlogic/mini/MiniThing;Ljava/lang/Float;Ljava/lang/Float;>;", null);
			fv.visitEnd();
		}
		{
			fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "miniProperty2", "Lorg/instantlogic/fabric/model/Attribute;",
					"Lorg/instantlogic/fabric/model/Attribute<Lcom/instantlogic/mini/MiniThing;Ljava/lang/Float;Ljava/lang/Float;>;", null);
			fv.visitEnd();
		}
		{
			fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "ATTRIBUTES", "[Lorg/instantlogic/fabric/model/Attribute;", null, null);
			fv.visitEnd();
		}
		{
			fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "RELATIONS", "[Lorg/instantlogic/fabric/model/Relation;", null, null);
			fv.visitEnd();
		}
		{
			fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "REVERSE_RELATIONS", "[Lorg/instantlogic/fabric/model/Relation;", null, null);
			fv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitTypeInsn(NEW, "com/instantlogic/mini/entity/MiniThingEntity");
			mv.visitInsn(DUP);
			mv.visitMethodInsn(INVOKESPECIAL, "com/instantlogic/mini/entity/MiniThingEntity", "<init>", "()V");
			mv.visitFieldInsn(PUTSTATIC, "com/instantlogic/mini/entity/MiniThingEntity", "INSTANCE", "Lcom/instantlogic/mini/entity/MiniThingEntity;");
			Label l1 = new Label();
			mv.visitLabel(l1);
			mv.visitTypeInsn(NEW, "com/instantlogic/mini/entity/MiniThingEntity$1");
			mv.visitInsn(DUP);
			Label l2 = new Label();
			mv.visitLabel(l2);
			mv.visitLdcInsn("miniProperty");
			mv.visitFieldInsn(GETSTATIC, "com/instantlogic/mini/entity/MiniThingEntity", "INSTANCE", "Lcom/instantlogic/mini/entity/MiniThingEntity;");
			mv.visitLdcInsn(Type.getType("Ljava/lang/Float;"));
			Label l3 = new Label();
			mv.visitLabel(l3);
			mv.visitMethodInsn(INVOKESPECIAL, "com/instantlogic/mini/entity/MiniThingEntity$1", "<init>",
					"(Ljava/lang/String;Lorg/instantlogic/fabric/model/Entity;Ljava/lang/Class;)V");
			Label l4 = new Label();
			mv.visitLabel(l4);
			mv.visitFieldInsn(PUTSTATIC, "com/instantlogic/mini/entity/MiniThingEntity", "miniProperty", "Lorg/instantlogic/fabric/model/Attribute;");
			Label l5 = new Label();
			mv.visitLabel(l5);
			mv.visitTypeInsn(NEW, "com/instantlogic/mini/entity/MiniThingEntity$2");
			mv.visitInsn(DUP);
			Label l6 = new Label();
			mv.visitLabel(l6);
			mv.visitLdcInsn("miniProperty2");
			mv.visitFieldInsn(GETSTATIC, "com/instantlogic/mini/entity/MiniThingEntity", "INSTANCE", "Lcom/instantlogic/mini/entity/MiniThingEntity;");
			mv.visitLdcInsn(Type.getType("Ljava/lang/Float;"));
			Label l7 = new Label();
			mv.visitLabel(l7);
			mv.visitMethodInsn(INVOKESPECIAL, "com/instantlogic/mini/entity/MiniThingEntity$2", "<init>",
					"(Ljava/lang/String;Lorg/instantlogic/fabric/model/Entity;Ljava/lang/Class;)V");
			Label l8 = new Label();
			mv.visitLabel(l8);
			mv.visitFieldInsn(PUTSTATIC, "com/instantlogic/mini/entity/MiniThingEntity", "miniProperty2", "Lorg/instantlogic/fabric/model/Attribute;");
			Label l9 = new Label();
			mv.visitLabel(l9);
			mv.visitInsn(ICONST_2);
			mv.visitTypeInsn(ANEWARRAY, "org/instantlogic/fabric/model/Attribute");
			mv.visitInsn(DUP);
			mv.visitInsn(ICONST_0);
			Label l10 = new Label();
			mv.visitLabel(l10);
			mv.visitFieldInsn(GETSTATIC, "com/instantlogic/mini/entity/MiniThingEntity", "miniProperty", "Lorg/instantlogic/fabric/model/Attribute;");
			mv.visitInsn(AASTORE);
			mv.visitInsn(DUP);
			mv.visitInsn(ICONST_1);
			Label l11 = new Label();
			mv.visitLabel(l11);
			mv.visitFieldInsn(GETSTATIC, "com/instantlogic/mini/entity/MiniThingEntity", "miniProperty2", "Lorg/instantlogic/fabric/model/Attribute;");
			mv.visitInsn(AASTORE);
			Label l12 = new Label();
			mv.visitLabel(l12);
			mv.visitFieldInsn(PUTSTATIC, "com/instantlogic/mini/entity/MiniThingEntity", "ATTRIBUTES", "[Lorg/instantlogic/fabric/model/Attribute;");
			Label l13 = new Label();
			mv.visitLabel(l13);
			mv.visitInsn(ICONST_0);
			mv.visitTypeInsn(ANEWARRAY, "org/instantlogic/fabric/model/Relation");
			mv.visitFieldInsn(PUTSTATIC, "com/instantlogic/mini/entity/MiniThingEntity", "RELATIONS", "[Lorg/instantlogic/fabric/model/Relation;");
			Label l14 = new Label();
			mv.visitLabel(l14);
			mv.visitInsn(ICONST_0);
			mv.visitTypeInsn(ANEWARRAY, "org/instantlogic/fabric/model/Relation");
			mv.visitFieldInsn(PUTSTATIC, "com/instantlogic/mini/entity/MiniThingEntity", "REVERSE_RELATIONS", "[Lorg/instantlogic/fabric/model/Relation;");
			Label l15 = new Label();
			mv.visitLabel(l15);
			mv.visitInsn(RETURN);
			mv.visitMaxs(5, 0);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PROTECTED, "<init>", "()V", null, null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/fabric/model/Entity", "<init>", "()V");
			Label l1 = new Label();
			mv.visitLabel(l1);
			mv.visitInsn(RETURN);
			Label l2 = new Label();
			mv.visitLabel(l2);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "createInstance", "()Lcom/instantlogic/mini/MiniThing;", null, null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitTypeInsn(NEW, "com/instantlogic/mini/MiniThing");
			mv.visitInsn(DUP);
			mv.visitMethodInsn(INVOKESPECIAL, "com/instantlogic/mini/MiniThing", "<init>", "()V");
			mv.visitInsn(ARETURN);
			Label l1 = new Label();
			mv.visitLabel(l1);
			mv.visitMaxs(2, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getInstanceClass", "()Ljava/lang/Class;", "()Ljava/lang/Class<Lcom/instantlogic/mini/MiniThing;>;", null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitLdcInsn(Type.getType("Lcom/instantlogic/mini/MiniThing;"));
			mv.visitInsn(ARETURN);
			Label l1 = new Label();
			mv.visitLabel(l1);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getName", "()Ljava/lang/String;", null, null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitLdcInsn("MiniThing");
			mv.visitInsn(ARETURN);
			Label l1 = new Label();
			mv.visitLabel(l1);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getLocalAttributes", "()[Lorg/instantlogic/fabric/model/Attribute;", null, null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitFieldInsn(GETSTATIC, "com/instantlogic/mini/entity/MiniThingEntity", "ATTRIBUTES", "[Lorg/instantlogic/fabric/model/Attribute;");
			mv.visitInsn(ARETURN);
			Label l1 = new Label();
			mv.visitLabel(l1);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getLocalRelations", "()[Lorg/instantlogic/fabric/model/Relation;", null, null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitFieldInsn(GETSTATIC, "com/instantlogic/mini/entity/MiniThingEntity", "RELATIONS", "[Lorg/instantlogic/fabric/model/Relation;");
			mv.visitInsn(ARETURN);
			Label l1 = new Label();
			mv.visitLabel(l1);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getLocalReverseRelations", "()[Lorg/instantlogic/fabric/model/Relation;", null, null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitFieldInsn(GETSTATIC, "com/instantlogic/mini/entity/MiniThingEntity", "REVERSE_RELATIONS", "[Lorg/instantlogic/fabric/model/Relation;");
			mv.visitInsn(ARETURN);
			Label l1 = new Label();
			mv.visitLabel(l1);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC, "createInstance", "()Lorg/instantlogic/fabric/Instance;", null, null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKEVIRTUAL, "com/instantlogic/mini/entity/MiniThingEntity", "createInstance", "()Lcom/instantlogic/mini/MiniThing;");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		cw.visitEnd();
		return cw.toByteArray();
	}
}
