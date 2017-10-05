package org.springframework.samples.petclinic.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.samples.petclinic.model.User;
import org.springframework.samples.petclinic.repository.auth.UserRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 628700
 * @since 04.10.2017
 */
@Repository
public class JpaUserRepositoryImpl implements UserRepository {

  @PersistenceContext
  private EntityManager em;


  @Override
  public User findByUsername(String userName) {
    Query query = this.em
        .createQuery("SELECT DISTINCT user FROM Users WHERE user.Username = :userName LIMIT 1");
    query.setParameter("userName", userName);
    return (User) query.getSingleResult();
  }

}
