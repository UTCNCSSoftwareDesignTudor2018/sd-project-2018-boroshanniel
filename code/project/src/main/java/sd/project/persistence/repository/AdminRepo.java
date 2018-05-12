package sd.project.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sd.project.persistence.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin,Integer> {
}
