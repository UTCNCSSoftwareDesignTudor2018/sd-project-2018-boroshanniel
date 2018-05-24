package sd.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sd.project.business.services.MemberService;
import sd.project.business.services.UserService;
import sd.project.persistence.entity.*;

import javax.inject.Inject;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    MemberService memberService;

    private ModelAndView mav;


    @GetMapping("/adminPage")
    public ModelAndView adminPage(@RequestParam(name = "username") String username,
                                  @RequestParam(name = "password") String password) {
        try {
            User currentUser = userService.login(username, password);
            mav = new ModelAndView("adminPage");
            mav.addObject("user", currentUser);

            Member member = new Member();
            mav.addObject("member", member);
            List<Member> members = memberService.getAllMembers();
            mav.addObject("members", members);
        } catch (IllegalArgumentException iae) {
            mav = new ModelAndView("errorPage");
            mav.addObject("error", "Login failed! No user found");
        } finally {
            return mav;
        }
    }

    @PostMapping(value="/adminPage", params = "Change Email")
    public ModelAndView updateEmail(@RequestParam(name="email")String email){

        User user = (User)mav.getModel().get("user");
        user.setEmail(email);
        try {
            userService.updateUser(user);
        }catch (IllegalArgumentException iae){
            mav = new ModelAndView("errorPage");
            mav.addObject("error","Update failed!" + iae.getMessage());
        }
        return mav;
    }

    @PostMapping(value = "/adminPage",params="Change phone number")
    public ModelAndView updatePhoneNumber(@RequestParam(name="phoneNumber")String phoneNumber){
        User user = (User)mav.getModel().get("user");
        user.setPhoneNumber(phoneNumber);
        try {
            userService.updateUser(user);
        }catch (IllegalArgumentException iae){
            mav = new ModelAndView("errorPage");
            mav.addObject("error","Update failed!" + iae.getMessage());
        }
        return mav;
    }

    @PostMapping(value = "/adminPage", params = "Edit member")
    public String editMember(@ModelAttribute("member")Member member, Model model, RedirectAttributes ra){
        ra.addAttribute("member",memberService.getMemberById(member.getIdMember()));
        return "redirect:memberAdmPage";
    }
}

