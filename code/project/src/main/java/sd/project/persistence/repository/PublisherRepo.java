package sd.project.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sd.project.persistence.entity.Publisher;

public interface PublisherRepo extends JpaRepository<Publisher,Integer> {

}
