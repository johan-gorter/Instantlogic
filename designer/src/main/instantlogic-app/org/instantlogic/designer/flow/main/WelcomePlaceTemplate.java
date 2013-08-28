package org.instantlogic.designer.flow.main;

public class WelcomePlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final WelcomePlaceTemplate INSTANCE = new WelcomePlaceTemplate();

	@Override
	public String getId() {
		return "otzOpAyuzq_AAitw_c691f9d5_033d";
	}
	

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.designer.deduction.CapitalizeFirstDeduction d0 = new org.instantlogic.designer.deduction.CapitalizeFirstDeduction();
		  	org.instantlogic.fabric.deduction.AttributeDeduction d1 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d1.setAttribute(org.instantlogic.designer.entity.ApplicationDesignEntity.name);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d2 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d2.setOfEntity(org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE);
		    d0.setInput(d1);
		    d1.setInstance(d2);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.ApplicationDesignEntity.entities);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction2() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DesignEntity.name);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction3() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.ApplicationDesignEntity.flows);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction4() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DesignEntity.name);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("Rievamhggqe_qcA_cd41dfc6_5607", "Page")        
            .addChild("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("Lafgx_eavqdimeUO_cd98fdf3_97b2", "Block")      
                    .setStyleNames(new String[]{"card"})        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("RAdOobhluycmwasg_70a55636_9608", "Heading3")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction0()).add(" (Application)").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("YxsAxniaoqfdcktd_4d50c9c1_903b", "Paragraph")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Welcome to the Designer").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("MsihtfscOaeyim_v_5dd308fd_6547", "Table")        
                            .addChild("columns",
                                new org.instantlogic.interaction.page.FragmentTemplate("FyunzlkUUIafqcab_d7276601_a528", "Column")      
                                    .putText("header", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Entities").getTextTemplate())        
                            )        
                            .addChild("rows",
                                new org.instantlogic.interaction.page.SelectionElement(createDeduction1(),
                                        new org.instantlogic.interaction.page.FragmentTemplate("Iy_u_khwUqdOsgz_a078f9b7_e218", "Row")        
                                            .addChild("cells",
                                                new org.instantlogic.interaction.page.FragmentTemplate("Ocpqywialubfy__z_cb8aec76_b20a", "Cell")        
                                                    .addChild("content",
                                                        new org.instantlogic.interaction.page.FragmentTemplate("aakjOjOi_iexmcrE_77f50174_61c0", "Link")      
                                                            .setEvent(org.instantlogic.designer.event.EntityDetailsEvent.INSTANCE)      
                                                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction2()).getTextTemplate())        
                                                    )        
                                            ))
        
                            )        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("NIyulroUgueucmua_5b68fb9e_374c", "Button")      
                            .setEvent(org.instantlogic.designer.event.AddEntityEvent.INSTANCE)      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Add entity").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("Bsymqigqgycemokj_65d6c0fc_e972", "Table")        
                            .addChild("columns",
                                new org.instantlogic.interaction.page.FragmentTemplate("MIwwih_zbIg_Aear_2e0218b1_2524", "Column")      
                                    .putText("header", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Flows").getTextTemplate())        
                            )        
                            .addChild("rows",
                                new org.instantlogic.interaction.page.SelectionElement(createDeduction3(),
                                        new org.instantlogic.interaction.page.FragmentTemplate("HewAwafteaccsdsn_b715da80_4476", "Row")        
                                            .addChild("cells",
                                                new org.instantlogic.interaction.page.FragmentTemplate("DbEnnhimce_uUnOI_e3938f06_a6a7", "Cell")        
                                                    .addChild("content",
                                                        new org.instantlogic.interaction.page.FragmentTemplate("CsylApIrruatelu_4b3f8403_b6f8", "Link")      
                                                            .setEvent(org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE)      
                                                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction4()).getTextTemplate())        
                                                    )        
                                            ))
        
                            )        
                    )        
            ); 
	
	private static final org.instantlogic.fabric.text.TextTemplate TITLE = new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Welcome").getTextTemplate();
	@Override
	protected org.instantlogic.fabric.text.TextTemplate getTitle() {
		return TITLE;
	}
	
	@Override
	public org.instantlogic.interaction.page.FragmentTemplate getRootContainer() {
		return CONTENT;
	}; 
	
    @Override
    public String getName() {
        return "Welcome";
    }
}