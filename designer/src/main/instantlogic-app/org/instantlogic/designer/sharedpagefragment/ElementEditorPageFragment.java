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

public class ElementEditorPageFragment extends org.instantlogic.interaction.page.SharedElement {
	
	public static ElementEditorPageFragment INSTANCE = new ElementEditorPageFragment();
	

	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTemplateDesign> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.ElementDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTemplateDesign> d1 
		  		= org.instantlogic.fabric.deduction.CastInstanceDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction1() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.ElementDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.ElementDesignEntity.editorOpen, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction2() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTemplateDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTypeDesign> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type, d0);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> d2 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.FragmentTypeDesignEntity.hasAttribute, d1);
		return d2;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction3() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTemplateDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.EntityDesign> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.entity, d0);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> d2 
		  		= org.instantlogic.fabric.deduction.HasValueDeduction.create(d1);
		return d2;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction4() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.ElementDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.ElementDesignEntity.previewMode, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction5() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTemplateDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTypeDesign> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type, d0);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d2 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d1);
		return d2;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction6() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.ElementDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.ElementDesignEntity.editorOpen, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PropertyDesign>> createDeduction7() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTemplateDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PropertyDesign>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.properties, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign>> createDeduction8() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.PropertyDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.PropertyDesignEntity.children, d0);
		return d1;
	}

	
	public static final org.instantlogic.interaction.page.Element SHARED_INSTANCE = 
        new org.instantlogic.interaction.page.FragmentTemplate("498881d4-ce4f-44c3-8a53-97e18d3307bd", "Block")      .setStyleNames(new String[]{"element"})
      
        .putChildren("content",
                new org.instantlogic.interaction.page.SelectionElement(createDeduction0()
,                        new org.instantlogic.interaction.page.IfElseElement(createDeduction1(),
        new org.instantlogic.interaction.page.Element[] {
                                new org.instantlogic.interaction.page.FragmentTemplate("a5ddd809-20f7-4acd-9373-d981821120e3", "Block")      .setStyleNames(new String[]{"editor"})
      
                                .putChildren("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("ff393e96-65fa-4bd8-b5fb-784c29878718", "Input")      .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type)
,
                                        new org.instantlogic.interaction.page.IfElseElement(createDeduction2(),
        new org.instantlogic.interaction.page.Element[] {
                                                new org.instantlogic.interaction.page.FragmentTemplate("9886c47e-c567-4e9e-83fc-705d46dd3b8f", "Block")      
                                                .putChildren("content",
                                                        new org.instantlogic.interaction.page.FragmentTemplate("90a14c24-f2e7-4f0d-ad08-1e0f7de619fa", "Input")      .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.entity)
,
                                                        new org.instantlogic.interaction.page.IfElseElement(createDeduction3(),
        new org.instantlogic.interaction.page.Element[] {
                                                                new org.instantlogic.interaction.page.FragmentTemplate("037f714d-c8e8-4825-b27b-d6a9cb0dbdf9", "Block")      
                                                                .putChildren("content",
                                                                        new org.instantlogic.interaction.page.FragmentTemplate("b074a631-fd5d-4855-882c-0068e4fce2d3", "Input")      .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.attribute)
,
                                                                        new org.instantlogic.interaction.page.FragmentTemplate("f3ae148a-0eda-4574-a1c3-68a22cf6a9c2", "Button")      .setEvent(org.instantlogic.designer.event.NewAttributeForFragmentTemplateEvent.INSTANCE)
      
                                                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("New attribute")))
                                                                )
        },
        new org.instantlogic.interaction.page.Element[] {
        }
)
                                                )
        },
        new org.instantlogic.interaction.page.Element[] {
        }
)
                                )
        },
        new org.instantlogic.interaction.page.Element[] {
        }
)
)
,
                new org.instantlogic.interaction.page.FragmentTemplate("55a57f82-e811-4e9f-aeff-93e9e540de29", "Block")      .setStyleNames(new String[]{"collapsable-content"})
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("db46ff4e-a61e-432a-af5a-0de14d28c4e5", "Link")      .setStyleNames(new String[]{"collapse-button"})
      
                        .putChildren("content",
                                new org.instantlogic.interaction.page.FragmentTemplate("08bf3fe0-71e7-460f-bf96-cd82764bc9ad", "Icon")      .setStyleNames(new String[]{"icon-chevron-down"})
                        )
,
                        new org.instantlogic.interaction.page.FragmentTemplate("f5c7c51d-ea7c-4a93-900d-cc60c1048284", "PreviewLine")      
                        .putValue("previewMode", createDeduction4())      
                        .putChildren("content",
                                new org.instantlogic.interaction.page.FragmentTemplate("470f363b-0368-49d1-bf21-5cf15921e6cf", "Strong")      
                                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction5())))
,
                                new org.instantlogic.interaction.page.IfElseElement(createDeduction6(),
        new org.instantlogic.interaction.page.Element[] {
                                        new org.instantlogic.interaction.page.FragmentTemplate("ef7a520d-574b-4384-9831-ed14a66b5c06", "Link")      .setStyleNames(new String[]{"editor-toggle"})
      .setEvent(org.instantlogic.designer.event.CloseEditorEvent.INSTANCE)
      
                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Close editor")))
        },
        new org.instantlogic.interaction.page.Element[] {
                                        new org.instantlogic.interaction.page.FragmentTemplate("c6fe9cad-4400-4a57-93e6-537caff54fe8", "Link")      .setStyleNames(new String[]{"editor-toggle"})
      .setEvent(org.instantlogic.designer.event.OpenEditorEvent.INSTANCE)
      
                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Edit")))
        }
)
,
                                new org.instantlogic.interaction.page.FragmentTemplate("cfa3a51f-a358-455c-bd8d-da7a949f4d69", "Preview")      
                                .putChildren("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("7e76f490-fdb7-4d22-8d8d-3f399bfa9d79", "PreviewPlaceholder")          .addCustomFilter(new org.instantlogic.designer.fragmentfilter.PreviewFragmentFilter())
                                )
                        )
,
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction7()
,                                new org.instantlogic.interaction.page.SelectionElement(createDeduction8()
,                                            new org.instantlogic.interaction.page.SharedElementHolder("5ba99363-3bf2-4a5f-ab85-33d187ea6405", org.instantlogic.designer.sharedpagefragment.ElementEditorPageFragment.INSTANCE)
)
)
                )
        )
; 

	protected ElementEditorPageFragment() {
	    INSTANCE=this;
	}
	
	static {
	    INSTANCE.setElement(SHARED_INSTANCE);
	}
	
}
