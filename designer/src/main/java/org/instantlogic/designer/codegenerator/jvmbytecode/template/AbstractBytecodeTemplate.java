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

import org.objectweb.asm.*;

public class AbstractBytecodeTemplate implements Opcodes {

	protected static String upperFirst(String name) {
		return name.substring(0,1).toUpperCase()+name.substring(1);
	}
	
	protected static void throwUnsupported(MethodVisitor mv) {
		mv.visitTypeInsn(NEW, "java/lang/UnsupportedOperationException");
		mv.visitInsn(DUP);
		mv.visitMethodInsn(INVOKESPECIAL, "java/lang/UnsupportedOperationException", "<init>", "()V");
		mv.visitInsn(ATHROW);
	}
}
