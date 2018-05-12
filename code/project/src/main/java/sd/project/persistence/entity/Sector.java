package sd.project.persistence.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sectors")
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSector;

    @OneToMany(mappedBy = "sector")
    private List<Book> books;



    @Column(columnDefinition = "VARCHAR(200)")
    private String name;

    @Column(columnDefinition = "VARCHAR(500)")
    private String description;
}
