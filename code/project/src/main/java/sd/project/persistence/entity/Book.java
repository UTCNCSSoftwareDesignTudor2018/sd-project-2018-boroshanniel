package sd.project.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue
    private String ISBN;

    @ManyToOne
    @JoinColumn(name = "idGenre")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "idPublisher")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "idSector")
    private Sector sector;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

    @OneToMany(mappedBy = "book")
    private List<IssuedBook> issuedBooks;



    @Column(columnDefinition = "VARCHAR(200)")
    private String name;

    @Column(columnDefinition = "VARCHAR(500)")
    private String description;
}
