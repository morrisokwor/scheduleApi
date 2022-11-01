package co.ke.okworo.schedulingapi.db.repository;

import co.ke.okworo.schedulingapi.db.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
