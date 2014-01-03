package org.instantlogic.designer;

import org.instantlogic.designer.codegenerator.classmodel.StaticFieldValueModel;
import org.instantlogic.designer.codegenerator.classmodel.ValueModel;

public class AttributeDesign extends AbstractAttributeDesign {

	protected boolean isNameUnique(String name) {
		if (name!=null && name.length()>0) { // getDataType().getJavaClassName()!=null removed
			for (AttributeDesign attribute: getBelongsToEntity().getAttributesAndRelations()) {
				if (name.equals(attribute.getName()) && attribute!=this) return false;
			}
			return true;
		}
		return false;
	}
	
	// TODO: override for RelationDesign and take the uniqueness of the reverseRelation into account 
	public boolean isValidForCodegeneration() {
		String name = getName();
		if (this instanceof RelationDesign) {
			if (((RelationDesign)this).getTo()==null) return false;
		}
		return isNameUnique(name);
	}
	
	// Makes the API easier to use
	@Override
	public AttributeDesign setRelevance(DeductionSchemeDesign newValue) {
		setHasRelevance(true); // Needed for the GUI
		return super.setRelevance(newValue);
	}

	// Makes the API easier to use
	@Override
	public AttributeDesign setRule(DeductionSchemeDesign newValue) {
		setHasRule(true);
		return super.setRule(newValue);
	}

	// Makes the API easier to use
	@Override
	public AttributeDesign setDefault(DeductionSchemeDesign newValue) {
		setHasDefault(true);
		return super.setDefault(newValue);
	}
	
	public ValueModel asStaticFieldValue() {
		EntityDesign entity = getBelongsToEntity();
		return new StaticFieldValueModel(entity.getApplication().getRootPackageName()+".entity."+entity.getTechnicalNameCapitalized()+"Entity", getJavaIdentifier(), 
			(this instanceof RelationDesign)?"org.instantlogic.fabric.model.Relation":"org.instantlogic.fabric.model.Attribute");
	}
	
	public AttributeDesign ordered() {
		getDataType().setOrdered(true);
		return this;
	}

	public AttributeDesign multivalue() {
		getDataType().setMultivalue(true);
		return this;
	}

}
