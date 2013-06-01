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

import org.instantlogic.designer.codegenerator.classmodel.FlowClassModel;
import org.instantlogic.designer.codegenerator.classmodel.FlowClassModel.FlowEdge;
import org.instantlogic.designer.codegenerator.classmodel.FlowClassModel.FlowNode;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.CheckClassAdapter;
import org.objectweb.asm.util.TraceClassVisitor;

public class FlowBytecodeTemplate extends AbstractBytecodeTemplate {
	
	public static final boolean TRACE = false;

	public static byte[] generate(FlowClassModel model) {
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

		String concreteClassName = model.getRootPackageInternalPrefix()+"flow/"+ model.technicalNameCapitalized+"Flow";
		String className = model.isCustomized?model.getRootPackageInternalPrefix()+"flow/Abstract" + model.technicalNameCapitalized+"Flow":concreteClassName;
		String flowPackage = model.getRootPackageInternalPrefix()+"flow/"+model.technicalNameCapitalized.toLowerCase()+"/";

		cw.visit(V1_7, ACC_PUBLIC + ACC_SUPER, className, null, "org/instantlogic/interaction/flow/impl/SimpleFlow", null);

		//public static final MainFlow INSTANCE = new MainFlow();
		{
			fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "INSTANCE", "L"+concreteClassName+";", null, null);
			fv.visitEnd();
		}
		{
			fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "NODES", "[Lorg/instantlogic/interaction/flow/FlowNodeBase;", null, null);
			fv.visitEnd();
		}
		{
			fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "EDGES", "[Lorg/instantlogic/interaction/flow/FlowEdge;", null, null);
			fv.visitEnd();
		}
		{
			fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "PARAMETERS", "[Lorg/instantlogic/fabric/model/Entity;", null, null);
			fv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
			mv.visitCode();
			mv.visitTypeInsn(NEW, concreteClassName);
			mv.visitInsn(DUP);
			mv.visitMethodInsn(INVOKESPECIAL, concreteClassName, "<init>", "()V");
			mv.visitFieldInsn(PUTSTATIC, className, "INSTANCE", "L"+concreteClassName+";");
			mv.visitIntInsn(BIPUSH, model.nodes.size());
			mv.visitTypeInsn(ANEWARRAY, "org/instantlogic/interaction/flow/FlowNodeBase");
			
			int i = 0;
			for (FlowNode node:model.nodes) {
				mv.visitInsn(DUP);
				mv.visitIntInsn(BIPUSH, i);
				emitGetInstanceField(mv, flowPackage, node.name+node.type);
				mv.visitInsn(AASTORE);
				i++;
			}
			
			mv.visitFieldInsn(PUTSTATIC, className, "NODES", "[Lorg/instantlogic/interaction/flow/FlowNodeBase;");

			mv.visitIntInsn(BIPUSH, model.edges.size());
			mv.visitTypeInsn(ANEWARRAY, "org/instantlogic/interaction/flow/FlowEdge");

			i = 0;
			for (FlowEdge edge:model.edges) {
				mv.visitInsn(DUP);
				mv.visitIntInsn(BIPUSH, i);
				mv.visitTypeInsn(NEW, "org/instantlogic/interaction/flow/FlowEdge");
				mv.visitInsn(DUP);
				emitGetInstanceField(mv, flowPackage, edge.startNode);
				emitGetInstanceField(mv, model.getRootPackageInternalPrefix() +"event/", edge.event+"Event");
				emitGetInstanceField(mv, flowPackage, edge.endNode);
				mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/interaction/flow/FlowEdge", "<init>", "(Lorg/instantlogic/interaction/flow/FlowNodeBase;Lorg/instantlogic/interaction/flow/FlowEvent;Lorg/instantlogic/interaction/flow/FlowNodeBase;)V");
				mv.visitInsn(AASTORE);
				i++;
			}
			mv.visitFieldInsn(PUTSTATIC, className, "EDGES", "[Lorg/instantlogic/interaction/flow/FlowEdge;");

			mv.visitIntInsn(BIPUSH, model.parameters.size());
			mv.visitTypeInsn(ANEWARRAY, "org/instantlogic/fabric/model/Entity");
			i = 0;
			for (String parameter:model.parameters) {
				mv.visitInsn(DUP);
				mv.visitIntInsn(BIPUSH, i);
				mv.visitFieldInsn(GETSTATIC, model.getRootPackageInternalPrefix()+"entity/"+parameter+"Entity", "INSTANCE", "L"+model.getRootPackageInternalPrefix()+"entity/"+parameter+"Entity;");
				mv.visitInsn(AASTORE);
				i++;
			}
			
			mv.visitFieldInsn(PUTSTATIC, className, "PARAMETERS", "[Lorg/instantlogic/fabric/model/Entity;");

			mv.visitInsn(RETURN);
			mv.visitMaxs(8, 0);
			mv.visitEnd();
		}
		
		// Default synthetic constructor
		{
			mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/interaction/flow/impl/SimpleFlow", "<init>", "()V");
			mv.visitInsn(RETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		
		// The rest...
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getName", "()Ljava/lang/String;", null, null);
			mv.visitCode();
			mv.visitLdcInsn(model.getName());
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getNodes", "()[Lorg/instantlogic/interaction/flow/FlowNodeBase;", null, null);
			mv.visitCode();
			mv.visitFieldInsn(GETSTATIC, className, "NODES", "[Lorg/instantlogic/interaction/flow/FlowNodeBase;");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getEdges", "()[Lorg/instantlogic/interaction/flow/FlowEdge;", null, null);
			mv.visitCode();
			mv.visitFieldInsn(GETSTATIC, className, "EDGES", "[Lorg/instantlogic/interaction/flow/FlowEdge;");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
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
