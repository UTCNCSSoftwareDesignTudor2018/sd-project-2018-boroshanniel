package sd.project.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sd.project.persistence.entity.EBook;

public interface EBookRepo extends JpaRepository<EBook,Integer> {
}
