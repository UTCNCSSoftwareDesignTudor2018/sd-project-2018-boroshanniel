package sd.project.business.services;

import org.springframework.stereotype.Service;
import sd.project.persistence.entity.Publisher;
import sd.project.persistence.repository.PublisherRepo;

import javax.inject.Inject;
import java.util.List;

@Service
public class PublisherService {

    @Inject
    PublisherRepo publisherRepo;

    public Publisher addNewPublisher(Publisher publisher){
        return publisherRepo.save(publisher);
    }

    public Publisher updatePublisher(Publisher publisher){
        return publisherRepo.save(publisher);
    }

    public List<Publisher> getAllPublishers(){
        return publisherRepo.findAll();
    }
}
