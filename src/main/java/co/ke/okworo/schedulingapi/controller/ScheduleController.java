package co.ke.okworo.schedulingapi.controller;

import co.ke.okworo.schedulingapi.models.ScheduleDTO;
import co.ke.okworo.schedulingapi.services.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<?> addSchedule(@RequestBody ScheduleDTO ScheduleDTO) {
        return ResponseEntity.ok(scheduleService.addSchedule(ScheduleDTO));

    }

    @PutMapping
    public ResponseEntity<?> updateSchedule(@RequestBody ScheduleDTO ScheduleDTO) {
        return ResponseEntity.ok(scheduleService.updateSchedule(ScheduleDTO));

    }


    @GetMapping("/all")
    public ResponseEntity<?> fetchAllAirlines() {
        return ResponseEntity.ok(scheduleService.fetchAllSchedules());
    }
}
