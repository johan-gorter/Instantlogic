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
        new org.instantlogic.interaction.page.FragmentTemplate("17050c45-b167-440b-8fa0-41c1d6cb0521", "Block")      .setStyleNames(new String[]{"element"})
      
        .putChildren("content",
                new org.instantlogic.interaction.page.SelectionElement(createDeduction0()
,                        new org.instantlogic.interaction.page.IfElseElement(createDeduction1(),
        new org.instantlogic.interaction.page.Element[] {
                                new org.instantlogic.interaction.page.FragmentTemplate("fc4973e9-89f9-4a4b-b384-19982b16f792", "Block")      .setStyleNames(new String[]{"editor"})
      
                                .putChildren("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("1d2ea3a7-44f1-4a66-a92b-e17df375e7fb", "Input")      .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type)
,
                                        new org.instantlogic.interaction.page.IfElseElement(createDeduction2(),
        new org.instantlogic.interaction.page.Element[] {
                                                new org.instantlogic.interaction.page.FragmentTemplate("e1ccf55f-3740-4e4c-b6f9-2791e76547c3", "Block")      
                                                .putChildren("content",
                                                        new org.instantlogic.interaction.page.FragmentTemplate("ee37901c-2c7f-427a-a9ff-0362ce620e35", "Input")      .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.entity)
,
                                                        new org.instantlogic.interaction.page.IfElseElement(createDeduction3(),
        new org.instantlogic.interaction.page.Element[] {
                                                                new org.instantlogic.interaction.page.FragmentTemplate("9d741a2b-2875-4f49-ae62-e71181bec1e1", "Block")      
                                                                .putChildren("content",
                                                                        new org.instantlogic.interaction.page.FragmentTemplate("f62a6e40-d908-4620-a57c-a5135566fae2", "Input")      .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.attribute)
,
                                                                        new org.instantlogic.interaction.page.FragmentTemplate("00833dca-0b14-4918-a58a-41ce2fb35cbd", "Button")      .setEvent(org.instantlogic.designer.event.NewAttributeForFragmentTemplateEvent.INSTANCE)
      
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
                new org.instantlogic.interaction.page.FragmentTemplate("5db8376a-d18f-45cb-9456-d1ffb4a5b345", "Block")      .setStyleNames(new String[]{"collapsable-content"})
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("1c3b61b0-00d2-45a5-9436-65ab7548d2d2", "Button")      .setStyleNames(new String[]{"collapse-button"})
      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("-")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("2fbe5c51-c764-43e2-a651-6b6408da32c9", "PreviewLine")      
                        .putValue("previewMode", createDeduction4())      
                        .putChildren("content",
                                new org.instantlogic.interaction.page.FragmentTemplate("7fb11bcf-0f9e-405a-96a4-09484532b9d3", "Strong")      
                                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction5())))
,
                                new org.instantlogic.interaction.page.IfElseElement(createDeduction6(),
        new org.instantlogic.interaction.page.Element[] {
                                        new org.instantlogic.interaction.page.FragmentTemplate("097bb766-3c92-4939-b6f0-110e7a0c00b2", "Link")      .setStyleNames(new String[]{"editor-toggle"})
      .setEvent(org.instantlogic.designer.event.CloseEditorEvent.INSTANCE)
      
                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Close editor")))
        },
        new org.instantlogic.interaction.page.Element[] {
                                        new org.instantlogic.interaction.page.FragmentTemplate("2f17fcba-1122-4c8a-a353-3b751b2942f4", "Link")      .setStyleNames(new String[]{"editor-toggle"})
      .setEvent(org.instantlogic.designer.event.OpenEditorEvent.INSTANCE)
      
                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Edit")))
        }
)
,
                                new org.instantlogic.interaction.page.FragmentTemplate("3c587fe3-943b-4973-831d-e5ed7cd33456", "Preview")      
                                .putChildren("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("eaccca1c-8885-46a5-8e8f-3939b636f5bc", "PreviewPlaceholder")          .addCustomFilter(new org.instantlogic.designer.fragmentfilter.PreviewFragmentFilter())
                                )
                        )
,
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction7()
,                                new org.instantlogic.interaction.page.SelectionElement(createDeduction8()
,                                            new org.instantlogic.interaction.page.SharedElementHolder("f8107726-986a-45e0-a906-bee2f69b013b", org.instantlogic.designer.sharedpagefragment.ElementEditorPageFragment.INSTANCE)
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
