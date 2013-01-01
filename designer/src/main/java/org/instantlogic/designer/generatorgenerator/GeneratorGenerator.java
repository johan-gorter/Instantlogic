package org.instantlogic.designer.generatorgenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.fabric.value.Multi;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

/**
 * The purpose of this is to create 'ugly' 'bootstrapping'-generator code from a designer model.
 * This is probably never to be used again.
 */
public class GeneratorGenerator {
	
	public static class SpecialFreemarkerWrapper extends DefaultObjectWrapper {
		
		@SuppressWarnings("rawtypes")
		@Override
		public TemplateModel wrap(Object obj) throws TemplateModelException {
			if (obj instanceof Multi) {
				return super.wrap(((Multi)obj).asList());
			}
			return super.wrap(obj);
		}
		
	}
	
	private ApplicationDesign applicationDesign;

	private File rootSourcesPath;

	static Configuration freemarkerConfig;
	public static Template entityTemplate;
	public static Template applicationTemplate;

	static {
		freemarkerConfig = new Configuration();
		freemarkerConfig.setClassForTemplateLoading(GeneratorGenerator.class,"");
		freemarkerConfig.setObjectWrapper(new SpecialFreemarkerWrapper());
		try {
			entityTemplate = freemarkerConfig.getTemplate("Entity.java.ftl");
			applicationTemplate = freemarkerConfig.getTemplate("Application.java.ftl");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public GeneratorGenerator(ApplicationDesign applicationDesign, String generatorSourcesPath) {
		this.applicationDesign = applicationDesign;
		this.rootSourcesPath = new File(generatorSourcesPath);
	}
	

	public void generate() {
		if (!rootSourcesPath.exists()) {
			rootSourcesPath.mkdirs();
		}
		generateFile(applicationTemplate, applicationDesign, applicationDesign.getName(), "ApplicationGenerator", null);
		for (EntityDesign entity : this.applicationDesign.getEntities()) {
			generateFile(entityTemplate, entity, entity.getName(),"EntityGenerator", null);
		}
	}
	
	private void generateFile(Template template, Object model, String name, String suffix, String subDirectory) {
		Writer writer = null;
		try {
			File root = rootSourcesPath;
			if (subDirectory!=null) {
				root = new File(root, subDirectory);
				root.mkdirs();
			}
			File output = new File(root, name+suffix+".java");
			writer = new OutputStreamWriter(new FileOutputStream(output), "UTF-8");
			template.process(model, writer);
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
}
