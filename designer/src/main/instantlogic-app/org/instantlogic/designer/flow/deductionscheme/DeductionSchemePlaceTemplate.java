package org.instantlogic.designer.flow.deductionscheme;

public class DeductionSchemePlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final DeductionSchemePlaceTemplate INSTANCE = new DeductionSchemePlaceTemplate();

	@Override
	public String getId() {
		return "UnaAyzkwjqfzsdyn_f2dcb005_9440";
	}
	

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.IdDeduction d0 = new org.instantlogic.fabric.deduction.IdDeduction();
		  	org.instantlogic.fabric.deduction.AttributeDeduction d1 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d1.setAttribute(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.output);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d2 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d2.setOfEntity(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE);
		    d0.setIdOfInstance(d1);
		    d1.setInstance(d2);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.deductions);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction2() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DeductionDesignEntity.diagramPosition);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction3() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DeductionDesignEntity.inputs);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction4() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DeductionInputDesignEntity.operationInput);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DeductionInputDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction5() {
		  	org.instantlogic.fabric.deduction.IdDeduction d0 = new org.instantlogic.fabric.deduction.IdDeduction();
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DeductionInputDesignEntity.INSTANCE);
		    d0.setIdOfInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction6() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DeductionDesignEntity.diagramHeight);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction7() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DeductionDesignEntity.diagramWidth);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction8() {
		  	org.instantlogic.fabric.deduction.ReverseRelationDeduction d0 = new org.instantlogic.fabric.deduction.ReverseRelationDeduction();
		    d0.setRelation(org.instantlogic.designer.entity.DeductionInputDesignEntity.inputs);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE);
		    d0.setToInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction9() {
		  	org.instantlogic.fabric.deduction.IdDeduction d0 = new org.instantlogic.fabric.deduction.IdDeduction();
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DeductionInputDesignEntity.INSTANCE);
		    d0.setIdOfInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction10() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DeductionDesignEntity.operation);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction11() {
		  	org.instantlogic.fabric.deduction.IdDeduction d0 = new org.instantlogic.fabric.deduction.IdDeduction();
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE);
		    d0.setIdOfInstance(d1);
		return d0;
	}

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("EfIkpwt_na_akhlu_6466c71f_1f07", "Page")        
            .addChild("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("PE_sxcIwoaewIbse_34a3fef8_745c", "Block")      
                    .setStyleNames(new String[]{"card"})        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("PwsyIElq_qgkUdzb_b9c3b3dc_a5b6", "Heading3")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("DeductionScheme").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("YgjxEzylqIdeslvu_af941759_5776", "Button")      
                            .setStyleNames(new String[]{"btn"})      
                            .setEvent(org.instantlogic.designer.event.DataEvent.INSTANCE)      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Data").getTextTemplate())        
                            .addChild("content",
                                new org.instantlogic.interaction.page.FragmentTemplate("FeofmnphlIfcAiso_87b81165_f9e2", "Icon")      
                                    .setStyleNames(new String[]{"icon-wrench"})        
                            )        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("AsOsfiEg_igtAeOb_5c6078e1_567a", "DeductionScheme")      
                            .putValue("output", createDeduction0())        
                            .addChild("deductions",
                                new org.instantlogic.interaction.page.SelectionElement(createDeduction1(),
                                        new org.instantlogic.interaction.page.FragmentTemplate("JuzmbiuIjadAm_oU_f52accc3_a4a2", "Deduction")      
                                            .putValue("height", createDeduction6())      
                                            .putValue("width", createDeduction7())      
                                            .putValue("deductionId", createDeduction11())      
                                            .putValue("xy", createDeduction2())      
                                            .putText("operationName", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction10()).getTextTemplate())        
                                            .addChild("inputs",
                                                new org.instantlogic.interaction.page.SelectionElement(createDeduction3(),
                                                        new org.instantlogic.interaction.page.FragmentTemplate("FzmupuOcyqeUsnIy_890d974c_110a", "DeductionInput")      
                                                            .putValue("deductionInputId", createDeduction5())      
                                                            .putText("operationInputName", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction4()).getTextTemplate()))
        
                                            )        
                                            .addChild("outputs",
                                                new org.instantlogic.interaction.page.SelectionElement(createDeduction8(),
                                                        new org.instantlogic.interaction.page.FragmentTemplate("EulEtcizsmanomib_3e801746_5d03", "Output")      
                                                            .putValue("toDeductionInputId", createDeduction9()))
        
                                            ))
        
                            )        
                    )        
            ); 
	
	private static final org.instantlogic.fabric.text.TextTemplate TITLE = new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("DeductionScheme").getTextTemplate();
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
        return "DeductionScheme";
    }
}