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
    new org.instantlogic.interaction.page.FragmentTemplate("ij_cOodtmqcesjwf_62a09656_966b", "Block")      
        .setStyleNames(new String[]{"element"})        
        .addChild("content",
            new org.instantlogic.interaction.page.SelectionElement(createDeduction0(),
                    new org.instantlogic.interaction.page.FragmentTemplate("DdxquUcipIeIuflw_70aa7a57_49ab", "Block")        
                        .addChild("content",
                            new org.instantlogic.interaction.page.IfElseElement(createDeduction1(),
                                    new org.instantlogic.interaction.page.FragmentTemplate("TaauzzbdnubUmolt_1b3fd246_d66f", "Block")        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("eoqtqhujsI_aeeac_683cde8b_f3a2", "Block")      
                                                .setStyleNames(new String[]{"editor", "popover", "top"})        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("QhIfowEoamapukvw_150d009f_f5dd", "Block")      
                                                        .setStyleNames(new String[]{"arrow"})        
                                                )        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("unwAEwOuaucgcoaj_62e98f38_74a5", "Input")      
                                                        .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type)        
                                                )        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.IfElseElement(createDeduction2(),
                                                            new org.instantlogic.interaction.page.FragmentTemplate("DspIfmOq_mgUadpl_3841cca8_8954", "Block")        
                                                                .addChild("content",
                                                                    new org.instantlogic.interaction.page.FragmentTemplate("DkvAIIoEkygfgirx_335c078f_8805", "Input")      
                                                                        .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.entity)        
                                                                )        
                                                                .addChild("content",
                                                                    new org.instantlogic.interaction.page.IfElseElement(createDeduction3(),
                                                                            new org.instantlogic.interaction.page.FragmentTemplate("YUk_xvcwdeaqgffx_5390b22f_52c3", "Block")        
                                                                                .addChild("content",
                                                                                    new org.instantlogic.interaction.page.FragmentTemplate("BzeqadseiyfyAcnz_2a72ac97_92e1", "Input")      
                                                                                        .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.attribute)        
                                                                                )        
                                                                                .addChild("content",
                                                                                    new org.instantlogic.interaction.page.FragmentTemplate("iuIIbo_ohqeiamjb_c6fb9df1_bf14", "Button")      
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
                            new org.instantlogic.interaction.page.FragmentTemplate("Pnyxggnliactgcgd_9fe305db_89d3", "Block")      
                                .setStyleNames(new String[]{"collapsable-content"})        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("LxfrIpOrUablwdlu_b9ce838c_839b", "Link")      
                                        .setStyleNames(new String[]{"collapse-button"})        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("DgpEiewtEmddAfuh_36c8b632_bd6a", "Icon")      
                                                .setStyleNames(new String[]{"icon-chevron-down"})        
                                        )        
                                )        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("VqufhxzwAealyguf_421f32dc_021f", "PreviewLine")      
                                        .putValue("previewMode", createDeduction4())        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("e_mubcImuaf_AoIl_a7124c7c_6c20", "Strong")      
                                                .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction5()).getTextTemplate())        
                                        )        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("irIbjhlOxubrmn_e_98999138_2811", "Block")      
                                                .setStyleNames(new String[]{"btn-group", "element-edit-options"})        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.IfElseElement(createDeduction6(),
                                                            new org.instantlogic.interaction.page.FragmentTemplate("NwwIbm_svIchabwU_e8796eea_b32d", "Button")      
                                                                .setStyleNames(new String[]{"active", "btn-small"})      
                                                                .setEvent(org.instantlogic.designer.event.CloseEditorEvent.INSTANCE)        
                                                                .addChild("content",
                                                                    new org.instantlogic.interaction.page.FragmentTemplate("Injobrc_yuerIhyx_ae021d03_19c8", "Icon")      
                                                                        .setStyleNames(new String[]{"icon-pencil"})        
                                                                ),
                                                            new org.instantlogic.interaction.page.FragmentTemplate("RgpaxldEcmbza__w_6e738592_f5b4", "Button")      
                                                                .setStyleNames(new String[]{"btn-small"})      
                                                                .setEvent(org.instantlogic.designer.event.OpenEditorEvent.INSTANCE)        
                                                                .addChild("content",
                                                                    new org.instantlogic.interaction.page.FragmentTemplate("QjmaknmxoydzAfAw_c6ba499b_db4d", "Icon")      
                                                                        .setStyleNames(new String[]{"icon-pencil"})        
                                                                ))
        
                                                )        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("TulekbjgAactclib_3de9f4cc_73df", "Button")      
                                                        .setStyleNames(new String[]{"btn-small", "btn-success"})      
                                                        .setEvent(org.instantlogic.designer.event.InsertFragmentTemplateBelowEvent.INSTANCE)        
                                                        .addChild("content",
                                                            new org.instantlogic.interaction.page.FragmentTemplate("DrhjswyntI_kyktI_31870fb3_e8eb", "Icon")      
                                                                .setStyleNames(new String[]{"icon-hand-down"})        
                                                        )        
                                                )        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("iUqmEpAbuiedAcyI_658d4e0e_d2eb", "Button")      
                                                        .setStyleNames(new String[]{"btn-danger", "btn-small"})      
                                                        .setEvent(org.instantlogic.designer.event.RemoveFragmentTemplateEvent.INSTANCE)        
                                                        .addChild("content",
                                                            new org.instantlogic.interaction.page.FragmentTemplate("eaqEIceiaaeqUihq_cd254ecb_d363", "Icon")      
                                                                .setStyleNames(new String[]{"icon-remove"})        
                                                        )        
                                                )        
                                        )        
                                        .addChild("content",
                                            new org.instantlogic.interaction.page.FragmentTemplate("OegtdyidUybjmoUj_093f998d_2e45", "Preview")        
                                                .addChild("content",
                                                    new org.instantlogic.interaction.page.FragmentTemplate("umjkEggpnIbtyiIn_ef59b9aa_65c1", "PreviewPlaceholder")      
                                                        .addCustomFilter(new org.instantlogic.designer.fragmentfilter.PreviewFragmentFilter())        
                                                )        
                                        )        
                                )        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.SelectionElement(createDeduction7(),
                                            new org.instantlogic.interaction.page.SelectionElement(createDeduction8(),
                                                        new org.instantlogic.interaction.page.SharedElementHolder("BAbkAtObEi_tkjgz_c1c11a5b_9efd", org.instantlogic.designer.sharedpagefragment.ElementEditorPageFragment.INSTANCE)
)
)
        
                                )        
                        ))
        
        )        
        .addChild("content",
            new org.instantlogic.interaction.page.SelectionElement(createDeduction9(),
                    new org.instantlogic.interaction.page.FragmentTemplate("Rr_m_jtpbmeimfOO_e40f88b2_c7b0", "Block")      
                        .setStyleNames(new String[]{"collapsable-content"})        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("Pasaepojyugvekuw_e6b105ef_828e", "Link")      
                                .setStyleNames(new String[]{"collapse-button"})        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("WzzzOoAmxqeIoean_665ebcea_d063", "Icon")      
                                        .setStyleNames(new String[]{"icon-chevron-down"})        
                                )        
                        )        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("SdoOkbvEnyeAwiOa_5e155644_f3db", "PreviewLine")      
                                .putValue("previewMode", createDeduction10())        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("TUtOmeecEydeakaj_8a5be32a_c7fb", "Strong")      
                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("[IfElse]").getTextTemplate())        
                                )        
                        ))
        
        )        
        .addChild("content",
            new org.instantlogic.interaction.page.SelectionElement(createDeduction11(),
                    new org.instantlogic.interaction.page.FragmentTemplate("OrI_athjrqcicebo_c753307a_e793", "Block")      
                        .setStyleNames(new String[]{"collapsable-content"})        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("TczskxefkudiIevv_6c103fdd_6df6", "Link")      
                                .setStyleNames(new String[]{"collapse-button"})        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("FktkeA_kumbjyjpe_f1550271_2456", "Icon")      
                                        .setStyleNames(new String[]{"icon-chevron-down"})        
                                )        
                        )        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("XiUkwjkhnmbpoo_l_11a17190_7f2b", "PreviewLine")      
                                .putValue("previewMode", createDeduction12())        
                                .addChild("content",
                                    new org.instantlogic.interaction.page.FragmentTemplate("NUqjln_fUuepyox_5d2d1529_57c1", "Strong")      
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
