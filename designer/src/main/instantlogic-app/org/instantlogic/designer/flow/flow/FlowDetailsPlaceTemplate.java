package org.instantlogic.designer.flow.flow;

public class FlowDetailsPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final FlowDetailsPlaceTemplate INSTANCE = new FlowDetailsPlaceTemplate();

	@Override
	public String getId() {
		return "EkcqiAlOOyefmjxg_14ee1a13_3a5f";
	}
	

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.designer.deduction.CapitalizeFirstDeduction d0 = new org.instantlogic.designer.deduction.CapitalizeFirstDeduction();
		  	org.instantlogic.fabric.deduction.AttributeDeduction d1 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d1.setAttribute(org.instantlogic.designer.entity.DesignEntity.name);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d2 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d2.setOfEntity(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		    d0.setInput(d1);
		    d1.setInstance(d2);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.FlowDesignEntity.nodes);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction2() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DesignEntity.name);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction3() {
		  	org.instantlogic.designer.deduction.CapitalizeFirstDeduction d0 = new org.instantlogic.designer.deduction.CapitalizeFirstDeduction();
		  	org.instantlogic.fabric.deduction.AttributeDeduction d1 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d1.setAttribute(org.instantlogic.designer.entity.DesignEntity.name);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d2 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d2.setOfEntity(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		    d0.setInput(d1);
		    d1.setInstance(d2);
		return d0;
	}

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("KeesogtuAy_yIhlw_0e5f2bf5_7a7a", "Page")        
            .addChild("mainContent",
                    new org.instantlogic.interaction.page.SharedElementHolder("IoadUztwvygdkogj_36de0cc6_866a", org.instantlogic.designer.sharedpagefragment.ApplicationContextPageFragment.INSTANCE)
        
            )        
            .addChild("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("_z_uzrgyxafkmaqr_d0e636bf_cefb", "Block")      
                    .setStyleNames(new String[]{"card"})        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("HAoymwwvomahkdlI_42dd8373_845d", "Heading3")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(" (Flow)").add(createDeduction0()).getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction1(),
                                new org.instantlogic.interaction.page.FragmentTemplate("HlIIyzEtOmeumlso_55c2d9ad_4a7f", "Link")      
                                    .setEvent(org.instantlogic.designer.event.FlowNodeDetailsEvent.INSTANCE)        
                                    .addChild("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("WUafdqEvfqddIdmi_b80f105e_86d9", "Block")        
                                            .addChild("content",
                                                new org.instantlogic.interaction.page.FragmentTemplate("ucmjibaenmgmeiwy_a9bdc52c_6070", "Strong")      
                                                    .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction2()).getTextTemplate())        
                                            )        
                                    ))
        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("PwnAipzIpegxynou_139f1008_eb32", "Heading4")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Nodes").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("Pyvchk_Eci_oUnrr_43812e86_6414", "Input")      
                            .setField(org.instantlogic.designer.entity.DesignEntity.INSTANCE, org.instantlogic.designer.entity.DesignEntity.name)        
                    )        
            ); 
	
	private static final org.instantlogic.fabric.text.TextTemplate TITLE = new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(" (Flow)").add(createDeduction3()).getTextTemplate();
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
        return "FlowDetails";
    }
}