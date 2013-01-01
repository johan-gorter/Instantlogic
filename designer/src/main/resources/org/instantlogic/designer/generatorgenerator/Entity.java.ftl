package ${application.rootPackageName};

<#macro relationType relation>
  <#if relation.owner?? && relation.owner>
    <#if relation.autoCreate?? && relation.autoCreate>
      OneToOneAggregation<#t>
    <#else>
      <#if relation.multivalue>
        OneToManyAggregation<#t>
      <#else>
        OneToZeroOrOneAggregation<#t>
      </#if>
    </#if>
  <#else>
    <#if relation.multivalue?? && relation.multivalue>
      <#if relation.reverseMultivalue?? && relation.reverseMultivalue>
        ManyToMany<#t>
      <#else>
        OneToMany<#t>
      </#if>
    <#else>
      <#if relation.reverseMultivalue?? && relation.reverseMultivalue>
        ManyToZeroOrOne<#t>
      <#else>
        OneToZeroOrOne<#t>
      </#if>
    </#if>
  </#if>
</#macro>

public class ${name}EntityGenerator extends EntityDesign {

    public static final ${name}EntityGenerator ENTITY = new ${name}EntityGenerator();
    
    private ${name}EntityGenerator() {
        setName("${name}");
<#if extendsFrom??>        
        setExtendsFrom(${extendsFrom.name}EntityGenerator.ENTITY);
</#if>
<#if isCustomized??>
  <#if isCustomized>
        setIsCustomized(true);
  </#if>
</#if>
    }

    // Attributes
<#list attributes as attribute>
    public static final AttributeDesign ${attribute.javaIdentifier} = addAttribute(ENTITY, "${attribute.name}", ${attribute.className}.class);
</#list>

    // Relations
<#list relations as relation>
    public static final RelationDesign ${relation.javaIdentifier} = addRelation(ENTITY, "${relation.name}", RelationType.<@relationType relation=relation />, ${relation.to.name}EntityGenerator.ENTITY)
            .setReverseName("${relation.reverseName}");
</#list>

}