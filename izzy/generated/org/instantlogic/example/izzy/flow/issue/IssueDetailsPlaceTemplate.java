package org.instantlogic.example.izzy.flow.issue;

public class IssueDetailsPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final IssueDetailsPlaceTemplate INSTANCE = new IssueDetailsPlaceTemplate();

	@Override
	public String getId() {
		return "issueDetails";
	}
	

	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Integer> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.example.izzy.Issue> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.Integer> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.number, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction1() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.example.izzy.Issue> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.headline, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Integer> createDeduction2() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.example.izzy.Issue> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.Integer> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.number, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction3() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.example.izzy.Issue> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.headline, d0);
		return d1;
	}

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("b30d3883-076d-4dbb-a7ee-55a78ba7912a", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("1fa8eab9-3f6d-4e19-81f2-a52a2dbc51bf", "Button")      .setStyleNames(new String[]{"btn-link"})
      .setEvent(org.instantlogic.example.izzy.event.HomeEvent.INSTANCE)
      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Home")))
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("94279264-b41d-4b9b-98c9-7a140419c3a7", "Icon")      .setStyleNames(new String[]{"icon-home"})
                )
,
                new org.instantlogic.interaction.page.FragmentTemplate("779c6c76-ce04-4c30-b0da-580dc424c322", "Heading2")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Issue "),new org.instantlogic.fabric.text.StringTemplate(createDeduction0()),new org.instantlogic.fabric.text.StringTemplate(": "),new org.instantlogic.fabric.text.StringTemplate(createDeduction1())))
,
                new org.instantlogic.interaction.page.FragmentTemplate("284431e5-54c9-46bd-9a9d-7fb67ac68d2b", "Input")      .setStyleNames(new String[]{"answer-span8"})
      .setField(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE, org.instantlogic.example.izzy.entity.IssueEntity.headline)
,
                new org.instantlogic.interaction.page.FragmentTemplate("de05766d-4a52-4211-b079-bd7f4ca15106", "Input")      .setStyleNames(new String[]{"answer-span4"})
      .setField(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE, org.instantlogic.example.izzy.entity.IssueEntity.reporter)
,
                new org.instantlogic.interaction.page.FragmentTemplate("a41e19ad-06f6-41af-aa62-f6a152b8f82e", "Input")      .setStyleNames(new String[]{"answer-span4"})
      .setField(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE, org.instantlogic.example.izzy.entity.IssueEntity.assignee)
,
                new org.instantlogic.interaction.page.FragmentTemplate("7de4a992-89f8-43be-a799-e58bbf784eed", "Input")      .setField(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE, org.instantlogic.example.izzy.entity.IssueEntity.StoryPoints)
,
                new org.instantlogic.interaction.page.FragmentTemplate("eff45844-e9a8-44a5-9353-0489e0afcc41", "Input")      .setStyleNames(new String[]{"answer-span8", "answer-height300"})
      .setField(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE, org.instantlogic.example.izzy.entity.IssueEntity.description)
        )
; 
	
	private static final org.instantlogic.fabric.text.TextTemplate TITLE = new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Issue "),new org.instantlogic.fabric.text.StringTemplate(createDeduction2()),new org.instantlogic.fabric.text.StringTemplate(": "),new org.instantlogic.fabric.text.StringTemplate(createDeduction3()));
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
        return "issueDetails";
    }
}