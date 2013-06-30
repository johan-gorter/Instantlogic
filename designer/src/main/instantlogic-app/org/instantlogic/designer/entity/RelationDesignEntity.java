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
		  	org.instantlogic.designer.deduction.ReverseTechnicalNameDeduction d0 = new org.instantlogic.designer.deduction.ReverseTechnicalNameDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.designer.deduction.ReverseJavaIdentifierDeduction d0 = new org.instantlogic.designer.deduction.ReverseJavaIdentifierDeduction();
		return d0;
	}


	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> owner; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> autoCreate; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> reverseMultivalue; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> reverseName; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> reverseTechnicalName; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> reverseJavaIdentifier; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> hasOptions; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> to;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> reverseDataType;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> options;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> from;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> $owner
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean>(
				"Attributedesign__001b", "owner", INSTANCE, java.lang.Boolean.class, "owner", org.instantlogic.designer.RelationDesign.class);
		owner = $owner;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> $autoCreate
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean>(
				"Attributedesign__001c", "autoCreate", INSTANCE, java.lang.Boolean.class, "autoCreate", org.instantlogic.designer.RelationDesign.class);
		autoCreate = $autoCreate;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> $reverseMultivalue
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean>(
				"Attributedesign__001d", "reverseMultivalue", INSTANCE, java.lang.Boolean.class, "reverseMultivalue", org.instantlogic.designer.RelationDesign.class);
		reverseMultivalue = $reverseMultivalue;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> $reverseName
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String>(
				"Attributedesign__001e", "reverseName", INSTANCE, java.lang.String.class, "reverseName", org.instantlogic.designer.RelationDesign.class);
		reverseName = $reverseName;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> $reverseTechnicalName
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String>(
				"Attributedesign__001f", "reverseTechnicalName", INSTANCE, java.lang.String.class, "reverseTechnicalName", org.instantlogic.designer.RelationDesign.class);
		reverseTechnicalName = $reverseTechnicalName;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> $reverseJavaIdentifier
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String>(
				"Attributedesign__0020", "reverseJavaIdentifier", INSTANCE, java.lang.String.class, "reverseJavaIdentifier", org.instantlogic.designer.RelationDesign.class);
		reverseJavaIdentifier = $reverseJavaIdentifier;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> $hasOptions
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean>(
				"Attributedesign__0021", "hasOptions", INSTANCE, java.lang.Boolean.class, "hasOptions", org.instantlogic.designer.RelationDesign.class);
		hasOptions = $hasOptions;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $to
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"Relationdesign__0030", "to", INSTANCE, "to", org.instantlogic.designer.RelationDesign.class);
		to = $to;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> $reverseDataType
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
				"Relationdesign__0031", "reverseDataType", INSTANCE, "reverseDataType", org.instantlogic.designer.RelationDesign.class);
		reverseDataType = $reverseDataType;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $options
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"Relationdesign__0032", "options", INSTANCE, "options", org.instantlogic.designer.RelationDesign.class);
		options = $options;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $from
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"Relationdesign__000d", "from", INSTANCE, "from", org.instantlogic.designer.RelationDesign.class);
		from = $from;
		
		// Phase 2
		$owner.dataType.put("category", "boolean");
		$autoCreate.dataType.put("category", "boolean");
		$reverseMultivalue.dataType.put("category", "boolean");
		$reverseName.dataType.put("category", "text");
		$reverseTechnicalName.dataType.put("category", "text");
		$reverseTechnicalName.readOnly = true;
		$reverseTechnicalName.rule = createDeduction0();
		$reverseJavaIdentifier.dataType.put("category", "text");
		$reverseJavaIdentifier.readOnly = true;
		$reverseJavaIdentifier.rule = createDeduction1();
		$hasOptions.dataType.put("category", "boolean");

		$to.valueClass = org.instantlogic.designer.EntityDesign.class;
		$to.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$to.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.reverseRelations);
		$reverseDataType.valueClass = org.instantlogic.designer.DataTypeDesign.class;
		$reverseDataType.to = org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE;
		$reverseDataType.setReverseRelation(org.instantlogic.designer.entity.DataTypeDesignEntity.reverseRelation);
		$reverseDataType.owner = true;
		$reverseDataType.autoCreate = true;
		$options.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$options.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$options.setReverseRelation(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.optionsOfRelation);
		$options.owner = true;

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
		return "Entitydesign__000b";
	}
	
	@Override
	public String getName() {
		return "RelationDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		owner,
		autoCreate,
		reverseMultivalue,
		reverseName,
		reverseTechnicalName,
		reverseJavaIdentifier,
		hasOptions,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		to,
		reverseDataType,
		options,
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
