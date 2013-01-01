package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DeductionDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DeductionDesign> {

	public static final DeductionDesignEntity INSTANCE = new DeductionDesignEntity();
	

	private static final org.instantlogic.fabric.model.Entity<?>[] EXTENSIONS = new org.instantlogic.fabric.model.Entity<?>[] {
		org.instantlogic.designer.entity.AttributeDeductionDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.CastInstanceDeductionDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.ConstantDeductionDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.CustomDeductionDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.EqualsDeductionDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.HasValueDeductionDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.NegationDeductionDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.ReverseRelationDeductionDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.SelectedInstanceDeductionDesignEntity.INSTANCE,
		org.instantlogic.designer.entity.SumDeductionDesignEntity.INSTANCE
	};
	 
	@Override
	public org.instantlogic.fabric.model.Entity[] extensions() {
		return EXTENSIONS;
	}
	
	@Override
	public org.instantlogic.designer.DeductionDesign createInstance() {
		return new org.instantlogic.designer.DeductionDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.DeductionDesign> getInstanceClass() {
		return org.instantlogic.designer.DeductionDesign.class;
	}
	
	@Override
	public String getName() {
		return "DeductionDesign";
	}

	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.DataTypeDesign> createDeduction0() {
		    org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.DataTypeDesign> d0 
		    	= new org.instantlogic.designer.deduction.DeductionDataTypeDeduction();
		return d0;
	}


	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> dataType
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
			"dataType", INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.DataTypeDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DataTypeDesign> get(
					org.instantlogic.designer.DeductionDesign instance) {
				return instance.getDataTypeRelationValue();
			}
	
			public boolean isReadOnly() {
				return true;
			}

			private org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.DataTypeDesign> rule;
			@Override
			public org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.DataTypeDesign> getRule() {
				if (rule==null) {
					rule  = createDeduction0();
				}
				return rule;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign> inputs
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign>(
			"inputs", INSTANCE, org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE, org.instantlogic.designer.DeductionDesign.class, 
			org.instantlogic.designer.entity.DeductionDesignEntity.outputs
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> get(
					org.instantlogic.designer.DeductionDesign instance) {
				return instance.getInputsRelationValue();
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign> outputs
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign>(
			"outputs", INSTANCE, org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE, org.instantlogic.designer.DeductionDesign.class, org.instantlogic.designer.entity.DeductionDesignEntity.inputs
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> get(
					org.instantlogic.designer.DeductionDesign instance) {
				return instance.getOutputsRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> scheme
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
			"scheme", INSTANCE, org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE, org.instantlogic.designer.DeductionSchemeDesign.class, org.instantlogic.designer.entity.DeductionSchemeDesignEntity.deductions
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign> get(
					org.instantlogic.designer.DeductionDesign instance) {
				return instance.getSchemeRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		dataType,
		inputs,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		outputs,
		scheme,
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
	public java.util.Map<String, org.instantlogic.designer.DeductionDesign> getStaticInstances() {
		return org.instantlogic.designer.DeductionDesign.getStaticDeductionDesignInstances();
	}
}
