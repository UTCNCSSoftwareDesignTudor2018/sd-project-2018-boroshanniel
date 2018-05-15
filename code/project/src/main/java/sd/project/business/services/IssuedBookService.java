package sd.project.business.services;

import sd.project.business.utility.Constants;
import sd.project.persistence.entity.Book;
import sd.project.persistence.entity.IssuedBook;
import sd.project.persistence.entity.Member;

import sd.project.persistence.repository.IssuedBookRepo;

import javax.inject.Inject;

import java.util.Date;
import java.util.List;

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

        if(issuedBook.getCompleted() == Constants.NONCOMPLETED){
            issuedBook.setCompleted(Constants.COMPLETED);
            issuedBookRepo.save(issuedBook);
            bookToRecover.updateStock(Constants.INCREMENT_STOCK);
            bookService.updateBook(bookToRecover);
        }
        if(issuedBook.getCompleted() == Constants.COMPLETED){
            return;
        }

    }

    public List<IssuedBook> getIssuedBooksOfMember(Member member){
        return issuedBookRepo.findAllByMember(member);
    }

    public List<IssuedBook> getMembersWithIssuedBook(Book book){
        return issuedBookRepo.findAllByBook(book);
    }

}
