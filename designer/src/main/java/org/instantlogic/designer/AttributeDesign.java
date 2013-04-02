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

import org.instantlogic.designer.codegenerator.classmodel.StaticFieldValueModel;
import org.instantlogic.designer.codegenerator.classmodel.ValueModel;

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
	
	public ValueModel asStaticFieldValue() {
		EntityDesign entity = getBelongsToEntity();
		return new StaticFieldValueModel(entity.getApplication().getRootPackageName()+".entity."+entity.getTechnicalNameCapitalized()+"Entity", getTechnicalName());
	}

}
