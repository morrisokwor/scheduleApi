package co.ke.okworo.schedulingapi.services;

import co.ke.okworo.schedulingapi.db.entities.Route;
import co.ke.okworo.schedulingapi.db.entities.Status;
import co.ke.okworo.schedulingapi.db.repository.DestinationRepository;
import co.ke.okworo.schedulingapi.db.repository.RouteRepository;
import co.ke.okworo.schedulingapi.models.ApiResponse;
import co.ke.okworo.schedulingapi.models.RouteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;

    private final DestinationRepository destinationRepository;

    public ApiResponse addRoute(RouteDTO routeDTO) {

        var fromDestination = destinationRepository.findById(routeDTO.getFromDestination());
        var toDestination = destinationRepository.findById(routeDTO.getToDestination());

        if (!fromDestination.isPresent()) {
            return new ApiResponse("From Location Not Found!", false, null);
        }
        if (!toDestination.isPresent()) {
            return new ApiResponse("To Destination Not Found", false, null);
        }
        var route = new Route();
        route.setDuration(route.getDuration());
        route.setStatus(Status.ACTIVE);
        route.setFromDestination(destinationRepository.findById(routeDTO.getFromDestination()).get());
        route.setToDestination(destinationRepository.findById(routeDTO.getToDestination()).get());

        return new ApiResponse("Added Successfully", true, routeRepository.save(route));
    }

    public ApiResponse updateRoute(RouteDTO routeDTO) {
        var _route = routeRepository.findById(routeDTO.getId());
        var fromDestination = destinationRepository.findById(routeDTO.getFromDestination());
        var toDestination = destinationRepository.findById(routeDTO.getToDestination());

        if (!_route.isPresent()) {
            return new ApiResponse("Route Not Found!", false, null);
        }

        if (!fromDestination.isPresent()) {
            return new ApiResponse("From Location Not Found!", false, null);
        }
        if (!toDestination.isPresent()) {
            return new ApiResponse("To Destination Not Found", false, null);
        }

        var route = _route.get();
        route.setDuration(route.getDuration());
        route.setStatus(routeDTO.getStatus());
        route.setFromDestination(destinationRepository.findById(routeDTO.getFromDestination()).get());
        route.setToDestination(destinationRepository.findById(routeDTO.getToDestination()).get());

        return new ApiResponse("Updated Successfully", true, routeRepository.save(route));
    }

    public ApiResponse suspendRoute(Long routeId) {
        var route = routeRepository.findById(routeId);
        if (route.isPresent()) {
            route.get().setStatus(Status.SUSPENDED);
            return new ApiResponse("Suspended Successfully", true, routeRepository.save(route.get()));
        } else {
            return new ApiResponse("Route Not Found!", false, null);
        }
    }


    public ApiResponse fetchAllRoutes() {
        return new ApiResponse("Successfully Fetched", false, routeRepository.findAll());
    }
}
