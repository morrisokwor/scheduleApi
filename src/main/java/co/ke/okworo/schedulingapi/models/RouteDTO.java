package co.ke.okworo.schedulingapi.models;

import co.ke.okworo.schedulingapi.db.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteDTO {

    private Long id;

    private Long fromDestination;

    private Long toDestination;

    private Long duration;

    private Status status;
}
