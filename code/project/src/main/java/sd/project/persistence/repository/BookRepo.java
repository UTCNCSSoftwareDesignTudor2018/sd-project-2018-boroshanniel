package sd.project.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sd.project.persistence.entity.Book;

public interface BookRepo extends JpaRepository<Book,String> {

}
