package sd.project.business.services;

import org.springframework.stereotype.Service;
import sd.project.persistence.entity.EBook;
import sd.project.persistence.repository.EBookRepo;

import javax.inject.Inject;
import java.util.List;

@Service
public class EBookService {

    @Inject
    EBookRepo eBookRepo;

    public List<EBook> getAllEBooks(){
        return eBookRepo.findAll();
    }

    public EBook getEBookById(Integer id){
        return eBookRepo.findById(id).get();
    }

}
