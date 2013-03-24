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
		  	org.instantlogic.fabric.deduction.CastInstanceDeduction d0 
		  	  = new org.instantlogic.fabric.deduction.CastInstanceDeduction(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 
		  	  = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction(org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE);
		    d0.addToInputs(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction1() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 
		  	  = new org.instantlogic.fabric.deduction.AttributeDeduction(org.instantlogic.designer.entity.ElementDesignEntity.editorOpen);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 
		  	  = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction(org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE);
		    d0.addToInputs(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction2() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 
		  	  = new org.instantlogic.fabric.deduction.AttributeDeduction(org.instantlogic.designer.entity.FragmentTypeDesignEntity.hasAttribute);
		  	org.instantlogic.fabric.deduction.AttributeDeduction d1 
		  	  = new org.instantlogic.fabric.deduction.AttributeDeduction(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d2 
		  	  = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		    d0.addToInputs(d1);
		    d1.addToInputs(d2);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction3() {
		  	org.instantlogic.fabric.deduction.HasValueDeduction d0 
		  	  = new org.instantlogic.fabric.deduction.HasValueDeduction();
		  	org.instantlogic.fabric.deduction.AttributeDeduction d1 
		  	  = new org.instantlogic.fabric.deduction.AttributeDeduction(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.entity);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d2 
		  	  = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		    d0.addToInputs(d1);
		    d1.addToInputs(d2);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction4() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 
		  	  = new org.instantlogic.fabric.deduction.AttributeDeduction(org.instantlogic.designer.entity.ElementDesignEntity.previewMode);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 
		  	  = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction(org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE);
		    d0.addToInputs(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction5() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 
		  	  = new org.instantlogic.fabric.deduction.AttributeDeduction(org.instantlogic.designer.entity.DesignEntity.name);
		  	org.instantlogic.fabric.deduction.AttributeDeduction d1 
		  	  = new org.instantlogic.fabric.deduction.AttributeDeduction(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d2 
		  	  = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		    d0.addToInputs(d1);
		    d1.addToInputs(d2);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction6() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 
		  	  = new org.instantlogic.fabric.deduction.AttributeDeduction(org.instantlogic.designer.entity.ElementDesignEntity.editorOpen);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 
		  	  = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction(org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE);
		    d0.addToInputs(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PropertyDesign>> createDeduction7() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 
		  	  = new org.instantlogic.fabric.deduction.AttributeDeduction(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.properties);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 
		  	  = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		    d0.addToInputs(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign>> createDeduction8() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 
		  	  = new org.instantlogic.fabric.deduction.AttributeDeduction(org.instantlogic.designer.entity.PropertyDesignEntity.children);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 
		  	  = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction(org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE);
		    d0.addToInputs(d1);
		return d0;
	}

	
	public static final org.instantlogic.interaction.page.Element SHARED_INSTANCE = 
        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__003f", "Block")      .setStyleNames(new String[]{"element"})
      
        .putChildren("content",
                new org.instantlogic.interaction.page.SelectionElement(createDeduction0()
,                        new org.instantlogic.interaction.page.IfElseElement(createDeduction1(),
        new org.instantlogic.interaction.page.Element[] {
                                new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0040", "Block")      .setStyleNames(new String[]{"editor"})
      
                                .putChildren("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0041", "Input")      .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type)
,
                                        new org.instantlogic.interaction.page.IfElseElement(createDeduction2(),
        new org.instantlogic.interaction.page.Element[] {
                                                new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0042", "Block")      
                                                .putChildren("content",
                                                        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0043", "Input")      .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.entity)
,
                                                        new org.instantlogic.interaction.page.IfElseElement(createDeduction3(),
        new org.instantlogic.interaction.page.Element[] {
                                                                new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0044", "Block")      
                                                                .putChildren("content",
                                                                        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0045", "Input")      .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.attribute)
,
                                                                        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0046", "Button")      .setEvent(org.instantlogic.designer.event.NewAttributeForFragmentTemplateEvent.INSTANCE)
      
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
                new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0047", "Block")      .setStyleNames(new String[]{"collapsable-content"})
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0048", "Link")      .setStyleNames(new String[]{"collapse-button"})
      
                        .putChildren("content",
                                new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0049", "Icon")      .setStyleNames(new String[]{"icon-chevron-down"})
                        )
,
                        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__004a", "PreviewLine")      
                        .putValue("previewMode", createDeduction4())      
                        .putChildren("content",
                                new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__004b", "Strong")      
                                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction5())))
,
                                new org.instantlogic.interaction.page.IfElseElement(createDeduction6(),
        new org.instantlogic.interaction.page.Element[] {
                                        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__004d", "Link")      .setStyleNames(new String[]{"editor-toggle"})
      .setEvent(org.instantlogic.designer.event.CloseEditorEvent.INSTANCE)
      
                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Close editor")))
        },
        new org.instantlogic.interaction.page.Element[] {
                                        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__004c", "Link")      .setStyleNames(new String[]{"editor-toggle"})
      .setEvent(org.instantlogic.designer.event.OpenEditorEvent.INSTANCE)
      
                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Edit")))
        }
)
,
                                new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__004e", "Preview")      
                                .putChildren("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__004f", "PreviewPlaceholder")          .addCustomFilter(new org.instantlogic.designer.fragmentfilter.PreviewFragmentFilter())
                                )
                        )
,
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction7()
,                                new org.instantlogic.interaction.page.SelectionElement(createDeduction8()
,                                            new org.instantlogic.interaction.page.SharedElementHolder("Sharedelemntdsgn__0008", org.instantlogic.designer.sharedpagefragment.ElementEditorPageFragment.INSTANCE)
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
