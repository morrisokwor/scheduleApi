package co.ke.okworo.schedulingapi.db.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AirlineProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airline_provider_gen")
    @SequenceGenerator(name = "airline_provider_gen", sequenceName = "airline_provider_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

}
