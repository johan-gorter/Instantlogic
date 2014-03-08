package org.instantlogic.designer;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeObserver;

public class FragmentTemplateDesign extends AbstractFragmentTemplateDesign {

	private ValueChangeObserver typeChangeObserver = new ValueChangeObserver() {
		
		@Override
		public void valueChanged(ValueChangeEvent event) {
			if (!event.isUndoEvent()) {
				afterTypeChange();
			}
		}
	};

	public FragmentTemplateDesign() {
		this.getTypeRelationValue().addValueChangeObserver(typeChangeObserver);
	}

	public FragmentTemplateDesign(String fragmentTypeName) {
		throw new UnsupportedOperationException();
	}
	
	public void afterTypeChange() {
		FragmentTypeDesign type = getType();
		if (type != null) {
			// Contents
			List<FragmentTemplateContentDesign> propertyRemovalCandidates = new ArrayList<>(getContents().asCollection());
			for (String name : type.getContentPropertyNames()) {
				FragmentTemplateContentDesign existingProperty = findProperty(propertyRemovalCandidates, name);
				if (existingProperty == null) {
					// Create and initialize a new property
					FragmentTemplateContentDesign newProperty = new FragmentTemplateContentDesign();
					addToContents(newProperty);
					newProperty.setPropertyName(name);
				} else {
					propertyRemovalCandidates.remove(existingProperty);
				}
			}
			// Remove old contents
			for (FragmentTemplateContentDesign remove : propertyRemovalCandidates) {
				// Policy: Never throw away data without explicit instruction from the user
				if (remove.getChildren().size() == 0) {
					removeFromContents(remove);
				}
			}
			// Texts
			List<FragmentTemplateTextDesign> textPropertyRemovalCandidates = new ArrayList<>(getTexts().asCollection());
			for (String name : type.getTextPropertyNames()) {
				FragmentTemplateTextDesign existingProperty = findProperty(textPropertyRemovalCandidates, name);
				if (existingProperty == null) {
					// Create and initialize a new property
					FragmentTemplateTextDesign newProperty = new FragmentTemplateTextDesign();
					addToTexts(newProperty);
					newProperty.setPropertyName(name);
				} else {
					textPropertyRemovalCandidates.remove(existingProperty);
				}
			}
			// Remove old Texts
			for (FragmentTemplateTextDesign remove : textPropertyRemovalCandidates) {
				// Policy: Never throw away data without explicit instruction from the user
				if (remove.getText().getUntranslated().size() == 0) {
					removeFromTexts(remove);
				}
			}

			// Values
			List<FragmentTemplateValueDesign> valuePropertyRemovalCandidates = new ArrayList<>(getValues().asCollection());
			for (String name : type.getValuePropertyNames()) {
				FragmentTemplateValueDesign existingProperty = findProperty(valuePropertyRemovalCandidates, name);
				if (existingProperty == null) {
					// Create and initialize a new property
					FragmentTemplateValueDesign newProperty = new FragmentTemplateValueDesign();
					addToValues(newProperty);
					newProperty.setPropertyName(name);
				} else {
					valuePropertyRemovalCandidates.remove(existingProperty);
				}
			}
			// Remove old Values
			for (FragmentTemplateValueDesign remove : valuePropertyRemovalCandidates) {
				// Policy: Never throw away data without explicit instruction from the user
				if (remove.getValue() == null || remove.getValue().getOutput() == null) {
					removeFromValues(remove);
				}
			}
		}
	}
	
	private <T extends PropertyDesign> T findProperty (List<T> properties, String name) {
		for (T property: properties) {
			if (property.getPropertyName()!=null && property.getPropertyName().equals(name)) {
				return property;
			}
		}
		return null;
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
