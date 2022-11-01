package co.ke.okworo.schedulingapi.controller;

import co.ke.okworo.schedulingapi.models.RouteDTO;
import co.ke.okworo.schedulingapi.services.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/route")
@RequiredArgsConstructor
public class RouteController {

    private final RouteService routeService;

    @PostMapping
    public ResponseEntity<?> addRoute(@RequestBody RouteDTO RouteDTO) {
        return ResponseEntity.ok(routeService.addRoute(RouteDTO));

    }

    @PutMapping
    public ResponseEntity<?> updateRoute(@RequestBody RouteDTO RouteDTO) {
        return ResponseEntity.ok(routeService.updateRoute(RouteDTO));

    }

    @PostMapping("/suspend/{airlineId}")
    public ResponseEntity<?> suspendRoute(@PathVariable Long airlineId) {
        return ResponseEntity.ok(routeService.suspendRoute(airlineId));

    }

    @GetMapping("/all")
    public ResponseEntity<?> fetchAllAirlines() {
        return ResponseEntity.ok(routeService.fetchAllRoutes());
    }
}
