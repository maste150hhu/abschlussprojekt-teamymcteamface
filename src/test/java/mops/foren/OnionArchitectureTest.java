package mops.foren;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@AnalyzeClasses(packages = "mops.foren", importOptions = ImportOption.DontIncludeTests.class)
public class OnionArchitectureTest {
    @ArchTest
    public static final ArchRule ONION_ARCHITECTURE = onionArchitecture()
            .domainModels("..mops.foren.domain.model..")
            .domainServices("..mops.foren.domain..")
            .applicationServices("..mops.foren.applicationservices..")
            .adapter("web", "..mops.foren.infrastructure.web..")
            .adapter("persistence", "..mops.foren.infrastructure.persistence..");
}
