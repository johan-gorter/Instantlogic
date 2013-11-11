package org.instantlogic.designer.codegenerator.jvmbytecode.template;

import java.io.PrintWriter;

import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel;
import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel.StaticInstance;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.TraceClassVisitor;

public class InstanceBytecodeTemplate extends AbstractBytecodeTemplate {
	
	private static final boolean TRACE = false;

	public static byte[] generate(EntityClassModel model, String fullInstanceClassName) {
		ClassWriter cwriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);

		ClassVisitor cw;
		if (TRACE) {
			cw = new TraceClassVisitor(cwriter, new ASMifier(), new PrintWriter(System.out));
		} else {
			cw=cwriter;
		}
		
		FieldVisitor fv;
		MethodVisitor mv;

		String className = model.getRootPackageInternalPrefix()+(model.isCustomized?"Abstract":"")+model.technicalNameCapitalized;
		String concreteClassName = model.getRootPackageInternalPrefix()+model.technicalNameCapitalized;
		
		String baseClassName = model.extendsFrom==null?"org/instantlogic/fabric/Instance":model.getRootPackageInternalPrefix()+model.extendsFrom;
		String entityClassName = model.getRootPackageInternalPrefix()+"entity/"+model.technicalNameCapitalized+"Entity";

		// public class ... extends org.instantlogic.fabric.Instance
		cw.visit(V1_7, ACC_PUBLIC + ACC_SUPER + (model.isCustomized?ACC_ABSTRACT:0), 
				className, null, baseClassName, null);
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
						a.javaIdentifier, 
						"Lorg/instantlogic/fabric/value/"+(a.readonly?"ReadOnly":"")+"AttributeValue"+a.getValueSuffix()+";",
						null,//"Lorg/instantlogic/fabric/value/AttributeValue<Lorg/instantlogic/example/izzy/User;Ljava/lang/String;>;", 
						null);
				fv.visitEnd();
			}
		}
		{
			for (EntityClassModel.Relation r : model.relations) {
				// private final org.instantlogic.fabric.value.RelationValues<..., ...> ...
				fv = cw.visitField(
						ACC_PRIVATE + ACC_FINAL, 
						r.javaIdentifier, 
						"Lorg/instantlogic/fabric/value/"+(r.readonly?"ReadOnly":"")+"RelationValue"+r.getValueSuffix()+";",
						null,//"Lorg/instantlogic/fabric/value/AttributeValue<Lorg/instantlogic/example/izzy/User;Ljava/lang/String;>;", 
						null);
				fv.visitEnd();
			}
		}
		{
			for (EntityClassModel.Relation r : model.reverseRelations) {
				// private final org.instantlogic.fabric.value.RelationValues<..., ...> ...
				fv = cw.visitField(
						ACC_PRIVATE + ACC_FINAL, 
						r.javaIdentifier, 
						"Lorg/instantlogic/fabric/value/RelationValue"+r.getValueSuffix()+";",
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
			
			// Phase 1
			for (EntityClassModel.StaticInstance staticInstance : model.staticInstances)
			{
				//   _boolean = addStaticInstance("boolean", new DataTypeDesign());
				//   _boolean.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Boolean")));
				mv.visitLdcInsn(staticInstance.javaIdentifier);
				mv.visitTypeInsn(NEW, concreteClassName);
				mv.visitInsn(DUP);
				mv.visitMethodInsn(INVOKESPECIAL, concreteClassName, "<init>", "()V");
				mv.visitMethodInsn(INVOKESTATIC, className, "addStaticInstance", "(Ljava/lang/String;L"+concreteClassName+";)L"+concreteClassName+";");
				mv.visitFieldInsn(PUTSTATIC, className, staticInstance.javaIdentifier, "L"+concreteClassName+";");
			}
			
			// Phase 2
			for (EntityClassModel.StaticInstance staticInstance : model.staticInstances) {
				if (staticInstance.getDescription()!=null) {
					// draft.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Draft").getTextTemplate());
					mv.visitFieldInsn(GETSTATIC, className, staticInstance.javaIdentifier, "L"+concreteClassName+";");
					mv.visitMethodInsn(INVOKEVIRTUAL, concreteClassName, "getMetadata", "()Lorg/instantlogic/fabric/util/InstanceMetadata;");
					dumpText(mv, className, staticInstance.getDescription());
					mv.visitMethodInsn(INVOKEVIRTUAL, "org/instantlogic/fabric/util/InstanceMetadata", "setStaticDescription", "(Lorg/instantlogic/fabric/text/TextTemplate;)V");
				}
			}
			
			mv.visitInsn(RETURN);
			mv.visitMaxs(2, 0);
			mv.visitEnd();
		}
		
		// Constructor
		{
			mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, baseClassName, "<init>", "()V");
			for (EntityClassModel.Attribute a : model.attributes) {
				// username = createAttributeValue(org.instantlogic.example.izzy.entity.UserEntity.username);
				mv.visitVarInsn(ALOAD, 0);
				mv.visitVarInsn(ALOAD, 0);
				mv.visitFieldInsn(GETSTATIC, model.getInternalEntityName(), a.javaIdentifier, "Lorg/instantlogic/fabric/model/Attribute;");
				mv.visitMethodInsn(INVOKEVIRTUAL, className, "create"+(a.readonly?"ReadOnly":"")+"AttributeValue"+a.getValueSuffix(), "(Lorg/instantlogic/fabric/model/Attribute;)Lorg/instantlogic/fabric/value/"+(a.readonly?"ReadOnly":"")+"AttributeValue"+a.getValueSuffix()+";");
				mv.visitFieldInsn(PUTFIELD, className, a.javaIdentifier, "Lorg/instantlogic/fabric/value/"+(a.readonly?"ReadOnly":"")+"AttributeValue"+a.getValueSuffix()+";");
			}
			for (EntityClassModel.Relation r : model.relations) {
				// activePlaces = createRelationValues(org.instantlogic.engine.presence.entity.PresenceEntity.activePlaces)
				mv.visitVarInsn(ALOAD, 0);
				mv.visitVarInsn(ALOAD, 0);
				mv.visitFieldInsn(GETSTATIC, model.getInternalEntityName(), r.javaIdentifier, "Lorg/instantlogic/fabric/model/Relation;");
				mv.visitMethodInsn(INVOKEVIRTUAL, className, "create"+(r.readonly?"ReadOnly":"")+"RelationValue"+r.getValueSuffix(), "(Lorg/instantlogic/fabric/model/Relation;)Lorg/instantlogic/fabric/value/"+(r.readonly?"ReadOnly":"")+"RelationValue"+r.getValueSuffix()+";");
				mv.visitFieldInsn(PUTFIELD, className, r.javaIdentifier, "Lorg/instantlogic/fabric/value/"+(r.readonly?"ReadOnly":"")+"RelationValue"+r.getValueSuffix()+";");
			}
			for (EntityClassModel.Relation r : model.reverseRelations) {
				// presence = createReverseRelationValue(org.instantlogic.engine.presence.entity.TravelerEntity.presence)
				mv.visitVarInsn(ALOAD, 0);
				mv.visitVarInsn(ALOAD, 0);
				mv.visitFieldInsn(GETSTATIC, model.getInternalEntityName(), r.javaIdentifier, "Lorg/instantlogic/fabric/model/Relation;");
				mv.visitMethodInsn(INVOKEVIRTUAL, className, "createReverseRelationValue"+r.getValueSuffix(), "(Lorg/instantlogic/fabric/model/Relation;)Lorg/instantlogic/fabric/value/RelationValue"+r.getValueSuffix()+";");
				mv.visitFieldInsn(PUTFIELD, className, r.javaIdentifier, "Lorg/instantlogic/fabric/value/RelationValue"+r.getValueSuffix()+";");
			}
			mv.visitInsn(RETURN);
			mv.visitMaxs(3, 1);
			mv.visitEnd();
		}

		//public static java.util.Map<String, DataCategoryDesign> getStaticDataCategoryDesignInstances() {
		//	return _staticInstances;
		//}
		{
			mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "getStatic"+model.technicalNameCapitalized+"Instances", "()Ljava/util/Map;", "()Ljava/util/Map<Ljava/lang/String;L"+concreteClassName+";>;", null);
			mv.visitCode();
			mv.visitFieldInsn(GETSTATIC, className, "_staticInstances", "Ljava/util/Map;");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 0);
			mv.visitEnd();
		}
		
		//private static User addStaticInstance(String name, User instance) {
		//	_staticInstances.put(name, instance);
		//	instance.getMetadata().makeStatic(name);
		//	return instance;
		//}
		{
			mv = cw.visitMethod(ACC_PRIVATE + ACC_STATIC, "addStaticInstance", "(Ljava/lang/String;L"+concreteClassName+";)L"+concreteClassName+";", null, null);
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
				mv.visitFieldInsn(GETFIELD, className, a.javaIdentifier, "Lorg/instantlogic/fabric/value/"+(a.readonly?"ReadOnly":"")+"AttributeValue;");
				mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/ReadOnlyAttributeValue", "getValue", "()Ljava/lang/Object;");
				mv.visitTypeInsn(CHECKCAST, a.internalClassName);
				mv.visitInsn(ARETURN);
				mv.visitMaxs(1, 1);
				mv.visitEnd();
			}
			//public org.instantlogic.fabric.value.AttributeValue<User, java.lang.String> getUsernameAttributeValue() {
			//	return username;
			//}
			{
				mv = cw.visitMethod(ACC_PUBLIC, "get"+a.technicalNameCapitalized+"AttributeValue", "()Lorg/instantlogic/fabric/value/"+(a.readonly?"ReadOnly":"")+"AttributeValue"+a.getValueSuffix()+";", null /* "()Lorg/instantlogic/fabric/value/AttributeValue<Lorg/instantlogic/example/izzy/User;Ljava/lang/String;>;"*/, null);
				mv.visitCode();
				mv.visitVarInsn(ALOAD, 0);
				mv.visitFieldInsn(GETFIELD, className, a.javaIdentifier, "Lorg/instantlogic/fabric/value/"+(a.readonly?"ReadOnly":"")+"AttributeValue"+a.getValueSuffix()+";");
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
					mv = cw.visitMethod(ACC_PUBLIC, "set"+a.technicalNameCapitalized, "(L"+a.internalClassName+";)L"+concreteClassName+";", null, null);
					mv.visitCode();
					mv.visitVarInsn(ALOAD, 0);
					mv.visitFieldInsn(GETFIELD, className, a.javaIdentifier, "Lorg/instantlogic/fabric/value/AttributeValue;");
					mv.visitVarInsn(ALOAD, 1);
					mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/AttributeValue", "setValue", "(Ljava/lang/Object;)V");
					mv.visitVarInsn(ALOAD, 0);
					mv.visitTypeInsn(CHECKCAST, concreteClassName);
					mv.visitInsn(ARETURN);
					mv.visitMaxs(2, 2);
					mv.visitEnd();
				}
			} 
			if (!a.readonly && a.multivalue) {
				//public ApplicationDesign addToThemeNames(java.lang.String item) {
				//	themeNames.addValue(item);
				//	return (ApplicationDesign)this;
				//}
				{
					mv = cw.visitMethod(ACC_PUBLIC, "addTo"+a.technicalNameCapitalized, "(L"+a.internalItemClassName+";)L"+concreteClassName+";", null, null);
					mv.visitCode();
					mv.visitVarInsn(ALOAD, 0);
					mv.visitFieldInsn(GETFIELD, className, a.javaIdentifier, "Lorg/instantlogic/fabric/value/AttributeValues;");
					mv.visitVarInsn(ALOAD, 1);
					mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/AttributeValues", "addValue", "(Ljava/lang/Object;)V");
					mv.visitVarInsn(ALOAD, 0);
					mv.visitTypeInsn(CHECKCAST, concreteClassName);
					mv.visitInsn(ARETURN);
					mv.visitMaxs(2, 2);
					mv.visitEnd();
				}
				//public ApplicationDesign addToThemeNames(java.lang.String item, int index) {
				//	themeNames.insertValue(item, index);
				//	return (ApplicationDesign)this;
				//}
				if (a.ordered)
				{
					mv = cw.visitMethod(ACC_PUBLIC, "addTo"+a.technicalNameCapitalized, "(L"+a.internalItemClassName+";I)L"+concreteClassName+";", null, null);
					mv.visitCode();
					mv.visitVarInsn(ALOAD, 0);
					mv.visitFieldInsn(GETFIELD, className, a.javaIdentifier, "Lorg/instantlogic/fabric/value/AttributeValues;");
					mv.visitVarInsn(ALOAD, 1);
					mv.visitVarInsn(ILOAD, 2);
					mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/AttributeValues", "insertValue", "(Ljava/lang/Object;I)V");
					mv.visitVarInsn(ALOAD, 0);
					mv.visitTypeInsn(CHECKCAST, concreteClassName);
					mv.visitInsn(ARETURN);
					mv.visitMaxs(3, 3);
					mv.visitEnd();
				}
				//public ApplicationDesign removeFromThemeNames(java.lang.String item) {
				//	themeNames.removeValue(item);
				//	return (ApplicationDesign)this;
				//}
				{
					mv = cw.visitMethod(ACC_PUBLIC, "removeFrom"+a.technicalNameCapitalized, "(L"+a.internalItemClassName+";)L"+concreteClassName+";", null, null);
					mv.visitCode();
					mv.visitVarInsn(ALOAD, 0);
					mv.visitFieldInsn(GETFIELD, className, a.javaIdentifier, "Lorg/instantlogic/fabric/value/AttributeValues;");
					mv.visitVarInsn(ALOAD, 1);
					mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/AttributeValues", "removeValue", "(Ljava/lang/Object;)V");
					mv.visitVarInsn(ALOAD, 0);
					mv.visitTypeInsn(CHECKCAST, concreteClassName);
					mv.visitInsn(ARETURN);
					mv.visitMaxs(2, 2);
					mv.visitEnd();
				}
				//public ApplicationDesign removeFromThemeNames(int index) {
				//	themeNames.removeValue(index);
				//	return (ApplicationDesign)this;
				//}
				if (a.ordered)
				{
					mv = cw.visitMethod(ACC_PUBLIC, "removeFrom"+a.technicalNameCapitalized, "(I)L"+a.internalItemClassName+";", null, null);
					mv.visitCode();
					mv.visitVarInsn(ALOAD, 0);
					mv.visitFieldInsn(GETFIELD, className, a.javaIdentifier, "Lorg/instantlogic/fabric/value/AttributeValues;");
					mv.visitVarInsn(ILOAD, 1);
					mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/AttributeValues", "removeValue", "(I)Ljava/lang/Object;");
					mv.visitInsn(POP);
					mv.visitVarInsn(ALOAD, 0);
					mv.visitTypeInsn(CHECKCAST, a.internalItemClassName);
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
				mv = cw.visitMethod(ACC_PUBLIC, "get"+r.technicalNameCapitalized+"RelationValue", "()Lorg/instantlogic/fabric/value/"+(r.readonly?"ReadOnly":"")+"RelationValue"+r.getValueSuffix()+";", null /* "()Lorg/instantlogic/fabric/value/RelationValue<Lorg/instantlogic/designer/ApplicationDesign;Lorg/instantlogic/designer/EntityDesign;>;"*/, null);
				mv.visitCode();
				mv.visitVarInsn(ALOAD, 0);
				mv.visitFieldInsn(GETFIELD, className, r.javaIdentifier, "Lorg/instantlogic/fabric/value/"+(r.readonly?"ReadOnly":"")+"RelationValue"+r.getValueSuffix()+";");
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
				mv.visitFieldInsn(GETFIELD, className, r.javaIdentifier, "Lorg/instantlogic/fabric/value/"+(r.readonly?"ReadOnly":"")+"RelationValue"+r.getValueSuffix()+";");
				mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/"+(r.readonly?"ReadOnly":"")+"RelationValue"+r.getValueSuffix(), "getValue", "()Ljava/lang/Object;");
				mv.visitTypeInsn(CHECKCAST, r.internalTo);
				mv.visitInsn(ARETURN);
				mv.visitMaxs(1, 1);
				mv.visitEnd();
			}
			if (!r.readonly && !r.multivalue) {
				//public ApplicationDesign setCaseEntity(org.instantlogic.designer.EntityDesign newValue) {
				//	caseEntity.setValue(newValue);
				//	return (ApplicationDesign)this;
				//}
				{
					mv = cw.visitMethod(ACC_PUBLIC, "set"+r.technicalNameCapitalized, "(L"+r.internalTo+";)L"+concreteClassName+";", null, null);
					mv.visitCode();
					mv.visitVarInsn(ALOAD, 0);
					mv.visitFieldInsn(GETFIELD, className, r.javaIdentifier, "Lorg/instantlogic/fabric/value/RelationValue;");
					mv.visitVarInsn(ALOAD, 1);
					mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/RelationValue", "setValue", "(Ljava/lang/Object;)V");
					mv.visitVarInsn(ALOAD, 0);
					mv.visitTypeInsn(CHECKCAST, concreteClassName);
					mv.visitInsn(ARETURN);
					mv.visitMaxs(2, 2);
					mv.visitEnd();
				}
				if (r.owner) {
					//public org.instantlogic.designer.ElementDesign newContent() {
					//	org.instantlogic.designer.ElementDesign newValue = new org.instantlogic.designer.ElementDesign(); 
					//	content.setValue(newValue);
					//	return newValue;
					//}
					{
						mv = cw.visitMethod(ACC_PUBLIC, "new"+r.technicalNameCapitalized, "()L"+r.internalTo+";", null, null);
						mv.visitCode();
						mv.visitTypeInsn(NEW, r.internalTo);
						mv.visitInsn(DUP);
						mv.visitMethodInsn(INVOKESPECIAL, r.internalTo, "<init>", "()V");
						mv.visitVarInsn(ASTORE, 1);
						mv.visitVarInsn(ALOAD, 0);
						mv.visitFieldInsn(GETFIELD, className, r.javaIdentifier, "Lorg/instantlogic/fabric/value/RelationValue;");
						mv.visitVarInsn(ALOAD, 1);
						mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/RelationValue", "setValue", "(Ljava/lang/Object;)V");
						mv.visitVarInsn(ALOAD, 1);
						mv.visitInsn(ARETURN);
						mv.visitMaxs(2, 2);
						mv.visitEnd();
					}
				}
			}
			if (!r.readonly && r.multivalue) {
				//public Project addToIssues(Issue item) {
				//	issues.addValue(item);
				//	return (Project)this;
				//}
				{
					mv = cw.visitMethod(ACC_PUBLIC, "addTo"+r.technicalNameCapitalized, "(L"+r.internalItemClassName+";)L"+concreteClassName+";", null, null);
					mv.visitCode();
					mv.visitVarInsn(ALOAD, 0);
					mv.visitFieldInsn(GETFIELD, className, r.javaIdentifier, "Lorg/instantlogic/fabric/value/RelationValues;");
					mv.visitVarInsn(ALOAD, 1);
					mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/RelationValues", "addValue", "(Ljava/lang/Object;)V");
					mv.visitVarInsn(ALOAD, 0);
					mv.visitTypeInsn(CHECKCAST, concreteClassName);
					mv.visitInsn(ARETURN);
					mv.visitMaxs(2, 2);
					mv.visitEnd();
				}
				//public Project addToIssues(Issue item, int index) {
				//	issues.insertValue(item, index);
				//	return (Project)this;
				//}
				if (r.ordered)
				{
					mv = cw.visitMethod(ACC_PUBLIC, "addTo"+r.technicalNameCapitalized, "(L"+r.internalItemClassName+";I)L"+concreteClassName+";", null, null);
					mv.visitCode();
					mv.visitVarInsn(ALOAD, 0);
					mv.visitFieldInsn(GETFIELD, className, r.javaIdentifier, "Lorg/instantlogic/fabric/value/RelationValues;");
					mv.visitVarInsn(ALOAD, 1);
					mv.visitVarInsn(ILOAD, 2);
					mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/RelationValues", "insertValue", "(Ljava/lang/Object;I)V");
					mv.visitVarInsn(ALOAD, 0);
					mv.visitTypeInsn(CHECKCAST, concreteClassName);
					mv.visitInsn(ARETURN);
					mv.visitMaxs(3, 3);
					mv.visitEnd();
				}
				//public Project removeFromIssues(Issue item) {
				//	issues.removeValue(item);
				//	return (Project)this;
				//}
				{
					mv = cw.visitMethod(ACC_PUBLIC, "removeFrom"+r.technicalNameCapitalized, "(L"+r.internalItemClassName+";)L"+concreteClassName+";", null, null);
					mv.visitCode();
					mv.visitVarInsn(ALOAD, 0);
					mv.visitFieldInsn(GETFIELD, className, r.javaIdentifier, "Lorg/instantlogic/fabric/value/RelationValues;");
					mv.visitVarInsn(ALOAD, 1);
					mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/RelationValues", "removeValue", "(Ljava/lang/Object;)V");
					mv.visitVarInsn(ALOAD, 0);
					mv.visitTypeInsn(CHECKCAST, concreteClassName);
					mv.visitInsn(ARETURN);
					mv.visitMaxs(2, 2);
					mv.visitEnd();
				}
				//public Project removeFromIssues(int index) {
				//	issues.removeValue(index);
				//	return (Project)this;
				//}
				if (r.ordered)
				{
					mv = cw.visitMethod(ACC_PUBLIC, "removeFrom"+r.technicalNameCapitalized, "(I)L"+concreteClassName+";", null, null);
					mv.visitCode();
					mv.visitVarInsn(ALOAD, 0);
					mv.visitFieldInsn(GETFIELD, className, r.javaIdentifier, "Lorg/instantlogic/fabric/value/RelationValues;");
					mv.visitVarInsn(ILOAD, 1);
					mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/RelationValues", "removeValue", "(I)Ljava/lang/Object;");
					mv.visitInsn(POP);
					mv.visitVarInsn(ALOAD, 0);
					mv.visitTypeInsn(CHECKCAST, concreteClassName);
					mv.visitInsn(ARETURN);
					mv.visitMaxs(2, 2);
					mv.visitEnd();
				}				
			}
		}
		for (EntityClassModel.Relation r : model.reverseRelations) {
			//public org.instantlogic.fabric.value.RelationValue<User, Presence> getPresenceRelationValue() {
			//	return presence;
			//}
			{
				mv = cw.visitMethod(ACC_PUBLIC, "get"+r.technicalNameCapitalized+"RelationValue", "()Lorg/instantlogic/fabric/value/RelationValue"+r.getValueSuffix()+";", null /* "()Lorg/instantlogic/fabric/value/RelationValue<Lorg/instantlogic/engine/presence/User;Lorg/instantlogic/engine/presence/Presence;>;"*/, null);
				mv.visitCode();
				mv.visitVarInsn(ALOAD, 0);
				mv.visitFieldInsn(GETFIELD, className, r.javaIdentifier, "Lorg/instantlogic/fabric/value/RelationValue"+r.getValueSuffix()+";");
				mv.visitInsn(ARETURN);
				mv.visitMaxs(1, 1);
				mv.visitEnd();
			}
			//public org.instantlogic.engine.presence.Presence getPresence() {
			//	return presence.getValue();
			//}
			{
				mv = cw.visitMethod(ACC_PUBLIC, "get"+r.technicalNameCapitalized, "()L"+r.internalTo+";", null, null);
				mv.visitCode();
				mv.visitVarInsn(ALOAD, 0);
				mv.visitFieldInsn(GETFIELD, className, r.javaIdentifier, "Lorg/instantlogic/fabric/value/RelationValue"+r.getValueSuffix()+";");
				mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/RelationValue", "getValue", "()Ljava/lang/Object;");
				mv.visitTypeInsn(CHECKCAST, r.internalTo);
				mv.visitInsn(ARETURN);
				mv.visitMaxs(1, 1);
				mv.visitEnd();
			}
			if (r.multivalue) {
				//public User addToTravelers(Traveler item) {
				//    travelers.addValue(item);
				//    return (User)this;
				//}
				{
					mv = cw.visitMethod(ACC_PUBLIC, "addTo"+r.technicalNameCapitalized, "(L"+r.internalItemClassName+";)L"+concreteClassName+";", null, null);
					mv.visitCode();
					mv.visitVarInsn(ALOAD, 0);
					mv.visitFieldInsn(GETFIELD, className, r.javaIdentifier, "Lorg/instantlogic/fabric/value/RelationValues;");
					mv.visitVarInsn(ALOAD, 1);
					mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/RelationValues", "addValue", "(Ljava/lang/Object;)V");
					mv.visitVarInsn(ALOAD, 0);
					mv.visitTypeInsn(CHECKCAST, concreteClassName);
					mv.visitInsn(ARETURN);
					mv.visitMaxs(2, 2);
					mv.visitEnd();
				}
				//public User removeFromTravelers(Traveler item) {
				//    travelers.removeValue(item);
				//    return (User)this;
				//}
				{
					mv = cw.visitMethod(ACC_PUBLIC, "removeFrom"+r.technicalNameCapitalized, "(L"+r.internalItemClassName+";)L"+concreteClassName+";", null, null);
					mv.visitCode();
					mv.visitVarInsn(ALOAD, 0);
					mv.visitFieldInsn(GETFIELD, className, r.javaIdentifier, "Lorg/instantlogic/fabric/value/RelationValues;");
					mv.visitVarInsn(ALOAD, 1);
					mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/RelationValues", "removeValue", "(Ljava/lang/Object;)V");
					mv.visitVarInsn(ALOAD, 0);
					mv.visitTypeInsn(CHECKCAST, concreteClassName);
					mv.visitInsn(ARETURN);
					mv.visitMaxs(2, 2);
					mv.visitEnd();
				}
			} else {
				//public User setPresence(org.instantlogic.engine.presence.Presence newValue) {
				//    presence.setValue(newValue);
				//    return (User)this;
				//}
				{
					mv = cw.visitMethod(ACC_PUBLIC, "set"+r.technicalNameCapitalized, "(L"+r.internalTo+";)L"+concreteClassName+";", null, null);
					mv.visitCode();
					mv.visitVarInsn(ALOAD, 0);
					mv.visitFieldInsn(GETFIELD, className, r.javaIdentifier, "Lorg/instantlogic/fabric/value/RelationValue;");
					mv.visitVarInsn(ALOAD, 1);
					mv.visitMethodInsn(INVOKEINTERFACE, "org/instantlogic/fabric/value/RelationValue", "setValue", "(Ljava/lang/Object;)V");
					mv.visitVarInsn(ALOAD, 0);
					mv.visitTypeInsn(CHECKCAST, concreteClassName);
					mv.visitInsn(ARETURN);
					mv.visitMaxs(2, 2);
					mv.visitEnd();
				}
			}
		}
		
		cw.visitEnd();

		return cwriter.toByteArray();
	}
}
