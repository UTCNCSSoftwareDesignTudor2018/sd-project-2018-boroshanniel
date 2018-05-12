package sd.project.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdmin;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;


}
