/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.interaction.util;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.util.AbstractDeductionContext;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.page.FragmentTemplate;
import org.instantlogic.interaction.page.SharedElementHolder;


public class RenderContext extends AbstractDeductionContext {

	public static RenderContext create(Flow mainFlow, String path, Instance caseInstance, String caseId, TravelerInfo travelerInfo) {
		FlowContext flowContext = FlowContext.create(mainFlow, path, caseInstance, caseId, travelerInfo);
		return new RenderContext(flowContext, path);
	}
	
	private final FlowContext flowContext;
	
	public List<String> prefixes = new ArrayList<String>();
	private final String pageCoordinates;

	public RenderContext(FlowContext flowContext, String pageCoordinates) {
		super(flowContext);
		this.pageCoordinates = pageCoordinates;
		this.flowContext = flowContext;
	}

	public Instance getCaseInstance() {
		return flowContext.getCaseInstance();
	}
	
	public String makeId(FragmentTemplate fragmentTemplate) {
		String suffix = fragmentTemplate.getId();
		return makeId(suffix);
	}
	
	private String makeId(String suffix) {
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
		String id = makeId(sharedElementHolder.getId());
		prefixes.add(id);
		return id;
	}
	
	public String enterScope(Instance forInstance) {
		String id = makeId(forInstance);
		prefixes.add(id);
		return id;
	}
	
	public void exitScope() {
		prefixes.remove(prefixes.size()-1);
	}

	public String getCaseId() {
		return flowContext.getCaseId();
	}

	public String getPageCoordinates() {
		return pageCoordinates;
	}

	public FlowContext getFlowContext() {
		return flowContext;
	}
}
