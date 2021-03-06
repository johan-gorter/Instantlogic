package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class RelationDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.RelationDesign> {

	public static final RelationDesignEntity INSTANCE = new RelationDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
	}

	
	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.designer.deduction.ReverseJavaIdentifierDeduction d0 = new org.instantlogic.designer.deduction.ReverseJavaIdentifierDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.fabric.deduction.ConcatenateDeduction d0 = new org.instantlogic.fabric.deduction.ConcatenateDeduction();
		  	org.instantlogic.fabric.deduction.AttributeDeduction d1 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d1.setAttribute(org.instantlogic.designer.entity.DesignEntity.name);
		  	org.instantlogic.fabric.deduction.ReverseRelationDeduction d2 = new org.instantlogic.fabric.deduction.ReverseRelationDeduction();
		    d2.setRelation(org.instantlogic.designer.entity.EntityDesignEntity.relations);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d3 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d3.setOfEntity(org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.ConstantDeduction d4 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d4.setValue("On");
		  	org.instantlogic.fabric.deduction.AttributeDeduction d5 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d5.setAttribute(org.instantlogic.designer.entity.DesignEntity.name);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d6 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d6.setOfEntity(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		    d0.addToStrings(d5);
		    d0.addToStrings(d4);
		    d0.addToStrings(d1);
		    d1.setInstance(d2);
		    d2.setToInstance(d3);
		    d5.setInstance(d6);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction2() {
		  	org.instantlogic.designer.deduction.ReverseTechnicalNameDeduction d0 = new org.instantlogic.designer.deduction.ReverseTechnicalNameDeduction();
		return d0;
	}


	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> autoCreate; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> hasOptions; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> owner; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> reverseJavaIdentifier; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> reverseMultivalue; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> reverseName; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> reverseTechnicalName; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> options;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> reverseDataType;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> to;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> from;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> $autoCreate
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean>(
				"AttributeDesign_autoCreate", "autoCreate", INSTANCE, java.lang.Boolean.class, "autoCreate", org.instantlogic.designer.RelationDesign.class);
		autoCreate = $autoCreate;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> $hasOptions
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean>(
				"AttributeDesign_hasOptions", "hasOptions", INSTANCE, java.lang.Boolean.class, "hasOptions", org.instantlogic.designer.RelationDesign.class);
		hasOptions = $hasOptions;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> $owner
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean>(
				"AttributeDesign_owner", "owner", INSTANCE, java.lang.Boolean.class, "owner", org.instantlogic.designer.RelationDesign.class);
		owner = $owner;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> $reverseJavaIdentifier
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String>(
				"AttributeDesign_reverseJavaIdentifier", "reverseJavaIdentifier", INSTANCE, java.lang.String.class, "reverseJavaIdentifier", org.instantlogic.designer.RelationDesign.class);
		reverseJavaIdentifier = $reverseJavaIdentifier;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> $reverseMultivalue
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean>(
				"AttributeDesign_reverseMultivalue", "reverseMultivalue", INSTANCE, java.lang.Boolean.class, "reverseMultivalue", org.instantlogic.designer.RelationDesign.class);
		reverseMultivalue = $reverseMultivalue;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> $reverseName
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String>(
				"AttributeDesign_reverseName", "reverseName", INSTANCE, java.lang.String.class, "reverseName", org.instantlogic.designer.RelationDesign.class);
		reverseName = $reverseName;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> $reverseTechnicalName
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String>(
				"AttributeDesign_reverseTechnicalName", "reverseTechnicalName", INSTANCE, java.lang.String.class, "reverseTechnicalName", org.instantlogic.designer.RelationDesign.class);
		reverseTechnicalName = $reverseTechnicalName;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $options
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"RelationDesign_options", "options", INSTANCE, "options", org.instantlogic.designer.RelationDesign.class);
		options = $options;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> $reverseDataType
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
				"RelationDesign_reverseDataType", "reverseDataType", INSTANCE, "reverseDataType", org.instantlogic.designer.RelationDesign.class);
		reverseDataType = $reverseDataType;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $to
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"RelationDesign_to", "to", INSTANCE, "to", org.instantlogic.designer.RelationDesign.class);
		to = $to;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $from
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"reverse-RelationDesign_relations", "from", INSTANCE, "from", org.instantlogic.designer.RelationDesign.class);
		from = $from;
		
		// Phase 2
		$autoCreate.dataType.put("category", "boolean");
		$hasOptions.dataType.put("category", "boolean");
		$owner.dataType.put("category", "boolean");
		$reverseJavaIdentifier.dataType.put("category", "text");
		$reverseJavaIdentifier.readOnly = true;
		$reverseJavaIdentifier.rule = createDeduction0();
		$reverseMultivalue.dataType.put("category", "boolean");
		$reverseName.dataType.put("category", "text");
		$reverseName._default = createDeduction1();
		$reverseTechnicalName.dataType.put("category", "text");
		$reverseTechnicalName.readOnly = true;
		$reverseTechnicalName.rule = createDeduction2();

		$options.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$options.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$options.setReverseRelation(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.optionsOfRelation);
		$options.owner = true;
		$reverseDataType.valueClass = org.instantlogic.designer.DataTypeDesign.class;
		$reverseDataType.to = org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE;
		$reverseDataType.setReverseRelation(org.instantlogic.designer.entity.DataTypeDesignEntity.reverseRelation);
		$reverseDataType.owner = true;
		$reverseDataType.autoCreate = true;
		$to.valueClass = org.instantlogic.designer.EntityDesign.class;
		$to.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$to.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.reverseRelations);

		$from.reverse = true;
		$from.valueClass = org.instantlogic.designer.EntityDesign.class;
		$from.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$from.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.relations);
	}

	@Override
	public org.instantlogic.designer.RelationDesign createInstance() {
		return new org.instantlogic.designer.RelationDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.RelationDesign> getInstanceClass() {
		return org.instantlogic.designer.RelationDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "EntityDesign_RelationDesign";
	}
	
	@Override
	public String getName() {
		return "RelationDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		autoCreate,
		hasOptions,
		owner,
		reverseJavaIdentifier,
		reverseMultivalue,
		reverseName,
		reverseTechnicalName,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		options,
		reverseDataType,
		to,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		from,
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
	public java.util.Map<String, org.instantlogic.designer.RelationDesign> getStaticInstances() {
		return org.instantlogic.designer.RelationDesign.getStaticRelationDesignInstances();
	}
}
