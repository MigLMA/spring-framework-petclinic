package org.springframework.samples.petclinic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@ComponentScan("org.springframework.samples.petclinic.service.auth")
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  public static final String ROLE_ADMIN = "ADMIN";
  public static final String ROLE_USER = "USER";

  @Autowired
  private UserDetailsService userDetailsService;

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // @formatter:off

    // logged-in
    http.authorizeRequests()
      // Matchers & allowed roles per matcher
      .antMatchers("/resources/**").permitAll()
      .antMatchers("/").hasRole(WebSecurityConfig.ROLE_USER)
//    .antMatchers("/admin").hasRole(WebSecurityConfig.ROLE_ADMIN)
      // EACH ENDPOINT:
      // CrashController endpoints
      .antMatchers("/oups").hasRole(WebSecurityConfig.ROLE_USER)
      // OwnerController endpoints
      .antMatchers("/owners/new").hasRole(WebSecurityConfig.ROLE_ADMIN)
      .antMatchers("/owners/find").hasRole(WebSecurityConfig.ROLE_USER)
      .antMatchers("/owners").hasRole(WebSecurityConfig.ROLE_USER)
      .antMatchers("/owners/*/edit").hasRole(WebSecurityConfig.ROLE_ADMIN)
      .antMatchers("/owners/*").hasRole(WebSecurityConfig.ROLE_USER)
      // PetController
      .antMatchers("/owners/*/pets/new").hasRole(WebSecurityConfig.ROLE_ADMIN)
      .antMatchers("/owners/*/pets/*/edit").hasRole(WebSecurityConfig.ROLE_ADMIN)
      // VetController
      .antMatchers("/vets.html").hasRole(WebSecurityConfig.ROLE_USER)
      .antMatchers("/vets.json").hasRole(WebSecurityConfig.ROLE_USER)
      .antMatchers("/vets.xml").hasRole(WebSecurityConfig.ROLE_USER)
      // VisitController
      .antMatchers("/owners/*/pets/*/visits/new").hasRole(WebSecurityConfig.ROLE_ADMIN)
      .antMatchers("/owners/*/pets/*/visits").hasRole(WebSecurityConfig.ROLE_USER)
      //
      // All requests must be authenticated
    .anyRequest().authenticated()
      // All unauthenticated users are granted access to login and logout pages
      .and()
    .formLogin().loginPage("/login").permitAll()
      .and()
    .logout().permitAll();

    // @formatter:on
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
  }

  @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
}
