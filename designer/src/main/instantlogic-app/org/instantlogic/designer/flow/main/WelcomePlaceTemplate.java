package org.instantlogic.designer.flow.main;

public class WelcomePlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final WelcomePlaceTemplate INSTANCE = new WelcomePlaceTemplate();

	@Override
	public String getId() {
		return "DpUOEmhkgIcyUjgo_dec63ef2_1b7b";
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
        new org.instantlogic.interaction.page.FragmentTemplate("NrAwzqoUAibecnzE_78b314eb_ad7c", "Page")        
            .addChild("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("VIUamiyjhufAobwd_f7ded372_853c", "Block")      
                    .setStyleNames(new String[]{"card"})        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("Jmagbwxvxycaoodv_11632a5f_866c", "Heading3")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction0()).add(" (Application)").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("Tgchyk_UreanIeit_b147664d_4037", "Paragraph")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Welcome to the Designer").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("Lpmidluhuy_fsfxc_460147a4_3da1", "Table")        
                            .addChild("columns",
                                new org.instantlogic.interaction.page.FragmentTemplate("KfstxUntfiakaaUw_edefc7fc_3baa", "Column")      
                                    .putText("header", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Entities").getTextTemplate())        
                            )        
                            .addChild("rows",
                                new org.instantlogic.interaction.page.SelectionElement(createDeduction1(),
                                        new org.instantlogic.interaction.page.FragmentTemplate("etsEhUjOxafaccrd_2cf4753c_2b82", "Row")        
                                            .addChild("cells",
                                                new org.instantlogic.interaction.page.FragmentTemplate("OEplvyykIiewobxj_36b742b4_3492", "Cell")        
                                                    .addChild("content",
                                                        new org.instantlogic.interaction.page.FragmentTemplate("XhqEizkIpidyumvc_7c360c68_7f30", "Link")      
                                                            .setEvent(org.instantlogic.designer.event.EntityDetailsEvent.INSTANCE)      
                                                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction2()).getTextTemplate())        
                                                    )        
                                            ))
        
                            )        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("Iik_EEcawmffIg_k_a17e502f_28a9", "Button")      
                            .setEvent(org.instantlogic.designer.event.AddEntityEvent.INSTANCE)      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Add entity").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("Evbvceludagpahum_97bdc50e_4585", "Table")        
                            .addChild("columns",
                                new org.instantlogic.interaction.page.FragmentTemplate("GEhhphIwyibrkbky_eb72367a_0c9d", "Column")      
                                    .putText("header", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Flows").getTextTemplate())        
                            )        
                            .addChild("rows",
                                new org.instantlogic.interaction.page.SelectionElement(createDeduction3(),
                                        new org.instantlogic.interaction.page.FragmentTemplate("ZlOdvdppqIcakiIr_ce93765b_eabf", "Row")        
                                            .addChild("cells",
                                                new org.instantlogic.interaction.page.FragmentTemplate("ohbfxAlmvufaqiIb_50d20bd4_be63", "Cell")        
                                                    .addChild("content",
                                                        new org.instantlogic.interaction.page.FragmentTemplate("iUEnxEcjmIaAufds_c3c4291d_f60f", "Link")      
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