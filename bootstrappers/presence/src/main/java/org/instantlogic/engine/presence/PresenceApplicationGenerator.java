/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.engine.presence;

import java.io.File;
import java.io.FileWriter;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.DeductionOperationDesign;
import org.instantlogic.engine.presence.flow.MainFlowGenerator;
import org.instantlogic.fabric.util.id.SequencePerLabelIdGenerator;
import org.instantlogic.tools.generator.Generator;
import org.instantlogic.tools.persistence.json.CasePersister;

public class PresenceApplicationGenerator extends ApplicationDesign {

	public static final DeductionOperationDesign UserNameDefaultDeduction = new DeductionOperationDesign();
	public static final DeductionOperationDesign UserAvatarUrlDefaultDeduction  = new DeductionOperationDesign();
    
	public static PresenceApplicationGenerator APPLICATION = new PresenceApplicationGenerator();

    public PresenceApplicationGenerator() {
    	APPLICATION = this;
		getMetadata().getCaseAdministration().setIdGenerator(new SequencePerLabelIdGenerator()); // predictable Id's for better source control
    	addToCustomDeductionOperations(UserNameDefaultDeduction);
		UserNameDefaultDeduction.setJavaClassName("org.instantlogic.engine.presence.deduction.UserNameDefaultDeduction");
		addToCustomDeductionOperations(UserAvatarUrlDefaultDeduction);
		UserAvatarUrlDefaultDeduction.setJavaClassName("org.instantlogic.engine.presence.deduction.UserAvatarUrlDefaultDeduction");
        setName("Presence");
        setRootPackageName("org.instantlogic.engine.presence");
        setSourcePath("target/generated-sources/instantlogic-app");
        setCaseEntity(PresenceEntityGenerator.ENTITY);
        setMainFlow(MainFlowGenerator.FLOW);

        init();
    }
    
    public static void main(String[] args) throws Exception {
		try (FileWriter fileWriter = new FileWriter(new File("../../instantlogic-engine/src/main/instantlogic-designs/presence.json"))) {
			new CasePersister().save(APPLICATION, fileWriter);
		}
		System.out.println("presence.json written");
		Generator.scanForInstantlogicDesigns(new File("../../instantlogic-engine"));
    }
}
