package org.instantlogic.designer.codegenerator.classmodel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EntityClassModel extends AbstractClassModel {

	public static class Attribute implements Comparable<Attribute>{

		public static class DomainEntry {
			public String name;
			public TextModel display;
			
			public String getName() {
				return name;
			}
			public TextModel getDisplay() {
				return display;
			}
		}
		
		public String name;
		public String id;
		public String technicalName;
		public String technicalNameCapitalized;
		public String javaIdentifier;
		public String className;
		public String internalClassName;
		public String itemClassName;
		public String internalItemClassName;
		public TextModel question;
		public boolean multivalue;
		public boolean ordered;
		public boolean readonly;
		public TextModel explanation;
		public List<DomainEntry> domain;
		public Integer relevanceDeductionIndex;
		public Integer ruleDeductionIndex;
		public Integer defaultDeductionIndex;
		public Integer optionsDeductionIndex;
		public final Map<String, Object> dataType = new LinkedHashMap<String, Object>();
		public final List<String> validations = new ArrayList<String>();
		
		public Map<String, Object> getDataType() {
			return dataType;
		}
		public String getName() {
			return name;
		}
		public String getClassName() {
			return className;
		}
		public boolean isMultivalue() {
			return multivalue;
		}
		public boolean isOrdered() {
			return ordered;
		}
		public boolean isReadonly() {
			return readonly;
		}
		public List<DomainEntry> getDomain() {
			return domain;
		}
		public String getItemClassName() {
			return itemClassName;
		}
		public TextModel getQuestion() {
			return question;
		}
		public TextModel getExplanation() {
			return explanation;
		}
		public Integer getRuleDeductionIndex() {
			return ruleDeductionIndex;
		}
		public Integer getDefaultDeductionIndex() {
			return defaultDeductionIndex;
		}
		public Integer getRelevanceDeductionIndex() {
			return relevanceDeductionIndex;
		}
		@Override
		public int compareTo(Attribute o) {
			return this.name.compareTo(o.name);
		}
		public String getTechnicalName() {
			return technicalName;
		}
		public String getJavaIdentifier() {
			return javaIdentifier;
		}
		public Integer getOptionsDeductionIndex() {
			return optionsDeductionIndex;
		}
		public List<String> getValidations() {
			return validations;
		}
		public String getId() {
			return id;
		}
		
		// getReadOnlyRelationValue...
		public String getValueSuffix() {
			if (multivalue) {
				if (ordered) {
					return "List";
				} else {
					return "s";
				}
			}
			return "";
		}
	}
	
	public static class Relation extends Attribute {
		public boolean owner;
		public String to;
		public String internalTo;
		public String item;
		public String reverseName;
		public boolean autoCreate;
		public String reverseJavaIdentifier;
		
		public boolean isOwner() {
			return owner;
		}

		public String getTo() {
			return to;
		}

		public String getItem() {
			return item;
		}

		public String getReverseName() {
			return reverseName;
		}

		public boolean isAutoCreate() {
			return autoCreate;
		}

		public String getReverseJavaIdentifier() {
			return reverseJavaIdentifier;
		}
	}
	
	public static class StaticInstanceValue {
		public ValueModel value;
		public boolean multivalue;
		public String attributeName;
		
		public ValueModel getValue() {
			return value;
		}
		public boolean isMultivalue() {
			return multivalue;
		}
		public String getAttributeName() {
			return attributeName;
		}
	}
	
	public static class StaticInstance {
		public String name;
		public String javaIdentifier;
		public TextModel description;
		public final List<StaticInstanceValue> values = new ArrayList<StaticInstanceValue>();
		
		public List<StaticInstanceValue> getValues() {
			return values;
		}
		public String getName() {
			return name;
		}
		public TextModel getDescription() {
			return description;
		}
		public String getJavaIdentifier() {
			return javaIdentifier;
		}
	}

	public String extendsFrom;
	public TextModel title;
	
	public final List<String> extensions = new ArrayList<String>();
	public final List<StaticInstance> staticInstances = new ArrayList<StaticInstance>();
	public final List<Attribute> attributes = new ArrayList<Attribute>();
	public final List<Relation> relations = new ArrayList<Relation>();
	public final List<Relation> reverseRelations = new ArrayList<Relation>();
	public final List<String> validations = new ArrayList<String>();
	
	private String internalName;
	private String internalEntityName;
	
	public List<String> getExtensions() {
		return extensions;
	}
	public List<Attribute> getAttributes() {
		return attributes;
	}
	public List<Relation> getRelations() {
		return relations;
	}
	public List<Relation> getReverseRelations() {
		return reverseRelations;
	}
	public String getExtendsFrom() {
		return extendsFrom;
	}
	public String getExtendsFromEntityInternalName() {
		return getRootPackageInternalPrefix()+"entity/"+extendsFrom+"Entity";
	}

	public String getInternalEntityName() {
		if (internalEntityName==null) {
			internalEntityName = getRootPackageInternalPrefix()+"entity/"+technicalNameCapitalized+"Entity";
		}
		return internalEntityName;
	}
	public List<StaticInstance> getStaticInstances() {
		return staticInstances;
	}
	public TextModel getTitle() {
		return title;
	}
	public List<String> getValidations() {
		return validations;
	}
}
