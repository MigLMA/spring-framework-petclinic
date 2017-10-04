package org.springframework.samples.petclinic.service.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.samples.petclinic.service.ClinicServiceJdbcTests;
import org.springframework.samples.petclinic.service.ClinicServiceJpaTests;
import org.springframework.samples.petclinic.service.ClinicServiceSpringDataJpaTests;

@RunWith(Suite.class)
@SuiteClasses({ClinicServiceJdbcTests.class, ClinicServiceJpaTests.class,
    ClinicServiceSpringDataJpaTests.class})
public class AllServiceTests {

}
