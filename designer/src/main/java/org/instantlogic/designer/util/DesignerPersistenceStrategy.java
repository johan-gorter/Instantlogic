package org.instantlogic.designer.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.codegenerator.generator.BackgroundThreadGeneratedClassModelsProcessor;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModelsProcessor;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;
import org.instantlogic.designer.codegenerator.jvmbytecode.ApplicationBytecodeGenerator;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.InstanceStorageInfo;
import org.instantlogic.fabric.util.InstanceStorageInfo.AttributeValueNode;
import org.instantlogic.fabric.util.InstanceStorageInfo.InstanceNode;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeEvent.MultiValueUpdateType;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;
import org.instantlogic.fabric.value.Values;
import org.instantlogic.fabric.value.WriteableAttributeValue;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.DesignerApplicationEnvironment;
import org.instantlogic.tools.persistence.json.FileCasePersister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DesignerPersistenceStrategy extends FileCasePersister {
	
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	
	private static final Logger logger = LoggerFactory.getLogger(DesignerPersistenceStrategy.class);

	private DesignerApplicationEnvironment applicationEnvironment;
	
	public DesignerPersistenceStrategy(DesignerApplicationEnvironment applicationEnvironment) {
		this.applicationEnvironment = applicationEnvironment;
	}

	@Override
	protected File getCaseDir(Application application, String caseId) {
		return new File(applicationEnvironment.getApplicationRoot(caseId), "src/main/instantlogic-designs");
	}

	@Override
	public Instance loadOrCreate(String caseId, Class<? extends Instance> ofType, Application application) {
		Instance result = super.loadOrCreate(caseId, ofType, application);

		ApplicationDesign applicationDesign = (ApplicationDesign)result;
		
		ApplicationBytecodeGenerator applicationBytecodeGenerator = new ApplicationBytecodeGenerator((DesignerApplicationEnvironment)applicationEnvironment, // Generate bytecode 
			new BackgroundThreadGeneratedClassModelsProcessor(
				new ApplicationJavacodeGenerator(new File(new File("../webapps", applicationDesign.getName()), "target/generated-sources/instantlogic-app").getAbsoluteFile()) // Generate java code
			)
		);
		
		// Generate bytecode once synchronously, and afterward asynchronously
		applicationBytecodeGenerator.process(applicationDesign.getApplicationGenerator().getClassModelUpdates());
		
		applicationDesign.setGeneratedClassModelsProcessor(
			new BackgroundThreadGeneratedClassModelsProcessor(
				applicationBytecodeGenerator
			)
		);
		
		return result;
		// TODO: cleanup
	}
	
	@Override
	public void persist(String id, Instance caseInstance, int version, Application application, List<ValueChangeEvent> events) {
		
		save(caseInstance, getCaseDir(application, id), events);
		
		ApplicationDesign applicationDesign = (ApplicationDesign)caseInstance;
		GeneratedClassModelsProcessor generatedClassModelsProcessor = applicationDesign.getGeneratedClassModelsProcessor();
		if (generatedClassModelsProcessor!=null) {
			GeneratedClassModels classModelUpdates = applicationDesign.getApplicationGenerator().getClassModelUpdates();
			int updates = classModelUpdates.countUpdates();
			int deletes = classModelUpdates.countDeletes();
			if (updates>0 || deletes>0) {
				logger.info("Updated {} class models and deleted {} class models", updates, deletes);
				generatedClassModelsProcessor.process(classModelUpdates);
			}
		}
	}

	public void save(Instance instance, File dir, List<ValueChangeEvent> events) {
		List<InstanceStorageInfo> instancesToSave = new ArrayList<>();
		List<InstanceStorageInfo> instancesToDelete = new ArrayList<>();
		if (instance.getMetadata().getStorageInfo() == null) {
			// Has never been saved yet
			initInstanceToStorage(instance, null, instancesToSave);
		} else {
			for (ValueChangeEvent event : events) {
				if (event.isMultivalueUpdate() && event.getInstance().getMetadata().getInstanceOwner()==null && event.getAttribute() instanceof Relation) {
					// Add/remove a file
					Instance value = (Instance) event.getNewStoredValue();
					if (event.getMultiValueUpdateType()== MultiValueUpdateType.DELETE) {
						if (value.getMetadata().getStorageInfo()!=null) {
							instancesToDelete.add(value.getMetadata().getStorageInfo());
						}
					}
					if (event.getMultiValueUpdateType()== MultiValueUpdateType.INSERT) {
						initInstanceToStorage(value, event.getAttribute().getName(), instancesToSave);
					}
				} else {
					// Find the storageInfo to save and modify it
					// TODO
				}
			}
		}
		for(InstanceStorageInfo storageInfo: instancesToSave) {
			File subDir = storageInfo.subDirectory==null?dir:new File(dir, storageInfo.subDirectory);
			if (!subDir.exists()) {
				subDir.mkdirs();
			}
			File tmpFile = new File(subDir, storageInfo.fileName+".tmp");
			try {
				try (
					FileOutputStream stream = new FileOutputStream(tmpFile);
					OutputStreamWriter writer = new OutputStreamWriter(stream, "UTF-8")
				) {
					writeInstance(writer, storageInfo.rootNode);
				}
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
			File targetFile = new File(subDir, storageInfo.fileName);
			if (targetFile.exists()) {
				targetFile.delete();
			}
			tmpFile.renameTo(targetFile);
		}
	}

	private void initInstanceToStorage(Instance instance, String subDirectory, List<InstanceStorageInfo> results) {
		InstanceStorageInfo instanceStorage = new InstanceStorageInfo();
		instance.getMetadata().setStorageInfo(instanceStorage);
		results.add(instanceStorage);
		instanceStorage.subDirectory = subDirectory;
		instanceStorage.rootNode = initInstanceNode(instance, results);
		instanceStorage.fileName = instance.getMetadata().getUniqueId()+".design";
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private InstanceNode initInstanceNode(Instance instance, List<InstanceStorageInfo> results) {
		InstanceNode node = new InstanceStorageInfo.InstanceNode();
		node.entityName = instance.getMetadata().getEntity().getName();
		node.uniqueId = instance.getMetadata().getUniqueId();
		
		for (Attribute attribute : instance.getMetadata().getEntity().getAttributes()) {
			if (!attribute.isReadOnly()) {
				AttributeValueNode attributeNode = new AttributeValueNode();
				attributeNode.attributeName = attribute.getName();
				node.attributes.add(attributeNode);
				ReadOnlyAttributeValue attributeValue = attribute.get(instance);
				if (attribute.isMultivalue()) {
					attributeNode.multivalue = true;
					
					for (Object value : (Values)attributeValue.getValue()) {
						attributeNode.values.add(gson.toJson(value));
					}
					
				} else {
					Object value = ((WriteableAttributeValue)attributeValue).getStoredValue();
					if (value!=null) {
						attributeNode.values.add(gson.toJson(value));
					}
				}
			}
		}
		
		for (Relation relation : instance.getMetadata().getEntity().getRelations()) {
			ReadOnlyAttributeValue attributeValue = relation.get(instance);
			if (relation.isOwner() && relation.isMultivalue() && instance.getMetadata().getInstanceOwner()==null) {
				// Move each entry to a file of its own
				for (Instance value : (Values<Instance>)attributeValue.getValue()) {
					initInstanceToStorage(value, relation.getName(), results);
				}
			} else {
				AttributeValueNode attributeNode = new AttributeValueNode();
				attributeNode.attributeName = relation.getName();
				node.attributes.add(attributeNode);
				if (relation.isOwner()) {
					if (relation.isMultivalue()) {
						attributeNode.multivalue = true;
						for (Instance value : (Values<Instance>)attributeValue.getValue()) {
							InstanceNode subInstance = initInstanceNode(value, null);
							attributeNode.subInstances.add(subInstance);
						}
					} else {
						Instance value = (Instance)attributeValue.getValue();
						if (value!=null) {
							InstanceNode subInstance = initInstanceNode(value, null);
							attributeNode.subInstances.add(subInstance);
						}
					}
				} else {
					if (relation.isMultivalue()) {
						attributeNode.multivalue = true;
						for (Instance value : (Values<Instance>)attributeValue.getValue()) {
							attributeNode.values.add("\""+value.getMetadata().getUniqueId()+"\"");
						}
					} else {
						if (!relation.isReadOnly()) {
							Instance value = (Instance)((WriteableAttributeValue)attributeValue).getStoredValue();
							if (value!=null) {
								attributeNode.values.add("\""+value.getMetadata().getUniqueId()+"\"");
							}
						}
					}
				}
			}
		}
		
		return node;
	}

	private void writeInstance(OutputStreamWriter writer, InstanceNode rootNode) throws IOException {
		String prefix = rootNode.uniqueId+" ";
		writer.write(prefix);
		writer.write(rootNode.uniqueId);
		writer.write(":");
		writer.write(rootNode.entityName);
		writer.write("{\n");
		
		writeAttributes(writer, rootNode, prefix+" ", "   ");
		
		writer.write(prefix);
		writer.write("}");
		writer.write(rootNode.uniqueId);
		writer.write("\n");
	}

	private void writeAttributes(OutputStreamWriter writer, InstanceNode rootNode, String prefix, String nextIndent) throws IOException {
		for (AttributeValueNode attribute : rootNode.attributes) {
			if (attribute.multivalue) {
				writer.write(prefix);
				writer.write(attribute.attributeName);
				writer.write("[\n");
				
				for (String value : attribute.values) {
					writer.write(prefix);
					writer.write(attribute.attributeName);
					writer.write("+");
					writer.write(value);
					writer.write("\n");
				}
				
				for (InstanceNode subInstance : attribute.subInstances) {
					writer.write(prefix);
					writer.write(attribute.attributeName);
					writer.write("+");
					writer.write(subInstance.uniqueId);
					writer.write(":");
					writer.write(subInstance.entityName);
					writer.write("{\n");
					
					
					writeAttributes(writer, subInstance, subInstance.uniqueId+nextIndent, nextIndent+" ");

					writer.write(prefix);
					writer.write("}");
					writer.write(subInstance.uniqueId);
					writer.write("\n");
				}
				
				writer.write(prefix);
				writer.write(attribute.attributeName);
				writer.write("]\n");
			} else {
				writer.write(prefix);
				writer.write(attribute.attributeName);
				if (attribute.values.size()>0) {
					writer.write("=");
					writer.write(attribute.values.get(0));
				}
				writer.write("\n");
			}
		}
	}
}
