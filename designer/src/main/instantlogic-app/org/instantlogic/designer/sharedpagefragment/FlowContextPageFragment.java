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
    new org.instantlogic.interaction.page.FragmentTemplate("IE_AuoO_hufvehwx_e1aab8b8_d0a7", "Group")        
        .addChild("content",
                new org.instantlogic.interaction.page.SharedElementHolder("SsctnpUudqdOchxf_cc23ce37_8108", org.instantlogic.designer.sharedpagefragment.ApplicationContextPageFragment.INSTANCE)
        
        )        
        .addChild("content",
            new org.instantlogic.interaction.page.FragmentTemplate("_jeOpcvwwybsoaxe_67ad8af6_3620", "Link")      
                .setEvent(org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE)        
                .addChild("content",
                    new org.instantlogic.interaction.page.FragmentTemplate("TaIhkdswpebAkhvc_146a238a_de68", "Block")      
                        .setStyleNames(new String[]{"inactive-card"})        
                        .addChild("content",
                            new org.instantlogic.interaction.page.FragmentTemplate("RIwskjvnAucasoww_73754399_439c", "Heading3")      
                                .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(" (Flow)").add(createDeduction0()).getTextTemplate())        
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
