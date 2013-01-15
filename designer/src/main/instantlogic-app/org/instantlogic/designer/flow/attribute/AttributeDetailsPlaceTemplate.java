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
		return "037ff177-a8e7-488a-9397-34b76918d380";
	}
	

	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.EntityDesign> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.AttributeDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.EntityDesign> d1 
		  		= org.instantlogic.fabric.deduction.ReverseRelationDeduction.create(org.instantlogic.designer.entity.EntityDesignEntity.attributes, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction1() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.Design> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.DataTypeDesign> createDeduction2() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.AttributeDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.DataTypeDesign> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.AttributeDesignEntity.dataType, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction3() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.Design> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		return d1;
	}

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("fb0e9444-2525-444b-a363-77edd43a182b", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.SelectionElement(createDeduction0()
,                            new org.instantlogic.interaction.page.SharedElementHolder("263e7500-d026-4293-94ec-e324ebe2e221", org.instantlogic.designer.sharedpagefragment.EntityContextPageFragment.INSTANCE)
)
,
                new org.instantlogic.interaction.page.FragmentTemplate("5176b0e5-aff9-4f36-8b5e-2c4febccd326", "Block")      .setStyleNames(new String[]{"card"})
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("07f5e14e-3d62-4086-a90f-ee3d902a5171", "Heading3")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction1()),new org.instantlogic.fabric.text.StringTemplate(" (Attribute)")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("0d032a21-7445-4d13-9f6a-294bc457437e", "Input")      .setField(org.instantlogic.designer.entity.DesignEntity.INSTANCE, org.instantlogic.designer.entity.DesignEntity.name)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("189e1c35-3bf8-42ed-a8ef-8c42dac23f5b", "Heading4")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Data type")))
,
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction2()
,                                new org.instantlogic.interaction.page.FragmentTemplate("b964e0ba-d20a-42bb-855d-13e6335ebc6e", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.dataCategory)
,                                new org.instantlogic.interaction.page.FragmentTemplate("942377a8-5448-4ccd-86dc-0c54afbc7ddf", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.multiLine)
,                                new org.instantlogic.interaction.page.FragmentTemplate("88ef54a7-c47e-4de3-832f-ecc89514fef4", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.formatted)
,                                new org.instantlogic.interaction.page.FragmentTemplate("3beb5ccb-ccc8-43f3-bde3-7d4e70acef12", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.percentage)
,                                new org.instantlogic.interaction.page.FragmentTemplate("2a7b97c8-9399-4aa6-a4b8-3e65d4c67ffa", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.wholeNumber)
,                                new org.instantlogic.interaction.page.FragmentTemplate("7f25254a-06e7-4dae-8bee-69602002d358", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.exactRounding)
)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("fba92a58-155b-4d4b-b852-6bead8249b26", "Heading4")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Value")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("6c04e669-de44-418a-95a6-b78bfdce55d2", "Input")      .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.hasRelevance)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("233057dd-6fbb-4671-ac1a-9df5b31fb3f2", "Input")      .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.hasRule)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("0b77484c-ec8e-4766-8b7d-d130c9bcb22e", "Input")      .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.writeable)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("e5bc016e-531e-4fb5-ab3d-1c287be1798c", "Input")      .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.hasDefault)
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