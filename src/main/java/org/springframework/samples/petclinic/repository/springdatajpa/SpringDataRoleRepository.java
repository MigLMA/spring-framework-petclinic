package org.springframework.samples.petclinic.repository.springdatajpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Role;
import org.springframework.samples.petclinic.repository.auth.RoleRepository;

/**
 * @author 628700
 * @since 04.10.2017
 */
public interface SpringDataRoleRepository extends RoleRepository, Repository<Role, Long> {

  @Override
  @Query("SELECT DISTINCT role FROM Roles WHERE role.RoleId = :roleId ")
  public Role findById(@Param("roleId") Long roleId);

}
