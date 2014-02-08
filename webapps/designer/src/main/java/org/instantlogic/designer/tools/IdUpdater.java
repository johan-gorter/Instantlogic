package org.instantlogic.designer.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.deduction.TechnicalNameDeduction;
import org.instantlogic.designer.util.DesignerCasePersister;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;
import org.instantlogic.fabric.value.RelationValue;
import org.instantlogic.fabric.value.Values;
import org.instantlogic.fabric.value.WriteableAttributeValue;

/**
 * Provides a main class that generates javacode for all (web)apps found under ../ and ../webapps/
 */
public class IdUpdater {
	
	public static void main(String[] args) {
		if (args.length>0) {
			loadAndUpdate(new File(args[0]));
		} else {
			System.out.println("provide the path (like ../nextdesigner)");
		}
	}

	public static void loadAndUpdate(File webapp) {
		File designsDirectory = new File(webapp, "src/main/instantlogic-designs");
		if (designsDirectory.isDirectory()) {
			for(File file : designsDirectory.listFiles()) {
				String designName = file.getName();
				if (file.isDirectory()) {
					System.out.println(file.getAbsolutePath());
					ApplicationDesign app = new DesignerCasePersister().loadApplicationDesign(file);
					ApplicationDesign newApp = new ApplicationDesign();
					newApp.getMetadata().initUniqueId("Application_"+TechnicalNameDeduction.makeTechnicalName(app.getName()));
					List<Instance> oldInstances = new ArrayList<>();
					List<Instance> newInstances = new ArrayList<>();
					Operation operation = newApp.getMetadata().getCaseAdministration().startOperation(true);
			        recreateStructure(newApp, app, oldInstances, newInstances, newApp.getMetadata().getCaseAdministration());
			        for (int i=0;i<oldInstances.size();i++) {
			        	copyData(oldInstances.get(i), newInstances.get(i), oldInstances, newInstances);
			        }
			        operation.complete();
			        operation.close();
			        deleteFolder(file, true);
			        new DesignerCasePersister().save(newApp, file, null);
				}
			}
		}
	}
	
	private static void deleteFolder(File folder, boolean contentOnly) {
	    File[] files = folder.listFiles();
	    if(files!=null) { //some JVMs return null for empty dirs
	        for(File f: files) {
	            if(f.isDirectory()) {
	                deleteFolder(f, false);
	            } else {
	                f.delete();
	            }
	        }
	    }
	    if (!contentOnly) {
	    	folder.delete();
	    }
	}
	
