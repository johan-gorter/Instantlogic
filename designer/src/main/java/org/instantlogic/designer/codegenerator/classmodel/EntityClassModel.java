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
		public String technicalName;
		public String javaIdentifier;
		public String className;
		public String itemClassName;
		public TextModel question;
		public boolean multivalue;
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
	}
	
	public static class Relation extends Attribute {
		public boolean owner;
		public String to;
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
	
	public static class StaticInstance {
		public String name;
		public String javaIdentifier;
		public TextModel description;
		
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
	public String getInternalName() {
		if (internalName==null) {
			internalName = getRootPackageInternalPrefix()+technicalNameCapitalized;
		}
		return internalName;
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
