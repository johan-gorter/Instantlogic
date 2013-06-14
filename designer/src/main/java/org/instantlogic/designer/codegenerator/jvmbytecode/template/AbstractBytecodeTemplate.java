package org.instantlogic.designer.codegenerator.jvmbytecode.template;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.instantlogic.designer.codegenerator.classmodel.ContentModel;
import org.instantlogic.designer.codegenerator.classmodel.DeductionModel;
import org.instantlogic.designer.codegenerator.classmodel.DeductionModel.Parameter;
import org.instantlogic.designer.codegenerator.classmodel.DeductionSchemeModel;
import org.instantlogic.designer.codegenerator.classmodel.TextModel;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

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
	
	protected static void emitReturnTrue(ClassWriter cw, String methodName) {
		{
			MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, methodName, "()Z", null, null);
			mv.visitCode();
			mv.visitInsn(ICONST_1);
			mv.visitInsn(IRETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}			
	}
	
	protected static void dumpDeductionScheme(ClassVisitor cw, DeductionSchemeModel scheme) {
		List<Label> labels = new ArrayList<Label>();
		MethodVisitor mv = cw.visitMethod(ACC_PRIVATE + ACC_STATIC, "createDeduction"+scheme.index, "()Lorg/instantlogic/fabric/deduction/Deduction;", null, null);
		mv.visitCode();
		int localVariableIndex = 0;
		for (DeductionModel deduction: scheme.deductions) {
			// org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
			mv.visitTypeInsn(NEW, deduction.getInternalClassName());
			mv.visitInsn(DUP);
			mv.visitMethodInsn(INVOKESPECIAL, deduction.getInternalClassName(), "<init>", "()V");
			mv.visitVarInsn(ASTORE, localVariableIndex);
			Label label = new Label();
			mv.visitLabel(label);
			labels.add(label);
			for (Parameter parameter: deduction.getParameters()) {
				// d0.setAttribute(org.instantlogic.example.izzy.entity.ProjectEntity.users);
				mv.visitVarInsn(ALOAD, localVariableIndex);
				parameter.getValue().writeJvmBytecode(mv);
				mv.visitMethodInsn(INVOKEVIRTUAL, deduction.getInternalClassName() , "set"+parameter.name, "(L"+parameter.valueClass.replace('.','/')+";)V");
			}
			localVariableIndex++;
		}
		localVariableIndex = 0;
		for (DeductionModel deduction: scheme.deductions) {
			for (DeductionModel.Input input: deduction.inputs) {
				// d0.setInstance(d1);
				mv.visitVarInsn(ALOAD, localVariableIndex);
				mv.visitVarInsn(ALOAD, input.deductionIndex);
				if (input.multivalue) {
					mv.visitMethodInsn(INVOKEVIRTUAL, deduction.getInternalClassName(), "addTo"+input.getInputName(), "(Lorg/instantlogic/fabric/deduction/Deduction;)V");
				} else {
					mv.visitMethodInsn(INVOKEVIRTUAL, deduction.getInternalClassName(), "set"+input.getInputName(), "(Lorg/instantlogic/fabric/deduction/Deduction;)V");
				}
			}
			localVariableIndex++;
		}
		mv.visitVarInsn(ALOAD, 0);
		mv.visitInsn(ARETURN);
		Label endLabel = new Label();
		mv.visitLabel(endLabel);
		localVariableIndex = 0;
		for (DeductionModel deduction: scheme.deductions) {
			mv.visitLocalVariable("d"+localVariableIndex, "L"+deduction.getInternalClassName()+";", null, labels.get(localVariableIndex), endLabel, localVariableIndex);
			localVariableIndex++;
		}
		mv.visitMaxs(2, localVariableIndex);
		mv.visitEnd();
	}
	
	public static void dumpText(MethodVisitor mv, String className, TextModel text) {
		mv.visitTypeInsn(NEW, "org/instantlogic/fabric/text/TextTemplate");
		mv.visitInsn(DUP);
		mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/fabric/text/TextTemplate", "<init>", "()V");
		mv.visitMethodInsn(INVOKEVIRTUAL, "org/instantlogic/fabric/text/TextTemplate", "getUntranslated", "()Lorg/instantlogic/fabric/text/TextTranslationTemplate;");
		for (TextModel.StringTemplate stringTemplate : text.untranslated) {
			if (stringTemplate.constant!=null) {
				mv.visitLdcInsn(stringTemplate.constant);
				mv.visitMethodInsn(INVOKEVIRTUAL, "org/instantlogic/fabric/text/TextTranslationTemplate", "add", "(Ljava/lang/String;)Lorg/instantlogic/fabric/text/TextTranslationTemplate;");
			} else {
				mv.visitMethodInsn(INVOKESTATIC, className, "createDeduction"+stringTemplate.deductionIndex, "()Lorg/instantlogic/fabric/deduction/Deduction;");
				mv.visitMethodInsn(INVOKEVIRTUAL, "org/instantlogic/fabric/text/TextTranslationTemplate", "add", "(Lorg/instantlogic/fabric/deduction/Deduction;)Lorg/instantlogic/fabric/text/TextTranslationTemplate;");
			}
		}
		mv.visitMethodInsn(INVOKEVIRTUAL, "org/instantlogic/fabric/text/TextTranslationTemplate", "getTextTemplate", "()Lorg/instantlogic/fabric/text/TextTemplate;");
		// TODO: Translations
	}
	
	protected static void emitGetInstanceField(MethodVisitor mv, String packageInternalName, String className) {
		if (className==null) {
			mv.visitInsn(ACONST_NULL);
		} else {
			mv.visitFieldInsn(GETSTATIC, packageInternalName + className, "INSTANCE", "L"+packageInternalName+className+";");
		}
	}
	
	protected static void dumpStringArray(MethodVisitor mv, String[] array) {
		mv.visitIntInsn(BIPUSH, array.length);
		mv.visitTypeInsn(ANEWARRAY, "java/lang/String");
		for (int i = 0;i<array.length;i++) {
			mv.visitInsn(DUP);
			mv.visitIntInsn(BIPUSH, i);
			mv.visitLdcInsn(array[i]);
			mv.visitInsn(AASTORE);
		}
	}

	protected static void dumpContent(MethodVisitor mv, String className, ContentModel content) {
		switch (content.category) {
			case Shared:
				// new org.instantlogic.interaction.page.SharedElementHolder("${content.id}", ${rootPackageName}.sharedpagefragment.${content.name}PageFragment.INSTANCE)
				mv.visitTypeInsn(NEW, "org/instantlogic/interaction/page/SharedElementHolder");
				mv.visitInsn(DUP);
				mv.visitLdcInsn(content.id);
				emitGetInstanceField(mv, content.getRootPackageInternalPrefix()+"sharedpagefragment/", content.name+"PageFragment");
				mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/interaction/page/SharedElementHolder", "<init>", "(Ljava/lang/String;Lorg/instantlogic/interaction/page/SharedElement;)V");
				break;
			case Selection:
				mv.visitTypeInsn(NEW, "org/instantlogic/interaction/page/SelectionElement");
				mv.visitInsn(DUP);
				mv.visitMethodInsn(INVOKESTATIC, className, "createDeduction"+content.deductionIndex, "()Lorg/instantlogic/fabric/deduction/Deduction;");
				dumpContent(mv, className, content.child);
				mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/interaction/page/SelectionElement", "<init>", "(Lorg/instantlogic/fabric/deduction/Deduction;Lorg/instantlogic/interaction/page/Element;)V");
				break;
			case IfElse:
				// new org.instantlogic.interaction.page.IfElseElement(createDeduction2(), ... , ... )
				mv.visitTypeInsn(NEW, "org/instantlogic/interaction/page/IfElseElement");
				mv.visitInsn(DUP);
				mv.visitMethodInsn(INVOKESTATIC, className, "createDeduction"+content.deductionIndex, "()Lorg/instantlogic/fabric/deduction/Deduction;");
				if (content.child!=null) {
					dumpContent(mv, className, content.child);
				} else {
					mv.visitInsn(ACONST_NULL);
				}
				if (content.elseChild!=null) {
					dumpContent(mv, className, content.elseChild);
				} else {
					mv.visitInsn(ACONST_NULL);
				}
				mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/interaction/page/IfElseElement", "<init>", "(Lorg/instantlogic/fabric/deduction/Deduction;Lorg/instantlogic/interaction/page/Element;Lorg/instantlogic/interaction/page/Element;)V");
				break;
			case Fragment:
				// new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__000c", "Page")
				mv.visitTypeInsn(NEW, "org/instantlogic/interaction/page/FragmentTemplate");
				mv.visitInsn(DUP);
				mv.visitLdcInsn(content.id);
				mv.visitLdcInsn(content.fragmentTypeName);
				mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/interaction/page/FragmentTemplate", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V");
				// .setStyleNames(new String[]{"answer-span8"})
				if (content.styleNames!=null) {
					dumpStringArray(mv, content.styleNames);
					mv.visitMethodInsn(INVOKEVIRTUAL, "org/instantlogic/interaction/page/FragmentTemplate", "setStyleNames", "([Ljava/lang/String;)Lorg/instantlogic/interaction/page/FragmentTemplate;");
				}
			    if (content.fragmentFilters!=null) {
			    	for (String fragmentFilter : content.fragmentFilters) {
			    		// .addCustomFilter(new org.instantlogic.designer.fragmentfilter.PreviewFragmentFilter())
			    		fragmentFilter = fragmentFilter.replace('.', '/');
			    		mv.visitTypeInsn(NEW, fragmentFilter);
			    		mv.visitInsn(DUP);
			    		mv.visitMethodInsn(INVOKESPECIAL, fragmentFilter, "<init>", "()V");
			    		mv.visitMethodInsn(INVOKEVIRTUAL, "org/instantlogic/interaction/page/FragmentTemplate", "addCustomFilter", "(Lorg/instantlogic/interaction/page/FragmentFilter;)Lorg/instantlogic/interaction/page/FragmentTemplate;");
			    	}
			    }
			    if (content.event!=null) {
			    	// .setEvent(org.instantlogic.designer.event.NewAttributeForFragmentTemplateEvent.INSTANCE)
			    	emitGetInstanceField(mv, content.getRootPackageInternalPrefix()+"event/", content.event+"Event");
			    	mv.visitMethodInsn(INVOKEVIRTUAL, "org/instantlogic/interaction/page/FragmentTemplate", "setEvent", "(Lorg/instantlogic/interaction/flow/FlowEvent;)Lorg/instantlogic/interaction/page/FragmentTemplate;");
			    }
			    if (content.attribute!=null) {
			    	//.setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.entity)
			    	emitGetInstanceField(mv, content.getRootPackageInternalPrefix()+"entity/", content.entity+"Entity");
			    	mv.visitFieldInsn(GETSTATIC, content.getRootPackageInternalPrefix()+"entity/"+content.entity+"Entity", content.attribute, content.attributeIsRelation?"Lorg/instantlogic/fabric/model/Relation;":"Lorg/instantlogic/fabric/model/Attribute;");  
                    mv.visitMethodInsn(INVOKEVIRTUAL, "org/instantlogic/interaction/page/FragmentTemplate", "setField", "(Lorg/instantlogic/fabric/model/Entity;Lorg/instantlogic/fabric/model/Attribute;)Lorg/instantlogic/interaction/page/FragmentTemplate;");
			    }			    
				for (Map.Entry<String, Integer> entry : content.values.entrySet()) {
					// .putValue("applicationName", createDeduction0()) 
					mv.visitLdcInsn(entry.getKey());
					mv.visitMethodInsn(INVOKESTATIC, className, "createDeduction"+entry.getValue(), "()Lorg/instantlogic/fabric/deduction/Deduction;");
					mv.visitMethodInsn(INVOKEVIRTUAL, "org/instantlogic/interaction/page/FragmentTemplate", "putValue", "(Ljava/lang/String;Lorg/instantlogic/fabric/deduction/Deduction;)Lorg/instantlogic/interaction/page/FragmentTemplate;");
				}
				for (Map.Entry<String, TextModel> entry : content.texts.entrySet()) {
					mv.visitLdcInsn(entry.getKey());
					dumpText(mv, className, entry.getValue());
					mv.visitMethodInsn(INVOKEVIRTUAL, "org/instantlogic/interaction/page/FragmentTemplate", "putText", "(Ljava/lang/String;Lorg/instantlogic/fabric/text/TextTemplate;)Lorg/instantlogic/interaction/page/FragmentTemplate;");
				}
				for (Map.Entry<String, List<ContentModel>> entry : content.childLists.entrySet()) {
					for (ContentModel child : entry.getValue()) {
			            // .addChild("mainContent",
						mv.visitLdcInsn(entry.getKey());
						dumpContent(mv, className, child);
						mv.visitMethodInsn(INVOKEVIRTUAL, "org/instantlogic/interaction/page/FragmentTemplate", "addChild", "(Ljava/lang/String;Lorg/instantlogic/interaction/page/Element;)Lorg/instantlogic/interaction/page/FragmentTemplate;");
					}
				}
				break;
		}
	}
}
