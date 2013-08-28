package org.instantlogic.designer.flow.placetemplate;

public class PlaceTemplateDetailsPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final PlaceTemplateDetailsPlaceTemplate INSTANCE = new PlaceTemplateDetailsPlaceTemplate();

	@Override
	public String getId() {
		return "YAilyxIhdmbmyiwc_383167ef_0190";
	}
	

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.ReverseRelationDeduction d0 = new org.instantlogic.fabric.deduction.ReverseRelationDeduction();
		    d0.setRelation(org.instantlogic.designer.entity.FlowDesignEntity.nodes);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE);
		    d0.setToInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DesignEntity.name);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction2() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.content);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction3() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DesignEntity.name);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("Eje_ayqjOy_Isacn_130995b6_d333", "Page")        
            .addChild("mainContent",
                new org.instantlogic.interaction.page.SelectionElement(createDeduction0(),
                            new org.instantlogic.interaction.page.SharedElementHolder("FdjdapszvqaOobiU_9111d513_a726", org.instantlogic.designer.sharedpagefragment.FlowContextPageFragment.INSTANCE)
)
        
            )        
            .addChild("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("XIdttfuqwybdkakz_a61e9b6e_5cd8", "Block")      
                    .setStyleNames(new String[]{"card"})        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("MrrgmAczAeevommv_8fad2151_b6a9", "Heading3")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction1()).add(" (Place template)").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("DOon_lr_Oaffolhh_21774215_540b", "Input")      
                            .setField(org.instantlogic.designer.entity.DesignEntity.INSTANCE, org.instantlogic.designer.entity.DesignEntity.name)        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("ooUcpmqdbyebcmxn_30744a2d_bfd7", "Heading4")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Content").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction2(),
                                new org.instantlogic.interaction.page.FragmentTemplate("FEmjmetfAucoAeph_6f2a1e95_ee2b", "ElementEditor")        
                                    .addChild("content",
                                            new org.instantlogic.interaction.page.SharedElementHolder("TnsaIreAAebxoaxh_d74fd22d_d256", org.instantlogic.designer.sharedpagefragment.ElementEditorPageFragment.INSTANCE)
        
                                    ))
        
                    )        
            ); 
	
	private static final org.instantlogic.fabric.text.TextTemplate TITLE = new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction3()).add(" (Place)").getTextTemplate();
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
        return "PlaceTemplateDetails";
    }
}