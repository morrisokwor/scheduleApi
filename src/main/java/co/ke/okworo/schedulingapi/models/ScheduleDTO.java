package co.ke.okworo.schedulingapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDTO {

    private Long id;

    private Long airplaneId;

    private Long routeId;

    @FutureOrPresent
    private LocalDateTime departureTime;

    @Future
    private LocalDateTime arrivalTime;
}
