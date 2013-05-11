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
	private static final org.instantlogic.fabric.model.Entity<?>[] EXTENSIONS;
	 
	@Override
	public org.instantlogic.fabric.model.Entity[] extensions() {
		return EXTENSIONS;
	}
	</#if>
	
	// Deductions
	<#list deductionSchemes as scheme>
		<@deductionscheme_macro scheme=scheme />
	</#list>

	<#if title??>
	// Title
	private static final org.instantlogic.fabric.text.TextTemplate title;
	@Override
	public org.instantlogic.fabric.text.TextTemplate getTitle() {
		return title;
	}
	</#if>
	
	// Attributes
	<#list attributes as attribute>
	public static final org.instantlogic.fabric.model.Attribute<${rootPackageName}.${technicalNameCapitalized}, ${attribute.className}, ${attribute.itemClassName}> ${attribute.javaIdentifier}; 
	</#list>
	
	// Relations
	<#list relations as relation>
	public static final org.instantlogic.fabric.model.Relation<${rootPackageName}.${technicalNameCapitalized}, ${relation.to}, ${rootPackageName}.${relation.item}> ${relation.javaIdentifier};
	</#list>
	
	// Reverse relations
	<#list reverseRelations as relation>
	public static final org.instantlogic.fabric.model.Relation<${rootPackageName}.${technicalNameCapitalized}, ${relation.to}, ${rootPackageName}.${relation.item}> ${relation.javaIdentifier};
	</#list>

	static {
		// Phase 1
		// Attributes
		<#list attributes as attribute>
		org.instantlogic.fabric.model.impl.SimpleAttribute<${rootPackageName}.${technicalNameCapitalized}, ${attribute.className}, ${attribute.itemClassName}> $${attribute.javaIdentifier}
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<${rootPackageName}.${technicalNameCapitalized}, ${attribute.className}, ${attribute.itemClassName}>(
				"${attribute.id}", "${attribute.name}", INSTANCE, ${attribute.itemClassName}.class, "${attribute.javaIdentifier}", ${rootPackageName}.<#if isCustomized>Abstract</#if>${technicalNameCapitalized}.class);
		${attribute.javaIdentifier} = $${attribute.javaIdentifier};
		</#list>
		// Relations
		<#list relations as relation>
		org.instantlogic.fabric.model.impl.SimpleRelation<${rootPackageName}.${technicalNameCapitalized}, ${relation.to}, ${rootPackageName}.${relation.item}> $${relation.javaIdentifier}
			= new org.instantlogic.fabric.model.impl.SimpleRelation<${rootPackageName}.${technicalNameCapitalized}, ${relation.to}, ${rootPackageName}.${relation.item}>(
				"${relation.id}", "${relation.name}", INSTANCE, "${relation.javaIdentifier}", ${rootPackageName}.<#if isCustomized>Abstract</#if>${technicalNameCapitalized}.class);
		${relation.javaIdentifier} = $${relation.javaIdentifier};
		</#list>
		// Reverse relations
		<#list reverseRelations as relation>
		org.instantlogic.fabric.model.impl.SimpleRelation<${rootPackageName}.${technicalNameCapitalized}, ${relation.to}, ${rootPackageName}.${relation.item}> $${relation.javaIdentifier}
			= new org.instantlogic.fabric.model.impl.SimpleRelation<${rootPackageName}.${technicalNameCapitalized}, ${relation.to}, ${rootPackageName}.${relation.item}>(
				"${relation.id}", "${relation.name}", INSTANCE, "${relation.javaIdentifier}", ${rootPackageName}.<#if isCustomized>Abstract</#if>${technicalNameCapitalized}.class);
		${relation.javaIdentifier} = $${relation.javaIdentifier};
		</#list>
		
		// Phase 2
		<#if extensions?size != 0>
		EXTENSIONS = new org.instantlogic.fabric.model.Entity<?>[] {
			<#list extensions as extension>
			${rootPackageName}.entity.${extension}Entity.INSTANCE<#if extension_has_next>,</#if>
			</#list>
		};
		</#if>
		<#list attributes as attribute>
			<#list attribute.dataType?keys as key>
			<#if attribute.dataType[key]?is_string>
		$${attribute.javaIdentifier}.dataType.put("${key}", "${attribute.dataType[key]}");
			<#elseif attribute.dataType[key]?is_boolean>
		$${attribute.javaIdentifier}.dataType.put("${key}", <#if attribute.dataType[key]>true<#else>false</#if>);
			<#else>
		$${attribute.javaIdentifier}.dataType.put("${key}", ${attribute.dataType[key]});
			</#if>
			</#list>
			<#if attribute.multivalue>
		$${attribute.javaIdentifier}.multivalue = true;
			</#if>
			<#if attribute.question??>
		$${attribute.javaIdentifier}.question=<@text_macro text=attribute.question />;
			</#if>
			<#if attribute.readonly>
		$${attribute.javaIdentifier}.readOnly = true;
			</#if>
            <#if attribute.relevanceDeductionIndex??>
		$${attribute.javaIdentifier}.relevance = createDeduction${attribute.relevanceDeductionIndex}();
            </#if>
            <#if attribute.ruleDeductionIndex??>
		$${attribute.javaIdentifier}.rule = createDeduction${attribute.ruleDeductionIndex}();
            </#if>
            <#if attribute.defaultDeductionIndex??>
		$${attribute.javaIdentifier}._default = createDeduction${attribute.defaultDeductionIndex}();
            </#if>
            <#if attribute.validations?size!=0>
        $${attribute.javaIdentifier}.validations = new org.instantlogic.fabric.model.Validation[] {
				<#list attribute.validations as validation>
			${rootPackageName}.validation.${validation}Validation.INSTANCE,
				</#list>
		};
			</#if>
		</#list>

		<#list relations as relation>
		$${relation.javaIdentifier}.valueClass = ${rootPackageName}.${relation.item}.class;
		$${relation.javaIdentifier}.to = ${rootPackageName}.entity.${relation.item}Entity.INSTANCE;
			<#if relation.reverseJavaIdentifier??>
		$${relation.javaIdentifier}.setReverseRelation(${rootPackageName}.entity.${relation.item}Entity.${relation.reverseJavaIdentifier});
			</#if>
			<#if relation.owner>
		$${relation.javaIdentifier}.owner = true;
			</#if>
			<#if relation.autoCreate>
		$${relation.javaIdentifier}.autoCreate = true;
			</#if>
			<#if relation.multivalue>
		$${relation.javaIdentifier}.multivalue = true;
			</#if>
			<#if relation.readonly>
		$${relation.javaIdentifier}.readOnly = true;
			</#if>
			<#if relation.ruleDeductionIndex??>
		$${relation.javaIdentifier}.rule = createDeduction${relation.ruleDeductionIndex}();
			</#if>
			<#if relation.optionsDeductionIndex??>
		$${relation.javaIdentifier}.options = (org.instantlogic.fabric.deduction.Deduction)createDeduction${relation.optionsDeductionIndex}();
			</#if>
            <#if relation.validations?size!=0>
		$${relation.javaIdentifier}.validations = new org.instantlogic.fabric.model.Validation[] {
			<#list relation.validations as validation>
			${rootPackageName}.validation.${validation}Validation.INSTANCE,
			</#list>
		};
			</#if>
		</#list>

		<#list reverseRelations as relation>
		$${relation.javaIdentifier}.reverse = true;
		$${relation.javaIdentifier}.valueClass = ${rootPackageName}.${relation.item}.class;
		$${relation.javaIdentifier}.to = ${rootPackageName}.entity.${relation.item}Entity.INSTANCE;
		$${relation.javaIdentifier}.setReverseRelation(${rootPackageName}.entity.${relation.item}Entity.${relation.reverseJavaIdentifier});
			<#if relation.multivalue>
		$${relation.javaIdentifier}.multivalue = true;
			</#if>
		</#list>
		<#if title??>

		title = <@text_macro text=title />;
		</#if>
	}

	@Override
	public ${rootPackageName}.${technicalNameCapitalized} createInstance() {
		return new ${rootPackageName}.${technicalNameCapitalized}();
	}
	
	@Override
	public Class<${rootPackageName}.${technicalNameCapitalized}> getInstanceClass() {
		return ${rootPackageName}.${technicalNameCapitalized}.class;
	}
	
	@Override
	public String getUniqueId() {
		return "${id}";
	}
	
	@Override
	public String getName() {
		return "${name}";
	}

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
