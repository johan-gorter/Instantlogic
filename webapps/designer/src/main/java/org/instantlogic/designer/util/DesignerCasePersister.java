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
import org.instantlogic.designer.DesignerApplication;
import org.instantlogic.designer.deduction.TechnicalNameDeduction;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.InstanceStorageInfo;
import org.instantlogic.fabric.util.InstanceStorageInfo.AttributeValueNode;
import org.instantlogic.fabric.util.InstanceStorageInfo.InstanceNode;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeEvent.MultiValueUpdateType;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;
import org.instantlogic.fabric.value.Values;
import org.instantlogic.fabric.value.WriteableAttributeValue;
import org.instantlogic.interaction.Application;
import org.instantlogic.tools.persistence.json.FileCasePersister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class DesignerCasePersister extends FileCasePersister {
	
	private static final int MERGE_CONFLICT_PREVENTION = 1; // 0 = no, 1 = normal, 2 = extreme
	
	private static final boolean REFERENCES_MUST_RESOLVE = true; 

	protected static final Logger logger = LoggerFactory.getLogger(DesignerPersistenceStrategy.class);
	protected static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
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

	@Override
	protected File getCaseDir(Application application, String caseId) {
		return new File("../../webapps/"+caseId+"/src/main/instantlogic-designs/"+caseId+"/");
	}

	@Override
	public Instance loadOrCreate(String caseId, Class<? extends Instance> ofType, Application application) {
			File dir = getCaseDir(application, caseId);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			InstanceStorageInfo storage = loadStorages(dir, caseId);
			
			Instance result = loadFromStorages(storage, application.getAllEntities());
			
			
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
			return result;
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
								} else if (REFERENCES_MUST_RESOLVE) {
									throw new RuntimeException("Instance not found: "+parsed.getAsString()+" in "+instance);
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

	private Instance loadFromStorages(InstanceStorageInfo storage, SortedMap<String, Entity<?>> entities) {
		Entity<?> entity = entities.get(storage.node.entityName);
		Instance result = entity.createInstance();
		CaseAdministration caseAdministration = result.getMetadata().getCaseAdministration();
		Operation loadingOperation = caseAdministration.startOperation(true);
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
		loadData(result, caseAdministration);
		loadingOperation.complete();
		loadingOperation.close();
		return result;
	}

	private void createStructure(Instance instance, InstanceNode node, SortedMap<String, Entity<?>> entities,
			InstanceStorageInfo rootStorage) {
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
										if (REFERENCES_MUST_RESOLVE) {
											throw new RuntimeException("Could not load instance ["+subNode.uniqueId+"] of unknown entity ["+subNode.entityName+"]");
										} else {
											logger.warn("Could not load instance ["+subNode.uniqueId+"] of unknown entity ["+subNode.entityName+"]");
										}
									}
								}
							}
						}
					}
				}
			}

	private InstanceStorageInfo loadStorages(File dir, String caseId) {
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
				root.fileName = "application.design";
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
						throw new RuntimeException("Wrong instance close, expected "+current.uniqueId+", was "+matcher.group(2));
					current = stack.pop();
				}
			}
		}
		if (current!=result.node) 
			throw new RuntimeException("Last instance was not closed");
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void save(Instance instance, File dir, List<ValueChangeEvent> events) {
		List<InstanceStorageInfo> instancesToSave = new ArrayList<>();
		List<InstanceStorageInfo> instancesToDelete = new ArrayList<>();
		if (instance.getMetadata().getStorageInfo() == null) {
			// Has never been saved yet
			initRootInstanceNode(instance, null, instancesToSave);
			instance.getMetadata().getStorageInfo().fileName="application.design";
		} else {
			for (ValueChangeEvent event : events) {
				if (event.storedValueChanged()) {
					Attribute attribute = event.getAttribute();
					InstanceStorageInfo storageInfo = event.getInstance().getMetadata().getStorageInfo();
					if (storageInfo==null) {
						throw new RuntimeException("No storage info");
					}
					if (event.isMultivalueUpdate() && "ApplicationDesign".equals(event.getInstance().getMetadata().getEntity().getName()) && attribute instanceof Relation) {
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
				return TechnicalNameDeduction.capitalizeFirst(TechnicalNameDeduction.makeTechnicalName(name))+".design";
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
	
	private String buildPrefix(InstanceNode forNode) throws IOException {
		StringBuilder sb = new StringBuilder();
		if (MERGE_CONFLICT_PREVENTION>0) {
			int length = forNode.uniqueId.length();
			if (length>=30) {
				sb.append(forNode.uniqueId.substring(length-30));
				sb.append(": ");
			} else {
				sb.append(forNode.uniqueId);
				sb.append(": ");
				for (int i=length;i<30;i++) {
					sb.append(' ');
				}
			}
		}
		return sb.toString();
	}

	private void writeInstance(OutputStreamWriter writer, InstanceNode rootNode) throws IOException {
		String prefix = buildPrefix(rootNode);
		writer.write(prefix);
		writer.write(rootNode.uniqueId);
		writer.write(":");
		writer.write(rootNode.entityName);
		writer.write("{\n");
		
		writeAttributes(writer, rootNode, prefix+" ", "  ");
		
		writer.write(prefix);
		writer.write("}");
		writer.write(rootNode.uniqueId);
		writer.write("\n");
	}

	private void writeAttributes(OutputStreamWriter writer, InstanceNode rootNode, String prefix, String nextIndent) throws IOException {
				for (AttributeValueNode attribute : rootNode.values) {
					if (attribute.multivalue) {
						if (MERGE_CONFLICT_PREVENTION>1) {
							writer.write(prefix);
							writer.write(attribute.attributeName);
							writer.write("[\n");
						}
						
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
							
							
							writeAttributes(writer, subInstance, buildPrefix(subInstance)+nextIndent, nextIndent+" ");
			
							writer.write(prefix);
							writer.write("}");
							writer.write(subInstance.uniqueId);
							writer.write("\n");
						}
						
						if (MERGE_CONFLICT_PREVENTION>1) {
							writer.write(prefix);
							writer.write(attribute.attributeName);
							writer.write("]\n");
						}
					} else {
						if (attribute.subInstances.size()>0) {
							writer.write(prefix);
							writer.write(attribute.attributeName);
							InstanceNode subInstance = attribute.subInstances.get(0);
							writer.write("=");
							writer.write(subInstance.uniqueId);
							writer.write(":");
							writer.write(subInstance.entityName);
							writer.write("{\n");
							
							
							writeAttributes(writer, subInstance, buildPrefix(subInstance)+nextIndent, nextIndent+" ");
			
							writer.write(prefix);
							writer.write("}");
							writer.write(subInstance.uniqueId);
							writer.write("\n");
						} else if (attribute.values.size()>0) {
							writer.write(prefix);
							writer.write(attribute.attributeName);
							writer.write("=");
							writer.write(attribute.values.get(0));
							writer.write("\n");
						} else if (MERGE_CONFLICT_PREVENTION>1) {
							writer.write(prefix);
							writer.write(attribute.attributeName);
							writer.write("\n");
						}
					}
				}
			}

	public ApplicationDesign loadApplicationDesign(File folder) {
		InstanceStorageInfo storage = loadStorages(folder, folder.getName());
		
		Instance result = loadFromStorages(storage, DesignerApplication.INSTANCE.getAllEntities());
		
		return (ApplicationDesign) result;
	}
}
