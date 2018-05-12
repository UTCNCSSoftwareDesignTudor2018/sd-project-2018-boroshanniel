package sd.project.persistence.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAuthor;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "authorsbooks",
    joinColumns = { @JoinColumn(name = "idAuthor") },
    inverseJoinColumns = { @JoinColumn(name = "ISBN") }
    )
    private List<Book> books;



    @Column(columnDefinition = "VARCHAR(200)")
    private String name;
}
