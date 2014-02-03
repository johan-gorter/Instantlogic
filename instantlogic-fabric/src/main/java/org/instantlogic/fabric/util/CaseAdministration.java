package org.instantlogic.fabric.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.id.Id;
import org.instantlogic.fabric.util.id.IdGenerator;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;

public class CaseAdministration {

	private final Instance rootInstance;
	
	private long version;
	private List<Observations> observationsStack = new ArrayList<Observations>();
	private Observations currentObservations = null;
	private IdGenerator idGenerator;
	
	private SortedMap<String, Entity<?>> allEntitiesByName;
	private SortedMap<String, Entity<?>> allEntitiesById;
	
	private Map<String, Instance> instanceByUniqueId = new HashMap<String, Instance>();
	
	private static void addEntities(Entity<?> entity, SortedMap<String, Entity<?>> all) {
		if (all.containsKey(entity.getName())) {
			return;
		}
		all.put(entity.getName(), entity);
		if (entity.extendsEntity()!=null) {
			addEntities(entity.extendsEntity(), all);
		}
		for (Entity<?> extension : entity.extensions()) {
			addEntities(extension, all);
		}
		for (Relation<?, ?, ? extends Instance> relation : entity.getRelations()) {
			addEntities(relation.getTo(), all);
		}
	}
	
	private static void addEntitiesById(Entity<?> entity, SortedMap<String, Entity<?>> all) {
		if (all.containsKey(entity.getUniqueId())) {
			return;
		}
		all.put(entity.getUniqueId(), entity);
		if (entity.extendsEntity()!=null) {
			addEntitiesById(entity.extendsEntity(), all);
		}
		for (Entity<?> extension : entity.extensions()) {
			addEntitiesById(extension, all);
		}
		for (Relation<?, ?, ? extends Instance> relation : entity.getRelations()) {
			addEntitiesById(relation.getTo(), all);
		}
	}
	
	// Also available from the Application
	public SortedMap<String, Entity<?>> getAllEntities() {
		if (allEntitiesByName==null) {
			TreeMap<String, Entity<?>> tempResult = new TreeMap<String, Entity<?>>();
			addEntities(rootInstance.getMetadata().getEntity(), tempResult);
			allEntitiesByName = tempResult;
		}
		return allEntitiesByName;
	}
	
	public static SortedMap<String, Entity<?>> getAllEntitiesById(Entity<?> caseEntity) {
		TreeMap<String, Entity<?>> result = new TreeMap<String, Entity<?>>();
		if (caseEntity!=null) {
			addEntitiesById(caseEntity, result);
		}
		return result;
	}

	public SortedMap<String, Entity<?>> getAllEntitiesById() {
		if (allEntitiesById==null) {
			allEntitiesById = getAllEntitiesById(rootInstance.getMetadata().getEntity());
		}
		return allEntitiesById;
	}
	
	// Convenience method
	// Watch out, the created instance is not yet added to this caseAdministration. The instance needs to be owned by another instance first.
	public Instance createInstance(String entityName) {
		Entity<? extends Instance> entity = getAllEntities().get(entityName);
		if (entity==null) throw new IllegalArgumentException("Unknown entity "+entityName);
		return entity.createInstance();
	}
	
	private List<TransactionListener> transactionListeners = new ArrayList<TransactionListener>();
	
	private Operation currentOperation;
	
	public CaseAdministration(Instance rootInstance) {
		this.rootInstance = rootInstance;
	}

	/**
	 * Finds the instance by unique id
	 * @param uniqueId the unique id
	 * @return The instance if found, null otherwise
	 */
	public Instance getInstanceByUniqueId(String uniqueId) {
		return this.instanceByUniqueId.get(uniqueId);
	}

	public void registerObservation(ReadOnlyAttributeValue<? extends Instance, ? extends Object> attributeValueObserved) {
		if (currentObservations!=null) {
			currentObservations.add(attributeValueObserved);
		}
	}
	
	public void startRecordingObservations() {
		if (currentObservations!=null) {
			observationsStack.add(currentObservations);
		}
		currentObservations = new Observations();
	}

	public void startRecordingObservations(Observations appendTo) {
		if (currentObservations!=null) {
			observationsStack.add(currentObservations);
		}
		currentObservations = appendTo;
	}

	public Observations stopRecordingObservations() {
		Observations result = currentObservations;
		if (result==null) throw new IllegalStateException();
		if (observationsStack.size()>0) {
			// pop
			currentObservations = observationsStack.get(observationsStack.size()-1);
			observationsStack.remove(observationsStack.size()-1);
		} else {
			currentObservations = null;
		}
		return result;
	}
	
	public void afterLoading() {
	}
	
	public void afterSubmit() {
	}

	
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
	public Operation startOperation() {
		return startOperation(currentOperation != null && currentOperation.isLoading());
	}

	public Operation startOperation(boolean loading) {
		if (!loading && currentOperation!=null && currentOperation.isLoading()) {
			throw new IllegalArgumentException("loading");
		}
		Operation operation = new Operation(this, currentOperation, loading);
		currentOperation = operation;
		operation.start();
		return operation;
	}
	
	protected void fireTransactionStarted()	{
		for(TransactionListener listener: transactionListeners) {
			listener.transactionStarted(this);
		}
	}
	
	protected void fireTransactionPreparing(List<ValueChangeEvent> events)	{
		for(TransactionListener listener: transactionListeners) {
			listener.transactionPreparing(this, events);
		}
	}
	
	protected void fireTransactionCommitting(List<ValueChangeEvent> events)	{
		for(TransactionListener listener: transactionListeners) {
			listener.transactionCommitting(this, events);
		}
	}
	
	protected void fireTransactionCompleted(boolean committed, List<ValueChangeEvent> events)	{
		for(TransactionListener listener: transactionListeners) {
			listener.transactionCompleted(this, committed, events);
		}
	}
	
	public void addTransactionListener(TransactionListener listener) {
		ArrayList<TransactionListener> newListeners = new ArrayList<TransactionListener>(this.transactionListeners);
		newListeners.add(listener);
		this.transactionListeners = newListeners;
	}

	public void removeTransactionListener(TransactionListener listener) {
		ArrayList<TransactionListener> newListeners = new ArrayList<TransactionListener>(this.transactionListeners);
		newListeners.remove(listener);
		this.transactionListeners = newListeners;
	}

	protected void popCurrentOperation(Operation operation) {
		this.currentOperation = operation;
	}

	void rememberInstanceWithUniqueId(String uniqueId, Instance instance) {
		if (uniqueId==null) {
			throw new IllegalArgumentException();
		}
		Instance oldInstance = this.instanceByUniqueId.put(uniqueId, instance);
		if (oldInstance!=null) {
			this.instanceByUniqueId.put(uniqueId, oldInstance);
			throw new RuntimeException("Duplicate unique id detected: "+uniqueId);
		}
	}

	void forgetInstanceWithUniqueId(String uniqueId) {
		Instance removed = this.instanceByUniqueId.remove(uniqueId);
		if (removed==null) {
			throw new RuntimeException("UniqueId was not registered: "+uniqueId);
		}
	}

	public IdGenerator getIdGenerator() {
		return idGenerator;
	}

	public void setIdGenerator(IdGenerator idGenerator) {
		this.idGenerator = idGenerator;
	}

	public String newId(Instance forInstance) {
		if (idGenerator==null) return Id.newRandomId().toString(false);
		return idGenerator.generate(forInstance.getMetadata().getEntity().getName()).toString(false);
	}
}
