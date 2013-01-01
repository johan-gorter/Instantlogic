package org.instantlogic.designer;

import java.io.File;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;
import org.instantlogic.designer.event.HomeEventGenerator;
import org.instantlogic.designer.flow.MainFlowGenerator;


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
    
    public DesignerApplicationGenerator() {
        APPLICATION = this;
        setName("Designer");
        setRootPackageName("org.instantlogic.designer");
        setSourcePath("target/generated-sources/instantlogic-app");
        setCaseEntity(ApplicationDesignEntityGenerator.ENTITY);
        setMainFlow(MainFlowGenerator.FLOW);
        setStartEvent(HomeEventGenerator.EVENT);
        addToThemeNames("margin");
        addToThemeNames("designer");

        init();
        
        addFragmentTypes();
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
        GeneratedClassModels classModelUpdates = APPLICATION.getApplicationGenerator().getClassModelUpdates();
        ApplicationJavacodeGenerator.generate(classModelUpdates, new File(APPLICATION.getSourcePath()));
    }
}