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
import org.objectweb.asm.MethodVisitor;

public class InstanceBytecodeTemplate extends AbstractBytecodeTemplate {

	public static void generate(Map<String, byte[]> bytecodeClasses, EntityClassModel model) {
		bytecodeClasses.put(model.rootPackageName+"."+model.name, dump(model));	
	}

	public static byte[] dump(EntityClassModel model) {

		ClassWriter cw = new ClassWriter(0);
		FieldVisitor fv;
		MethodVisitor mv;

		String className = model.getRootPackageInternalPrefix()+model.name;
		String entityClassName = model.getRootPackageInternalPrefix()+"entity/"+model.name+"Entity";

		
		// public class ... extends org.instantlogic.fabric.Instance
		cw.visit(V1_7, ACC_PUBLIC + ACC_SUPER, model.getRootPackageInternalPrefix()+model.name, null, "org/instantlogic/fabric/Instance", null);
		// private static final java.util.Map<String, User> _staticInstances = new java.util.LinkedHashMap<String, ...>();
		{
			fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "_staticInstances", "Ljava/util/Map;", null /* "Ljava/util/Map<Ljava/lang/String;Lorg/instantlogic/example/izzy/User;>;" */, null);
			fv.visitEnd();
		}
		

		{
			for (EntityClassModel.Attribute a : model.attributes) {
				// private final org.instantlogic.fabric.value.AttributeValue<..., java.lang.String> ...
				fv = cw.visitField(
						ACC_PRIVATE + ACC_FINAL, 
						a.name, 
						"Lorg/instantlogic/fabric/value/"+(a.readonly?"ReadOnly":"")+"AttributeValue"+(a.isMultivalue()?"s":"")+";",
						null,//"Lorg/instantlogic/fabric/value/AttributeValue<Lorg/instantlogic/example/izzy/User;Ljava/lang/String;>;", 
						null);
				fv.visitEnd();
			}
		}
		{
			for (EntityClassModel.Attribute a : model.relations) {
				// private final org.instantlogic.fabric.value.RelationValues<..., ...> ...
				fv = cw.visitField(
						ACC_PRIVATE + ACC_FINAL, 
						a.name, 
						"Lorg/instantlogic/fabric/value/"+(a.readonly?"ReadOnly":"")+"RelationValue"+(a.isMultivalue()?"s":"")+";",
						null,//"Lorg/instantlogic/fabric/value/AttributeValue<Lorg/instantlogic/example/izzy/User;Ljava/lang/String;>;", 
						null);
				fv.visitEnd();
			}
		}
		{
			for (EntityClassModel.Attribute a : model.reverseRelations) {
				// private final org.instantlogic.fabric.value.RelationValues<..., ...> ...
				fv = cw.visitField(
						ACC_PRIVATE + ACC_FINAL, 
						a.name, 
						"Lorg/instantlogic/fabric/value/RelationValue"+(a.isMultivalue()?"s":"")+";",
						null,//"Lorg/instantlogic/fabric/value/AttributeValue<Lorg/instantlogic/example/izzy/User;Ljava/lang/String;>;", 
						null);
				fv.visitEnd();
			}
		}

		// _staticInstances = new java.util.LinkedHashMap<String, User>();
		{
			mv = cw.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
			mv.visitCode();
			mv.visitTypeInsn(NEW, "java/util/LinkedHashMap");
			mv.visitInsn(DUP);
			mv.visitMethodInsn(INVOKESPECIAL, "java/util/LinkedHashMap", "<init>", "()V");
			mv.visitFieldInsn(PUTSTATIC, className, "_staticInstances", "Ljava/util/Map;");
			mv.visitInsn(RETURN);
			mv.visitMaxs(2, 0);
			mv.visitEnd();
		}
		
		{
			mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/fabric/Instance", "<init>", "()V");
			for (EntityClassModel.Attribute a : model.attributes) {
				// username = createAttributeValue(org.instantlogic.example.izzy.entity.UserEntity.username);
				mv.visitVarInsn(ALOAD, 0);
				mv.visitVarInsn(ALOAD, 0);
				mv.visitFieldInsn(GETSTATIC, model.getInternalEntityName(), a.javaIdentifier, "Lorg/instantlogic/fabric/model/Attribute;");
				mv.visitMethodInsn(INVOKEVIRTUAL, model.getInternalName(), "create"+(a.readonly?"ReadOnly":"")+"AttributeValue"+(a.multivalue?"s":""), "(Lorg/instantlogic/fabric/model/Attribute;)Lorg/instantlogic/fabric/value/AttributeValue;");
				mv.visitFieldInsn(PUTFIELD, model.getInternalName(), a.javaIdentifier, "Lorg/instantlogic/fabric/value/AttributeValue;");
			}
			// TODO: relations
			// TODO: reverse relations
			mv.visitInsn(RETURN);
			mv.visitMaxs(3, 1);
			mv.visitEnd();
		}
		
