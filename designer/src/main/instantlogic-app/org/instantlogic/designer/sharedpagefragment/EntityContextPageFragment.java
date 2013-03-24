/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer.sharedpagefragment;

public class EntityContextPageFragment extends org.instantlogic.interaction.page.SharedElement {
	
	public static EntityContextPageFragment INSTANCE = new EntityContextPageFragment();
	

	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction0() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 
		  	  = new org.instantlogic.fabric.deduction.AttributeDeduction(org.instantlogic.designer.entity.DesignEntity.name);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 
		  	  = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction(org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE);
		    d0.addToInputs(d1);
		return d0;
	}

	
	public static final org.instantlogic.interaction.page.Element SHARED_INSTANCE = 
        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0037", "Group")      
        .putChildren("content",
                    new org.instantlogic.interaction.page.SharedElementHolder("Sharedelemntdsgn__0006", org.instantlogic.designer.sharedpagefragment.ApplicationContextPageFragment.INSTANCE)
,
                new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0038", "Link")      .setEvent(org.instantlogic.designer.event.EntityDetailsEvent.INSTANCE)
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0039", "Block")      .setStyleNames(new String[]{"inactive-card"})
      
                        .putChildren("content",
                                new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__003a", "Heading3")      
                                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0()),new org.instantlogic.fabric.text.StringTemplate(" (Entity)")))
                        )
                )
        )
; 

	protected EntityContextPageFragment() {
	    INSTANCE=this;
	}
	
	static {
	    INSTANCE.setElement(SHARED_INSTANCE);
	}
	
}
