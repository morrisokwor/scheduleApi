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
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airplane_gen")
    @SequenceGenerator(name = "airplane_gen", sequenceName = "airplane_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "airline_id")
    private AirlineProvider airline;

    private String regNo;

    private int capacity;

    @Enumerated(EnumType.STRING)
    private Status status;
}