		//private static User addStaticInstance(String name, User instance) {
		//	_staticInstances.put(name, instance);
		//	instance.getMetadata().makeStatic(name);
		//	return instance;
		//}
		{
			mv = cw.visitMethod(ACC_PRIVATE + ACC_STATIC, "addStaticInstance", "(Ljava/lang/String;L"+className+";)L"+className+";", null, null);
			mv.visitCode();
			mv.visitFieldInsn(GETSTATIC, className, "_staticInstances", "Ljava/util/Map;");
			mv.visitVarInsn(ALOAD, 0);
			mv.visitVarInsn(ALOAD, 1);
			mv.visitMethodInsn(INVOKEINTERFACE, "java/util/Map", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
			mv.visitInsn(POP);
			mv.visitVarInsn(ALOAD, 1);
			mv.visitMethodInsn(INVOKEVIRTUAL, className, "getMetadata", "()Lorg/instantlogic/fabric/util/InstanceMetadata;");
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKEVIRTUAL, "org/instantlogic/fabric/util/InstanceMetadata", "makeStatic", "(Ljava/lang/String;)V");
			mv.visitVarInsn(ALOAD, 1);
			mv.visitInsn(ARETURN);
			mv.visitMaxs(3, 2);
			mv.visitEnd();
		}

		//@Override
		//protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		//	return org.instantlogic.example.izzy.entity.UserEntity.INSTANCE;
		//}
		{
			mv = cw.visitMethod(ACC_PROTECTED, "getInstanceEntity", "()Lorg/instantlogic/fabric/model/Entity;", null, null);
			mv.visitCode();
			mv.visitFieldInsn(GETSTATIC, entityClassName, "INSTANCE", "L"+entityClassName+";");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		
		for (EntityClassModel.Attribute a : model.attributes) {
			//public java.lang.String getUsername() {
			//	return username.getValue();
			//}
			{
				mv = cw.visitMethod(ACC_PUBLIC, "get"+a.technicalNameCapitalized, "()L"+a.internalClassName+";", null, null);
				mv.visitCode();
				mv.visitVarInsn(ALOAD, 0);
				mv.visitFieldInsn(GETFIELD, className, a.javaIdentifier, "Lorg/instantlogic/fabric/value/AttributeValue;");
				mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/AttributeValue", "getValue", "()Ljava/lang/Object;");
				mv.visitTypeInsn(CHECKCAST, a.internalClassName);
				mv.visitInsn(ARETURN);
				mv.visitMaxs(1, 1);
				mv.visitEnd();
			}
			//public org.instantlogic.fabric.value.AttributeValue<User, java.lang.String> getUsernameAttributeValue() {
			//	return username;
			//}
			{
				mv = cw.visitMethod(ACC_PUBLIC, "get"+a.technicalNameCapitalized+"AttributeValue", "()Lorg/instantlogic/fabric/value/AttributeValue;", null /* "()Lorg/instantlogic/fabric/value/AttributeValue<Lorg/instantlogic/example/izzy/User;Ljava/lang/String;>;"*/, null);
				mv.visitCode();
				mv.visitVarInsn(ALOAD, 0);
				mv.visitFieldInsn(GETFIELD, className, a.javaIdentifier, "Lorg/instantlogic/fabric/value/AttributeValue;");
				mv.visitInsn(ARETURN);
				mv.visitMaxs(1, 1);
				mv.visitEnd();
			}
			if (!a.readonly  && !a.multivalue) {
				{
					//public User setUsername(java.lang.String newValue) {
					//	username.setValue(newValue);
					//	return (User)this;
					//}
					mv = cw.visitMethod(ACC_PUBLIC, "set"+a.technicalNameCapitalized, "(L"+a.internalClassName+";)L"+className+";", null, null);
					mv.visitCode();
					mv.visitVarInsn(ALOAD, 0);
					mv.visitFieldInsn(GETFIELD, className, a.javaIdentifier, "Lorg/instantlogic/fabric/value/AttributeValue;");
					mv.visitVarInsn(ALOAD, 1);
					mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/AttributeValue", "setValue", "(Ljava/lang/Object;)V");
					mv.visitVarInsn(ALOAD, 0);
					mv.visitInsn(ARETURN);
					mv.visitMaxs(2, 2);
					mv.visitEnd();
				}
			} else if (!a.readonly) {
				// TODO: addTo methods
			}
		}
		
		// TODO: relations
		// TODO: reverse relations
		
		cw.visitEnd();

		return cw.toByteArray();
	}
}
