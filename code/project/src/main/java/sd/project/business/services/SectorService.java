package sd.project.business.services;

import org.springframework.stereotype.Service;
import sd.project.persistence.entity.Sector;
import sd.project.persistence.repository.SectorRepo;

import javax.inject.Inject;
import java.util.List;

@Service
public class SectorService {

    @Inject
    SectorRepo sectorRepo;

    public Sector addNewSector(Sector sector){
        return sectorRepo.save(sector);
    }

    public Sector updateSector(Sector sector){
        return sectorRepo.save(sector);
    }

    public List<Sector> getAllSector(){
        return sectorRepo.findAll();
    }
}
