/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer.flow.flow;

public class FlowDetailsPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final FlowDetailsPlaceTemplate INSTANCE = new FlowDetailsPlaceTemplate();

	@Override
	public String getId() {
		return "64a1c5a4-78cb-42de-b7ab-c6634c7ee712";
	}
	

	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.Design> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		    org.instantlogic.fabric.deduction.Deduction<java.lang.String> d2 
		    	= new org.instantlogic.designer.deduction.CapitalizeFirstDeduction(d1);
		return d2;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowNodeBaseDesign>> createDeduction1() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FlowDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowNodeBaseDesign>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.FlowDesignEntity.nodes, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction2() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FlowNodeBaseDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction3() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.Design> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		    org.instantlogic.fabric.deduction.Deduction<java.lang.String> d2 
		    	= new org.instantlogic.designer.deduction.CapitalizeFirstDeduction(d1);
		return d2;
	}

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("0f893f71-7140-41fd-948d-fdb2d156c0c8", "Page")      
        .putChildren("mainContent",
                    new org.instantlogic.interaction.page.SharedElementHolder("4b69f97a-ea7b-486a-9703-dd588632f04c", org.instantlogic.designer.sharedpagefragment.ApplicationContextPageFragment.INSTANCE)
,
                new org.instantlogic.interaction.page.FragmentTemplate("e4eafbe8-3865-49e2-940a-24d195eaeb69", "Block")      .setStyleNames(new String[]{"card"})
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("0a43c50e-c648-48b9-98c9-4e75de77a9df", "Heading3")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0()),new org.instantlogic.fabric.text.StringTemplate(" (Flow)")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("e573b09f-dc67-4e12-b5bc-405c76ed0781", "Input")      .setField(org.instantlogic.designer.entity.DesignEntity.INSTANCE, org.instantlogic.designer.entity.DesignEntity.name)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("f7979b24-de72-41fc-9d6e-9966956ed274", "Heading4")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Nodes")))
,
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction1()
,                                new org.instantlogic.interaction.page.FragmentTemplate("727a89da-cb83-48f6-824b-6654a8285b01", "Link")      .setEvent(org.instantlogic.designer.event.FlowNodeDetailsEvent.INSTANCE)
      
                                .putChildren("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("f89f8b26-4d86-4f9d-b295-0e2dec3d7aef", "Block")      
                                        .putChildren("content",
                                                new org.instantlogic.interaction.page.FragmentTemplate("88708e6f-765a-4a99-b52d-781fe7227c2c", "Strong")      
                                                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction2())))
                                        )
                                )
)
                )
        )
; 
	
	private static final org.instantlogic.fabric.text.TextTemplate TITLE = new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction3()),new org.instantlogic.fabric.text.StringTemplate(" (Flow)"));
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
        return "FlowDetails";
    }
}