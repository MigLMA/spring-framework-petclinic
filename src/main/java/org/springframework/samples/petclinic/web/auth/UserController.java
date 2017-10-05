package org.springframework.samples.petclinic.web.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller used to perform authentication tasks
 *
 * @author 628700
 */
@Controller
public class UserController {

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login(Model model, String error, String logout) {
    if (error != null)
      model.addAttribute("error", "Your username and password is invalid.");

    if (logout != null)
      model.addAttribute("message", "You have been logged out successfully.");

    return "login";
  }

  @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
  public String welcome(Model model) {
    return "welcome";
  }

}
