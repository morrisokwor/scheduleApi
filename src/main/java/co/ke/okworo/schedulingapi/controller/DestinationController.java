package co.ke.okworo.schedulingapi.controller;

import co.ke.okworo.schedulingapi.models.DestinationDTO;
import co.ke.okworo.schedulingapi.services.DestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/destination")
@RequiredArgsConstructor
public class DestinationController {

    private final DestinationService destinationService;

    @PostMapping
    public ResponseEntity<?> addDestination(@RequestBody DestinationDTO DestinationDTO) {
        return ResponseEntity.ok(destinationService.addDestination(DestinationDTO));

    }

    @PutMapping
    public ResponseEntity<?> updateDestination(@RequestBody DestinationDTO DestinationDTO) {
        return ResponseEntity.ok(destinationService.updateDestination(DestinationDTO));

    }

    @PostMapping("/suspend/{airlineId}")
    public ResponseEntity<?> suspendDestination(@PathVariable Long airlineId) {
        return ResponseEntity.ok(destinationService.suspendDestination(airlineId));

    }

    @GetMapping("/all")
    public ResponseEntity<?> fetchAllAirlines() {
        return ResponseEntity.ok(destinationService.fetchAllDestinations());
    }
}
