/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.example.izzy.flow.main;

public class NotLoggedInPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final NotLoggedInPlaceTemplate INSTANCE = new NotLoggedInPlaceTemplate();

	@Override
	public String getId() {
		return "9c98338d-9555-41dd-9d5b-bc8084cad5fe";
	}
	
	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("c3f29735-fac9-4ccd-a37b-d86c39d147d5", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("56f1f82d-c3e6-4841-ba61-ef50f4006056", "Paragraph")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Please log in.")))
        )
; 
	
	
	@Override
	public org.instantlogic.interaction.page.FragmentTemplate getRootContainer() {
		return CONTENT;
	}; 
	
    @Override
    public String getName() {
        return "not logged in";
    }
}