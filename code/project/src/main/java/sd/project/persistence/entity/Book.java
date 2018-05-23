package sd.project.persistence.entity;

import sd.project.business.utility.Constants;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(columnDefinition = "CHAR(13)")
    private String ISBN;

    //relationships

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

    @OneToMany(mappedBy = "book")
    private List<EBook> ebooks;

    //other DB columns

    @Column(columnDefinition = "VARCHAR(200)")
    private String name;

    //ki lehet szedni
    @Column(columnDefinition = "VARCHAR(500)")
    private String description;

    @Column
    private Integer stock;

    //methods

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<IssuedBook> getIssuedBooks() {
        return issuedBooks;
    }

    public void setIssuedBooks(List<IssuedBook> issuedBooks) {
        this.issuedBooks = issuedBooks;
    }

    public List<EBook> getEbooks() {
        return ebooks;
    }

    public void setEbooks(List<EBook> ebooks) {
        this.ebooks = ebooks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void updateStock(int command){
        if(command == Constants.INCREMENT_STOCK){
            setStock(this.stock+1);
        }
        if(command == Constants.DECREMENT_STOCK){
            setStock(this.stock-1);
        }
    }

    public void addAuthor(Author author){
        authors.add(author);
    }
}
