package sd.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping(value = "/memberLogin")
    public String memberLogin(){
        return "memberLogin";
    }
}
