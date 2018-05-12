package sd.project.persistence.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPublisher;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;



    @Column(columnDefinition = "VARCHAR(200)")
    private String name;

    @Column(columnDefinition = "VARCHAR(200)")
    private String address;

    @Column(columnDefinition = "CHAR(13)")
    private String phoneNumber;

}
