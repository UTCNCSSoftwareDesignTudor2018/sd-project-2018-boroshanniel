package sd.project.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sd.project.persistence.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {


}
