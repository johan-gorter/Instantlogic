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

import java.io.PrintWriter;
import java.util.Map;

import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel;
import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel.Attribute;
import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel.Relation;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.TraceClassVisitor;

public class EntityBytecodeTemplate extends AbstractBytecodeTemplate {
	
	public static final boolean TRACE = true;

	public static void generate(Map<String, byte[]> bytecodeClasses, EntityClassModel model, String fullName) {
		bytecodeClasses.put(fullName, dump(model));
		int innerClassIndex=1;
		for (int i = 0; i < model.attributes.size(); i++) {
			bytecodeClasses.put(fullName + "$" + innerClassIndex, dumpAttributeInnerClass(model, innerClassIndex, model.attributes.get(i)));
			innerClassIndex++;
		}
		for (int i = 0; i < model.relations.size(); i++) {
			bytecodeClasses.put(fullName + "$" + innerClassIndex, dumpRelationInnerClass(model, innerClassIndex, model.relations.get(i)));
			innerClassIndex++;
		}
		for (int i = 0; i < model.reverseRelations.size(); i++) {
			bytecodeClasses.put(fullName + "$" + innerClassIndex, dumpReverseRelationInnerClass(model, innerClassIndex, model.reverseRelations.get(i)));
			innerClassIndex++;
		}
	}

	public static byte[] dump(EntityClassModel model) {
		ClassWriter cwriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);

		ClassVisitor cw;
		if (TRACE) {
			cw = new TraceClassVisitor(cwriter, new ASMifier(), new PrintWriter(System.out));
		} else {
			cw=cwriter;
		}
		
		FieldVisitor fv;
		MethodVisitor mv;

