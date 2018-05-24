package sd.project.business.services;

import org.springframework.stereotype.Service;
import sd.project.business.utility.Constants;
import sd.project.persistence.entity.Book;
import sd.project.persistence.entity.IssuedBook;
import sd.project.persistence.entity.Member;

import sd.project.persistence.repository.IssuedBookRepo;

import javax.inject.Inject;

import java.util.Date;
import java.util.List;

@Service
public class IssuedBookService {

    @Inject
    IssuedBookRepo issuedBookRepo;
    @Inject
    BookService bookService;

    public void issueBookToMember(Book bookToIssue, Member member){

        Date issueDate = new Date();
        //get today's date;
        Date dueDate = new Date();


        IssuedBook newIssuedBook = new IssuedBook();
        newIssuedBook.setBook(bookToIssue);
        newIssuedBook.setMember(member);

        newIssuedBook.setIssueDate(issueDate);
        newIssuedBook.setDueDate(dueDate);

        issuedBookRepo.save(newIssuedBook);

        //update the book stock
        bookToIssue.updateStock(Constants.DECREMENT_STOCK);
        bookService.updateBook(bookToIssue);
    }

    public void recoverBookFromMember(Book bookToRecover, Member member){

        IssuedBook issuedBook = issuedBookRepo.findByBookAndMember(bookToRecover,member);

        issuedBook.setCompleted(Constants.COMPLETED);
        issuedBookRepo.save(issuedBook);
        bookToRecover.updateStock(Constants.INCREMENT_STOCK);
        bookService.updateBook(bookToRecover);
    }

    public List<IssuedBook> getIssuedBooksOfMember(Member member){
        return issuedBookRepo.findAllByMemberAndCompleted(member,0);
    }

    public List<IssuedBook> getMembersWithIssuedBook(Book book){
        return issuedBookRepo.findAllByBook(book);
    }

    public IssuedBook getIssuedBookById(Integer id){
        return issuedBookRepo.findById(id).get();
    }
}
