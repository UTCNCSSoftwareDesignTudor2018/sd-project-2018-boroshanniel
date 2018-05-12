package sd.project.persistence.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGenre;

    @OneToMany(mappedBy = "genre")
    private List<Book> books;



    @Column(columnDefinition = "VARCHAR(200)")
    private String name;
}
