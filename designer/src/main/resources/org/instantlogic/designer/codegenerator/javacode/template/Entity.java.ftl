<#--
Copyright 2013, Johan Gorter
This file is part of Instantlogic.
Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
General Public License for more details. You should have received a copy of the GNU Lesser General Public License
along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
-->
package ${rootPackageName}.entity;
<#include "Text.java.ftl">
<#include "DeductionScheme.java.ftl">

@SuppressWarnings({"unchecked","rawtypes"})
public class ${technicalNameCapitalized}Entity extends org.instantlogic.fabric.model.Entity<${rootPackageName}.${technicalNameCapitalized}> {

	public static final ${technicalNameCapitalized}Entity INSTANCE = new ${technicalNameCapitalized}Entity();
	
	<#if extendsFrom??>
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return ${rootPackageName}.entity.${extendsFrom}Entity.INSTANCE;
	}
	</#if>

	<#if extensions?size != 0>
	private static final org.instantlogic.fabric.model.Entity<?>[] EXTENSIONS = new org.instantlogic.fabric.model.Entity<?>[] {
		<#list extensions as extension>
		${rootPackageName}.entity.${extension}Entity.INSTANCE<#if extension_has_next>,</#if>
		</#list>
	};
	 
	@Override
	public org.instantlogic.fabric.model.Entity[] extensions() {
		return EXTENSIONS;
	}
	</#if>
	
	@Override
	public ${rootPackageName}.${technicalNameCapitalized} createInstance() {
		return new ${rootPackageName}.${technicalNameCapitalized}();
	}
	
	@Override
	public Class<${rootPackageName}.${technicalNameCapitalized}> getInstanceClass() {
		return ${rootPackageName}.${technicalNameCapitalized}.class;
	}
	
	@Override
	public String getName() {
		return "${name}";
	}

	// Deductions
	<#list deductionSchemes as scheme>
		<@deductionscheme_macro scheme=scheme />
	</#list>

	<#if title??>
	// Title
	private org.instantlogic.fabric.text.TextTemplate title;
	@Override
	public org.instantlogic.fabric.text.TextTemplate getTitle() {
		if (title==null) {
			title = <@text_macro text=title />;
		}
		return title;
	}
	</#if>
	
	// Attributes
	<#list attributes as attribute>
	
	public static final org.instantlogic.fabric.model.Attribute<${rootPackageName}.${technicalNameCapitalized}, ${attribute.className}, ${attribute.itemClassName}> ${attribute.javaIdentifier} 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<${rootPackageName}.${technicalNameCapitalized}, ${attribute.className}, ${attribute.itemClassName}>(
			"${attribute.name}", INSTANCE, ${attribute.itemClassName}.class
		) {
			{
			<#list attribute.dataType?keys as key>
			<#if attribute.dataType[key]?is_string>
				dataType.put("${key}", "${attribute.dataType[key]}");
			<#elseif attribute.dataType[key]?is_boolean>
				dataType.put("${key}", <#if attribute.dataType[key]>true<#else>false</#if>);
			<#else>
				dataType.put("${key}", ${attribute.dataType[key]});
			</#if>
			</#list>
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<#if attribute.multivalue>s</#if><${rootPackageName}.${technicalNameCapitalized}, ${attribute.itemClassName}> get(${rootPackageName}.${technicalNameCapitalized} instance) {
				return instance.get${attribute.technicalName?cap_first}AttributeValue();
			}
			<#if attribute.multivalue>
	
			public boolean isMultivalue() {
				return true;
			}
			</#if>
			<#if attribute.question??>
			
			private final org.instantlogic.fabric.text.TextTemplate question = <@text_macro text=attribute.question />;
			@Override
			public org.instantlogic.fabric.text.TextTemplate getQuestion() {
				return question;
			}
			</#if>
			<#if attribute.readonly>
			
			public boolean isReadOnly() {
				return true;
			};
			</#if>
            <#if attribute.relevanceDeductionIndex??>

            private org.instantlogic.fabric.deduction.Deduction<Boolean> relevance;
            @Override
            public org.instantlogic.fabric.deduction.Deduction<Boolean> getRelevance() {
                if (relevance==null) {
                    relevance = createDeduction${attribute.relevanceDeductionIndex}();
                }
                return relevance;
            }
            </#if>
            <#if attribute.ruleDeductionIndex??>

            private org.instantlogic.fabric.deduction.Deduction<${attribute.itemClassName}> rule;
            @Override
            public org.instantlogic.fabric.deduction.Deduction<${attribute.itemClassName}> getRule() {
                if (rule==null) {
                    rule = createDeduction${attribute.ruleDeductionIndex}();
                }
                return rule;
            }
            </#if>
            <#if attribute.defaultDeductionIndex??>

            private org.instantlogic.fabric.deduction.Deduction<${attribute.itemClassName}> defaultDeduction;
            @Override
            public org.instantlogic.fabric.deduction.Deduction<${attribute.itemClassName}> getDefault() {
                if (defaultDeduction==null) {
                    defaultDeduction = createDeduction${attribute.defaultDeductionIndex}();
                }
                return defaultDeduction;
            }
            </#if>
            
            <#if attribute.validations?size!=0>
            
            public org.instantlogic.fabric.model.Validation[] validations;
			@Override
			public org.instantlogic.fabric.model.Validation[] getValidations() {
				if (validations==null) {
					validations = new org.instantlogic.fabric.model.Validation[] {
						<#list attribute.validations as validation>
						${rootPackageName}.validation.${validation}Validation.INSTANCE,
						</#list>
					};
				}
				return validations;
			}
			</#if>
		};
	</#list>
	
	// Relations
	<#list relations as relation>
	
	public static final org.instantlogic.fabric.model.Relation<${rootPackageName}.${technicalNameCapitalized}, ${relation.to}, ${rootPackageName}.${relation.item}> ${relation.javaIdentifier}
		= new org.instantlogic.fabric.model.impl.SimpleRelation<${rootPackageName}.${technicalNameCapitalized}, ${relation.to}, ${rootPackageName}.${relation.item}>(
			"${relation.technicalName}", INSTANCE, ${rootPackageName}.entity.${relation.item}Entity.INSTANCE, ${rootPackageName}.${relation.item}.class, 
			<#if relation.reverseName??>${rootPackageName}.entity.${relation.item}Entity.${relation.reverseJavaIdentifier}<#else>null</#if>
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<#if relation.multivalue>s</#if><${rootPackageName}.${technicalNameCapitalized}, ${rootPackageName}.${relation.item}> get(
					${rootPackageName}.${technicalNameCapitalized} instance) {
				return instance.get${relation.technicalName?cap_first}RelationValue();
			}
			<#if relation.owner>
	
			public boolean isOwner() {
				return true;
			}
			</#if>
			<#if relation.autoCreate>
	
			public boolean isAutoCreate() {
				return true;
			}
			</#if>
			<#if relation.multivalue>
	
			public boolean isMultivalue() {
				return true;
			}
			</#if>
			<#if relation.readonly>
	
			public boolean isReadOnly() {
				return true;
			}
			</#if>
			<#if relation.ruleDeductionIndex??>

			private org.instantlogic.fabric.deduction.Deduction<${relation.to}> rule;
			@Override
			public org.instantlogic.fabric.deduction.Deduction<${relation.to}> getRule() {
				if (rule==null) {
					rule  = createDeduction${relation.ruleDeductionIndex}();
				}
				return rule;
			}
			</#if>
			<#if relation.optionsDeductionIndex??>
			
			private org.instantlogic.fabric.deduction.Deduction<? extends java.lang.Iterable<${relation.to}>> options;
			@Override
			public org.instantlogic.fabric.deduction.Deduction<? extends java.lang.Iterable<${relation.to}>> getOptions() {
				if (options==null) {
					options = (org.instantlogic.fabric.deduction.Deduction)createDeduction${relation.optionsDeductionIndex}();
				}
				return options;
			};
			</#if>
            <#if relation.validations?size!=0>
            
            public org.instantlogic.fabric.model.Validation[] validations;
			@Override
			public org.instantlogic.fabric.model.Validation[] getValidations() {
				if (validations==null) {
					validations = new org.instantlogic.fabric.model.Validation[] {
						<#list relation.validations as validation>
						${rootPackageName}.validation.${validation}Validation.INSTANCE,
						</#list>
					};
				}
				return validations;
			}
			</#if>
		};
	</#list>
	
	// Reverse relations
	<#list reverseRelations as relation>
	
	public static final org.instantlogic.fabric.model.Relation<${rootPackageName}.${technicalNameCapitalized}, ${relation.to}, ${rootPackageName}.${relation.item}> ${relation.javaIdentifier}
		= new org.instantlogic.fabric.model.impl.SimpleRelation<${rootPackageName}.${technicalNameCapitalized}, ${relation.to}, ${rootPackageName}.${relation.item}>(
			"${relation.technicalName}", INSTANCE, ${rootPackageName}.entity.${relation.item}Entity.INSTANCE, ${rootPackageName}.${relation.item}.class, ${rootPackageName}.entity.${relation.item}Entity.${relation.reverseJavaIdentifier}
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<#if relation.multivalue>s</#if><${rootPackageName}.${technicalNameCapitalized}, ${rootPackageName}.${relation.item}> get(
					${rootPackageName}.${technicalNameCapitalized} instance) {
				return instance.get${relation.technicalName?cap_first}RelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
			<#if relation.multivalue>
	
			public boolean isMultivalue() {
				return true;
			}
			</#if>
		};
	</#list>

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		<#list attributes as attribute>
		${attribute.javaIdentifier},
		</#list>
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		<#list relations as relation>
		${relation.javaIdentifier},
		</#list>
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		<#list reverseRelations as relation>
		${relation.javaIdentifier},
		</#list>
	};
	private static final org.instantlogic.fabric.model.Validation[] VALIDATIONS = new org.instantlogic.fabric.model.Validation[]{
		<#list validations as validation>
		${rootPackageName}.validation.${validation}Validation.INSTANCE,
		</#list>
	};
	

	@Override
	public org.instantlogic.fabric.model.Attribute[] getLocalAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public org.instantlogic.fabric.model.Relation[] getLocalRelations() {
		return RELATIONS;
	}

	@Override
	public org.instantlogic.fabric.model.Relation[] getLocalReverseRelations() {
		return REVERSE_RELATIONS;
	}
	@Override
	public org.instantlogic.fabric.model.Validation[] getLocalValidations() {
		return VALIDATIONS;
	}
	
	@Override
	public java.util.Map<String, ${rootPackageName}.${technicalNameCapitalized}> getStaticInstances() {
		return ${rootPackageName}.${technicalNameCapitalized}.getStatic${technicalNameCapitalized}Instances();
	}
}
