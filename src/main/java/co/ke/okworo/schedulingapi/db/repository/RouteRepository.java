package co.ke.okworo.schedulingapi.db.repository;

import co.ke.okworo.schedulingapi.db.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
}
