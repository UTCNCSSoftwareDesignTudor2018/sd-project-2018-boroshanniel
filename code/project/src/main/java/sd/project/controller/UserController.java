package sd.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sd.project.business.services.UserService;
import sd.project.business.utility.Constants;
import sd.project.persistence.entity.User;

import javax.inject.Inject;

@Controller
public class UserController {

    @Inject
    UserService userService;



}
