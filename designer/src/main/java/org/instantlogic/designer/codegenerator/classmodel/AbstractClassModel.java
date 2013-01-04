/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer.codegenerator.classmodel;

import java.util.ArrayList;
import java.util.List;



/**
 * Represents all the data used to construct a (possibly Java) class. 
 */
public abstract class AbstractClassModel {

	private List<DeductionSchemeModel> deductionSchemes = new ArrayList<DeductionSchemeModel>();
	
	public String rootPackageName;
	public String name;
	public String technicalNameCapitalized;
	public String id;
	public boolean isCustomized;
	
	private String rootPackageInternalPrefix;
	
	public String getRootPackageName() {
		return rootPackageName;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getIsCustomized() {
		return isCustomized;
	}
	
	public List<DeductionSchemeModel> getDeductionSchemes() {
		return deductionSchemes;
	}
	
	public int addDeductionScheme(DeductionSchemeModel scheme) {
		int deductionIndex = deductionSchemes.size();
		deductionSchemes.add(scheme);
		scheme.index = deductionIndex;
		return deductionIndex;
	}

	public String getRootPackageInternalPrefix() {
		if (rootPackageInternalPrefix==null) {
			rootPackageInternalPrefix = rootPackageName.replace(".", "/")+"/";
		}
		return rootPackageInternalPrefix;
	}

	public String getTechnicalNameCapitalized() {
		return technicalNameCapitalized;
	}

	public String getId() {
		return id;
	}
}
