package org.instantlogic.designer.codegenerator.jvmbytecode.template;

import java.io.PrintWriter;

import org.instantlogic.designer.codegenerator.classmodel.DeductionSchemeModel;
import org.instantlogic.designer.codegenerator.classmodel.SharedPageFragmentClassModel;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.CheckClassAdapter;
import org.objectweb.asm.util.TraceClassVisitor;

public class SharedPageFragmentBytecodeTemplate extends AbstractBytecodeTemplate {
	
	public static final boolean TRACE = false;

	public static byte[] generate(SharedPageFragmentClassModel model) {
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

		String concreteClassName = model.getRootPackageInternalPrefix()+"sharedpagefragment/"+ model.technicalNameCapitalized+"PageFragment";
		String className = model.isCustomized?model.getRootPackageInternalPrefix()+"sharedpagefragment/Abstract" + model.technicalNameCapitalized+"PageFragment":concreteClassName;

		cw.visit(V1_7, ACC_PUBLIC + ACC_SUPER, className, null, "org/instantlogic/interaction/page/SharedElement", null);

		// public static IssueRowPageFragment INSTANCE
		{
			fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "INSTANCE", "L"+concreteClassName+";", null, null);
			fv.visitEnd();
		}
		
		// public static final org.instantlogic.interaction.page.Element SHARED_INSTANCE
		{
			fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "SHARED_INSTANCE", "Lorg/instantlogic/interaction/page/Element;", null, null);
			fv.visitEnd();
		}

		{
			mv = cw.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
			mv.visitCode();
			
			// INSTANCE = new ...
			mv.visitTypeInsn(NEW, concreteClassName);
			mv.visitInsn(DUP);
			mv.visitMethodInsn(INVOKESPECIAL, concreteClassName, "<init>", "()V");
			mv.visitFieldInsn(PUTSTATIC, className, "INSTANCE", "L"+concreteClassName+";");

			// SHARED_INSTANCE = 
			dumpContent(mv, className, model.content);
			mv.visitFieldInsn(PUTSTATIC, "org/instantlogic/example/izzy/sharedpagefragment/IssueRowPageFragment", "SHARED_INSTANCE", "Lorg/instantlogic/interaction/page/Element;");

			
			// INSTANCE.setElement(SHARED_INSTANCE);
			mv.visitFieldInsn(GETSTATIC, "org/instantlogic/example/izzy/sharedpagefragment/IssueRowPageFragment", "INSTANCE", "Lorg/instantlogic/example/izzy/sharedpagefragment/IssueRowPageFragment;");
			mv.visitFieldInsn(GETSTATIC, "org/instantlogic/example/izzy/sharedpagefragment/IssueRowPageFragment", "SHARED_INSTANCE", "Lorg/instantlogic/interaction/page/Element;");
			mv.visitMethodInsn(INVOKEVIRTUAL, "org/instantlogic/example/izzy/sharedpagefragment/IssueRowPageFragment", "setElement", "(Lorg/instantlogic/interaction/page/Element;)V");

			
			mv.visitInsn(RETURN);
			mv.visitMaxs(99, 9);
			mv.visitEnd();
		}

		// protected IssueRowPageFragment() {
		//    INSTANCE=this;
		// }
		{
			mv = cw.visitMethod(ACC_PROTECTED, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/interaction/page/SharedElement", "<init>", "()V"); //TODO: if (abstract) everywhere!
			mv.visitVarInsn(ALOAD, 0);
			mv.visitFieldInsn(PUTSTATIC, className, "INSTANCE", "L"+concreteClassName+";");
			mv.visitInsn(RETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}		
		
		//Deductions
		for (DeductionSchemeModel scheme : model.getDeductionSchemes()) {
			dumpDeductionScheme(cw, scheme);
		}
		
		cw.visitEnd();
		return cwriter.toByteArray();
	}
}
