package org.instantlogic.designer.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.codegenerator.generator.BackgroundThreadGeneratedClassModelsProcessor;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModelsProcessor;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;
import org.instantlogic.designer.codegenerator.jvmbytecode.ApplicationBytecodeGenerator;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.CaseAdministration;
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
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LazilyParsedNumber;

public class DesignerPersistenceStrategy extends FileCasePersister {
	
	private static final Logger logger = LoggerFactory.getLogger(DesignerPersistenceStrategy.class);

	private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	private static final Pattern START_LINE = Pattern.compile("^(\\w+:)?\\s*(\\w+)\\s*:\\s*(\\w+)\\s*\\{\\s*$");
	private static final Pattern DATA_LINE = Pattern.compile("^(\\w+:)?\\s*(\\w+)\\s*([\\[\\+=])\\s*(.*)$");
	private static final Pattern NODATA_LINE = Pattern.compile("^(\\w+:)?\\s*(\\w+)\\s*$");
	private static final Pattern ENTITY_END_LINE = Pattern.compile("^(\\w+:)?\\s*\\}\\s*(\\w+)\\s*$");
	private static final Pattern ENTITY_START_DATA = Pattern.compile("(\\w+)\\s*:\\s*(\\w+)\\s*\\{\\s*$");
	
	private static final FilenameFilter DESIGNS = new FilenameFilter() {
		@Override
		public boolean accept(File dir, String name) {
			return name.toLowerCase().endsWith(".design");
		}
	};

	private DesignerApplicationEnvironment applicationEnvironment;

	private boolean generateCode;
	
	public DesignerPersistenceStrategy(DesignerApplicationEnvironment applicationEnvironment, boolean generateCode) {
		this.applicationEnvironment = applicationEnvironment;
		this.generateCode = generateCode;
	}

	@Override
	protected File getCaseDir(Application application, String caseId) {
		return new File(applicationEnvironment.getApplicationRoot(caseId), "src/main/instantlogic-designs");
	}

	
	// Load
	
