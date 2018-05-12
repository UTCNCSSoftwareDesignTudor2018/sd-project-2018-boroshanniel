package sd.project.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sd.project.persistence.entity.Author;

public interface AuthorRepo extends JpaRepository<Author,Integer> {
}
