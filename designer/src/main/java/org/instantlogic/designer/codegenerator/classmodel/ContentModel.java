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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContentModel {

	public enum Category {Fragment, Shared, Selection, IfElse}
	
	public Category category;
	// Text, Button, ...
	public String fragmentTypeName;
	public String answerWidgetName;

	//F1P2...
	public String id;

	public String rootPackageName;
	public String name;
	
	public TextModel text;

	public int deductionIndex;
	public String entity;
	public String attribute;
	public boolean required;
	public boolean readOnly;
	public String relationEntity;
	public String relationName;
	public String event;
	public boolean isCustomized;
	public String[] styleNames;
	public String[] fragmentFilters;
	public ContentModel child;
	public ContentModel elseChild;
	public String implementationClassName;
	
	public final Map<String, Object> values = new HashMap<String, Object>();
	public final Map<String, TextModel> texts = new HashMap<String, TextModel>();
	public final Map<String, List<ContentModel>> childLists = new HashMap<String, List<ContentModel>>();
	
	public boolean isRequired() {
		return required;
	}
	public boolean isReadOnly() {
		return readOnly;
	}

	public String getRelationEntity() {
		return relationEntity;
	}

	public String getRelationName() {
		return relationName;
	}

	public TextModel getText() {
		return text;
	}
	public String getEvent() {
		return event;
	}
	public boolean getIsCustomized() {
		return isCustomized;
	}
	public int getDeductionIndex() {
		return deductionIndex;
	}
	public String getEntity() {
		return entity;
	}
	public String getAttribute() {
		return attribute;
	}
	public String getImplementationClassName() {
		return implementationClassName;
	}
	public String getRootPackageName() {
		return rootPackageName;
	}
	public Category getCategory() {
		return category;
	}
	public String getFragmentTypeName() {
		return fragmentTypeName;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAnswerWidgetName() {
		return answerWidgetName;
	}
	public Map<String, List<ContentModel>> getChildLists() {
		return childLists;
	}
	public Map<String, Object> getValues() {
		return values;
	}
	public Map<String, TextModel> getTexts() {
		return texts;
	}
	public ContentModel getChild() {
		return child;
	}
	public ContentModel getElseChild() {
		return elseChild;
	}
	public String[] getStyleNames() {
		return styleNames;
	}
	public String[] getFragmentFilters() {
		return fragmentFilters;
	}
}
