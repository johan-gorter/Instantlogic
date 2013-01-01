package ${rootPackageName};

import java.io.File;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;


public class ${name}ApplicationGenerator extends ApplicationDesign {

    public static final ${name}ApplicationGenerator APPLICATION = new ${name}ApplicationGenerator();
    
    public ${name}ApplicationGenerator() {
        setName("${name}");
        setRootPackageName("${rootPackageName}");
        setSourcePath("${sourcePath}");
        setCaseEntity(${caseEntity.name}EntityGenerator.ENTITY);
        init();
    }
    
    public static void main(String[] args) throws Exception {
        ApplicationDesign applicationInstance = new ${name}ApplicationGenerator();
        GeneratedClassModels classModelUpdates = applicationInstance.getApplicationGenerator().getClassModelUpdates();
        ApplicationJavacodeGenerator.generate(classModelUpdates, new File(applicationInstance.getSourcePath()));
    }
    
}