package sd.project.persistence.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "issuedbooks")
public class IssuedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIssuedBooks;

    @ManyToMany
    @JoinColumn(name = "idMember")
    private Member member;

    @ManyToMany
    @JoinColumn(name = "idBook")
    private Book book;

    @Column
    Date issueDate;

    @Column
    Date dueDate;


}
