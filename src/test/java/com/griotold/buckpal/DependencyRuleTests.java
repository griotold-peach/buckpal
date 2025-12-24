package com.griotold.buckpal;

import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.griotold.buckpal.archunit.HexagonalArchitecture;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

class DependencyRuleTests {

    /**
     * 헥사고날 아키텍처 전체 검증
     */
    @Disabled
    @Test
    void validateHexagonalArchitecture() {
        HexagonalArchitecture.boundedContext("com.griotold.buckpal.account")
            
            .withDomainLayer("domain")
            
            .withAdaptersLayer("adapter")
                .incoming("in.web")
                .outgoing("out.persistence")
                .and()
            
            .withApplicationLayer("application")
                .services("service")
                .incomingPorts("port.in")
                .outgoingPorts("port.out")
                .and()
            
            .withConfiguration("configuration")
            
            .check(new ClassFileImporter()
                .importPackages("com.griotold.buckpal.."));
    }

    /**
     * Domain은 Application에 의존하면 안 됨
     */
    @Test
    void domainShouldNotDependOnApplication() {
        noClasses()
            .that()
            .resideInAPackage("com.griotold.buckpal..domain..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("com.griotold.buckpal..application..")
            .check(new ClassFileImporter()
                .importPackages("com.griotold.buckpal.."));
    }

    /**
     * Domain은 Adapter에 의존하면 안 됨
     */
    @Test
    void domainShouldNotDependOnAdapter() {
        noClasses()
            .that()
            .resideInAPackage("com.griotold.buckpal..domain..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("com.griotold.buckpal..adapter..")
            .check(new ClassFileImporter()
                .importPackages("com.griotold.buckpal.."));
    }

    /**
     * Domain은 Spring에 의존하면 안 됨
     */
    @Test
    void domainShouldNotDependOnSpring() {
        noClasses()
            .that()
            .resideInAPackage("com.griotold.buckpal..domain..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("org.springframework..")
            .check(new ClassFileImporter()
                .importPackages("com.griotold.buckpal.."));
    }

    /**
     * Domain은 JPA에 의존하면 안 됨
     */
    @Test
    void domainShouldNotDependOnJPA() {
        noClasses()
            .that()
            .resideInAPackage("com.griotold.buckpal..domain..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("jakarta.persistence..")
            .check(new ClassFileImporter()
                .importPackages("com.griotold.buckpal.."));
    }
}
