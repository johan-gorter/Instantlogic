/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer.flow.placetemplate;

public class PlaceTemplateDetailsPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final PlaceTemplateDetailsPlaceTemplate INSTANCE = new PlaceTemplateDetailsPlaceTemplate();

	@Override
	public String getId() {
		return "Placetemplatdsgn__0004";
	}
	

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.ReverseRelationDeduction d0 = new org.instantlogic.fabric.deduction.ReverseRelationDeduction();
		    d0.setRelation(org.instantlogic.designer.entity.FlowDesignEntity.nodes);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE);
		    d0.setToInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DesignEntity.name);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction2() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.content);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction3() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DesignEntity.name);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0021", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.SelectionElement(createDeduction0()
,                            new org.instantlogic.interaction.page.SharedElementHolder("Sharedelemntdsgn__0003", org.instantlogic.designer.sharedpagefragment.FlowContextPageFragment.INSTANCE)
)
,
                new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0022", "Block")      .setStyleNames(new String[]{"card"})
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0023", "Heading3")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction1()),new org.instantlogic.fabric.text.StringTemplate(" (Place template)")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0024", "Input")      .setField(org.instantlogic.designer.entity.DesignEntity.INSTANCE, org.instantlogic.designer.entity.DesignEntity.name)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0025", "Heading4")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Content")))
,
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction2()
,                                new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0026", "ElementEditor")      
                                .putChildren("content",
                                            new org.instantlogic.interaction.page.SharedElementHolder("Sharedelemntdsgn__0004", org.instantlogic.designer.sharedpagefragment.ElementEditorPageFragment.INSTANCE)
                                )
)
                )
        )
; 
	
	private static final org.instantlogic.fabric.text.TextTemplate TITLE = new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction3()),new org.instantlogic.fabric.text.StringTemplate(" (Place)"));
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
        return "PlaceTemplateDetails";
    }
}