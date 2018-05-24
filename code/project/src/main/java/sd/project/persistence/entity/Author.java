package sd.project.persistence.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAuthor;

    //relationships

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "authorsbooks",
    joinColumns = { @JoinColumn(name = "idAuthor") },
    inverseJoinColumns = { @JoinColumn(name = "ISBN") }
    )
    private List<Book> books;

    //other DB columns

    @Column(columnDefinition = "VARCHAR(200)")
    private String name;

    //methods

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
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

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                '}';
    }
}
