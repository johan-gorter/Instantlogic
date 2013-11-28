package org.instantlogic.interaction.page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.text.TextTemplate;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.SubmitContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

public class FragmentTemplate extends Element {

	private final List<FragmentFilter> customFilters = new ArrayList<FragmentFilter>();
	
	private final Map<String, Deduction<?>> valueProperties = new HashMap<String, Deduction<?>>();
	private final Map<String, TextTemplate> textProperties = new HashMap<String, TextTemplate>();
	private final Map<String, List<Element>> childlistProperties = new HashMap<String, List<Element>>();
	
	private final String id;
	private final String fragmentTypeName;

	private String[] styleNames;

	private FieldFilter field;
	private ActionFilter action;

	private List<FragmentFilter> filters;
	
	private void initFilters() {
		if (filters==null) {
			filters = new ArrayList<FragmentFilter>();
			filters.addAll(customFilters);
			if (field!=null) {
				filters.add(field);
			}
			if (action!=null) {
				filters.add(action);
			}
		}
	}
	
	private class FilterChain implements FragmentFilterChain {
		
		private final String id;
		private Iterator<FragmentFilter> iterator = filters.iterator();
		
		public FilterChain(String id) {
			this.id = id;
		}
		
		@Override
		public Map<String, Object> render(RenderContext context) {
			if (iterator.hasNext()) {
				return iterator.next().render(context, id, this);
			} else {
				return doRender(context, id);
			}
		}

		@Override
		public FlowEventOccurrence submit(SubmitContext context) {
			if (iterator.hasNext()) {
				return iterator.next().submit(context, id, this);
			} else {
				return doSubmit(context, id);
			}
		}

		@Override
		public void change(ChangeContext context) {
			if (iterator.hasNext()) {
				iterator.next().change(context, id, this);
			} else {
				doChange(context, id);
			}
		}
	};
	
	public FragmentTemplate(String id, String fragmentTypeName) {
		this.id = id;
		this.fragmentTypeName = fragmentTypeName;
	}
	
	public FragmentTemplate addCustomFilter(FragmentFilter filter) {
		if (filter==null) throw new IllegalArgumentException();
		customFilters.add(filter);
		return this;
	}

	public FragmentTemplate putValue(String DataKey, Deduction<?> value) {
		if (value==null) throw new IllegalArgumentException();
		valueProperties.put(DataKey, value);
		return this;
	}
	
	public FragmentTemplate putText(String DataKey, TextTemplate value) {
		if (value==null) throw new IllegalArgumentException();
		textProperties.put(DataKey, value);
		return this;
	}
	
	public FragmentTemplate putConstantText(String dataKey, String constantText) {
		return putText(dataKey, new TextTemplate().getUntranslated().add(constantText).getTextTemplate());
	}
	
	public FragmentTemplate putChildren(String DataKey, Element... children) {
		if (children==null) throw new IllegalArgumentException();
		childlistProperties.put(DataKey, Arrays.asList(children));
		return this;
	}
	
	public FragmentTemplate addChild(String key, Element child) {
		if (child==null) throw new IllegalArgumentException();
		List<Element> list = childlistProperties.get(key);
		if (list==null) {
			list = new ArrayList<Element>();
			childlistProperties.put(key, list);
		}
		list.add(child);
		return this;
	}
	
	public FragmentTemplate setField(Entity<?> entity, Attribute<?, ?, ?> attribute) {
		this.field = new FieldFilter(entity, attribute);
		return this;
	}
	
	public FragmentTemplate setEvent(FlowEvent event) {
		this.action = new ActionFilter(event);
		return this;
	}

	public FragmentTemplate setDestination(PlaceTemplate destination) {
		this.action = new ActionFilter(destination);
		return this;
	}
	
	public FragmentTemplate setStyleNames(String[] styleNames) {
		if (styleNames==null) throw new IllegalArgumentException();
		this.styleNames = styleNames;
		return this;
	}
	
	public String getId() {
		return id;
	}
	
	public String getFragmentTypeName() {
		return fragmentTypeName;
	}
	
	@Override
	public void render(RenderContext context, List<Map<String, Object>> appendTo) {
		initFilters();
		String id = context.makeId(this);
		FilterChain chain = new FilterChain(id);
		Map<String, Object> rendering = chain.render(context); // Chain ends with a call to doRender
		if (rendering!=null) {
			appendTo.add(rendering);
		}
	}
	
	protected Map<String, Object> doRender(RenderContext context, String id) {
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		result.put("type", getFragmentTypeName());
		result.put("id", id);
		if (styleNames!=null) {
			result.put("styleNames", styleNames);
		}
		for (Map.Entry<String, Deduction<?>> entry : valueProperties.entrySet()) {
			result.put(entry.getKey(), entry.getValue().deduce(context).getValue());
		}
		for (Map.Entry<String, TextTemplate> entry : textProperties.entrySet()) {
			result.put(entry.getKey(), entry.getValue().renderText(context));
		}
		for (Map.Entry<String, List<Element>> entry : childlistProperties.entrySet()) {
			List<Map<String, Object>> fragments = new ArrayList<Map<String, Object>>();
			for (Element template: entry.getValue()) {
				template.render(context, fragments);
			}
			result.put(entry.getKey(), fragments);
		}
		return result;
	}

	@Override
	public FlowEventOccurrence submit(SubmitContext submitContext) {
		initFilters();
		String id = submitContext.makeId(this);
		FilterChain chain = new FilterChain(id);
		FlowEventOccurrence result = chain.submit(submitContext); // Chain ends with a call to doSubmit
		return result;
	}
	
	protected FlowEventOccurrence doSubmit(SubmitContext submitContext, String id) {
		// This can be optimized by going to the right element straight away
		FlowEventOccurrence result=null;
		for (List<Element> fragmentTemplates: childlistProperties.values()) {
			for (Element template: fragmentTemplates) {
				FlowEventOccurrence itemResult = template.submit(submitContext);
				if (itemResult!=null) {
					if (result!=null) {
						throw new RuntimeException("More than one FlowEventOccurrence");
					}
					result = itemResult;
				}
			}
		}
		return result;
	}

	@Override
	public void change(ChangeContext changeContext) {
		initFilters();
		String id = changeContext.makeId(this);
		FilterChain chain = new FilterChain(id);
		chain.change(changeContext); // Chain ends with a call to doSubmit
	}
	
	public void doChange(ChangeContext changeContext, String id) {
		// This can be optimized by going to the right element straight away
		for (List<Element> fragmentTemplates: childlistProperties.values()) {
			for (Element template: fragmentTemplates) {
				template.change(changeContext);
			}
		}
	}
}
