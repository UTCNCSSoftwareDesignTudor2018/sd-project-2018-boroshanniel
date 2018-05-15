package sd.project.business.services;

import org.springframework.stereotype.Service;
import sd.project.persistence.entity.Genre;
import sd.project.persistence.repository.GenreRepo;

import javax.inject.Inject;
import java.util.List;

@Service
public class GenreService {

    @Inject
    GenreRepo genreRepo;

    public Genre addNewGenre(Genre genre){
        return genreRepo.save(genre);
    }

    public Genre updateGenre(Genre genre){
        return genreRepo.save(genre);
    }

    public List<Genre> getAllGenres(){
        return genreRepo.findAll();
    }

}