		String className = model.getRootPackageInternalPrefix()+"entity/"+model.technicalNameCapitalized+"Entity";
		String instanceClassName = model.getRootPackageInternalPrefix()+model.technicalNameCapitalized;

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
		for(Relation r: model.relations) {
			// public static final org.instantlogic.fabric.model.Relation<org.instantlogic.engine.presence.Presence, org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.Place>, org.instantlogic.engine.presence.Place> activePlaces
			{
				fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, r.javaIdentifier, "Lorg/instantlogic/fabric/model/Relation;", "Lorg/instantlogic/fabric/model/Relation<L"+instanceClassName+";L"+r.internalTo+";L"+r.internalItemClassName+";>;", null);
				fv.visitEnd();
			}
		}
		for(Relation r:model.reverseRelations) {
			{
				fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, r.javaIdentifier, "Lorg/instantlogic/fabric/model/Relation;", "Lorg/instantlogic/fabric/model/Relation<L"+instanceClassName+";L"+r.internalTo+";L"+r.internalItemClassName+";>;", null);
				fv.visitEnd();
			}			
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
				// public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.engine.presence.User, java.lang.String, java.lang.String> username
				//   = new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.engine.presence.User, java.lang.String, java.lang.String>
				mv.visitTypeInsn(NEW, className+"$"+innerClassIndex);
				mv.visitInsn(DUP);
				mv.visitLdcInsn(a.javaIdentifier);
				mv.visitFieldInsn(GETSTATIC, className, "INSTANCE", "L"+className+";");
				mv.visitLdcInsn(Type.getType("L"+a.internalClassName+";"));
				mv.visitMethodInsn(INVOKESPECIAL, className+"$"+innerClassIndex, "<init>", "(Ljava/lang/String;Lorg/instantlogic/fabric/model/Entity;Ljava/lang/Class;)V");
				mv.visitFieldInsn(PUTSTATIC, className, a.javaIdentifier, "Lorg/instantlogic/fabric/model/Attribute;");
				innerClassIndex++;
			}
			for (Relation r:model.relations) {
				//public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.Project, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue>, org.instantlogic.example.izzy.Issue> issues
				//= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.Project, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue>, org.instantlogic.example.izzy.Issue>(
				//	"issues", INSTANCE, org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE, org.instantlogic.example.izzy.Issue.class, 
				//	org.instantlogic.example.izzy.entity.IssueEntity.project
				String toEntity = model.getRootPackageInternalPrefix()+"entity/"+r.item+"Entity";
				mv.visitTypeInsn(NEW, className+"$"+innerClassIndex);
				mv.visitInsn(DUP);
				mv.visitLdcInsn(r.javaIdentifier);
				mv.visitFieldInsn(GETSTATIC, className, "INSTANCE", "L"+className+";");
				mv.visitFieldInsn(GETSTATIC, toEntity, "INSTANCE", "L"+toEntity+";");
				mv.visitLdcInsn(Type.getType("L"+model.getRootPackageInternalPrefix()+r.item+";"));
				mv.visitFieldInsn(GETSTATIC, toEntity, r.reverseJavaIdentifier, "Lorg/instantlogic/fabric/model/Relation;");
				mv.visitMethodInsn(INVOKESPECIAL, className+"$"+innerClassIndex, "<init>", "(Ljava/lang/String;Lorg/instantlogic/fabric/model/Entity;Lorg/instantlogic/fabric/model/Entity;Ljava/lang/Class;Lorg/instantlogic/fabric/model/Relation;)V");
				mv.visitFieldInsn(PUTSTATIC, className, r.javaIdentifier, "Lorg/instantlogic/fabric/model/Relation;");
				innerClassIndex++;
			}
			for (Relation r:model.reverseRelations) {
				//	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.engine.presence.User, org.instantlogic.engine.presence.Presence, org.instantlogic.engine.presence.Presence> presence
				//   = new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.engine.presence.User, org.instantlogic.engine.presence.Presence, org.instantlogic.engine.presence.Presence>(
				String toEntity = model.getRootPackageInternalPrefix()+"entity/"+r.item+"Entity";
				mv.visitTypeInsn(NEW, className+"$"+innerClassIndex);
				mv.visitInsn(DUP);
				mv.visitLdcInsn(r.javaIdentifier);
				mv.visitFieldInsn(GETSTATIC, className, "INSTANCE", "L"+className+";");
				mv.visitFieldInsn(GETSTATIC, toEntity, "INSTANCE", "L"+toEntity+";");
				mv.visitLdcInsn(Type.getType("L"+model.getRootPackageInternalPrefix()+r.item+";"));
				mv.visitFieldInsn(GETSTATIC, toEntity, r.reverseJavaIdentifier, "Lorg/instantlogic/fabric/model/Relation;");
				mv.visitMethodInsn(INVOKESPECIAL, className+"$"+innerClassIndex, "<init>", "(Ljava/lang/String;Lorg/instantlogic/fabric/model/Entity;Lorg/instantlogic/fabric/model/Entity;Ljava/lang/Class;Lorg/instantlogic/fabric/model/Relation;)V");
				mv.visitFieldInsn(PUTSTATIC, className, r.javaIdentifier, "Lorg/instantlogic/fabric/model/Relation;");
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
			
			mv.visitIntInsn(BIPUSH, model.relations.size());
			mv.visitTypeInsn(ANEWARRAY, "org/instantlogic/fabric/model/Relation");
			i=0;
			for(Relation r:model.relations) {
				mv.visitInsn(DUP);
				mv.visitIntInsn(BIPUSH, i);
				mv.visitFieldInsn(GETSTATIC, className, r.javaIdentifier, "Lorg/instantlogic/fabric/model/Relation;");
				mv.visitInsn(AASTORE);
				i++;
			}
			mv.visitFieldInsn(PUTSTATIC, className, "RELATIONS", "[Lorg/instantlogic/fabric/model/Relation;");
			
			mv.visitIntInsn(BIPUSH, model.reverseRelations.size());
			mv.visitTypeInsn(ANEWARRAY, "org/instantlogic/fabric/model/Relation");
			i=0;
			for(Relation r:model.reverseRelations) {
				mv.visitInsn(DUP);
				mv.visitIntInsn(BIPUSH, i);
				mv.visitFieldInsn(GETSTATIC, className, r.javaIdentifier, "Lorg/instantlogic/fabric/model/Relation;");
				mv.visitInsn(AASTORE);
				i++;
			}
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
		return cwriter.toByteArray();
	}
	
	private static byte[] dumpAttributeInnerClass(EntityClassModel model, int innerClassIndex, Attribute attribute) {
		ClassWriter cw = new ClassWriter(0);
		MethodVisitor mv;
		
		String className = model.getRootPackageInternalPrefix()+"entity/"+model.technicalNameCapitalized+"Entity$"+innerClassIndex;

		cw.visit(V1_7, ACC_SUPER, className,
				"Lorg/instantlogic/fabric/model/impl/SimpleAttribute<L"+model.getRootPackageInternalPrefix()+model.technicalNameCapitalized+";L"+attribute.internalClassName+";>;",
				"org/instantlogic/fabric/model/impl/SimpleAttribute", null);

		cw.visitOuterClass(model.getRootPackageInternalPrefix()+"entity/"+model.technicalNameCapitalized+"Entity", null, null);

		cw.visitInnerClass(className, null, null, 0);

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
			mv = cw.visitMethod(ACC_PUBLIC, "get", "(L"+model.getRootPackageInternalPrefix()+model.technicalNameCapitalized+";)Lorg/instantlogic/fabric/value/ReadOnlyAttributeValue"+(attribute.multivalue?"s":"")+";", "(L"+model.getRootPackageInternalPrefix()+model.technicalNameCapitalized+";)Lorg/instantlogic/fabric/value/ReadOnlyAttributeValue"+(attribute.multivalue?"s":"")+"<L"+model.getRootPackageInternalPrefix()+model.technicalNameCapitalized+";L"+attribute.internalClassName+";>;", null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 1);
			mv.visitMethodInsn(INVOKEVIRTUAL, model.getRootPackageInternalPrefix()+model.technicalNameCapitalized, "get"+attribute.technicalNameCapitalized+"AttributeValue", "()Lorg/instantlogic/fabric/value/AttributeValue"+(attribute.multivalue?"s":"")+";");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 2);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC, "get", "(Lorg/instantlogic/fabric/Instance;)Lorg/instantlogic/fabric/value/ReadOnlyAttributeValue"+(attribute.multivalue?"s":"")+";", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitVarInsn(ALOAD, 1);
			mv.visitTypeInsn(CHECKCAST, model.getRootPackageInternalPrefix()+model.technicalNameCapitalized);
			mv.visitMethodInsn(INVOKEVIRTUAL, className, "get", "(L"+model.getRootPackageInternalPrefix()+model.technicalNameCapitalized+";)Lorg/instantlogic/fabric/value/ReadOnlyAttributeValue"+(attribute.multivalue?"s":"")+";");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(2, 2);
			mv.visitEnd();
		}
		
		if (attribute.multivalue) {
			//public boolean isMultivalue() {
			//	return true;
			//}
			emitReturnTrue(cw, "isMultivalue");
		}
		
		// TODO: Question

		if (attribute.readonly) {
			//public boolean isReadOnly() {
			//	return true;
			//};
			emitReturnTrue(cw, "isReadOnly");
		}

		// TODO: Deductions 3x
		
		// TODO: Validations
		
		cw.visitEnd();

		return cw.toByteArray();
	}
	
	private static byte[] dumpRelationInnerClass(EntityClassModel model, int innerClassIndex, Relation relation) {
		ClassWriter cw = new ClassWriter(0);
		MethodVisitor mv;
		
		String className = model.getRootPackageInternalPrefix()+"entity/"+model.technicalNameCapitalized+"Entity$"+innerClassIndex;
		String instanceClassName = model.getRootPackageInternalPrefix()+model.technicalNameCapitalized;
		
		cw.visit(V1_7, ACC_SUPER, className, 
				"Lorg/instantlogic/fabric/model/impl/SimpleRelation<L"+instanceClassName+";L"+relation.internalTo+";L"+relation.internalItemClassName+";>;", "org/instantlogic/fabric/model/impl/SimpleRelation", null);

		cw.visitSource("PresenceEntity.java", null);

		cw.visitOuterClass(model.getRootPackageInternalPrefix()+"entity/"+model.technicalNameCapitalized+"Entity", null, null);

		cw.visitInnerClass(className, null, null, 0);

		{
			mv = cw.visitMethod(0, "<init>", "(Ljava/lang/String;Lorg/instantlogic/fabric/model/Entity;Lorg/instantlogic/fabric/model/Entity;Ljava/lang/Class;Lorg/instantlogic/fabric/model/Relation;)V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitVarInsn(ALOAD, 1);
			mv.visitVarInsn(ALOAD, 2);
			mv.visitVarInsn(ALOAD, 3);
			mv.visitVarInsn(ALOAD, 4);
			mv.visitVarInsn(ALOAD, 5);
			mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/fabric/model/impl/SimpleRelation", "<init>", "(Ljava/lang/String;Lorg/instantlogic/fabric/model/Entity;Lorg/instantlogic/fabric/model/Entity;Ljava/lang/Class;Lorg/instantlogic/fabric/model/Relation;)V");
			mv.visitInsn(RETURN);
			mv.visitMaxs(6, 6);
			mv.visitEnd();
		}
		
		if (relation.owner) {
			//public boolean isOwner() {
			//	return true;
			//}
			emitReturnTrue(cw, "isOwner");
		}
		
		if (relation.autoCreate) {
			//public boolean isAutoCreate() {
			//	return true;
			//}
			emitReturnTrue(cw, "isAutoCreate");
		}
		if (relation.multivalue) {
			//public boolean isMultivalue() {
			//	return true;
			//}
			emitReturnTrue(cw, "isMultivalue");
		}
		if (relation.readonly) {
			//public boolean isReadOnly() {
			//	return true;
			//}
			emitReturnTrue(cw, "isReadOnly");
		}
		if (relation.ruleDeductionIndex!=null) {
			//private org.instantlogic.fabric.deduction.Deduction<${relation.to}> rule;
			//@Override
			//public org.instantlogic.fabric.deduction.Deduction<${relation.to}> getRule() {
			//	if (rule==null) {
			//		rule  = createDeduction${relation.ruleDeductionIndex}();
			//	}
			//	return rule;
			//}
			
			//TODO
		}
		if (relation.optionsDeductionIndex!=null) {
			//private org.instantlogic.fabric.deduction.Deduction<? extends java.lang.Iterable<${relation.to}>> options;
			//@Override
			//public org.instantlogic.fabric.deduction.Deduction<? extends java.lang.Iterable<${relation.to}>> getOptions() {
			//	if (options==null) {
			//		options = (org.instantlogic.fabric.deduction.Deduction)createDeduction${relation.optionsDeductionIndex}();
			//	}
			//	return options;
			//};
			
			//TODO
		}
        if (relation.validations.size()>0) {
			//public org.instantlogic.fabric.model.Validation[] validations;
			//@Override
			//public org.instantlogic.fabric.model.Validation[] getValidations() {
			//	if (validations==null) {
			//		validations = new org.instantlogic.fabric.model.Validation[] {
			//			<#list relation.validations as validation>
			//			${rootPackageName}.validation.${validation}Validation.INSTANCE,
			//			</#list>
			//		};
			//	}
			//	return validations;
			//}
        	
        	//TODO
        }
	
		cw.visitEnd();

		return cw.toByteArray();
	}

	private static byte[] dumpReverseRelationInnerClass(EntityClassModel model, int innerClassIndex, Relation relation) {
		ClassWriter cw = new ClassWriter(0);
		MethodVisitor mv;
		
		String className = model.getRootPackageInternalPrefix()+"entity/"+model.technicalNameCapitalized+"Entity$"+innerClassIndex;
		String instanceClassName = model.getRootPackageInternalPrefix()+model.technicalNameCapitalized;
		
		cw.visit(V1_7, ACC_SUPER, className, 
				"Lorg/instantlogic/fabric/model/impl/SimpleRelation<L"+model.getRootPackageInternalPrefix()+model.technicalNameCapitalized+";L"+relation.internalTo+";L"+relation.internalItemClassName+";>;", "org/instantlogic/fabric/model/impl/SimpleRelation", null);

		cw.visitOuterClass(model.getRootPackageInternalPrefix()+"entity/"+model.technicalNameCapitalized+"Entity", null, null);

		cw.visitInnerClass(className, null, null, 0);

		{
			mv = cw.visitMethod(0, "<init>", "(Ljava/lang/String;Lorg/instantlogic/fabric/model/Entity;Lorg/instantlogic/fabric/model/Entity;Ljava/lang/Class;Lorg/instantlogic/fabric/model/Relation;)V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitVarInsn(ALOAD, 1);
			mv.visitVarInsn(ALOAD, 2);
			mv.visitVarInsn(ALOAD, 3);
			mv.visitVarInsn(ALOAD, 4);
			mv.visitVarInsn(ALOAD, 5);
			mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/fabric/model/impl/SimpleRelation", "<init>", "(Ljava/lang/String;Lorg/instantlogic/fabric/model/Entity;Lorg/instantlogic/fabric/model/Entity;Ljava/lang/Class;Lorg/instantlogic/fabric/model/Relation;)V");
			mv.visitInsn(RETURN);
			mv.visitMaxs(6, 6);
			mv.visitEnd();
		}
		
		//@Override
		//public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.engine.presence.User, org.instantlogic.engine.presence.Traveler> get(
		//		org.instantlogic.engine.presence.User instance) {
		//	return instance.getTravelersRelationValue();
		//}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "get", "(L"+instanceClassName+";)Lorg/instantlogic/fabric/value/ReadOnlyRelationValue"+(relation.isMultivalue()?"s":"")+";", "(L"+instanceClassName+";)Lorg/instantlogic/fabric/value/ReadOnlyRelationValue<L"+instanceClassName+";L"+relation.internalItemClassName+";>;", null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 1);
			mv.visitMethodInsn(INVOKEVIRTUAL, instanceClassName, "getPresenceRelationValue", "()Lorg/instantlogic/fabric/value/RelationValue;");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 2);
			mv.visitEnd();
		}
		
		//public boolean isReverse() {
		//	return true;
		//}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "isReverse", "()Z", null, null);
			mv.visitCode();
			mv.visitInsn(ICONST_1);
			mv.visitInsn(IRETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}		

		if (relation.multivalue) {
			//public boolean isMultivalue() {
			//	return true;
			//}
			{
				mv = cw.visitMethod(ACC_PUBLIC, "isMultivalue", "()Z", null, null);
				mv.visitCode();
				mv.visitInsn(ICONST_1);
				mv.visitInsn(IRETURN);
				mv.visitMaxs(1, 1);
				mv.visitEnd();
			}		
		}
	
		cw.visitEnd();

		return cw.toByteArray();
	}
}
