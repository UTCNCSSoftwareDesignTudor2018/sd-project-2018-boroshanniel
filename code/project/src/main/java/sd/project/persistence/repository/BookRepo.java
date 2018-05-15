package sd.project.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sd.project.persistence.entity.*;

import java.util.List;

public interface BookRepo extends JpaRepository<Book,String> {

    List<Book> findAllByPublisher(Publisher publisher);

    List<Book> findAllByGenre(Genre genre);

    List<Book> findAllByAuthors(List<Author> authors);

}
