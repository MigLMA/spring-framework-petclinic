package org.springframework.samples.petclinic.repository.auth;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Role;

/**
 * Repository class for <code>Role</code> domain objects All method names are compliant with Spring
 * Data naming conventions so this interface can easily be extended for Spring Data See here:
 * http://static.springsource.org/spring-data/jpa/docs/current/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
 *
 * @author 628700
 */
public interface RoleRepository {

  /**
   * Retrieve <code>Role</code>s from the data store by role Id, returning all roles whose id
   * <i>is</i> the given id.
   *
   * @param roleId Value to search for
   * @return a matching <code>Role</code> (or an empty <code>Role</code> if none found)
   */
  Role findById(Long roleId) throws DataAccessException;


}
