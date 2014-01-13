package org.instantlogic.designer.codegenerator.classmodel;


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
	public boolean attributeIsRelation;
	public boolean required;
	public boolean readOnly;
	public String relationEntity;
	public String relationName;
	public String destination;
	@Deprecated
	public String event;
	public String[] styleNames;
	public String[] fragmentFilters;
	public ContentModel child;
	public ContentModel elseChild;
	public String implementationClassName;
	
	public final Map<String, Integer> values = new HashMap<String, Integer>();
	public final Map<String, TextModel> texts = new HashMap<String, TextModel>();
	public final Map<String, List<ContentModel>> childLists = new HashMap<String, List<ContentModel>>();
	
	private String rootPackageInternalPrefix;
	
	public String getRootPackageInternalPrefix() {
		if (rootPackageInternalPrefix==null) {
			rootPackageInternalPrefix = rootPackageName.replace(".", "/")+"/";
		}
		return rootPackageInternalPrefix;
	}
	
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
	public Map<String, Integer> getValues() {
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
	public String getDestination() {
		return destination;
	}
}
