/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.interaction.page;

import java.util.List;
import java.util.Map;

import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.SubmitContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;


public class SharedElement extends Element {

	private Element delegate;

	protected void setElement(Element delegate) {
		this.delegate = delegate;
	}

	@Override
	public void render(RenderContext context, List<Map<String, Object>> appendTo) {
		delegate.render(context, appendTo);
	}
	
	@Override
	public FlowEventOccurrence submit(SubmitContext submitContext) {
		return delegate.submit(submitContext);
	}

	@Override
	public void change(ChangeContext changeContext) {
		delegate.change(changeContext);
		
	}
}
