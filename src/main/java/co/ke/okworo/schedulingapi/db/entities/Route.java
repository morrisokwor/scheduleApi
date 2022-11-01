package co.ke.okworo.schedulingapi.db.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "route_gen")
    @SequenceGenerator(name = "route_gen", sequenceName = "route_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_id")
    private Destination fromDestination;

    @ManyToOne
    @JoinColumn(name = "to_id")
    private Destination toDestination;

    private Long duration;

    @Enumerated(EnumType.STRING)
    private Status status;

}
