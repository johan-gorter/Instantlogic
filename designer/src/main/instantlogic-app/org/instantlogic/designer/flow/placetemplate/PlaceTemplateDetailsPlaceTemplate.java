package org.instantlogic.designer.flow.placetemplate;

public class PlaceTemplateDetailsPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final PlaceTemplateDetailsPlaceTemplate INSTANCE = new PlaceTemplateDetailsPlaceTemplate();

	@Override
	public String getId() {
		return "axcvttEIfedoInEy_82259119_f1d6";
	}
	

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DesignEntity.name);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.content);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction2() {
		  	org.instantlogic.fabric.deduction.ReverseRelationDeduction d0 = new org.instantlogic.fabric.deduction.ReverseRelationDeduction();
		    d0.setRelation(org.instantlogic.designer.entity.FlowDesignEntity.nodes);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE);
		    d0.setToInstance(d1);
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
        new org.instantlogic.interaction.page.FragmentTemplate("NldOaltvnIgIclab_978e8c8c_9c84", "Page")        
            .addChild("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("DnnEurndgigpylvf_458d0b4a_e131", "Block")      
                    .setStyleNames(new String[]{"card"})        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("Ec_UwilIhmdhaakq_7c2600e2_15f2", "Heading3")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction0()).add(" (Place template)").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("UUjpuzciiq_yiblI_37f6b9d3_6168", "Input")      
                            .setField(org.instantlogic.designer.entity.DesignEntity.INSTANCE, org.instantlogic.designer.entity.DesignEntity.name)        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("VOorxUknxiagalas_029b045d_7e88", "Heading4")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Content").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction1(),
                                new org.instantlogic.interaction.page.FragmentTemplate("TmypvlIjxub_cknu_4468f06c_37fb", "ElementEditor")        
                                    .addChild("content",
                                            new org.instantlogic.interaction.page.SharedElementHolder("W_uhfqnAhycas_jk_6f91241d_a7ea", org.instantlogic.designer.sharedpagefragment.ElementEditorPageFragment.INSTANCE)
        
                                    ))
        
                    )        
            )        
            .addChild("mainContent",
                new org.instantlogic.interaction.page.SelectionElement(createDeduction2(),
                            new org.instantlogic.interaction.page.SharedElementHolder("NvIensdxyactakjb_43c57127_255b", org.instantlogic.designer.sharedpagefragment.FlowContextPageFragment.INSTANCE)
)
        
            ); 
	
	private static final org.instantlogic.fabric.text.TextTemplate TITLE = new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(" (Place)").add(createDeduction3()).getTextTemplate();
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