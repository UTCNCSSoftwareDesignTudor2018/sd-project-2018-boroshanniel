package sd.project.persistence.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ebooks")
public class EBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idebook;

    //relationships

    @ManyToOne
    @JoinColumn(name = "idBook")
    private Book book;

    //other DB columns

    @Column(columnDefinition = "VARCHAR(500)")
    private String ebookurl;

    //methods

    public Integer getIdebook() {
        return idebook;
    }

    public void setIdebook(Integer idebook) {
        this.idebook = idebook;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getEbookurl() {
        return ebookurl;
    }

    public void setEbookurl(String ebookurl) {
        this.ebookurl = ebookurl;
    }
}
