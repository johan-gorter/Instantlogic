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


public class PlaceTemplateDesign extends AbstractPlaceTemplateDesign {

	public PlaceTemplateDesign() {}
	
	public PlaceTemplateDesign(String name) {
		setName(name);
	}
	
	public void init() {
	}
	
    public PlaceTemplateDesign setOwner(org.instantlogic.designer.FlowDesign newValue) {
    	super.setOwner(newValue);
    	return this;
    }
    
    public void lookUpTypes() {
    	ElementDesign element = getContent();
    	lookUpTypes(element);
    }

	private void lookUpTypes(ElementDesign element) {
		if (element instanceof FragmentTemplateDesign) {
			FragmentTemplateDesign fragmentTemplate = (FragmentTemplateDesign)element;
			if (fragmentTemplate.getType()==null && fragmentTemplate.getFragmentTypeName()!=null) {
				fragmentTemplate.setType(findType(fragmentTemplate.getFragmentTypeName()));
			}
			for (PropertyDesign property: fragmentTemplate.getProperties()) {
				for(ElementDesign child : property.getChildren()) {
					lookUpTypes(child);
				}
			}
		} else if (element instanceof SelectionDesign) {
			SelectionDesign selection = (SelectionDesign)element;
			if(selection.getChild()!=null) {
				lookUpTypes(selection.getChild());
			}
		} else if (element instanceof IfElseDesign) {
			IfElseDesign ifElse = (IfElseDesign)element;
			if(ifElse.getIfChild()!=null) {
				lookUpTypes(ifElse.getIfChild());
			}
			if(ifElse.getElseChild()!=null) {
				lookUpTypes(ifElse.getElseChild());
			}
		} // SharedElements are not yet needed...
	}

	private FragmentTypeDesign findType(String name) {
		for (FragmentTypeDesign type : getOwner().getApplication().getFragmentTypes()) {
			if (type.getName().equals(name)) return type;
		}
		throw new RuntimeException("Unknown type: "+name);
	}
}
