package sd.project.persistence.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "issuedbooks")
public class IssuedBook {

    //id

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIssuedBooks;

    //relationships

    @ManyToOne
    @JoinColumn(name = "idMember")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "idBook")
    private Book book;

    //other DB columns

    @Column
    Date issueDate;

    @Column
    Date dueDate;

    //methods

    public Integer getIdIssuedBooks() {
        return idIssuedBooks;
    }

    public void setIdIssuedBooks(Integer idIssuedBooks) {
        this.idIssuedBooks = idIssuedBooks;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
