package org.instantlogic.designer.flow.flow;


public class FlowDetailsPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final FlowDetailsPlaceTemplate INSTANCE = new FlowDetailsPlaceTemplate();

	@Override
	public String getId() {
		return "K_AEnhbalygjmklk_bf7183e3_b2cb";
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
        new org.instantlogic.interaction.page.FragmentTemplate("VUnpxplUxIdvqneq_7733dc11_3d6e", "Page")        
            .addChild("mainContent",
                    new org.instantlogic.interaction.page.SharedElementHolder("JsnrqldbnqfiueIO_a2406baa_4a74", org.instantlogic.designer.sharedpagefragment.ApplicationContextPageFragment.INSTANCE)
        
            )        
            .addChild("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("ZkmvenAIlIghAhqt_540f2226_f898", "Block")      
                    .setStyleNames(new String[]{"card"})        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("WnxpmzmxcubecnUq_02835900_2bf9", "Heading3")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction0()).add(" (Flow)").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("DqvkmqjhcqeEebaq_4a3e3c58_a6be", "Input")      
                            .setField(org.instantlogic.designer.entity.DesignEntity.INSTANCE, org.instantlogic.designer.entity.DesignEntity.name)        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("_AdoumoOEqcqcbxu_a29cc835_a319", "Heading4")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Nodes").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction1(),
                                new org.instantlogic.interaction.page.FragmentTemplate("JxwtslUOyicUuoge_3976f6b5_97e3", "Link")      
                                    .setEvent(org.instantlogic.designer.event.FlowNodeDetailsEvent.INSTANCE)        
                                    .addChild("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("BxxmkeisqaemUfal_a052e20b_5529", "Block")        
                                            .addChild("content",
                                                new org.instantlogic.interaction.page.FragmentTemplate("QexxxdnhdycIkjvA_338b62e6_e1c0", "Strong")      
                                                    .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction2()).getTextTemplate())        
                                            )        
                                    ))
        
                    )        
            );
	
	private static final org.instantlogic.fabric.text.TextTemplate TITLE = new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction3()).add(" (Flow)").getTextTemplate();
	@Override
	protected org.instantlogic.fabric.text.TextTemplate getTitle() {
		return TITLE;
	}
	
	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
	};

	@Override
	public org.instantlogic.fabric.model.Entity[] getParameters() {
		return PARAMETERS;
	}
	
	@Override
	public org.instantlogic.interaction.page.FragmentTemplate getRootContainer() {
		return CONTENT;
	}; 
	
    @Override
    public String getName() {
        return "FlowDetails";
    }
	
    @Override
    public String getTechnicalName() {
        return "FlowDetails";
    }
}