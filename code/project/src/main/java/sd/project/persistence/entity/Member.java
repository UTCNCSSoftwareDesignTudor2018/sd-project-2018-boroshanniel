package sd.project.persistence.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "members")
public class Member {

    //id

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMember;

    //relationships

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    @OneToMany(mappedBy = "member")
    private List<IssuedBook> issuedBooks;

    //methods

    public Integer getIdMember() {
        return idMember;
    }

    public void setIdMember(Integer idMember) {
        this.idMember = idMember;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<IssuedBook> getIssuedBooks() {
        return issuedBooks;
    }

    public void setIssuedBooks(List<IssuedBook> issuedBooks) {
        this.issuedBooks = issuedBooks;
    }
}
