/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer;

import java.util.Iterator;

import org.instantlogic.designer.codegenerator.classmodel.StaticFieldValueModel;
import org.instantlogic.designer.codegenerator.classmodel.ValueModel;



public class EntityDesign extends AbstractEntityDesign { 

	public enum RelationType {
		OneToZeroOrOne, 
		OneToZeroOrOneAggregation, 
		OneToOneAggregation, 
		OneToMany, 
		OneToManyAggregation, 
		ManyToZeroOrOne, 
		ManyToMany
	}
	
	public EntityDesign() {}
	
	public EntityDesign(String name) {
		setName(name);
	}
	
	protected static AttributeDesign addAttribute(EntityDesign from, String name, Class<?> type) {
		return from.addAttribute(name,  type);
	}

	protected static AttributeDesign addAttribute(EntityDesign from, String name, DataCategoryDesign dataCategory) {
		return from.addAttribute(name, dataCategory);
	}
	
	protected static AttributeDesign addAttribute(EntityDesign from, String name, String className) {
		return from.addAttribute(name, className);
	}
	
	protected static RelationDesign addRelation(EntityDesign from, String name, RelationType relationType, EntityDesign to) {
		return from.addRelation(name, relationType, to);
	}
	
	protected static StaticInstanceDesign addStaticInstance(EntityDesign of, String name, TextTemplateDesign description) {
		StaticInstanceDesign result = new StaticInstanceDesign();
		of.addToStaticInstances(result);
		result.setDescription(description);
		result.setName(name);
		return result;
	}

	protected static void addStaticInstanceRelationValue(StaticInstanceDesign staticInstance, RelationDesign relation, StaticInstanceDesign to) {
    	StaticInstanceValueDesign value = new StaticInstanceValueDesign();
    	staticInstance.addToValues(value);
    	value.setAttribute(relation);
    	value.setRelationValue(to);
	}

	protected static void addStaticInstanceValue(StaticInstanceDesign staticInstance, AttributeDesign relation, Object value) {
    	StaticInstanceValueDesign valueDesign = new StaticInstanceValueDesign();
    	staticInstance.addToValues(valueDesign);
    	valueDesign.setAttribute(relation);
    	valueDesign.setValue(value);
	}

	public AttributeDesign addAttribute(String name, Class<?> type) {
		return addAttribute(name, type.getName());
	}

	public AttributeDesign addAttribute(String name, String className) {
		AttributeDesign result = new AttributeDesign();
		result.setName(name);
		result.getDataType().setJavaClassName(className);
		addToAttributes(result);
		return result;
	}

	public AttributeDesign addAttribute(String name, DataCategoryDesign dataCategory) {
		AttributeDesign result = new AttributeDesign();
		result.setName(name);
		result.getDataType().setDataCategory(dataCategory);
		addToAttributes(result);
		return result;
	}
	
	public RelationDesign addRelation(String name, RelationType relationType, EntityDesign to) {
		RelationDesign relation = new RelationDesign();
		addToRelations(relation);
		relation.setTo(to);
		relation.setName(name);
		relation.setOwner(relationType==RelationType.OneToManyAggregation || relationType==RelationType.OneToZeroOrOneAggregation || relationType==RelationType.OneToOneAggregation);
		relation.setAutoCreate(relationType==RelationType.OneToOneAggregation);
		relation.getDataType().setMultivalue(relationType==RelationType.OneToMany || relationType==RelationType.OneToManyAggregation || relationType==RelationType.ManyToMany);
		relation.setReverseMultivalue(relationType==RelationType.ManyToMany || relationType==RelationType.ManyToZeroOrOne);
		return relation;
	}
	
	public DeductionSchemeDesign newValidation(String uniqueId, String message, AttributeDesign... displayWith) {
		ValidationDesign validation = new ValidationDesign();
		validation.getMetadata().initUniqueId(uniqueId);
		addToValidations(validation);
		validation.setMessage(createConstantText(message));
		for (AttributeDesign attribute : displayWith) {
			validation.addToDisplayWith(attribute);
		}
		return validation.newRule();
	}
	
	public ValidationDesign newValidation(String uniqueId, AttributeDesign... displayWith) {
		ValidationDesign validation = new ValidationDesign();
		validation.getMetadata().initUniqueId(uniqueId);
		addToValidations(validation);
		for (AttributeDesign attribute : displayWith) {
			validation.addToDisplayWith(attribute);
		}
		return validation;
	}
	
	public Iterable<AttributeDesign> getAttributesAndRelations() {
		return new Iterable<AttributeDesign>() {
			
			@Override
			public Iterator<AttributeDesign> iterator() {
				return new Iterator<AttributeDesign>() {
					
					final Iterator<AttributeDesign> attributes = getAttributes().iterator();
					final Iterator<RelationDesign> relations = getRelations().iterator();

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
					
					@Override
					public AttributeDesign next() {
						if(attributes.hasNext()) {
							return attributes.next();
						}
						return relations.next();
					}
					
					@Override
					public boolean hasNext() {
						return attributes.hasNext()||relations.hasNext();
					}
				};
			}
		};
	}
	
	public void registerApplication(ApplicationDesign application) {
		if (application.getEntities().contains(this)) return;
		application.addToEntities(this);
		if (this.getExtendsFrom()!=null) {
			this.getExtendsFrom().registerApplication(application);
		}
		for(EntityDesign entity: this.getExtensions()) {
			entity.registerApplication(application);
		}
		for (RelationDesign relation: getRelations()) {
			relation.getTo().registerApplication(application);
		}
	}
	
	/**
	 * Will be called once for every entity from ApplicationDesign.init
	 */
	public void init() {
	}

	// Used for code generation
	public ValueModel asStaticFieldValue() {
		return new StaticFieldValueModel(getApplication().getRootPackageName()+".entity."+getTechnicalNameCapitalized()+"Entity","INSTANCE");
	}
}
