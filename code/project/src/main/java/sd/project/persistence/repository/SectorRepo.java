package sd.project.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sd.project.persistence.entity.Sector;

public interface SectorRepo extends JpaRepository<Sector,Integer> {
}
