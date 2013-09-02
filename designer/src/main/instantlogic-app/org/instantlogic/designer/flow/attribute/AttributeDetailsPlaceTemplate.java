package org.instantlogic.designer.flow.attribute;

public class AttributeDetailsPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final AttributeDetailsPlaceTemplate INSTANCE = new AttributeDetailsPlaceTemplate();

	@Override
	public String getId() {
		return "aEdkdtefoIbigcof_3c65cabc_1542";
	}
	

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.ReverseRelationDeduction d0 = new org.instantlogic.fabric.deduction.ReverseRelationDeduction();
		    d0.setRelation(org.instantlogic.designer.entity.EntityDesignEntity.attributes);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE);
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
		    d0.setAttribute(org.instantlogic.designer.entity.AttributeDesignEntity.dataType);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction3() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.AttributeDesignEntity.rule);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction4() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.AttributeDesignEntity._default);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction5() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DesignEntity.name);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("ZyOtjjbsUIgfA_ik_0ab04747_9636", "Page")        
            .addChild("mainContent",
                new org.instantlogic.interaction.page.SelectionElement(createDeduction0(),
                            new org.instantlogic.interaction.page.SharedElementHolder("itusknoUEigeqjil_033c859e_b305", org.instantlogic.designer.sharedpagefragment.EntityContextPageFragment.INSTANCE)
)
        
            )        
            .addChild("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("YedjdboaIeamwgjj_3c861348_79c5", "Block")      
                    .setStyleNames(new String[]{"card"})        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("ugOfEbsooeaoobeq_c9a5e837_a971", "Heading3")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction1()).add(" (Attribute)").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("VszcaUkcqybbihlg_98975cde_f6d6", "Button")      
                            .setStyleNames(new String[]{"btn"})      
                            .setEvent(org.instantlogic.designer.event.DataEvent.INSTANCE)      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Data").getTextTemplate())        
                            .addChild("content",
                                new org.instantlogic.interaction.page.FragmentTemplate("Gdfoffnraigmmngl_cc19b29e_83e9", "Icon")      
                                    .setStyleNames(new String[]{"icon-wrench"})        
                            )        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("Yzkpqlnbzygtslag_5f3a1cca_fc90", "Button")      
                            .setStyleNames(new String[]{"btn"})      
                            .setEvent(org.instantlogic.designer.event.RemoveAttributeEvent.INSTANCE)      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Delete").getTextTemplate())        
                            .addChild("content",
                                new org.instantlogic.interaction.page.FragmentTemplate("ibUfvzI_yqcygddO_726a4a5b_080f", "Icon")      
                                    .setStyleNames(new String[]{"icon-remove"})        
                            )        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("Mlreyyxtvqgmgldl_f80f2d4b_84ac", "Input")      
                            .setField(org.instantlogic.designer.entity.DesignEntity.INSTANCE, org.instantlogic.designer.entity.DesignEntity.name)        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("otwkphaitmceabsE_5c758e16_c5b3", "Heading4")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Data type").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction2(),
                                new org.instantlogic.interaction.page.FragmentTemplate("_ddUnidpvefuydxd_f0ce8f98_d1f4", "Block")        
                                    .addChild("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("awIiIAoIqebEu_xm_94a08ade_ab5d", "Input")      
                                            .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.dataCategory)        
                                    )        
                                    .addChild("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("Qajxvzrnxecuchcg_cca19502_c6a1", "Input")      
                                            .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.multiLine)        
                                    )        
                                    .addChild("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("awwgdjmrzIcIejfc_746a07c3_a5f3", "Input")      
                                            .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.formatted)        
                                    )        
                                    .addChild("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("Enj_jrmyyi_iUdmx_52bed1e4_977b", "Input")      
                                            .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.percentage)        
                                    )        
                                    .addChild("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("eUylkopwxmewIhto_f72ca3cb_17c8", "Input")      
                                            .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.wholeNumber)        
                                    )        
                                    .addChild("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("Eawudwevne_dkogk_b67c8ace_50d1", "Input")      
                                            .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.exactRounding)        
                                    ))
        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("oAoOb_qrdycAaevi_be71bba9_4b56", "Heading4")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Value").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("WUxftdxIbe_jqepd_b712397d_608e", "Input")      
                            .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.hasRelevance)        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("Yojohodzkudtwnzy_5e7fe5be_c53b", "Input")      
                            .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.hasRule)        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction3(),
                                new org.instantlogic.interaction.page.FragmentTemplate("WmeOjAlEymetAjaO_f44c457e_ee26", "Button")      
                                    .setStyleNames(new String[]{"btn"})      
                                    .setEvent(org.instantlogic.designer.event.DeductionSchemeDetailsEvent.INSTANCE)      
                                    .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Deduction scheme").getTextTemplate()))
        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("ZyrknA_pcufcogrc_946eba2c_fb26", "Input")      
                            .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.writeable)        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("WgcOlgwOzqcbuk_a5504df9_e068", "Input")      
                            .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.hasDefault)        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction4(),
                                new org.instantlogic.interaction.page.FragmentTemplate("UlvkIs_jaqfdamcA_3afc8d89_9993", "Button")      
                                    .setStyleNames(new String[]{"btn"})      
                                    .setEvent(org.instantlogic.designer.event.DeductionSchemeDetailsEvent.INSTANCE)      
                                    .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Deduction scheme").getTextTemplate()))
        
                    )        
            ); 
	
	private static final org.instantlogic.fabric.text.TextTemplate TITLE = new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction5()).add(" (Attribute)").getTextTemplate();
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
        return "AttributeDetails";
    }
}