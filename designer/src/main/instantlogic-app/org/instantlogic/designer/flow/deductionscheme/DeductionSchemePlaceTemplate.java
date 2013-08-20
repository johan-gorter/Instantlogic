package org.instantlogic.designer.flow.deductionscheme;

public class DeductionSchemePlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final DeductionSchemePlaceTemplate INSTANCE = new DeductionSchemePlaceTemplate();

	@Override
	public String getId() {
		return "_hadkvxvqaemgaiE_40410db2_7cd1";
	}
	

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.deductions);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DeductionDesignEntity.inputs);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction2() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DeductionInputDesignEntity.operationInput);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DeductionInputDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction3() {
		  	org.instantlogic.fabric.deduction.IdDeduction d0 = new org.instantlogic.fabric.deduction.IdDeduction();
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DeductionInputDesignEntity.INSTANCE);
		    d0.setIdOfInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction4() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DeductionDesignEntity.diagramPosition);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction5() {
		  	org.instantlogic.fabric.deduction.ReverseRelationDeduction d0 = new org.instantlogic.fabric.deduction.ReverseRelationDeduction();
		    d0.setRelation(org.instantlogic.designer.entity.DeductionInputDesignEntity.inputs);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE);
		    d0.setToInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction6() {
		  	org.instantlogic.fabric.deduction.IdDeduction d0 = new org.instantlogic.fabric.deduction.IdDeduction();
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DeductionInputDesignEntity.INSTANCE);
		    d0.setIdOfInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction7() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DeductionDesignEntity.operation);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction8() {
		  	org.instantlogic.fabric.deduction.IdDeduction d0 = new org.instantlogic.fabric.deduction.IdDeduction();
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE);
		    d0.setIdOfInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction9() {
		  	org.instantlogic.fabric.deduction.IdDeduction d0 = new org.instantlogic.fabric.deduction.IdDeduction();
		  	org.instantlogic.fabric.deduction.AttributeDeduction d1 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d1.setAttribute(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.output);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d2 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d2.setOfEntity(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE);
		    d0.setIdOfInstance(d1);
		    d1.setInstance(d2);
		return d0;
	}

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("DaOlOpOOlqgtabfu_6e0dd080_f43f", "Page")        
            .addChild("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("Jofcawnuuybeibix_629d0ca0_9fd5", "Block")      
                    .setStyleNames(new String[]{"card"})        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("HxtUhtdOwucoiomb_995f379f_449f", "Heading3")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("DeductionScheme").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("Sweo_IfikucAwcym_cb66c259_7c2e", "DeductionScheme")      
                            .putValue("output", createDeduction9())        
                            .addChild("deductions",
                                new org.instantlogic.interaction.page.SelectionElement(createDeduction0(),
                                        new org.instantlogic.interaction.page.FragmentTemplate("XnAOonndfqafueEO_64ff7369_3779", "Deduction")      
                                            .putValue("deductionId", createDeduction8())      
                                            .putValue("xy", createDeduction4())      
                                            .putText("operationName", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction7()).getTextTemplate())        
                                            .addChild("inputs",
                                                new org.instantlogic.interaction.page.SelectionElement(createDeduction1(),
                                                        new org.instantlogic.interaction.page.FragmentTemplate("ThosuziaOIdsglcu_ecdaa5d9_e0df", "DeductionInput")      
                                                            .putValue("deductionInputId", createDeduction3())      
                                                            .putText("operationInputName", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction2()).getTextTemplate()))
        
                                            )        
                                            .addChild("outputs",
                                                new org.instantlogic.interaction.page.SelectionElement(createDeduction5(),
                                                        new org.instantlogic.interaction.page.FragmentTemplate("eAtoyxmtuy_dsopa_0fc48434_6e92", "Output")      
                                                            .putValue("toDeductionInputId", createDeduction6()))
        
                                            ))
        
                            )        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("ebItyndiei_nk_AE_1f0784d9_0cf2", "Button")      
                            .setStyleNames(new String[]{"btn"})      
                            .setEvent(org.instantlogic.designer.event.DataEvent.INSTANCE)      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Data").getTextTemplate())        
                            .addChild("content",
                                new org.instantlogic.interaction.page.FragmentTemplate("OAplUhkdyagbcjfx_2e284891_3636", "Icon")      
                                    .setStyleNames(new String[]{"icon-wrench"})        
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