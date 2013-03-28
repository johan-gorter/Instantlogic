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

import org.instantlogic.designer.deduction.DeductionDataTypeDeduction;


public class DeductionDesignEntityGenerator extends EntityDesign {

    public static final DeductionDesignEntityGenerator ENTITY = new DeductionDesignEntityGenerator();
    
    private DeductionDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("DeductionDesign");
        setIsCustomized(true);
    }

    // Relations
    public static final RelationDesign operation = addRelation(ENTITY, "operation", RelationType.ManyToZeroOrOne, DeductionOperationDesignEntityGenerator.ENTITY);

    public static final RelationDesign dataType = addRelation(ENTITY, "dataType", RelationType.ManyToZeroOrOne, DataTypeDesignEntityGenerator.ENTITY);
    
    public static final RelationDesign inputs = addRelation(ENTITY, "inputs", RelationType.OneToManyAggregation, DeductionInputDesignEntityGenerator.ENTITY)
    	.setReverseName("deduction");
    
    @Override
    public void init() {
    	dataType.setWriteable(false);
    	dataType.setRule(new DeductionSchemeDesign().deduceCustom(DeductionDataTypeDeduction.class, DataTypeDesign.class).getScheme());
    }
}