package org.instantlogic.designer.flow.attribute;

public class AttributeDetailsPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final AttributeDetailsPlaceTemplate INSTANCE = new AttributeDetailsPlaceTemplate();

	@Override
	public String getId() {
		return "elacfrvsqeabojqx_920c4349_5b9d";
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
        new org.instantlogic.interaction.page.FragmentTemplate("eojmjhfEnIbqUjAa_ca72f461_845c", "Page")        
            .addChild("mainContent",
                new org.instantlogic.interaction.page.SelectionElement(createDeduction0(),
                            new org.instantlogic.interaction.page.SharedElementHolder("YgdsdiEpAqequlqm_5980ce87_6800", org.instantlogic.designer.sharedpagefragment.EntityContextPageFragment.INSTANCE)
)
        
            )        
            .addChild("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("Aomtyvsyom_vocnl_310e764c_0cdc", "Block")      
                    .setStyleNames(new String[]{"card"})        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("QkgnvzOdUufEadqq_6fdbe0cd_c54e", "Heading3")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(" (Attribute)").add(createDeduction1()).getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("QiiomdbkAuecsncz_63713495_690f", "Button")      
                            .setStyleNames(new String[]{"btn"})      
                            .setEvent(org.instantlogic.designer.event.DataEvent.INSTANCE)      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Data").getTextTemplate())        
                            .addChild("content",
                                new org.instantlogic.interaction.page.FragmentTemplate("YxmvAcxbtq_hu_ef_355f57ab_cbb3", "Icon")      
                                    .setStyleNames(new String[]{"icon-wrench"})        
                            )        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("DecnjmobEadaA_if_f791d5f2_7d68", "Button")      
                            .setStyleNames(new String[]{"btn"})      
                            .setEvent(org.instantlogic.designer.event.RemoveAttributeEvent.INSTANCE)      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Delete").getTextTemplate())        
                            .addChild("content",
                                new org.instantlogic.interaction.page.FragmentTemplate("ZqUUgEmuiecako_s_6cd7de50_1b5f", "Icon")      
                                    .setStyleNames(new String[]{"icon-remove"})        
                            )        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("ufgpaufOuicma_rn_35a583fd_2717", "Input")      
                            .setField(org.instantlogic.designer.entity.DesignEntity.INSTANCE, org.instantlogic.designer.entity.DesignEntity.name)        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("efEhqylnOIbzib_c_181b7cf6_4995", "Heading4")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Data type").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction2(),
                                new org.instantlogic.interaction.page.FragmentTemplate("GkireOIw_ib_Ieeo_31b6bef1_7934", "Block")        
                                    .addChild("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("RbkgfqkqmufaIktu_837c5ce0_012a", "Input")      
                                            .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.dataCategory)        
                                    )        
                                    .addChild("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("VcijeoyelIemocgU_904cfb4c_78e5", "Input")      
                                            .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.multiLine)        
                                    )        
                                    .addChild("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("Xo_AqkaOqIglwbph_7858d535_51cd", "Input")      
                                            .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.formatted)        
                                    )        
                                    .addChild("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("KnmkEpvdEqcgwesj_3698cee7_cb24", "Input")      
                                            .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.percentage)        
                                    )        
                                    .addChild("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("IqcAdbhrwu_AAoUd_23e32076_449a", "Input")      
                                            .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.wholeNumber)        
                                    )        
                                    .addChild("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("_xxggfdotIaOUecd_4c384c3e_4c05", "Input")      
                                            .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.exactRounding)        
                                    ))
        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("ItdhqnjruadEimaI_77de7888_8047", "Heading4")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Value").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("TwwlocjdnicIakOi_5fe56d5a_1da7", "Input")      
                            .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.hasRelevance)        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("Yptimbdfyi_yglo_aa37f8a2_4e67", "Input")      
                            .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.hasRule)        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction3(),
                                new org.instantlogic.interaction.page.FragmentTemplate("VEpqtOthhieqqhpO_8267f5d4_6c08", "Button")      
                                    .setStyleNames(new String[]{"btn"})      
                                    .setEvent(org.instantlogic.designer.event.DeductionSchemeDetailsEvent.INSTANCE)      
                                    .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Deduction scheme").getTextTemplate()))
        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("KigqIglheieIibjd_cc9e41ef_e080", "Input")      
                            .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.writeable)        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("Aaprdponfy_Aihoz_3b8283ac_f93d", "Input")      
                            .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.hasDefault)        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction4(),
                                new org.instantlogic.interaction.page.FragmentTemplate("PcaAqs_tUyfbwipI_68481e90_46c8", "Button")      
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