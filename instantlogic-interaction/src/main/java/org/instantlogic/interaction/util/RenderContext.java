package org.instantlogic.interaction.util;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.util.AbstractDeductionContext;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.page.FragmentTemplate;
import org.instantlogic.interaction.page.SharedElementHolder;


public class RenderContext extends AbstractDeductionContext {

	public static RenderContext create(Application application, String path, Instance caseInstance, String caseId, TravelerInfo travelerInfo) {
		FlowContext flowContext = FlowContext.create(application, path, caseInstance, caseId, travelerInfo);
		return new RenderContext(flowContext, path);
	}
	
	private final FlowContext flowContext;
	
	public List<String> prefixes = new ArrayList<String>();
	private final String location;

	public RenderContext(FlowContext flowContext, String location) {
		super(flowContext);
		this.location = location;
		this.flowContext = flowContext;
	}

	public Instance getCaseInstance() {
		return flowContext.getCaseInstance();
	}
	
	public String makeId(FragmentTemplate fragmentTemplate) {
		String suffix = fragmentTemplate.getId();
		return makeId(suffix);
	}
	
	public String makeId(String suffix) {
		if (prefixes.size()==0) return suffix;
		StringBuilder sb = new StringBuilder();
		sb.append(prefixes.get(prefixes.size()-1));
		sb.append('+');
		sb.append(suffix);
		return sb.toString();
	}

	private String makeId(Instance forInstance) {
		String suffix = forInstance.getMetadata().getUniqueId();
		if (prefixes.size()==0) return "!"+suffix;
		StringBuilder sb = new StringBuilder();
		sb.append(prefixes.get(prefixes.size()-1));
		sb.append('!');
		sb.append(suffix);
		return sb.toString();
	}

	public String enterScope(SharedElementHolder sharedElementHolder) {
		return enterScope(makeId(sharedElementHolder.getId()));
	}
	
	public String enterScope(Instance forInstance) {
		return enterScope(makeId(forInstance));
	}
	
	public String enterScope(String id) {
		prefixes.add(id);
		return id;
	}
	
	public void exitScope() {
		prefixes.remove(prefixes.size()-1);
	}

	public String getCaseId() {
		return flowContext.getCaseId();
	}

	public String getLocation() {
		return location;
	}

	public FlowContext getFlowContext() {
		return flowContext;
	}
	
	public TravelerInfo getTraveler() {
		return flowContext.getTraveler();
	}
}