	@Override
	public Instance loadOrCreate(String caseId, Class<? extends Instance> ofType, Application application) {
		File dir = getCaseDir(application, caseId);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		InstanceStorageInfo storage = load(dir, caseId);
		
		//TODO: move these to a place where the application reload can take place (also for non-designer applications)
		Instance result = createStructure(storage, application.getAllEntities());
		loadData(result, result.getMetadata().getCaseAdministration());
		
//		OutputStreamWriter osw = new OutputStreamWriter(System.out);
//		super.save(result, osw);
//		try {
//			osw.flush();
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
		
//		Instance result = super.loadOrCreate(caseId, ofType, application);
		
//		result.getMetadata().setStorageInfo(null);
//		save(result, getCaseDir(application, caseId), null);
		
		
		if (generateCode) {
			ApplicationDesign applicationDesign = (ApplicationDesign)result;
			ApplicationBytecodeGenerator applicationBytecodeGenerator = new ApplicationBytecodeGenerator((DesignerApplicationEnvironment)applicationEnvironment, // Generate bytecode 
				new BackgroundThreadGeneratedClassModelsProcessor(
					new ApplicationJavacodeGenerator(new File(dir, "../../../target/generated-sources/instantlogic-app/"+caseId).getAbsoluteFile()) // Generate java code
				)
			);
			
			// Generate bytecode once synchronously, and afterward asynchronously
			applicationBytecodeGenerator.process(applicationDesign.getApplicationGenerator().getClassModelUpdates(), caseId);
			
			applicationDesign.setGeneratedClassModelsProcessor(
				new BackgroundThreadGeneratedClassModelsProcessor(
					applicationBytecodeGenerator
				)
			);
		}
		addPersistTransactionListener(caseId, application, result);
		return result;
		// TODO: cleanup
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void loadData(Instance instance, CaseAdministration caseAdministration) {
		InstanceNode node = instance.getMetadata().getStorageInfo().node;
		for (AttributeValueNode value : node.values) {
			if (value.values.size()>0) {
				Entity<?> entity = instance.getMetadata().getEntity();
				Attribute attribute = entity.tryGetAttribute(value.attributeName);
				if (attribute!=null && !attribute.isReadOnly()) {
					WriteableAttributeValue attributeValue = (WriteableAttributeValue)attribute.get(instance);
					if (attribute.isMultivalue()) {
						for (String item : value.values) {
							attributeValue.setOrAdd(parseValue(item, attributeValue.getModel()));
						}
					} else {
						attributeValue.setOrAdd(parseValue(value.values.get(0), attributeValue.getModel()));
					}
				} else {
					Relation relation = entity.tryGetRelation(value.attributeName);
					if (relation!=null && !relation.isOwner() && !relation.isReadOnly()) {
						WriteableAttributeValue relationValue = (WriteableAttributeValue)relation.get(instance);
						for (String jsonId : value.values) {
							JsonElement parsed = new JsonParser().parse(jsonId);
							if (parsed.isJsonPrimitive()) {
								Instance to = caseAdministration.getInstanceByUniqueId(parsed.getAsString());
								if (to!=null) {
									relationValue.setOrAdd(to);
									if (!relation.isMultivalue()) {
									  break;
									}
								}
							} else {
								String entityName = parsed.getAsJsonObject().get("entityName").getAsString();
								String instanceName = parsed.getAsJsonObject().get("instanceName").getAsString();
								Entity<?> entityOfStaticInstance = caseAdministration.getAllEntities().get(entityName);
								relationValue.setOrAdd(entityOfStaticInstance.getStaticInstances().get(instanceName));
							}
						}
					}
				}
			}
		}
		for (Instance child : instance.getMetadata().getChildren()) {
			loadData(child, caseAdministration);
		}
	}

	private Object parseValue(String item, Attribute attribute) {
		Class<?> javaClassName = attribute.getJavaClassName();
		Object result = gson.fromJson(item, javaClassName);
		if (javaClassName==Object.class && (result instanceof Double) && (!item.contains("."))) {
			return ((Double)result).intValue();
		}
		return result;
	}

	private Instance createStructure(InstanceStorageInfo storage, SortedMap<String, Entity<?>> entities) {
		Instance result = entities.get(storage.node.entityName).createInstance();
		result.getMetadata().initUniqueId(storage.node.uniqueId);
		result.getMetadata().setStorageInfo(storage);
		createStructure(result, storage.node, entities, storage);
		for (Entry<String, List<InstanceStorageInfo>> entry: storage.subStorages.entrySet()) {
			Relation relation = result.getMetadata().getEntity().tryGetRelation(entry.getKey());
			if (relation!=null && !relation.isReadOnly() && relation.isOwner() && relation.isMultivalue()) {
				WriteableAttributeValue attributeValue = (WriteableAttributeValue)relation.get(result);
				for (InstanceStorageInfo subStorage : entry.getValue()) {
					Instance subResult = entities.get(subStorage.node.entityName).createInstance();
					subResult.getMetadata().initUniqueId(subStorage.node.uniqueId);
					attributeValue.setOrAdd(subResult);
					subResult.getMetadata().setStorageInfo(subStorage);
					createStructure(subResult, subStorage.node, entities, subStorage);
				}
			}
		}
		return result;
	}

	private void createStructure(Instance instance, InstanceNode node, SortedMap<String, Entity<?>> entities, InstanceStorageInfo rootStorage) {
		instance.getMetadata().getStorageInfo().root = rootStorage;
		for (AttributeValueNode value : node.values) {
			if (value.subInstances.size()>0) {
				Relation relation = instance.getMetadata().getEntity().tryGetRelation(value.attributeName);
				if (relation!=null && !relation.isReadOnly() && relation.isOwner()) {
					WriteableAttributeValue attributeValue = (WriteableAttributeValue)relation.get(instance);
					if (relation.isMultivalue()) {
						for (InstanceNode subNode : value.subInstances) {
							Instance result = entities.get(subNode.entityName).createInstance();
							result.getMetadata().initUniqueId(subNode.uniqueId);
							attributeValue.setOrAdd(result);
							InstanceStorageInfo subStorageInfo = new InstanceStorageInfo();
							subStorageInfo.node = subNode;
							result.getMetadata().setStorageInfo(subStorageInfo);
							createStructure(result, subNode, entities, rootStorage);
						}
					} else {
						if (value.subInstances.size()>0) {
							InstanceNode subNode = value.subInstances.get(0);
							Entity<?> entity = entities.get(subNode.entityName);
							if (entity!=null) {
								Instance result = entity.createInstance();
								result.getMetadata().initUniqueId(subNode.uniqueId);
								try {
									attributeValue.setOrAdd(result);
								} catch (ClassCastException e) {
									logger.warn("Could not set ["+attributeValue+"] to ["+result+"]");
								}
								InstanceStorageInfo subStorageInfo = new InstanceStorageInfo();
								subStorageInfo.node = subNode;
								result.getMetadata().setStorageInfo(subStorageInfo);
								createStructure(result, subNode, entities, rootStorage);
							} else {
								logger.warn("Could not load instance ["+subNode.uniqueId+"] of unknown entity ["+subNode.entityName+"]");
							}
						}
					}
				}
			}
		}
	}

	private InstanceStorageInfo load(File dir, String caseId) {
		File[] designs = dir.listFiles(DESIGNS);
		if (designs.length>1) {
			throw new RuntimeException(designs.length+" .design files exist in "+dir+" expected 1");
		}
		try {
			InstanceStorageInfo root;
			if (designs.length==1) { 
				root = loadDesign(designs[0], null);
			} else {
				root = new InstanceStorageInfo();
				root.node = new InstanceNode();
				root.node.entityName = "ApplicationDesign";
				root.node.uniqueId = new ApplicationDesign().getMetadata().getUniqueId();
				root.fileName = caseId+".design";
				AttributeValueNode nameValue = new AttributeValueNode();
				nameValue.attributeName = "name";
				nameValue.values.add("\""+caseId+"\"");
				root.node.values.add(nameValue);
			}
			root.root = null;
			for(File sub : dir.listFiles()) {
				if (sub.isDirectory()) {
					designs = sub.listFiles(DESIGNS);
					for (File design : designs) {
						InstanceStorageInfo subStorage = loadDesign(design, sub.getName());
						root.addSubStorage(sub.getName(), subStorage);
					}
				}
			}
			return root;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private InstanceStorageInfo loadDesign(File file, String subDirectory) throws IOException {
		InstanceStorageInfo result = new InstanceStorageInfo();
		result.root = result;
		result.fileName = file.getName();
		result.subDirectory = subDirectory;
		InstanceNode current = new InstanceNode();
		result.node = current;
		Deque<InstanceNode> stack = new ArrayDeque<>();
		stack.push(current);
		
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while (true) {
				line = reader.readLine();
				if (line==null) throw new RuntimeException("Start line not found");
				Matcher matcher = START_LINE.matcher(line);
				if (matcher.matches()) {
					result.node.uniqueId = matcher.group(2);
					result.node.entityName = matcher.group(3);
					break;
				}
				matcher = DATA_LINE.matcher(line);
				if (matcher.matches()) throw new RuntimeException("Start line not found");
			}
			while ((line = reader.readLine())!=null) {
				Matcher matcher = DATA_LINE.matcher(line);
				if (matcher.matches()) {
					if (current==null) throw new RuntimeException("Data after end");
					String attributeName = matcher.group(2);
					AttributeValueNode value = current.getOrAddValue(attributeName);
					char instruction = matcher.group(3).charAt(0);
					switch (instruction) {
					case '[':
						value.multivalue = true;
						break;
					case '+':
					case '=':
						value.multivalue = instruction=='+';
						String data = matcher.group(4);
						matcher = ENTITY_START_DATA.matcher(data);
						if (matcher.matches()) {
							stack.push(current);
							current = new InstanceNode();
							current.uniqueId = matcher.group(1);
							current.entityName = matcher.group(2);
							value.subInstances.add(current);
						} else {
							value.values.add(data);
						}
						break;
					}
					continue;
				}
				matcher = NODATA_LINE.matcher(line);
				if (matcher.matches()) {
					if (current==null) throw new RuntimeException("Data after end");
					String attributeName = matcher.group(2);
					current.getOrAddValue(attributeName);
					continue;
				}
				matcher = ENTITY_END_LINE.matcher(line); 
				if (matcher.matches()) {
					if (!current.uniqueId.equals(matcher.group(2))) 
						throw new RuntimeException("Wrong instance close");
					current = stack.pop();
				}
			}
		}
		if (current!=result.node) 
			throw new RuntimeException("Last instance was not closed");
		return result;
	}
	
	
	
	// Save
	

	@Override
	public void persist(String id, Instance caseInstance, int version, Application application, List<ValueChangeEvent> events) {
		save(caseInstance, getCaseDir(application, id), events);
		
		if (caseInstance instanceof ApplicationDesign) {
			// NextDesigner has its own ApplicationDesign class
			ApplicationDesign applicationDesign = (ApplicationDesign)caseInstance;
			GeneratedClassModelsProcessor generatedClassModelsProcessor = applicationDesign.getGeneratedClassModelsProcessor();
			if (generatedClassModelsProcessor!=null) {
				GeneratedClassModels classModelUpdates = applicationDesign.getApplicationGenerator().getClassModelUpdates();
				int updates = classModelUpdates.countUpdates();
				if (updates>0) {
					logger.info("Updated {} class models", updates);
					generatedClassModelsProcessor.process(classModelUpdates, id);
				}
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void save(Instance instance, File dir, List<ValueChangeEvent> events) {
		List<InstanceStorageInfo> instancesToSave = new ArrayList<>();
		List<InstanceStorageInfo> instancesToDelete = new ArrayList<>();
		if (instance.getMetadata().getStorageInfo() == null) {
			// Has never been saved yet
			initRootInstanceNode(instance, null, instancesToSave);
		} else {
			for (ValueChangeEvent event : events) {
				if (event.storedValueChanged()) {
					Attribute attribute = event.getAttribute();
					InstanceStorageInfo storageInfo = event.getInstance().getMetadata().getStorageInfo();
					if (storageInfo==null) {
						throw new RuntimeException("No storage info");
					}
					if (event.isMultivalueUpdate() && event.getInstance().getMetadata().getInstanceOwner()==null && attribute instanceof Relation) {
						// direct descendant of Application: Add/remove a file
						Instance value = (Instance) event.getItemValue();
						if (event.getMultiValueUpdateType()== MultiValueUpdateType.DELETE) {
							if (value.getMetadata().getStorageInfo()!=null) {
								instancesToDelete.add(value.getMetadata().getStorageInfo());
								storageInfo.root.removeSubStorage(attribute.getName(), value.getMetadata().getStorageInfo());
							}
						}
						if (event.getMultiValueUpdateType()== MultiValueUpdateType.INSERT) {
							InstanceStorageInfo subStorage = initRootInstanceNode(value, attribute.getName(), instancesToSave);
							storageInfo.root.addSubStorage(attribute.getName(), subStorage);
						}
					} else {
						instancesToSave.add(storageInfo.root);
						if (attribute instanceof Relation) {
							if (((Relation)attribute).isOwner()) {
								 if (event.isMultivalueUpdate()) {
									if (event.getMultiValueUpdateType() == MultiValueUpdateType.INSERT) {
										initSubInstanceNode((Instance)event.getItemValue(), instancesToSave, storageInfo.root);
									}
									List<InstanceNode> newNodes = new ArrayList<>();
									for (Instance value : (Iterable<Instance>)event.getNewValue().getValue()) {
										newNodes.add(value.getMetadata().getStorageInfo().node);
									}
									storageInfo.node.setInstances(event.getAttribute(), newNodes);
								 } else {
									 Instance newChild =(Instance)event.getNewStoredValue(); 
									 if (newChild!=null) {
										 InstanceNode newNode = initSubInstanceNode(newChild, instancesToSave, storageInfo.root);
										 storageInfo.node.setInstance(event.getAttribute(), newNode);
									 }
								 }
							} else {
								 if (event.isMultivalueUpdate()) {
									 List<String> ids = new ArrayList<String>();
									 for (Instance value : (Iterable<Instance>)event.getNewValue().getValue()) {
										 ids.add(serializeInstanceId(value));
									 }
									 storageInfo.node.setValues(event.getAttribute(), ids);
								 } else {
									 Instance newValue = (Instance)event.getNewStoredValue();
									 if (newValue==null) {
										 storageInfo.node.setValue(event.getAttribute(), null);
									 } else {
										 storageInfo.node.setValue(event.getAttribute(), serializeInstanceId(newValue));
									 }
								 }
							 }
						} else {
							if (event.isMultivalueUpdate()) {
								List<String> strings = new ArrayList<String>();
								for (Object value : (Iterable)event.getNewValue().getValue()) {
									strings.add(toJson(value));
								}
								storageInfo.node.setValues(event.getAttribute(), strings);
							} else {
								storageInfo.node.setValue(event.getAttribute(), toJson(event.getNewStoredValue()));
							}
						}
					}
				}
			}
		}
		for(InstanceStorageInfo storageInfo: instancesToSave) {
			logger.debug("Saving design {}/{}", storageInfo.subDirectory, storageInfo.fileName);
			if (storageInfo.fileName==null) {
				throw new RuntimeException("Storage is not a root");
			}
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
					writeInstance(writer, storageInfo.node);
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
		for(InstanceStorageInfo storageInfo: instancesToDelete) {
			logger.debug("Deleting design {}/{}", storageInfo.subDirectory, storageInfo.fileName);
			File subDir = storageInfo.subDirectory==null?dir:new File(dir, storageInfo.subDirectory);
			File file = new File(subDir, storageInfo.fileName);
			if (file.exists()) {
				file.delete();
			}
		}
	}

	private String toJson(Object value) {
		if (value==null) {
			return null;
		}
		return gson.toJson(value);
	}

	private InstanceStorageInfo initRootInstanceNode(Instance instance, String subDirectory, List<InstanceStorageInfo> results) {
		InstanceStorageInfo instanceStorage = new InstanceStorageInfo();
		instance.getMetadata().setStorageInfo(instanceStorage);
		results.add(instanceStorage);
		instanceStorage.subDirectory = subDirectory;
		instanceStorage.node = initInstanceNode(instance, results, instanceStorage);
		instanceStorage.fileName = fileNameForInstance(instance);
		instanceStorage.root = instanceStorage;
		return instanceStorage;
	}

	private String fileNameForInstance(Instance instance) {
		Attribute nameAttribute = instance.getMetadata().getEntity().tryGetAttribute("name");
		if (nameAttribute!=null) {
			String name = (String)nameAttribute.get(instance).getValue();
			if (name!=null) {
				return name+".design";
			}
		}
		return instance.getMetadata().getUniqueId()+".design";
	}

	private InstanceNode initSubInstanceNode(Instance instance, List<InstanceStorageInfo> instanceStoragesToSave, InstanceStorageInfo instanceStorageRoot) {
		InstanceStorageInfo storageInfo = new InstanceStorageInfo();
		storageInfo.root = instanceStorageRoot;
		instance.getMetadata().setStorageInfo(storageInfo);
		storageInfo.node = initInstanceNode(instance, instanceStoragesToSave, instanceStorageRoot);
		return storageInfo.node;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private InstanceNode initInstanceNode(Instance instance, List<InstanceStorageInfo> instanceStoragesToSave, InstanceStorageInfo instanceStorageRoot) {
		InstanceNode node = new InstanceStorageInfo.InstanceNode();
		node.entityName = instance.getMetadata().getEntity().getName();
		node.uniqueId = instance.getMetadata().getUniqueId();
		
		for (Attribute attribute : instance.getMetadata().getEntity().getAttributes()) {
			if (!attribute.isReadOnly()) {
				AttributeValueNode attributeNode = new AttributeValueNode();
				attributeNode.attributeName = attribute.getName();
				node.values.add(attributeNode);
				ReadOnlyAttributeValue attributeValue = attribute.get(instance);
				if (attribute.isMultivalue()) {
					attributeNode.multivalue = true;
					
					for (Object value : (Values)attributeValue.getValue()) {
						attributeNode.values.add(gson.toJson(value));
					}
					
				} else {
					Object value = ((WriteableAttributeValue)attributeValue).getStoredValue();
					if (value!=null) {
						if (value instanceof Instance) {
							attributeNode.values.add(value.toString());
						} else {
							attributeNode.values.add(gson.toJson(value));
						}
					}
				}
			}
		}
		
		for (Relation relation : instance.getMetadata().getEntity().getRelations()) {
			ReadOnlyAttributeValue attributeValue = relation.get(instance);
			if (attributeValue.hasStoredValue()) {
				if (relation.isOwner() && relation.isMultivalue() && instance.getMetadata().getInstanceOwner()==null) {
					// Move each entry to a file of its own
					for (Instance value : (Values<Instance>)attributeValue.getValue()) {
						InstanceStorageInfo result = initRootInstanceNode(value, relation.getName(), instanceStoragesToSave);
						instanceStorageRoot.addSubStorage(relation.getName(), result);
					}
				} else {
					AttributeValueNode attributeNode = new AttributeValueNode();
					attributeNode.attributeName = relation.getName();
					node.values.add(attributeNode);
					if (relation.isOwner()) {
						if (relation.isMultivalue()) {
							attributeNode.multivalue = true;
							for (Instance value : (Values<Instance>)attributeValue.getValue()) {
								InstanceNode subInstance = initSubInstanceNode(value, null, instanceStorageRoot);
								attributeNode.subInstances.add(subInstance);
							}
						} else {
							Instance value = (Instance)attributeValue.getValue();
							if (value!=null) {
								InstanceNode subInstance = initSubInstanceNode(value, null, instanceStorageRoot);
								attributeNode.subInstances.add(subInstance);
							}
						}
					} else {
						if (relation.isMultivalue()) {
							attributeNode.multivalue = true;
							for (Instance value : (Values<Instance>)attributeValue.getValue()) {
								attributeNode.values.add(serializeInstanceId(value));
							}
						} else {
							if (!relation.isReadOnly()) {
								Instance value = (Instance)((WriteableAttributeValue)attributeValue).getStoredValue();
								if (value!=null) {
									attributeNode.values.add(serializeInstanceId(value));
								}
							}
						}
					}
				}
			}
		}
		
		return node;
	}

	private String serializeInstanceId(Instance value) {
		if (value.getMetadata().isStatic()) {
			JsonObject result = new JsonObject();
			result.add("entityName", new JsonPrimitive(value.getMetadata().getEntity().getName()));
			result.add("instanceName", new JsonPrimitive(value.getMetadata().getStaticName()));
			return result.toString();
		}
		return "\""+value.getMetadata().getUniqueId()+"\"";
	}

	private void writeInstance(OutputStreamWriter writer, InstanceNode rootNode) throws IOException {
		String prefix = rootNode.uniqueId+": ";
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
		for (AttributeValueNode attribute : rootNode.values) {
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
					
					
					writeAttributes(writer, subInstance, subInstance.uniqueId+":"+nextIndent, nextIndent+" ");

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
				if (attribute.subInstances.size()>0) {
					InstanceNode subInstance = attribute.subInstances.get(0);
					writer.write("=");
					writer.write(subInstance.uniqueId);
					writer.write(":");
					writer.write(subInstance.entityName);
					writer.write("{\n");
					
					
					writeAttributes(writer, subInstance, subInstance.uniqueId+":"+nextIndent, nextIndent+" ");

					writer.write(prefix);
					writer.write("}");
					writer.write(subInstance.uniqueId);
				} else if (attribute.values.size()>0) {
					writer.write("=");
					writer.write(attribute.values.get(0));
				}
				writer.write("\n");
			}
		}
	}
}
