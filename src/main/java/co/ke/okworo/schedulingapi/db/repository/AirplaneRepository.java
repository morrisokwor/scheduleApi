package co.ke.okworo.schedulingapi.db.repository;

import co.ke.okworo.schedulingapi.db.entities.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
}
