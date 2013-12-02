package org.instantlogic.designer.codegenerator.jvmbytecode.template;

import java.io.PrintWriter;

import org.instantlogic.designer.codegenerator.classmodel.DeductionSchemeModel;
import org.instantlogic.designer.codegenerator.classmodel.PlaceTemplateClassModel;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.CheckClassAdapter;
import org.objectweb.asm.util.TraceClassVisitor;

public class PlaceTemplateBytecodeTemplate extends AbstractBytecodeTemplate {
	
	public static final boolean TRACE = false;

	public static byte[] generate(PlaceTemplateClassModel model) {
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

		String subPackageName = model.flowname==null?"placetemplate":"flow/"+model.flowname.toLowerCase();
		
		String concreteClassName = model.getRootPackageInternalPrefix()+subPackageName+ "/"+ model.technicalNameCapitalized+"PlaceTemplate";
		String className = model.isCustomized?model.getRootPackageInternalPrefix()+subPackageName+ "/Abstract" + model.technicalNameCapitalized+"PlaceTemplate":concreteClassName;

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

		//	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
		//		org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE,
		//	};
		{
			fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "PARAMETERS", "[Lorg/instantlogic/fabric/model/Entity;", null, null);
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
			if (model.content!=null) {
				dumpContent(mv, className, model.content);
			} else {
				mv.visitInsn(ACONST_NULL);
			}
			mv.visitFieldInsn(PUTSTATIC, className, "CONTENT", "Lorg/instantlogic/interaction/page/FragmentTemplate;");

			if (model.title!=null) {
				// TITLE = new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction3()).add("'s dashboard").getTextTemplate();
				dumpText(mv, className, model.title);
				mv.visitFieldInsn(PUTSTATIC, className, "TITLE", "Lorg/instantlogic/fabric/text/TextTemplate;");
			}
			
			mv.visitIntInsn(BIPUSH, model.parameters.size());
			mv.visitTypeInsn(ANEWARRAY, "org/instantlogic/fabric/model/Entity");
			
			int i = 0;
			for (String parameter:model.parameters) {
				mv.visitInsn(DUP);
				mv.visitIntInsn(BIPUSH, i);
				//Better use: emitGetInstanceField(mv, flowPackage, node.name+node.type);
				mv.visitFieldInsn(GETSTATIC, model.getRootPackageInternalPrefix()+"entity/"+parameter+"Entity", "INSTANCE", "L"+model.getRootPackageInternalPrefix()+"entity/"+parameter+"Entity;");
				mv.visitInsn(AASTORE);
				i++;
			}			
			mv.visitFieldInsn(PUTSTATIC, className, "PARAMETERS", "[Lorg/instantlogic/fabric/model/Entity;");
			
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

		//public String getTechnicalName() {
		//    return "Dashboard";
		//}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getTechnicalName", "()Ljava/lang/String;", null, null);
			mv.visitCode();
			mv.visitLdcInsn(model.technicalNameCapitalized);
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		
//		@Override
//		public org.instantlogic.fabric.model.Entity[] getParameters() {
//			return PARAMETERS;
//		}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getParameters", "()[Lorg/instantlogic/fabric/model/Entity;", null, null);
			mv.visitCode();
			mv.visitFieldInsn(GETSTATIC, className, "PARAMETERS", "[Lorg/instantlogic/fabric/model/Entity;");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}

		
		cw.visitEnd();
		return cwriter.toByteArray();
	}
}
