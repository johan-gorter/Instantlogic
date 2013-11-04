package org.instantlogic.designer.codegenerator.generator;


import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.DataTypeDesign;
import org.instantlogic.designer.Design;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.StaticInstanceDesign;
import org.instantlogic.designer.StaticInstanceValueDesign;
import org.instantlogic.designer.TextTemplateDesign;
import org.instantlogic.designer.ValidationDesign;
import org.instantlogic.designer.codegenerator.classmodel.ConstantValueModel;
import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel;
import org.instantlogic.designer.codegenerator.classmodel.ValidationClassModel;
import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel.Attribute;
import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel.StaticInstance;
import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel.StaticInstanceValue;
import org.instantlogic.designer.codegenerator.classmodel.StaticFieldValueModel;
import org.instantlogic.designer.deduction.TechnicalNameDeduction;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

public class EntityGenerator extends AbstractGenerator<EntityClassModel> {

	public EntityDesign entityDesign;
	private Map<String, AbstractGenerator<ValidationClassModel>> validationGenerators = new HashMap<String, AbstractGenerator<ValidationClassModel>>();
	
	public EntityGenerator(EntityDesign entityDesign) {
		this.entityDesign = entityDesign;
	}
	
	@Override
	public EntityClassModel generate(GeneratedClassModels context) {
		if (observations != null && !observations.isOutdated()) {
			updateAll(validationGenerators.values(), context);
			return null;
		}

		entityDesign.getMetadata().getCaseAdministration().startRecordingObservations();
		
		EntityClassModel model = new EntityClassModel();
		model.name = entityDesign.getName();
		model.rootPackageName = entityDesign.getApplication().getRootPackageName();
		model.id = entityDesign.getMetadata().getUniqueId();
		model.technicalNameCapitalized = entityDesign.getTechnicalNameCapitalized();
		model.isCustomized = entityDesign.getIsCustomized()==Boolean.TRUE;
		
		model.determineIsDeleted(entityDesign.isValidForCodeGeneration());
		
		if (entityDesign.getExtendsFrom()!=null) {
			model.extendsFrom = entityDesign.getExtendsFrom().getTechnicalNameCapitalized();
		}
		if (entityDesign.getTitle()!=null) {
			model.title = TextGenerator.generate(entityDesign.getTitle(), model);
		}
		for (EntityDesign extension : entityDesign.getExtensions()) {
			model.extensions.add(extension.getTechnicalNameCapitalized());
		}
		Collections.sort(model.extensions);
		for (AttributeDesign attributeDesign: entityDesign.getAttributes()) {
			if (!attributeDesign.isValidForCodegeneration()) continue;
			EntityClassModel.Attribute attribute = new EntityClassModel.Attribute();
			attribute.name = attributeDesign.getName();
			attribute.id = attributeDesign.getMetadata().getUniqueId();
			attribute.technicalName = attributeDesign.getTechnicalName();
			attribute.technicalNameCapitalized = attributeDesign.getTechnicalNameCapitalized();
			attribute.javaIdentifier = attributeDesign.getJavaIdentifier();
			if (attribute.getDataType()!=null && attributeDesign.getDataType().getJavaClassName()!=null) {
				setDatatype(attribute, attributeDesign.getDataType());
				attribute.itemClassName = attributeDesign.getDataType().getJavaClassName();
				attribute.internalClassName = attribute.itemClassName.replace('.', '/');
			} else {
				// Work in progress, just do not crash
				attribute.dataType.put("category", "text");
				attribute.itemClassName = "java.lang.String";
				attribute.internalClassName = attribute.itemClassName.replace('.', '/');
			}
			attribute.multivalue = (attributeDesign.getDataType().getMultivalue()==Boolean.TRUE);
			attribute.ordered = (attributeDesign.getDataType().getOrdered()==Boolean.TRUE);
			if (attribute.multivalue) {
				String valuesClassName = attribute.ordered?"ValueList":"Values";
				attribute.className="org.instantlogic.fabric.value."+valuesClassName+"<"+attribute.itemClassName+">";
				attribute.internalClassName = "org/instantlogic/fabric/value/"+valuesClassName;
			} else {
				attribute.className=attribute.itemClassName;
			}
			attribute.internalItemClassName = attribute.itemClassName.replace('.', '/');
			attribute.readonly = (attributeDesign.getWriteable()==Boolean.FALSE);
			TextTemplateDesign question = attributeDesign.getQuestion();
			if (question!=null) {
				attribute.question = TextGenerator.generate(question, model);
			}
			TextTemplateDesign explanation = attributeDesign.getExplanation();
			if (explanation!=null) {
				attribute.explanation = TextGenerator.generate(explanation, model);
			}
			if (attributeDesign.getRelevance()!=null) {
				attribute.relevanceDeductionIndex = model.addDeductionScheme(DeductionSchemeGenerator.generate(model.rootPackageName, attributeDesign.getRelevance()));
			}
			if (attributeDesign.getRule()!=null) {
				attribute.ruleDeductionIndex = model.addDeductionScheme(DeductionSchemeGenerator.generate(model.rootPackageName, attributeDesign.getRule()));
			}
			if (attributeDesign.getDefault()!=null) {
				attribute.defaultDeductionIndex = model.addDeductionScheme(DeductionSchemeGenerator.generate(model.rootPackageName, attributeDesign.getDefault()));
			}
			for (ValidationDesign validation:attributeDesign.getValidations()) {
				attribute.validations.add(validation.getTechnicalNameCapitalized());
			}
			model.attributes.add(attribute);
		}
		for (RelationDesign relationDesign: entityDesign.getRelations()) {
			if (!relationDesign.isValidForCodegeneration()) continue;
			EntityClassModel.Relation relation = new EntityClassModel.Relation();
			relation.name = relationDesign.getName();
			relation.id = relationDesign.getMetadata().getUniqueId();
			relation.technicalName = relationDesign.getTechnicalName();
			relation.technicalNameCapitalized = relationDesign.getTechnicalNameCapitalized();
			relation.javaIdentifier = relationDesign.getJavaIdentifier();
			relation.multivalue = (relationDesign.getDataType().getMultivalue()==Boolean.TRUE);
			relation.ordered = (relationDesign.getDataType().getOrdered()==Boolean.TRUE);
			relation.readonly = (relationDesign.getWriteable()==Boolean.FALSE);
			relation.owner = (relationDesign.getOwner()==Boolean.TRUE);
			relation.autoCreate = (relationDesign.getAutoCreate()==Boolean.TRUE);
			relation.item = relationDesign.getTo().getTechnicalNameCapitalized();
			relation.to = model.rootPackageName+"."+relation.item;
			if (relation.multivalue) {
				String valueClassName = relation.ordered?"ValueList":"Values";
				relation.internalItemClassName=relation.to.replace('.', '/');
				relation.to = "org.instantlogic.fabric.value."+valueClassName+"<"+relation.to+">";
				relation.internalTo="org/instantlogic/fabric/value/"+valueClassName;
			} else {
				relation.internalTo=relation.internalItemClassName=relation.to.replace('.', '/');
			}
			if (relationDesign.getReverseName()== null) {
				throw new RuntimeException("Reverse relation is mandatory");
			}
			relation.reverseName=relationDesign.getReverseName();
			relation.reverseJavaIdentifier = relationDesign.getReverseJavaIdentifier();
			if (relationDesign.getRule()!=null) {
				relation.ruleDeductionIndex = model.addDeductionScheme(DeductionSchemeGenerator.generate(model.rootPackageName, relationDesign.getRule()));
			}
			if (relationDesign.getOptions()!=null) {
				relation.optionsDeductionIndex = model.addDeductionScheme(DeductionSchemeGenerator.generate(model.rootPackageName, relationDesign.getOptions()));
			}
			for (ValidationDesign validation:relationDesign.getValidations()) {
				relation.validations.add(validation.getTechnicalNameCapitalized());
			}
			model.relations.add(relation);
		}
		for (RelationDesign relationDesign: entityDesign.getReverseRelations()) {
			if (relationDesign.getReverseName()!=null) {
				if (!relationDesign.isValidForCodegeneration()) continue;
				EntityClassModel.Relation relation = new EntityClassModel.Relation();
				// Inversion takes place here
				relation.name = relationDesign.getReverseName();
				relation.id = relationDesign.getMetadata().getUniqueId();
				relation.technicalName = relationDesign.getReverseTechnicalName();
				relation.technicalNameCapitalized = TechnicalNameDeduction.capitalizeFirst(relationDesign.getReverseTechnicalName());
				relation.javaIdentifier = relationDesign.getReverseJavaIdentifier();
				relation.multivalue = (relationDesign.getReverseMultivalue()==Boolean.TRUE);
				relation.reverseName = relationDesign.getTechnicalNameCapitalized();
				relation.reverseJavaIdentifier = relationDesign.getJavaIdentifier();
				relation.item = relationDesign.getFrom().getTechnicalNameCapitalized();
				relation.to = model.rootPackageName+"."+relation.item;
				if (relation.multivalue) {
					String valueClassName = relation.ordered?"ValueList":"Values";
					relation.internalItemClassName=relation.to.replace('.', '/');
					relation.to = "org.instantlogic.fabric.value."+valueClassName+"<"+relation.to+">";
					relation.internalTo="org/instantlogic/fabric/value/"+valueClassName;
				} else {
					relation.internalTo=relation.internalItemClassName=relation.to.replace('.', '/');
				}
				model.reverseRelations.add(relation);
			}
		}
		for (ValidationDesign validation: entityDesign.getValidations()) {
			model.validations.add(validation.getTechnicalNameCapitalized());
		}
		for (StaticInstanceDesign staticInstanceDesign: entityDesign.getStaticInstances()) {
			StaticInstance staticInstance = new StaticInstance();
			staticInstance.name = staticInstanceDesign.getName();
			staticInstance.javaIdentifier = staticInstanceDesign.getJavaIdentifier();
			staticInstance.description = TextGenerator.generate(staticInstanceDesign.getDescription(), model);
			for (StaticInstanceValueDesign valueDesign: staticInstanceDesign.getValues()) {
				StaticInstanceValue value = new StaticInstanceValue();
				value.attributeName = valueDesign.getAttribute().getTechnicalNameCapitalized();
				value.multivalue = valueDesign.getAttribute().getDataType().getMultivalue();
				if (valueDesign.getRelationValue()!=null) {
					value.value = new StaticFieldValueModel(model.rootPackageName + "."+ valueDesign.getRelationValue().getEntity().getTechnicalNameCapitalized(), valueDesign.getRelationValue().getJavaIdentifier(), "org.instantlogic.fabric.model.Relation");
				} else {
					value.value = new ConstantValueModel(valueDesign.getValue());
				}
				staticInstance.values.add(value);
			}
			model.staticInstances.add(staticInstance);
		}
		
		List<Design> newValidations = updateGenerators(validationGenerators, entityDesign.getValidations(), context);
		for (Design newDesign : newValidations) {
			ValidationDesign newValidation = (ValidationDesign) newDesign;
			ValidationGenerator validationGenerator = new ValidationGenerator(newValidation);
			validationGenerator.update(context);
			validationGenerators.put(newValidation.getName(), validationGenerator);
		}
		
		this.observations = new ObservationsOutdatedObserver(entityDesign.getMetadata().getCaseAdministration().stopRecordingObservations(), null);
		return model;
	}
	
	@Override
	public void queueClassModel(EntityClassModel classModel, GeneratedClassModels context) {
		context.updatedEntities.add(classModel);
	}

	private void setDatatype(Attribute attribute, DataTypeDesign dataType) {
		exportDatatype(attribute.dataType, dataType);
	}
	
	public static void exportDatatype(Map<String, Object> to, DataTypeDesign dataType) {
		if (dataType.getDataCategory()!=null) {
			to.put("category", dataType.getDataCategory().getMetadata().getStaticName());
		}
		if (dataType.getPercentage() == Boolean.TRUE) {
			to.put("percentage", true);
		}
		if (dataType.getWholeNumber() == Boolean.TRUE) {
			to.put("wholeNumber", true);
		}
		if (dataType.getExactRounding() == Boolean.TRUE) {
			to.put("exactRounding", true);
		}
		if (dataType.getMultiLine() == Boolean.TRUE) {
			to.put("multiLine", true);
		}
		if (dataType.getFormatted() == Boolean.TRUE) {
			to.put("formatted", true);
		}
		// In the future: Unit-prefix, unit-suffix, decimalPlaces
	}
}
