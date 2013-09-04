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
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> reverseTechnicalName; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> hasOptions; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> reverseName; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> reverseMultivalue; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> reverseJavaIdentifier; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> options;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> reverseDataType;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> to;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> from;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> $owner
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean>(
				"DlOfOxpyieayimta_961781ea_409f", "owner", INSTANCE, java.lang.Boolean.class, "owner", org.instantlogic.designer.RelationDesign.class);
		owner = $owner;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> $autoCreate
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean>(
				"GssrrfuIrucqAecp_726ad037_999f", "autoCreate", INSTANCE, java.lang.Boolean.class, "autoCreate", org.instantlogic.designer.RelationDesign.class);
		autoCreate = $autoCreate;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> $reverseTechnicalName
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String>(
				"HhUpEjcErIdAIepw_7994e4ce_cfbb", "reverseTechnicalName", INSTANCE, java.lang.String.class, "reverseTechnicalName", org.instantlogic.designer.RelationDesign.class);
		reverseTechnicalName = $reverseTechnicalName;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> $hasOptions
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean>(
				"KxnntOrvkadAUmoe_d72cbf1e_8a87", "hasOptions", INSTANCE, java.lang.Boolean.class, "hasOptions", org.instantlogic.designer.RelationDesign.class);
		hasOptions = $hasOptions;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> $reverseName
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String>(
				"LyhixxlivmgEAmOt_3b07e49b_86e6", "reverseName", INSTANCE, java.lang.String.class, "reverseName", org.instantlogic.designer.RelationDesign.class);
		reverseName = $reverseName;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean> $reverseMultivalue
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.Boolean, java.lang.Boolean>(
				"Rwtsuvzafqcwgali_dc02e119_3a7e", "reverseMultivalue", INSTANCE, java.lang.Boolean.class, "reverseMultivalue", org.instantlogic.designer.RelationDesign.class);
		reverseMultivalue = $reverseMultivalue;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String> $reverseJavaIdentifier
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.RelationDesign, java.lang.String, java.lang.String>(
				"UknAp_AyEI_walok_34eae6a8_d2d8", "reverseJavaIdentifier", INSTANCE, java.lang.String.class, "reverseJavaIdentifier", org.instantlogic.designer.RelationDesign.class);
		reverseJavaIdentifier = $reverseJavaIdentifier;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $options
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"WueqelfImI_qycth_bd225860_25f4", "options", INSTANCE, "options", org.instantlogic.designer.RelationDesign.class);
		options = $options;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> $reverseDataType
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
				"YuOeqgAoIIcyIfec_259c8e8b_839a", "reverseDataType", INSTANCE, "reverseDataType", org.instantlogic.designer.RelationDesign.class);
		reverseDataType = $reverseDataType;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $to
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"icoygmzcuIcUIk_p_8301e2aa_9ec1", "to", INSTANCE, "to", org.instantlogic.designer.RelationDesign.class);
		to = $to;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $from
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.RelationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"DdfInmI_di_qIkIo_d5b5913b_d430", "from", INSTANCE, "from", org.instantlogic.designer.RelationDesign.class);
		from = $from;
		
		// Phase 2
		$owner.dataType.put("category", "boolean");
		$autoCreate.dataType.put("category", "boolean");
		$reverseTechnicalName.dataType.put("category", "text");
		$reverseTechnicalName.readOnly = true;
		$reverseTechnicalName.rule = createDeduction0();
		$hasOptions.dataType.put("category", "boolean");
		$reverseName.dataType.put("category", "text");
		$reverseMultivalue.dataType.put("category", "boolean");
		$reverseJavaIdentifier.dataType.put("category", "text");
		$reverseJavaIdentifier.readOnly = true;
		$reverseJavaIdentifier.rule = createDeduction1();

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
		return "KOpem_amreedUjah_7c1fbc48_0118";
	}
	
	@Override
	public String getName() {
		return "RelationDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		owner,
		autoCreate,
		reverseTechnicalName,
		hasOptions,
		reverseName,
		reverseMultivalue,
		reverseJavaIdentifier,
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
