package co.ke.okworo.schedulingapi.models;

import co.ke.okworo.schedulingapi.db.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirplaneDTO {

    private Long id;


    private Long airlineId;

    private String regNo;

    private int capacity;

    private Status status;
}
