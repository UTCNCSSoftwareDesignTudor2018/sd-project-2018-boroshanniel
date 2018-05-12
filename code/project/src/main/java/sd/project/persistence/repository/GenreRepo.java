package sd.project.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sd.project.persistence.entity.Genre;

public interface GenreRepo extends JpaRepository<Genre,Integer> {
}
