package co.ke.okworo.schedulingapi.services;

import co.ke.okworo.schedulingapi.db.entities.Airplane;
import co.ke.okworo.schedulingapi.db.entities.Status;
import co.ke.okworo.schedulingapi.db.repository.AirlineRepository;
import co.ke.okworo.schedulingapi.db.repository.AirplaneRepository;
import co.ke.okworo.schedulingapi.models.AirplaneDTO;
import co.ke.okworo.schedulingapi.models.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirplaneService {

    private final AirplaneRepository airplaneRepository;
    private final AirlineRepository airlineRepository;


    public ApiResponse addAirplane(AirplaneDTO airplaneDTO) {
        var airlineProvider = airlineRepository.findById(airplaneDTO.getAirlineId());
        if (!airlineProvider.isPresent()) {
            return new ApiResponse("Airline Provider Not Found", false, null);
        }
        var airplane = new Airplane();

        airplane.setAirline(airlineProvider.get());
        airplane.setCapacity(airplaneDTO.getCapacity());
        airplane.setStatus(Status.ACTIVE);
        airplane.setRegNo(airplaneDTO.getRegNo());
        return new ApiResponse("Added Successfully", true, airplaneRepository.save(airplane));

    }

    public ApiResponse updateAirplane(AirplaneDTO airplaneDTO) {
        var _airplane = airplaneRepository.findById(airplaneDTO.getId());
        var airlineProvider = airlineRepository.findById(airplaneDTO.getAirlineId());
        if (!_airplane.isPresent()) {
            return new ApiResponse("Airplane Not Found", false, null);
        }
        if (!airlineProvider.isPresent()) {
            return new ApiResponse("Airline Provider Not Found", false, null);
        }
        var airplane = _airplane.get();
        airplane.setCapacity(airplaneDTO.getCapacity());
        airplane.setStatus(airplaneDTO.getStatus());
        airplane.setRegNo(airplaneDTO.getRegNo());
        airplane.setAirline(airlineProvider.get());
        return new ApiResponse("Updated Successfully", true, airplaneRepository.save(airplane));

    }

    public ApiResponse suspendAirplane(Long airplaneId) {
        var _airplane = airplaneRepository.findById(airplaneId);
        if (_airplane.isPresent()) {

            _airplane.get().setStatus(Status.SUSPENDED);
            return new ApiResponse("Airplane Suspended Successfully", true, airplaneRepository.save(_airplane.get()));
        } else {
            return new ApiResponse("Aiplane Not Found", false, null);
        }
    }

    public ApiResponse fetchAllAirplanes() {
        return new ApiResponse("Successfully Fetched", true, airplaneRepository.findAll());
    }
}
