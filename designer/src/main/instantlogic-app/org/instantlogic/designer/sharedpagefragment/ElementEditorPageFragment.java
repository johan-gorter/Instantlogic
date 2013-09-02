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
		    d0.setAttribute(org.instantlogic.designer.entity.DesignEntity.name);
		  	org.instantlogic.fabric.deduction.AttributeDeduction d1 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d1.setAttribute(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d2 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d2.setOfEntity(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		    d1.setInstance(d2);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction5() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.ElementDesignEntity.editorOpen);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction6() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.ElementDesignEntity.previewMode);
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
    new org.instantlogic.interaction.page.FragmentTemplate("EEomzUnzyicaIgzy_bb107d48_e218", "Block")      
        .setStyleNames(new String[]{"element"})        
        .addChild("content",
            new org.instantlogic.interaction.page.SelectionElement(createDeduction0(),
                    new org.instantlogic.interaction.page.FragmentTemplate("CvaAseufamgmUhho_72666d9f_19f6", "Block")        
                        .addChild("content",
                            new org.instantlogic.interaction.page.IfElseElement(createDeduction1(),
                                    new org.instantlogic.interaction.page.FragmentTemplate("XcEvkztdxicyknEO_ed5e96da_adb9", "Block")        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("VOwufcwnsygbqlnp_c25086dd_9a53", "Block")      
                                                .setStyleNames(new String[]{"editor", "popover", "top"})        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("ZwmbtdtkbqajAggz_8ff170d9_4a9b", "Block")      
                                                        .setStyleNames(new String[]{"arrow"})        
                                                )        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("Svoaknmzgygdyklb_6ddf98ef_f07d", "Input")      
                                                        .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type)        
                                                )        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.IfElseElement(createDeduction2(),
                                                            new org.instantlogic.interaction.page.FragmentTemplate("oiIieyucoI_yeiwr_ce428292_9fd0", "Block")        
                                                                .addChild("content",
                                                                    new org.instantlogic.interaction.page.FragmentTemplate("WOyr_aIzbafqaiio_0cc2c408_45ca", "Input")      
                                                                        .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.entity)        
                                                                )        
                                                                .addChild("content",
                                                                    new org.instantlogic.interaction.page.IfElseElement(createDeduction3(),
                                                                            new org.instantlogic.interaction.page.FragmentTemplate("Vwibadikqa_ouhwz_3a66d18a_92e6", "Block")        
                                                                                .addChild("content",
                                                                                    new org.instantlogic.interaction.page.FragmentTemplate("ogEoujq_iuaIc_Uf_a2ed7085_20c5", "Input")      
                                                                                        .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.attribute)        
                                                                                )        
                                                                                .addChild("content",
                                                                                    new org.instantlogic.interaction.page.FragmentTemplate("EowOfcfsvIeogfvz_b245e9ed_43be", "Button")      
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
                            new org.instantlogic.interaction.page.FragmentTemplate("ihAplAdUwigem_Ei_b9fe0770_fe64", "Block")      
                                .setStyleNames(new String[]{"collapsable-content"})        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("WyoItdnxuielabqO_547eaa72_fb2e", "Link")      
                                        .setStyleNames(new String[]{"collapse-button"})        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("XUO_aAsbbybcajck_7275da78_4d8f", "Icon")      
                                                .setStyleNames(new String[]{"icon-chevron-down"})        
                                        )        
                                )        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("IaOoiEwfEyfegfAl_8e8b6c2f_2585", "PreviewLine")      
                                        .putValue("previewMode", createDeduction6())        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("iibzyjddxeeOaoyI_fc56e643_bb07", "Strong")      
                                                .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction4()).getTextTemplate())        
                                        )        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("LntImvykay_asgcO_61625448_5d00", "Block")      
                                                .setStyleNames(new String[]{"btn-group", "element-edit-options"})        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.IfElseElement(createDeduction5(),
                                                            new org.instantlogic.interaction.page.FragmentTemplate("StkbmAhaumfUcahp_7ce990da_bf5b", "Button")      
                                                                .setStyleNames(new String[]{"active", "btn-small"})      
                                                                .setEvent(org.instantlogic.designer.event.CloseEditorEvent.INSTANCE)        
                                                                .addChild("content",
                                                                    new org.instantlogic.interaction.page.FragmentTemplate("PzognynsEabuAawy_41972674_4c60", "Icon")      
                                                                        .setStyleNames(new String[]{"icon-pencil"})        
                                                                ),
                                                            new org.instantlogic.interaction.page.FragmentTemplate("uxIvxymnyabIshqe_09731e9d_788e", "Button")      
                                                                .setStyleNames(new String[]{"btn-small"})      
                                                                .setEvent(org.instantlogic.designer.event.OpenEditorEvent.INSTANCE)        
                                                                .addChild("content",
                                                                    new org.instantlogic.interaction.page.FragmentTemplate("KsrAiamvoefaUijh_5e5a0428_1c50", "Icon")      
                                                                        .setStyleNames(new String[]{"icon-pencil"})        
                                                                ))
        
                                                )        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("Vh_t_gaIqicoohtk_6d5cb328_3fda", "Button")      
                                                        .setStyleNames(new String[]{"btn-small", "btn-success"})      
                                                        .setEvent(org.instantlogic.designer.event.InsertFragmentTemplateBelowEvent.INSTANCE)        
                                                        .addChild("content",
                                                            new org.instantlogic.interaction.page.FragmentTemplate("OIkncfruqadlubcr_59f1654f_832b", "Icon")      
                                                                .setStyleNames(new String[]{"icon-hand-down"})        
                                                        )        
                                                )        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("ittqjhaOeuaouein_8a34ebfc_4c7b", "Button")      
                                                        .setStyleNames(new String[]{"btn-danger", "btn-small"})      
                                                        .setEvent(org.instantlogic.designer.event.RemoveFragmentTemplateEvent.INSTANCE)        
                                                        .addChild("content",
                                                            new org.instantlogic.interaction.page.FragmentTemplate("opAkrbgcumctAnsx_2ca22f10_dbae", "Icon")      
                                                                .setStyleNames(new String[]{"icon-remove"})        
                                                        )        
                                                )        
                                        )        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("AkkkEIjcAqgUqagm_709e7895_bfac", "Preview")        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("Qq_ngbtwuadwkfaA_7b3bdca8_26d4", "PreviewPlaceholder")      
                                                        .addCustomFilter(new org.instantlogic.designer.fragmentfilter.PreviewFragmentFilter())        
                                                )        
                                        )        
                                )        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.SelectionElement(createDeduction7(),
                                            new org.instantlogic.interaction.page.SelectionElement(createDeduction8(),
                                                        new org.instantlogic.interaction.page.SharedElementHolder("CkpEzbObUmfdi_my_eacb1df6_9066", org.instantlogic.designer.sharedpagefragment.ElementEditorPageFragment.INSTANCE)
)
)
        
                                )        
                        ))
        
        )        
        .addChild("content",
            new org.instantlogic.interaction.page.SelectionElement(createDeduction9(),
                    new org.instantlogic.interaction.page.FragmentTemplate("L_jgkbfjvq_eAgcx_5eaf2db5_4167", "Block")      
                        .setStyleNames(new String[]{"collapsable-content"})        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("QkOul_dlqugicjlE_f3288f47_25d7", "Link")      
                                .setStyleNames(new String[]{"collapse-button"})        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("_cnjivitOigbqleE_e217c0d8_5262", "Icon")      
                                        .setStyleNames(new String[]{"icon-chevron-down"})        
                                )        
                        )        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("JupOrUmota_aqcO_13d6514e_9829", "PreviewLine")      
                                .putValue("previewMode", createDeduction10())        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("YlymOj_ntuglwaik_f0c41484_62ae", "Strong")      
                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("[IfElse]").getTextTemplate())        
                                )        
                        ))
        
        )        
        .addChild("content",
            new org.instantlogic.interaction.page.SelectionElement(createDeduction11(),
                    new org.instantlogic.interaction.page.FragmentTemplate("UageUmupta_eUjvt_bfdf14ad_34cb", "Block")      
                        .setStyleNames(new String[]{"collapsable-content"})        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("Hnet_pwIwyaficyI_d2fac54b_333a", "Link")      
                                .setStyleNames(new String[]{"collapse-button"})        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("Vmvcykiime_bmmxs_8ff9c7d7_bacd", "Icon")      
                                        .setStyleNames(new String[]{"icon-chevron-down"})        
                                )        
                        )        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("SUiEtyOscIfdgkfu_8cbdc456_fe76", "PreviewLine")      
                                .putValue("previewMode", createDeduction12())        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("TuUpeAcofmdzwhy_d0bcd043_0788", "Strong")      
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
