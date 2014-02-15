package org.instantlogic.designer.placetemplate;


public class AttributeDetailsPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final AttributeDetailsPlaceTemplate INSTANCE = new AttributeDetailsPlaceTemplate();

	@Override
	public String getId() {
		return "PlaceTemplateDesign_AttributeDetails";
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
        new org.instantlogic.interaction.page.FragmentTemplate("FragmentTemplateDesign", "Page")        
            .addChild("mainContent",
                new org.instantlogic.interaction.page.SelectionElement(createDeduction0(),
                            new org.instantlogic.interaction.page.SharedElementHolder("SharedElementDesign", org.instantlogic.designer.sharedpagefragment.EntityContextPageFragment.INSTANCE)
)
        
            )        
            .addChild("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("FragmentTemplateDesign_1", "Block")      
                    .setStyleNames(new String[]{"card"})        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("FragmentTemplateDesign_2", "Heading3")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction1()).add(" (Attribute)").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("FragmentTemplateDesign_3", "Button")      
                            .setStyleNames(new String[]{"btn"})      
                            .setDestination(org.instantlogic.designer.placetemplate.ToDataExplorerPlaceTemplate.INSTANCE)      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Data").getTextTemplate())        
                            .addChild("content",
                                new org.instantlogic.interaction.page.FragmentTemplate("FragmentTemplateDesign_4", "Icon")      
                                    .setStyleNames(new String[]{"glyphicon-wrench"})        
                            )        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("FragmentTemplateDesign_5", "Button")      
                            .setStyleNames(new String[]{"btn"})      
                            .setDestination(org.instantlogic.designer.placetemplate.RemoveAttributePlaceTemplate.INSTANCE)      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Delete").getTextTemplate())        
                            .addChild("content",
                                new org.instantlogic.interaction.page.FragmentTemplate("FragmentTemplateDesign_6", "Icon")      
                                    .setStyleNames(new String[]{"glyphicon-remove"})        
                            )        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("FragmentTemplateDesign_7", "Input")      
                            .setField(org.instantlogic.designer.entity.DesignEntity.INSTANCE, org.instantlogic.designer.entity.DesignEntity.name)        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("FragmentTemplateDesign_8", "Heading4")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Data type").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction2(),
                                new org.instantlogic.interaction.page.FragmentTemplate("FragmentTemplateDesign_9", "Block")        
                                    .addChild("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("FragmentTemplateDesign_10", "Input")      
                                            .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.dataCategory)        
                                    )        
                                    .addChild("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("FragmentTemplateDesign_11", "Input")      
                                            .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.multiLine)        
                                    )        
                                    .addChild("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("FragmentTemplateDesign_12", "Input")      
                                            .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.formatted)        
                                    )        
                                    .addChild("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("FragmentTemplateDesign_13", "Input")      
                                            .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.percentage)        
                                    )        
                                    .addChild("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("FragmentTemplateDesign_14", "Input")      
                                            .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.wholeNumber)        
                                    )        
                                    .addChild("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("FragmentTemplateDesign_15", "Input")      
                                            .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.exactRounding)        
                                    ))
        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("FragmentTemplateDesign_16", "Heading4")      
                            .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Value").getTextTemplate())        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("FragmentTemplateDesign_17", "Input")      
                            .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.hasRelevance)        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("FragmentTemplateDesign_18", "Input")      
                            .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.hasRule)        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction3(),
                                new org.instantlogic.interaction.page.FragmentTemplate("FragmentTemplateDesign_19", "Button")      
                                    .setStyleNames(new String[]{"btn"})      
                                    .setDestination(org.instantlogic.designer.placetemplate.DeductionSchemePlaceTemplate.INSTANCE)      
                                    .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Deduction scheme").getTextTemplate()))
        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("FragmentTemplateDesign_20", "Input")      
                            .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.writeable)        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("FragmentTemplateDesign_21", "Input")      
                            .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.hasDefault)        
                    )        
                    .addChild("content",
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction4(),
                                new org.instantlogic.interaction.page.FragmentTemplate("FragmentTemplateDesign_22", "Button")      
                                    .setStyleNames(new String[]{"btn"})      
                                    .setDestination(org.instantlogic.designer.placetemplate.DeductionSchemePlaceTemplate.INSTANCE)      
                                    .putText("text", new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Deduction scheme").getTextTemplate()))
        
                    )        
            );
	
	private static final org.instantlogic.fabric.text.TextTemplate TITLE = new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction5()).add(" (Attribute)").getTextTemplate();
	@Override
	protected org.instantlogic.fabric.text.TextTemplate getTitle() {
		return TITLE;
	}
	
	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
		org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE,
	};

	@Override
	public org.instantlogic.fabric.model.Entity[] getParameters() {
		return PARAMETERS;
	}
	
	@Override
	public org.instantlogic.interaction.page.FragmentTemplate getRootContainer() {
		return CONTENT;
	}; 
	
    @Override
    public String getName() {
        return "AttributeDetails";
    }
	
    @Override
    public String getTechnicalName() {
        return "AttributeDetails";
    }
}