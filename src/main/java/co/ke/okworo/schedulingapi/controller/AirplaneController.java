package co.ke.okworo.schedulingapi.controller;

import co.ke.okworo.schedulingapi.models.AirplaneDTO;
import co.ke.okworo.schedulingapi.services.AirplaneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airplane")
@RequiredArgsConstructor
public class AirplaneController {

    private final AirplaneService airplaneService;

    @PostMapping
    public ResponseEntity<?> addAirplane(@RequestBody AirplaneDTO AirplaneDTO) {
        return ResponseEntity.ok(airplaneService.addAirplane(AirplaneDTO));

    }

    @PutMapping
    public ResponseEntity<?> updateAirplane(@RequestBody AirplaneDTO AirplaneDTO) {
        return ResponseEntity.ok(airplaneService.updateAirplane(AirplaneDTO));

    }

    @PostMapping("/suspend/{airlineId}")
    public ResponseEntity<?> suspendAirplane(@PathVariable Long airlineId) {
        return ResponseEntity.ok(airplaneService.suspendAirplane(airlineId));

    }

    @GetMapping("/all")
    public ResponseEntity<?> fetchAllAirlines() {
        return ResponseEntity.ok(airplaneService.fetchAllAirplanes());
    }
}
