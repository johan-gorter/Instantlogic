package org.instantlogic.engine.presence;

import java.io.File;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.DeductionOperationDesign;
import org.instantlogic.designer.tools.Generator;
import org.instantlogic.designer.util.DesignerCasePersister;
import org.instantlogic.engine.presence.placetemplate.TravelerPlaceTemplateGenerator;
import org.instantlogic.fabric.util.id.SequencePerLabelIdGenerator;

public class PresenceApplicationGenerator extends ApplicationDesign {

	public static final DeductionOperationDesign UserNameDefaultDeduction = new DeductionOperationDesign();
	public static final DeductionOperationDesign UserAvatarUrlDefaultDeduction  = new DeductionOperationDesign();
	public static final DeductionOperationDesign IsMeDeduction  = new DeductionOperationDesign();
    
	public static PresenceApplicationGenerator APPLICATION = new PresenceApplicationGenerator();

    public PresenceApplicationGenerator() {
    	APPLICATION = this;
		getMetadata().getCaseAdministration().setIdGenerator(new SequencePerLabelIdGenerator()); // predictable Id's for better source control
    	addToCustomDeductionOperations(UserNameDefaultDeduction);
    	UserNameDefaultDeduction.setName("userNameDefault");
		UserNameDefaultDeduction.setJavaClassName("org.instantlogic.engine.presence.deduction.UserNameDefaultDeduction");
		addToCustomDeductionOperations(UserAvatarUrlDefaultDeduction);
		UserAvatarUrlDefaultDeduction.setName("userAvatarUrlDefault");
		UserAvatarUrlDefaultDeduction.setJavaClassName("org.instantlogic.engine.presence.deduction.UserAvatarUrlDefaultDeduction");
		addToCustomDeductionOperations(IsMeDeduction);
		IsMeDeduction.setName("isMe");
		IsMeDeduction.setJavaClassName("org.instantlogic.engine.presence.deduction.IsMeDeduction");
        setName("Presence");
        setRootPackageName("org.instantlogic.engine.presence");
        setCaseEntity(PresenceEntityGenerator.ENTITY);
        setStartPlace(TravelerPlaceTemplateGenerator.PLACE);

        init();
    }
    
    public static void main(String[] args) throws Exception {
		new DesignerCasePersister().save(APPLICATION, new File("../../instantlogic-engine/src/main/instantlogic-designs/presence/"), null);

		System.out.println("presence written");
		Generator.scanForInstantlogicDesigns(new File("../../instantlogic-engine"));
    }
}
