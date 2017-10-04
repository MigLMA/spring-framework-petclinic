package org.springframework.samples.petclinic.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.samples.petclinic.model.suite.AllModelTests;
import org.springframework.samples.petclinic.service.suite.AllServiceTests;
import org.springframework.samples.petclinic.web.suite.AllWebTests;

@RunWith(Suite.class)
@SuiteClasses({AllModelTests.class, AllServiceTests.class, AllWebTests.class})
public class AllTests {

}
