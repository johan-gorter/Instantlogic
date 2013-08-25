package org.instantlogic.designer.flow.main;

public class WelcomePlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final WelcomePlaceTemplate INSTANCE = new WelcomePlaceTemplate();

	@Override
	public String getId() {
		return "PoxIhaiyzIfwimed_da0ad89d_8903";
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
        new org.instantlogic.interaction.page.FragmentTemplate("RItUsoyUwqcqUfix_10bf25e4_519c", "Page")        
            .addChild("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("RcehwIgkjqerce_r_c0a83bd8_94f7", "Block")      
                    .setStyleNames(new String[]{"card"})        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("DhpkggamAaewqbor_231420ea_643d", "Heading3")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction0()).add(" (Application)").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("IbjwuhibiygIsmzw_91b34a32_ad7d", "Paragraph")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Welcome to the Designer").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("Drfjgov__ibvyecj_3e33d609_7290", "Table")        
                            .addChild("columns",
                                new org.instantlogic.interaction.page.FragmentTemplate("uxoIpdtvsufiocue_03c08103_2936", "Column")      
                                    .putText("header", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Entities").getTextTemplate())        
                            )        
                            .addChild("rows",
                                new org.instantlogic.interaction.page.SelectionElement(createDeduction1(),
                                        new org.instantlogic.interaction.page.FragmentTemplate("Kw_dAzqermcimgoc_38104e16_e15b", "Row")        
                                            .addChild("cells",
                                                new org.instantlogic.interaction.page.FragmentTemplate("Abkhepfpzmgrkkd_22208344_9b62", "Cell")        
                                                    .addChild("content",
                                                        new org.instantlogic.interaction.page.FragmentTemplate("_OiUc_zyAednoern_29e0d109_d86b", "Link")      
                                                            .setEvent(org.instantlogic.designer.event.EntityDetailsEvent.INSTANCE)      
                                                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction2()).getTextTemplate())        
                                                    )        
                                            ))
        
                            )        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("VUmUhtuftIcrwif_bab4bd72_3bdb", "Button")      
                            .setEvent(org.instantlogic.designer.event.AddEntityEvent.INSTANCE)      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Add entity").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("XEsevbcmaIfxUjOd_fab0890a_b04b", "Table")        
                            .addChild("columns",
                                new org.instantlogic.interaction.page.FragmentTemplate("FvowUdxAEecighzt_9e2c77eb_cef7", "Column")      
                                    .putText("header", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Flows").getTextTemplate())        
                            )        
                            .addChild("rows",
                                new org.instantlogic.interaction.page.SelectionElement(createDeduction3(),
                                        new org.instantlogic.interaction.page.FragmentTemplate("EzhxqsAgxidwwhbm_a527667c_0f5b", "Row")        
                                            .addChild("cells",
                                                new org.instantlogic.interaction.page.FragmentTemplate("PazrUU_Imq_rsml_fc63616c_00ca", "Cell")        
                                                    .addChild("content",
                                                        new org.instantlogic.interaction.page.FragmentTemplate("Piwfycqvwm_age_p_f061cf45_295a", "Link")      
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