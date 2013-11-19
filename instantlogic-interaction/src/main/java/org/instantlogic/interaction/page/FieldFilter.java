package org.instantlogic.interaction.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.InstanceMetadata;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.util.ValueLevel;
import org.instantlogic.fabric.value.Values;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.RenderContext;

public class FieldFilter extends AbstractFragmentFilter {
	
	private final Attribute<?, ?, ?> attribute;
	private final Entity<?> entity;
	
	public FieldFilter(Entity<?> entity, Attribute<?, ?, ?> attribute) {
		this.entity = entity;
		this.attribute = attribute;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map<String, Object> render(RenderContext context, String id, FragmentFilterChain chain) {
		ValueAndLevel valueAndLevel = context.getAttributeValue((Entity)entity, (Attribute)attribute).getValueAndLevel();
		if (valueAndLevel.getValueLevel()==ValueLevel.IRRELEVANT) return null;
		Map<String, Object> result = super.render(context, id, chain);
		if (!result.containsKey("questionText")) {
			if (attribute.getQuestion()!=null) {
				result.put("questionText", attribute.getQuestion().renderText(context));
			} else {
				result.put("questionText", attribute.getName());
			}
		}
		if (!result.containsKey("options") && (attribute instanceof Relation<?,?,?>)) {
			Deduction options = ((Relation)attribute).getOptions();
			if (options!=null) {
				Iterable<Instance> values = (Iterable<Instance>) options.deduce(context).getValue();
				List<Map<String, Object>> resultOptions = new ArrayList<Map<String, Object>>();
				for(Instance value : values) {
					Map resultOption = new HashMap<String, Object>();
					if (value.getMetadata().getStaticName()!=null) {
						resultOption.put("id", value.getMetadata().getEntity().getName()+"!"+value.getMetadata().getStaticName());						
					} else {
						resultOption.put("id", value.getMetadata().getUniqueId());						
					}
					if (value.getMetadata().getStaticDescription()!=null) {
						resultOption.put("text", value.getMetadata().getStaticDescription().renderText(context));
					} else if (value.getMetadata().getStaticName()!=null) {
						resultOption.put("text", value.getMetadata().getStaticName());
					} else {
						String title = value.renderTitle(context);
						if (title!=null) {
							resultOption.put("text", title);
						} else {
							resultOption.put("text", value.getMetadata().getUniqueId());
						}
					}
					resultOptions.add(resultOption);
				}
				result.put("options", resultOptions.toArray());
			}
		}
		if (!result.containsKey("dataType")) {
			Map<String, Object> dataType = attribute.getDataType();
			if (dataType!=null) {
				result.put("dataType", dataType);
			}
		}
		if (attribute.isMultivalue() && !result.containsKey("multivalue")) {
			result.put("multivalue", true);
		}
		result.put("valueLevel", valueAndLevel.getValueLevel().toString().toLowerCase());
		if (valueAndLevel.getValueLevel()==ValueLevel.RULE) {
			result.put("readOnly", true);
		}
		result.put("value", safeValue(valueAndLevel.getValue()));
		return result;
	}
	
	private Object safeValue(Object value) {
		if (value instanceof Instance) {
			InstanceMetadata metadata = ((Instance)value).getMetadata();
			if (metadata.getStaticName()!=null) {
				return metadata.getEntity().getName()+"!"+metadata.getStaticName();
			} else {
				return metadata.getUniqueId();
			}
		}
		if (value instanceof Values) {
			return ((Values)value).asCollection().toArray();
		}
		return value;
	}

	@Override
	public void change(ChangeContext changeContext, String id, FragmentFilterChain chain) {
		super.change(changeContext, id, chain);
		if (changeContext.getPageElementId().equals(id)) {
			changeContext.setValue(this.entity, this.attribute, changeContext.getValue());
		}
	}
}
