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

import org.instantlogic.designer.deduction.DefaultDesignNameDeduction;
import org.instantlogic.designer.deduction.JavaIdentifierDeduction;
import org.instantlogic.designer.deduction.TechnicalNameDeduction;


public class DesignEntityGenerator extends EntityDesign {

    public static final DesignEntityGenerator ENTITY = new DesignEntityGenerator();
    
    private DesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
    	setIsCustomized(true);
        setName("Design");
    }

    // Attributes
    public static final AttributeDesign name = addAttribute(ENTITY, "name", java.lang.String.class);
    public static final AttributeDesign javaIdentifier = addAttribute(ENTITY, "javaIdentifier", java.lang.String.class);
    public static final AttributeDesign technicalName = addAttribute(ENTITY, "technicalName", java.lang.String.class);
    public static final AttributeDesign isCustomized = addAttribute(ENTITY, "isCustomized", java.lang.Boolean.class);

    // Relations

    @Override
    public void init() {
    	super.init();
    	
    	name.setDefault(new DeductionSchemeDesign().deduceCustom(DefaultDesignNameDeduction.class, String.class).getScheme());
    	
    	DeductionSchemeDesign nameDeduction;
		newTitle().addToUntranslated(new StringTemplateDesign().setDeduction(nameDeduction = new DeductionSchemeDesign()));
		nameDeduction.deduceAttribute(name);
    	
		javaIdentifier.setWriteable(false);
		javaIdentifier.setRule(new DeductionSchemeDesign().deduceCustom(JavaIdentifierDeduction.class, String.class).getScheme());

		technicalName.setWriteable(false);
		technicalName.setRule(new DeductionSchemeDesign().deduceCustom(TechnicalNameDeduction.class, String.class).getScheme());
    }
}