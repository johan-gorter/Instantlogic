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
    new org.instantlogic.interaction.page.FragmentTemplate("KqqIymrezegtidcq_ab17c837_23af", "Block")      
        .setStyleNames(new String[]{"element"})        
        .addChild("content",
            new org.instantlogic.interaction.page.SelectionElement(createDeduction0(),
                    new org.instantlogic.interaction.page.FragmentTemplate("GtOhjUUkneavUcav_5162bab4_b936", "Block")        
                        .addChild("content",
                            new org.instantlogic.interaction.page.IfElseElement(createDeduction1(),
                                    new org.instantlogic.interaction.page.FragmentTemplate("_yquqvyviy_twhnp_01e2e3bb_b692", "Block")        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("PpAEhgqlcm_vkooo_204c1fa7_26d3", "Block")      
                                                .setStyleNames(new String[]{"editor", "popover", "top"})        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("OuzbhyIvhmcde_qw_21183d4e_3acf", "Block")      
                                                        .setStyleNames(new String[]{"arrow"})        
                                                )        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("GvUdrtmgqIfqickl_c5102798_bc09", "Input")      
                                                        .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type)        
                                                )        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.IfElseElement(createDeduction2(),
                                                            new org.instantlogic.interaction.page.FragmentTemplate("Wcysr_sUay_cAnaq_8a7d79f0_ffbd", "Block")        
                                                                .addChild("content",
                                                                    new org.instantlogic.interaction.page.FragmentTemplate("Hzotrdlftigwwdwr_25336040_88a3", "Input")      
                                                                        .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.entity)        
                                                                )        
                                                                .addChild("content",
                                                                    new org.instantlogic.interaction.page.IfElseElement(createDeduction3(),
                                                                            new org.instantlogic.interaction.page.FragmentTemplate("RauwkgzIgm_hqaqt_7b46689a_17c2", "Block")        
                                                                                .addChild("content",
                                                                                    new org.instantlogic.interaction.page.FragmentTemplate("BlqIUbwewqbgqfke_fe84d0ad_eca2", "Input")      
                                                                                        .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.attribute)        
                                                                                )        
                                                                                .addChild("content",
                                                                                    new org.instantlogic.interaction.page.FragmentTemplate("QAbuOuyIzafuegUu_1e105895_3c3c", "Button")      
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
                            new org.instantlogic.interaction.page.FragmentTemplate("TEElusetpIghUamb_3407e530_4826", "Block")      
                                .setStyleNames(new String[]{"collapsable-content"})        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("Nttneoqthe_ucjyy_51a8bf1a_2c3a", "Link")      
                                        .setStyleNames(new String[]{"collapse-button"})        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("GlaOAxnzliglagIb_3b134884_5905", "Icon")      
                                                .setStyleNames(new String[]{"icon-chevron-down"})        
                                        )        
                                )        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("Ahouci_wqycauhjt_2e44c8b0_c790", "PreviewLine")      
                                        .putValue("previewMode", createDeduction6())        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("BOAEi_rbuegricwn_c59b2c5b_2232", "Strong")      
                                                .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction4()).getTextTemplate())        
                                        )        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("_hocfnzolefkijco_ab3765f5_4596", "Block")      
                                                .setStyleNames(new String[]{"btn-group", "element-edit-options"})        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.IfElseElement(createDeduction5(),
                                                            new org.instantlogic.interaction.page.FragmentTemplate("NvkkmUhIfafdcnf_93d57312_14d2", "Button")      
                                                                .setStyleNames(new String[]{"active", "btn-small"})      
                                                                .setEvent(org.instantlogic.designer.event.CloseEditorEvent.INSTANCE)        
                                                                .addChild("content",
                                                                    new org.instantlogic.interaction.page.FragmentTemplate("IsehmtaEmeanc_tz_c8f372b4_d56e", "Icon")      
                                                                        .setStyleNames(new String[]{"icon-pencil"})        
                                                                ),
                                                            new org.instantlogic.interaction.page.FragmentTemplate("WIvnfgluImdOUogp_eccce2fb_dfa7", "Button")      
                                                                .setStyleNames(new String[]{"btn-small"})      
                                                                .setEvent(org.instantlogic.designer.event.OpenEditorEvent.INSTANCE)        
                                                                .addChild("content",
                                                                    new org.instantlogic.interaction.page.FragmentTemplate("XAvrwttuhIbiajAl_fb6ea88e_1887", "Icon")      
                                                                        .setStyleNames(new String[]{"icon-pencil"})        
                                                                ))
        
                                                )        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("Xnidwpalxecrsjyr_755b5818_c8d9", "Button")      
                                                        .setStyleNames(new String[]{"btn-small", "btn-success"})      
                                                        .setEvent(org.instantlogic.designer.event.InsertFragmentTemplateBelowEvent.INSTANCE)        
                                                        .addChild("content",
                                                            new org.instantlogic.interaction.page.FragmentTemplate("AUdOemzzkyeOkniw_0fabf589_0a8a", "Icon")      
                                                                .setStyleNames(new String[]{"icon-hand-down"})        
                                                        )        
                                                )        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("PwewEuphpygaqnwu_be2ead04_99cb", "Button")      
                                                        .setStyleNames(new String[]{"btn-danger", "btn-small"})      
                                                        .setEvent(org.instantlogic.designer.event.RemoveFragmentTemplateEvent.INSTANCE)        
                                                        .addChild("content",
                                                            new org.instantlogic.interaction.page.FragmentTemplate("UzOIlIsovaaqUfIA_d278639c_1f2a", "Icon")      
                                                                .setStyleNames(new String[]{"icon-remove"})        
                                                        )        
                                                )        
                                        )        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("KEyppkphiI_Ombxv_bde0542c_d886", "Preview")        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("GcwdakeIUq_dihEc_6628387c_d0f5", "PreviewPlaceholder")      
                                                        .addCustomFilter(new org.instantlogic.designer.fragmentfilter.PreviewFragmentFilter())        
                                                )        
                                        )        
                                )        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.SelectionElement(createDeduction7(),
                                            new org.instantlogic.interaction.page.SelectionElement(createDeduction8(),
                                                        new org.instantlogic.interaction.page.SharedElementHolder("Qnmkpqjffaggskyd_09d4ee56_5795", org.instantlogic.designer.sharedpagefragment.ElementEditorPageFragment.INSTANCE)
)
)
        
                                )        
                        ))
        
        )        
        .addChild("content",
            new org.instantlogic.interaction.page.SelectionElement(createDeduction9(),
                    new org.instantlogic.interaction.page.FragmentTemplate("Uenxxcfwjqcuqetn_d593e303_6780", "Block")      
                        .setStyleNames(new String[]{"collapsable-content"})        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("Tmwefbpn_eeoikjx_98a51663_05d6", "Link")      
                                .setStyleNames(new String[]{"collapse-button"})        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("epxchqkufedrAirb_031a4e05_0bd3", "Icon")      
                                        .setStyleNames(new String[]{"icon-chevron-down"})        
                                )        
                        )        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("Tqmwawitjqgvga_v_32722d6e_34a8", "PreviewLine")      
                                .putValue("previewMode", createDeduction10())        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("QaanhkxIoubwcdtU_08d28da6_ef0c", "Strong")      
                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("[IfElse]").getTextTemplate())        
                                )        
                        ))
        
        )        
        .addChild("content",
            new org.instantlogic.interaction.page.SelectionElement(createDeduction11(),
                    new org.instantlogic.interaction.page.FragmentTemplate("FwwmqOmbOqdkocwt_8b4dbfda_857d", "Block")      
                        .setStyleNames(new String[]{"collapsable-content"})        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("OmE_bzhAbI_nkmsI_8598bc15_7c1e", "Link")      
                                .setStyleNames(new String[]{"collapse-button"})        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("RhEvuwIOUaddU_lq_3ad59c7b_eed2", "Icon")      
                                        .setStyleNames(new String[]{"icon-chevron-down"})        
                                )        
                        )        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("WvEynEvnte_Uamas_17549920_402d", "PreviewLine")      
                                .putValue("previewMode", createDeduction12())        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("NyvztckknueEmdsk_92b87b3b_4517", "Strong")      
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
