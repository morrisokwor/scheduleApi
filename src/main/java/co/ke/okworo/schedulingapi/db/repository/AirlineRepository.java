package co.ke.okworo.schedulingapi.db.repository;

import co.ke.okworo.schedulingapi.db.entities.AirlineProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<AirlineProvider, Long> {
}
