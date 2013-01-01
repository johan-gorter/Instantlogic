package org.instantlogic.designer.codegenerator.classmodel;

import java.util.ArrayList;
import java.util.List;

public class DeductionSchemeModel {

	public int index;
	public final List<DeductionModel> deductions = new ArrayList<DeductionModel>();

	public int getIndex() {
		return index;
	}

	public List<DeductionModel> getDeductions() {
		return deductions;
	}
	
	public int getLastDeductionIndex() {
		return deductions.size()-1;
	}

	public String getLastResultType() {
		return deductions.get(deductions.size()-1).resultType;
	}

	
}
