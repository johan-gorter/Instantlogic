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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.instantlogic.designer.codegenerator.classmodel.DeductionSchemeModel;
import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel;
import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel.Attribute;
import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel.Relation;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.CheckClassAdapter;
import org.objectweb.asm.util.TraceClassVisitor;

public class EntityBytecodeTemplate extends AbstractBytecodeTemplate {
	
	public static final boolean TRACE = true;

	public static void generate(Map<String, byte[]> bytecodeClasses, EntityClassModel model, String fullName) {
		bytecodeClasses.put(fullName, dump(model));
	}

	public static byte[] dump(EntityClassModel model) {
		ClassWriter cwriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);

		ClassVisitor cw;
		if (TRACE) {
			cw = new TraceClassVisitor(cwriter, new ASMifier(), new PrintWriter(System.out));
			cw = new CheckClassAdapter(cw);
		} else {
			cw=cwriter;
		}
		
		FieldVisitor fv;
		MethodVisitor mv;

		String className = model.getRootPackageInternalPrefix()+"entity/"+model.technicalNameCapitalized+"Entity";
		String instanceClassName = model.getRootPackageInternalPrefix()+model.technicalNameCapitalized;
		String abstractInstanceClassName = model.isCustomized?model.getRootPackageInternalPrefix()+"Abstract"+model.technicalNameCapitalized:instanceClassName;

		cw.visit(V1_7, ACC_PUBLIC + ACC_SUPER, className,
				"Lorg/instantlogic/fabric/model/Entity<L"+instanceClassName+";>;", "org/instantlogic/fabric/model/Entity", null);

		List<Label> labels = new ArrayList<Label>();
		
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

