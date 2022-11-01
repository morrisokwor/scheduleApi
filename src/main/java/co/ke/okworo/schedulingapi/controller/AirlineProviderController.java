package co.ke.okworo.schedulingapi.controller;

import co.ke.okworo.schedulingapi.models.AirlineProviderDTO;
import co.ke.okworo.schedulingapi.services.AirlineProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airlineprovider")
@RequiredArgsConstructor
public class AirlineProviderController {

    private final AirlineProviderService airlineProviderService;

    @PostMapping
    public ResponseEntity<?> addAirlineProvider(@RequestBody AirlineProviderDTO airlineProviderDTO) {
        return ResponseEntity.ok(airlineProviderService.addAirlineProvider(airlineProviderDTO));

    }

    @PutMapping
    public ResponseEntity<?> updateAirlineProvider(@RequestBody AirlineProviderDTO airlineProviderDTO) {
        return ResponseEntity.ok(airlineProviderService.updateAirlineProvider(airlineProviderDTO));

    }

    @PostMapping("/suspend/{airlineId}")
    public ResponseEntity<?> suspendAirlineProvider(@PathVariable Long airlineId) {
        return ResponseEntity.ok(airlineProviderService.suspendAirlineProvider(airlineId));

    }

    @GetMapping("/all")
    public ResponseEntity<?> fetchAllAirlines() {
        return ResponseEntity.ok(airlineProviderService.fetchAllAirlines());
    }

}
