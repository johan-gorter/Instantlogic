package org.instantlogic.interaction.flow.impl;

import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.SubFlow;

public class SimpleSubFlow extends SubFlow {

	private final String name;
	private final Flow flow;
	
	public SimpleSubFlow(String name, Flow flow) {
		this.name = name;
		this.flow = flow;
	}

	public SimpleSubFlow(Flow flow) {
		this.name = flow.getName();
		this.flow = flow;
	}

	@Override
	public Flow getFlow() {
		return this.flow;
	}

	@Override
	public String getName() {
		return this.name;
	}
}
