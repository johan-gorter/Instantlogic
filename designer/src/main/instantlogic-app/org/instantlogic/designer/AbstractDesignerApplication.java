/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer;

public abstract class AbstractDesignerApplication extends org.instantlogic.interaction.Application {

	public static final DesignerApplication INSTANCE = new DesignerApplication();
	
	protected AbstractDesignerApplication() {
	}
	
	@Override
	public org.instantlogic.fabric.model.Entity<org.instantlogic.designer.ApplicationDesign> getCaseEntity() {
		return org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.interaction.flow.Flow getMainFlow() {
		return org.instantlogic.designer.flow.MainFlow.INSTANCE;
	}

	@Override
	public org.instantlogic.interaction.flow.FlowEvent getStartEvent() {
		return org.instantlogic.designer.event.HomeEvent.INSTANCE;
	}

    private static final String[] THEME_NAMES = new String[]{"margin", "designer"};	
	@Override
	public String[] getThemeNames() {
		return THEME_NAMES;
	}
	
	@Override
	public String getName() {
		return "Designer";
	}
}
