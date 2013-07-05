package org.instantlogic.designer.flow.deductionscheme;

public class DeductionSchemePlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final DeductionSchemePlaceTemplate INSTANCE = new DeductionSchemePlaceTemplate();

	@Override
	public String getId() {
		return "Placetemplatdsgn__0003";
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
		  	org.instantlogic.fabric.deduction.IdDeduction d0 = new org.instantlogic.fabric.deduction.IdDeduction();
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE);
		    d0.setIdOfInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction3() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DeductionDesignEntity.diagramPosition);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0027", "Page")        
            .addChild("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0028", "Block")      
                    .setStyleNames(new String[]{"card"})        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__0029", "Heading3")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("DeductionScheme").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__002a", "Button")      
                            .setStyleNames(new String[]{"btn"})      
                            .setEvent(org.instantlogic.designer.event.DataEvent.INSTANCE)      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Data").getTextTemplate())        
                            .addChild("content",
                                new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__002b", "Icon")      
                                    .setStyleNames(new String[]{"icon-wrench"})        
                            )        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__002c", "DeductionScheme")      
                            .putValue("output", createDeduction0())        
                            .addChild("deductions",
                                new org.instantlogic.interaction.page.SelectionElement(createDeduction1(),
                                        new org.instantlogic.interaction.page.FragmentTemplate("Fragmnttmpltdsgn__002d", "Deduction")      
                                            .putValue("id", createDeduction2())      
                                            .putValue("xy", createDeduction3()))
        
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