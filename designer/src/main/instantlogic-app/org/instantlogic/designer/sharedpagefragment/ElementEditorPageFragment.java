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


	private static org.instantlogic.fabric.deduction.Deduction createDeduction9() {
		  	org.instantlogic.fabric.deduction.CastInstanceDeduction d0 = new org.instantlogic.fabric.deduction.CastInstanceDeduction();
		    d0.setToEntity(org.instantlogic.designer.entity.IfElseDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction10() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.ElementDesignEntity.previewMode);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction11() {
		  	org.instantlogic.fabric.deduction.CastInstanceDeduction d0 = new org.instantlogic.fabric.deduction.CastInstanceDeduction();
		    d0.setToEntity(org.instantlogic.designer.entity.SelectionDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction12() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.ElementDesignEntity.previewMode);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}

	
	public static final org.instantlogic.interaction.page.Element SHARED_INSTANCE = 
    new org.instantlogic.interaction.page.FragmentTemplate("evxEnhhp_igfkhge_8fc1cbb5_3d2b", "Block")      
        .setStyleNames(new String[]{"element"})        
        .addChild("content",
            new org.instantlogic.interaction.page.SelectionElement(createDeduction0(),
                    new org.instantlogic.interaction.page.FragmentTemplate("DUzjAggjlugfAnqp_6a3bf575_356c", "Block")        
                        .addChild("content",
                            new org.instantlogic.interaction.page.IfElseElement(createDeduction1(),
                                    new org.instantlogic.interaction.page.FragmentTemplate("WgIgheeymagEmeen_5dcf0ec9_47b5", "Block")        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("PrkvadhptmeeAetA_f895f015_7a1f", "Block")      
                                                .setStyleNames(new String[]{"editor", "popover", "top"})        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("R__ftkzlyecuImul_a70bcbcc_1472", "Block")      
                                                        .setStyleNames(new String[]{"arrow"})        
                                                )        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("Hnznrndstafmmckz_3f7e1a9a_f1ce", "Input")      
                                                        .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type)        
                                                )        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.IfElseElement(createDeduction2(),
                                                            new org.instantlogic.interaction.page.FragmentTemplate("esxxjxgqIi_bi__g_6aaeec5a_50c2", "Block")        
                                                                .addChild("content",
                                                                    new org.instantlogic.interaction.page.FragmentTemplate("AhEeievUwidgyelO_0b982d70_fd29", "Input")      
                                                                        .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.entity)        
                                                                )        
                                                                .addChild("content",
                                                                    new org.instantlogic.interaction.page.IfElseElement(createDeduction3(),
                                                                            new org.instantlogic.interaction.page.FragmentTemplate("VdqgcUqyEIbrcodn_e0cf565b_5f79", "Block")        
                                                                                .addChild("content",
                                                                                    new org.instantlogic.interaction.page.FragmentTemplate("GnoOlsqcxqapybes_2ba3fb86_cf68", "Input")      
                                                                                        .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.attribute)        
                                                                                )        
                                                                                .addChild("content",
                                                                                    new org.instantlogic.interaction.page.FragmentTemplate("UdskIUyzOiapcdhk_4f19ff78_578d", "Button")      
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
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("Gtsoozyunycfunup_10214bcd_2af4", "Block")      
                                .setStyleNames(new String[]{"collapsable-content"})        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("SuilgfqgAafdg_zU_15d93c14_4a41", "Link")      
                                        .setStyleNames(new String[]{"collapse-button"})        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("JOiIlrUpiidcacIn_3e93ecbd_8a13", "Icon")      
                                                .setStyleNames(new String[]{"icon-chevron-down"})        
                                        )        
                                )        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("LvnnckcUhmbIUklr_df1d6397_79e2", "PreviewLine")      
                                        .putValue("previewMode", createDeduction4())        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("ZhellxyeyudpwoEv_56743efa_8c89", "Strong")      
                                                .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction5()).getTextTemplate())        
                                        )        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("ZdevohdotachqfAl_8fdb2e68_de8b", "Block")      
                                                .setStyleNames(new String[]{"btn-group", "element-edit-options"})        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.IfElseElement(createDeduction6(),
                                                            new org.instantlogic.interaction.page.FragmentTemplate("VbwzdkEUsybIgocU_a6a3a06a_a4a4", "Button")      
                                                                .setStyleNames(new String[]{"active", "btn-small"})      
                                                                .setEvent(org.instantlogic.designer.event.CloseEditorEvent.INSTANCE)        
                                                                .addChild("content",
                                                                    new org.instantlogic.interaction.page.FragmentTemplate("DgyurOeviigwemoI_d8044f62_161a", "Icon")      
                                                                        .setStyleNames(new String[]{"icon-pencil"})        
                                                                ),
                                                            new org.instantlogic.interaction.page.FragmentTemplate("Ibqabd_j_Igykbzm_eb1163ec_15ff", "Button")      
                                                                .setStyleNames(new String[]{"btn-small"})      
                                                                .setEvent(org.instantlogic.designer.event.OpenEditorEvent.INSTANCE)        
                                                                .addChild("content",
                                                                    new org.instantlogic.interaction.page.FragmentTemplate("Xdow_tfxfab_keOg_95d54117_7b4e", "Icon")      
                                                                        .setStyleNames(new String[]{"icon-pencil"})        
                                                                ))
        
                                                )        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("icdpiAbaOmdgAhtA_31223797_1acc", "Button")      
                                                        .setStyleNames(new String[]{"btn-small", "btn-success"})      
                                                        .setEvent(org.instantlogic.designer.event.InsertFragmentTemplateBelowEvent.INSTANCE)        
                                                        .addChild("content",
                                                            new org.instantlogic.interaction.page.FragmentTemplate("MrdIjbblIegpuedh_c839f162_fb1c", "Icon")      
                                                                .setStyleNames(new String[]{"icon-hand-down"})        
                                                        )        
                                                )        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("TOdfsmetsadlgoO_a9ac6894_5a43", "Button")      
                                                        .setStyleNames(new String[]{"btn-danger", "btn-small"})      
                                                        .setEvent(org.instantlogic.designer.event.RemoveFragmentTemplateEvent.INSTANCE)        
                                                        .addChild("content",
                                                            new org.instantlogic.interaction.page.FragmentTemplate("HavpAnbOOq_zilEc_123ee59e_f8cd", "Icon")      
                                                                .setStyleNames(new String[]{"icon-remove"})        
                                                        )        
                                                )        
                                        )        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("ZIEsbjEjhuczoiqh_31f0709a_5d5e", "Preview")        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("igsouyOkaid_wbnl_2fdeb2ba_e89f", "PreviewPlaceholder")      
                                                        .addCustomFilter(new org.instantlogic.designer.fragmentfilter.PreviewFragmentFilter())        
                                                )        
                                        )        
                                )        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.SelectionElement(createDeduction7(),
                                            new org.instantlogic.interaction.page.SelectionElement(createDeduction8(),
                                                        new org.instantlogic.interaction.page.SharedElementHolder("iErxAdAaiIfckolI_88ff3f6d_8131", org.instantlogic.designer.sharedpagefragment.ElementEditorPageFragment.INSTANCE)
)
)
        
                                )        
                        ))
        
        )        
        .addChild("content",
            new org.instantlogic.interaction.page.SelectionElement(createDeduction9(),
                    new org.instantlogic.interaction.page.FragmentTemplate("iIsjIxbqae_kUoAz_305b9ab6_d62f", "Block")      
                        .setStyleNames(new String[]{"collapsable-content"})        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("Xxpmtnyhrmgxcksz_f990a42b_35fc", "Link")      
                                .setStyleNames(new String[]{"collapse-button"})        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("ibeolbzvjIgOwaom_22841e5f_7c14", "Icon")      
                                        .setStyleNames(new String[]{"icon-chevron-down"})        
                                )        
                        )        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("TIirmaUxcyeagfUx_bca74e4d_57b9", "PreviewLine")      
                                .putValue("previewMode", createDeduction10())        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("LAtheapvAa_Imnmb_5fce5f02_0fad", "Strong")      
                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("[IfElse]").getTextTemplate())        
                                )        
                        ))
        
        )        
        .addChild("content",
            new org.instantlogic.interaction.page.SelectionElement(createDeduction11(),
                    new org.instantlogic.interaction.page.FragmentTemplate("B_wvraijuecbskrI_31e34098_e048", "Block")      
                        .setStyleNames(new String[]{"collapsable-content"})        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("BilEAbpqxq_oobbb_af523316_b5cd", "Link")      
                                .setStyleNames(new String[]{"collapse-button"})        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("NiOokbz_ae_OekAO_da249151_3059", "Icon")      
                                        .setStyleNames(new String[]{"icon-chevron-down"})        
                                )        
                        )        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("ibxpyptthIfoImzg_e922dfb0_6a07", "PreviewLine")      
                                .putValue("previewMode", createDeduction12())        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("apewpUr_sqcraowE_6213c4fe_70be", "Strong")      
                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("[Selection]").getTextTemplate())        
                                )        
                        ))
        
        ); 

	protected ElementEditorPageFragment() {
	    INSTANCE=this;
	}
	
	static {
	    INSTANCE.setElement(SHARED_INSTANCE);
	}
	
}
