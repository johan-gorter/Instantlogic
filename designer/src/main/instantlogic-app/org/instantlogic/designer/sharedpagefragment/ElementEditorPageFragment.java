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
		  	org.instantlogic.fabric.deduction.CastInstanceDeduction d1 = new org.instantlogic.fabric.deduction.CastInstanceDeduction();
		    d1.setToEntity(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d2 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d2.setOfEntity(org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		    d1.setInstance(d2);
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
    new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__003d", "Block")      
        .setStyleNames(new String[]{"element"})        
        .addChild("content",
            new org.instantlogic.interaction.page.SelectionElement(createDeduction0(),
                    new org.instantlogic.interaction.page.IfElseElement(createDeduction1(),
                            new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__003e", "Block")        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__003f", "Block")      
                                        .setStyleNames(new String[]{"editor", "popover", "top"})        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0040", "Block")      
                                                .setStyleNames(new String[]{"arrow"})        
                                        )        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0041", "Input")      
                                                .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type)        
                                        )        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.IfElseElement(createDeduction2(),
                                                    new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0042", "Block")        
                                                        .addChild("content",
                                                            new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0043", "Input")      
                                                                .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.entity)        
                                                        )        
                                                        .addChild("content",
                                                            new org.instantlogic.interaction.page.IfElseElement(createDeduction3(),
                                                                    new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0044", "Block")        
                                                                        .addChild("content",
                                                                            new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0045", "Input")      
                                                                                .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.attribute)        
                                                                        )        
                                                                        .addChild("content",
                                                                            new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0046", "Button")      
                                                                                .setStyleNames(new String[]{"after-previous-field"})      
                                                                                .setEvent(org.instantlogic.designer.event.NewAttributeForFragmentTemplateEvent.INSTANCE)      
                                                                                .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("New attribute").getTextTemplate())        
                                                                        ),
null
)
        
                                                        ),
null
)
        
                                        )        
                                ),
null
)
)
        
        )        
        .addChild("content",
            new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0047", "Block")      
                .setStyleNames(new String[]{"collapsable-content"})        
                .addChild("content",
                    new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0048", "Link")      
                        .setStyleNames(new String[]{"collapse-button"})        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0049", "Icon")      
                                .setStyleNames(new String[]{"icon-chevron-down"})        
                        )        
                )        
                .addChild("content",
                    new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__004a", "PreviewLine")      
                        .putValue("previewMode", createDeduction4())        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__004b", "Strong")      
                                .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction5()).getTextTemplate())        
                        )        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__004c", "Block")      
                                .setStyleNames(new String[]{"btn-group", "element-edit-options"})        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.IfElseElement(createDeduction6(),
                                            new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__004f", "Button")      
                                                .setStyleNames(new String[]{"btn-small", "active"})      
                                                .setEvent(org.instantlogic.designer.event.CloseEditorEvent.INSTANCE)        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0050", "Icon")      
                                                        .setStyleNames(new String[]{"icon-pencil"})        
                                                ),
                                            new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__004d", "Button")      
                                                .setStyleNames(new String[]{"btn-small"})      
                                                .setEvent(org.instantlogic.designer.event.OpenEditorEvent.INSTANCE)        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__004e", "Icon")      
                                                        .setStyleNames(new String[]{"icon-pencil"})        
                                                ))
        
                                )        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0051", "Button")      
                                        .setStyleNames(new String[]{"btn-small", "btn-success"})      
                                        .setEvent(org.instantlogic.designer.event.InsertFragmentTemplateBelowEvent.INSTANCE)        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0052", "Icon")      
                                                .setStyleNames(new String[]{"icon-hand-down"})        
                                        )        
                                )        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0053", "Button")      
                                        .setStyleNames(new String[]{"btn-small", "btn-danger"})      
                                        .setEvent(org.instantlogic.designer.event.RemoveFragmentTemplateEvent.INSTANCE)        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0054", "Icon")      
                                                .setStyleNames(new String[]{"icon-remove"})        
                                        )        
                                )        
                        )        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0055", "Preview")        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0056", "PreviewPlaceholder")      
                                        .addCustomFilter(new org.instantlogic.designer.fragmentfilter.PreviewFragmentFilter())        
                                )        
                        )        
                )        
                .addChild("content",
                    new org.instantlogic.interaction.page.SelectionElement(createDeduction7(),
                            new org.instantlogic.interaction.page.SelectionElement(createDeduction8(),
                                        new org.instantlogic.interaction.page.SharedElementHolder("Sharedelemntdsgn__0006", org.instantlogic.designer.sharedpagefragment.ElementEditorPageFragment.INSTANCE)
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
