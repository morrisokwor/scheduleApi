package co.ke.okworo.schedulingapi.services;

import co.ke.okworo.schedulingapi.db.entities.AirlineProvider;
import co.ke.okworo.schedulingapi.db.entities.Status;
import co.ke.okworo.schedulingapi.db.repository.AirlineRepository;
import co.ke.okworo.schedulingapi.models.AirlineProviderDTO;
import co.ke.okworo.schedulingapi.models.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirlineProviderService {

    private final AirlineRepository airlineRepository;


    public ApiResponse addAirlineProvider(AirlineProviderDTO airlineProviderDTO) {

        var airline = new AirlineProvider();
        airline.setStatus(Status.ACTIVE);
        airline.setName(airlineProviderDTO.getName());

        return new ApiResponse("Added Successfully", true, airlineRepository.save(airline));

    }

    public ApiResponse updateAirlineProvider(AirlineProviderDTO airlineProviderDTO) {

        var _airline = airlineRepository.findById(airlineProviderDTO.getId());
        if (_airline.isPresent()) {
            var airline = _airline.get();
            airline.setName(airline.getName());
            airline.setStatus(airlineProviderDTO.getStatus());

            return new ApiResponse("Updated Successfully", true, airlineRepository.save(airline));

        } else {
            return new ApiResponse("Airline Provider Not Found!", false, null);
        }
    }

    public ApiResponse suspendAirlineProvider(Long airlineProviderId) {
        var _airlineProvider = airlineRepository.findById(airlineProviderId);
        if (_airlineProvider.isPresent()) {
            var airlineProvider = _airlineProvider.get();
            airlineProvider.setStatus(Status.SUSPENDED);

            return new ApiResponse(airlineProvider.getName() + " Successfully Suspended", true, airlineRepository.save(airlineProvider));

        } else {
            return new ApiResponse("Airline Provider Not Found!", false, null);
        }


    }

    public ApiResponse fetchAllAirlines() {

        return new ApiResponse("Successfully Fetched", true, airlineRepository.findAll());
    }
}
