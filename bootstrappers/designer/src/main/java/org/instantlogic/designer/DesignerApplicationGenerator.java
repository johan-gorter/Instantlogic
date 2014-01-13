package org.instantlogic.designer;

import java.io.File;
import java.io.FileWriter;

import org.instantlogic.designer.event.HomeEventGenerator;
import org.instantlogic.designer.flow.MainFlowGenerator;
import org.instantlogic.designer.tools.Generator;
import org.instantlogic.fabric.util.id.SequencePerLabelIdGenerator;
import org.instantlogic.tools.persistence.json.CasePersister;


public class DesignerApplicationGenerator extends ApplicationDesign {

    public static DesignerApplicationGenerator APPLICATION = new DesignerApplicationGenerator();
    
    public static FragmentTypeDesign FragmentTypeInput;
    public static FragmentTypeDesign FragmentTypeButton;
    public static FragmentTypeDesign FragmentTypeLink;
    public static FragmentTypeDesign FragmentTypeParagraph;
    public static FragmentTypeDesign FragmentTypeHeading1;
    public static FragmentTypeDesign FragmentTypeHeading2;
    public static FragmentTypeDesign FragmentTypeHeading3;
    public static FragmentTypeDesign FragmentTypeHeading4;
    public static FragmentTypeDesign FragmentTypeHeading5;
    
    public static DeductionOperationDesign AttributeBelongsToDeduction;
    public static DeductionOperationDesign CapitalizeFirstDeduction;
    public static DeductionOperationInputDesign CapitalizeFirstDeductionInput;
    public static DeductionOperationDesign DataTypeDataCategoryDeduction;
    public static DeductionOperationDesign DataTypeDataCategoryOptionsDeduction;
    public static DeductionOperationDesign DataTypeEntityDeduction;
    public static DeductionOperationDesign DataTypeJavaClassNameDeduction;
    public static DeductionOperationDesign DataTypeMultivalueDeduction;
    public static DeductionOperationDesign DefaultDesignNameDeduction;
    public static DeductionOperationDesign JavaIdentifierDeduction;
    public static DeductionOperationDesign ReverseJavaIdentifierDeduction;
    public static DeductionOperationDesign ReverseTechnicalNameDeduction;
    public static DeductionOperationDesign TechnicalNameDeduction;
    public static DeductionOperationDesign DeductionDiagramPositionDefaultDeduction;
	public static DeductionOperationDesign DeductionParameterValueDescriptionRuleDeduction;
	public static DeductionOperationDesign DeductionParameterValuesDescriptionRuleDeduction;
    
    public DesignerApplicationGenerator() {
        APPLICATION = this;
		getMetadata().getCaseAdministration().setIdGenerator(new SequencePerLabelIdGenerator()); // predictable Id's for better source control
        setName("Designer");
        setIsCustomized(true);
        setRootPackageName("org.instantlogic.designer");
        addDeductionOperations();
        setCaseEntity(ApplicationDesignEntityGenerator.ENTITY);
        setMainFlow(MainFlowGenerator.FLOW);
        setStartEvent(HomeEventGenerator.EVENT);
        addToThemeNames("margin");
        addToThemeNames("designer");

        init();
        
        addFragmentTypes();
    }
    
