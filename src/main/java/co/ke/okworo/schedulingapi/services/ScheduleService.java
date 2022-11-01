package co.ke.okworo.schedulingapi.services;

import co.ke.okworo.schedulingapi.db.entities.Schedule;
import co.ke.okworo.schedulingapi.db.repository.AirplaneRepository;
import co.ke.okworo.schedulingapi.db.repository.RouteRepository;
import co.ke.okworo.schedulingapi.db.repository.ScheduleRepository;
import co.ke.okworo.schedulingapi.models.ApiResponse;
import co.ke.okworo.schedulingapi.models.ScheduleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final AirplaneRepository airplaneRepository;
    private final RouteRepository routeRepository;

    public ApiResponse addSchedule(ScheduleDTO scheduleDTO) {
        var _route = routeRepository.findById(scheduleDTO.getRouteId());
        var _airplane = airplaneRepository.findById(scheduleDTO.getAirplaneId());

        if (!_route.isPresent()) {
            return new ApiResponse("Route Not Found!", false, null);
        }

        if (_airplane.isPresent()) {
            return new ApiResponse("Airplane Not Found", false, null);
        }

        var schedule = new Schedule();
        schedule.setAirplane(_airplane.get());
        schedule.setRoute(_route.get());
        schedule.setArrivalTime(scheduleDTO.getArrivalTime());
        schedule.setDepartureTime(scheduleDTO.getDepartureTime());

        return new ApiResponse("Added Successfully", true, scheduleRepository.save(schedule));

    }

    public ApiResponse updateSchedule(ScheduleDTO scheduleDTO) {
        var _schedule = scheduleRepository.findById(scheduleDTO.getId());
        var _route = routeRepository.findById(scheduleDTO.getRouteId());
        var _airplane = airplaneRepository.findById(scheduleDTO.getAirplaneId());

        if (!_schedule.isPresent()) {
            return new ApiResponse("Schedule Not Found!", false, null);
        }

        if (!_route.isPresent()) {
            return new ApiResponse("Route Not Found!", false, null);
        }

        if (_airplane.isPresent()) {
            return new ApiResponse("Airplane Not Found", false, null);
        }

        var schedule = _schedule.get();
        schedule.setAirplane(_airplane.get());
        schedule.setRoute(_route.get());
        schedule.setArrivalTime(scheduleDTO.getArrivalTime());
        schedule.setDepartureTime(scheduleDTO.getDepartureTime());

        return new ApiResponse("Updated Successfully", true, scheduleRepository.save(schedule));

    }

    public ApiResponse fetchAllSchedules() {
        return new ApiResponse("Fetched Successfully", true, scheduleRepository.findAll());
    }
}
