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

public class FragmentTemplateDesign extends AbstractFragmentTemplateDesign {

	public FragmentTemplateDesign() {
	}

	public FragmentTemplateDesign(String fragmentTypeName) {
		setFragmentTypeName(fragmentTypeName);
	}
	
	public boolean isValidForCodegeneration() {
		return (this.getType()!=null || this.getFragmentTypeName()!=null);
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
