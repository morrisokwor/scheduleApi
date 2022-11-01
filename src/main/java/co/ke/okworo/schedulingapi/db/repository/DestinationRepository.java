package co.ke.okworo.schedulingapi.db.repository;

import co.ke.okworo.schedulingapi.db.entities.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
}
