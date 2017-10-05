package org.springframework.samples.petclinic.service.auth;

import org.springframework.samples.petclinic.model.User;

public interface UserService {
  User findByUsername(String userName);

}
