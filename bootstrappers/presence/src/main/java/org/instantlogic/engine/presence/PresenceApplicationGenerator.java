package org.instantlogic.engine.presence;

import java.io.File;
import java.io.FileWriter;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.DeductionOperationDesign;
import org.instantlogic.designer.tools.Generator;
import org.instantlogic.engine.presence.flow.MainFlowGenerator;
import org.instantlogic.fabric.util.id.SequencePerLabelIdGenerator;
import org.instantlogic.tools.persistence.json.CasePersister;

public class PresenceApplicationGenerator extends ApplicationDesign {

	public static final DeductionOperationDesign UserNameDefaultDeduction = new DeductionOperationDesign();
	public static final DeductionOperationDesign UserAvatarUrlDefaultDeduction  = new DeductionOperationDesign();
	public static final DeductionOperationDesign IsMeDeduction  = new DeductionOperationDesign();
    
	public static PresenceApplicationGenerator APPLICATION = new PresenceApplicationGenerator();

    public PresenceApplicationGenerator() {
    	APPLICATION = this;
		getMetadata().getCaseAdministration().setIdGenerator(new SequencePerLabelIdGenerator()); // predictable Id's for better source control
    	addToCustomDeductionOperations(UserNameDefaultDeduction);
		UserNameDefaultDeduction.setJavaClassName("org.instantlogic.engine.presence.deduction.UserNameDefaultDeduction");
		addToCustomDeductionOperations(UserAvatarUrlDefaultDeduction);
		UserAvatarUrlDefaultDeduction.setJavaClassName("org.instantlogic.engine.presence.deduction.UserAvatarUrlDefaultDeduction");
		addToCustomDeductionOperations(IsMeDeduction);
		IsMeDeduction.setJavaClassName("org.instantlogic.engine.presence.deduction.IsMeDeduction");
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