    private void addDeductionOperations() {
    	AttributeBelongsToDeduction = new DeductionOperationDesign();
    	addToCustomDeductionOperations(AttributeBelongsToDeduction);
    	AttributeBelongsToDeduction.setName("DataTypeDataCategoryOptions");
    	AttributeBelongsToDeduction.setJavaClassName("org.instantlogic.designer.deduction.AttributeBelongsToDeduction");
    	
    	CapitalizeFirstDeduction = new DeductionOperationDesign();
    	addToCustomDeductionOperations(CapitalizeFirstDeduction);
    	CapitalizeFirstDeduction.setName("CapitalizeFirst");
    	CapitalizeFirstDeduction.setJavaClassName("org.instantlogic.designer.deduction.CapitalizeFirstDeduction");
    	CapitalizeFirstDeduction.setOutputDataType(DataTypeDesign.text);
    	CapitalizeFirstDeductionInput = new DeductionOperationInputDesign();
    	CapitalizeFirstDeduction.addToInputs(CapitalizeFirstDeductionInput);
    	CapitalizeFirstDeductionInput.setName("Input");

    	DataTypeDataCategoryDeduction = new DeductionOperationDesign();
    	addToCustomDeductionOperations(DataTypeDataCategoryDeduction);
    	DataTypeDataCategoryDeduction.setName("DataTypeDataCategoryOptions");
    	DataTypeDataCategoryDeduction.setJavaClassName("org.instantlogic.designer.deduction.DataTypeDataCategoryDeduction");

    	DataTypeDataCategoryOptionsDeduction = new DeductionOperationDesign();
    	addToCustomDeductionOperations(DataTypeDataCategoryOptionsDeduction);
    	DataTypeDataCategoryOptionsDeduction.setName("DataTypeDataCategoryOptions");
    	DataTypeDataCategoryOptionsDeduction.setJavaClassName("org.instantlogic.designer.deduction.DataTypeDataCategoryOptionsDeduction");

    	DataTypeEntityDeduction = new DeductionOperationDesign();
    	addToCustomDeductionOperations(DataTypeEntityDeduction);
    	DataTypeEntityDeduction.setName("DataTypeDataCategoryOptions");
    	DataTypeEntityDeduction.setJavaClassName("org.instantlogic.designer.deduction.DataTypeEntityDeduction");

    	DataTypeJavaClassNameDeduction = new DeductionOperationDesign();
    	addToCustomDeductionOperations(DataTypeJavaClassNameDeduction);
    	DataTypeJavaClassNameDeduction.setName("DataTypeDataCategoryOptions");
    	DataTypeJavaClassNameDeduction.setJavaClassName("org.instantlogic.designer.deduction.DataTypeJavaClassNameDeduction");

    	DataTypeMultivalueDeduction = new DeductionOperationDesign();
    	addToCustomDeductionOperations(DataTypeMultivalueDeduction);
    	DataTypeMultivalueDeduction.setName("DataTypeDataCategoryOptions");
    	DataTypeMultivalueDeduction.setJavaClassName("org.instantlogic.designer.deduction.DataTypeMultivalueDeduction");

    	DefaultDesignNameDeduction = new DeductionOperationDesign();
    	addToCustomDeductionOperations(DefaultDesignNameDeduction);
    	DefaultDesignNameDeduction.setName("DataTypeDataCategoryOptions");
    	DefaultDesignNameDeduction.setJavaClassName("org.instantlogic.designer.deduction.DefaultDesignNameDeduction");

    	JavaIdentifierDeduction = new DeductionOperationDesign();
    	addToCustomDeductionOperations(JavaIdentifierDeduction);
    	JavaIdentifierDeduction.setName("DataTypeDataCategoryOptions");
    	JavaIdentifierDeduction.setJavaClassName("org.instantlogic.designer.deduction.JavaIdentifierDeduction");

    	ReverseJavaIdentifierDeduction = new DeductionOperationDesign();
    	addToCustomDeductionOperations(ReverseJavaIdentifierDeduction);
    	ReverseJavaIdentifierDeduction.setName("DataTypeDataCategoryOptions");
    	ReverseJavaIdentifierDeduction.setJavaClassName("org.instantlogic.designer.deduction.ReverseJavaIdentifierDeduction");

    	ReverseTechnicalNameDeduction = new DeductionOperationDesign();
    	addToCustomDeductionOperations(ReverseTechnicalNameDeduction);
    	ReverseTechnicalNameDeduction.setName("DataTypeDataCategoryOptions");
    	ReverseTechnicalNameDeduction.setJavaClassName("org.instantlogic.designer.deduction.ReverseTechnicalNameDeduction");

    	TechnicalNameDeduction = new DeductionOperationDesign();
    	addToCustomDeductionOperations(TechnicalNameDeduction);
    	TechnicalNameDeduction.setName("TechnicalName");
    	TechnicalNameDeduction.setJavaClassName("org.instantlogic.designer.deduction.TechnicalNameDeduction");
    	
    	DeductionDiagramPositionDefaultDeduction = new DeductionOperationDesign();
    	addToCustomDeductionOperations(DeductionDiagramPositionDefaultDeduction);
    	DeductionDiagramPositionDefaultDeduction.setName("DeductionDiagramPositionDefault");
    	DeductionDiagramPositionDefaultDeduction.setJavaClassName("org.instantlogic.designer.deduction.DeductionDiagramPositionDefaultDeduction");
    	
    	DeductionParameterValueDescriptionRuleDeduction = new DeductionOperationDesign();
    	addToCustomDeductionOperations(DeductionParameterValueDescriptionRuleDeduction);
    	DeductionParameterValueDescriptionRuleDeduction.setName("DeductionParameterValueDescriptionRuleDeduction");
    	DeductionParameterValueDescriptionRuleDeduction.setJavaClassName("org.instantlogic.designer.deduction.DeductionParameterValueDescriptionRuleDeduction");

    	DeductionParameterValuesDescriptionRuleDeduction = new DeductionOperationDesign();
    	addToCustomDeductionOperations(DeductionParameterValuesDescriptionRuleDeduction);
    	DeductionParameterValuesDescriptionRuleDeduction.setName("DeductionParameterValuesDescriptionRuleDeduction");
    	DeductionParameterValuesDescriptionRuleDeduction.setJavaClassName("org.instantlogic.designer.deduction.DeductionParameterValuesDescriptionRuleDeduction");
    
    }

	private void addFragmentTypes() {
    	FragmentTypeInput = (FragmentTypeDesign) new FragmentTypeDesign().setHasAttribute(true).setName("Input");
    	FragmentTypeButton = (FragmentTypeDesign) new FragmentTypeDesign().setHasEvent(true).setName("Button");
    	FragmentTypeLink = (FragmentTypeDesign) new FragmentTypeDesign().setHasEvent(true).setName("Link");
    	FragmentTypeParagraph = (FragmentTypeDesign) new FragmentTypeDesign().setName("Paragraph");
    	FragmentTypeHeading1 = (FragmentTypeDesign) new FragmentTypeDesign().setName("Heading1");
    	FragmentTypeHeading2 = (FragmentTypeDesign) new FragmentTypeDesign().setName("Heading2");
    	FragmentTypeHeading3 = (FragmentTypeDesign) new FragmentTypeDesign().setName("Heading3");
    	FragmentTypeHeading4 = (FragmentTypeDesign) new FragmentTypeDesign().setName("Heading4");
    	FragmentTypeHeading5 = (FragmentTypeDesign) new FragmentTypeDesign().setName("Heading5");
	}

	public static void main(String[] args) throws Exception {
/*		try (FileWriter fileWriter = new FileWriter(new File("../../webapps/nextdesigner/src/main/instantlogic-designs/nextdesigner.json"))) {
			new CasePersister().save(APPLICATION, fileWriter);
		}
		System.out.println("nextdesigner.json written");
*/		Generator.scanForInstantlogicDesigns(new File("../../webapps/nextdesigner"));
    }
}