	private static void copyData(Instance oldInstance, Instance newInstance, List<Instance> oldInstances, List<Instance> newInstances) {
		Entity<?> entity = oldInstance.getMetadata().getEntity();
		for (Attribute oldAttribute : entity.getAttributes()) {
			copyValue(oldInstance, oldAttribute, newInstance, entity);
		}
		for (Relation oldRelation : entity.getRelations()) {
			Relation newRelation = entity.getRelationById(oldRelation.getUniqueId());
			if (newRelation!=null) {
				if (!oldRelation.isOwner()) {
					if (!newRelation.isOwner()) {
						copyRelationValue(oldInstance, oldRelation, newInstance, entity, oldInstances, newInstances);
					}
				}
			}
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void copyRelationValue(Instance oldInstance, Relation oldRelation, Instance newInstance, Entity<?> newEntity, List<Instance> oldInstances, List<Instance> newInstances) {
		ReadOnlyAttributeValue relationValue = oldRelation.get(oldInstance);
		if (relationValue.hasStoredValue()) {
			Relation newRelation = newEntity.getRelationById(oldRelation.getUniqueId());
			if (newRelation!=null && !newRelation.isReadOnly()) {
				if (oldRelation.isMultivalue()) {
					if (newRelation.isMultivalue()) {
						WriteableAttributeValue oldRelationValues = (WriteableAttributeValue)oldRelation.get(oldInstance);
						WriteableAttributeValue newRelationValues = (WriteableAttributeValue)newRelation.get(newInstance);
						for (Instance oldValue : (Values<Instance>)oldRelationValues.getStoredValue()) {
							Instance newValue = findInstance(oldValue, oldInstances, newInstances);
							newRelationValues.setOrAdd(newValue);
						}
					}
				} else {
					if (!newRelation.isMultivalue()) {
						Instance oldValue = (Instance)((RelationValue)oldRelation.get(oldInstance)).getStoredValue();
						Instance newValue = findInstance(oldValue, oldInstances, newInstances);
						((AttributeValue)newRelation.get(newInstance)).setValue(newValue);
					}
				}
			}
		}
	}
	

	private static Instance findInstance(Instance oldInstance, List<Instance> oldInstances, List<Instance> newInstances) {
		return newInstances.get(oldInstances.indexOf(oldInstance));
	}

	private static Instance createInstance(Instance oldChildInstance, String id) {
		Instance newInstance = oldChildInstance.getMetadata().getEntity().createInstance();
		newInstance.getMetadata().initUniqueId(id);
		return newInstance;
	}	

	private static void recreateStructure(Instance newInstance, Instance oldInstance, List<Instance> oldInstances, List<Instance> newInstances, CaseAdministration newCaseAdministration) {
		oldInstances.add(oldInstance);
		newInstances.add(newInstance);
		Entity<?> newEntity = newInstance.getMetadata().getEntity();
		Entity<?> oldEntity = oldInstance.getMetadata().getEntity();
		for (Relation oldRelation : oldEntity.getRelations()) {
			if (oldRelation.isOwner()) {
				Relation newRelation = newEntity.getRelationById(oldRelation.getUniqueId());
				if (newRelation!=null && newRelation.isOwner()) {
					ReadOnlyAttributeValue attributeValue = oldRelation.get(oldInstance);
					if (attributeValue.hasStoredValue()) {
						if (oldRelation.isMultivalue()) {
							if (newRelation.isMultivalue()) {
								WriteableAttributeValue oldRelationValues = (WriteableAttributeValue)oldRelation.get(oldInstance);
								WriteableAttributeValue newRelationValues = (WriteableAttributeValue)newRelation.get(newInstance);
								for (Instance oldChildInstance : (Values<? extends Instance>)oldRelationValues.getValue()) {
									Instance newChildInstance = createInstance(oldChildInstance, generateNewId(oldChildInstance, newCaseAdministration));
									newRelationValues.setOrAdd(newChildInstance);
									recreateStructure(newChildInstance, oldChildInstance, oldInstances, newInstances, newCaseAdministration);
								}
							}
						} else {
							if (!newRelation.isMultivalue()) {
								Instance oldChildInstance = (Instance)oldRelation.get(oldInstance).getValue();
								Instance newChildInstance = createInstance(oldChildInstance, generateNewId(oldChildInstance, newCaseAdministration));
								((RelationValue)newRelation.get(newInstance)).setValue(newChildInstance);
								recreateStructure(oldChildInstance, newChildInstance, oldInstances, newInstances, newCaseAdministration);
							}
						}
					}
				}
			}
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void copyValue(Instance oldInstance, Attribute oldAttribute, Instance newInstance, Entity<?> newEntity) {
		ReadOnlyAttributeValue attributeValue = oldAttribute.get(oldInstance);
		if (attributeValue.hasStoredValue()) {
			Attribute newAttribute = newEntity.getAttributeById(oldAttribute.getUniqueId());
			if (newAttribute!=null && !newAttribute.isReadOnly()) {
				if (oldAttribute.isMultivalue()) {
					if (newAttribute.isMultivalue()) {
						WriteableAttributeValue oldAttributeValues = (WriteableAttributeValue)oldAttribute.get(oldInstance);
						WriteableAttributeValue newAttributeValues = (WriteableAttributeValue)newAttribute.get(newInstance);
						for (Object oldValue : (Values)oldAttributeValues.getStoredValue()) {
							newAttributeValues.setOrAdd(oldValue);
						}
					}
				} else {
					if (!newAttribute.isMultivalue()) {
						Object oldValue = ((AttributeValue)oldAttribute.get(oldInstance)).getStoredValue();
						((AttributeValue)newAttribute.get(newInstance)).setValue(oldValue);
					}
				}
			}
		}
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static String generateNewId(Instance oldInstance, CaseAdministration newCaseAdministration) {
		Entity<?> entity = oldInstance.getMetadata().getEntity();
		String id = entity.getName();
		Attribute nameAttribute = entity.tryGetAttribute("name");
		if (nameAttribute!=null) {
			String name = (String)nameAttribute.get(oldInstance).getValue();
			if (name!=null) {
				id = id+"_"+TechnicalNameDeduction.makeTechnicalName(name);
			}
		}
		if (newCaseAdministration.getInstanceByUniqueId(id)==null) {
			return id;
		}
		int index = 0;
		String indexedId;
		do {
			index++;
			indexedId = id+"_"+index;
		} while (newCaseAdministration.getInstanceByUniqueId(indexedId)!=null);
		return indexedId;
	}
}
