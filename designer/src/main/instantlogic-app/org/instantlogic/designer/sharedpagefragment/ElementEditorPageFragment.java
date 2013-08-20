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
    new org.instantlogic.interaction.page.FragmentTemplate("Aovj_Odm_qclIkxe_9fbb07d3_2177", "Block")      
        .setStyleNames(new String[]{"element"})        
        .addChild("content",
            new org.instantlogic.interaction.page.SelectionElement(createDeduction0(),
                    new org.instantlogic.interaction.page.FragmentTemplate("OcOtIeEkfaamyeer_f1386c50_09f8", "Block")        
                        .addChild("content",
                            new org.instantlogic.interaction.page.IfElseElement(createDeduction1(),
                                    new org.instantlogic.interaction.page.FragmentTemplate("XeaiIIl_eqbwkeze_45802bc6_e331", "Block")        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("iUmootUr_udowkeo_81d57043_eb4f", "Block")      
                                                .setStyleNames(new String[]{"editor", "popover", "top"})        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("NUEcbcadaagayolj_c2081da5_eb63", "Input")      
                                                        .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type)        
                                                )        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("OorkmeU_Eq_zo_gt_8e0a7af6_be1e", "Block")      
                                                        .setStyleNames(new String[]{"arrow"})        
                                                )        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.IfElseElement(createDeduction2(),
                                                            new org.instantlogic.interaction.page.FragmentTemplate("OetEcsekImagmdmv_7d69dbf4_2e63", "Block")        
                                                                .addChild("content",
                                                                    new org.instantlogic.interaction.page.IfElseElement(createDeduction3(),
                                                                            new org.instantlogic.interaction.page.FragmentTemplate("aaqEzww_pmbpwhqr_b399f5bc_6752", "Block")        
                                                                                .addChild("content",
                                                                                    new org.instantlogic.interaction.page.FragmentTemplate("KtimkbAkmIckAhmf_91b844c3_7212", "Input")      
                                                                                        .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.attribute)        
                                                                                )        
                                                                                .addChild("content",
                                                                                    new org.instantlogic.interaction.page.FragmentTemplate("MzmkpxyvgiceicUl_9a7981a3_4636", "Button")      
                                                                                        .setStyleNames(new String[]{"after-previous-field"})      
                                                                                        .setEvent(org.instantlogic.designer.event.NewAttributeForFragmentTemplateEvent.INSTANCE)      
                                                                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("New attribute").getTextTemplate())        
                                                                                ),
null
)
        
                                                                )        
                                                                .addChild("content",
                                                                    new org.instantlogic.interaction.page.FragmentTemplate("TrOtfhjummdbAghO_fecab12e_8c3f", "Input")      
                                                                        .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.entity)        
                                                                ),
null
)
        
                                                )        
                                        ),
