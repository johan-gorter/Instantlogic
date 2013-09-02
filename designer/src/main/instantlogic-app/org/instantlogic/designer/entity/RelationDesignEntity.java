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
		  	org.instantlogic.designer.deduction.ReverseTechnicalNameDeduction d0 = new org.instantlogic.designer.deduction.ReverseTechnicalNameDeduction();
		return d0;
	}


	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> owner; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> reverseJavaIdentifier; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> reverseName; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> autoCreate; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> hasOptions; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> reverseMultivalue; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> reverseTechnicalName; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> to;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> options;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> reverseDataType;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> from;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> $owner
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean>(
				"Aryxncqscaadwawr_8930f927_8b0e", "owner", INSTANCE, java.lang.Boolean.class, "owner", org.instantlogic.designer.RelationDesign.class);
		owner = $owner;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> $reverseJavaIdentifier
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String>(
				"GfAatvchIafuUktb_24d1b2d6_c958", "reverseJavaIdentifier", INSTANCE, java.lang.String.class, "reverseJavaIdentifier", org.instantlogic.designer.RelationDesign.class);
		reverseJavaIdentifier = $reverseJavaIdentifier;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> $reverseName
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String>(
				"Kxhm_opUgibwU_wa_fc4db239_83d7", "reverseName", INSTANCE, java.lang.String.class, "reverseName", org.instantlogic.designer.RelationDesign.class);
		reverseName = $reverseName;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> $autoCreate
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean>(
				"OfO_ekssjaegggez_774df69b_653d", "autoCreate", INSTANCE, java.lang.Boolean.class, "autoCreate", org.instantlogic.designer.RelationDesign.class);
		autoCreate = $autoCreate;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> $hasOptions
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean>(
				"RdspomAanybUAkw_23036d81_37f5", "hasOptions", INSTANCE, java.lang.Boolean.class, "hasOptions", org.instantlogic.designer.RelationDesign.class);
		hasOptions = $hasOptions;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> $reverseMultivalue
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean>(
				"SgAtqdbcsidceadi_2b2ced59_f7e3", "reverseMultivalue", INSTANCE, java.lang.Boolean.class, "reverseMultivalue", org.instantlogic.designer.RelationDesign.class);
		reverseMultivalue = $reverseMultivalue;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> $reverseTechnicalName
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String>(
				"alsaiUUUtqbpchur_7a30a877_20ce", "reverseTechnicalName", INSTANCE, java.lang.String.class, "reverseTechnicalName", org.instantlogic.designer.RelationDesign.class);
		reverseTechnicalName = $reverseTechnicalName;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $to
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"Iftcmdxfka_Iujwu_37bf1db2_3c10", "to", INSTANCE, "to", org.instantlogic.designer.RelationDesign.class);
		to = $to;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $options
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"WeakAeAkxicyiczA_7b92d251_f183", "options", INSTANCE, "options", org.instantlogic.designer.RelationDesign.class);
		options = $options;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> $reverseDataType
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
				"ZetfknaOuigjynvw_2956ea9b_d277", "reverseDataType", INSTANCE, "reverseDataType", org.instantlogic.designer.RelationDesign.class);
		reverseDataType = $reverseDataType;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $from
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"WfulvAEimmeywitk_3f2f6d7e_f95a", "from", INSTANCE, "from", org.instantlogic.designer.RelationDesign.class);
		from = $from;
		
		// Phase 2
		$owner.dataType.put("category", "boolean");
		$reverseJavaIdentifier.dataType.put("category", "text");
		$reverseJavaIdentifier.readOnly = true;
		$reverseJavaIdentifier.rule = createDeduction0();
		$reverseName.dataType.put("category", "text");
		$autoCreate.dataType.put("category", "boolean");
		$hasOptions.dataType.put("category", "boolean");
		$reverseMultivalue.dataType.put("category", "boolean");
		$reverseTechnicalName.dataType.put("category", "text");
		$reverseTechnicalName.readOnly = true;
		$reverseTechnicalName.rule = createDeduction1();

		$to.valueClass = org.instantlogic.designer.EntityDesign.class;
		$to.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$to.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.reverseRelations);
		$options.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$options.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$options.setReverseRelation(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.optionsOfRelation);
		$options.owner = true;
		$reverseDataType.valueClass = org.instantlogic.designer.DataTypeDesign.class;
		$reverseDataType.to = org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE;
		$reverseDataType.setReverseRelation(org.instantlogic.designer.entity.DataTypeDesignEntity.reverseRelation);
		$reverseDataType.owner = true;
		$reverseDataType.autoCreate = true;

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
		return "awfIOyEpkiaecbkf_b8998cb2_cdff";
	}
	
	@Override
	public String getName() {
		return "RelationDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		owner,
		reverseJavaIdentifier,
		reverseName,
		autoCreate,
		hasOptions,
		reverseMultivalue,
		reverseTechnicalName,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		to,
		options,
		reverseDataType,
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
