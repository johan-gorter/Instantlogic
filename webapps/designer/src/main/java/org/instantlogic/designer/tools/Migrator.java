package org.instantlogic.designer.tools;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.FragmentTemplateContentDesign;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.FragmentTemplateTextDesign;
import org.instantlogic.designer.FragmentTemplateValueDesign;
import org.instantlogic.designer.FragmentTypeDesign;
import org.instantlogic.designer.PropertyDesign;
import org.instantlogic.fabric.value.AttributeValueList;

public class Migrator {

	public static void applyMigrations(ApplicationDesign newApp) {
		for (FragmentTypeDesign type: newApp.getFragmentTypes()) {
			for (FragmentTemplateDesign template : type.getUsages()) {
				updateTemplate(template);
			}
		}
	}

	private static void updateTemplate(FragmentTemplateDesign template) {
		FragmentTypeDesign type = template.getType();
		for (PropertyDesign property : template.getProperties()) {
			if (property.getChildren().size()>0) {
				System.out.println(type.getName()+" content: "+property.getPropertyName());
				addIfNotPresent(property.getPropertyName(), type.getContentPropertyNamesAttributeValue());
				FragmentTemplateContentDesign content = new FragmentTemplateContentDesign();
				content.setPropertyName(property.getPropertyName());
				template.addToContents(content);
				while (property.getChildren().size()>0) {
					content.addToChildren(property.getChildren().get(0));
				}
			} else if (property.getText()!=null && property.getText().getUntranslated().size()>0) {
				System.out.println(type.getName()+" text: "+property.getPropertyName());
				addIfNotPresent(property.getPropertyName(), type.getTextPropertyNamesAttributeValue());
				FragmentTemplateTextDesign text = new FragmentTemplateTextDesign();
				template.addToTexts(text);
				text.setPropertyName(property.getPropertyName());
				text.setText(property.getText());
			} else if (property.getValue()!=null && property.getValue().getOutput()!=null) {
				System.out.println(type.getName()+" value: "+property.getPropertyName());
				addIfNotPresent(property.getPropertyName(), type.getValuePropertyNamesAttributeValue());
				FragmentTemplateValueDesign value = new FragmentTemplateValueDesign();
				value.setPropertyName(property.getPropertyName());
				value.setValue(property.getValue());
				template.addToValues(value);
			} else {
				System.out.println(type.getName()+" NOTHING!");
			}
		}
		template.getPropertiesRelationValue().clear();
	}

	private static void addIfNotPresent(String value,
			AttributeValueList<FragmentTypeDesign, String> values) {
		for (String candidate : values.getValue()) {
			if (value.equals(candidate)) {
				return;
			}
		}
		System.out.println("New");
		values.addValue(value);
	}

}
