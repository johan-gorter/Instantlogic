

package org.instantlogic.designer.fragmentfilter;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.DataTypeDesign;
import org.instantlogic.designer.DeductionOperationDesign;
import org.instantlogic.designer.DeductionParameterDesign;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.ElementDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PropertyDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.TextTemplateDesign;
import org.instantlogic.designer.codegenerator.generator.EntityGenerator;
import org.instantlogic.designer.entity.ElementDesignEntity;
import org.instantlogic.interaction.page.FragmentFilter;
import org.instantlogic.interaction.page.FragmentFilterChain;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;
import org.instantlogic.interaction.util.SubmitContext;

public class PreviewFragmentFilter implements FragmentFilter {

	@Override
	public Map<String, Object> render(RenderContext renderContext, String id, FragmentFilterChain chain) {
		ElementDesign element = renderContext.getSelectedInstance(ElementDesignEntity.INSTANCE);
		Map<String, Object> result = chain.render(renderContext);
		if (element instanceof FragmentTemplateDesign) {
			FragmentTemplateDesign template = (FragmentTemplateDesign) element;
			if (template.getType()!=null) {
				result.put("type", template.getType().getName()); // Official way
			} else if (template.getFragmentTypeName()!=null) {
				result.put("type", template.getFragmentTypeName()); // Unofficial way
			} else {
				result.put("type", "Text"); // Fallback
			}
			if (template.getStyleNames()!=null && template.getStyleNames().size()>0) {
				result.put("styleNames", template.getStyleNames().asList().toArray());
			}
			for (PropertyDesign property : template.getProperties()) {
				if (property.getChildren().size()>0) {
					result.put(property.getPropertyName(), new Object[]{ createDummyBlock(property.getPropertyName(), id)});
				} else if (property.getText()!=null) {
					result.put(property.getPropertyName(), renderText(property.getText()));
				} else if (property.getValue()!=null) {
					result.put(property.getPropertyName(), fakeResult(property.getValue()));
				}
			}
			if (template.getAttribute()!=null && template.getEntity()!=null) {
				addField(result, template.getAttribute(), template.getEntity());
			}
		} else {
			result.put("type", "Block");
		}
		
		return result;
	}

	private void addField(Map<String, Object> result, AttributeDesign attribute, EntityDesign entity) {
		// Behavior should be the same as FieldFilter
		if (attribute.getQuestion()!=null) {
			result.put("questionText", renderText(attribute.getQuestion()));
		} else {
			result.put("questionText", attribute.getName());
		}
		if (!result.containsKey("explainText")) {
			if (attribute.getExplanation()!=null) {
				result.put("explainText", renderText(attribute.getExplanation()));
			}
		}
		if (attribute instanceof RelationDesign) {
			result.put("options", new Object[0]);
		}
		DataTypeDesign dataType = attribute.getDataType();
		if (dataType!=null) {
			result.put("dataType", renderDataType(dataType));
		}
		result.put("valueLevel", "stored");
		if (attribute.getDefault()!=null) {
			result.put("value", fakeResult(attribute.getDefault()));
		} else {
			result.put("value", dummyValue(attribute.getDataType()));
		}
	}

	private Map<String, Object> renderDataType(DataTypeDesign dataType) {
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		if (dataType.getDataCategory()!=null) {
			EntityGenerator.exportDatatype(result, dataType);
		}
		return result;
	}

	private Object dummyValue(DataTypeDesign dataType) {
		if (dataType.getJavaClassName()=="java.lang.Boolean") {
			return Boolean.TRUE;
		}
		if (dataType.getJavaClassName()=="java.lang.Integer") {
			return 99;
		}
		if (dataType.getJavaClassName()=="java.lang.Double") {
			return 9.99;
		}
		return "...";
	}

	private Object fakeResult(DeductionSchemeDesign scheme) {
		if (scheme.getOutput().getOperation() == DeductionOperationDesign.constant) {
			DeductionParameterDesign constantValue = scheme.getOutput().getParameters().iterator().next();
			return constantValue.getValue();
		}
		if (scheme.getOutput().getDataType()==null) {
			return "...";
		}
		return dummyValue(scheme.getOutput().getDataType());
	}

	private String renderText(TextTemplateDesign text) {
		StringBuffer result = new StringBuffer();
		for (StringTemplateDesign part : text.getUntranslated()) {
			if (part.getConstantText()!=null) {
				result.append(part.getConstantText());
			} else if (part.getDeduction()!=null) {
				result.append(fakeResult(part.getDeduction()));
			}
		}
		return result.toString();
	}

	private Map<String, Object> createDummyBlock(String name, String parentId) {
		Map<String, Object> text = new LinkedHashMap<String, Object>();
		text.put("type", "Paragraph");
		text.put("id", parentId+"-1-1");
		text.put("text", name);
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		result.put("type", "Block");
		result.put("id", parentId+"-1");
		result.put("styleNames", new String[]{"dummy"});
		result.put("content", Collections.EMPTY_LIST);// Collections.singletonList(text));
		return result;
	}

	@Override
	public FlowEventOccurrence submit(SubmitContext submitContext, String id, FragmentFilterChain chain) {
		return chain.submit(submitContext);
	}

	@Override
	public void change(ChangeContext changeContext, String id, FragmentFilterChain chain) {
		chain.change(changeContext);
	}


}
