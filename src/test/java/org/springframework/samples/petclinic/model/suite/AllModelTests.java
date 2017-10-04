package org.springframework.samples.petclinic.model.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.samples.petclinic.model.ValidatorTests;

@RunWith(Suite.class)
@SuiteClasses({ValidatorTests.class})
public class AllModelTests {

}
