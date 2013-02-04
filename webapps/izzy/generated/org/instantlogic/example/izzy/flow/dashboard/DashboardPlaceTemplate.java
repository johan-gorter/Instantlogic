/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.example.izzy.flow.dashboard;

public class DashboardPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final DashboardPlaceTemplate INSTANCE = new DashboardPlaceTemplate();

	@Override
	public String getId() {
		return "c2412b99-2c49-4a93-9b58-13e2a7fea62d";
	}
	

	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.example.izzy.User> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.example.izzy.entity.UserEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.example.izzy.entity.UserEntity.username, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue>> createDeduction1() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.example.izzy.User> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.example.izzy.entity.UserEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue>> d1 
		  		= org.instantlogic.fabric.deduction.ReverseRelationDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.assignee, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue>> createDeduction2() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.example.izzy.Project> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.example.izzy.entity.ProjectEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.example.izzy.entity.ProjectEntity.issues, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction3() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.example.izzy.User> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.example.izzy.entity.UserEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.example.izzy.entity.UserEntity.username, d0);
		return d1;
	}

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("386b9c88-76aa-4bf2-a603-013144a7cf39", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("e562a954-e865-46e8-9e04-8f108e79d338", "Heading2")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0()),new org.instantlogic.fabric.text.StringTemplate("'s dashboard")))
,
                new org.instantlogic.interaction.page.FragmentTemplate("c5c75f51-602d-4663-aba1-95f042361035", "Heading4")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Assigned to me")))
,
                new org.instantlogic.interaction.page.FragmentTemplate("5a5e86c1-ccd9-4761-9c1a-3fde007a1735", "Table")      
                .putChildren("columns",
                        new org.instantlogic.interaction.page.FragmentTemplate("54bba882-1d50-4b00-ac5e-01dc73ff2763", "Column")      .setStyleNames(new String[]{"issueNr"})
      
                        .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("#")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("303c8958-7003-44d0-aa97-cff430ede8ed", "Column")      .setStyleNames(new String[]{"issueHeadline"})
      
                        .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Issue")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("dd72531f-3015-4bc2-b155-2dd30ef6e0e7", "Column")      .setStyleNames(new String[]{"issuePreview"})
,
                        new org.instantlogic.interaction.page.FragmentTemplate("39aae63d-0c80-4d8b-b359-529459f2d781", "Column")      .setStyleNames(new String[]{"presence-indicator"})
                )
      
                .putChildren("rows",
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction1()
,                                    new org.instantlogic.interaction.page.SharedElementHolder("53df1c9a-00ce-42a5-b33a-0ba694498c53", org.instantlogic.example.izzy.sharedpagefragment.IssueRowPageFragment.INSTANCE)
)
                )
,
                new org.instantlogic.interaction.page.FragmentTemplate("e11b6e74-44f8-4a8b-884f-44b2b5ade9f2", "Heading4")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("All issues")))
,
                new org.instantlogic.interaction.page.FragmentTemplate("56d0a36e-f8c2-4459-a76f-09e8ec2fef86", "Table")      
                .putChildren("columns",
                        new org.instantlogic.interaction.page.FragmentTemplate("c32c44ba-88f5-4a59-b140-2833939031ff", "Column")      .setStyleNames(new String[]{"issueNr"})
      
                        .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("#")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("9f0ddbec-d237-4ce3-a779-2d40062ae45f", "Column")      .setStyleNames(new String[]{"issueHeadline"})
      
                        .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Issue")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("e8ac7a86-9769-4a46-87a8-c38263e342c9", "Column")      .setStyleNames(new String[]{"issuePreview"})
,
                        new org.instantlogic.interaction.page.FragmentTemplate("d44a0fb9-6c74-4bba-88bb-a94b51fd2892", "Column")      .setStyleNames(new String[]{"presence-indicator"})
                )
      
                .putChildren("rows",
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction2()
,                                    new org.instantlogic.interaction.page.SharedElementHolder("c2c134b5-5687-4923-ad39-d60f5ac40ffe", org.instantlogic.example.izzy.sharedpagefragment.IssueRowPageFragment.INSTANCE)
)
                )
,
                new org.instantlogic.interaction.page.FragmentTemplate("c8671bd6-2168-4ff3-9e02-444d4998ced6", "Button")      .setEvent(org.instantlogic.example.izzy.event.CreateIssueEvent.INSTANCE)
      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Create issue")))
        )
; 
	
	private static final org.instantlogic.fabric.text.TextTemplate TITLE = new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction3()),new org.instantlogic.fabric.text.StringTemplate("'s dashboard"));
	@Override
	protected org.instantlogic.fabric.text.TextTemplate getTitle() {
		return TITLE;
	}
	
	@Override
	public org.instantlogic.interaction.page.FragmentTemplate getRootContainer() {
		return CONTENT;
	}; 
	
    @Override
    public String getName() {
        return "dashboard";
    }
}