package org.instantlogic.designer.codegenerator.jvmbytecode.template;

import java.io.PrintWriter;

import org.instantlogic.designer.codegenerator.classmodel.ApplicationClassModel;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.TraceClassVisitor;

public class ApplicationBytecodeTemplate extends AbstractBytecodeTemplate {

	private static final boolean TRACE = false;

	public static byte[] generate(ApplicationClassModel model, String fullApplicationClassName) {
		ClassWriter cwriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);

		ClassVisitor cw;
		if (TRACE) {
			cw = new TraceClassVisitor(cwriter, new ASMifier(), new PrintWriter(System.out));
		} else {
			cw=cwriter;
		}
		
		FieldVisitor fv;
		MethodVisitor mv;
		
		String concreteClassName = model.getRootPackageInternalPrefix()+model.technicalNameCapitalized+"Application";
		String className = model.isCustomized?model.getRootPackageInternalPrefix()+"Abstract"+model.technicalNameCapitalized+"Application":concreteClassName;
		
		if (model.isCustomized) {
			cw.visit(V1_7, ACC_PUBLIC + ACC_SUPER + ACC_ABSTRACT, className, null, "org/instantlogic/interaction/Application", null);
		} else {
			// public class ??Application extends org.instantlogic.interaction.Application
			cw.visit(V1_7, ACC_PUBLIC + ACC_SUPER, className, null, "org/instantlogic/interaction/Application", null);
		}

