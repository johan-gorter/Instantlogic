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

import org.instantlogic.designer.codegenerator.classmodel.SubFlowClassModel;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.CheckClassAdapter;
import org.objectweb.asm.util.TraceClassVisitor;

public class SubFlowBytecodeTemplate extends AbstractBytecodeTemplate {
	
	public static final boolean TRACE = false;

	public static byte[] generate(SubFlowClassModel model) {
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

		String className = model.getRootPackageInternalPrefix()+ "flow/" + model.flowname + "/" + model.technicalNameCapitalized+"SubFlow";

		cw.visit(V1_7, ACC_PUBLIC + ACC_SUPER, className, null, "org/instantlogic/interaction/flow/SubFlow", null);

		// public static final HomeEvent
		{
			fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "INSTANCE", "L"+className+";", null, null);
			fv.visitEnd();
		}

		{
			mv = cw.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
			mv.visitCode();
			
			// INSTANCE = new IssueSubFlow();
			mv.visitTypeInsn(NEW, className);
			mv.visitInsn(DUP);
			mv.visitMethodInsn(INVOKESPECIAL, className, "<init>", "()V");
			mv.visitFieldInsn(PUTSTATIC, className, "INSTANCE", "L"+className+";");

			mv.visitInsn(RETURN);
			mv.visitMaxs(9, 99);
			mv.visitEnd();
		}
		// Default synthetic constructor
		{
			mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/interaction/flow/SubFlow", "<init>", "()V");
			mv.visitInsn(RETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}

		//public org.instantlogic.interaction.flow.Flow getFlow() {
		//	return org.instantlogic.example.izzy.flow.IssueFlow.INSTANCE;
		//}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getFlow", "()Lorg/instantlogic/interaction/flow/Flow;", null, null);
			mv.visitCode();
			emitGetInstanceField(mv, model.getRootPackageInternalPrefix()+"flow/", model.subFlowName+"Flow");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		//public String getName() {
		//	return "issue";
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
