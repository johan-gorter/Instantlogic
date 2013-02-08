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
		return "34c5c2e9-f3ad-461e-97d6-43eaf901d79e";
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
        new org.instantlogic.interaction.page.FragmentTemplate("bdc800ed-333d-411a-ae85-7ac608b58b6b", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.SelectionElement(createDeduction0()
,                            new org.instantlogic.interaction.page.SharedElementHolder("3f413eb5-14b8-468a-b6d1-c59f8a0a8d9f", org.instantlogic.designer.sharedpagefragment.EntityContextPageFragment.INSTANCE)
)
,
                new org.instantlogic.interaction.page.FragmentTemplate("00e21d0c-078f-4ac6-95ac-e9ef9ef438e1", "Block")      .setStyleNames(new String[]{"card"})
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("9dc16230-cba3-4ee1-9519-e7e206969f05", "Heading3")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction1()),new org.instantlogic.fabric.text.StringTemplate(" (Attribute)")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("43fbfeb4-9671-4034-87fd-8442a46cb7ad", "Input")      .setField(org.instantlogic.designer.entity.DesignEntity.INSTANCE, org.instantlogic.designer.entity.DesignEntity.name)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("bf5aea53-b502-409f-885d-b93f91df59a9", "Heading4")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Data type")))
,
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction2()
,                                new org.instantlogic.interaction.page.FragmentTemplate("45ab8b31-9794-4750-bfba-9a6da6f6db1b", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.dataCategory)
,                                new org.instantlogic.interaction.page.FragmentTemplate("f0c542a6-5cb4-465a-861a-98cb5bee26ff", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.multiLine)
,                                new org.instantlogic.interaction.page.FragmentTemplate("800ea8c5-0006-4063-b40f-8715e791aae9", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.formatted)
,                                new org.instantlogic.interaction.page.FragmentTemplate("2e775c9b-4962-4c00-8f5d-881233e0ce60", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.percentage)
,                                new org.instantlogic.interaction.page.FragmentTemplate("a887a73b-9597-4932-b15c-a01de210081c", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.wholeNumber)
,                                new org.instantlogic.interaction.page.FragmentTemplate("e287817e-4a3c-43bf-9644-6ce469b8c2c0", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.exactRounding)
)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("aa58be38-fccb-48bb-933e-50ee3b69ea49", "Heading4")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Value")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("4b9458e1-03de-43b9-ad6b-9e051d221c1e", "Input")      .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.hasRelevance)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("a5fe1ce4-df59-4479-9f87-73473c57c65d", "Input")      .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.hasRule)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("45fe584a-9c98-4674-a540-145f92271f87", "Input")      .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.writeable)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("34a2ad96-a7e3-45e5-b7a3-b64d37c5ad50", "Input")      .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.hasDefault)
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