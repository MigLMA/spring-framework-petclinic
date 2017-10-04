package org.springframework.samples.petclinic.web.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.samples.petclinic.web.CrashControllerTests;
import org.springframework.samples.petclinic.web.OwnerControllerTests;
import org.springframework.samples.petclinic.web.PetControllerTests;
import org.springframework.samples.petclinic.web.PetTypeFormatterTests;
import org.springframework.samples.petclinic.web.VetControllerTests;
import org.springframework.samples.petclinic.web.VisitControllerTests;

@RunWith(Suite.class)
@SuiteClasses({CrashControllerTests.class, OwnerControllerTests.class, PetControllerTests.class,
    PetTypeFormatterTests.class, VetControllerTests.class, VisitControllerTests.class})
public class AllWebTests {

}
