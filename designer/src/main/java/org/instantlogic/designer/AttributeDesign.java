package org.instantlogic.designer;

public class AttributeDesign extends AbstractAttributeDesign {
	
	// TODO: override for RelationDesign and take the uniqueness of the reverseRelation into account 
	public boolean isValidForCodegeneration() {
		String name = getName();
		if (getDataType().getJavaClassName()!=null && name!=null && name.length()>0) {
			for (AttributeDesign attribute: getBelongsToEntity().getAttributesAndRelations()) {
				if (name.equals(attribute.getName()) && attribute!=this) return false;
			}
			return true;
		}
		return false;
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

}
