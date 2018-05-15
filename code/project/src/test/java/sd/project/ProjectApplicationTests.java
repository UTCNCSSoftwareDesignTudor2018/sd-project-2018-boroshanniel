package sd.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sd.project.business.services.*;
import sd.project.persistence.entity.*;
import sd.project.persistence.repository.MemberRepo;
import sd.project.persistence.repository.UserRepo;

import javax.inject.Inject;
import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectApplicationTests {

    @Inject
    UserRepo userRepo;
    @Inject
    MemberRepo memberRepo;

    @Inject
    UserService userService;

    @Inject
    BookService bookService;
    @Inject
    GenreService genreService;
    @Inject
    PublisherService publisherService;
    @Inject
    AuthorService authorService;
    @Inject
    SectorService sectorService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void persistenceUserTest(){
        //test admin

        User user = new User();
        user.setFlag(1);
        user.setCnp("1234567891111");
        user.setEmail("email");
        user.setUsername("paul");
        user.setPassword("123");
        user.setName("gordan paul");
        user.setPhoneNumber("1234567891111");

        Member member = new Member();
        member.setUser(user);

        user.setMember(member);

        userRepo.save(user);
        memberRepo.save(member);
	}

	@Test
    public void persistenceBookTest(){

        Sector sector = new Sector();
        Genre genre = new Genre();
        Publisher publisher = new Publisher();
        Author author = new Author();
        Book book = new Book();

        sector.setName("sector1");
        genre.setName("genre1");
        publisher.setName("publisher1");
        author.setName("author1");

        genreService.addNewGenre(genre);
        sectorService.addNewSector(sector);
        publisherService.addNewPublisher(publisher);
        authorService.addNewAuthor(author);
    }

	@Test
	public void loginTest(){

	    User toLogin;

	    toLogin = userService.login("paul","123");
        if(toLogin!=null)
	        System.out.println(toLogin.toString());
    }

    @Test
    public void pesistenceBookTest(){

	    Sector sector = new Sector();
	    Genre genre = new Genre();
        Publisher publisher = new Publisher();
        Author author = new Author();
        Book book = new Book();

        sector.setName("sector1");
        genre.setName("genre1");
        publisher.setName("publisher1");
        author.setName("author1");

        book.setStock(1);

        List<Author> authorslist = new ArrayList<>();
        authorslist.add(author);
        book.setAuthors(authorslist);
        //author.addBook(book);

        List<Book> bookslist = new ArrayList<>();
        bookslist.add(book);

        book.setGenre(genre);
        genre.setBooks(bookslist);

        book.setPublisher(publisher);
        publisher.setBooks(bookslist);

        book.setSector(sector);
        sector.setBooks(bookslist);

        book.setISBN("1234567891111");

        genreService.addNewGenre(genre);
        sectorService.addNewSector(sector);
        publisherService.addNewPublisher(publisher);
        authorService.addNewAuthor(author);
        bookService.addNewBook(book);

    }
}

