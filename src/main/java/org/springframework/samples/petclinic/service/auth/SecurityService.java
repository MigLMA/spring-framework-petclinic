package org.springframework.samples.petclinic.service.auth;

public interface SecurityService {
  String findLoggedInUsername();

  void autologin(String username, String password);
}
