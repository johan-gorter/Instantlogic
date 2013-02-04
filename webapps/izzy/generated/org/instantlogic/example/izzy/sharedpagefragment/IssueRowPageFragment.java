/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.example.izzy.sharedpagefragment;

public class IssueRowPageFragment extends org.instantlogic.interaction.page.SharedElement {
	
	public static IssueRowPageFragment INSTANCE = new IssueRowPageFragment();
	

	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Integer> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.example.izzy.Issue> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.Integer> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.number, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction1() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.example.izzy.Issue> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.headline, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction2() {
		    org.instantlogic.fabric.deduction.Deduction<java.lang.String> d0 
		    	= new org.instantlogic.example.izzy.deduction.IssuePreviewDeduction();
		return d0;
	}

	
	public static final org.instantlogic.interaction.page.Element SHARED_INSTANCE = 
        new org.instantlogic.interaction.page.FragmentTemplate("f77c00e0-b59b-43c1-b00e-c06cf99699dd", "Row")      
        .putChildren("cells",
                new org.instantlogic.interaction.page.FragmentTemplate("8daef65e-9d76-48b2-9e29-4edd04ac2430", "Link")      .setEvent(org.instantlogic.example.izzy.event.IssueDetailsEvent.INSTANCE)
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("6b1caf2b-53c4-4a86-9ba1-25f39e689bba", "Cell")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0())))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("dfdb8a7e-7a31-4042-ae4c-294675cf9ad2", "Cell")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction1())))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("21606dcf-0732-4f89-935b-c0cbc5f4b947", "Cell")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction2())))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("1357cae9-0bdf-447c-a2ce-d332dd630196", "Cell")      
                        .putChildren("content",
                                new org.instantlogic.interaction.page.FragmentTemplate("5b91a03e-7fef-41cd-89a0-31a91e21c745", "PresenceIndicator")                        )
                )
        )
; 

	protected IssueRowPageFragment() {
	    INSTANCE=this;
	}
	
	static {
	    INSTANCE.setElement(SHARED_INSTANCE);
	}
	
}
