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
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public class EntityBytecodeTemplate extends AbstractBytecodeTemplate {

	public static void generate(Map<String, byte[]> bytecodeClasses, String fullName, EntityClassModel model) {
		bytecodeClasses.put(fullName, dump(model));
		for (int i = 0; i < model.attributes.size(); i++) {
			bytecodeClasses.put(fullName + "$" + (i + 1), dumpAttributeInnerClass(model, i+1, model.attributes.get(i)));
		}
		// TODO: relations and reverse relations
	}

	public static byte[] dump(EntityClassModel model) {
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		FieldVisitor fv;
		MethodVisitor mv;

		String className = model.getRootPackageInternalPrefix()+"entity/"+model.name+"Entity";
		String instanceClassName = model.getRootPackageInternalPrefix()+model.name;

		cw.visit(V1_7, ACC_PUBLIC + ACC_SUPER, className,
				"Lorg/instantlogic/fabric/model/Entity<L"+instanceClassName+";>;", "org/instantlogic/fabric/model/Entity", null);

		for (int i = 0; i < model.attributes.size(); i++) { // TODO: + relations.size()
			cw.visitInnerClass("com/instantlogic/mini/entity/MiniThingEntity$"+(i+1), null, null, 0);
		}

		// public static final UserEntity INSTANCE 
		{
			fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "INSTANCE", "L"+className+";", null, null);
			fv.visitEnd();
		}
		// private org.instantlogic.fabric.text.TextTemplate title;
		{
			fv = cw.visitField(ACC_PRIVATE, "title", "Lorg/instantlogic/fabric/text/TextTemplate;", null, null);
			fv.visitEnd();
		}
		for(Attribute a:model.attributes) {
			{
				// public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.example.izzy.User, java.lang.String, java.lang.String> username
				fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, a.javaIdentifier, "Lorg/instantlogic/fabric/model/Attribute;", "Lorg/instantlogic/fabric/model/Attribute<L"+instanceClassName+";L"+a.internalClassName+";L"+a.internalItemClassName+";>;", null);
				fv.visitEnd();
			}
		}
		// TODO: relations and reverserelations
		
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
			fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "VALIDATIONS", "[Lorg/instantlogic/fabric/model/Validation;", null, null);
			fv.visitEnd();
		}		
		{
			mv = cw.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
			mv.visitCode();
			mv.visitTypeInsn(NEW, className);
			mv.visitInsn(DUP);
			mv.visitMethodInsn(INVOKESPECIAL, className, "<init>", "()V");
			mv.visitFieldInsn(PUTSTATIC, className, "INSTANCE", "L"+className+";");

			int innerClassIndex=1;
			for(Attribute a:model.attributes) {
				mv.visitTypeInsn(NEW, className+"$"+innerClassIndex);
				mv.visitInsn(DUP);
				mv.visitLdcInsn(a.javaIdentifier);
				mv.visitFieldInsn(GETSTATIC, className, "INSTANCE", "L"+className+";");
				mv.visitLdcInsn(Type.getType("L"+a.internalClassName+";"));
				mv.visitMethodInsn(INVOKESPECIAL, className+"$"+innerClassIndex, "<init>", "(Ljava/lang/String;Lorg/instantlogic/fabric/model/Entity;Ljava/lang/Class;)V");
				mv.visitFieldInsn(PUTSTATIC, className, a.javaIdentifier, "Lorg/instantlogic/fabric/model/Attribute;");
				innerClassIndex++;
			}

			// private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{ ...
			mv.visitIntInsn(BIPUSH, model.attributes.size());
			mv.visitTypeInsn(ANEWARRAY, "org/instantlogic/fabric/model/Attribute");
			int i=0;
			for(Attribute a:model.attributes) {
				mv.visitInsn(DUP);
				mv.visitIntInsn(BIPUSH, i);
				mv.visitFieldInsn(GETSTATIC, className, a.javaIdentifier, "Lorg/instantlogic/fabric/model/Attribute;");
				mv.visitInsn(AASTORE);
				i++;
			}
			mv.visitFieldInsn(PUTSTATIC, className, "ATTRIBUTES", "[Lorg/instantlogic/fabric/model/Attribute;");
			
			mv.visitInsn(ICONST_0);
			mv.visitTypeInsn(ANEWARRAY, "org/instantlogic/fabric/model/Relation");
			mv.visitFieldInsn(PUTSTATIC, className, "RELATIONS", "[Lorg/instantlogic/fabric/model/Relation;");
			
			mv.visitInsn(ICONST_0);
			mv.visitTypeInsn(ANEWARRAY, "org/instantlogic/fabric/model/Relation");
			mv.visitFieldInsn(PUTSTATIC, className, "REVERSE_RELATIONS", "[Lorg/instantlogic/fabric/model/Relation;");

			mv.visitInsn(ICONST_0);
			mv.visitTypeInsn(ANEWARRAY, "org/instantlogic/fabric/model/Validation");
			mv.visitFieldInsn(PUTSTATIC, className, "VALIDATIONS", "[Lorg/instantlogic/fabric/model/Validation;");
			mv.visitInsn(RETURN);
			mv.visitMaxs(7, 0);
			mv.visitEnd();
		}
		// Default synthetic constructor
		{
			mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/fabric/model/Entity", "<init>", "()V");
			mv.visitInsn(RETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		//@Override
		//public org.instantlogic.example.izzy.User createInstance() {
		//	return new org.instantlogic.example.izzy.User();
		//}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "createInstance", "()L"+instanceClassName+";", null, null);
			mv.visitCode();
			mv.visitTypeInsn(NEW, instanceClassName);
			mv.visitInsn(DUP);
			mv.visitMethodInsn(INVOKESPECIAL, instanceClassName, "<init>", "()V");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(2, 1);
			mv.visitEnd();
		}
		//@Override
		//public Class<org.instantlogic.example.izzy.User> getInstanceClass() {
		//	return org.instantlogic.example.izzy.User.class;
		//}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getInstanceClass", "()Ljava/lang/Class;", "()Ljava/lang/Class<L"+instanceClassName+";>;", null);
			mv.visitCode();
			mv.visitLdcInsn(Type.getType("L"+instanceClassName+";"));
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		//@Override
		//public String getName() {
		//	return "user";
		//}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getName", "()Ljava/lang/String;", null, null);
			mv.visitCode();
			mv.visitLdcInsn(model.name);
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getLocalAttributes", "()[Lorg/instantlogic/fabric/model/Attribute;", null, null);
			mv.visitCode();
			mv.visitFieldInsn(GETSTATIC, className, "ATTRIBUTES", "[Lorg/instantlogic/fabric/model/Attribute;");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getLocalRelations", "()[Lorg/instantlogic/fabric/model/Relation;", null, null);
			mv.visitCode();
			mv.visitFieldInsn(GETSTATIC, className, "RELATIONS", "[Lorg/instantlogic/fabric/model/Relation;");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getLocalReverseRelations", "()[Lorg/instantlogic/fabric/model/Relation;", null, null);
			mv.visitCode();
			mv.visitFieldInsn(GETSTATIC, className, "REVERSE_RELATIONS", "[Lorg/instantlogic/fabric/model/Relation;");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getLocalValidations", "()[Lorg/instantlogic/fabric/model/Validation;", null, null);
			mv.visitCode();
			mv.visitFieldInsn(GETSTATIC, className, "VALIDATIONS", "[Lorg/instantlogic/fabric/model/Validation;");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getStaticInstances", "()Ljava/util/Map;", "()Ljava/util/Map<Ljava/lang/String;L"+instanceClassName+";>;", null);
			mv.visitCode();
			mv.visitMethodInsn(INVOKESTATIC, instanceClassName, "getStatic"+model.technicalNameCapitalized+"Instances", "()Ljava/util/Map;");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC, "createInstance", "()Lorg/instantlogic/fabric/Instance;", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKEVIRTUAL, className, "createInstance", "()L"+instanceClassName+";");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		
		// TODO: getTitle
		cw.visitEnd();
		return cw.toByteArray();
	}
	
	private static byte[] dumpAttributeInnerClass(EntityClassModel model, int innerClassIndex, Attribute attribute) {
		ClassWriter cw = new ClassWriter(0);
		MethodVisitor mv;
		
		String className = model.getRootPackageInternalPrefix()+"entity/"+model.name+"Entity$"+innerClassIndex;

		cw.visit(V1_7, ACC_SUPER, className,
				"Lorg/instantlogic/fabric/model/impl/SimpleAttribute<L"+model.getRootPackageInternalPrefix()+model.name+";L"+attribute.internalClassName+";>;",
				"org/instantlogic/fabric/model/impl/SimpleAttribute", null);

		cw.visitOuterClass(model.getRootPackageInternalPrefix()+model.name+"Entity", null, null);

		cw.visitInnerClass(model.getRootPackageInternalPrefix()+model.name+"Entity$"+innerClassIndex, null, null, 0);

		//username = new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.example.izzy.User, java.lang.String, java.lang.String>("username", INSTANCE, java.lang.String.class
		{
			mv = cw.visitMethod(0, "<init>", "(Ljava/lang/String;Lorg/instantlogic/fabric/model/Entity;Ljava/lang/Class;)V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitVarInsn(ALOAD, 1);
			mv.visitVarInsn(ALOAD, 2);
			mv.visitVarInsn(ALOAD, 3);
			mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/fabric/model/impl/SimpleAttribute", "<init>",
					"(Ljava/lang/String;Lorg/instantlogic/fabric/model/Entity;Ljava/lang/Class;)V");
			mv.visitVarInsn(ALOAD, 0);
			// dataType.put("category", "text");
			for (Map.Entry<String,Object> dataTypeEntry : attribute.dataType.entrySet()) {
				mv.visitFieldInsn(GETFIELD, className, "dataType", "Ljava/util/Map;");
				mv.visitLdcInsn(dataTypeEntry.getKey());
				mv.visitLdcInsn(dataTypeEntry.getValue()); // Works at least for strings...
				mv.visitMethodInsn(INVOKEINTERFACE, "java/util/Map", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
				mv.visitInsn(POP);
			}
			mv.visitInsn(RETURN);
			mv.visitMaxs(4, 4);
			mv.visitEnd();
		}
		//@Override
		//public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.example.izzy.User, java.lang.String> get(org.instantlogic.example.izzy.User instance) {
		//	return instance.getUsernameAttributeValue();
		//}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "get", "(L"+model.getRootPackageInternalPrefix()+model.name+";)Lorg/instantlogic/fabric/value/ReadOnlyAttributeValue;", "(L"+model.getRootPackageInternalPrefix()+model.name+";)Lorg/instantlogic/fabric/value/ReadOnlyAttributeValue<L"+model.getRootPackageInternalPrefix()+model.name+";L"+attribute.internalClassName+";>;", null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 1);
			mv.visitMethodInsn(INVOKEVIRTUAL, model.getRootPackageInternalPrefix()+model.name, "get"+attribute.technicalNameCapitalized+"AttributeValue", "()Lorg/instantlogic/fabric/value/AttributeValue;");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 2);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC, "get", "(Lorg/instantlogic/fabric/Instance;)Lorg/instantlogic/fabric/value/ReadOnlyAttributeValue;", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitVarInsn(ALOAD, 1);
			mv.visitTypeInsn(CHECKCAST, model.getRootPackageInternalPrefix()+model.name);
			mv.visitMethodInsn(INVOKEVIRTUAL, className, "get", "(L"+model.getRootPackageInternalPrefix()+model.name+";)Lorg/instantlogic/fabric/value/ReadOnlyAttributeValue;");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(2, 2);
			mv.visitEnd();
		}
		cw.visitEnd();

		return cw.toByteArray();
	}	
}
