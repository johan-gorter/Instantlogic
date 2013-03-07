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
import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel.StaticInstance;
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

		String className = model.getRootPackageInternalPrefix()+(model.isCustomized?"Abstract":"")+model.technicalNameCapitalized;
		String concreteClassName = model.getRootPackageInternalPrefix()+model.technicalNameCapitalized;
		String entityClassName = model.getRootPackageInternalPrefix()+"entity/"+model.technicalNameCapitalized+"Entity";

		
		// public class ... extends org.instantlogic.fabric.Instance
		cw.visit(V1_7, ACC_PUBLIC + ACC_SUPER + (model.isCustomized?ACC_ABSTRACT:0), 
				className, null, model.extendsFrom==null?"org/instantlogic/fabric/Instance":model.extendsFrom.replace('.', '/'), null);
		// private static final java.util.Map<String, User> _staticInstances = new java.util.LinkedHashMap<String, ...>();
		{
			fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "_staticInstances", "Ljava/util/Map;", null /* "Ljava/util/Map<Ljava/lang/String;Lorg/instantlogic/example/izzy/User;>;" */, null);
			fv.visitEnd();
		}

		for(StaticInstance staticInstance : model.getStaticInstances()) {
			// public static final DataTypeDesign _boolean;
			{
				fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, staticInstance.javaIdentifier, "L"+concreteClassName+";", null, null);
				fv.visitEnd();
			}
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
			
			for (EntityClassModel.StaticInstance staticInstance : model.staticInstances)
			{
				//   _boolean = addStaticInstance("boolean", new DataTypeDesign());
				//   _boolean.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Boolean")));
				mv.visitLdcInsn(staticInstance.name);
				mv.visitTypeInsn(NEW, concreteClassName);
				mv.visitInsn(DUP);
				mv.visitMethodInsn(INVOKESPECIAL, concreteClassName, "<init>", "()V");
				mv.visitMethodInsn(INVOKESTATIC, className, "addStaticInstance", "(Ljava/lang/String;L"+concreteClassName+";)L"+concreteClassName+";");
				mv.visitFieldInsn(PUTSTATIC, className, staticInstance.javaIdentifier, "L"+concreteClassName+";");
				mv.visitFieldInsn(GETSTATIC, className, "_boolean", "L"+concreteClassName+";");
				mv.visitMethodInsn(INVOKEVIRTUAL, "org/instantlogic/designer/DataTypeDesign", "getMetadata", "()Lorg/instantlogic/fabric/util/InstanceMetadata;");
				mv.visitTypeInsn(NEW, "org/instantlogic/fabric/text/TextTemplate");
				mv.visitInsn(DUP);
				mv.visitInsn(ICONST_1);
				mv.visitTypeInsn(ANEWARRAY, "org/instantlogic/fabric/text/StringTemplate");
				mv.visitInsn(DUP);
				mv.visitInsn(ICONST_0);
				mv.visitTypeInsn(NEW, "org/instantlogic/fabric/text/StringTemplate");
				mv.visitInsn(DUP);
				mv.visitLdcInsn("TODO"); // TODO: text macro
				mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/fabric/text/StringTemplate", "<init>", "(Ljava/lang/String;)V");
				mv.visitInsn(AASTORE);
				mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/fabric/text/TextTemplate", "<init>", "([Lorg/instantlogic/fabric/text/StringTemplate;)V");
				mv.visitMethodInsn(INVOKEVIRTUAL, "org/instantlogic/fabric/util/InstanceMetadata", "setStaticDescription", "(Lorg/instantlogic/fabric/text/TextTemplate;)V");
				mv.visitInsn(RETURN);				
			}
			
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
				mv.visitMethodInsn(INVOKEVIRTUAL, model.getInternalName(), "create"+(a.readonly?"ReadOnly":"")+"AttributeValue"+(a.multivalue?"s":""), "(Lorg/instantlogic/fabric/model/Attribute;)Lorg/instantlogic/fabric/value/"+(a.readonly?"ReadOnly":"")+"AttributeValue"+(a.multivalue?"s":"")+";");
				mv.visitFieldInsn(PUTFIELD, model.getInternalName(), a.javaIdentifier, "Lorg/instantlogic/fabric/value/"+(a.readonly?"ReadOnly":"")+"AttributeValue"+(a.multivalue?"s":"")+";");
			}
			for (EntityClassModel.Relation r : model.relations) {
				mv.visitFieldInsn(GETSTATIC, model.getInternalEntityName(), r.javaIdentifier, "Lorg/instantlogic/fabric/model/Relation;");
				mv.visitMethodInsn(INVOKEVIRTUAL, model.getInternalName(), "create"+(r.readonly?"ReadOnly":"")+"RelationValue"+(r.multivalue?"s":""), "(Lorg/instantlogic/fabric/model/Relation;)Lorg/instantlogic/fabric/value/"+(r.readonly?"ReadOnly":"")+"RelationValue"+(r.multivalue?"s":"")+";");
				mv.visitFieldInsn(PUTFIELD, model.getInternalName(), r.javaIdentifier, "Lorg/instantlogic/fabric/value/"+(r.readonly?"ReadOnly":"")+"RelationValue"+(r.multivalue?"s":"")+";");
			}
			for (EntityClassModel.Relation r : model.reverseRelations) {
				mv.visitFieldInsn(GETSTATIC, model.getInternalEntityName(), r.javaIdentifier, "Lorg/instantlogic/fabric/model/Relation;");
				mv.visitMethodInsn(INVOKEVIRTUAL, model.getInternalName(), "createReverseRelationValue"+(r.multivalue?"s":""), "(Lorg/instantlogic/fabric/model/Relation;)Lorg/instantlogic/fabric/value/RelationValue"+(r.multivalue?"s":"")+";");
				mv.visitFieldInsn(PUTFIELD, model.getInternalName(), r.javaIdentifier, "Lorg/instantlogic/fabric/value/RelationValue"+(r.multivalue?"s":"")+";");
			}
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
				mv = cw.visitMethod(ACC_PUBLIC, "get"+a.technicalNameCapitalized+"AttributeValue", "()Lorg/instantlogic/fabric/value/"+(a.readonly?"ReadOnly":"")+"AttributeValue"+(a.multivalue?"s":"")+";", null /* "()Lorg/instantlogic/fabric/value/AttributeValue<Lorg/instantlogic/example/izzy/User;Ljava/lang/String;>;"*/, null);
				mv.visitCode();
				mv.visitVarInsn(ALOAD, 0);
				mv.visitFieldInsn(GETFIELD, className, a.javaIdentifier, "Lorg/instantlogic/fabric/value/"+(a.readonly?"ReadOnly":"")+"AttributeValue"+(a.multivalue?"s":"")+";");
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
			} 
			if (!a.readonly && !a.multivalue) {
				//public ApplicationDesign addToThemeNames(java.lang.String item) {
				//	themeNames.addValue(item);
				//	return (ApplicationDesign)this;
				//}
				{
					mv = cw.visitMethod(ACC_PUBLIC, "addTo"+a.technicalNameCapitalized, "(L"+a.internalItemClassName+";)L"+className+";", null, null);
					mv.visitCode();
					mv.visitVarInsn(ALOAD, 0);
					mv.visitFieldInsn(GETFIELD, className, a.javaIdentifier, "Lorg/instantlogic/fabric/value/AttributeValues;");
					mv.visitVarInsn(ALOAD, 1);
					mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/AttributeValues", "addValue", "(Ljava/lang/Object;)V");
					mv.visitVarInsn(ALOAD, 0);
					mv.visitTypeInsn(CHECKCAST, className);
					mv.visitInsn(ARETURN);
					mv.visitMaxs(2, 2);
					mv.visitEnd();
				}
				//public ApplicationDesign addToThemeNames(java.lang.String item, int index) {
				//	themeNames.insertValue(item, index);
				//	return (ApplicationDesign)this;
				//}
				{
					mv = cw.visitMethod(ACC_PUBLIC, "addTo"+a.technicalNameCapitalized, "(L"+a.internalItemClassName+";I)L"+className+";", null, null);
					mv.visitCode();
					mv.visitVarInsn(ALOAD, 0);
					mv.visitFieldInsn(GETFIELD, className, a.javaIdentifier, "Lorg/instantlogic/fabric/value/AttributeValues;");
					mv.visitVarInsn(ALOAD, 1);
					mv.visitVarInsn(ILOAD, 2);
					mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/AttributeValues", "insertValue", "(Ljava/lang/Object;I)V");
					mv.visitVarInsn(ALOAD, 0);
					mv.visitTypeInsn(CHECKCAST, className);
					mv.visitInsn(ARETURN);
					mv.visitMaxs(3, 3);
					mv.visitEnd();
				}
				//public ApplicationDesign removeFromThemeNames(java.lang.String item) {
				//	themeNames.removeValue(item);
				//	return (ApplicationDesign)this;
				//}
				{
					mv = cw.visitMethod(ACC_PUBLIC, "removeFrom"+a.technicalNameCapitalized, "(L"+a.internalItemClassName+";)L"+className+";", null, null);
					mv.visitCode();
					mv.visitVarInsn(ALOAD, 0);
					mv.visitFieldInsn(GETFIELD, className, a.javaIdentifier, "Lorg/instantlogic/fabric/value/AttributeValues;");
					mv.visitVarInsn(ALOAD, 1);
					mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/AttributeValues", "removeValue", "(Ljava/lang/Object;)V");
					mv.visitVarInsn(ALOAD, 0);
					mv.visitTypeInsn(CHECKCAST, className);
					mv.visitInsn(ARETURN);
					mv.visitMaxs(2, 2);
					mv.visitEnd();
				}
				//public ApplicationDesign removeFromThemeNames(int index) {
				//	themeNames.removeValue(index);
				//	return (ApplicationDesign)this;
				//}
				{
					mv = cw.visitMethod(ACC_PUBLIC, "removeFrom"+a.technicalNameCapitalized, "(I)L"+a.internalItemClassName+";", null, null);
					mv.visitCode();
					mv.visitVarInsn(ALOAD, 0);
					mv.visitFieldInsn(GETFIELD, className, a.javaIdentifier, "Lorg/instantlogic/fabric/value/AttributeValues;");
					mv.visitVarInsn(ILOAD, 1);
					mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/AttributeValues", "removeValue", "(I)Ljava/lang/Object;");
					mv.visitInsn(POP);
					mv.visitVarInsn(ALOAD, 0);
					mv.visitTypeInsn(CHECKCAST, className);
					mv.visitInsn(ARETURN);
					mv.visitMaxs(2, 2);
					mv.visitEnd();
				}
			}
		}
		
		for (EntityClassModel.Relation r : model.relations) {
			//public org.instantlogic.fabric.value.RelationValue<ApplicationDesign, EntityDesign> getCaseEntityRelationValue() {
			//	return caseEntity;
			//}
			{
				mv = cw.visitMethod(ACC_PUBLIC, "get"+r.technicalNameCapitalized+"RelationValue", "()Lorg/instantlogic/fabric/value/"+(r.readonly?"ReadOnly":"")+"RelationValue"+(r.multivalue?"s":"")+";", null /* "()Lorg/instantlogic/fabric/value/RelationValue<Lorg/instantlogic/designer/ApplicationDesign;Lorg/instantlogic/designer/EntityDesign;>;"*/, null);
				mv.visitCode();
				mv.visitVarInsn(ALOAD, 0);
				mv.visitFieldInsn(GETFIELD, className, r.javaIdentifier, "Lorg/instantlogic/fabric/value/"+(r.readonly?"ReadOnly":"")+"RelationValue"+(r.multivalue?"s":"")+";");
				mv.visitInsn(ARETURN);
				mv.visitMaxs(1, 1);
				mv.visitEnd();
			}
			//public org.instantlogic.designer.EntityDesign getCaseEntity() {
			//	return caseEntity.getValue();
			//}
			{
				mv = cw.visitMethod(ACC_PUBLIC, "get"+r.technicalNameCapitalized, "()L"+r.internalTo+";", null, null);
				mv.visitCode();
				mv.visitVarInsn(ALOAD, 0);
				mv.visitFieldInsn(GETFIELD, className, r.javaIdentifier, "Lorg/instantlogic/fabric/value/"+(r.readonly?"ReadOnly":"")+"RelationValue"+(r.multivalue?"s":"")+";");
				mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/"+(r.readonly?"ReadOnly":"")+"RelationValue"+(r.multivalue?"s":""), "getValue", "()Ljava/lang/Object;");
				mv.visitTypeInsn(CHECKCAST, r.internalTo);
				mv.visitInsn(ARETURN);
				mv.visitMaxs(1, 1);
				mv.visitEnd();
				}
			
			// TODO: relations
		}
		for (EntityClassModel.Relation r : model.reverseRelations) {
			// TODO: reverse relations
		}
		
		cw.visitEnd();

		return cw.toByteArray();
	}
}
