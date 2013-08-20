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
    new org.instantlogic.interaction.page.FragmentTemplate("ZjggOedsme_Ucown_e7d11acf_0c39", "Group")        
        .addChild("content",
                new org.instantlogic.interaction.page.SharedElementHolder("QpAkaohfvqfpgfy_c50885a5_8d06", org.instantlogic.designer.sharedpagefragment.ApplicationContextPageFragment.INSTANCE)
        
        )        
        .addChild("content",
            new org.instantlogic.interaction.page.FragmentTemplate("ZuAfxlIraufvyhwE_9b80160d_1497", "Link")      
                .setEvent(org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE)        
                .addChild("content",
                    new org.instantlogic.interaction.page.FragmentTemplate("KcIExt_noucnmgct_c33fa589_b3fc", "Block")      
                        .setStyleNames(new String[]{"inactive-card"})        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("A_bgviA_cubcqelb_3f9c044f_6cf5", "Heading3")      
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
