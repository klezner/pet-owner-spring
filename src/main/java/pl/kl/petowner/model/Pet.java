package pl.kl.petowner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;

    @Formula("(SELECT CONCAT(o.first_name, ' ', o.last_name) FROM owner o WHERE owner_id = o.id)")
    private String ownerName;

    private Double weight;
    private boolean pureRace;

    @Enumerated(EnumType.STRING)
    private Race race;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Owner owner;
}
