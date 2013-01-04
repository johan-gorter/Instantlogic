/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer.event;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.ElementDesignEntityGenerator;
import org.instantlogic.designer.EventDesign;

public class CloseEditorEventGenerator extends EventDesign {

	public static CloseEditorEventGenerator EVENT = new CloseEditorEventGenerator();
	
	private CloseEditorEventGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToEvents(this);
		setName("CloseEditor");
		addToParameters(ElementDesignEntityGenerator.ENTITY);
	}
}