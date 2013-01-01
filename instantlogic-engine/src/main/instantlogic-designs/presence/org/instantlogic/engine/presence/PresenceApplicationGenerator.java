package org.instantlogic.engine.presence;

import java.io.File;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;
import org.instantlogic.engine.presence.flow.MainFlowGenerator;

public class PresenceApplicationGenerator extends ApplicationDesign {

    public static PresenceApplicationGenerator APPLICATION = new PresenceApplicationGenerator();
    
    public PresenceApplicationGenerator() {
    	APPLICATION = this;
        setName("Presence");
        setRootPackageName("org.instantlogic.engine.presence");
        setSourcePath("target/generated-sources/instantlogic-app");
        setCaseEntity(PresenceEntityGenerator.ENTITY);
        setMainFlow(MainFlowGenerator.FLOW);

        init();
    }
    
    public static void main(String[] args) throws Exception {
        GeneratedClassModels classModelUpdates = APPLICATION.getApplicationGenerator().getClassModelUpdates();
        ApplicationJavacodeGenerator.generate(classModelUpdates, new File(APPLICATION.getSourcePath()));
    }

}
