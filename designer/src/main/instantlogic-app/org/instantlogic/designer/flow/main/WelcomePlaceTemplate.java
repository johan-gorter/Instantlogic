package org.instantlogic.designer.flow.main;

public class WelcomePlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final WelcomePlaceTemplate INSTANCE = new WelcomePlaceTemplate();

	@Override
	public String getId() {
		return "ZEkgbqiwcIc_kdUp_3944acd7_9958";
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
        new org.instantlogic.interaction.page.FragmentTemplate("U_Ubdhdcyi_ykmjs_335927e8_0d56", "Page")        
            .addChild("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("Tjsvjenopi_gkhbE_53746dd7_1b6d", "Block")      
                    .setStyleNames(new String[]{"card"})        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("HhlOx_byqqghsesn_8b371a00_5803", "Heading3")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction0()).add(" (Application)").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("CEyAnEnsOeeIUopi_a0dd5d43_94aa", "Paragraph")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Welcome to the Designer").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("Raswvrtaxiats_di_01220855_baae", "Table")        
                            .addChild("columns",
                                new org.instantlogic.interaction.page.FragmentTemplate("aojdeorwiyekmjEk_1eb55236_48bb", "Column")      
                                    .putText("header", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Entities").getTextTemplate())        
                            )        
                            .addChild("rows",
                                new org.instantlogic.interaction.page.SelectionElement(createDeduction1(),
                                        new org.instantlogic.interaction.page.FragmentTemplate("HbdgAthyqydjackh_3bada788_7b57", "Row")        
                                            .addChild("cells",
                                                new org.instantlogic.interaction.page.FragmentTemplate("Url_lkindaedg_jb_8ec78c9f_4308", "Cell")        
                                                    .addChild("content",
                                                        new org.instantlogic.interaction.page.FragmentTemplate("R_IsUjivtIfbm_rE_a4d044d0_faea", "Link")      
                                                            .setEvent(org.instantlogic.designer.event.EntityDetailsEvent.INSTANCE)      
                                                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction2()).getTextTemplate())        
                                                    )        
                                            ))
        
                            )        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("Owniqsgetaevwmov_4dad14e0_d4ea", "Button")      
                            .setEvent(org.instantlogic.designer.event.AddEntityEvent.INSTANCE)      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Add entity").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("ukAObnelaecUefUw_4a1c0cfb_122d", "Table")        
                            .addChild("columns",
                                new org.instantlogic.interaction.page.FragmentTemplate("ChuqnUfjnufhsbzp_d9fc69b4_f9fc", "Column")      
                                    .putText("header", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Flows").getTextTemplate())        
                            )        
                            .addChild("rows",
                                new org.instantlogic.interaction.page.SelectionElement(createDeduction3(),
                                        new org.instantlogic.interaction.page.FragmentTemplate("LIEethqfcudlAbfr_b6107a90_b068", "Row")        
                                            .addChild("cells",
                                                new org.instantlogic.interaction.page.FragmentTemplate("MOpedeugqqbdg_jf_71d1e2e2_736b", "Cell")        
                                                    .addChild("content",
                                                        new org.instantlogic.interaction.page.FragmentTemplate("XwyAkriIEIggunwx_ce5759ca_93ba", "Link")      
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