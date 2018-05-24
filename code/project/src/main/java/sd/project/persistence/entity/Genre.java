package sd.project.persistence.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genres")
public class Genre {

    //id

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGenre;

    //relationships

    @OneToMany(mappedBy = "genre")
    private List<Book> books;

    //other DB columns

    @Column(columnDefinition = "VARCHAR(200)")
    private String name;

    //methods

    public Integer getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Integer idGenre) {
        this.idGenre = idGenre;
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
        return "Genre{" +
                "name='" + name + '\'' +
                '}';
    }
}
