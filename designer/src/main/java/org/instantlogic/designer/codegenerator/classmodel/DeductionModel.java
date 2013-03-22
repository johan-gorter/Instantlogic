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

public class DeductionModel {
	public static class Input {
		public int deductionIndex;
		public String inputName;
		public boolean multivalue;

		public String getInputName() {
			return inputName;
		}

		public boolean isMultivalue() {
			return multivalue;
		}

		public void setDeductionIndex(int deductionIndex) {
			this.deductionIndex = deductionIndex;
		}

		public int getDeductionIndex() {
			return deductionIndex;
		}
	}
	
	public int index;
	public String type;
	public String resultType;
	public String customization;
	public List<Input> inputs = new ArrayList<Input>();
	public List<ValueModel> parameters = new ArrayList<ValueModel>();
	
	public List<ValueModel> getParameters() {
		return parameters;
	}
	public int getIndex() {
		return index;
	}
	public String getType() {
		return type;
	}
	public String getResultType() {
		return resultType;
	}
	public List<Input> getInputs() {
		return inputs;
	}
	public String getCustomization() {
		return customization;
	}
}
