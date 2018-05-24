package sd.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sd.project.business.services.EmailServiceImpl;
import sd.project.business.services.IssuedBookService;
import sd.project.business.services.UserService;
import sd.project.persistence.entity.Book;
import sd.project.persistence.entity.IssuedBook;
import sd.project.persistence.entity.Member;
import sd.project.persistence.repository.BookRepo;

import java.util.List;

@Controller
public class MemberAdministrationController {

    @Autowired
    UserService userService;

    @Autowired
    IssuedBookService issuedBookService;

    @Autowired
    EmailServiceImpl emailService;


    private ModelAndView mav;

    @GetMapping("/memberAdmPage")
    public ModelAndView memberAdmPage(@RequestParam(name="member")Member member){
        mav = new ModelAndView("memberAdmPage");
        mav.addObject("member",member);
        IssuedBook issuedBook = new IssuedBook();
        mav.addObject("issuedBook",issuedBook);
        List<IssuedBook> issuedBooks = issuedBookService.getIssuedBooksOfMember(member);
        mav.addObject("issuedBooks",issuedBooks);
        return mav;
    }

    @GetMapping(value = "/memberAdmPage",params = "Mark Completed")
    public ModelAndView recoverBook(@ModelAttribute("issuedBook")IssuedBook issuedBook, Model model){
        IssuedBook bookToRecover = issuedBookService.getIssuedBookById(issuedBook.getIdIssuedBooks());
        Member member = (Member)mav.getModel().get("member");
        issuedBookService.recoverBookFromMember(bookToRecover.getBook(),member);
        mav.getModel().replace("issuedBooks",issuedBookService.getIssuedBooksOfMember(member));
        return mav;
    }

    @GetMapping(value = "/memberAdmPage",params = "Send Email Notification")
    public ModelAndView sendEmail(@ModelAttribute("issuedBook")IssuedBook issuedBook,Model model){
        IssuedBook bookToNotify = issuedBookService.getIssuedBookById(issuedBook.getIdIssuedBooks());
        Member member = (Member)mav.getModel().get("member");
        String emailSubject = "Return the Book!";
        String emailBody = "We want to remind you, you have to bring back the book: " + bookToNotify.getBook().toString();
        emailService.sendSimpleMessage(member.getUser().getEmail(),emailSubject,emailBody);
        return mav;
    }



}
