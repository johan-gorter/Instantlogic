package org.instantlogic.designer.codegenerator.jvmbytecode.template;

import java.io.PrintWriter;

import org.instantlogic.designer.codegenerator.classmodel.DeductionSchemeModel;
import org.instantlogic.designer.codegenerator.classmodel.PlaceClassModel;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.CheckClassAdapter;
import org.objectweb.asm.util.TraceClassVisitor;

public class PlaceTemplateBytecodeTemplate extends AbstractBytecodeTemplate {
	
	public static final boolean TRACE = false;

	public static byte[] generate(PlaceClassModel model) {
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

		String concreteClassName = model.getRootPackageInternalPrefix()+"flow/"+model.flowname.toLowerCase()+ "/"+ model.technicalNameCapitalized+"PlaceTemplate";
		String className = model.isCustomized?model.getRootPackageInternalPrefix()+"flow/"+model.flowname.toLowerCase()+ "/Abstract" + model.technicalNameCapitalized+"PlaceTemplate":concreteClassName;

		cw.visit(V1_7, ACC_PUBLIC + ACC_SUPER, className, null, "org/instantlogic/interaction/flow/PlaceTemplate", null);

		// public static final UserEntity INSTANCE 
		{
			fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "INSTANCE", "L"+concreteClassName+";", null, null);
			fv.visitEnd();
		}

		// private static org.instantlogic.interaction.page.FragmentTemplate CONTENT
		{
			fv = cw.visitField(ACC_PRIVATE + ACC_STATIC, "CONTENT", "Lorg/instantlogic/interaction/page/FragmentTemplate;", null, null);
			fv.visitEnd();
		}		
		
		if (model.title!=null)
		{
			// private static final org.instantlogic.fabric.text.TextTemplate TITLE
			{
				fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "TITLE", "Lorg/instantlogic/fabric/text/TextTemplate;", null, null);
				fv.visitEnd();
			}
		}

		{
			mv = cw.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
			mv.visitCode();
			
			// INSTANCE = new DashboardPlaceTemplate();
			mv.visitTypeInsn(NEW, concreteClassName);
			mv.visitInsn(DUP);
			mv.visitMethodInsn(INVOKESPECIAL, concreteClassName, "<init>", "()V");
			mv.visitFieldInsn(PUTSTATIC, className, "INSTANCE", "L"+concreteClassName+";");

			// Phase 2
			
			dumpContent(mv, className, model.content);
			mv.visitFieldInsn(PUTSTATIC, className, "CONTENT", "Lorg/instantlogic/interaction/page/FragmentTemplate;");


			if (model.title!=null) {
				// TITLE = new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction3()).add("'s dashboard").getTextTemplate();
				dumpText(mv, className, model.title);
				mv.visitFieldInsn(PUTSTATIC, className, "TITLE", "Lorg/instantlogic/fabric/text/TextTemplate;");
			}
			
			mv.visitInsn(RETURN);
			mv.visitMaxs(99, 9);
			mv.visitEnd();
		}
		// Default synthetic constructor
		{
			mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/interaction/flow/PlaceTemplate", "<init>", "()V");
			mv.visitInsn(RETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}

		//Deductions
		for (DeductionSchemeModel scheme : model.getDeductionSchemes()) {
			dumpDeductionScheme(cw, scheme);
		}
		
		if (model.title!=null)
		{
			// protected org.instantlogic.fabric.text.TextTemplate getTitle() {
			//	  return TITLE;
			// }
			{
				mv = cw.visitMethod(ACC_PUBLIC, "getTitle", "()Lorg/instantlogic/fabric/text/TextTemplate;", null, null);
				mv.visitCode();
				mv.visitFieldInsn(GETSTATIC, className, "TITLE", "Lorg/instantlogic/fabric/text/TextTemplate;");
				mv.visitInsn(ARETURN);
				mv.visitMaxs(1, 1);
				mv.visitEnd();
			}		
		}
		
		// public String getId() {
		//	return "Placetemplatdsgn__0002";
		// }
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getId", "()Ljava/lang/String;", null, null);
			mv.visitCode();
			mv.visitLdcInsn(model.id);
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}	

		// public org.instantlogic.interaction.page.FragmentTemplate getRootContainer() {
		//	  return CONTENT;
		// }; 
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getRootContainer", "()Lorg/instantlogic/interaction/page/FragmentTemplate;", null, null);
			mv.visitCode();
			mv.visitFieldInsn(GETSTATIC, className, "CONTENT", "Lorg/instantlogic/interaction/page/FragmentTemplate;");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}

		//public String getName() {
		//    return "dashboard";
		//}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getName", "()Ljava/lang/String;", null, null);
			mv.visitCode();
			mv.visitLdcInsn(model.name);
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}		
		
		cw.visitEnd();
		return cwriter.toByteArray();
	}
}
