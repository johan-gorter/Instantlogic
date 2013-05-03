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
	

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.CastInstanceDeduction d0 = new org.instantlogic.fabric.deduction.CastInstanceDeduction();
		    d0.setToEntity(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.ElementDesignEntity.editorOpen);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction2() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.FragmentTypeDesignEntity.hasAttribute);
		  	org.instantlogic.fabric.deduction.AttributeDeduction d1 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d1.setAttribute(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d2 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d2.setOfEntity(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		    d1.setInstance(d2);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction3() {
		  	org.instantlogic.fabric.deduction.HasValueDeduction d0 = new org.instantlogic.fabric.deduction.HasValueDeduction();
		  	org.instantlogic.fabric.deduction.AttributeDeduction d1 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d1.setAttribute(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.entity);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d2 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d2.setOfEntity(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		    d0.setInput(d1);
		    d1.setInstance(d2);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction4() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.ElementDesignEntity.previewMode);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction5() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DesignEntity.name);
		  	org.instantlogic.fabric.deduction.AttributeDeduction d1 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d1.setAttribute(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d2 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d2.setOfEntity(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		    d1.setInstance(d2);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction6() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.ElementDesignEntity.editorOpen);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction7() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.properties);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction8() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.PropertyDesignEntity.children);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}

	
	public static final org.instantlogic.interaction.page.Element SHARED_INSTANCE = 
    new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0040", "Block")      
        .setStyleNames(new String[]{"element"})        
        .addChild("content",
            new org.instantlogic.interaction.page.SelectionElement(createDeduction0()
,                    new org.instantlogic.interaction.page.IfElseElement(createDeduction1(),
        new org.instantlogic.interaction.page.Element[] {
                            new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0041", "Block")      
                                .setStyleNames(new String[]{"editor"})        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0042", "Input")      
                                        .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type)        
                                )        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.IfElseElement(createDeduction2(),
        new org.instantlogic.interaction.page.Element[] {
                                            new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0043", "Block")        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0044", "Input")      
                                                        .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.entity)        
                                                )        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.IfElseElement(createDeduction3(),
        new org.instantlogic.interaction.page.Element[] {
                                                            new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0045", "Block")        
                                                                .addChild("content",
                                                                    new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0046", "Input")      
                                                                        .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.attribute)        
                                                                )        
                                                                .addChild("content",
                                                                    new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0047", "Button")      
                                                                        .setEvent(org.instantlogic.designer.event.NewAttributeForFragmentTemplateEvent.INSTANCE)      
                                                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("New attribute").getTextTemplate())        
                                                                )        },
        new org.instantlogic.interaction.page.Element[] {
        }
)
        
                                                )        },
        new org.instantlogic.interaction.page.Element[] {
        }
)
        
                                )        },
        new org.instantlogic.interaction.page.Element[] {
        }
)
)
        
        )        
        .addChild("content",
            new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0048", "Block")      
                .setStyleNames(new String[]{"collapsable-content"})        
                .addChild("content",
                    new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0049", "Link")      
                        .setStyleNames(new String[]{"collapse-button"})        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__004a", "Icon")      
                                .setStyleNames(new String[]{"icon-chevron-down"})        
                        )        
                )        
                .addChild("content",
                    new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__004b", "PreviewLine")      
                        .putValue("previewMode", createDeduction4())        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__004c", "Strong")      
                                .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction5()).getTextTemplate())        
                        )        
                        .addChild("content",
                            new org.instantlogic.interaction.page.IfElseElement(createDeduction6(),
        new org.instantlogic.interaction.page.Element[] {
                                    new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__004e", "Link")      
                                        .setStyleNames(new String[]{"editor-toggle"})      
                                        .setEvent(org.instantlogic.designer.event.CloseEditorEvent.INSTANCE)      
                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Close editor").getTextTemplate())        },
        new org.instantlogic.interaction.page.Element[] {
                                    new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__004d", "Link")      
                                        .setStyleNames(new String[]{"editor-toggle"})      
                                        .setEvent(org.instantlogic.designer.event.OpenEditorEvent.INSTANCE)      
                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Edit").getTextTemplate())        }
)
        
                        )        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__004f", "Preview")        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0050", "PreviewPlaceholder")      
                                        .addCustomFilter(new org.instantlogic.designer.fragmentfilter.PreviewFragmentFilter())        
                                )        
                        )        
                )        
                .addChild("content",
                    new org.instantlogic.interaction.page.SelectionElement(createDeduction7()
,                            new org.instantlogic.interaction.page.SelectionElement(createDeduction8()
,                                        new org.instantlogic.interaction.page.SharedElementHolder("Sharedelemntdsgn__0008", org.instantlogic.designer.sharedpagefragment.ElementEditorPageFragment.INSTANCE)
)
)
        
                )        
        ); 

	protected ElementEditorPageFragment() {
	    INSTANCE=this;
	}
	
	static {
	    INSTANCE.setElement(SHARED_INSTANCE);
	}
	
}
