/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer.flow.attribute;

public class AttributeDetailsPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final AttributeDetailsPlaceTemplate INSTANCE = new AttributeDetailsPlaceTemplate();

	@Override
	public String getId() {
		return "Placetemplatdsgn__0005";
	}
	

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.ReverseRelationDeduction d0 
		  	  = new org.instantlogic.fabric.deduction.ReverseRelationDeduction(org.instantlogic.designer.entity.EntityDesignEntity.attributes);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 
		  	  = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE);
		    d0.addToInputs(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 
		  	  = new org.instantlogic.fabric.deduction.AttributeDeduction(org.instantlogic.designer.entity.DesignEntity.name);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 
		  	  = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		    d0.addToInputs(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction2() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 
		  	  = new org.instantlogic.fabric.deduction.AttributeDeduction(org.instantlogic.designer.entity.AttributeDesignEntity.dataType);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 
		  	  = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE);
		    d0.addToInputs(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction3() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 
		  	  = new org.instantlogic.fabric.deduction.AttributeDeduction(org.instantlogic.designer.entity.DesignEntity.name);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 
		  	  = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		    d0.addToInputs(d1);
		return d0;
	}

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0027", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.SelectionElement(createDeduction0()
,                            new org.instantlogic.interaction.page.SharedElementHolder("Sharedelemntdsgn__0005", org.instantlogic.designer.sharedpagefragment.EntityContextPageFragment.INSTANCE)
)
,
                new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0028", "Block")      .setStyleNames(new String[]{"card"})
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0029", "Heading3")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction1()),new org.instantlogic.fabric.text.StringTemplate(" (Attribute)")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__002a", "Input")      .setField(org.instantlogic.designer.entity.DesignEntity.INSTANCE, org.instantlogic.designer.entity.DesignEntity.name)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__002b", "Heading4")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Data type")))
,
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction2()
,                                new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__002c", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.dataCategory)
,                                new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__002d", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.multiLine)
,                                new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__002e", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.formatted)
,                                new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__002f", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.percentage)
,                                new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0030", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.wholeNumber)
,                                new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0031", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.exactRounding)
)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0032", "Heading4")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Value")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0033", "Input")      .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.hasRelevance)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0034", "Input")      .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.hasRule)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0035", "Input")      .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.writeable)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0036", "Input")      .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.hasDefault)
                )
        )
; 
	
	private static final org.instantlogic.fabric.text.TextTemplate TITLE = new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction3()),new org.instantlogic.fabric.text.StringTemplate(" (Attribute)"));
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
        return "AttributeDetails";
    }
}