		// public static final ??Application INSTANCE ...
		{
			fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "INSTANCE", "L"+concreteClassName+";", null, null);
			fv.visitEnd();
		}
		// private static final String[] THEME_NAMES ...
		{
			fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "THEME_NAMES", "[Ljava/lang/String;", null, null);
			fv.visitEnd();
		}
		
		//	private static final org.instantlogic.interaction.flow.PlaceTemplate[] PLACE_TEMPLATES = new org.instantlogic.interaction.flow.PlaceTemplate[]{
		{
			fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "PLACE_TEMPLATES", "[Lorg/instantlogic/interaction/flow/PlaceTemplate;", null, null);
			fv.visitEnd();
		}
		
		{
			mv = cw.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
			mv.visitCode();
			// INSTANCE = 
			mv.visitTypeInsn(NEW, concreteClassName);
			mv.visitInsn(DUP);
			mv.visitMethodInsn(INVOKESPECIAL, concreteClassName, "<init>", "()V");
			mv.visitFieldInsn(PUTSTATIC, className, "INSTANCE", "L"+concreteClassName+";");
			// THEME_NAMES =
			mv.visitIntInsn(BIPUSH, model.themeNames.length);
			mv.visitTypeInsn(ANEWARRAY, "java/lang/String");
			int index = 0;
			for(String themeName : model.themeNames) { 
				mv.visitInsn(DUP);
				mv.visitIntInsn(BIPUSH, index++);
				mv.visitLdcInsn(themeName);
				mv.visitInsn(AASTORE);
			}
			mv.visitFieldInsn(PUTSTATIC, className, "THEME_NAMES", "[Ljava/lang/String;");

			index = 0;
			mv.visitIntInsn(BIPUSH, model.placeTemplates.size());
			mv.visitTypeInsn(ANEWARRAY, "org/instantlogic/interaction/flow/PlaceTemplate");			
			for (String placeTemplate:model.placeTemplates) {
				mv.visitInsn(DUP);
				mv.visitIntInsn(BIPUSH, index++);
				emitGetInstanceField(mv, model.getRootPackageInternalPrefix()+"placetemplate/", placeTemplate+"PlaceTemplate");
				mv.visitInsn(AASTORE);
			}
			mv.visitFieldInsn(PUTSTATIC, className, "PLACE_TEMPLATES", "[Lorg/instantlogic/interaction/flow/PlaceTemplate;");
			
			mv.visitInsn(RETURN);
			mv.visitMaxs(0, 0);
			mv.visitEnd();
		}
		
		// protected ??Application()
		{
			mv = cw.visitMethod(ACC_PROTECTED, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/interaction/Application", "<init>", "()V");
			mv.visitInsn(RETURN);
			mv.visitMaxs(0, 0);
			mv.visitEnd();
		}
		
		// public org.instantlogic.fabric.model.Entity<org.instantlogic.example.??.??> getCaseEntity()
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getCaseEntity", "()Lorg/instantlogic/fabric/model/Entity;", "()Lorg/instantlogic/fabric/model/Entity<+Lorg/instantlogic/fabric/Instance;>;", null);
			mv.visitCode();
			if (model.caseEntity==null) {
				mv.visitInsn(ACONST_NULL);
			} else {
				String caseEntity = model.getRootPackageInternalPrefix()+"entity/"+model.caseEntity+"Entity";
				mv.visitFieldInsn(GETSTATIC, caseEntity, "INSTANCE", "L"+caseEntity+";");
			}
			mv.visitInsn(ARETURN);
			mv.visitMaxs(0, 0);
			mv.visitEnd();
		}

		if (model.getMainFlow()!=null) {
			{
				mv = cw.visitMethod(ACC_PUBLIC, "getMainFlow", "()Lorg/instantlogic/interaction/flow/Flow;", null, null);
				mv.visitCode();
				mv.visitFieldInsn(GETSTATIC, model.getRootPackageInternalPrefix()+"flow/"+model.getMainFlow()+"Flow", "INSTANCE", "L"+model.getRootPackageInternalPrefix()+"flow/"+model.getMainFlow()+"Flow;");
				mv.visitInsn(ARETURN);
				mv.visitMaxs(0, 0);
				mv.visitEnd();
			}
		}
		if (model.startEvent!=null) {
			// public org.instantlogic.interaction.flow.FlowEvent getStartEvent()
			{
				mv = cw.visitMethod(ACC_PUBLIC, "getStartEvent", "()Lorg/instantlogic/interaction/flow/FlowEvent;", null, null);
				mv.visitCode();
				emitGetInstanceField(mv, model.getRootPackageInternalPrefix()+"event/", model.startEvent+"Event");
				mv.visitInsn(ARETURN);
				mv.visitMaxs(1, 1);
				mv.visitEnd();
			}
		}
		if (model.loggedInEvent!=null) {
			// public org.instantlogic.interaction.flow.FlowEvent getLoggedInEvent()
			{
				mv = cw.visitMethod(ACC_PUBLIC, "getLoggedInEvent", "()Lorg/instantlogic/interaction/flow/FlowEvent;", null, null);
				mv.visitCode();
				emitGetInstanceField(mv, model.getRootPackageInternalPrefix()+"event/", model.loggedInEvent+"Event");
				mv.visitInsn(ARETURN);
				mv.visitMaxs(1, 1);
				mv.visitEnd();
			}
		}
		if (model.startPlace!=null) {
			// public org.instantlogic.interaction.flow.PlaceTempalte getStartPlace()
			{
				mv = cw.visitMethod(ACC_PUBLIC, "getStartPlace", "()Lorg/instantlogic/interaction/flow/PlaceTemplate;", null, null);
				mv.visitCode();
				emitGetInstanceField(mv, model.getRootPackageInternalPrefix()+"placetemplate/", model.startPlace+"PlaceTemplate");
				mv.visitInsn(ARETURN);
				mv.visitMaxs(1, 1);
				mv.visitEnd();
			}
		}
		if (model.loggedInPlace!=null) {
			// public org.instantlogic.interaction.flow.PlaceTemplate getLoggedInPlace()
			{
				mv = cw.visitMethod(ACC_PUBLIC, "getLoggedInPlace", "()Lorg/instantlogic/interaction/flow/PlaceTemplate;", null, null);
				mv.visitCode();
				emitGetInstanceField(mv, model.getRootPackageInternalPrefix()+"placetemplate/", model.loggedInPlace+"PlaceTemplate");
				mv.visitInsn(ARETURN);
				mv.visitMaxs(1, 1);
				mv.visitEnd();
			}
		}
		// public String[] getThemeNames()
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getThemeNames", "()[Ljava/lang/String;", null, null);
			mv.visitCode();
			mv.visitFieldInsn(GETSTATIC, className, "THEME_NAMES", "[Ljava/lang/String;");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(0, 0);
			mv.visitEnd();
		}
		
		// public org.instantlogic.interaction.flow.PlaceTemplate[] getPlaceTemplates()
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getPlaceTemplates", "()[Lorg/instantlogic/interaction/flow/PlaceTemplate;", null, null);
			mv.visitCode();
			mv.visitFieldInsn(GETSTATIC, className, "PLACE_TEMPLATES", "[Lorg/instantlogic/interaction/flow/PlaceTemplate;");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}		
		
		// public String getName()
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getName", "()Ljava/lang/String;", null, null);
			mv.visitCode();
			mv.visitLdcInsn(model.name);
			mv.visitInsn(ARETURN);
			mv.visitMaxs(0, 0);
			mv.visitEnd();
		}
		cw.visitEnd();

		return cwriter.toByteArray();
	}
}
