package sd.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sd.project.business.services.*;
import sd.project.persistence.entity.Book;
import sd.project.persistence.entity.EBook;
import sd.project.persistence.entity.IssuedBook;
import sd.project.persistence.entity.User;

import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private UserService userService;

    @Autowired
    IssuedBookService issuedBookService;

    @Autowired
    BookService bookService;

    @Autowired
    EBookService eBookService;

    @Autowired
    EmailServiceImpl emailService;

    private ModelAndView mav;

    @GetMapping("/memberPage")
    public ModelAndView memberPage(@RequestParam(name="username")String username,
                                   @RequestParam(name="password")String password){

        try
        {
            User currentUser = userService.login(username,password);
            mav = new ModelAndView("memberPage");
            mav.addObject("user",currentUser);
            Book book = new Book();
            mav.addObject("book",book);
            List<IssuedBook> issuedBooks = issuedBookService.getIssuedBooksOfMember(currentUser.getMember());
            mav.addObject("issuedBooks",issuedBooks);
            List<Book> books = bookService.getAllBooksAvailableForMember(currentUser.getMember());
            mav.addObject("books",books);
            EBook eBook = new EBook();
            mav.addObject("ebook",eBook);
            List<EBook> ebooks = eBookService.getAllEBooks();
            mav.addObject("ebooks",ebooks);
        }catch (IllegalArgumentException iae){
            mav = new ModelAndView("errorPage");
            mav.addObject("error","Login failed! No user found");
        }
        finally{
            return mav;
        }
    }

    @PostMapping(value = "/memberPage",params="Change Email")
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

    @PostMapping(value = "/memberPage",params="Change phone number")
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

    @PostMapping(value = "/memberPage",params="Issue")
    public ModelAndView issue(@ModelAttribute("book")Book book,Model model)
    {
        //System.out.println(book);
        Book bk = bookService.getBookById(book.getISBN());
        User user = (User)mav.getModel().get("user");
        issuedBookService.issueBookToMember(bk,user.getMember());
        mav.getModel().replace("issuedBooks",issuedBookService.getIssuedBooksOfMember(user.getMember()));
        mav.getModel().replace("books",bookService.getAllBooksAvailableForMember(user.getMember()));
        return mav;
    }

    @PostMapping(value = "/memberPage",params="Send PDF")
    public ModelAndView issue(@ModelAttribute("book")EBook ebook, Model model)
    {
        //System.out.println(book);
        EBook ebk = eBookService.getEBookById(ebook.getIdebook());
        User user = (User)mav.getModel().get("user");

        String emailSubject = "Requested Book!";
        String emailBody = "We attached here the book you requested!";

        emailService.sendMessageWithAttachement(user.getEmail(),emailSubject,emailBody,ebk);

        return mav;
    }


}
