

package org.instantlogic.interaction.util;

import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.flow.Flow;


public class SubmitContext extends RenderContext {

	public static SubmitContext create(Flow mainFlow, String path, Instance caseInstance, String caseId, String pageElementId, TravelerInfo travelerInfo) {
		FlowContext flowContext = FlowContext.create(mainFlow, path, caseInstance, caseId, travelerInfo);
		return new SubmitContext(flowContext, path, pageElementId);
	}
	
	private String pageElementId;
	
	public SubmitContext(FlowContext flowContext, String pageCoordinates, String pageElementId) {
		super(flowContext, pageCoordinates);
		this.pageElementId = pageElementId;
	}

	public String getPageElementId() {
		return pageElementId;
	}
}
