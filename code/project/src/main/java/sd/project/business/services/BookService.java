package sd.project.business.services;

import org.springframework.stereotype.Service;
import sd.project.persistence.entity.Author;
import sd.project.persistence.entity.Book;
import sd.project.persistence.entity.Genre;
import sd.project.persistence.entity.Publisher;
import sd.project.persistence.repository.BookRepo;

import javax.inject.Inject;
import java.util.List;

@Service
public class BookService {

    @Inject
    BookRepo bookRepo;

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

}
