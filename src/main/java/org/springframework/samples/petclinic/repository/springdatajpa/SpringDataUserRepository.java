package org.springframework.samples.petclinic.repository.springdatajpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.User;
import org.springframework.samples.petclinic.repository.UserRepository;

/**
 * @author 628700
 * @since 04.10.2017
 */
public interface SpringDataUserRepository extends UserRepository, Repository<User, Long> {

    @Override
    @Query("SELECT DISTINCT user FROM Users WHERE user.username LIKE :userName% LIMIT 1")
    public User findByUsername(@Param("userName") String userName);

}
