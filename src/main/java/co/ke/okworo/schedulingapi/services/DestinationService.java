package co.ke.okworo.schedulingapi.services;

import co.ke.okworo.schedulingapi.db.entities.Destination;
import co.ke.okworo.schedulingapi.db.entities.Status;
import co.ke.okworo.schedulingapi.db.repository.DestinationRepository;
import co.ke.okworo.schedulingapi.models.ApiResponse;
import co.ke.okworo.schedulingapi.models.DestinationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DestinationService {

    private final DestinationRepository destinationRepository;

    public ApiResponse addDestination(DestinationDTO destinationDTO) {
        var destination = new Destination();
        destination.setCode(destinationDTO.getCode());
        destination.setName(destinationDTO.getName());
        destination.setStatus(Status.ACTIVE);
        return new ApiResponse("Added Successfully", true, destinationRepository.save(destination));
    }

    public ApiResponse updateDestination(DestinationDTO destinationDTO) {
        var _destination = destinationRepository.findById(destinationDTO.getId());
        if (!_destination.isPresent()) {
            return new ApiResponse("Destination not found", false, null);
        }
        var destination = _destination.get();
        destination.setCode(destinationDTO.getCode());
        destination.setName(destinationDTO.getName());
        destination.setStatus(destinationDTO.getStatus());
        return new ApiResponse("Updated Successfully", true, destinationRepository.save(destination));
    }

    public ApiResponse suspendDestination(Long destinationId) {
        var destination = destinationRepository.findById(destinationId);
        if (destination.isPresent()) {
            destination.get().setStatus(Status.SUSPENDED);
            return new ApiResponse("Suspended Successfully", true, destinationRepository.save(destination.get()));
        } else {
            return new ApiResponse("Destination Not Found!", false, null);
        }


    }

    public ApiResponse fetchAllDestinations() {
        return new ApiResponse("Successfully Fetched", true, destinationRepository.findAll());
    }
}
