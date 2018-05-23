package sd.project.business.services;

import org.springframework.stereotype.Service;
import sd.project.persistence.entity.*;
import sd.project.persistence.repository.BookRepo;
import sd.project.persistence.repository.MemberRepo;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Inject
    BookRepo bookRepo;

    @Inject
    IssuedBookService issuedBookService;

    public Book addNewBook(Book book){
        return bookRepo.save(book);
    }

    public Book updateBook(Book book){
        return bookRepo.save(book);
    }

    public Book getBookById(String isbn){
        return bookRepo.findById(isbn).get();
    }

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public List<Book> getAllBooksOfPublisher(Publisher publisher){
        return bookRepo.findAllByPublisher(publisher);
    }

    public List<Book> getAllBooksOfGenre(Genre genre){
        return bookRepo.findAllByGenre(genre);
    }

    public List<Book> getAllBooksOfAuthors(List<Author> authors){
        return bookRepo.findAllByAuthors(authors);
    }

    public List<Book> getAllBooksAvailableForMember(Member member){

        List<IssuedBook> alreadyIssuedBooks = issuedBookService.getIssuedBooksOfMember(member);
        List<Book> allBooks = bookRepo.findAllByStockGreaterThan(0);

        List<Book> notAvailableBooks = new ArrayList<>();
        for(IssuedBook ib: alreadyIssuedBooks){
            notAvailableBooks.add(ib.getBook());
        }

        allBooks.removeAll(notAvailableBooks);
        return allBooks;
    }
}
