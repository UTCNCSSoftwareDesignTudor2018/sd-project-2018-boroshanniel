package sd.project.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sd.project.persistence.entity.Member;

public interface MemberRepo extends JpaRepository<Member,Integer> {
}