			// Phase 1
			int localVariableIndex=0;
			for(Attribute a:model.attributes) {
				//org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.example.izzy.Issue, java.lang.String, java.lang.String> $description
				//	= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.example.izzy.Issue, java.lang.String, java.lang.String>(
				//		"description", INSTANCE, java.lang.String.class, "description", org.instantlogic.example.izzy.Issue.class);
				//description = $description;
				mv.visitTypeInsn(NEW, "org/instantlogic/fabric/model/impl/SimpleAttribute");
				mv.visitInsn(DUP);
				mv.visitLdcInsn(a.name);
				mv.visitFieldInsn(GETSTATIC, className, "INSTANCE", "L"+className+";");
				mv.visitLdcInsn(Type.getType("L"+a.internalClassName+";"));
				mv.visitLdcInsn(a.javaIdentifier);
				mv.visitLdcInsn(Type.getType("L"+abstractInstanceClassName+";"));
				mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/fabric/model/impl/SimpleAttribute", "<init>", "(Ljava/lang/String;Lorg/instantlogic/fabric/model/Entity;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)V");
				mv.visitVarInsn(ASTORE, localVariableIndex);
				Label label = new Label();
				mv.visitLabel(label);
				labels.add(label);
				mv.visitVarInsn(ALOAD, localVariableIndex);
				mv.visitFieldInsn(PUTSTATIC, className, a.javaIdentifier, "Lorg/instantlogic/fabric/model/Attribute;");
				localVariableIndex++;
			}
			for (Relation r:model.relations) {
				//org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.Project, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue>, org.instantlogic.example.izzy.Issue> $issues
				//	= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.Project, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue>, org.instantlogic.example.izzy.Issue>(
				//		"issues", INSTANCE, "issues", org.instantlogic.example.izzy.Project.class);
				mv.visitTypeInsn(NEW, "org/instantlogic/fabric/model/impl/SimpleRelation");
				mv.visitInsn(DUP);
				mv.visitLdcInsn(r.name);
				mv.visitFieldInsn(GETSTATIC, className, "INSTANCE", "L"+className+";");
				mv.visitLdcInsn(r.javaIdentifier);
				mv.visitLdcInsn(Type.getType("L"+abstractInstanceClassName+";"));
				mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/fabric/model/impl/SimpleRelation", "<init>", "(Ljava/lang/String;Lorg/instantlogic/fabric/model/Entity;Ljava/lang/String;Ljava/lang/Class;)V");
				mv.visitVarInsn(ASTORE, localVariableIndex);
				Label label = new Label();
				mv.visitLabel(label);
				labels.add(label);
				mv.visitVarInsn(ALOAD, localVariableIndex);
				mv.visitFieldInsn(PUTSTATIC, className, r.javaIdentifier, "Lorg/instantlogic/fabric/model/Relation;");
				localVariableIndex++;
			}
			for (Relation r:model.reverseRelations) {
				//org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.Issue, org.instantlogic.example.izzy.Project, org.instantlogic.example.izzy.Project> $project
				//	= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.Issue, org.instantlogic.example.izzy.Project, org.instantlogic.example.izzy.Project>(
				//		"project", INSTANCE, "project", org.instantlogic.example.izzy.Issue.class);
				//project = $project;
				mv.visitTypeInsn(NEW, "org/instantlogic/fabric/model/impl/SimpleRelation");
				mv.visitInsn(DUP);
				mv.visitLdcInsn(r.name);
				mv.visitFieldInsn(GETSTATIC, className, "INSTANCE", "L"+className+";");
				mv.visitLdcInsn(r.javaIdentifier);
				mv.visitLdcInsn(Type.getType("L"+abstractInstanceClassName+";"));
				mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/fabric/model/impl/SimpleRelation", "<init>", "(Ljava/lang/String;Lorg/instantlogic/fabric/model/Entity;Ljava/lang/String;Ljava/lang/Class;)V");
				mv.visitVarInsn(ASTORE, localVariableIndex);
				Label label = new Label();
				mv.visitLabel(label);
				labels.add(label);
				mv.visitVarInsn(ALOAD, localVariableIndex);
				mv.visitFieldInsn(PUTSTATIC, className, r.javaIdentifier, "Lorg/instantlogic/fabric/model/Relation;");
				localVariableIndex++;
			}
			// Phase 2
			//EXTENSIONS = new org.instantlogic.fabric.model.Entity<?>[] {
			// TODO
			localVariableIndex=0;
			for(Attribute a:model.attributes) {
				for (Map.Entry<String,Object> dataTypeEntry : a.dataType.entrySet()) {
					// $description.dataType.put("category", "text");
					mv.visitVarInsn(ALOAD, localVariableIndex);
					mv.visitFieldInsn(GETFIELD, "org/instantlogic/fabric/model/impl/SimpleAttribute", "dataType", "Ljava/util/Map;");
					mv.visitLdcInsn(dataTypeEntry.getKey());
					Object value = dataTypeEntry.getValue();
					if (value instanceof Boolean) {
						mv.visitInsn(value==Boolean.TRUE?ICONST_1:ICONST_0);
						mv.visitMethodInsn(INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
					} else {
						mv.visitLdcInsn(dataTypeEntry.getValue()); // Works at least for strings...
					}
					mv.visitMethodInsn(INVOKEINTERFACE, "java/util/Map", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
					mv.visitInsn(POP);
				}
				if (a.multivalue) {
					// description.multivalue = true;
					mv.visitVarInsn(ALOAD, localVariableIndex);
					mv.visitInsn(ICONST_1);
					mv.visitFieldInsn(PUTFIELD, "org/instantlogic/fabric/model/impl/SimpleAttribute", "multivalue", "Z");
				}
				if (a.question!=null) {
					//TODO
				}
				if (a.readonly) {
					// description.readOnly = true;
					mv.visitVarInsn(ALOAD, localVariableIndex);
					mv.visitInsn(ICONST_1);
					mv.visitFieldInsn(PUTFIELD, "org/instantlogic/fabric/model/impl/SimpleAttribute", "readOnly", "Z");
				}
				if (a.relevanceDeductionIndex!=null) {
					//TODO
				}
				if (a.ruleDeductionIndex!=null) {
					//TODO
				}
				if (a.defaultDeductionIndex!=null) {
					mv.visitVarInsn(ALOAD, localVariableIndex);
					mv.visitMethodInsn(INVOKESTATIC, className, "createDeduction"+a.defaultDeductionIndex, "()Lorg/instantlogic/fabric/deduction/Deduction;");
					mv.visitFieldInsn(PUTFIELD, "org/instantlogic/fabric/model/impl/SimpleAttribute", "_default", "Lorg/instantlogic/fabric/deduction/Deduction;");
				}
				if (a.validations.size()>0) {
					//TODO
				}
				localVariableIndex++;
			}
			for (Relation r:model.relations) {
				//$issues.valueClass = org.instantlogic.example.izzy.Issue.class;
				mv.visitVarInsn(ALOAD, localVariableIndex);
				mv.visitLdcInsn(Type.getType("L"+model.getRootPackageInternalPrefix()+r.item+";"));
				mv.visitFieldInsn(PUTFIELD, "org/instantlogic/fabric/model/impl/SimpleRelation", "valueClass", "Ljava/lang/Class;");
				// $issues.to = org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE;
				String toEntity = model.getRootPackageInternalPrefix()+"entity/"+r.item+"Entity";
				mv.visitVarInsn(ALOAD, localVariableIndex);
				mv.visitFieldInsn(GETSTATIC, toEntity, "INSTANCE", "L"+toEntity+";");
				mv.visitFieldInsn(PUTFIELD, "org/instantlogic/fabric/model/impl/SimpleRelation", "to", "Lorg/instantlogic/fabric/model/Entity;");
				if(r.reverseJavaIdentifier!=null) {
					// $issues.setReverseRelation(org.instantlogic.example.izzy.entity.IssueEntity.project);
					mv.visitVarInsn(ALOAD, localVariableIndex);
					mv.visitFieldInsn(GETSTATIC, toEntity, r.reverseJavaIdentifier, "Lorg/instantlogic/fabric/model/Relation;");
					mv.visitMethodInsn(INVOKEVIRTUAL, "org/instantlogic/fabric/model/impl/SimpleRelation", "setReverseRelation", "(Lorg/instantlogic/fabric/model/Relation;)V");
				}
				if (r.owner) {
					//$issues.owner = true;
					mv.visitVarInsn(ALOAD, localVariableIndex);
					mv.visitInsn(ICONST_1);
					mv.visitFieldInsn(PUTFIELD, "org/instantlogic/fabric/model/impl/SimpleRelation", "owner", "Z");
				}
				if (r.autoCreate) {
					mv.visitVarInsn(ALOAD, localVariableIndex);
					mv.visitInsn(ICONST_1);
					mv.visitFieldInsn(PUTFIELD, "org/instantlogic/fabric/model/impl/SimpleRelation", "autoCreate", "Z");
				}
				if (r.multivalue) {
					//$issues.multivalue = true;
					mv.visitVarInsn(ALOAD, localVariableIndex);
					mv.visitInsn(ICONST_1);
					mv.visitFieldInsn(PUTFIELD, "org/instantlogic/fabric/model/impl/SimpleRelation", "multivalue", "Z");
				}
				if (r.readonly) {
					mv.visitVarInsn(ALOAD, localVariableIndex);
					mv.visitInsn(ICONST_1);
					mv.visitFieldInsn(PUTFIELD, "org/instantlogic/fabric/model/impl/SimpleRelation", "readOnly", "Z");
				}
				if (r.ruleDeductionIndex!=null) {
					// TODO
				}
				if (r.optionsDeductionIndex!=null) {
					mv.visitVarInsn(ALOAD, localVariableIndex);
					mv.visitMethodInsn(INVOKESTATIC, className, "createDeduction"+r.optionsDeductionIndex, "()Lorg/instantlogic/fabric/deduction/Deduction;");
					mv.visitFieldInsn(PUTFIELD, "org/instantlogic/fabric/model/impl/SimpleRelation", "options", "Lorg/instantlogic/fabric/deduction/Deduction;");
				}
				if (r.validations.size()>0) {
					// TODO
				}
				localVariableIndex++;
			}
			for (Relation r:model.reverseRelations) {
				// $x.reverse = true;
				mv.visitVarInsn(ALOAD, localVariableIndex);
				mv.visitInsn(ICONST_1);
				mv.visitFieldInsn(PUTFIELD, "org/instantlogic/fabric/model/impl/SimpleRelation", "reverse", "Z");
				//$issues.valueClass = org.instantlogic.example.izzy.Issue.class;
				mv.visitVarInsn(ALOAD, localVariableIndex);
				mv.visitLdcInsn(Type.getType("L"+model.getRootPackageInternalPrefix()+r.item+";"));
				mv.visitFieldInsn(PUTFIELD, "org/instantlogic/fabric/model/impl/SimpleRelation", "valueClass", "Ljava/lang/Class;");
				// $issues.to = org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE;
				String toEntity = model.getRootPackageInternalPrefix()+"entity/"+r.item+"Entity";
				mv.visitVarInsn(ALOAD, localVariableIndex);
				mv.visitFieldInsn(GETSTATIC, toEntity, "INSTANCE", "L"+toEntity+";");
				mv.visitFieldInsn(PUTFIELD, "org/instantlogic/fabric/model/impl/SimpleRelation", "to", "Lorg/instantlogic/fabric/model/Entity;");
				// $issues.setReverseRelation(org.instantlogic.example.izzy.entity.IssueEntity.project);
				mv.visitVarInsn(ALOAD, localVariableIndex);
				mv.visitFieldInsn(GETSTATIC, toEntity, r.reverseJavaIdentifier, "Lorg/instantlogic/fabric/model/Relation;");
				mv.visitMethodInsn(INVOKEVIRTUAL, "org/instantlogic/fabric/model/impl/SimpleRelation", "setReverseRelation", "(Lorg/instantlogic/fabric/model/Relation;)V");
				if (r.multivalue) {
					//$issues.multivalue = true;
					mv.visitVarInsn(ALOAD, localVariableIndex);
					mv.visitInsn(ICONST_1);
					mv.visitFieldInsn(PUTFIELD, "org/instantlogic/fabric/model/impl/SimpleRelation", "multivalue", "Z");
				}
				localVariableIndex++;
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
			Label endLabel = new Label();
			mv.visitLabel(endLabel);
			
			int index = 0;
			for (Attribute a:model.attributes) {
				mv.visitLocalVariable("$"+a.technicalName, "Lorg/instantlogic/fabric/model/impl/SimpleAttribute;", null, labels.get(index), endLabel, index);
				index++;
			}
			for (Relation r:model.relations) {
				mv.visitLocalVariable("$"+r.technicalName, "Lorg/instantlogic/fabric/model/impl/SimpleRelation;", null, labels.get(index), endLabel, index);
				index++;
			}
			for (Relation r:model.reverseRelations) {
				mv.visitLocalVariable("$"+r.technicalName, "Lorg/instantlogic/fabric/model/impl/SimpleRelation;", null, labels.get(index), endLabel, index);
				index++;
			}
			mv.visitInsn(RETURN);
			mv.visitMaxs(7, index);
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
		
		//Deductions
		for (DeductionSchemeModel scheme : model.getDeductionSchemes()) {
			dumpDeductionScheme(cw, scheme);
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
}
