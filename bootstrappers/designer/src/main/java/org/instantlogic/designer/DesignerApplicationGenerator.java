/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer;

import java.io.File;
import java.io.FileWriter;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;
import org.instantlogic.designer.event.HomeEventGenerator;
import org.instantlogic.designer.flow.MainFlowGenerator;
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
    
    public DesignerApplicationGenerator() {
        APPLICATION = this;
		getMetadata().getCaseAdministration().setIdGenerator(new SequencePerLabelIdGenerator()); // predictable Id's for better source control
        setName("Designer");
        setRootPackageName("org.instantlogic.designer");
        setSourcePath("target/generated-sources/instantlogic-app");
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
		try (FileWriter fileWriter = new FileWriter(new File("../../webapps/nextdesigner/src/main/instantlogic-designs/designer.json"))) {
			new CasePersister().save(APPLICATION, fileWriter);
		}
		System.out.println("designer.json written");

//        GeneratedClassModels classModelUpdates = APPLICATION.getApplicationGenerator().getClassModelUpdates();
//        ApplicationJavacodeGenerator.generate(classModelUpdates, new File(APPLICATION.getSourcePath()));
    }
}