null
)
        
                        )        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("FbzldzImsIfdmaOi_2e6eb7e9_c970", "Block")      
                                .setStyleNames(new String[]{"collapsable-content"})        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("HrzAjokglIgEodte_97f28c6f_d6c0", "Link")      
                                        .setStyleNames(new String[]{"collapse-button"})        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("Hm_mfbmhaIeIUlmm_3f7a8cb6_d0d0", "Icon")      
                                                .setStyleNames(new String[]{"icon-chevron-down"})        
                                        )        
                                )        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("OOmOeftnlIepAmiU_a52d3e9a_49c2", "PreviewLine")      
                                        .putValue("previewMode", createDeduction4())        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("GanAOvogUicIcmyd_83ea2b3a_2692", "Preview")        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("SdmlccoaAigcIjkl_3d094dee_1037", "PreviewPlaceholder")      
                                                        .addCustomFilter(new org.instantlogic.designer.fragmentfilter.PreviewFragmentFilter())        
                                                )        
                                        )        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("_ygsvllsEuggyiEl_b77b9412_2a86", "Strong")      
                                                .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction5()).getTextTemplate())        
                                        )        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("ohzsuzcjnydigfln_40fb8a6d_894f", "Block")      
                                                .setStyleNames(new String[]{"btn-group", "element-edit-options"})        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("AxjAkrqjvmavoevu_a588c98d_986d", "Button")      
                                                        .setStyleNames(new String[]{"btn-small", "btn-success"})      
                                                        .setEvent(org.instantlogic.designer.event.InsertFragmentTemplateBelowEvent.INSTANCE)        
                                                        .addChild("content",
                                                            new org.instantlogic.interaction.page.FragmentTemplate("AIdblEEwtu_ds_hj_bc2a76cf_ea6c", "Icon")      
                                                                .setStyleNames(new String[]{"icon-hand-down"})        
                                                        )        
                                                )        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("Vajqmtybnmcriker_e561510c_3b87", "Button")      
                                                        .setStyleNames(new String[]{"btn-danger", "btn-small"})      
                                                        .setEvent(org.instantlogic.designer.event.RemoveFragmentTemplateEvent.INSTANCE)        
                                                        .addChild("content",
                                                            new org.instantlogic.interaction.page.FragmentTemplate("ZAEtkAvxdyaAaogf_e9d039aa_530b", "Icon")      
                                                                .setStyleNames(new String[]{"icon-remove"})        
                                                        )        
                                                )        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.IfElseElement(createDeduction6(),
                                                            new org.instantlogic.interaction.page.FragmentTemplate("ZbmUAnIepqaxA_Oe_0f497549_08c7", "Button")      
                                                                .setStyleNames(new String[]{"active", "btn-small"})      
                                                                .setEvent(org.instantlogic.designer.event.CloseEditorEvent.INSTANCE)        
                                                                .addChild("content",
                                                                    new org.instantlogic.interaction.page.FragmentTemplate("aAhcpesyIudAgnmp_4fac5e84_33dd", "Icon")      
                                                                        .setStyleNames(new String[]{"icon-pencil"})        
                                                                ),
                                                            new org.instantlogic.interaction.page.FragmentTemplate("PueromEOjeeeaazA_7f0f2623_03e9", "Button")      
                                                                .setStyleNames(new String[]{"btn-small"})      
                                                                .setEvent(org.instantlogic.designer.event.OpenEditorEvent.INSTANCE)        
                                                                .addChild("content",
                                                                    new org.instantlogic.interaction.page.FragmentTemplate("ojOosczrpaaImjui_bd03029f_4d2c", "Icon")      
                                                                        .setStyleNames(new String[]{"icon-pencil"})        
                                                                ))
        
                                                )        
                                        )        
                                )        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.SelectionElement(createDeduction7(),
                                            new org.instantlogic.interaction.page.SelectionElement(createDeduction8(),
                                                        new org.instantlogic.interaction.page.SharedElementHolder("AEAzqmwqpIfuwbne_e3d95b06_de8a", org.instantlogic.designer.sharedpagefragment.ElementEditorPageFragment.INSTANCE)
)
)
        
                                )        
                        ))
        
        )        
        .addChild("content",
            new org.instantlogic.interaction.page.SelectionElement(createDeduction9(),
                    new org.instantlogic.interaction.page.FragmentTemplate("okihwUA_UeasUgam_c07ae02b_3bdb", "Block")      
                        .setStyleNames(new String[]{"collapsable-content"})        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("HazmfrmOnyejoecj_b7d130cd_1267", "PreviewLine")      
                                .putValue("previewMode", createDeduction10())        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("Mtdmqpkgjmcxeb_x_056d1ad0_4a41", "Strong")      
                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("[IfElse]").getTextTemplate())        
                                )        
                        )        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("UffobdAIra_pk_eI_e8181b27_d868", "Link")      
                                .setStyleNames(new String[]{"collapse-button"})        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("RAzqmaEokibaAd_d_66237a3d_3f25", "Icon")      
                                        .setStyleNames(new String[]{"icon-chevron-down"})        
                                )        
                        ))
        
        )        
        .addChild("content",
            new org.instantlogic.interaction.page.SelectionElement(createDeduction11(),
                    new org.instantlogic.interaction.page.FragmentTemplate("RfeEscykAagcmiv_7757c7f6_17e0", "Block")      
                        .setStyleNames(new String[]{"collapsable-content"})        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("HEntyqkpAe_OyoyU_cf244ec1_a831", "Link")      
                                .setStyleNames(new String[]{"collapse-button"})        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("LqsbIUbiiaafIiii_47773377_6ea2", "Icon")      
                                        .setStyleNames(new String[]{"icon-chevron-down"})        
                                )        
                        )        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("oeeAeujsjueroiIO_43223ac3_084c", "PreviewLine")      
                                .putValue("previewMode", createDeduction12())        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("ApuEizuxie_qI_xd_bf7a5a40_2029", "Strong")      
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
