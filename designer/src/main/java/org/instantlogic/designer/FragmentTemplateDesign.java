package org.instantlogic.designer;

public class FragmentTemplateDesign extends AbstractFragmentTemplateDesign {

	public FragmentTemplateDesign() {
	}

	public FragmentTemplateDesign(String fragmentTypeName) {
		setFragmentTypeName(fragmentTypeName);
	}
	
	public boolean isValidForCodegeneration() {
		if (this.getType()==null && this.getFragmentTypeName()==null) {
			return false;
		}
		if (this.getAttribute()!=null && !this.getAttribute().isValidForCodegeneration()) {
			return false;
		}
		return true;
	}

	public FragmentTemplateDesign setText(String propertyName, TextTemplateDesign text) {
		PropertyDesign fragmentText = new PropertyDesign();
		fragmentText.setPropertyName(propertyName);
		fragmentText.setText(text);
		addToProperties(fragmentText);
		return this;
	}
	
	public FragmentTemplateDesign setChildren(String propertyName, ElementDesign... children) {
		PropertyDesign childList= new PropertyDesign();
		childList.setPropertyName(propertyName);
		for (ElementDesign child: children) {
			childList.addToChildren(child);
		}
		addToProperties(childList);
		return this;
	}
	
	public FragmentTemplateDesign setValue(String propertyName, DeductionSchemeDesign value) {
		PropertyDesign fragmentValue = new PropertyDesign();
		fragmentValue.setPropertyName(propertyName);
		fragmentValue.setValue(value);
		addToProperties(fragmentValue);
		return this;
	}
}
