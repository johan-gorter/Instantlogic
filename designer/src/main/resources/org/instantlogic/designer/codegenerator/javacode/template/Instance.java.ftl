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
package ${rootPackageName};
<#include "Text.java.ftl">

@SuppressWarnings({"unchecked","rawtypes","unused"})
public<#if isCustomized> abstract</#if> class <#if isCustomized>Abstract</#if>${technicalNameCapitalized} extends <#if extendsFrom??>${extendsFrom}<#else>org.instantlogic.fabric.Instance</#if> { 

	private static final java.util.Map<String, ${technicalNameCapitalized}> _staticInstances = new java.util.LinkedHashMap<String, ${technicalNameCapitalized}>();
	
	public static java.util.Map<String, ${technicalNameCapitalized}> getStatic${technicalNameCapitalized}Instances() {
		return _staticInstances;
	}
	
	private static ${technicalNameCapitalized} addStaticInstance(String name, ${technicalNameCapitalized} instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	<#list staticInstances as staticInstance>
	public static final ${technicalNameCapitalized} ${staticInstance.javaIdentifier};
	</#list>
	
	static {
	   <#list staticInstances as staticInstance>
	   ${staticInstance.javaIdentifier} = addStaticInstance("${staticInstance.name}", new ${technicalNameCapitalized}());
	   <#if staticInstance.description??>${staticInstance.javaIdentifier}.getMetadata().setStaticDescription(<@text_macro text=staticInstance.description />);</#if>
	   </#list>
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return ${rootPackageName}.entity.${technicalNameCapitalized}Entity.INSTANCE;
	}

	// Attributes
	<#list attributes as attribute>
	
	private final org.instantlogic.fabric.value.<#if attribute.readonly>ReadOnly</#if>AttributeValue<#if attribute.multivalue>s</#if><${technicalNameCapitalized}, ${attribute.itemClassName}> ${attribute.javaIdentifier}
		= create<#if attribute.readonly>ReadOnly</#if>AttributeValue<#if attribute.multivalue>s</#if>(${rootPackageName}.entity.${technicalNameCapitalized}Entity.${attribute.javaIdentifier});
	
	public ${attribute.className} get${attribute.technicalName?cap_first}() {
		return ${attribute.javaIdentifier}.getValue();
	}

	public org.instantlogic.fabric.value.<#if attribute.readonly>ReadOnly</#if>AttributeValue<#if attribute.multivalue>s</#if><${technicalNameCapitalized}, ${attribute.itemClassName}> get${attribute.technicalName?cap_first}AttributeValue() {
		return ${attribute.javaIdentifier};
	}

	<#if !attribute.readonly && !attribute.multivalue>	
	public ${technicalNameCapitalized} set${attribute.technicalName?cap_first}(${attribute.className} newValue) {
		${attribute.javaIdentifier}.setValue(newValue);
		return (${technicalNameCapitalized})this;
	}
	
	</#if>
	<#if !attribute.readonly && attribute.multivalue>	
	public ${technicalNameCapitalized} addTo${attribute.technicalName?cap_first}(${attribute.itemClassName} item) {
		${attribute.javaIdentifier}.addValue(item);
		return (${technicalNameCapitalized})this;
	}
	
	public ${technicalNameCapitalized} addTo${attribute.technicalName?cap_first}(${attribute.itemClassName} item, int index) {
		${attribute.javaIdentifier}.insertValue(item, index);
		return (${technicalNameCapitalized})this;
	}
	
	public ${technicalNameCapitalized} removeFrom${attribute.technicalName?cap_first}(${attribute.itemClassName} item) {
		${attribute.javaIdentifier}.removeValue(item);
		return (${technicalNameCapitalized})this;
	}
	
	public ${technicalNameCapitalized} removeFrom${attribute.technicalName?cap_first}(int index) {
		${attribute.javaIdentifier}.removeValue(index);
		return (${technicalNameCapitalized})this;
	}
	
	</#if>
	</#list>
	
	// Relations
	<#list relations as relation>
	
	private final org.instantlogic.fabric.value.<#if relation.readonly>ReadOnly</#if>RelationValue<#if relation.multivalue>s</#if><${technicalNameCapitalized}, ${relation.item}> ${relation.javaIdentifier}
		= create<#if relation.readonly>ReadOnly</#if>RelationValue<#if relation.multivalue>s</#if>(${rootPackageName}.entity.${technicalNameCapitalized}Entity.${relation.javaIdentifier});
		
	public org.instantlogic.fabric.value.<#if relation.readonly>ReadOnly</#if>RelationValue<#if relation.multivalue>s</#if><${technicalNameCapitalized}, ${relation.item}> get${relation.technicalName?cap_first}RelationValue() {
		return ${relation.javaIdentifier};
	}

	public ${relation.to} get${relation.technicalName?cap_first}() {
		return ${relation.javaIdentifier}.getValue();
	}
	
	<#if !relation.readonly && !relation.multivalue>	
	public ${technicalNameCapitalized} set${relation.technicalName?cap_first}(${relation.to} newValue) {
		${relation.javaIdentifier}.setValue(newValue);
		return (${technicalNameCapitalized})this;
	}
	
	<#if relation.owner>	
	public ${relation.to} new${relation.technicalName?cap_first}() {
		${relation.to} newValue = new ${relation.to}(); 
		${relation.javaIdentifier}.setValue(newValue);
		return newValue;
	}
	</#if>

	</#if>
	<#if !relation.readonly && relation.multivalue>	
	public ${technicalNameCapitalized} addTo${relation.technicalName?cap_first}(${relation.item} item) {
		${relation.javaIdentifier}.addValue(item);
		return (${technicalNameCapitalized})this;
	}
	
	public ${technicalNameCapitalized} addTo${relation.technicalName?cap_first}(${relation.item} item, int index) {
		${relation.javaIdentifier}.insertValue(item, index);
		return (${technicalNameCapitalized})this;
	}
	
	public ${technicalNameCapitalized} removeFrom${relation.technicalName?cap_first}(${relation.item} item) {
		${relation.javaIdentifier}.removeValue(item);
		return (${technicalNameCapitalized})this;
	}
	
	public ${technicalNameCapitalized} removeFrom${relation.technicalName?cap_first}(int index) {
		${relation.javaIdentifier}.removeValue(index);
		return (${technicalNameCapitalized})this;
	}
	
	</#if>
	</#list>

	// Reverse relations
	<#list reverseRelations as relation>
	
	private final org.instantlogic.fabric.value.RelationValue<#if relation.multivalue>s</#if><${technicalNameCapitalized}, ${relation.item}> ${relation.javaIdentifier}
		= createReverseRelationValue<#if relation.multivalue>s</#if>(${rootPackageName}.entity.${technicalNameCapitalized}Entity.${relation.javaIdentifier});

	public org.instantlogic.fabric.value.RelationValue<#if relation.multivalue>s</#if><${technicalNameCapitalized}, ${relation.item}> get${relation.technicalName?cap_first}RelationValue() {
		return ${relation.javaIdentifier};
	}

	public ${relation.to} get${relation.technicalName?cap_first}() {
		return ${relation.javaIdentifier}.getValue();
	}

    <#if relation.multivalue>
    public ${technicalNameCapitalized} addTo${relation.technicalName?cap_first}(${relation.item} item) {
        ${relation.javaIdentifier}.addValue(item);
        return (${technicalNameCapitalized})this;
    }

    public ${technicalNameCapitalized} removeFrom${relation.technicalName?cap_first}(${relation.item} item) {
        ${relation.javaIdentifier}.removeValue(item);
        return (${technicalNameCapitalized})this;
    }
    <#else>
    public ${technicalNameCapitalized} set${relation.technicalName?cap_first}(${relation.to} newValue) {
        ${relation.javaIdentifier}.setValue(newValue);
        return (${technicalNameCapitalized})this;
    }
    </#if>

	</#list>

}
