package sd.project.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    @OneToOne(fetch = FetchType.LAZY,
                cascade = CascadeType.ALL,
                mappedBy = "user")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "user")
    private Admin admin;

    @Column(columnDefinition = "VARCHAR(200)")
    private String name;

    @Column(columnDefinition = "CHAR(13)")
    private String cnp;

    @Column(columnDefinition = "VARCHAR(200)")
    private String email;

    @Column(columnDefinition = "VARCHAR(13)")
    private String phoneNumber;


}
