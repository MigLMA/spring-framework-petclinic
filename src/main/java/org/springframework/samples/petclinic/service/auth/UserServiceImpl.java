package org.springframework.samples.petclinic.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.User;
import org.springframework.samples.petclinic.repository.auth.UserRepository;

public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public User findByUsername(String userName) {
    return this.userRepository.findByUsername(userName);
  }

}
