package org.springframework.samples.petclinic.repository.auth;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.User;

/**
 * Repository class for <code>User</code> domain objects All method names are compliant with Spring
 * Data naming conventions so this interface can easily be extended for Spring Data See here:
 * http://static.springsource.org/spring-data/jpa/docs/current/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
 *
 * @author 628700
 */
public interface UserRepository {

  /**
   * Retrieve <code>User</code>s from the data store by user name, returning all users whose
   * username <i>is</i> the given name.
   *
   * @param userName Value to search for
   * @return a matching <code>User</code> (or an empty <code>User</code> if none found)
   */
  User findByUsername(String userName) throws DataAccessException;


}
