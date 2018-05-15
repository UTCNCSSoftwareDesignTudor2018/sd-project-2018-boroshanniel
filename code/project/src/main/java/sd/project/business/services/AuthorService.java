package sd.project.business.services;

import org.springframework.stereotype.Service;
import sd.project.persistence.entity.Author;
import sd.project.persistence.repository.AuthorRepo;

import javax.inject.Inject;
import java.util.List;

@Service
public class AuthorService {

    @Inject
    AuthorRepo authorRepo;

    public Author addNewAuthor(Author author){
        return authorRepo.save(author);
    }

    public Author updateAuthor(Author author){
        return authorRepo.save(author);
    }

    public List<Author> getAllAuthors(){
        return authorRepo.findAll();
    }
}
