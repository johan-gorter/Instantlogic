package org.instantlogic.designer.sharedpagefragment;

public class FlowContextPageFragment extends org.instantlogic.interaction.page.SharedElement {
	
	public static FlowContextPageFragment INSTANCE = new FlowContextPageFragment();
	

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DesignEntity.name);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}

	
	public static final org.instantlogic.interaction.page.Element SHARED_INSTANCE = 
    new org.instantlogic.interaction.page.FragmentTemplate("VezsOtsqqqgpsghw_82226ec0_e6bb", "Group")        
        .addChild("content",
                new org.instantlogic.interaction.page.SharedElementHolder("OgxtivvxAueIecrv_d01ee4d1_f76c", org.instantlogic.designer.sharedpagefragment.ApplicationContextPageFragment.INSTANCE)
        
        )        
        .addChild("content",
            new org.instantlogic.interaction.page.FragmentTemplate("BpEofdkAzadpshmv_7a49d8d1_3225", "Link")      
                .setEvent(org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE)        
                .addChild("content",
                    new org.instantlogic.interaction.page.FragmentTemplate("Nfkhpjf_pa_sqiux_3cb4d783_80ea", "Block")      
                        .setStyleNames(new String[]{"inactive-card"})        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("errcefqjimbzejIc_d0e730b9_f9ff", "Heading3")      
                                .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction0()).add(" (Flow)").getTextTemplate())        
                        )        
                )        
        ); 

	protected FlowContextPageFragment() {
	    INSTANCE=this;
	}
	
	static {
	    INSTANCE.setElement(SHARED_INSTANCE);
	}
	
}
