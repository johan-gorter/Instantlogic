package org.instantlogic.designer.sharedpagefragment;

public class ApplicationContextPageFragment extends org.instantlogic.interaction.page.SharedElement {
	
	public static ApplicationContextPageFragment INSTANCE = new ApplicationContextPageFragment();
	

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.ApplicationDesignEntity.name);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}

	
	public static final org.instantlogic.interaction.page.Element SHARED_INSTANCE = 
    new org.instantlogic.interaction.page.FragmentTemplate("Gaxjwbfcemdygmjg_51b374b9_f337", "Link")      
        .setEvent(org.instantlogic.designer.event.HomeEvent.INSTANCE)        
        .addChild("content",
            new org.instantlogic.interaction.page.FragmentTemplate("ZnAylvaEnifOwcbA_c6311aa6_8c49", "Block")      
                .setStyleNames(new String[]{"inactive-card"})        
                .addChild("content",
                    new org.instantlogic.interaction.page.FragmentTemplate("FyunsfkIUmgtwfoh_6cab8270_4339", "Heading3")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction0()).add(" (Application)").getTextTemplate())        
                )        
        ); 

	protected ApplicationContextPageFragment() {
	    INSTANCE=this;
	}
	
	static {
	    INSTANCE.setElement(SHARED_INSTANCE);
	}
	
}
