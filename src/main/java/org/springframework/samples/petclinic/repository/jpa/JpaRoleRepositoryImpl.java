package org.springframework.samples.petclinic.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.samples.petclinic.model.Role;
import org.springframework.samples.petclinic.repository.auth.RoleRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 628700
 * @since 04.10.2017
 */
@Repository
public class JpaRoleRepositoryImpl implements RoleRepository {

  @PersistenceContext
  private EntityManager em;


  @Override
  public Role findById(Long roleId) {
    Query query =
        this.em.createQuery("SELECT DISTINCT role FROM Roles WHERE role.RoleId = :roleId LIMIT 1");
    query.setParameter("roleId", roleId);
    return (Role) query.getSingleResult();
  }

}
