package org.instantlogic.example.izzy.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class IssueEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.example.izzy.Issue> {

	public static final IssueEntity INSTANCE = new IssueEntity();
	

	
	@Override
	public org.instantlogic.example.izzy.Issue createInstance() {
		return new org.instantlogic.example.izzy.Issue();
	}
	
	@Override
	public Class<org.instantlogic.example.izzy.Issue> getInstanceClass() {
		return org.instantlogic.example.izzy.Issue.class;
	}
	
	@Override
	public String getName() {
		return "issue";
	}

	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.User>> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.example.izzy.Project> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.example.izzy.entity.ProjectEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.User>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.example.izzy.entity.ProjectEntity.users, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.User>> createDeduction1() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.example.izzy.Project> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.example.izzy.entity.ProjectEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.User>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.example.izzy.entity.ProjectEntity.users, d0);
		return d1;
	}


	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.example.izzy.Issue, java.lang.Integer, java.lang.Integer> StoryPoints 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.example.izzy.Issue, java.lang.Integer, java.lang.Integer>(
			"Story points", INSTANCE, java.lang.Integer.class
		) {
			{
				dataType.put("category", "number");
				dataType.put("wholeNumber", true);
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.example.izzy.Issue, java.lang.Integer> get(org.instantlogic.example.izzy.Issue instance) {
				return instance.getStoryPointsAttributeValue();
			}
            
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.example.izzy.Issue, java.lang.String, java.lang.String> description 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.example.izzy.Issue, java.lang.String, java.lang.String>(
			"description", INSTANCE, java.lang.String.class
		) {
			{
				dataType.put("category", "text");
				dataType.put("multiLine", true);
				dataType.put("formatted", true);
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.example.izzy.Issue, java.lang.String> get(org.instantlogic.example.izzy.Issue instance) {
				return instance.getDescriptionAttributeValue();
			}
            
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.example.izzy.Issue, java.lang.String, java.lang.String> headline 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.example.izzy.Issue, java.lang.String, java.lang.String>(
			"headline", INSTANCE, java.lang.String.class
		) {
			{
				dataType.put("category", "text");
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.example.izzy.Issue, java.lang.String> get(org.instantlogic.example.izzy.Issue instance) {
				return instance.getHeadlineAttributeValue();
			}
            
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.example.izzy.Issue, java.lang.String, java.lang.String> newAttribute 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.example.izzy.Issue, java.lang.String, java.lang.String>(
			"new attribute", INSTANCE, java.lang.String.class
		) {
			{
				dataType.put("category", "text");
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.example.izzy.Issue, java.lang.String> get(org.instantlogic.example.izzy.Issue instance) {
				return instance.getNewAttributeAttributeValue();
			}
            
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.example.izzy.Issue, java.lang.Integer, java.lang.Integer> number 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.example.izzy.Issue, java.lang.Integer, java.lang.Integer>(
			"number", INSTANCE, java.lang.Integer.class
		) {
			{
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.example.izzy.Issue, java.lang.Integer> get(org.instantlogic.example.izzy.Issue instance) {
				return instance.getNumberAttributeValue();
			}
            
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.Issue, org.instantlogic.example.izzy.User, org.instantlogic.example.izzy.User> assignee
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.Issue, org.instantlogic.example.izzy.User, org.instantlogic.example.izzy.User>(
			"assignee", INSTANCE, org.instantlogic.example.izzy.entity.UserEntity.INSTANCE, org.instantlogic.example.izzy.User.class, 
			org.instantlogic.example.izzy.entity.UserEntity.assignedIssues
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.example.izzy.Issue, org.instantlogic.example.izzy.User> get(
					org.instantlogic.example.izzy.Issue instance) {
				return instance.getAssigneeRelationValue();
			}
			
			private org.instantlogic.fabric.deduction.Deduction<? extends java.lang.Iterable<org.instantlogic.example.izzy.User>> options;
			@Override
			public org.instantlogic.fabric.deduction.Deduction<? extends java.lang.Iterable<org.instantlogic.example.izzy.User>> getOptions() {
				if (options==null) {
					options = (org.instantlogic.fabric.deduction.Deduction)createDeduction1();
				}
				return options;
			};
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.Issue, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Comment>, org.instantlogic.example.izzy.Comment> comments
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.Issue, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Comment>, org.instantlogic.example.izzy.Comment>(
			"comments", INSTANCE, org.instantlogic.example.izzy.entity.CommentEntity.INSTANCE, org.instantlogic.example.izzy.Comment.class, 
			org.instantlogic.example.izzy.entity.CommentEntity.issue
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.example.izzy.Issue, org.instantlogic.example.izzy.Comment> get(
					org.instantlogic.example.izzy.Issue instance) {
				return instance.getCommentsRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.Issue, org.instantlogic.example.izzy.User, org.instantlogic.example.izzy.User> reporter
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.Issue, org.instantlogic.example.izzy.User, org.instantlogic.example.izzy.User>(
			"reporter", INSTANCE, org.instantlogic.example.izzy.entity.UserEntity.INSTANCE, org.instantlogic.example.izzy.User.class, 
			org.instantlogic.example.izzy.entity.UserEntity.reportedIssues
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.example.izzy.Issue, org.instantlogic.example.izzy.User> get(
					org.instantlogic.example.izzy.Issue instance) {
				return instance.getReporterRelationValue();
			}
			
			private org.instantlogic.fabric.deduction.Deduction<? extends java.lang.Iterable<org.instantlogic.example.izzy.User>> options;
			@Override
			public org.instantlogic.fabric.deduction.Deduction<? extends java.lang.Iterable<org.instantlogic.example.izzy.User>> getOptions() {
				if (options==null) {
					options = (org.instantlogic.fabric.deduction.Deduction)createDeduction0();
				}
				return options;
			};
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.Issue, org.instantlogic.example.izzy.Project, org.instantlogic.example.izzy.Project> project
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.Issue, org.instantlogic.example.izzy.Project, org.instantlogic.example.izzy.Project>(
			"project", INSTANCE, org.instantlogic.example.izzy.entity.ProjectEntity.INSTANCE, org.instantlogic.example.izzy.Project.class, org.instantlogic.example.izzy.entity.ProjectEntity.issues
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.example.izzy.Issue, org.instantlogic.example.izzy.Project> get(
					org.instantlogic.example.izzy.Issue instance) {
				return instance.getProjectRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		StoryPoints,
		description,
		headline,
		newAttribute,
		number,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		assignee,
		comments,
		reporter,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		project,
	};
	private static final org.instantlogic.fabric.model.Validation[] VALIDATIONS = new org.instantlogic.fabric.model.Validation[]{
	};
	

	@Override
	public org.instantlogic.fabric.model.Attribute[] getLocalAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public org.instantlogic.fabric.model.Relation[] getLocalRelations() {
		return RELATIONS;
	}

	@Override
	public org.instantlogic.fabric.model.Relation[] getLocalReverseRelations() {
		return REVERSE_RELATIONS;
	}
	@Override
	public org.instantlogic.fabric.model.Validation[] getLocalValidations() {
		return VALIDATIONS;
	}
	
	@Override
	public java.util.Map<String, org.instantlogic.example.izzy.Issue> getStaticInstances() {
		return org.instantlogic.example.izzy.Issue.getStaticIssueInstances();
	}
}
