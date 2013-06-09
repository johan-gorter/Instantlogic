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
