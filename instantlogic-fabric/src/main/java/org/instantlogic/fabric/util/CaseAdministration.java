/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

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
	
	private SortedMap<String, Entity<?>> allEntities;
	
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
	
	public SortedMap<String, Entity<?>> getAllEntities() {
		if (allEntities==null) {
			TreeMap<String, Entity<?>> tempResult = new TreeMap<String, Entity<?>>();
			addEntities(rootInstance.getMetadata().getEntity(), tempResult);
			allEntities = tempResult;
		}
		return allEntities;
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
		Operation operation = new Operation(this, currentOperation);
		currentOperation = operation;
		operation.start();
		return operation;
	}
	
	protected void fireTransactionStarted()	{
		for(TransactionListener listener: transactionListeners) {
			listener.transactionStarted(this);
		}
	}
	
	protected void fireTransactionPreparing()	{
		for(TransactionListener listener: transactionListeners) {
			listener.transactionPreparing(this);
		}
	}
	
	protected void fireTransactionCommitting()	{
		for(TransactionListener listener: transactionListeners) {
			listener.transactionCommitting(this);
		}
	}
	
	protected void fireTransactionCompleted(boolean committed)	{
		for(TransactionListener listener: transactionListeners) {
			listener.transactionCompleted(this, committed);
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
		this.instanceByUniqueId.put(uniqueId, instance);
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

	public Id newId(Instance forInstance) {
		if (idGenerator==null) return Id.newRandomId();
		return idGenerator.generate(forInstance.getMetadata().getEntity().getName());
	}
}
