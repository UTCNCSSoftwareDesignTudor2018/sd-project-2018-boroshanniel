package sd.project.persistence.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "publishers")
public class Publisher {

    //id

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPublisher;

    //relationships

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

    //other DB columns

    @Column(columnDefinition = "VARCHAR(200)")
    private String name;

    //methods

    public Integer getIdPublisher() {
        return idPublisher;
    }

    public void setIdPublisher(Integer idPublisher) {
        this.idPublisher = idPublisher;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBook(Book book){
        books.add(book);
    }
}
