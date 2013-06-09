package org.instantlogic.designer.codegenerator.javacode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.instantlogic.designer.codegenerator.classmodel.AbstractClassModel;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public abstract class AbstractJavacodeGenerator {

	static Configuration freemarkerConfig;
	public static Template subFlowTemplate;
	public static Template placeTemplateTemplate;
	public static Template eventTemplate;
	public static Template pageFragmentTemplate;
	public static Template flowTemplate;
	public static Template applicationTemplate;
	public static Template instanceTemplate;
	public static Template entityTemplate;
	public static Template validationTemplate;

	static {
		freemarkerConfig = new Configuration();
		freemarkerConfig.setClassForTemplateLoading(AbstractJavacodeGenerator.class, "template/");
		freemarkerConfig.setObjectWrapper(new DefaultObjectWrapper());
		try {
			entityTemplate = freemarkerConfig.getTemplate("Entity.java.ftl");
			instanceTemplate = freemarkerConfig.getTemplate("Instance.java.ftl");
			applicationTemplate = freemarkerConfig.getTemplate("Application.java.ftl");
			eventTemplate = freemarkerConfig.getTemplate("Event.java.ftl");
			pageFragmentTemplate = freemarkerConfig.getTemplate("PageFragment.java.ftl");
			flowTemplate = freemarkerConfig.getTemplate("Flow.java.ftl");
			placeTemplateTemplate = freemarkerConfig.getTemplate("PlaceTemplate.java.ftl");
			subFlowTemplate = freemarkerConfig.getTemplate("SubFlow.java.ftl");
			validationTemplate = freemarkerConfig.getTemplate("Validation.java.ftl");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	static void generateFile(Template template, AbstractClassModel classModel, String subDirectory, String postfix, File root) {
		Writer writer = null;
		try {
			if (subDirectory!=null) {
				root = new File(root, subDirectory);
				root.mkdirs();
			}
			String prefix = (classModel.isCustomized && template!=entityTemplate)?"Abstract":"";
			File output = new File(root, prefix+classModel.technicalNameCapitalized+postfix+".java");
			writer = new OutputStreamWriter(new FileOutputStream(output), "UTF-8");
			template.process(classModel, writer);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
				}
			}
		}
	}

	static void deleteFile(String subDirectory, AbstractClassModel classModel, String postfix, File root) {
		String prefix = classModel.isCustomized?"Abstract":"";
		new File(new File(root, subDirectory), prefix + classModel.technicalNameCapitalized + postfix + ".java").delete();
	}
	
	protected static void purge(File dir) {
		if (dir==null) return;
		for( File file : dir.listFiles()) {
			if (file.isDirectory()) {
				purge(file);
			}
			if (!file.delete()) throw new RuntimeException("Could not delete "+file.getAbsolutePath());
		}
	}
}
