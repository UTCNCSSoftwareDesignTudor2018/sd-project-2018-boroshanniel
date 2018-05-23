package sd.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sd.project.business.services.AdminService;
import sd.project.business.services.UserService;
import sd.project.persistence.entity.Admin;
import sd.project.persistence.entity.User;

import javax.inject.Inject;

@Controller
public class AdminController {

    @Inject
    UserService userService;

}
