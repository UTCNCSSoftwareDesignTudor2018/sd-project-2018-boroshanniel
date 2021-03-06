package sd.project.persistence.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sectors")
public class Sector {

    //id

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSector;

    //relationships

    @OneToMany(mappedBy = "sector")
    private List<Book> books;

    //other DB columns

    @Column(columnDefinition = "VARCHAR(200)")
    private String name;

    //methods

    public Integer getIdSector() {
        return idSector;
    }

    public void setIdSector(Integer idSector) {
        this.idSector = idSector;
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
        return "Sector{" +
                "name='" + name + '\'' +
                '}';
    }
}
